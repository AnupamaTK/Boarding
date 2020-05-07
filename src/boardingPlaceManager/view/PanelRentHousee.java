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
import boardingPlaceManager.controller.PropertyController;
import boardingPlaceManager.controller.RentHouseController;
import boardingPlaceManager.dto.PropertyDTO;
import boardingPlaceManager.dto.RentHouseDTO;
import javax.swing.UIManager;
//import static boardingPlaceManager.view.PanelRentHouse.dark;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author User
 */
public class PanelRentHousee extends JPanel {

    /**
     * Creates new form panelRentHouse
     */
    private Color darkGreen = new Color(102, 102, 102);
    private String selectedAddress;
    private boolean fieldsUpdated = false;
    private int type = 0;

    public PanelRentHousee() throws SQLException {
        // super(parent, modal);
        initComponents();
        btnAddRent.setVisible(false);
        btnViewRentDetails.setVisible(false);
        //auto generate id

        try {
            // setCustName();
            // getID();

            //setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnRefreshActionPerformed(null);

        tblRentHouse.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblRentHouse.getSelectedRow() == -1) {
                    return;
                }
                btnAddRent.setVisible(true);
                btnViewRentDetails.setVisible(true);
                txtNoOfRooms.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 0).toString());
                txtNoOfBathRooms.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 1).toString());
                txtNoOfStory.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 2).toString());
                txtAddress.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 3).toString());
                txtadvanceFee.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 4).toString());
                txtMonthlyRent.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 5).toString());

                selectedAddress = txtAddress.getText();
                try {
                    RentHouseDTO rentHouse = RentHouseController.searchByAddress(selectedAddress);
                    Boolean availability = PropertyController.checkAvailability(rentHouse.getProperty_id());
//                    if (availability == true) {
//                        btnAddRent.setVisible(true);
//                        btnViewRentDetails.setVisible(false);
//
//                    } else {
//                        btnViewRentDetails.setVisible(true);
//                        btnAddRent.setVisible(false);
//                    }
                } catch (Exception ex) {
                    Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /* private void getID() throws SQLException {
        String newID;
        try {
            newID = IDGenarator.getNewID("RentHouse", "cid", "c");
            txtCustID.setText(newID);

        } catch (ClassNotFoundException | SQLException e) {
        }
    }*/
    private void clearAllTexts() {

        txtNoOfRooms.setText("");
        txtNoOfStory.setText("");
        txtNoOfBathRooms.setText("");
        txtAddress.setText("");
        txtadvanceFee.setText("");
        txtMonthlyRent.setText("");
    }

    public String getID() {
        String newID;

        try {
            newID = IDGenarator.getNewID("property", "property_id", "p");
            return newID;
        } catch (SQLException ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //to check text field inputs are empty
    public boolean checkText() {
        System.out.println("Chk");
        if (txtAddress.getText().isEmpty() || txtNoOfBathRooms.getText().isEmpty() || txtNoOfRooms.getText().isEmpty() || txtNoOfStory.getText().isEmpty() || txtMonthlyRent.getText().isEmpty() || txtadvanceFee.getText().isEmpty()) {
            return false;
        }
        return true;
    }

//    private void setCustName() throws Exception {
//        ArrayList<RentHouseDTO> allRentHouses = RentHouseController.getAllRentHouses();
//        cmbCustName.removeAllItems();
//
//        if (allRentHouses == null) {
//            return;
//        }
//        for (RentHouseDTO rentHouse : allRentHouses) {
//
//            
//            cmbCustName.addItem(rentHouse.getName());
//            
//        }
//        AutoCompleteDecorator.decorate(cmbCustName);
//
//    }
    /* public void getID() {
        String newID;
        try {
            newID = IDGenarator.getNewID("RentHouse", "cid", "C");
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
        btnClearFields = new org.jdesktop.swingx.JXButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNoOfRooms = new org.jdesktop.swingx.JXTextField();
        btnCancel = new javax.swing.JButton();
        txtNoOfBathRooms = new org.jdesktop.swingx.JXTextField();
        txtAddress = new org.jdesktop.swingx.JXTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNoOfStory = new org.jdesktop.swingx.JXTextField();
        btnAddRent = new org.jdesktop.swingx.JXButton();
        btnViewRentDetails = new org.jdesktop.swingx.JXButton();
        jLabel9 = new javax.swing.JLabel();
        txtadvanceFee = new org.jdesktop.swingx.JXTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMonthlyRent = new org.jdesktop.swingx.JXTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRentHouse = new org.jdesktop.swingx.JXTable();
        btnRefresh = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
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
        btnClearFields.setToolTipText("Click to Clear Fields");
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
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 0, -1, 744));

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
        jLabel7.setText("No of rooms");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, 130, 37));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("No of bathrooms");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 181, -1, 37));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Address");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 293, 137, 37));

        txtNoOfRooms.setToolTipText("No of rooms");
        txtNoOfRooms.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNoOfRooms.setPrompt("No of rooms");
        txtNoOfRooms.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtNoOfRoomsInputMethodTextChanged(evt);
            }
        });
        txtNoOfRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfRoomsActionPerformed(evt);
            }
        });
        txtNoOfRooms.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNoOfRoomsPropertyChange(evt);
            }
        });
        txtNoOfRooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoOfRoomsKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoOfRoomsKeyTyped(evt);
            }
        });
        jPanel1.add(txtNoOfRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 124, 170, 30));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Cancel 2_20px.png"))); // NOI18N
        btnCancel.setToolTipText("Click to clear fields");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 619, 48, 30));

        txtNoOfBathRooms.setToolTipText("No of Bathrooms");
        txtNoOfBathRooms.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNoOfBathRooms.setPrompt("No of bahrooms");
        txtNoOfBathRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfBathRoomsActionPerformed(evt);
            }
        });
        txtNoOfBathRooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoOfBathRoomsKeyPressed(evt);
            }
        });
        jPanel1.add(txtNoOfBathRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 184, 170, 30));

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAddress.setPrompt("Address");
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressKeyPressed(evt);
            }
        });
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 296, 170, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("No of story");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, -1, 37));

        txtNoOfStory.setToolTipText("No of Story");
        txtNoOfStory.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNoOfStory.setPrompt("No of story");
        txtNoOfStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfStoryActionPerformed(evt);
            }
        });
        txtNoOfStory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoOfStoryKeyPressed(evt);
            }
        });
        jPanel1.add(txtNoOfStory, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 239, 170, 30));

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
        jPanel1.add(btnAddRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 150, 32));

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
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 137, 37));

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
        jPanel1.add(txtadvanceFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 170, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Monthly Rent");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 137, 37));

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
        jPanel1.add(txtMonthlyRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 170, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 18, 325, 655));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("View Rent Houses");

        tblRentHouse.setForeground(new java.awt.Color(51, 51, 51));
        tblRentHouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No of rooms", "No of bathrooms", "No of story", "Address", "Advance fee", "Monthly Rent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRentHouse.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane3.setViewportView(tblRentHouse);

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Spinner Frame 3_20px.png"))); // NOI18N
        btnRefresh.setToolTipText("Click to refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        cmbType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Available", "Rented" }));
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

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, 655));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        if (selectedAddress == null) {
            JOptionPane.showMessageDialog(this, "Select a Rent House First");
            return;
        }
        int n = JOptionPane.showConfirmDialog(
                this, "Confirm deletion?",
                "An Inane Question",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            RentHouseDTO rentHouse = RentHouseController.searchByAddress(selectedAddress);

            try {
                boolean result = RentHouseController.deleteRentHouse(rentHouse);

                if (result) {
                    JOptionPane.showMessageDialog(this, "RentHouse has been successfully removed");
                    btnRefreshActionPerformed(evt);
                    clearAllTexts();
                } else {
                    JOptionPane.showMessageDialog(this, "RentHouse hasn't been removed");
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
        if (fieldsUpdated == false) {
            JOptionPane.showMessageDialog(this, "No change found");
            return;
        }

        try {
            RentHouseDTO rentHouse = RentHouseController.searchByAddress(selectedAddress);
            rentHouse.setNo_of_rooms(Integer.parseInt(txtNoOfRooms.getText()));
            rentHouse.setNo_of_bathrooms(Integer.parseInt(txtNoOfBathRooms.getText()));
            rentHouse.setNo_of_story(Integer.parseInt(txtNoOfStory.getText()));
            rentHouse.setAddress(txtAddress.getText());

            PropertyDTO property = new PropertyDTO(
                    rentHouse.getProperty_id(),
                    PropertyController.checkAvailability(rentHouse.getProperty_id()),
                    Double.parseDouble(txtadvanceFee.getText()),
                    Double.parseDouble(txtMonthlyRent.getText())
            );

            try {

                boolean result = RentHouseController.updateRentHouse(rentHouse, property);

                if (result) {
                    JOptionPane.showMessageDialog(this, "RentHouse details has been successfully updated");
                    btnRefreshActionPerformed(evt);
                    clearAllTexts();
                } else {
                    JOptionPane.showMessageDialog(this, "RentHouse details hasn't been updated");
                }

            } catch (Exception ex) {
                Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(darkGreen);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (checkText() == false) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);

            JOptionPane.showMessageDialog(this, "All fields should be filled to save");
            return;
        }
        RentHouseDTO rentHouse = new RentHouseDTO(
                getID(),
                Integer.parseInt(txtNoOfRooms.getText()),
                Integer.parseInt(txtNoOfBathRooms.getText()),
                Integer.parseInt(txtNoOfStory.getText()),
                txtAddress.getText()
        );

        PropertyDTO property = new PropertyDTO(
                getID(),
                true,
                Double.parseDouble(txtadvanceFee.getText()),
                Double.parseDouble(txtMonthlyRent.getText())
        );

        try {
            boolean result = RentHouseController.addRentHouse(rentHouse, property);
            if (result) {
                JOptionPane.showMessageDialog(this, "RentHouse has been successfully added");
                btnRefreshActionPerformed(evt);
                clearAllTexts();
            } else {
                JOptionPane.showMessageDialog(this, "RentHouse hasn't been added");
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            }
            System.out.println("Ststae changed");
            btnRefreshActionPerformed(null);

        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTypeItemStateChanged

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        //  getCID.requestFocus();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void txtNoOfBathRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfBathRoomsActionPerformed
        txtNoOfStory.requestFocus();
    }//GEN-LAST:event_txtNoOfBathRoomsActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearAllTexts();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtNoOfRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfRoomsActionPerformed
        txtNoOfBathRooms.requestFocus();
    }//GEN-LAST:event_txtNoOfRoomsActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtNoOfStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfStoryActionPerformed
        txtAddress.requestFocus();
    }//GEN-LAST:event_txtNoOfStoryActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) tblRentHouse.getModel();
        try {
            ArrayList<RentHouseDTO> allRentHouses = RentHouseController.getAllRentHouses();
            if (type == 1) {
                allRentHouses = RentHouseController.searchAvailable();
            } else if (type == 2) {
                allRentHouses = RentHouseController.searchRented();
            }
            if (allRentHouses != null) {

                dtm.setRowCount(0);

                for (RentHouseDTO rentHouse : allRentHouses) {
                    PropertyDTO property = new PropertyDTO(rentHouse.getProperty_id(), null, null, null);
                    property = PropertyController.searchProperty(property);
                    Object[] rowData = {rentHouse.getNo_of_rooms(),
                        rentHouse.getNo_of_bathrooms(),
                        rentHouse.getNo_of_story(),
                        rentHouse.getAddress(),
                        property.getAdvance_fee(),
                        property.getMonthly_rent()
                    };

                    dtm.addRow(rowData);

                }

            } else {
                dtm.setRowCount(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtNoOfRoomsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNoOfRoomsPropertyChange

    }//GEN-LAST:event_txtNoOfRoomsPropertyChange

    private void txtNoOfRoomsInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtNoOfRoomsInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfRoomsInputMethodTextChanged

    private void txtNoOfRoomsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfRoomsKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfRoomsKeyTyped

    private void txtNoOfRoomsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfRoomsKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtNoOfRoomsKeyPressed

    private void txtNoOfBathRoomsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfBathRoomsKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtNoOfBathRoomsKeyPressed

    private void txtNoOfStoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfStoryKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtNoOfStoryKeyPressed

    private void txtAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyPressed
        fieldsUpdated = true;
    }//GEN-LAST:event_txtAddressKeyPressed

    private void btnViewRentDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRentDetailsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRentDetailsMouseEntered

    private void btnViewRentDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRentDetailsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRentDetailsMouseExited

    private void btnViewRentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRentDetailsActionPerformed
        if (selectedAddress == null) {
            JOptionPane.showMessageDialog(this, "Select a Rent House First");
            return;
        }
        try {
            RentHouseDTO rentHouse = RentHouseController.searchByAddress(selectedAddress);
            PropertyDTO property = new PropertyDTO(rentHouse.getProperty_id(), null, null, null);
            property = PropertyController.searchProperty(property);
            new DialogViewRentDetails(DashBoard.dashBoard, true, new PanelRent(property)).setVisible(true);
            //btnGoToItem.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnViewRentDetailsActionPerformed

    private void btnAddRentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRentMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRentMouseExited

    private void btnAddRentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddRentMouseEntered

    private void btnAddRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRentActionPerformed
        if (selectedAddress == null) {
            JOptionPane.showMessageDialog(this, "Select a Rent House First");
            return;
        }
        try {
            RentHouseDTO rentHouse = RentHouseController.searchByAddress(selectedAddress);
            PropertyDTO property = new PropertyDTO(rentHouse.getProperty_id(), null, null, null);
            property = PropertyController.searchProperty(property);
            new DialogRennt(DashBoard.dashBoard, true, property).setVisible(true);
            //btnGoToItem.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void btnClearFieldsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearFieldsMouseExited
        btnRemove.setBackground(darkGreen);
    }//GEN-LAST:event_btnClearFieldsMouseExited

    private void btnClearFieldsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearFieldsMouseEntered
        btnRemove.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnClearFieldsMouseEntered

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        selectedAddress = null;
        clearAllTexts();
        btnAddRent.setVisible(false);
        btnViewRentDetails.setVisible(false);
    }//GEN-LAST:event_btnClearFieldsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAdd;
    private org.jdesktop.swingx.JXButton btnAddRent;
    private javax.swing.JButton btnCancel;
    private org.jdesktop.swingx.JXButton btnClearFields;
    private javax.swing.JButton btnRefresh;
    private org.jdesktop.swingx.JXButton btnRemove;
    private org.jdesktop.swingx.JXButton btnUpdate;
    private org.jdesktop.swingx.JXButton btnViewRentDetails;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable tblRentHouse;
    private org.jdesktop.swingx.JXTextField txtAddress;
    private org.jdesktop.swingx.JXTextField txtMonthlyRent;
    private org.jdesktop.swingx.JXTextField txtNoOfBathRooms;
    private org.jdesktop.swingx.JXTextField txtNoOfRooms;
    private org.jdesktop.swingx.JXTextField txtNoOfStory;
    private org.jdesktop.swingx.JXTextField txtadvanceFee;
    // End of variables declaration//GEN-END:variables
}
