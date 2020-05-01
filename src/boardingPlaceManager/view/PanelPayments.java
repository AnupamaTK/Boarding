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
import boardingPlaceManager.controller.PaymentController;
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
    private String selectedID;
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
        tblPayment.removeColumn(tblPayment.getColumnModel().getColumn(5));
        tblPayment.removeColumn(tblPayment.getColumnModel().getColumn(4));

        rent = rentDTO;
        rentNo=rent.getRent_id();
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

                    selectedID = tblPayment.getModel().getValueAt(tblPayment.getSelectedRow(), 4).toString();
                    //rentNo = tblPayment.getModel().getValueAt(tblPayment.getSelectedRow(), 5).toString();
                    //System.out.println(selectedID + "IDID");
                    // cmbPaymentNames.setSelectedItem(tblPayment.getValueAt(tblPayment.getSelectedRow(), 0).toString());
                    txtDescription.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 3).toString());
                    txtAmount.setText(tblPayment.getValueAt(tblPayment.getSelectedRow(), 4).toString());
                    datePickerDueDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblPayment.getValueAt(tblPayment.getSelectedRow(), 0).toString()));
                    datePickerPaymentDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblPayment.getValueAt(tblPayment.getSelectedRow(), 1).toString()));

                    System.out.println("Rent No" + rentNo);
                    //payment = new PaymentDTO(selectedID, "", "", null, null, 0.0, 0.0);

                } catch (ParseException ex) {
                    Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

//    private void loadAllPayments() throws Exception {
//        ArrayList<PaymentDTO> allPayments = PaymentController.getAllPayments();
//        //cmbPaymentNames.removeAllItems();
//
//        if (allPayments == null) {
//            return;
//        }
//        for (PaymentDTO payments : allPayments) {
//
//            //cmbPaymentNames.addItem(payments.get());
//        }
//        AutoCompleteDecorator.decorate(cmbPaymentNames);
//        cmbPaymentNames.setSelectedIndex(-1);
//
//    }
    private void clearAllTexts() {

        //txtBoardereName.setText("");
        //cmbPaymentNames.setSelectedIndex(-1);
        datePickerDueDate.setDate(null);
        datePickerPaymentDate.setDate(null);
        txtDescription.setText("");
        txtAmount.setText("");
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
        System.out.println("Chk");
        if (datePickerDueDate.getDate() == null || datePickerPaymentDate.getDate() == null || txtAmount.getText().isEmpty() || txtDescription.getText().isEmpty()) {
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
        btnPayments = new org.jdesktop.swingx.JXButton();
        jLabel9 = new javax.swing.JLabel();
        txtDescription = new org.jdesktop.swingx.JXTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAmount = new org.jdesktop.swingx.JXTextField();
        cmbPaymentNames = new javax.swing.JComboBox<>();
        datePickerPaymentDate = new org.jdesktop.swingx.JXDatePicker();
        datePickerDueDate = new org.jdesktop.swingx.JXDatePicker();
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
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Boadere Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 37));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Due Date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 181, -1, 37));

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
        jLabel10.setText("Paymet Date");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, -1, 37));

        btnPayments.setBackground(new java.awt.Color(153, 153, 153));
        btnPayments.setForeground(new java.awt.Color(255, 255, 255));
        btnPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Money_20px.png"))); // NOI18N
        btnPayments.setText("Payments");
        btnPayments.setToolTipText("Click to add");
        btnPayments.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPayments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPaymentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPaymentsMouseExited(evt);
            }
        });
        btnPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentsActionPerformed(evt);
            }
        });
        jPanel1.add(btnPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 140, 32));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Description");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 137, 37));

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
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
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 170, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Amount");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 137, 37));

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAmount.setPrompt("Amount");
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
        });
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 170, 30));

        cmbPaymentNames.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbPaymentNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPaymentNames.setToolTipText("Select Customer Name");
        cmbPaymentNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPaymentNamesItemStateChanged(evt);
            }
        });
        cmbPaymentNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentNamesActionPerformed(evt);
            }
        });
        cmbPaymentNames.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbPaymentNamesPropertyChange(evt);
            }
        });
        jPanel1.add(cmbPaymentNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 170, -1));

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
        jPanel1.add(datePickerPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 170, -1));

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
        jPanel1.add(datePickerDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 170, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("View Payment Details");

        tblPayment.setForeground(new java.awt.Color(51, 51, 51));
        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Due Date", "Payment Date", "Description", "Amount", "Payment ID", "Rent No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
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

//        int n = JOptionPane.showConfirmDialog(
//                this, "Confirm deletion?",
//                "An Inane Question",
//                JOptionPane.YES_NO_OPTION);
//        if (n == JOptionPane.NO_OPTION) {
//            return;
//        }
//
//        try {
//            PaymentDTO payment = PaymentController.searchPayment(new PaymentDTO(selectedID, "", "", null, null, 0.0, 0.0));
//
//            try {
//                boolean result = PaymentController.deletePayment(payment);
//
//                if (result) {
//                    JOptionPane.showMessageDialog(this, "Payment has been successfully removed");
//                    btnRefreshActionPerformed(evt);
//                    clearAllTexts();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Payment hasn't been removed");
//                }
//
//            } catch (Exception ex) {
//                Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnRemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseExited
        btnRemove.setBackground(darkGreen);
    }//GEN-LAST:event_btnRemoveMouseExited

    private void btnRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseEntered
        btnRemove.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnRemoveMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//        if (fieldsUpdated == false) {
