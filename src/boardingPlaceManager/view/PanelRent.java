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
import boardingPlaceManager.dto.BoadereDTO;
import boardingPlaceManager.dto.PropertyDTO;
import boardingPlaceManager.dto.RentDTO;
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
    private String selectedAddress;
    private boolean fieldsUpdated = false;
    private int type = 0;

    public PanelRent(PropertyDTO property) throws SQLException {
        // super(parent, modal);
        initComponents();
        //auto generate id

        try {
            // setCustName();
            // getID();

            //setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnRefreshActionPerformed(null);

        tblRent.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblRent.getSelectedRow() == -1) {
                    return;
                }

                txtBoardereName.setText(tblRent.getValueAt(tblRent.getSelectedRow(), 0).toString());
                txtFromDate.setText(tblRent.getValueAt(tblRent.getSelectedRow(), 1).toString());
                txtToDate.setText(tblRent.getValueAt(tblRent.getSelectedRow(), 2).toString());
                txtadvanceFee.setText(tblRent.getValueAt(tblRent.getSelectedRow(), 3).toString());
                txtMonthlyRent.setText(tblRent.getValueAt(tblRent.getSelectedRow(), 4).toString());

//                selectedAddress = txtAddress.getText();
//                try {
//                    RentDTO rent = RentController.searchByAddress(selectedAddress);
//                    Boolean availability = PropertyController.checkAvailability(rent.getProperty_id());
//                    if (availability == true) {
//                        btnAddRent.setVisible(true);
//                        btnViewRentDetails.setVisible(false);
//
//                    } else {
//                        btnViewRentDetails.setVisible(true);
//                        btnAddRent.setVisible(false);
//                    }
//                } catch (Exception ex) {
//                    Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
    }

    /* private void getID() throws SQLException {
        String newID;
        try {
            newID = IDGenarator.getNewID("Rent", "cid", "c");
            txtCustID.setText(newID);

        } catch (ClassNotFoundException | SQLException e) {
        }
    }*/
    private void clearAllTexts() {

        txtBoardereName.setText("");
        txtToDate.setText("");
        txtFromDate.setText("");
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
        if (txtFromDate.getText().isEmpty() || txtBoardereName.getText().isEmpty() || txtToDate.getText().isEmpty() || txtMonthlyRent.getText().isEmpty() || txtadvanceFee.getText().isEmpty()) {
            return false;
        }
        return true;
    }

