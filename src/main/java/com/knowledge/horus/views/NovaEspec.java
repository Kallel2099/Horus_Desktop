package com.knowledge.horus.views;

import com.knowledge.horus.controls.ComboBoxDAO;
import com.knowledge.horus.models.ComboBox;
import javax.swing.JOptionPane;

public class NovaEspec extends javax.swing.JDialog {
    
    ComboBox combo = new ComboBox();
    public static ArsenalView espec;
    public static BancoView espec2;
    
    public NovaEspec(ArsenalView parent, boolean modal) {
        super (parent, modal);
        initComponents();
    }
    
    public NovaEspec(BancoView parent, boolean modal) {
        super (parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldEsp = new javax.swing.JTextField();
        jButtonSair = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastrar Nova Especialidade");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 30));

        jTextFieldEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEspActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 230, 20));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 70, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 70, -1));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, -1));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 100));

        setSize(new java.awt.Dimension(273, 98));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            combo.setDescrição(jTextFieldEsp.getText());
            combo.setUso("Especialidade");
            new ComboBoxDAO().save(combo);
            combo = new ComboBox();
            jTextFieldEsp.setText("");
            jTextFieldEsp.requestFocus();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ítem já cadastrado!");
            jTextFieldEsp.setText("");
            jTextFieldEsp.requestFocus();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldEsp.setText("");
        jTextFieldEsp.requestFocus();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jTextFieldEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEspActionPerformed
        try {
            combo.setDescrição(jTextFieldEsp.getText());
            combo.setUso("Especialidade");
            new ComboBoxDAO().save(combo);
            combo = new ComboBox();
            jTextFieldEsp.setText("");
            jTextFieldEsp.requestFocus();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ítem já cadastrado!");
            jTextFieldEsp.setText("");
            jTextFieldEsp.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldEspActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovaEspec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaEspec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaEspec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaEspec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovaEspec dialog = new NovaEspec(espec, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JTextField jTextFieldEsp;
    // End of variables declaration//GEN-END:variables
}
