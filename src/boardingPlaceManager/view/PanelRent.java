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
import boardingPlaceManager.controller.BoadereController;
import boardingPlaceManager.controller.PropertyController;
import boardingPlaceManager.controller.RentController;
import boardingPlaceManager.controller.RentHouseController;
import boardingPlaceManager.dto.BoadereDTO;
import boardingPlaceManager.dto.PropertyDTO;
import boardingPlaceManager.dto.RentDTO;
import boardingPlaceManager.dto.RentHouseDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
//import java.time.DateTimeFormatter;
import javax.swing.UIManager;
//import static boardingPlaceManager.view.PanelRent.dark;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author User
 */
public class PanelRent extends JPanel {

    /**
     * Creates new form panelRent
     */
    private Color darkGreen = new Color(102, 102, 102);
    private String selectedID;
    private boolean fieldsUpdated = false;
    private int type = 0;
    private PropertyDTO property = null;
    private RentDTO rent = new RentDTO();
    private Date fromDate = null;
    private Date toDate = null;

    public PanelRent(PropertyDTO propertyDTO) throws SQLException {

        initComponents();
        tblRent.removeColumn(tblRent.getColumnModel().getColumn(5));
        property = propertyDTO;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            loadAllBoaderes();
        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
        datePickerFromDate.setDate(null);
        datePickerToDate.setDate(null);
        fieldsUpdated = false;
        datePickerFromDate.setFormats("yyyy-MM-dd");
        datePickerToDate.setFormats("yyyy-MM-dd");

        //auto generate id
        try {

        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnRefreshActionPerformed(null);

        tblRent.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                fieldsUpdated = false;

                try {
                    if (tblRent.getSelectedRow() == -1) {
                        return;
                    }

                    selectedID = tblRent.getModel().getValueAt(tblRent.getSelectedRow(), 5).toString();
                    //System.out.println(selectedID + "IDID");
                    cmbBoadereNames.setSelectedItem(tblRent.getValueAt(tblRent.getSelectedRow(), 0).toString());
                    txtadvanceFee.setText(tblRent.getValueAt(tblRent.getSelectedRow(), 3).toString());
                    txtMonthlyRent.setText(tblRent.getValueAt(tblRent.getSelectedRow(), 4).toString());
                    datePickerFromDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblRent.getValueAt(tblRent.getSelectedRow(), 1).toString()));
                    datePickerToDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblRent.getValueAt(tblRent.getSelectedRow(), 2).toString()));

                    rent = new RentDTO(selectedID, "", "", null, null, 0.0, 0.0);

                } catch (ParseException ex) {
                    Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    private void loadAllBoaderes() throws Exception {
        ArrayList<BoadereDTO> allBoaderes = BoadereController.getAllBoaderes();
        cmbBoadereNames.removeAllItems();

        if (allBoaderes == null) {
            return;
        }
        for (BoadereDTO boaderes : allBoaderes) {

            cmbBoadereNames.addItem(boaderes.getName());

        }
        AutoCompleteDecorator.decorate(cmbBoadereNames);
        cmbBoadereNames.setSelectedIndex(-1);

    }

    private void clearAllTexts() {

        //txtBoardereName.setText("");
        cmbBoadereNames.setSelectedIndex(-1);
        datePickerFromDate.setDate(null);
        datePickerToDate.setDate(null);
        txtadvanceFee.setText("");
        txtMonthlyRent.setText("");
    }

    public String getID() {
        String newID;

        try {
            newID = IDGenarator.getNewID("property", "property_id", "p");
            return newID;
        } catch (SQLException ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //to check text field inputs are empty
    public boolean checkText() {
        System.out.println("Chk");
        if (datePickerFromDate.getDate() == null || cmbBoadereNames.getSelectedIndex() < 0 || datePickerToDate.getDate() == null || txtMonthlyRent.getText().isEmpty() || txtadvanceFee.getText().isEmpty()) {
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
        btnClearFields = new org.jdesktop.swingx.JXButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnPayments = new org.jdesktop.swingx.JXButton();
        jLabel9 = new javax.swing.JLabel();
        txtadvanceFee = new org.jdesktop.swingx.JXTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMonthlyRent = new org.jdesktop.swingx.JXTextField();
        cmbBoadereNames = new javax.swing.JComboBox<>();
        datePickerToDate = new org.jdesktop.swingx.JXDatePicker();
        datePickerFromDate = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRent = new org.jdesktop.swingx.JXTable();
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

        btnClearFields.setBackground(new java.awt.Color(102, 102, 102));
        btnClearFields.setForeground(new java.awt.Color(255, 255, 255));
        btnClearFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Erase_20px.png"))); // NOI18N
        btnClearFields.setText("Clear Fields");
        btnClearFields.setToolTipText("Click to update");
        btnClearFields.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClearFields.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClearFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearFieldsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearFieldsMouseExited(evt);
            }
        });
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
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
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearFields, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, 130, 37));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("From Date");
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
        jLabel10.setText("To Date");
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
        jLabel9.setText("Advance Fee");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 137, 37));

        txtadvanceFee.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtadvanceFee.setPrompt("Advance Fee");
        txtadvanceFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadvanceFeeActionPerformed(evt);
            }
        });
        txtadvanceFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtadvanceFeeKeyPressed(evt);
            }
        });
        jPanel1.add(txtadvanceFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 170, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Monthly Rent");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 137, 37));

        txtMonthlyRent.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMonthlyRent.setPrompt("Monthly Rent");
        txtMonthlyRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthlyRentActionPerformed(evt);
            }
        });
        txtMonthlyRent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMonthlyRentKeyPressed(evt);
            }
        });
        jPanel1.add(txtMonthlyRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 170, 30));

        cmbBoadereNames.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbBoadereNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBoadereNames.setToolTipText("Select Customer Name");
        cmbBoadereNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBoadereNamesItemStateChanged(evt);
            }
        });
        cmbBoadereNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoadereNamesActionPerformed(evt);
            }
        });
        cmbBoadereNames.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbBoadereNamesPropertyChange(evt);
            }
        });
        jPanel1.add(cmbBoadereNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 170, -1));

        datePickerToDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                datePickerToDateMousePressed(evt);
            }
        });
        datePickerToDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerToDateActionPerformed(evt);
            }
        });
        jPanel1.add(datePickerToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 170, -1));

        datePickerFromDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                datePickerFromDateMousePressed(evt);
            }
        });
        datePickerFromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerFromDateActionPerformed(evt);
            }
        });
        jPanel1.add(datePickerFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 170, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("View Rent Details");

        tblRent.setForeground(new java.awt.Color(51, 51, 51));
        tblRent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Boadere Name", "From Date", "To Date", "Monthly Rent", "Advance fee", "Rent Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRent.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane3.setViewportView(tblRent);

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Spinner Frame 3_20px.png"))); // NOI18N
        btnRefresh.setToolTipText("Click to refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        cmbType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Past", "Current ", "Future" }));
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
        if (selectedID == null) {
            JOptionPane.showMessageDialog(this, "Select a Rent First");
        }
        int n = JOptionPane.showConfirmDialog(
                this, "Confirm deletion?",
                "An Inane Question",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            RentDTO rent = RentController.searchRent(new RentDTO(selectedID, "", "", null, null, 0.0, 0.0));

            try {
                boolean result = RentController.deleteRent(rent);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Rent has been successfully removed");
                    btnRefreshActionPerformed(evt);
                    clearAllTexts();
                } else {
                    JOptionPane.showMessageDialog(this, "Rent hasn't been removed");
                }

            } catch (Exception ex) {
                Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnRemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseExited
        btnRemove.setBackground(darkGreen);
    }//GEN-LAST:event_btnRemoveMouseExited

    private void btnRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseEntered
        btnRemove.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnRemoveMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (fieldsUpdated == false) {
            JOptionPane.showMessageDialog(this, "No change found");
            return;
        }

        if (datePickerFromDate.getDate().after(datePickerToDate.getDate())) {
            JOptionPane.showMessageDialog(this, "To Date should be a date after from date");
            return;
        }
        try {

            BoadereDTO boadere = BoadereController.searchBoadereByName(new BoadereDTO(null, cmbBoadereNames.getSelectedItem().toString(), null, null));

            try {

                RentDTO newRent = RentController.searchRent(this.rent);
                //System.out.println(boadere.getName() + "bbbbb" + newRent);

                newRent.setBoadere_id(boadere.getNic());
                newRent.setMonthly_rent(Double.parseDouble(txtMonthlyRent.getText()));
                newRent.setAdvance_fee(Double.parseDouble(txtadvanceFee.getText()));

//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                String fromDate = simpleDateFormat.format(datePickerFromDate.getDate());
//                System.out.println(fromDate);
                newRent.setFrom_date(datePickerFromDate.getDate());
                //String toDate = simpleDateFormat.format(datePickerFromDate.getDate());

                // String toDate = simpleDateFormat.format(datePickerToDate.getDate());
                newRent.setTo_date(datePickerFromDate.getDate());

                try {
                    System.out.println(newRent);
                    boolean result = RentController.updateRent(newRent);

                    if (result) {
                        JOptionPane.showMessageDialog(this, "Rent details has been successfully updated");
                        btnRefreshActionPerformed(evt);
                        clearAllTexts();
                    } else {
                        JOptionPane.showMessageDialog(this, "Rent details hasn't been updated");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex) {
                Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.println("State changed 1");
        try {
            if (cmbType.getSelectedIndex() == -1) {
                type = 0;
            } else if (cmbType.getSelectedIndex() == 0) {
                type = 0;
            } else if (cmbType.getSelectedIndex() == 1) {
                System.out.println("Selected");
                type = 1;
            } else if (cmbType.getSelectedIndex() == 2) {
                type = 2;
            } else if (cmbType.getSelectedIndex() == 3) {
                type = 3;
            }
            System.out.println("State changed");
            btnRefreshActionPerformed(null);

        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTypeItemStateChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        System.out.println("Bgn Refresh");
        try {
//            ArrayList<RentDTO> allRents = RentController.getAllRents();
//            if (type == 1 || type == 2 || type == 3) {
            ArrayList<RentDTO> allRents = RentController.searchRent(property.getProperty_id(), type);

            if (allRents != null) {
                DefaultTableModel dtm = (DefaultTableModel) tblRent.getModel();

                dtm.setRowCount(0);

                for (RentDTO rent : allRents) {
                    System.out.println("In Rent Loop");
                    //PropertyDTO property = new PropertyDTO(rent.getProperty_id(), null, null, null);
                    //  property = PropertyController.searchProperty(property);
                    BoadereDTO boadereDTO = new BoadereDTO(rent.getBoadere_id(), "", "", "");
                    System.out.println("..." + rent.getBoadere_id());
                    BoadereDTO boadere = BoadereController.searchBoadere(boadereDTO);
                    Object[] rowData = {
                        boadere.getName(),
                        rent.getFrom_date(),
                        rent.getTo_date(),
                        rent.getMonthly_rent(),
                        rent.getAdvance_fee(),
                        rent.getRent_id()};

                    dtm.addRow(rowData);

                }

            } else {
                DefaultTableModel dtm = (DefaultTableModel) tblRent.getModel();
                dtm.setRowCount(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        //  getCID.requestFocus();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void datePickerFromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerFromDateActionPerformed
        fieldsUpdated = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDateS = simpleDateFormat.format(datePickerFromDate.getDate());
        try {
            //System.out.println("sormatted"+fromDate);
            fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateS);
            //        System.out.println("Date" + datePickerFromDate.getDate());
        } catch (ParseException ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_datePickerFromDateActionPerformed

    private void datePickerFromDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datePickerFromDateMousePressed

    }//GEN-LAST:event_datePickerFromDateMousePressed

    private void datePickerToDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerToDateActionPerformed
        fieldsUpdated = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDateS = simpleDateFormat.format(datePickerFromDate.getDate());
        try {
            //System.out.println("sormatted"+fromDate);
            toDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateS);
            //        System.out.println("Date" + datePickerFromDate.getDate());
        } catch (ParseException ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_datePickerToDateActionPerformed

    private void datePickerToDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datePickerToDateMousePressed
        fieldsUpdated = true;
    }//GEN-LAST:event_datePickerToDateMousePressed

    private void cmbBoadereNamesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbBoadereNamesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBoadereNamesPropertyChange

    private void cmbBoadereNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoadereNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBoadereNamesActionPerformed

    private void cmbBoadereNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBoadereNamesItemStateChanged
        fieldsUpdated = true;
        //        try {
        //            if (cmbBoadereNames.getSelectedIndex() == -1) {
        //                return;
        //            }
        //
        //            boadere = BoadereController.searchBoadereByName(new BoadereDTO(null, cmbBoadereNames.getSelectedItem().toString(), null, null));

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
        //            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        //        }
    }//GEN-LAST:event_cmbBoadereNamesItemStateChanged

    private void txtMonthlyRentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonthlyRentKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtMonthlyRentKeyPressed

    private void txtMonthlyRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthlyRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthlyRentActionPerformed

    private void txtadvanceFeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadvanceFeeKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtadvanceFeeKeyPressed

    private void txtadvanceFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadvanceFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadvanceFeeActionPerformed

    private void btnPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsActionPerformed
        if (selectedID == null) {
            JOptionPane.showMessageDialog(this, "Select a Rent House First");
            return;
        }
        try {
            //RentDTO rentHouse = RentController.searchRent(this.rent);
            //PropertyDTO property = new PropertyDTO(rentHouse.getProperty_id(), null, null, null);
            //property = PropertyController.searchProperty(property);
            new DialogPayments(DashBoard.dashBoard, true, new PanelPayments(rent)).setVisible(true);
            //btnGoToItem.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void btnClearFieldsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearFieldsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearFieldsMouseEntered

    private void btnClearFieldsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearFieldsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearFieldsMouseExited

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        clearAllTexts();
    }//GEN-LAST:event_btnClearFieldsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private org.jdesktop.swingx.JXButton btnClearFields;
    private org.jdesktop.swingx.JXButton btnPayments;
    private javax.swing.JButton btnRefresh;
    private org.jdesktop.swingx.JXButton btnRemove;
    private org.jdesktop.swingx.JXButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBoadereNames;
    private javax.swing.JComboBox<String> cmbType;
    private org.jdesktop.swingx.JXDatePicker datePickerFromDate;
    private org.jdesktop.swingx.JXDatePicker datePickerToDate;
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
    private org.jdesktop.swingx.JXTable tblRent;
    private org.jdesktop.swingx.JXTextField txtMonthlyRent;
    private org.jdesktop.swingx.JXTextField txtadvanceFee;
    // End of variables declaration//GEN-END:variables
}