//    private void setCustName() throws Exception {
//        ArrayList<RentDTO> allRents = RentController.getAllRents();
//        cmbCustName.removeAllItems();
//
//        if (allRents == null) {
//            return;
//        }
//        for (RentDTO rent : allRents) {
//
//            
//            cmbCustName.addItem(rent.getName());
//            
//        }
//        AutoCompleteDecorator.decorate(cmbCustName);
//
//    }
    /* public void getID() {
        String newID;
        try {
            newID = IDGenarator.getNewID("Rent", "cid", "C");
            txtCustID.setText(newID);
        } catch (SQLException ex) {
            Logger.getLogger(PanelGRN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelGRN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
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
        btnAdd = new org.jdesktop.swingx.JXButton();
        btnUpdate = new org.jdesktop.swingx.JXButton();
        btnRemove = new org.jdesktop.swingx.JXButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBoardereName = new org.jdesktop.swingx.JXTextField();
        btnCancel = new javax.swing.JButton();
        txtFromDate = new org.jdesktop.swingx.JXTextField();
        jLabel10 = new javax.swing.JLabel();
        txtToDate = new org.jdesktop.swingx.JXTextField();
        btnAddRent = new org.jdesktop.swingx.JXButton();
        btnViewRentDetails = new org.jdesktop.swingx.JXButton();
        jLabel9 = new javax.swing.JLabel();
        txtadvanceFee = new org.jdesktop.swingx.JXTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMonthlyRent = new org.jdesktop.swingx.JXTextField();
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

        btnAdd.setBackground(new java.awt.Color(102, 102, 102));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Plus_20px_1.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setToolTipText("Click to add");
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Available Updates_20px.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setToolTipText("Click to update");
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
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
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(190, 190, 190)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, 130, 37));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("From Date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 181, -1, 37));

        txtBoardereName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBoardereName.setPrompt("Boadere Name");
        txtBoardereName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtBoardereNameInputMethodTextChanged(evt);
            }
        });
        txtBoardereName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoardereNameActionPerformed(evt);
            }
        });
        txtBoardereName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtBoardereNamePropertyChange(evt);
            }
        });
        txtBoardereName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBoardereNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBoardereNameKeyTyped(evt);
            }
        });
        jPanel1.add(txtBoardereName, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 124, 170, 30));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Cancel 2_20px.png"))); // NOI18N
        btnCancel.setToolTipText("Click to clear fields");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 619, 48, 30));

        txtFromDate.setToolTipText("No of Bathrooms");
        txtFromDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtFromDate.setPrompt("From Date");
        txtFromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFromDateActionPerformed(evt);
            }
        });
        txtFromDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFromDateKeyPressed(evt);
            }
        });
        jPanel1.add(txtFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 184, 170, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("To Date");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, -1, 37));

        txtToDate.setToolTipText("No of Story");
        txtToDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtToDate.setPrompt("To Date");
        txtToDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToDateActionPerformed(evt);
            }
        });
        txtToDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtToDateKeyPressed(evt);
            }
        });
        jPanel1.add(txtToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 239, 170, 30));

        btnAddRent.setBackground(new java.awt.Color(153, 153, 153));
        btnAddRent.setForeground(new java.awt.Color(255, 255, 255));
        btnAddRent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Add User Group Man Man_20px.png"))); // NOI18N
        btnAddRent.setText(" Rent ");
        btnAddRent.setToolTipText("Click to add");
        btnAddRent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddRent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddRent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddRentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddRentMouseExited(evt);
            }
        });
        btnAddRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRentActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 150, 32));

        btnViewRentDetails.setBackground(new java.awt.Color(153, 153, 153));
        btnViewRentDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnViewRentDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Details Pane_20px.png"))); // NOI18N
        btnViewRentDetails.setText(" View Rent Details ");
        btnViewRentDetails.setToolTipText("Click to add");
        btnViewRentDetails.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnViewRentDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewRentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewRentDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewRentDetailsMouseExited(evt);
            }
        });
        btnViewRentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRentDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewRentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 150, 32));

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("View Rent Details");

        tblRent.setForeground(new java.awt.Color(51, 51, 51));
        tblRent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Boadere Name", "From Date", "To Date", "Monthly Rent", "Advance fee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true
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

//        int n = JOptionPane.showConfirmDialog(
//                this, "Confirm deletion?",
//                "An Inane Question",
//                JOptionPane.YES_NO_OPTION);
//        if (n == JOptionPane.NO_OPTION) {
//            return;
//        }
//
//        try {
//            RentDTO rent = RentController.searchByAddress(selectedAddress);
//
//            try {
//                boolean result = RentController.deleteRent(rent);
//
//                if (result) {
//                    JOptionPane.showMessageDialog(this, "Rent has been successfully removed");
//                    btnRefreshActionPerformed(evt);
//                    clearAllTexts();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Rent hasn't been removed");
//                }
//
//            } catch (Exception ex) {
//                Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
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
//        try {
//            RentDTO rent = RentController.searchByAddress(selectedAddress);
//            rent.setNo_of_rooms(Integer.parseInt(txtBoardereName.getText()));
//            rent.setNo_of_bathrooms(Integer.parseInt(txtFromDate.getText()));
//            rent.setNo_of_story(Integer.parseInt(txtToDate.getText()));
//            rent.setAddress(txtAddress.getText());
//
//            PropertyDTO property = new PropertyDTO(
//                    rent.getProperty_id(),
//                    PropertyController.checkAvailability(rent.getProperty_id()),
//                    Double.parseDouble(txtadvanceFee.getText()),
//                    Double.parseDouble(txtMonthlyRent.getText())
//            );
//
//            try {
//
//                boolean result = RentController.updateRent(rent, property);
//
//                if (result) {
//                    JOptionPane.showMessageDialog(this, "Rent details has been successfully updated");
//                    btnRefreshActionPerformed(evt);
//                    clearAllTexts();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Rent details hasn't been updated");
//                }
//
//            } catch (Exception ex) {
//                Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(darkGreen);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

//        if (checkText() == false) {
//            UIManager UI = new UIManager();
//            UI.put("OptionPane.background", Color.white);
//            UI.put("Panel.background", Color.white);
//
//            JOptionPane.showMessageDialog(this, "All fields should be filled to save");
//            return;
//        }
//        RentDTO rent = new RentDTO(
//                getID(),
//                Integer.parseInt(txtBoardereName.getText()),
//                Integer.parseInt(txtFromDate.getText()),
//                Integer.parseInt(txtToDate.getText()),
//                txtAddress.getText()
//        );
//
//        PropertyDTO property = new PropertyDTO(
//                getID(),
//                true,
//                Double.parseDouble(txtadvanceFee.getText()),
//                Double.parseDouble(txtMonthlyRent.getText())
//        );
//
//        try {
//            boolean result = RentController.addRent(rent, property);
//            if (result) {
//                JOptionPane.showMessageDialog(this, "Rent has been successfully added");
//                btnRefreshActionPerformed(evt);
//                clearAllTexts();
//            } else {
//                JOptionPane.showMessageDialog(this, "Rent hasn't been added");
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        btnAdd.setBackground(darkGreen);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        btnAdd.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnAddMouseEntered

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void cmbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTypeItemStateChanged
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
            btnRefreshActionPerformed(null);

        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTypeItemStateChanged

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        //  getCID.requestFocus();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void txtFromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFromDateActionPerformed
        txtToDate.requestFocus();
    }//GEN-LAST:event_txtFromDateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearAllTexts();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtBoardereNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoardereNameActionPerformed
        txtFromDate.requestFocus();
    }//GEN-LAST:event_txtBoardereNameActionPerformed

    private void txtToDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToDateActionPerformed
//        txtAddress.requestFocus();
    }//GEN-LAST:event_txtToDateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            ArrayList<RentDTO> allRents = RentController.getAllRents();
            if (type == 1 || type == 2 || type == 3) {
                allRents = RentController.searchRent(TOOL_TIP_TEXT_KEY, type);
            }
            if (allRents != null) {
                DefaultTableModel dtm = (DefaultTableModel) tblRent.getModel();

                dtm.setRowCount(0);

                for (RentDTO rent : allRents) {
                    System.out.println("In Rent Loop");
                    //PropertyDTO property = new PropertyDTO(rent.getProperty_id(), null, null, null);
                    //  property = PropertyController.searchProperty(property);
                    BoadereDTO boadereDTO = new BoadereDTO(rent.getBoadere_id(), "", "", "");
                    System.out.println("..."+rent.getBoadere_id());
                    BoadereDTO boadere = BoadereController.searchBoadere(boadereDTO);
                    Object[] rowData = {boadere.getName(),
                        rent.getFrom_date(),
                        rent.getTo_date(),
                        rent.getMonthly_rent(),
                        rent.getAdvance_fee()
                    };

                    dtm.addRow(rowData);

                }

            }else{
                System.err.println("NULL CAME here");
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtBoardereNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBoardereNamePropertyChange

    }//GEN-LAST:event_txtBoardereNamePropertyChange

    private void txtBoardereNameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtBoardereNameInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoardereNameInputMethodTextChanged

    private void txtBoardereNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoardereNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoardereNameKeyTyped

    private void txtBoardereNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoardereNameKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtBoardereNameKeyPressed

    private void txtFromDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFromDateKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtFromDateKeyPressed

    private void txtToDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToDateKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtToDateKeyPressed

    private void btnViewRentDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRentDetailsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRentDetailsMouseEntered

    private void btnViewRentDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRentDetailsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRentDetailsMouseExited

    private void btnViewRentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRentDetailsActionPerformed
//        try {
//            RentDTO rent = RentController.searchByAddress(selectedAddress);
//            PropertyDTO property = new PropertyDTO(rent.getProperty_id(), null, null, null);
//            property = PropertyController.searchProperty(property);
//            new DialogViewRentDetails(DashBoard.dashBoard, true, property).setVisible(true);
//            //btnGoToItem.requestFocus();
//        } catch (Exception ex) {
//            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnViewRentDetailsActionPerformed

    private void btnAddRentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRentMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRentMouseExited

    private void btnAddRentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRentMouseEntered

    private void btnAddRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRentActionPerformed
//        try {
//            RentDTO rent = RentController.searchByAddress(selectedAddress);
//            PropertyDTO property = new PropertyDTO(rent.getProperty_id(), null, null, null);
//            property = PropertyController.searchProperty(property);
//            new DialogRennt(DashBoard.dashBoard, true, property).setVisible(true);
//            //btnGoToItem.requestFocus();
//        } catch (Exception ex) {
//            Logger.getLogger(PanelRent.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnAddRentActionPerformed

    private void txtadvanceFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadvanceFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadvanceFeeActionPerformed

    private void txtadvanceFeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadvanceFeeKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtadvanceFeeKeyPressed

    private void txtMonthlyRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthlyRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthlyRentActionPerformed

    private void txtMonthlyRentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonthlyRentKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtMonthlyRentKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAdd;
    private org.jdesktop.swingx.JXButton btnAddRent;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private org.jdesktop.swingx.JXButton btnRemove;
    private org.jdesktop.swingx.JXButton btnUpdate;
    private org.jdesktop.swingx.JXButton btnViewRentDetails;
    private javax.swing.JComboBox<String> cmbType;
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
    private org.jdesktop.swingx.JXTextField txtBoardereName;
    private org.jdesktop.swingx.JXTextField txtFromDate;
    private org.jdesktop.swingx.JXTextField txtMonthlyRent;
    private org.jdesktop.swingx.JXTextField txtToDate;
    private org.jdesktop.swingx.JXTextField txtadvanceFee;
    // End of variables declaration//GEN-END:variables
}
