/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardingPlaceManager.view;

import boardingPlaceManager.common.IDGenarator;
import boardingPlaceManager.controller.BoadereController;
import boardingPlaceManager.controller.PaymentController;
import boardingPlaceManager.controller.RentController;
import boardingPlaceManager.dto.BoadereDTO;
import boardingPlaceManager.dto.PaymentDTO;
import boardingPlaceManager.dto.PropertyDTO;
import boardingPlaceManager.dto.RentDTO;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.text.SimpleDateFormat;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import static java.util.concurrent.TimeUnit.DAYS;

/**
 *
 * @author User
 */
public class DialogRennt extends javax.swing.JDialog {

    /**
     * Creates new form DialogBoadereInOrders
     */
    public BoadereDTO boadere = null;
    public PropertyDTO property = null;

    public DialogRennt(java.awt.Frame parent, boolean modal, PropertyDTO property) throws Exception {
        super(parent, modal);
        // super(parent, modal);
        initComponents();
        setDefaultCloseOperation(2);
        //setLocationRelativeTo(null);
        loadAllBoaderes();
        this.property = property;
        setFees(property);
        btnRefreshActionPerformed(null);

        tblBoaders.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (tblBoaders.getSelectedRow() == -1) {
                    return;
                }

                cmbBoadereNames.setSelectedItem(tblBoaders.getValueAt(tblBoaders.getSelectedRow(), 1).toString());

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

    }

    public String getID() {
        String newID;

        try {
            newID = IDGenarator.getNewID("rent", "rent_id", "r");
            return newID;
        } catch (SQLException ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkFields(String rent_id) {
        if (txtAdvanceFee.getText().isEmpty() || txtMonthlyFee.getText().isEmpty() || rent_id == null || property.getProperty_id() == null || boadere.getNic() == null || datePickerFromDate.getDate() == null || datePickerToDate.getDate() == null) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbBoadereNames = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBoaders = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMonthlyFee = new org.jdesktop.swingx.JXTextField();
        txtAdvanceFee = new org.jdesktop.swingx.JXTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAdd = new org.jdesktop.swingx.JXButton();
        datePickerToDate = new org.jdesktop.swingx.JXDatePicker();
        datePickerFromDate = new org.jdesktop.swingx.JXDatePicker();
        chkAdvancePayments = new javax.swing.JCheckBox();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("House Rent Details -");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 258, 34));

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
        jPanel1.add(cmbBoadereNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 63, 108, -1));

