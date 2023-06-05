/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.dbconnector;
import config.login_db;
import static internalPages.productList.getHeightFromWidth;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author admin
 */
public class customerOrder extends javax.swing.JInternalFrame {

    public String destination = "";
    File selectedFile;
    public String oldpath;
    String path;

    DefaultTableModel model;
    private Connection con;

    public customerOrder() {
        initComponents();
        displayData();
        initialize();
        gslip();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

    }
    public void print(){
 
     try {
         rec.print();
     } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "print failed"+e);
     }
 
 
 
 
 }
    public void gslip() {
        
        rec.setText("****************************************************\n");
        rec.setText(rec.getText() + "----------PIZZA DELIVERY APP------------------\n");
        rec.setText(rec.getText() + "------------ORDER RECIEPT----------------------\n");
        rec.setText(rec.getText() + "****************************************************\n");

        Date date = new Date();  // or replace with your own date object

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Replace with your desired format
        String formattedDate = dateFormat.format(date);

        rec.setText(rec.getText() + "DATE: " + formattedDate + "\n");
        rec.setText(rec.getText() + "PRODUCT ID: " + pid.getText() + "\n");
        rec.setText(rec.getText() + "CUSTOMER ID: " + jComboBox1.getSelectedItem() + "\n");
        rec.setText(rec.getText() + "CUSTOMER NAME: " + customerNameTextField.getText() + "\n");
        rec.setText(rec.getText() + "QUANTITY: " + cquant.getText() + "\n");
        rec.setText(rec.getText() + "PRICE: " + cprice.getText() + "\n");
        rec.setText(rec.getText() + "******************************************************\n");
        rec.setText(rec.getText() + "TOTAL PRICE: " + ctp.getText() + "\n");
  
            
        rec.setText(rec.getText()+"\nThis Serve as an Official Receipt!!!\n\n");
    }

    public void initialize() {
//        String name = "";
//        try {
//            PreparedStatement ps;
//            String query = "SELECT * FROM customer_tbl";
//            ps = login_db.getConnection().prepareStatement(query);
//            ResultSet rs;
//            rs = ps.executeQuery();
//            while (rs.next()) {
//
//                name = rs.getString("c_name");
//
//            }
//            jComboBox1.addItem(name);
//        } catch (SQLException ex) {
//        }
        try {
    String name = " ";
    dbconnector dbc = new dbconnector();
    ResultSet rs = dbc.getData("SELECT * FROM customer_tbl");

    while (rs.next()) {
        name = rs.getString("c_id");
        jComboBox1.addItem(name);
    }

    jComboBox1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String selectedId = (String) jComboBox1.getSelectedItem();
            String customerName = lookupCustomerName(selectedId);

            customerNameTextField.setText(customerName);
        }

        private String lookupCustomerName(String selectedId) {
            // Implement the database lookup logic here
            String customerName = null;
            try {
                dbconnector dbc = new dbconnector();
                ResultSet rs = dbc.getData("SELECT c_name FROM customer_tbl WHERE c_id = '" + selectedId + "'");
                if (rs.next()) {
                    customerName = rs.getString("c_name");
                }
            } catch (SQLException ex) {
                System.out.println("Error Message: " + ex);
            }
            return customerName;
        }

    });

} catch (SQLException ex) {
    System.out.println("Error Message: " + ex);
}
    }
    //print
    

    public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void table() {
        int row = p_tbl.getSelectedRow();
        int cc = p_tbl.getSelectedColumn();
        ImageIcon format;
        String tc = p_tbl.getModel().getValueAt(row, 0).toString();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery", "root", "");
            String sql = "SELECT * from product_tbl where p_id=" + tc + "";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                String pprice = rs.getString("p_price");

                image.setIcon(ResizeImage(rs.getString("img_pc"), null, image));
                oldpath = rs.getString("img_pc");
                pid.setText("" + id);
                cprice.setText(pprice);

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void displayData() {

        try {

            dbconnector dbc = new dbconnector();
            ResultSet rs = dbc.getData("SELECT p_id as 'ID', p_name as 'Product', p_price as 'Price' FROM product_tbl");
            p_tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println("Error Message: " + ex);

        }
    }

    public void reset() {

        pid.setText("");
        cprice.setText("");
        ctp.setText("");
        customerNameTextField.setText("");
        cquant.setText("");

    }

    Color navcolor = new Color(217, 222, 135);
    Color headcolor = new Color(222, 140, 135);
    Color bodycolor = new Color(222, 184, 135);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        p_tbl = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        clear = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        refresh = new javax.swing.JPanel();
        REFRESH = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        ctp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cprice = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cquant = new javax.swing.JTextField();
        Quantity1 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rec = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        customerNameTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        print = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

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

        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 80, 30));

        p_tbl.setBackground(new java.awt.Color(255, 230, 204));
        p_tbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(p_tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 350, 150));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Product ID:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, 20));

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

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CLEAR");
        clear.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 80, 30));

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

        jPanel1.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 80, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Customer Name: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, 20));

        pid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 220, 20));

        ctp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ctp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 170, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Total Price:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 100, 20));

        cprice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cprice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 170, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Price:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 60, 20));

        jButton1.setBackground(new java.awt.Color(222, 140, 135));
        jButton1.setText("CALCULATE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));

        cquant.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cquant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cquant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(cquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 220, 20));

        Quantity1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Quantity1.setText("Quantity:");
        jPanel1.add(Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, 20));

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

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 80, 30));

        searchbar.setBackground(new java.awt.Color(222, 184, 135));
        searchbar.setText("Enter Search Here...");
        searchbar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        searchbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchbarMouseEntered(evt);
            }
        });
        jPanel1.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, 20));

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 110, -1));

        rec.setColumns(20);
        rec.setRows(5);
        jScrollPane2.setViewportView(rec);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 230, 270));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 220, 20));

        customerNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(customerNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 220, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Customer ID: ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, 20));

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

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PRINT");
        print.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        pid.setText(null);
        cquant.setText(null);
        cprice.setText(null);
        ctp.setText(null);
        customerNameTextField.setText(null);


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
        ctp.setText("" + totalp);
    }//GEN-LAST:event_jButton1MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        String product = pid.getText();
        String quantity = cquant.getText();
        String price = cprice.getText();
        String tp = ctp.getText();
        String name = jComboBox1.getSelectedItem().toString();

        if (name.equals("") || quantity.equals("") || price.equals("") || tp.equals("")) {
            JOptionPane.showMessageDialog(null, "All Fields Are Required!");
        } else {
            PreparedStatement ps;
            ResultSet rs;
            String registerUserQuery = "INSERT INTO customer_order(c_id, p_id, cu_quant, cu_price, cu_tp, cu_status) VALUES (?,?,?,?,?,?)";

            try {
                ps = login_db.getConnection().prepareStatement(registerUserQuery);
                ps.setString(1, name);
                ps.setString(2, product);
                ps.setString(3, quantity);
                ps.setString(4, price);
                ps.setString(5, tp);
                ps.setString(6, "PENDING");

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Add Successfully");
                        gslip();
                    reset();

                } else {
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

    private void customerNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTextFieldActionPerformed
        print();
    }//GEN-LAST:event_customerNameTextFieldActionPerformed

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered
        print.setBackground(navcolor);
    }//GEN-LAST:event_printMouseEntered

    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited
      print.setBackground(headcolor);
    }//GEN-LAST:event_printMouseExited

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
          print();
    }//GEN-LAST:event_printMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quantity1;
    private javax.swing.JLabel REFRESH;
    private javax.swing.JPanel add;
    private javax.swing.JPanel clear;
    private javax.swing.JTextField cprice;
    private javax.swing.JTextField cquant;
    private javax.swing.JTextField ctp;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable p_tbl;
    private javax.swing.JTextField pid;
    private javax.swing.JPanel print;
    private javax.swing.JTextArea rec;
    private javax.swing.JPanel refresh;
    private javax.swing.JPanel search;
    private javax.swing.JTextField searchbar;
    // End of variables declaration//GEN-END:variables
String filen = null;
    private ImageIcon format = null;

}
