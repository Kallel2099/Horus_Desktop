package com.knowledge.horus.views;

//import Controle.Splash;
import com.knowledge.horus.controls.ManipularImagem;
import com.knowledge.horus.controls.Sessão;
import com.knowledge.horus.controls.UsuariosDAO;
import com.knowledge.horus.models.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/Barcode1.png")).getImage());
        Sessão.getInstance();
        jbtnEntrar.requestFocus();
        firstUse();        
    }
    
    private void firstUse(){
        long tot = new UsuariosDAO().count();
        if(tot == 0){
            try {
                Image img1 = new ImageIcon(getClass().getResource("/imagens/usuario.png")).getImage();
                byte[] usu = ManipularImagem.getImgBytes((BufferedImage) ManipularImagem.toBufferedImage(img1));
                Image img2 = new ImageIcon(getClass().getResource("/imagens/admin.png")).getImage();
                byte[] adm = ManipularImagem.getImgBytes((BufferedImage) ManipularImagem.toBufferedImage(img2));
                
                Usuario admin = new Usuario();
                admin.setMatricula(9999998L);
                admin.setNome("Administrator");
                admin.setLogin("admin");
                admin.setSenha("admin1406");
                admin.setNivel("Administrador");
                admin.setFoto(adm);
                new UsuariosDAO().save(admin);

                Usuario user = new Usuario();
                user.setMatricula(9999999L);
                user.setNome("Usuário");
                user.setLogin("usuario");
                user.setSenha("usu1406");
                user.setNivel("Usuário");
                user.setFoto(usu);
                new UsuariosDAO().save(user);
            } catch(Exception e) {
                System.out.println("Erro: "+e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnCancelar = new javax.swing.JButton();
        jbtnEntrar = new javax.swing.JButton();
        jLabelSenha = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelTeste = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(570, 320));
        setName("Login"); // NOI18N
        setUndecorated(true);
        setSize(new java.awt.Dimension(570, 320));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 90, -1));

        jbtnEntrar.setText("Entrar");
        jbtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 80, -1));

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(82, 82, 0));
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 50, 30));

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(82, 82, 0));
        jLabelLogin.setText("Login:");
        getContentPane().add(jLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 50, 30));

        jtfLogin.setMaximumSize(new java.awt.Dimension(6, 25));
        jtfLogin.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfLogin.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jtfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 180, 23));

        jpfSenha.setMaximumSize(new java.awt.Dimension(6, 25));
        jpfSenha.setMinimumSize(new java.awt.Dimension(6, 25));
        jpfSenha.setPreferredSize(new java.awt.Dimension(6, 25));
        jpfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jpfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 180, 23));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 90)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(82, 82, 0));
        jLabel1.setText("orus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 270, 80));

        jLabel4.setFont(new java.awt.Font("BankGothic Md BT", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(82, 82, 0));
        jLabel4.setText("RASTREABILIDADE EM PROCESSOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 240, 20));

        jLabel5.setFont(new java.awt.Font("Felix Titling", 0, 120)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 150, 0));
        jLabel5.setText("H");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 100));

        jLabel2.setFont(new java.awt.Font("Poor Richard", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("knowledge");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, 30));
        getContentPane().add(jLabelTeste, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 60, 50));

        jLabelFundo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Login2.jpg"))); // NOI18N
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 320));

        setSize(new java.awt.Dimension(567, 320));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEntrarActionPerformed
        if (jpfSenha.getText().isEmpty() || jtfLogin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos Login ou Senha não podem estar vazios!");
            jpfSenha.setText("");
            jtfLogin.setText("");
            jtfLogin.requestFocus();
        }else {
            List<Usuario> usu = new UsuariosDAO().findByLogin(jtfLogin.getText().trim());
            if (usu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                jpfSenha.setText("");
                jtfLogin.setText("");
                jtfLogin.requestFocus();
            } else if(!usu.isEmpty()) {
                int tot = usu.size();
                for(int i = 0; i < tot; i++){
                    if (usu.get(i).getLogin().equalsIgnoreCase(jtfLogin.getText()) && usu.get(i).getSenha().equalsIgnoreCase(jpfSenha.getText())){
                        Sessão.setLogado(usu.get(i).getNome().trim());
                        Sessão.setNivel(usu.get(i).getNivel().trim());
                        Sessão.setFoto(usu.get(i).getFoto());
                        Cme tela = new Cme(usu.get(i).getNome().trim());
                        tela.setVisible(true);
                        tot = 0;
                        dispose();
                    }
                }
                if (tot != 0) {
                    JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                    jpfSenha.setText("");
                    jtfLogin.setText("");
                    jtfLogin.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                jpfSenha.setText("");
                jtfLogin.setText("");
                jtfLogin.requestFocus();
            }
        }
    }//GEN-LAST:event_jbtnEntrarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        System.exit (0);
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jpfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfSenhaActionPerformed
        if (jpfSenha.getText().isEmpty() || jtfLogin.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos Login ou Senha não podem estar vazios!");
            jpfSenha.setText("");
            jtfLogin.setText("");
            jtfLogin.requestFocus();
        }else {
            List<Usuario> usu = new UsuariosDAO().findByLogin(jtfLogin.getText().trim());
            if (usu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                jpfSenha.setText("");
                jtfLogin.setText("");
                jtfLogin.requestFocus();
            } else if(!usu.isEmpty()) {
                int tot = usu.size();
                for(int i = 0; i < tot; i++){
                    if (usu.get(i).getLogin().equalsIgnoreCase(jtfLogin.getText()) && usu.get(i).getSenha().equalsIgnoreCase(jpfSenha.getText())){
                        Sessão.setLogado(usu.get(i).getNome().trim());
                        Sessão.setNivel(usu.get(i).getNivel().trim());
                        Sessão.setFoto(usu.get(i).getFoto());
                        Cme tela = new Cme(usu.get(i).getNome().trim());
                        tela.setVisible(true);
                        tot = 0;
                        dispose();
                    }
                }
                if (tot != 0) {
                    JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                    jpfSenha.setText("");
                    jtfLogin.setText("");
                    jtfLogin.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha não conferem!");
                jpfSenha.setText("");
                jtfLogin.setText("");
                jtfLogin.requestFocus();
            }
        }
    }//GEN-LAST:event_jpfSenhaActionPerformed

    private void jtfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLoginActionPerformed
        if (jtfLogin.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Campo Login não pode estar vazio!");
            jpfSenha.setText("");
            jtfLogin.setText("");
            jtfLogin.requestFocus();
        } else {
            jpfSenha.requestFocus();
        }
    }//GEN-LAST:event_jtfLoginActionPerformed

    public static void main(String args[]) {
        //new Splash();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTeste;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEntrar;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfLogin;
    // End of variables declaration//GEN-END:variables
}
