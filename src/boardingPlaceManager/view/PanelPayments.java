/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.view;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import boardingPlaceManager.common.IDGenarator;
import boardingPlaceManager.controller.RentController;
import boardingPlaceManager.controller.PropertyController;
import boardingPlaceManager.controller.PaymentController;
import boardingPlaceManager.dto.PaymentDTO;
import boardingPlaceManager.dto.PaymentDTO;
import boardingPlaceManager.dto.PropertyDTO;
import boardingPlaceManager.dto.PaymentDTO;
import boardingPlaceManager.dto.RentDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
//import java.time.DateTimeFormatter;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;
//import static boardingPlaceManager.view.PanelPayment.dark;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author User
 */
public class PanelPayments extends JPanel {

    /**
     * Creates new form panelPayment
     */
    private Color darkGreen = new Color(102, 102, 102);
    private int selectedID;
    private String rentNo;
    private boolean fieldsUpdated = false;
    private int type = 0;
    private RentDTO rent = null;
    private PaymentDTO payment = new PaymentDTO();
    private Date fromDate = null;
    private Date toDate = null;
    private TableColumn myTableColumn2;
    private TableColumn myTableColumn3;

    public PanelPayments(RentDTO rentDTO) throws SQLException {

        initComponents();
        tblPayment.removeColumn(tblPayment.getColumnModel().getColumn(6));
        tblPayment.removeColumn(tblPayment.getColumnModel().getColumn(5));

        rent = rentDTO;
        try {
            rent = RentController.searchRent(rent);
        } catch (Exception ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
        rentNo = rent.getRent_id();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        try {
//            loadAllPayments();
//        } catch (Exception ex) {
//            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//        }
        datePickerDueDate.setDate(null);
        datePickerPaymentDate.setDate(null);
        fieldsUpdated = false;
        datePickerDueDate.setFormats("yyyy-MM-dd");
        datePickerPaymentDate.setFormats("yyyy-MM-dd");
        hidePaymentDetails();

        //auto generate id
        try {

        } catch (Exception ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnRefreshActionPerformed(null);

        tblPayment.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                fieldsUpdated = false;

                try {
                    if (tblPayment.getSelectedRow() == -1) {
                        return;
                    }

                    selectedID = Integer.parseInt(tblPayment.getModel().getValueAt(tblPayment.getSelectedRow(), 5).toString());
                    //rentNo = tblPayment.getModel().getValueAt(tblPayment.getSelectedRow(), 5).toString();
                    //System.out.println(selectedID + "IDID");
                    // cmbPaymentNames.setSelectedItem(tblPayment.getValueAt(tblPayment.getSelectedRow(), 0).toString());
                    txtDescription.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 2).toString());
                    txtDueAmount.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 3).toString());
                    txtPaidAmount.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 4).toString());
                    if (tblPayment.getValueAt(tblPayment.getSelectedRow(), 0) != null) {
                        datePickerDueDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblPayment.getValueAt(tblPayment.getSelectedRow(), 0).toString()));
                    } else {
                        // System.out.println("Null");
                        datePickerDueDate.setDate(null);
                    }

                    if (tblPayment.getValueAt(tblPayment.getSelectedRow(), 1) != null) {
                        datePickerPaymentDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblPayment.getValueAt(tblPayment.getSelectedRow(), 1).toString()));
