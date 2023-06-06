package myapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import internalPages.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class dashBoard extends javax.swing.JFrame {

    /**
     * Creates new form dashBoard
     */
    public dashBoard() {
        initComponents();
    }
    
    Color navcolor= new Color(217,222,135);
    Color headcolor= new Color(222,140,135);
    Color body = new Color (222,184,135);
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        dashpane1 = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        customer_report = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        deliveryrinfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userni = new javax.swing.JLabel();
        ACC = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        customerlist = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        minimize = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("2ROAD.avif"));
        Image img = icon.getImage();
        maindesktop = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(), getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        navbar.setBackground(new java.awt.Color(217, 222, 135));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashpane1.setBackground(new java.awt.Color(217, 222, 135));
        dashpane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashpane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashpane1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashpane1MouseExited(evt);
            }
        });
        dashpane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setBackground(new java.awt.Color(0, 204, 204));
        dashboard.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-list-48 (1).png"))); // NOI18N
        dashboard.setText("  PRODUCT LIST");
        dashpane1.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        navbar.add(dashpane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 180, 40));

        customer_report.setBackground(new java.awt.Color(217, 222, 135));
        customer_report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_reportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customer_reportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customer_reportMouseExited(evt);
            }
        });
        customer_report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-report-48 (1).png"))); // NOI18N
        jLabel9.setText("CUSTOMER ORDER");
        customer_report.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        navbar.add(customer_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 180, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-male-user-50.png"))); // NOI18N
        navbar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ADMIN!");
        navbar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 150, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("WELCOME");
        navbar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 140, -1));

        deliveryrinfo.setBackground(new java.awt.Color(217, 222, 135));
        deliveryrinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deliveryrinfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deliveryrinfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deliveryrinfoMouseExited(evt);
            }
        });
        deliveryrinfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delivery-30 (1).png"))); // NOI18N
        jLabel2.setText("DELIVERY INFORMATION");
        deliveryrinfo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 190, -1));

        navbar.add(deliveryrinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 180, 40));

        userni.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        userni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userni.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        navbar.add(userni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, 30));

        ACC.setBackground(new java.awt.Color(217, 222, 135));
        ACC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ACCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ACCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ACCMouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(217, 222, 135));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-settings-64 (1).png"))); // NOI18N
        jLabel10.setText("ACCOUNT SETTINGS");

        javax.swing.GroupLayout ACCLayout = new javax.swing.GroupLayout(ACC);
        ACC.setLayout(ACCLayout);
        ACCLayout.setHorizontalGroup(
            ACCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ACCLayout.setVerticalGroup(
            ACCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        navbar.add(ACC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 180, 40));

        customerlist.setBackground(new java.awt.Color(217, 222, 135));
        customerlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerlistMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerlistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerlistMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-customer-40.png"))); // NOI18N
        jLabel11.setText("CUSTOMER LIST");

        javax.swing.GroupLayout customerlistLayout = new javax.swing.GroupLayout(customerlist);
        customerlist.setLayout(customerlistLayout);
        customerlistLayout.setHorizontalGroup(
            customerlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerlistLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        customerlistLayout.setVerticalGroup(
            customerlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerlistLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        navbar.add(customerlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        jPanel1.add(navbar);
        navbar.setBounds(0, 0, 180, 470);

        header.setBackground(new java.awt.Color(222, 140, 135));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimize.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("—");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        header.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 30, 30));

        close.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        header.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 30));

        jPanel1.add(header);
        header.setBounds(180, 0, 730, 40);

        maindesktop.setBackground(new java.awt.Color(222, 184, 135));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APP");
        maindesktop.add(jLabel1);
        jLabel1.setBounds(0, 240, 720, 50);

        jLabel5.setFont(new java.awt.Font("Engravers MT", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("pizza");
        maindesktop.add(jLabel5);
        jLabel5.setBounds(0, 120, 720, 50);

        jLabel7.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("delivery");
        maindesktop.add(jLabel7);
        jLabel7.setBounds(-10, 180, 740, 50);

        jPanel1.add(maindesktop);
        maindesktop.setBounds(180, 40, 730, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashpane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashpane1MouseEntered
        dashpane1.setBackground(body);
    }//GEN-LAST:event_dashpane1MouseEntered

    private void dashpane1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashpane1MouseExited
        dashpane1.setBackground(navcolor);
    }//GEN-LAST:event_dashpane1MouseExited

    private void customer_reportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_reportMouseEntered
      customer_report.setBackground(body);
    }//GEN-LAST:event_customer_reportMouseEntered

    private void customer_reportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_reportMouseExited
         customer_report.setBackground(navcolor);
    }//GEN-LAST:event_customer_reportMouseExited

    private void customer_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_reportMouseClicked
          customerOrder up = new customerOrder();
      maindesktop.add(up).setVisible(true);
    }//GEN-LAST:event_customer_reportMouseClicked

    private void dashpane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashpane1MouseClicked
     productList pl = new   productList();
     maindesktop.add(pl).setVisible(true);
    }//GEN-LAST:event_dashpane1MouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void deliveryrinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryrinfoMouseEntered
        deliveryrinfo.setBackground(body);
    }//GEN-LAST:event_deliveryrinfoMouseEntered

    private void deliveryrinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryrinfoMouseExited
        deliveryrinfo.setBackground(navcolor);
    }//GEN-LAST:event_deliveryrinfoMouseExited

    private void deliveryrinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryrinfoMouseClicked
        customerReport oi = new customerReport();
     maindesktop.add(oi).setVisible(true);
    }//GEN-LAST:event_deliveryrinfoMouseClicked

    private void ACCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACCMouseClicked
      account ac = new   account();
     maindesktop.add(ac).setVisible(true);
    }//GEN-LAST:event_ACCMouseClicked

    private void ACCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACCMouseEntered
        ACC.setBackground(body);
    }//GEN-LAST:event_ACCMouseEntered

    private void ACCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACCMouseExited
       ACC.setBackground(navcolor);
    }//GEN-LAST:event_ACCMouseExited

    private void customerlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerlistMouseClicked
        customerlist cl = new  customerlist();
     maindesktop.add(cl).setVisible(true);
    }//GEN-LAST:event_customerlistMouseClicked

    private void customerlistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerlistMouseEntered
          customerlist.setBackground(body);
    }//GEN-LAST:event_customerlistMouseEntered

    private void customerlistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerlistMouseExited
         customerlist.setBackground(navcolor);
    }//GEN-LAST:event_customerlistMouseExited

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
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ACC;
    private javax.swing.JLabel close;
    private javax.swing.JPanel customer_report;
    private javax.swing.JPanel customerlist;
    private javax.swing.JLabel dashboard;
    private javax.swing.JPanel dashpane1;
    private javax.swing.JPanel deliveryrinfo;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JDesktopPane maindesktop;
    private javax.swing.JLabel minimize;
    private javax.swing.JPanel navbar;
    public static javax.swing.JLabel userni;
    // End of variables declaration//GEN-END:variables
}