        tblBoaders.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBoaders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIC", "Name", "Tel No", "Address"
            }
        ));
        jScrollPane1.setViewportView(tblBoaders);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 109, 1092, 293));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Plus_20px_1.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 64, 42, 27));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Monthly Fee");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 413, 130, 37));

        txtMonthlyFee.setToolTipText("Monthly Fee");
        txtMonthlyFee.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMonthlyFee.setPrompt("Monthly Fee");
        txtMonthlyFee.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtMonthlyFeeInputMethodTextChanged(evt);
            }
        });
        txtMonthlyFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonthlyFeeActionPerformed(evt);
            }
        });
        txtMonthlyFee.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtMonthlyFeePropertyChange(evt);
            }
        });
        txtMonthlyFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMonthlyFeeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMonthlyFeeKeyTyped(evt);
            }
        });
        jPanel1.add(txtMonthlyFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 416, 170, 30));

        txtAdvanceFee.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAdvanceFee.setPrompt("Advance Fee");
        txtAdvanceFee.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtAdvanceFeeInputMethodTextChanged(evt);
            }
        });
        txtAdvanceFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdvanceFeeActionPerformed(evt);
            }
        });
        txtAdvanceFee.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtAdvanceFeePropertyChange(evt);
            }
        });
        txtAdvanceFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdvanceFeeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdvanceFeeKeyTyped(evt);
            }
        });
        jPanel1.add(txtAdvanceFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 459, 170, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Advance Fee");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 456, 130, 37));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("From Date");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 416, 130, 37));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("To Date");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 459, 130, 37));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Boardere");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 66, 130, -1));

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
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 522, 137, -1));
        jPanel1.add(datePickerToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 469, 120, -1));

        datePickerFromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerFromDateActionPerformed(evt);
            }
        });
        jPanel1.add(datePickerFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 426, 120, -1));

        chkAdvancePayments.setText("Advance Paid");
        jPanel1.add(chkAdvancePayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, -1));

        btnRefresh.setBackground(new java.awt.Color(204, 204, 204));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardingPlaceManager/icons/Available Updates_20px.png"))); // NOI18N
        btnRefresh.setToolTipText("To Reload Table");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1089, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(229, 229, 229))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            ArrayList<BoadereDTO> allBoaderes = BoadereController.getAllBoaderes();

            DefaultTableModel dtm = (DefaultTableModel) tblBoaders.getModel();

            dtm.setRowCount(0);

            for (BoadereDTO boadere : allBoaderes) {

                Object[] rowData = {boadere.getNic(),
                    boadere.getName(),
                    boadere.getTel(),
                    boadere.getAddress()
                };

                dtm.addRow(rowData);

            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cmbBoadereNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBoadereNamesItemStateChanged
        try {
            if (cmbBoadereNames.getSelectedIndex() == -1) {
                return;
            }

            boadere = BoadereController.searchBoadereByName(new BoadereDTO(null, cmbBoadereNames.getSelectedItem().toString(), null, null));

            if (boadere == null) {
                return;
            }

            DefaultTableModel dtm = (DefaultTableModel) tblBoaders.getModel();
            dtm.setRowCount(0);
            Object[] rowData = {boadere.getNic(),
                boadere.getName(),
                boadere.getTel(),
                boadere.getAddress()};

            dtm.addRow(rowData);

            /*itemDescriptionText.setText(item.getDescription());
            qtyOnHandText.setText(item.getQtyOnHand() + "");
            itemPriceText.setText(item.getUnitPrice().toPlainString());*/
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbBoadereNamesItemStateChanged

    private void cmbBoadereNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoadereNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBoadereNamesActionPerformed

    private void txtMonthlyFeeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtMonthlyFeeInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthlyFeeInputMethodTextChanged

    private void txtMonthlyFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonthlyFeeActionPerformed
        //txtNoOfBathRooms.requestFocus();
    }//GEN-LAST:event_txtMonthlyFeeActionPerformed

    private void txtMonthlyFeePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtMonthlyFeePropertyChange

    }//GEN-LAST:event_txtMonthlyFeePropertyChange

    private void txtMonthlyFeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonthlyFeeKeyPressed
        //fieldsUpdated = true;
    }//GEN-LAST:event_txtMonthlyFeeKeyPressed

    private void txtMonthlyFeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonthlyFeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonthlyFeeKeyTyped

    private void txtAdvanceFeeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtAdvanceFeeInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceFeeInputMethodTextChanged

    private void txtAdvanceFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdvanceFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceFeeActionPerformed

    private void txtAdvanceFeePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtAdvanceFeePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceFeePropertyChange

    private void txtAdvanceFeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdvanceFeeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceFeeKeyPressed

    private void txtAdvanceFeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdvanceFeeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceFeeKeyTyped

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        //btnAdd.setBackground(darkGreen);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        // btnAdd.setBackground(Color.lightGray);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (datePickerFromDate.getDate().after(datePickerToDate.getDate())) {
            JOptionPane.showMessageDialog(this, "To Date should be a date after from date");
            return;
        }

        String rent_id = getID();
        RentDTO rent = new RentDTO(rent_id, property.getProperty_id(), boadere.getNic(), datePickerFromDate.getDate(), datePickerToDate.getDate(), Double.parseDouble(txtMonthlyFee.getText()), Double.parseDouble(txtAdvanceFee.getText()));

        if (checkFields(rent_id) == false) {
            JOptionPane.showMessageDialog(this, "Can't add rent. All fields are required");
        }

        ArrayList<PaymentDTO> payments = new ArrayList<>();
        Date rentedDate = rent.getFrom_date();

        Calendar c = new GregorianCalendar(rentedDate.getYear(), rentedDate.getMonth(), rentedDate.getDate());
        Calendar temp = new GregorianCalendar(rentedDate.getYear(), rentedDate.getMonth(), rentedDate.getDate());
        int i = 1;
        boolean flag = true;
        //String pid = getPaymentID();

        if (chkAdvancePayments.isSelected() == true) {
            payments.add(new PaymentDTO(0, rent_id, rent.getFrom_date(), rent.getFrom_date(), "Advance Payment", rent.getAdvance_fee(),rent.getAdvance_fee()));
        }
        //payments.add(new PaymentDTO(null, rent_id, rent.getFrom_date(), null, "Advance Payment", rent.getAdvance_fee(),0.0));
        while (flag) {
            try {
                c.add(Calendar.MONTH, i);
                temp.add(Calendar.MONTH, (i - 1));

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                Date selectedDate = new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
                String dateString = dateFormat.format(selectedDate);
                Date dueDate = dateFormat.parse(dateString); //date after a month

                Date tempDate = new Date(temp.get(Calendar.YEAR), temp.get(Calendar.MONTH), temp.get(Calendar.DATE));
                String tempDateString = dateFormat.format(tempDate);
                Date dueTempDate = dateFormat.parse(tempDateString); //date before a month

                long difference = (rent.getTo_date().getTime() - dueTempDate.getTime());
                float diff = (difference / (1000 * 60 * 60 * 24));

                //long diff1 = Math.round((rent.getTo_date().getTime() - dueTempDate.getTime()) / (double) 86400000);
                //System.out.println("Last" + rent.getTo_date() + "Temp" + dueTempDate + "     " + dueDate + ":" + diff);
                if (diff >= 28) {
                    payments.add(new PaymentDTO(0, rent_id, dueDate, null, "Monthly Payment", 0.0,0.0));
                } else {
                    c.add(Calendar.MONTH, -1);
                    temp.add(Calendar.MONTH, -1);

                    Date selectedDate2 = new Date(temp.get(Calendar.YEAR), temp.get(Calendar.MONTH), temp.get(Calendar.DATE));
                    String dateString2 = dateFormat.format(selectedDate2);
                    Date dueDate2 = dateFormat.parse(dateString2);
                    Double payment = rent.getMonthly_rent() * (diff / 30);
                    if (payment >= 1000) {
                        payments.add(new PaymentDTO(0, rent_id, rent.getTo_date(), null, "Monthly Payment", payment,0.0));
                    }
                    flag = false;
                }
                c = new GregorianCalendar(rentedDate.getYear(), rentedDate.getMonth(), rentedDate.getDate());
                temp = new GregorianCalendar(rentedDate.getYear(), rentedDate.getMonth(), rentedDate.getDate());

                // System.out.println("New c:" + c + "    +temp:" + temp);
                i++;

            } catch (ParseException ex) {
                Logger.getLogger(DialogRennt.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        try {
            boolean result = RentController.addRent(rent);
            if (result) {
                System.out.println(payments);
                PaymentController.addPayments(payments);
                JOptionPane.showMessageDialog(this, "Rent has been successfully added");
                btnRefreshActionPerformed(evt);
                //clearAllTexts();
            } else {
                JOptionPane.showMessageDialog(this, "Rent hasn't been added");
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelRentHousee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void datePickerFromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerFromDateActionPerformed
        // System.out.println(datePickerFromDate.getDate());
    }//GEN-LAST:event_datePickerFromDateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogRennt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogRennt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogRennt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogRennt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DialogRennt dialog = new DialogRennt(new javax.swing.JFrame(), true, null);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(DialogRennt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btnAdd;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JCheckBox chkAdvancePayments;
    private javax.swing.JComboBox<String> cmbBoadereNames;
    private org.jdesktop.swingx.JXDatePicker datePickerFromDate;
    private org.jdesktop.swingx.JXDatePicker datePickerToDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBoaders;
    private org.jdesktop.swingx.JXTextField txtAdvanceFee;
    private org.jdesktop.swingx.JXTextField txtMonthlyFee;
    // End of variables declaration//GEN-END:variables

    private void setFees(PropertyDTO property) {
        txtAdvanceFee.setText(property.getAdvance_fee().toString());
        txtMonthlyFee.setText(property.getMonthly_rent().toString());
    }
}