//                        btnClickToPay.setVisible(false);
//                        hidePaymentDetails();
                    } else {
                        //System.out.println("Null");
                        datePickerPaymentDate.setDate(null);
//                        btnClickToPay.setVisible(true);
                    }
                    if (Double.parseDouble(txtDueAmount.getText()) != 0.0 && (Double.parseDouble(txtDueAmount.getText()) != Double.parseDouble(txtPaidAmount.getText()))) {
                        btnClickToPay.setVisible(true);
                        hidePaymentDetails();
                    } else {
                        btnClickToPay.setVisible(false);
                        hidePaymentDetails();
                    }
                    payment = new PaymentDTO(selectedID, "", null, null, "", 0.0, 0.0);
                    try {
                        payment = PaymentController.searchPayment(payment);
                    } catch (Exception ex) {
                        Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    private void clearAllTexts() {

        //txtBoardereName.setText("");
        //cmbPaymentNames.setSelectedIndex(-1);
        datePickerDueDate.setDate(null);
        datePickerPaymentDate.setDate(null);
        txtDescription.setText("");
        txtDueAmount.setText("");
        txtPaidAmount.setText("");
    }

    private void hidePaymentDetails() {
        btnPay.setVisible(false);
        lblAmount.setVisible(false);
        txtPayingAmount.setVisible(false);
        //btnClickToPay.setVisible(false);
    }

    private void showPaymentDetails() {
        btnPay.setVisible(true);
        lblAmount.setVisible(true);
        txtPayingAmount.setVisible(true);
        //btnClickToPay.setVisible(true);
    }

    public String getID() {
        String newID;

        try {
            newID = IDGenarator.getNewID("property", "property_id", "p");
            return newID;
        } catch (SQLException ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //to check text field inputs are empty
    public boolean checkText() {
        //System.out.println("Chk");
        if (datePickerDueDate.getDate() == null || datePickerPaymentDate.getDate() == null || txtDueAmount.getText().isEmpty() || txtDescription.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnUpdate = new org.jdesktop.swingx.JXButton();
        btnRemove = new org.jdesktop.swingx.JXButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnPay = new org.jdesktop.swingx.JXButton();
        jLabel9 = new javax.swing.JLabel();
        txtDescription = new org.jdesktop.swingx.JXTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDueAmount = new org.jdesktop.swingx.JXTextField();
        datePickerPaymentDate = new org.jdesktop.swingx.JXDatePicker();
        datePickerDueDate = new org.jdesktop.swingx.JXDatePicker();
        lblAmount = new javax.swing.JLabel();
        txtPayingAmount = new org.jdesktop.swingx.JXTextField();
        btnClickToPay = new org.jdesktop.swingx.JXButton();
        jLabel13 = new javax.swing.JLabel();
        txtPaidAmount = new org.jdesktop.swingx.JXTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPayment = new org.jdesktop.swingx.JXTable();
        btnRefresh = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rent Houses");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnUpdate.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Available Updates_20px.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setToolTipText("Click to update");
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(102, 102, 102));
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Delete_20px.png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setToolTipText("Click to  remove");
        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRemove.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveMouseExited(evt);
            }
        });
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Payment Details");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 37));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Due Date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 37));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Cancel 2_20px.png"))); // NOI18N
        btnCancel.setToolTipText("Click to clear fields");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 619, 48, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Payment Date");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 37));

        btnPay.setBackground(new java.awt.Color(153, 153, 153));
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Money_20px.png"))); // NOI18N
        btnPay.setText("Confirm Payment");
        btnPay.setToolTipText("Click to add");
        btnPay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPayMouseExited(evt);
            }
        });
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 170, 32));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Description");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 137, 37));

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescription.setPrompt("Description");
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
        });
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 170, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Due Amount");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 137, 37));

        txtDueAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDueAmount.setPrompt("Due Amount");
        txtDueAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDueAmountActionPerformed(evt);
            }
        });
        txtDueAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDueAmountKeyPressed(evt);
            }
        });
        jPanel1.add(txtDueAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 170, 30));

        datePickerPaymentDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                datePickerPaymentDateMousePressed(evt);
            }
        });
        datePickerPaymentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerPaymentDateActionPerformed(evt);
            }
        });
        jPanel1.add(datePickerPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 170, -1));

        datePickerDueDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                datePickerDueDateMousePressed(evt);
            }
        });
        datePickerDueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerDueDateActionPerformed(evt);
            }
        });
        jPanel1.add(datePickerDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 170, -1));

        lblAmount.setBackground(new java.awt.Color(255, 255, 255));
        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(0, 153, 153));
        lblAmount.setText("Amount");
        jPanel1.add(lblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 137, 37));

        txtPayingAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPayingAmount.setPrompt("Paying Amount");
        txtPayingAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayingAmountActionPerformed(evt);
            }
        });
        txtPayingAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPayingAmountKeyPressed(evt);
            }
        });
        jPanel1.add(txtPayingAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 170, 30));

        btnClickToPay.setBackground(new java.awt.Color(153, 153, 153));
        btnClickToPay.setForeground(new java.awt.Color(255, 255, 255));
        btnClickToPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Money_20px.png"))); // NOI18N
        btnClickToPay.setText("Click to add Payment");
        btnClickToPay.setToolTipText("Click to add");
        btnClickToPay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClickToPay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClickToPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClickToPayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClickToPayMouseExited(evt);
            }
        });
        btnClickToPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClickToPayActionPerformed(evt);
            }
        });
        jPanel1.add(btnClickToPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 170, 32));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Paid Amount");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 137, 37));

        txtPaidAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPaidAmount.setPrompt("Paid Amount");
        txtPaidAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaidAmountActionPerformed(evt);
            }
        });
        txtPaidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaidAmountKeyPressed(evt);
            }
        });
        jPanel1.add(txtPaidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 170, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("View Payment Details");

        tblPayment.setForeground(new java.awt.Color(51, 51, 51));
        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Due Date", "Payment Date", "Description", "Due Amount", "Paid Amount", "Payment ID", "Rent No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPayment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane3.setViewportView(tblPayment);

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Spinner Frame 3_20px.png"))); // NOI18N
        btnRefresh.setToolTipText("Click to refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        cmbType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Completed", "Not Completed", "Future" }));
        cmbType.setToolTipText("Click to select Item");
        cmbType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTypeItemStateChanged(evt);
            }
        });
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this, "Confirm deletion? Can't get Payment Details Back",
                "An Inane Question",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.NO_OPTION) {
            return;
        }

        try {

            try {
                boolean result = PaymentController.deletePayment(payment);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Payment has been successfully removed");
                    btnRefreshActionPerformed(evt);
                    clearAllTexts();
                } else {
                    JOptionPane.showMessageDialog(this, "Payment hasn't been removed");
                }

            } catch (Exception ex) {
                Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnRemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseExited
        btnRemove.setBackground(darkGreen);
    }//GEN-LAST:event_btnRemoveMouseExited

    private void btnRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseEntered
        btnRemove.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnRemoveMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (fieldsUpdated == false) {
                JOptionPane.showMessageDialog(this, "No change found");
                return;
            }
            if (Double.parseDouble(txtDueAmount.getText()) < Double.parseDouble(txtPaidAmount.getText())) {
                JOptionPane.showMessageDialog(this, "Invalid Payment Amount");
                return;
            }

            if (Double.parseDouble(txtPaidAmount.getText()) == 0.0 && datePickerPaymentDate.getDate() != null) {
                JOptionPane.showMessageDialog(this, "Invalid Payment Amount");
                return;
            }

            PaymentDTO newPayment = PaymentController.searchPayment(payment);
            newPayment.setDescription(txtDescription.getText());
            newPayment.setDueAmount(Double.parseDouble(txtDueAmount.getText()));
            newPayment.setPaidAmount(Double.parseDouble(txtPaidAmount.getText()));
            newPayment.setDue_date(datePickerDueDate.getDate());
            if (newPayment.getPaidAmount() != 0.0) {
                newPayment.setPayment_date(datePickerDueDate.getDate());
            } else {
                newPayment.setPayment_date(null);
            }

            if (!payment.getDescription().contains("Partial") && Double.parseDouble(txtDueAmount.getText()) > Double.parseDouble(txtPaidAmount.getText()) && Double.parseDouble(txtPaidAmount.getText()) == 0.0) {
                int n = JOptionPane.showConfirmDialog(
                        this, "Want to add Partial Payments?",
                        "An Inane Question",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    newPayment.setDescription(newPayment.getDescription() + "(Partial)");
                    PaymentDTO partialPayment = new PaymentDTO(0, rentNo, payment.getDue_date(), null, newPayment.getDescription(), newPayment.getDueAmount() - newPayment.getPaidAmount(), ABORT);
                    PaymentController.addPayment(partialPayment);
                    //return;
                }
            }
            Double balance = 0.0;
            Boolean extraPayment = false;
            if (Double.parseDouble(txtDueAmount.getText()) != payment.getDueAmount()) {
                balance = Double.parseDouble(txtDueAmount.getText())-payment.getDueAmount();
                extraPayment = true;
            }
            if (Double.parseDouble(txtPaidAmount.getText()) != payment.getPaidAmount()) {
                balance += Double.parseDouble(txtPaidAmount.getText())-payment.getPaidAmount();
                extraPayment = true;
            }
            if (extraPayment == true) {
                int n = JOptionPane.showConfirmDialog(
                        this, "Want to Balance the Changed Amounts?",
                        "An Inane Question",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //newPayment.setDescription(newPayment.getDescription() + "(Partial)");

                    int m = JOptionPane.showConfirmDialog(
                            this, "Want to add the balance to a upcoming payment?",
                            "An Inane Question",
                            JOptionPane.YES_NO_OPTION);
                    if (m == JOptionPane.NO_OPTION) {
                        //newPayment.setDescription(newPayment.getDescription() + "(Partial)");
                        PaymentDTO partialPayment = new PaymentDTO(0, rentNo, payment.getDue_date(), null, datePickerDueDate.getDate().toString() + "-Payments Balancing", balance, 0.0);
                        PaymentController.addPayment(partialPayment);
                        //return;
                    }
                    if (m == JOptionPane.YES_OPTION) {
                        //newPayment.setDescription(newPayment.getDescription() + "(Partial)");
                        Double paymentAmount = 0.0;
                        while (balance < 0.0) {
                            PaymentDTO partialPayment = PaymentController.getNearestPayment(rentNo, payment.getDue_date(), payment.getPayment_id());
                            if (partialPayment != null) {
                                if (partialPayment.getDueAmount() > (-1 * balance)) {
                                    paymentAmount = partialPayment.getDueAmount() + balance;
                                    balance = 0.0;
                                } else {
                                    //paymentAmount = (-1 * balance) - partialPayment.getDueAmount();
                                    balance = partialPayment.getDueAmount() + balance;
                                    paymentAmount = balance;
                                }
                                if (!partialPayment.getDescription().equalsIgnoreCase("balance")) {
                                    partialPayment.setDescription(partialPayment.getDescription() + "+Payment Balancing");
                                }
                                partialPayment.setDueAmount(paymentAmount);

                                if (partialPayment.getDueAmount() == 0) {
                                    PaymentController.deletePayment(partialPayment);
                                    //return;
                                } else {
                                    PaymentController.updatePayment(partialPayment);
                                }
                                //partialPayment.set
                                //System.out.println(partialPayment + "Partial Payment GOT");
                                //PaymentDTO changedPayment = new PaymentDTO(0, rentNo, payment.getDue_date(), null, datePickerDueDate.getDate().toString() + "-Payments Balancing", balance, 0.0);

                            } else { // no suitable paments to balance
                                PaymentDTO newPaymentBalance = new PaymentDTO(0, rentNo, payment.getDue_date(), null, datePickerDueDate.getDate().toString() + "-Payments Balancing", balance, 0.0);
                                PaymentController.addPayment(newPaymentBalance);
                                balance = 0.0;
                            }
                            //System.out.println("Balance in LOop" + balance);
                        }
                        if (balance > 0.0) {
                            PaymentDTO partialPayment = PaymentController.getNearestPayment(rentNo, payment.getDue_date(), payment.getPayment_id());
                            System.out.println("+ paymenttttt" + partialPayment);
                            if (partialPayment != null) {
                                if (!partialPayment.getDescription().equalsIgnoreCase("balance")) {
                                    partialPayment.setDescription(partialPayment.getDescription() + "+Payment Balancing");
                                }
                                partialPayment.setDueAmount(partialPayment.getDueAmount() + balance);
                                PaymentController.updatePayment(partialPayment);
                            } else {
                                PaymentDTO newPaymentBalance = new PaymentDTO(0, rentNo, payment.getDue_date(), null, datePickerDueDate.getDate().toString() + "-Payments Balancing", balance, 0.0);
                                PaymentController.addPayment(newPaymentBalance);

                            }
                        }
//                       PaymentController.addPayment(partialPayment);
//                        //return;

                    }
                    //PaymentDTO partialPayment = new PaymentDTO("", rentNo, payment.getDue_date(), null, datePickerDueDate.getDate().toString() + "-Payments Balancing", balance, 0.0);
                    // PaymentController.addPayment(partialPayment);
                    //return;
                }
            }

            Boolean flag = PaymentController.updatePayment(newPayment);
            if (flag == true) {

                JOptionPane.showMessageDialog(this, "Payment Updated");

            } else {
                JOptionPane.showMessageDialog(this, "Error Updating Payment");
            }

        } catch (Exception ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(darkGreen);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void cmbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTypeItemStateChanged

        if (cmbType.getSelectedIndex() == -1) {
            type = 0;
        } else if (cmbType.getSelectedIndex() == 0) {
            type = 0;
        } else if (cmbType.getSelectedIndex() == 1) {
            type = 1;
        } else if (cmbType.getSelectedIndex() == 2) {
            type = 2;
        } else if (cmbType.getSelectedIndex() == 3) {
            type = 3;
        }
        btnRefreshActionPerformed(null);
//        try {
//            if (cmbType.getSelectedIndex() == -1) {
//                tblPayment.getColumnModel().addColumn(myTableColumn2);
//                tblPayment.getColumnModel().addColumn(myTableColumn3);
//            } else if (cmbType.getSelectedIndex() == 0) {
//                tblPayment.getColumnModel().addColumn(myTableColumn2);
//                tblPayment.getColumnModel().addColumn(myTableColumn3);
//            } else if (cmbType.getSelectedIndex() == 1) {
//                tblPayment.getColumnModel().addColumn(myTableColumn2);
//                tblPayment.getColumnModel().addColumn(myTableColumn3);
//            } else if (cmbType.getSelectedIndex() == 2) {
//                tblPayment.getColumnModel().removeColumn(myTableColumn2);
//                tblPayment.getColumnModel().removeColumn(myTableColumn3);
//            } else if (cmbType.getSelectedIndex() == 3) {
//                tblPayment.getColumnModel().removeColumn(myTableColumn2);
//                tblPayment.getColumnModel().removeColumn(myTableColumn3);
//            }
//            btnRefreshActionPerformed(null);
//
//        } catch (Exception ex) {
//            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_cmbTypeItemStateChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
//            ArrayList<PaymentDTO> allPayments = PaymentController.getAllPayments();
//            if (type == 1 || type == 2 || type == 3) {
            ArrayList<PaymentDTO> allPayments = PaymentController.searchPayment(rentNo, type);

            if (allPayments != null) {
                DefaultTableModel dtm = (DefaultTableModel) tblPayment.getModel();

                dtm.setRowCount(0);

                for (PaymentDTO payment : allPayments) {
                  //  System.out.println("In Payment Loop");
                    //PropertyDTO property = new PropertyDTO(payment.getProperty_id(), null, null, null);
                    //  property = PropertyController.searchProperty(property);
                    // PaymentDTO boadereDTO = new PaymentDTO(payment.getPayment_id(), "", "", "");
                    // System.out.println("..." + payment.getPayment_id());
                    // PaymentDTO boadere = PaymentController.searchPayment(boadereDTO);
                    Object[] rowData = {
                        // boadere.getName(),
                        payment.getDue_date(),
                        payment.getPayment_date(),
                        payment.getDescription(),
                        payment.getDueAmount(),
                        payment.getPaidAmount(),
                        payment.getPayment_id(),
                        payment.getRent_no()
                    };

                    dtm.addRow(rowData);

                }

            } else {
                DefaultTableModel dtm = (DefaultTableModel) tblPayment.getModel();
                dtm.setRowCount(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }

        myTableColumn2 = tblPayment.getColumnModel().getColumn(2);
        myTableColumn3 = tblPayment.getColumnModel().getColumn(3);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        //  getCID.requestFocus();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void datePickerDueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerDueDateActionPerformed
        fieldsUpdated = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDateS = simpleDateFormat.format(datePickerDueDate.getDate());
        try {
            //System.out.println("sormatted"+fromDate);
            fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateS);
            //        System.out.println("Date" + datePickerFromDate.getDate());
        } catch (ParseException ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_datePickerDueDateActionPerformed

    private void datePickerDueDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datePickerDueDateMousePressed

    }//GEN-LAST:event_datePickerDueDateMousePressed

    private void datePickerPaymentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerPaymentDateActionPerformed
        fieldsUpdated = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDateS = simpleDateFormat.format(datePickerDueDate.getDate());
        try {
            //System.out.println("sormatted"+fromDate);
            toDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateS);
            //        System.out.println("Date" + datePickerFromDate.getDate());
        } catch (ParseException ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_datePickerPaymentDateActionPerformed

    private void datePickerPaymentDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datePickerPaymentDateMousePressed
        fieldsUpdated = true;
    }//GEN-LAST:event_datePickerPaymentDateMousePressed

    private void txtDueAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDueAmountKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtDueAmountKeyPressed

    private void txtDueAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDueAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDueAmountActionPerformed

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtDescriptionKeyPressed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        long millis = System.currentTimeMillis();
        java.sql.Date curDate = new java.sql.Date(millis);
        //System.out.println(txtDescription.getText());
        Boolean flag = false;
        String descriptionTemp = "";
        String descriptionTemp1 = "";
        //if (txtDescription.getText().equalsIgnoreCase("Monthly Payment") || txtDescription.getText().equalsIgnoreCase("Monthly Payment(Partial)")) {
        try {
           // System.out.println("Rent MP" + rent);

            if (Double.parseDouble(txtPayingAmount.getText()) < payment.getDueAmount()) {
                Double balance = payment.getDueAmount() - Double.parseDouble(txtPayingAmount.getText());
                descriptionTemp = payment.getDescription();
                descriptionTemp1 = descriptionTemp;
                if (!descriptionTemp.contains("Partial")) {
                    descriptionTemp1 = descriptionTemp + "(Partial)";
                }
                PaymentDTO newPayment = new PaymentDTO(0, rentNo, datePickerDueDate.getDate(), null, descriptionTemp1, balance, 0.0);
                try {
                    PaymentController.addPayment(newPayment);
                    PaymentDTO partialPayment = new PaymentDTO(selectedID, "", null, null, "", 0.0, 0.0);
                    partialPayment = PaymentController.searchPayment(partialPayment);
                    if (partialPayment != null) {
                        // System.out.println("ppartial not null");
                        partialPayment.setDescription(descriptionTemp + "(Partial)");
                        partialPayment.setPaidAmount(Double.parseDouble(txtPayingAmount.getText()));
                        partialPayment.setPayment_date(curDate);
                        flag = PaymentController.updatePayment(partialPayment);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String description = descriptionTemp;
                if (txtDescription.getText().equalsIgnoreCase(descriptionTemp + "(Partial)")) {
                    description = descriptionTemp + "(Partial)";
                }
                PaymentDTO payment = new PaymentDTO(selectedID, "", null, null, "", 0.0, 0.0);
                payment = PaymentController.searchPayment(payment);
                payment.setPaidAmount(Double.parseDouble(txtPayingAmount.getText()));
                payment.setPayment_date(curDate);
                payment.setDescription(description);
                flag = PaymentController.updatePayment(payment);
            }
            if (flag == true) {
                JOptionPane.showMessageDialog(this, "Payment Successfull");
                btnRefreshActionPerformed(evt);
            }

//            PaymentDTO newPayment = new PaymentDTO(selectedID, "", null, null, "", 0.0, 0.0);
//            try {
//                newPayment = PaymentController.searchPayment(payment);
//                if (newPayment != null) {
//                    //newPayment.setDescription("Monthly Payment(Partial)");
//                    newPayment.setPayment_date(curDate);
//                    newPayment.setDueAmount(Double.parseDouble(txtPayingAmount.getText()));
//                    Boolean flag = PaymentController.addPayment(newPayment);
//                    if (flag == true) {
//                        JOptionPane.showMessageDialog(this, "Payment Successfull");
//                        btnRefreshActionPerformed(evt);
//                    }
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } catch (Exception ex) {
            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPayActionPerformed

    private void btnPayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPayMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPayMouseExited

    private void btnPayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPayMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPayMouseEntered

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearAllTexts();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtPayingAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayingAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayingAmountActionPerformed

    private void txtPayingAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPayingAmountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayingAmountKeyPressed

    private void btnClickToPayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClickToPayMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClickToPayMouseEntered

    private void btnClickToPayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClickToPayMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClickToPayMouseExited

    private void btnClickToPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClickToPayActionPerformed
        showPaymentDetails();
    }//GEN-LAST:event_btnClickToPayActionPerformed

    private void txtPaidAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaidAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaidAmountActionPerformed

    private void txtPaidAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidAmountKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtPaidAmountKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private org.jdesktop.swingx.JXButton btnClickToPay;
    private org.jdesktop.swingx.JXButton btnPay;
    private javax.swing.JButton btnRefresh;
    private org.jdesktop.swingx.JXButton btnRemove;
    private org.jdesktop.swingx.JXButton btnUpdate;
    private javax.swing.JComboBox<String> cmbType;
    private org.jdesktop.swingx.JXDatePicker datePickerDueDate;
    private org.jdesktop.swingx.JXDatePicker datePickerPaymentDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAmount;
    private org.jdesktop.swingx.JXTable tblPayment;
    private org.jdesktop.swingx.JXTextField txtDescription;
    private org.jdesktop.swingx.JXTextField txtDueAmount;
    private org.jdesktop.swingx.JXTextField txtPaidAmount;
    private org.jdesktop.swingx.JXTextField txtPayingAmount;
    // End of variables declaration//GEN-END:variables
}
