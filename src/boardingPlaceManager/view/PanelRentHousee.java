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
import boardingPlaceManager.controller.RentHouseController;
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

                txtNoOfRooms.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 0).toString());
                txtNoOfBathRooms.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 1).toString());
                txtNoOfStory.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 2).toString());
                txtAddress.setText(tblRentHouse.getValueAt(tblRentHouse.getSelectedRow(), 3).toString());

                selectedAddress = txtAddress.getText();
                try {
                    RentHouseDTO rentHouse = RentHouseController.searchByAddress(selectedAddress);
                    Boolean availability = RentHouseController.checkAvailability(rentHouse.getProperty_id());
                    System.out.println(availability+",,,,,,,");
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
        if (txtAddress.getText().isEmpty() && txtNoOfBathRooms.getText().isEmpty() && txtNoOfRooms.getText().isEmpty() && txtNoOfStory.getText().isEmpty()) {
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
        btnAdd1 = new org.jdesktop.swingx.JXButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRentHouse = new org.jdesktop.swingx.JXTable();
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
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

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("No of rooms");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("No of bathrooms");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Address");

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

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Cancel 2_20px.png"))); // NOI18N
        btnCancel.setToolTipText("Click to clear fields");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

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

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("No of story");

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

        btnAdd1.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Plus_20px_1.png"))); // NOI18N
        btnAdd1.setText("Rent ");
        btnAdd1.setToolTipText("Click to add");
        btnAdd1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdd1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdd1MouseExited(evt);
            }
        });
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoOfStory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNoOfBathRooms, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtNoOfRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoOfRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoOfBathRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoOfStory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("View Rent Houses");

        tblRentHouse.setForeground(new java.awt.Color(51, 51, 51));
        tblRentHouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No of rooms", "No of bathrooms", "No of story", "Address"
            }
        ));
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
                        .addGap(119, 119, 119)
                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

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

            try {

                boolean result = RentHouseController.updateRentHouse(rentHouse);

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

        if (!checkText()) {
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

        try {
            boolean result = RentHouseController.addRentHouse(rentHouse);
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
        try {
            ArrayList<RentHouseDTO> allRentHouses = RentHouseController.getAllRentHouses();
            if (type == 1) {
                allRentHouses = RentHouseController.searchAvailable();
            } else if (type == 2) {
                allRentHouses = RentHouseController.searchRented();
            }
            if (allRentHouses != null) {
                DefaultTableModel dtm = (DefaultTableModel) tblRentHouse.getModel();

                dtm.setRowCount(0);

                for (RentHouseDTO rentHouse : allRentHouses) {

                    Object[] rowData = {rentHouse.getNo_of_rooms(),
                        rentHouse.getNo_of_bathrooms(),
                        rentHouse.getNo_of_story(),
                        rentHouse.getAddress()};

                    dtm.addRow(rowData);

                }

            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtNoOfRoomsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNoOfRoomsPropertyChange
        System.out.print("Hy");
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

    private void btnAdd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1MouseEntered

    private void btnAdd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1MouseExited

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAdd;
    private org.jdesktop.swingx.JXButton btnAdd1;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private org.jdesktop.swingx.JXButton btnRemove;
    private org.jdesktop.swingx.JXButton btnUpdate;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable tblRentHouse;
    private org.jdesktop.swingx.JXTextField txtAddress;
    private org.jdesktop.swingx.JXTextField txtNoOfBathRooms;
    private org.jdesktop.swingx.JXTextField txtNoOfRooms;
    private org.jdesktop.swingx.JXTextField txtNoOfStory;
    // End of variables declaration//GEN-END:variables
}
