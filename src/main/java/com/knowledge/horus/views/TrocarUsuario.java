package com.knowledge.horus.views;

import com.knowledge.horus.controls.UsuariosDAO;
import com.knowledge.horus.models.TrocarUsu;
import com.knowledge.horus.models.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

public class TrocarUsuario extends javax.swing.JDialog {

    public static javax.swing.JDialog sessão;
    
    Usuario usu = new Usuario();
    TrocarUsu troca = new TrocarUsu();
    
    public TrocarUsuario(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Esta ação requer supervisão.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Atenção!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Login:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 40, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 40, 20));

        jTextFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText(" Entre com login e senha de administrador:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, 20));

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 75, 23));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 75, 23));

        jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 160, -1));

        jLabelFundo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 180));

        setSize(new java.awt.Dimension(270, 181));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoginActionPerformed
        if (jTextFieldLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo Login não pode estar vazio!");
            jTextFieldLogin.setText("");
            jTextFieldLogin.requestFocus();
        } else {
            jPasswordFieldSenha.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldLoginActionPerformed

    private void jPasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaActionPerformed
        if (jPasswordFieldSenha.getText().isEmpty() || jTextFieldLogin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos Login ou Senha não podem estar vazios!");
            jPasswordFieldSenha.setText("");
            jTextFieldLogin.setText("");
            jTextFieldLogin.requestFocus();
        }else {
            List<Usuario> usu = new UsuariosDAO().findByLogin(jTextFieldLogin.getText().trim());
            if (!usu.isEmpty()) {
                int tot = usu.size();
                for (int i = 0; i < tot; i++) {
                    if (usu.get(i).getLogin().equalsIgnoreCase(jTextFieldLogin.getText().trim())
                            && usu.get(i).getSenha().equalsIgnoreCase(jPasswordFieldSenha.getText().trim())) {
                        if (usu.get(i).getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
                            TrocarUsu.setNivel(1);
                            TrocarUsu.setOperador(usu.get(i).getNome().intern().trim());
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "O usuário precisa ter nível de Administrador");
                            jPasswordFieldSenha.setText("");
                            jTextFieldLogin.setText("");
                            jTextFieldLogin.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                        jPasswordFieldSenha.setText("");
                        jTextFieldLogin.setText("");
                        jTextFieldLogin.requestFocus();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                jPasswordFieldSenha.setText("");
                jTextFieldLogin.setText("");
                jTextFieldLogin.requestFocus();
            }
        }
    }//GEN-LAST:event_jPasswordFieldSenhaActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        if (jPasswordFieldSenha.getText().isEmpty() || jTextFieldLogin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos Login ou Senha não podem estar vazios!");
            jPasswordFieldSenha.setText("");
            jTextFieldLogin.setText("");
            jTextFieldLogin.requestFocus();
        }else {
            List<Usuario> usu = new UsuariosDAO().findByLogin(jTextFieldLogin.getText().trim());
            if (!usu.isEmpty()) {
                int tot = usu.size();
                for (int i = 0; i < tot; i++) {
                    if (usu.get(i).getLogin().equalsIgnoreCase(jTextFieldLogin.getText().trim())
                            && usu.get(i).getSenha().equalsIgnoreCase(jPasswordFieldSenha.getText().trim())) {
                        if (usu.get(i).getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
                            troca.setNivel(1);
                            troca.setOperador(usu.get(i).getNome().intern().trim());
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "O usuário precisa ter nível de Administrador");
                            jPasswordFieldSenha.setText("");
                            jTextFieldLogin.setText("");
                            jTextFieldLogin.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                        jPasswordFieldSenha.setText("");
                        jTextFieldLogin.setText("");
                        jTextFieldLogin.requestFocus();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                jPasswordFieldSenha.setText("");
                jTextFieldLogin.setText("");
                jTextFieldLogin.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrocarUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            TrocarUsuario dialog = new TrocarUsuario(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables
}
