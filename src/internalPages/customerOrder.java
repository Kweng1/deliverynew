/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.dbconnector;
import config.login_db;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import myapp.loginForm;
import net.proteanit.sql.DbUtils;
import static java.lang.String.format;
import javax.swing.JComboBox;



/**
 *
 * @author admin
 */


public class customerOrder extends javax.swing.JInternalFrame {

     public byte[] imageBytes;
    String path;
    String action;
    String filename=null;
    String imgPath = null;
   byte[] person_image = null; 
DefaultTableModel model;
private Connection con;
    public customerOrder() {
        initComponents();
        displayData();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
       csize = new JComboBox<>();
    csize.addItem("Small");
    csize.addItem("Medium");
    csize.addItem("Large"); 
        csize.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            generatePrice();
        }

            private void generatePrice() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        jPanel1.add(csize, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 220, 20));
}
    
    
    
    public void table(){
     int row = p_tbl.getSelectedRow();
     int cc = p_tbl.getSelectedColumn();
     String tc = p_tbl.getModel().getValueAt(row, 0).toString();
             try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery","root","");
             String sql = "select * from product_tbl where p_id="+tc+"";
             
             PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            int id=rs.getInt("p_id");
            String name1=rs.getString("p_name");           
            byte[] img = rs.getBytes("img_pc");
            format = new ImageIcon(img);
            Image im =format.getImage().getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
            pic.setIcon(new ImageIcon(im));
            
                cid.setText(""+id);
                corder.setText(name1);   
                
                
         
            }
             pst.close();
             rs.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
         }
        }
    public void displayData(){
       
        try{
       
            dbconnector dbc = new dbconnector();
            ResultSet rs = dbc.getData("SELECT p_id as 'ID', p_name as 'Product', p_small as 'small',p_medium as 'medium', p_large as 'large' FROM product_tbl");
            p_tbl.setModel(DbUtils.resultSetToTableModel(rs));
       
            while (rs.next()) {
            String small = rs.getString("Small");
            String medium = rs.getString("Medium");
            String large = rs.getString("Large");
            if (small != null)
                csize.addItem("Small");
            if (medium != null)
                csize.addItem("Medium");
            if (large != null)
                csize.addItem("Large");
        }
        }catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
        }
    }
    
    public void reset(){
        
       
        cname.setText("");
        cadd.setText("");
        ccon.setText("");
        cid.setText("");
         corder.setText("");
          cprice.setText("");
         csize.getSelectedIndex();
            ctp.setText("");
            
        
        
    }
    
    
    
     Color navcolor= new Color(217,222,135);
    Color headcolor= new Color(222,140,135);
    Color bodycolor = new Color(222,184,135);
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        p_tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ccon = new javax.swing.JTextField();
        cname = new javax.swing.JTextField();
        clear = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cadd = new javax.swing.JTextField();
        refresh = new javax.swing.JPanel();
        REFRESH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        ctp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        corder = new javax.swing.JTextField();
        cprice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Quantity = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cquant = new javax.swing.JTextField();
        Quantity1 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        csize = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(736, 436));

        jPanel1.setBackground(new java.awt.Color(222, 184, 135));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("COSTUMER ORDER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 20));

        search.setBackground(new java.awt.Color(222, 140, 135));
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });
        search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SEARCH");
        search.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 80, 30));

        p_tbl.setBackground(new java.awt.Color(255, 230, 204));
        p_tbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(p_tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 430, 150));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Contact No.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 100, 20));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 40, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Address:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 70, 20));

        ccon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ccon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ccon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ccon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 220, 20));

        cname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 220, 20));

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

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CLEAR");
        clear.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 80, 30));

        cadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cadd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cadd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 220, 20));

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

        jPanel1.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 80, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Name: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 60, 20));

        cid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 220, 20));

        ctp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ctp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 220, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Total Price:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 372, 100, 20));

        corder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        corder.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        corder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(corder, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 220, 20));

        cprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cprice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 220, 20));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Order:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 60, 20));

        Quantity.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Quantity.setText("Size:");
        jPanel1.add(Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 80, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Price:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 60, 20));

        jButton1.setBackground(new java.awt.Color(222, 140, 135));
        jButton1.setText("CALCULATE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, -1, -1));

        cquant.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cquant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cquant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 220, 20));

        Quantity1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Quantity1.setText("Quantity:");
        jPanel1.add(Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 80, 20));

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

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ADD");
        add.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 80, 30));

        searchbar.setBackground(new java.awt.Color(222, 184, 135));
        searchbar.setText("Enter Search Here...");
        searchbar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        searchbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchbarMouseEntered(evt);
            }
        });
        jPanel1.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 40, 340, 30));

        pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        csize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SMALL", "LARGE", "MEDIUM" }));
        jPanel1.add(csize, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
       DefaultTableModel model = (DefaultTableModel) p_tbl.getModel();
       TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(model);
       p_tbl.setRowSorter(obj);
       obj.setRowFilter(RowFilter.regexFilter(searchbar.getText()));
               
    }//GEN-LAST:event_searchMouseClicked

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        search.setBackground(navcolor);
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        search.setBackground(headcolor);
    }//GEN-LAST:event_searchMouseExited

    private void clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseExited
          clear.setBackground(headcolor);
    }//GEN-LAST:event_clearMouseExited

    private void clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseEntered
         clear.setBackground(navcolor);
    }//GEN-LAST:event_clearMouseEntered

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        
         cname.setText(null);
         ccon.setText(null);        
         cid.setText(null);
         cadd.setText(null);
         corder.setText(null);
                  csize.getSelectedIndex();

         cprice.setText(null);
         ctp.setText(null);
        
            
    }//GEN-LAST:event_clearMouseClicked

    private void p_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_tblMouseClicked
       table();
       
    }//GEN-LAST:event_p_tblMouseClicked
       
    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        
    
    
    }//GEN-LAST:event_refreshMouseClicked

    private void refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseEntered
       refresh.setBackground(navcolor);
    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited
       refresh.setBackground(headcolor);

    }//GEN-LAST:event_refreshMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        double a = Double.parseDouble(cquant.getText()); 

       int b = Integer.parseInt(cprice.getText());
       double totalp = a * b;
       ctp.setText (""+totalp);
    }//GEN-LAST:event_jButton1MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
          String name = cname.getText();
         String contact = ccon.getText();
      String address = cadd.getText();
      String order = corder.getText();
     String size = String.valueOf(csize.getSelectedIndex());

      String quantity =String.valueOf(csize.getSelectedIndex());
      String price = cprice.getText();
      String tp =ctp.getText();
       
        
       
        if (name.equals("")||contact.equals("")||address.equals("")||order.equals("")||size.equals("")||quantity.equals("")||price.equals("")||tp.equals(""))
        {
            JOptionPane.showMessageDialog(null, "All Fields Are Required!");
        }
        else{
        PreparedStatement ps;
ResultSet rs;
String registerUserQuery = "INSERT INTO customer_tbl(c_name, c_add, c_con, c_order, c_size, c_quant, c_price, c_tp, sta_tus) VALUES (?,?,?,?,?,?,?,?,?)";

try {
    ps = login_db.getConnection().prepareStatement(registerUserQuery);
    ps.setString(1, name);
    ps.setString(2, address);
    ps.setString(3, contact);
    ps.setString(4, order);
    ps.setString(5, size);
    ps.setString(6, quantity);
    ps.setString(7, price);
    ps.setString(8,tp );
    ps.setString(9,"PENDING" );
   
 
    if(ps.executeUpdate() > 0){
        JOptionPane.showMessageDialog(null, "Add Successfully");
        displayData();
        reset();
       
       
      
    }else{
        JOptionPane.showMessageDialog(null, "Error: Check Your Information");
    }
} catch (SQLException ex) {
  JOptionPane.showMessageDialog(null, ex);
}
        }
    }//GEN-LAST:event_addMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
         add.setBackground(navcolor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
          add.setBackground(headcolor);
    }//GEN-LAST:event_addMouseExited

    private void searchbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseEntered
         searchbar.setText(null);
    }//GEN-LAST:event_searchbarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quantity;
    private javax.swing.JLabel Quantity1;
    private javax.swing.JLabel REFRESH;
    private javax.swing.JPanel add;
    private javax.swing.JTextField cadd;
    private javax.swing.JTextField ccon;
    private javax.swing.JTextField cid;
    private javax.swing.JPanel clear;
    private javax.swing.JTextField cname;
    private javax.swing.JTextField corder;
    private javax.swing.JTextField cprice;
    private javax.swing.JTextField cquant;
    private javax.swing.JComboBox<String> csize;
    private javax.swing.JTextField ctp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable p_tbl;
    private javax.swing.JLabel pic;
    private javax.swing.JPanel refresh;
    private javax.swing.JPanel search;
    private javax.swing.JTextField searchbar;
    // End of variables declaration//GEN-END:variables
String filen= null;

private ImageIcon format = null;

}

