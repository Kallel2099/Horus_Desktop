package com.knowledge.horus.views;

//import Controle.Cme.UsuáriosSQL;
//import Controle.ManipularImagem;
//import Modelos.Cme.UsuáriosMod;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.knowledge.horus.controls.ManipularImagem;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Usuarios extends javax.swing.JDialog {

    //UsuáriosMod usu = new UsuáriosMod();
    //UsuáriosSQL u = new UsuáriosSQL();
    private Dimension dimensao_default;
    private Webcam WebCam;
    boolean exec = true;
    byte[] bytes;
    int s = 0;
    public static MenuGerenciar usuarios;
    
    public Usuarios(MenuGerenciar parent, boolean modal) {
    //public Usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextFieldMat.requestFocus();
        Start();
    }
    
    private void Start(){
        try{
            dimensao_default = WebcamResolution.VGA.getSize();
            WebCam = Webcam.getDefault();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private void Vídeo(){
        new Thread(){
            @Override
            public void run(){
                while (true && exec){
                    try {
                        Image imagem = WebCam.getImage();
                        ImageIcon icon = new ImageIcon(imagem);
                        icon.setImage(icon.getImage().getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), 100));
                        jLabelFoto.setIcon(icon);
                        Thread.sleep(50);
                    } catch (Exception e) {
                        
                    }
                }
            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMat = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldLogin = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jButtonCam = new javax.swing.JButton();
        jButtonCap = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Matricula");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Login");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 50, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Senha");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 20));

        jTextFieldMat.setNextFocusableComponent(jTextFieldNome);
        jTextFieldMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMatActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 160, 23));

        jTextFieldNome.setEnabled(false);
        jTextFieldNome.setNextFocusableComponent(jTextFieldLogin);
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, 23));

        jTextFieldLogin.setEnabled(false);
        jTextFieldLogin.setNextFocusableComponent(jTextFieldSenha);
        jTextFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 160, 23));

        jTextFieldSenha.setEnabled(false);
        jTextFieldSenha.setNextFocusableComponent(jComboBox1);
        jTextFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 160, 23));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 75, 23));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gerenciar usuários");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 140, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Usuário", "Administrador" }));
        jComboBox1.setEnabled(false);
        jComboBox1.setNextFocusableComponent(jButtonCam);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 160, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nível");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 30, 20));

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setToolTipText("");
        jLabelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelFoto.setOpaque(true);
        getContentPane().add(jLabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 176, 144));

        jButtonCam.setText("Camera");
        jButtonCam.setEnabled(false);
        jButtonCam.setNextFocusableComponent(jButtonCap);
        jButtonCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCamActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 75, 40));

        jButtonCap.setText("Capturar");
        jButtonCap.setEnabled(false);
        jButtonCap.setNextFocusableComponent(jButtonSalvar);
        jButtonCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCapActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 75, 40));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 75, 23));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 75, 23));

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 75, 23));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 75, 23));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 230));

        setSize(new java.awt.Dimension(541, 231));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jTextFieldMat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Atenção!\nO campo 'Matrícula' não pode estar vazio.");
        } else if (jTextFieldNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Atenção!\nO campo 'Nome' não pode estar vazio.");
        } else if (jTextFieldLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Atenção!\nO campo 'Login' não pode estar vazio.");
        } else if (jTextFieldSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Atenção!\nO campo 'Senha' não pode estar vazio.");
        } else if (jLabelFoto.getIcon().equals(null)) {
            JOptionPane.showMessageDialog(null, "Atenção!\nA foto é obrigatória.");
        } else if (s == 0) {
            /*usu.setNome(jTextFieldNome.getText());
            usu.setMatricula(jTextFieldMat.getText());
            usu.setLogin(jTextFieldLogin.getText());
            usu.setSenha(jTextFieldSenha.getText());
            usu.setNivel((String) jComboBox1.getSelectedItem());
            usu.setFoto(bytes);
            u.Salvar(usu);*/
            jTextFieldMat.setText("");
            jTextFieldNome.setText("");
            jTextFieldLogin.setText("");
            jTextFieldSenha.setText("");
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setEnabled(!true);
            jLabelFoto.setIcon(null);
            jTextFieldNome.setEnabled(!true);
            jTextFieldLogin.setEnabled(!true);
            jTextFieldSenha.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonEditar.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonSalvar.setEnabled(!true);
            jButtonCam.setEnabled(!true);
            jButtonCap.setEnabled(!true);
            jTextFieldMat.requestFocus();
        } else if (s == 1){
            /*usu.setNome(jTextFieldNome.getText());
            usu.setMatricula(jTextFieldMat.getText());
            usu.setLogin(jTextFieldLogin.getText());
            usu.setSenha(jTextFieldSenha.getText());
            usu.setNivel((String) jComboBox1.getSelectedItem());
            bytes = ManipularImagem.getImgBytes((BufferedImage) ManipularImagem.iconToImage(jLabelFoto.getIcon()));
            usu.setFoto(bytes);
            u.Editar(usu);*/
            jTextFieldMat.setText("");
            jTextFieldNome.setText("");
            jTextFieldLogin.setText("");
            jTextFieldSenha.setText("");
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setEnabled(!true);
            jLabelFoto.setIcon(null);
            jTextFieldNome.setEnabled(!true);
            jTextFieldLogin.setEnabled(!true);
            jTextFieldSenha.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonEditar.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonSalvar.setEnabled(!true);
            jButtonCam.setEnabled(!true);
            jButtonCap.setEnabled(!true);
            jTextFieldMat.requestFocus();
            s = 0;
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCamActionPerformed
        new Thread(){
            public void run(){
                exec = true;
                WebCam.open();
                Vídeo();
            }
        }.start();
        jButtonCap.setEnabled(true);
    }//GEN-LAST:event_jButtonCamActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        new Thread(){
            public void run(){
                WebCam.close();
                exec = !true;
            }
        }.start();
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCapActionPerformed
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(WebCam.getImage(), "jpg", baos);
            bytes = baos.toByteArray();
            
            ByteArrayInputStream is = new ByteArrayInputStream(bytes);
            BufferedImage imagem = ImageIO.read(is);
            
            int NovaLargura = 176, NovaAltura = 144;
            BufferedImage foto = new BufferedImage(NovaLargura, NovaAltura, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = foto.createGraphics();
            g.drawImage(imagem, 0, 0, NovaLargura, NovaAltura, null);
            new Thread(){
                public void run(){
                    WebCam.close();
                    exec = !true;
                }
            }.start();
            jLabelFoto.setIcon(new ImageIcon(foto));
            jButtonSalvar.setEnabled(true);
            jButtonCancelar.setEnabled(true);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButtonCapActionPerformed

    private void jTextFieldMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMatActionPerformed
        jTextFieldNome.requestFocus();
        /*usu.setBusca(jTextFieldMat.getText());
        UsuáriosMod model = u.Buscar(usu);
        if (model.getOk().intern().trim().equals("ok")) {
            jTextFieldNome.setEnabled(true);
            jTextFieldNome.requestFocus();
            jButtonLimpar.setEnabled(true);
        } else {
            Object[] options = {"Sim", "Não", "Cancelar"};
            int c = JOptionPane.showOptionDialog(null, "Atençao!\nUsuário cadastrado no sistema!\nGostaria de continuar?\n", 
                "Selecione um Opção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (c == 0) {
                jButtonEditar.setEnabled(true);
                jButtonCam.setEnabled(!true);
                jButtonCap.setEnabled(!true);
                jButtonCancelar.setEnabled(true);
                jTextFieldNome.setText(model.getNome().intern().trim());
                jTextFieldLogin.setText(model.getLogin().intern().trim());
                jTextFieldSenha.setText(model.getSenha().intern().trim());
                jComboBox1.setSelectedItem(model.getNivel().intern().trim());
                jTextFieldMat.setEnabled(!true);
                jTextFieldNome.setEnabled(!true);
                jTextFieldLogin.setEnabled(!true);
                jTextFieldSenha.setEnabled(!true);
                jComboBox1.setEnabled(!true);
                try {
                    ByteArrayInputStream is = new ByteArrayInputStream(model.getFoto());
                    BufferedImage imagem = ImageIO.read(is);
                    int NovaLargura = 178, NovaAltura = 140;
                    BufferedImage foto = new BufferedImage(NovaLargura, NovaAltura, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = foto.createGraphics();
                    g.drawImage(imagem, 0, 0, NovaLargura, NovaAltura, null);
                    jLabelFoto.setIcon(new ImageIcon(foto));
                } catch (IOException e){

                }
            } else if (c == 1){
                jTextFieldMat.setText("");
                jTextFieldMat.requestFocus();
            }
        }*/
    }//GEN-LAST:event_jTextFieldMatActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        jTextFieldLogin.setEnabled(true);
        jTextFieldLogin.requestFocus();
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoginActionPerformed
        jTextFieldSenha.setEnabled(true);
        jTextFieldSenha.requestFocus();
    }//GEN-LAST:event_jTextFieldLoginActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldMat.setText("");
        jTextFieldNome.setText("");
        jTextFieldLogin.setText("");
        jTextFieldSenha.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox1.setEnabled(!true);
        jLabelFoto.setIcon(null);
        jTextFieldMat.setEnabled(true);
        jTextFieldNome.setEnabled(!true);
        jTextFieldLogin.setEnabled(!true);
        jTextFieldSenha.setEnabled(!true);
        jButtonLimpar.setEnabled(!true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(!true);
        jButtonCam.setEnabled(!true);
        jButtonCap.setEnabled(!true);
        jButtonCancelar.setEnabled(!true);
        jTextFieldMat.requestFocus();
        s = 0;
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        jTextFieldNome.setEnabled(true);
        jTextFieldLogin.setEnabled(true);
        jTextFieldSenha.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonCam.setEnabled(true);
        jButtonCap.setEnabled(true);
        jComboBox1.setEnabled(true);
        s = 1;
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int excluir = JOptionPane.showConfirmDialog(rootPane, "O registro será excuído, continuar?");
        if (excluir == JOptionPane.YES_OPTION) {
            //usu.setMatricula(jTextFieldMat.getText());
            //u.Excluir(usu);
            jTextFieldMat.setText("");
            jTextFieldNome.setText("");
            jTextFieldLogin.setText("");
            jTextFieldSenha.setText("");
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setEnabled(!true);
            jLabelFoto.setIcon(null);
            jTextFieldNome.setEnabled(!true);
            jTextFieldLogin.setEnabled(!true);
            jTextFieldSenha.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonEditar.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonSalvar.setEnabled(!true);
            jButtonCam.setEnabled(!true);
            jButtonCap.setEnabled(!true);
            s = 0;
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        jButtonCam.setEnabled(true);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldMat.setText("");
        jTextFieldNome.setText("");
        jTextFieldLogin.setText("");
        jTextFieldSenha.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox1.setEnabled(!true);
        jLabelFoto.setIcon(null);
        jTextFieldMat.setEnabled(true);
        jTextFieldNome.setEnabled(!true);
        jTextFieldLogin.setEnabled(!true);
        jTextFieldSenha.setEnabled(!true);
        jButtonLimpar.setEnabled(!true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(!true);
        jButtonCam.setEnabled(!true);
        jButtonCap.setEnabled(!true);
        jButtonCancelar.setEnabled(!true);
        jTextFieldMat.requestFocus();
        s = 0;
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSenhaActionPerformed
        jComboBox1.setEnabled(true);
        jComboBox1.requestFocus();
    }//GEN-LAST:event_jTextFieldSenhaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuarios dialog = new Usuarios(usuarios, true);
                //Usuarios dialog = new Usuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCam;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCap;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldMat;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    // End of variables declaration//GEN-END:variables
}
