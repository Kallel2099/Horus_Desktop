package com.knowledge.horus.views;

public class MenuReceber extends javax.swing.JDialog {

    public static ReceberEsteril esteril;
    public static ReceberTextil textil;
    public static LavarConsig consignado;
    public static Cme cme;
    
    public MenuReceber(Cme parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRecText = new javax.swing.JButton();
        jButtonRecEst = new javax.swing.JButton();
        jButtonRecConsig = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRecText.setBackground(new java.awt.Color(200, 200, 200));
        jButtonRecText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRecText.setForeground(new java.awt.Color(70, 70, 70));
        jButtonRecText.setText("<html><center>Receber<br>Textil<html>");
        jButtonRecText.setToolTipText("");
        jButtonRecText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRecText.setContentAreaFilled(false);
        jButtonRecText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRecText.setIconTextGap(10);
        jButtonRecText.setOpaque(true);
        jButtonRecText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRecTextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRecTextMouseExited(evt);
            }
        });
        jButtonRecText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecTextActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRecText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 70));

        jButtonRecEst.setBackground(new java.awt.Color(200, 200, 200));
        jButtonRecEst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRecEst.setForeground(new java.awt.Color(70, 70, 70));
        jButtonRecEst.setText("<html><center>Receber<br>Estéril<html>");
        jButtonRecEst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRecEst.setContentAreaFilled(false);
        jButtonRecEst.setIconTextGap(10);
        jButtonRecEst.setOpaque(true);
        jButtonRecEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRecEstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRecEstMouseExited(evt);
            }
        });
        jButtonRecEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecEstActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRecEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, 70));

        jButtonRecConsig.setBackground(new java.awt.Color(200, 200, 200));
        jButtonRecConsig.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRecConsig.setForeground(new java.awt.Color(70, 70, 70));
        jButtonRecConsig.setText("<html><center>Receber<br>Consignado<html>");
        jButtonRecConsig.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRecConsig.setContentAreaFilled(false);
        jButtonRecConsig.setOpaque(true);
        jButtonRecConsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRecConsigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRecConsigMouseExited(evt);
            }
        });
        jButtonRecConsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecConsigActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRecConsig, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 150, 70));

        jButtonSair.setBackground(new java.awt.Color(200, 200, 200));
        jButtonSair.setText("Sair");
        jButtonSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSair.setContentAreaFilled(false);
        jButtonSair.setOpaque(true);
        jButtonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSairMouseExited(evt);
            }
        });
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 70, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 280));

        setSize(new java.awt.Dimension(191, 279));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonRecTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecTextActionPerformed
        textil = new ReceberTextil(this, true);
        textil.setVisible(true);
    }//GEN-LAST:event_jButtonRecTextActionPerformed

    private void jButtonRecEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecEstActionPerformed
        esteril = new ReceberEsteril(this, true);
        esteril.setVisible(true);
    }//GEN-LAST:event_jButtonRecEstActionPerformed

    private void jButtonRecConsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecConsigActionPerformed
        consignado = new LavarConsig(this, true);
        consignado.setVisible(true);
    }//GEN-LAST:event_jButtonRecConsigActionPerformed

    private void jButtonRecTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecTextMouseEntered
        jButtonRecText.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonRecTextMouseEntered

    private void jButtonRecTextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecTextMouseExited
        jButtonRecText.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonRecTextMouseExited

    private void jButtonRecEstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecEstMouseEntered
        jButtonRecEst.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonRecEstMouseEntered

    private void jButtonRecEstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecEstMouseExited
        jButtonRecEst.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonRecEstMouseExited

    private void jButtonRecConsigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecConsigMouseEntered
        jButtonRecConsig.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonRecConsigMouseEntered

    private void jButtonRecConsigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecConsigMouseExited
        jButtonRecConsig.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonRecConsigMouseExited

    private void jButtonSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSairMouseEntered
        jButtonSair.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonSairMouseEntered

    private void jButtonSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSairMouseExited
        jButtonSair.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonSairMouseExited

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            MenuReceber dialog = new MenuReceber(cme, true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRecConsig;
    private javax.swing.JButton jButtonRecEst;
    private javax.swing.JButton jButtonRecText;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelFundo;
    // End of variables declaration//GEN-END:variables
}