//            JOptionPane.showMessageDialog(this, "No change found");
//            return;
//        }
//
//        if (datePickerFromDate.getDate().after(datePickerToDate.getDate())) {
//            JOptionPane.showMessageDialog(this, "To Date should be a date after from date");
//            return;
//        }
//        try {
//
//            PaymentDTO boadere = PaymentController.searchPaymentByName(new PaymentDTO(null, cmbPaymentNames.getSelectedItem().toString(), null, null));
//
//            try {
//
//                PaymentDTO newPayment = PaymentController.searchPayment(this.payment);
//                //System.out.println(boadere.getName() + "bbbbb" + newPayment);
//
//                newPayment.setPayment_id(boadere.getNic());
//                newPayment.setMonthly_payment(Double.parseDouble(txtMonthlyPayment.getText()));
//                newPayment.setAdvance_fee(Double.parseDouble(txtadvanceFee.getText()));
//
////                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////                String fromDate = simpleDateFormat.format(datePickerFromDate.getDate());
////                System.out.println(fromDate);
//                newPayment.setFrom_date(datePickerFromDate.getDate());
//                //String toDate = simpleDateFormat.format(datePickerFromDate.getDate());
//
//                // String toDate = simpleDateFormat.format(datePickerToDate.getDate());
//                newPayment.setTo_date(datePickerFromDate.getDate());
//
//                try {
//                    System.out.println(newPayment);
//                    boolean result = PaymentController.updatePayment(newPayment);
//
//                    if (result) {
//                        JOptionPane.showMessageDialog(this, "Payment details has been successfully updated");
//                        btnRefreshActionPerformed(evt);
//                        clearAllTexts();
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Payment details hasn't been updated");
//                    }
//
//                } catch (Exception ex) {
//                    Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PanelPayments.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
                    System.out.println("In Payment Loop");
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
                        payment.getAmount(),
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

    private void cmbPaymentNamesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbPaymentNamesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaymentNamesPropertyChange

    private void cmbPaymentNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaymentNamesActionPerformed

    private void cmbPaymentNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPaymentNamesItemStateChanged
        fieldsUpdated = true;
        //        try {
        //            if (cmbPaymentNames.getSelectedIndex() == -1) {
        //                return;
        //            }
        //
        //            boadere = PaymentController.searchPaymentByName(new PaymentDTO(null, cmbPaymentNames.getSelectedItem().toString(), null, null));

        //            if (boadere == null) {
        //                return;
        //            }
        //
        //            DefaultTableModel dtm = (DefaultTableModel) tblBoaders.getModel();
        //            dtm.setRowCount(0);
        //            Object[] rowData = {boadere.getNic(),
        //                boadere.getName(),
        //                boadere.getTel(),
        //                boadere.getAddress()};
        //
        //            dtm.addRow(rowData);
        //
        //            /*itemDescriptionText.setText(item.getDescription());
        //            qtyOnHandText.setText(item.getQtyOnHand() + "");
        //            itemPriceText.setText(item.getUnitPrice().toPlainString());*/
        //        } catch (Exception ex) {
        //            Logger.getLogger(PanelPaymentHousee.class.getName()).log(Level.SEVERE, null, ex);
        //        }
    }//GEN-LAST:event_cmbPaymentNamesItemStateChanged

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtAmountKeyPressed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtDescriptionKeyPressed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void btnPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsActionPerformed

    }//GEN-LAST:event_btnPaymentsActionPerformed

    private void btnPaymentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentsMouseExited

    private void btnPaymentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentsMouseEntered

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearAllTexts();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private org.jdesktop.swingx.JXButton btnPayments;
    private javax.swing.JButton btnRefresh;
    private org.jdesktop.swingx.JXButton btnRemove;
    private org.jdesktop.swingx.JXButton btnUpdate;
    private javax.swing.JComboBox<String> cmbPaymentNames;
    private javax.swing.JComboBox<String> cmbType;
    private org.jdesktop.swingx.JXDatePicker datePickerDueDate;
    private org.jdesktop.swingx.JXDatePicker datePickerPaymentDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable tblPayment;
    private org.jdesktop.swingx.JXTextField txtAmount;
    private org.jdesktop.swingx.JXTextField txtDescription;
    // End of variables declaration//GEN-END:variables
}
