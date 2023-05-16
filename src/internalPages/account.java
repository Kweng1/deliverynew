/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.dbconnector;
import java.sql.ResultSet;
import javax.swing.*;
import java.io.*;
import java.awt.Image;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class account extends javax.swing.JInternalFrame {
private Connection con;
    /**
     * Creates new form account
     */
    public account() {
        initComponents();
        displayData();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    } 
    public void displayData(){
         try {
              dbconnector dbc = new dbconnector();
              ResultSet rs = dbc.getData("SELECT f_name as 'First Name', l_name as 'Last Name', email as 'Email', user_name as 'Username', sta_tus as 'Status' FROM `user_db` ");
              acc_tbl.setModel(DbUtils.resultSetToTableModel( rs));
        
         
         
         }
         catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
        }
    }
     public void update(){
         try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery","root","");
         int row =acc_tbl.getSelectedRow();
         String value = (acc_tbl.getModel().getValueAt(row, 0).toString());
         String sql = "UPDATE user_db SET f_name=?,l-name=?, email=?, user_name=?"+value;
            PreparedStatement pst = con.prepareStatement(sql);
           
            pst.setString(1, namf.getText());
            pst.setString(2, naml.getText());
            pst.setString(3, eml.getText());
            pst.setString(4, username.getText());
           ;
            pst.executeUpdate();
           if(row == 0){
            JOptionPane.showMessageDialog(null, "Updated FAILED!");
        }else{
           JOptionPane.showMessageDialog(null, "Updated Successfully!");
           displayData();
           
        }
         } catch (Exception e) {
             e.printStackTrace();
         }
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
        UPD = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        username = new javax.swing.JTextField();
        naml = new javax.swing.JTextField();
        eml = new javax.swing.JTextField();
        namf = new javax.swing.JTextField();
        stat = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        acc_tbl = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(222, 184, 135));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UPD.setBackground(new java.awt.Color(255, 230, 179));
        UPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UPDMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("UPDATE DATA");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout UPDLayout = new javax.swing.GroupLayout(UPD);
        UPD.setLayout(UPDLayout);
        UPDLayout.setHorizontalGroup(
            UPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        UPDLayout.setVerticalGroup(
            UPDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(UPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 120, 30));

        jPanel2.setBackground(new java.awt.Color(255, 238, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Status:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 50, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("First Name:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 60, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Last Name:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 20));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Email:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setText("Username:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 70, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("ACCOUNT SETTINGS");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Change your profile and account settings");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 590, 20));

        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 130, 20));

        naml.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        naml.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(naml, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, 20));

        eml.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eml.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(eml, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 130, 20));

        namf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        namf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(namf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 130, 20));

        stat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 130, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 160));

        acc_tbl.setBackground(new java.awt.Color(255, 230, 204));
        acc_tbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        acc_tbl.setGridColor(new java.awt.Color(255, 153, 153));
        acc_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc_tblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(acc_tbl);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 690, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acc_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc_tblMouseClicked
         int rowIndex = acc_tbl.getSelectedRow();
         
      if(rowIndex < 0){
          
      }else{
          TableModel model = acc_tbl.getModel();
          namf.setText(""+model.getValueAt(rowIndex, 0));
          naml.setText(""+model.getValueAt(rowIndex, 1));
          eml.setText(""+model.getValueAt(rowIndex, 2));
          
          username.setText(""+model.getValueAt(rowIndex, 3));
          stat.setText(""+model.getValueAt(rowIndex, 4));
         
         
         

          
          
      }
       
    }//GEN-LAST:event_acc_tblMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

    }//GEN-LAST:event_jLabel10MouseClicked
     public boolean validation(){
  String name= naml.getText();
String psam= namf.getText();
String pmed= eml.getText();
String pla= username.getText();
    return false;

     }
    private void UPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UPDMouseClicked
        if(validation()== true){
     update();
        }
    }//GEN-LAST:event_UPDMouseClicked
         



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UPD;
    private javax.swing.JTable acc_tbl;
    private javax.swing.JTextField eml;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField namf;
    private javax.swing.JTextField naml;
    private javax.swing.JTextField stat;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    public void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

    
    
    
}
