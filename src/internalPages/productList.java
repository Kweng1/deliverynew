/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.dbconnector;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.io.*;
import static java.lang.String.format;
import javax.swing.*;


/**
 *
 * @author admin
 */
public class productList extends javax.swing.JInternalFrame {

    
    public byte[] imageBytes;
    String path;
    String action;
    String filename=null;
    String imgPath = null;
   byte[] person_image = null; 
DefaultTableModel model;
private Connection con;
    
    public productList() {
        initComponents();
        displayData();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
       
    }
    public void displayData(){
       
        try{
       
            dbconnector dbc = new dbconnector();
            ResultSet rs = dbc.getData("SELECT p_id as 'Product ID', p_name as 'Product Name', p_small as 'Small', p_medium as 'Medium', p_large as 'Large' FROM product_tbl");
           
            pr_table.setModel(DbUtils.resultSetToTableModel(rs));
       
        }catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
        }
    }
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(picv.getWidth(), picv.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}


    
    public void reset(){
        
       
        pname.setText("");
        ps.setText("");
        pm.setText("");
        pid.setText("");
         pl.setText("");
         picv.setIcon(null);
        
        
    }
         public boolean validation(){
  String name= pname.getText();
String psam= ps.getText();
String pmed= pm.getText();
String pla= pl.getText();

 if (name.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER NAME");
 return false;
 }
 if(psam.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER THE PRICE OF SMALL PRODUCT");
 return false;
 }
if(pmed.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER THE PRICE OF MEDIUM PRODUCT");
 return false;
 }     
 if(pla.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER THE PRICE OF MEDIUM PRODUCT");
 return false;
 }    
  
    if(picv.getIcon()==null){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER PHOTO");
 return false;
 }
   return true;  
 }
    
     public void add(){
      try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery","root","");
            String sql = "INSERT INTO product_tbl  ( p_name, p_small, p_medium , p_large, img_pc) VALUES (?,?,?,?,?)"; 
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, pname.getText());
            pst.setString(2, ps.getText());
            pst.setString(3, pm.getText());
            pst.setString(4, pl.getText());
            pst.setBytes(5, pic);
            pst.executeUpdate();
           
            displayData();
               reset(); 
        JOptionPane.showMessageDialog(this, "ADDED SUCCESSFULLY");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }
     
     }
    public void update(){
         try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery","root","");
         int row =pr_table.getSelectedRow();
         String value = (pr_table.getModel().getValueAt(row, 0).toString());
         String sql = "UPDATE product_tbl SET p_name=?, p_small=?, p_medium=?, p_large=?, img_pc=? where p_id="+value;
            PreparedStatement pst = con.prepareStatement(sql);
           
            pst.setString(1, pname.getText());
            pst.setString(2, ps.getText());
            pst.setString(3, pm.getText());
            pst.setString(4, pl.getText());
            pst.setBytes(5, pic);
            pst.executeUpdate();
           if(row == 0){
            JOptionPane.showMessageDialog(null, "Updated FAILED!");
        }else{
           JOptionPane.showMessageDialog(null, "Updated Successfully!");
           displayData();
           reset();
        }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     public void upload(){
     JFileChooser chose = new JFileChooser();
     chose.showOpenDialog(null);
     File f = chose.getSelectedFile();
         filename = f.getAbsolutePath();
         ImageIcon ii = new ImageIcon(filename);
         Image img = ii.getImage().getScaledInstance(picv.getWidth(), picv.getHeight(), Image.SCALE_SMOOTH);
     picv.setIcon(new ImageIcon(img));
         try {
             File ig = new File(filename);
             FileInputStream is = new FileInputStream(ig);
             ByteArrayOutputStream bos =  new ByteArrayOutputStream();
             byte[] buf = new byte [1024];
             for (int rnum; (rnum = is.read(buf))!=-1;){
             bos.write(buf, 0, rnum);
             }
             pic =bos.toByteArray();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
          
    }
      public void table(){
     int row = pr_table.getSelectedRow();
     int cc = pr_table.getSelectedColumn();
     String tc = pr_table.getModel().getValueAt(row, 0).toString();
             try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery","root","");
             String sql = "select * from product_tbl where p_id="+tc+"";
             PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            int id=rs.getInt("p_id");
            String name=rs.getString("p_name");
            String sm=rs.getString("p_small");
            String med=rs.getString("p_medium");
            String lr=rs.getString("p_large");
            
            byte[] img = rs.getBytes("img_pc");
            format = new ImageIcon(img);
            Image im =format.getImage().getScaledInstance(picv.getWidth(), picv.getHeight(), Image.SCALE_SMOOTH);
            picv.setIcon(new ImageIcon(im));
            
            
                pid.setText(""+id);
                pname.setText(name);
                ps.setText(sm);
                pl.setText(lr);
                pm.setText(med);
                
                
         
            }
             pst.close();
             rs.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
         }
        }
     
    
     Color navcolor= new Color(217,222,135);
    Color headcolor= new Color(222,140,135);
    Color bodycolor = new Color(222,184,135);
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pr_table = new javax.swing.JTable();
        delete = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pm = new javax.swing.JTextField();
        pname = new javax.swing.JTextField();
        clear = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        print = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ps = new javax.swing.JTextField();
        refresh = new javax.swing.JPanel();
        REFRESH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        pl = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        add = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        picv = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(736, 436));

        jPanel1.setBackground(new java.awt.Color(222, 184, 135));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCT LIST");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 720, 30));

        update.setBackground(new java.awt.Color(222, 140, 135));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(222, 141, 135));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("UPDATE");
        update.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 80, 30));

        pr_table.setBackground(new java.awt.Color(255, 230, 204));
        pr_table.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pr_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pr_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pr_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 360, 180));

        delete.setBackground(new java.awt.Color(222, 140, 135));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(222, 141, 135));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DELETE");
        delete.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 80, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("MEDIUM:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 40, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("SMALL:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 30));

        pm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pmKeyPressed(evt);
            }
        });
        jPanel1.add(pm, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 220, 30));

        pname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 220, 30));

        clear.setBackground(new java.awt.Color(222, 140, 135));
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearMouseExited(evt);
            }
        });
        clear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(222, 141, 135));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CLEAR");
        clear.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 80, 30));

        print.setBackground(new java.awt.Color(222, 140, 135));
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printMouseExited(evt);
            }
        });
        print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRINT");
        print.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 80, 30));

        ps.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ps.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        ps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psKeyPressed(evt);
            }
        });
        jPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 220, 30));

        refresh.setBackground(new java.awt.Color(222, 140, 135));
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshMouseExited(evt);
            }
        });
        refresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        REFRESH.setBackground(new java.awt.Color(153, 153, 153));
        REFRESH.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        REFRESH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REFRESH.setText("REFRESH");
        refresh.add(REFRESH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 80, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Name: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 30));

        pid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 220, 30));

        pl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plActionPerformed(evt);
            }
        });
        pl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                plKeyPressed(evt);
            }
        });
        jPanel1.add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 220, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("LARGE:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 80, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 700, 10));

        add.setBackground(new java.awt.Color(222, 140, 135));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(222, 141, 135));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADD");
        add.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 80, 30));

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 80, 30));

        picv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picv, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 150, 130));

        btnImage.setText("BROWSE");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });
        jPanel1.add(btnImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseExited
          clear.setBackground(headcolor);
    }//GEN-LAST:event_clearMouseExited

    private void clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseEntered
         clear.setBackground(navcolor);
    }//GEN-LAST:event_clearMouseEntered

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        
         pname.setText(null);
         pm.setText(null);        
         pid.setText(null);
         ps.setText(null);
         pl.setText(null);
         picv.setIcon(null);
            
    }//GEN-LAST:event_clearMouseClicked

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        delete.setBackground(headcolor);
    }//GEN-LAST:event_deleteMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        delete.setBackground(navcolor);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
       int rowIndex = pr_table.getSelectedRow();
       if(rowIndex < 0){
           JOptionPane.showMessageDialog(null, "Please select a data first");
       }else{
            TableModel model = pr_table.getModel();
            Object value = model.getValueAt(rowIndex, 0);
            String id = value.toString();
             int a=JOptionPane.showConfirmDialog(null,"Are you sure?");  
                    if(a==JOptionPane.YES_OPTION){  
                            dbconnector dbc = new dbconnector();
                            int cid = Integer.parseInt(id);
                            dbc.deleteData(cid,"product_tbl","p_id");
                            displayData();
                            reset();
                    }    
       }
    }//GEN-LAST:event_deleteMouseClicked

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        update.setBackground(headcolor);
    }//GEN-LAST:event_updateMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        update.setBackground(navcolor);
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
         if(validation()== true){
     update();
        }
    }//GEN-LAST:event_updateMouseClicked

    private void pr_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pr_tableMouseClicked
      table();
    }//GEN-LAST:event_pr_tableMouseClicked

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        MessageFormat header = new MessageFormat("Customer Order");
       MessageFormat footer = new MessageFormat("Page {0, number,integer}");
       
       try
       {
           pr_table.print(JTable.PrintMode.NORMAL,header,footer);
       }
       
       catch(java.awt.print.PrinterException e)
       {
           System.err.format("No Printer found", e.getMessage());
       }
    }//GEN-LAST:event_printMouseClicked

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered
        print.setBackground(navcolor);
    }//GEN-LAST:event_printMouseEntered
       
    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited
        print.setBackground(headcolor);
    }//GEN-LAST:event_printMouseExited

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
         table();
    
    
    }//GEN-LAST:event_refreshMouseClicked

    private void refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseEntered
       refresh.setBackground(navcolor);
    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited
       refresh.setBackground(headcolor);

    }//GEN-LAST:event_refreshMouseExited

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
     if (validation () == true){
         add();
     }
    }//GEN-LAST:event_addMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(navcolor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(headcolor);
    }//GEN-LAST:event_addMouseExited

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
      upload();
    }//GEN-LAST:event_btnImageActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        
    }//GEN-LAST:event_psActionPerformed

    private void psKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psKeyPressed
         char c = evt.getKeyChar();
        if(Character.isLetter(c)){
        ps.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        ps.setEditable(true);
        }
    }//GEN-LAST:event_psKeyPressed

    private void pmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pmKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
        pm.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        pm.setEditable(true);
        }
    }//GEN-LAST:event_pmKeyPressed

    private void plActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plActionPerformed

    private void plKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
        pl.setEditable(false);
        JOptionPane.showMessageDialog(this, "Please enter number only");
        }else{
        pl.setEditable(true);
        }
    }//GEN-LAST:event_plKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel REFRESH;
    private javax.swing.JPanel add;
    private javax.swing.JButton btnImage;
    private javax.swing.JPanel clear;
    private javax.swing.JPanel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel picv;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pl;
    private javax.swing.JTextField pm;
    private javax.swing.JTextField pname;
    private javax.swing.JTable pr_table;
    private javax.swing.JPanel print;
    private javax.swing.JTextField ps;
    private javax.swing.JPanel refresh;
    private javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables

 String filen= null;
byte[] pic = null; 
private ImageIcon format = null;

   
}
