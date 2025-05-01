package com.knowledge.horus.views;

public class MenuGerenciar extends javax.swing.JDialog {

    public static BancoView banco;
    public static ArsenalView caditem;
    public static NovaCaixa novacx;
    public static NovaBandeja novabd;
    public static NovoKit novokt;
    public static Danificados dani;
    public static Usuarios usuarios;
    
    public MenuGerenciar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonUsuarios = new javax.swing.JButton();
        jButtonArsenal = new javax.swing.JButton();
        jButtonReferência = new javax.swing.JButton();
        jButtonCaixa = new javax.swing.JButton();
        jButtonBandeja = new javax.swing.JButton();
        jButtonKit3 = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonKit = new javax.swing.JButton();
        jButtonDanifi = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonUsuarios.setBackground(new java.awt.Color(200, 200, 200));
        jButtonUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonUsuarios.setForeground(new java.awt.Color(70, 70, 70));
        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Foto.png"))); // NOI18N
        jButtonUsuarios.setText("<html>Gerenciar<br />Usuários</html>");
        jButtonUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUsuarios.setContentAreaFilled(false);
        jButtonUsuarios.setIconTextGap(10);
        jButtonUsuarios.setOpaque(true);
        jButtonUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUsuariosMouseExited(evt);
            }
        });
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 70));

        jButtonArsenal.setBackground(new java.awt.Color(200, 200, 200));
        jButtonArsenal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonArsenal.setForeground(new java.awt.Color(70, 70, 70));
        jButtonArsenal.setText("<html>Gerenciar<br />Arsenal<html/>");
        jButtonArsenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonArsenal.setContentAreaFilled(false);
        jButtonArsenal.setIconTextGap(10);
        jButtonArsenal.setOpaque(true);
        jButtonArsenal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonArsenalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonArsenalMouseExited(evt);
            }
        });
        jButtonArsenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArsenalActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonArsenal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 70));

        jButtonReferência.setBackground(new java.awt.Color(200, 200, 200));
        jButtonReferência.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonReferência.setForeground(new java.awt.Color(70, 70, 70));
        jButtonReferência.setText("<html>Gerenciar<br />Banco de<br />Referência<html/>");
        jButtonReferência.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonReferência.setContentAreaFilled(false);
        jButtonReferência.setIconTextGap(10);
        jButtonReferência.setOpaque(true);
        jButtonReferência.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonReferênciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonReferênciaMouseExited(evt);
            }
        });
        jButtonReferência.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReferênciaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReferência, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 70));

        jButtonCaixa.setBackground(new java.awt.Color(200, 200, 200));
        jButtonCaixa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCaixa.setForeground(new java.awt.Color(70, 70, 70));
        jButtonCaixa.setText("<html>Gerenciar<br />Caixas<html/>");
        jButtonCaixa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCaixa.setContentAreaFilled(false);
        jButtonCaixa.setIconTextGap(10);
        jButtonCaixa.setOpaque(true);
        jButtonCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCaixaMouseExited(evt);
            }
        });
        jButtonCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaixaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 150, 70));

        jButtonBandeja.setBackground(new java.awt.Color(200, 200, 200));
        jButtonBandeja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBandeja.setForeground(new java.awt.Color(70, 70, 70));
        jButtonBandeja.setText("<html>Gerenciar<br />Bandejas<html/>");
        jButtonBandeja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonBandeja.setContentAreaFilled(false);
        jButtonBandeja.setIconTextGap(10);
        jButtonBandeja.setOpaque(true);
        jButtonBandeja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBandejaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBandejaMouseExited(evt);
            }
        });
        jButtonBandeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBandejaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBandeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 150, 70));

        jButtonKit3.setBackground(new java.awt.Color(200, 200, 200));
        jButtonKit3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonKit3.setForeground(new java.awt.Color(70, 70, 70));
        jButtonKit3.setText("<html>...<br />...<html/>");
        jButtonKit3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonKit3.setContentAreaFilled(false);
        jButtonKit3.setIconTextGap(10);
        jButtonKit3.setOpaque(true);
        getContentPane().add(jButtonKit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 150, 70));

        jButtonPesquisar.setBackground(new java.awt.Color(200, 200, 200));
        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPesquisar.setForeground(new java.awt.Color(70, 70, 70));
        jButtonPesquisar.setText("<html>Pesquisar<br />Instrumental<html/>");
        jButtonPesquisar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPesquisar.setContentAreaFilled(false);
        jButtonPesquisar.setIconTextGap(10);
        jButtonPesquisar.setOpaque(true);
        jButtonPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonPesquisarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonPesquisarMouseExited(evt);
            }
        });
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 150, 70));

        jButtonKit.setBackground(new java.awt.Color(200, 200, 200));
        jButtonKit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonKit.setForeground(new java.awt.Color(70, 70, 70));
        jButtonKit.setText("<html>Gerenciar<br />Kits<html/>");
        jButtonKit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonKit.setContentAreaFilled(false);
        jButtonKit.setIconTextGap(10);
        jButtonKit.setOpaque(true);
        jButtonKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonKitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonKitMouseExited(evt);
            }
        });
        jButtonKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 150, 70));

        jButtonDanifi.setBackground(new java.awt.Color(200, 200, 200));
        jButtonDanifi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDanifi.setForeground(new java.awt.Color(70, 70, 70));
        jButtonDanifi.setText("<html>Gerenciar<br />Danificados /<br />Extraviados<html/>");
        jButtonDanifi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonDanifi.setContentAreaFilled(false);
        jButtonDanifi.setIconTextGap(10);
        jButtonDanifi.setOpaque(true);
        jButtonDanifi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDanifiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDanifiMouseExited(evt);
            }
        });
        jButtonDanifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDanifiActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDanifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 150, 70));

        jButtonSair.setBackground(new java.awt.Color(200, 200, 200));
        jButtonSair.setText("Sair");
        jButtonSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSair.setContentAreaFilled(false);
        jButtonSair.setOpaque(true);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 70, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 290));

        setSize(new java.awt.Dimension(512, 291));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        dispose();
        usuarios = new Usuarios (this, true);
        usuarios.setVisible(true);
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonArsenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArsenalActionPerformed
        caditem = new ArsenalView(this, true);
        caditem.setVisible(true);
    }//GEN-LAST:event_jButtonArsenalActionPerformed

    private void jButtonReferênciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReferênciaActionPerformed
        banco = new BancoView(this, true);
        banco.setVisible(true);
    }//GEN-LAST:event_jButtonReferênciaActionPerformed

    private void jButtonCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaixaActionPerformed
        novacx = new NovaCaixa(this, true);
        novacx.setVisible(true);
    }//GEN-LAST:event_jButtonCaixaActionPerformed

    private void jButtonBandejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBandejaActionPerformed
        novabd = new NovaBandeja (this, true);
        novabd.setVisible(true);
    }//GEN-LAST:event_jButtonBandejaActionPerformed

    private void jButtonKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKitActionPerformed
        novokt = new NovoKit (this, true);
        novokt.setVisible(true);
    }//GEN-LAST:event_jButtonKitActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonDanifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDanifiActionPerformed
        dani = new Danificados (this, true);
        dani.setVisible(true);
    }//GEN-LAST:event_jButtonDanifiActionPerformed

    private void jButtonUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsuariosMouseEntered
        jButtonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonUsuariosMouseEntered

    private void jButtonUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUsuariosMouseExited
        jButtonUsuarios.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonUsuariosMouseExited

    private void jButtonArsenalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonArsenalMouseEntered
        jButtonArsenal.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonArsenalMouseEntered

    private void jButtonArsenalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonArsenalMouseExited
        jButtonArsenal.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonArsenalMouseExited

    private void jButtonReferênciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonReferênciaMouseEntered
       jButtonReferência.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonReferênciaMouseEntered

    private void jButtonReferênciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonReferênciaMouseExited
        jButtonReferência.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonReferênciaMouseExited

    private void jButtonCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCaixaMouseEntered
        jButtonCaixa.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonCaixaMouseEntered

    private void jButtonCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCaixaMouseExited
        jButtonCaixa.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonCaixaMouseExited

    private void jButtonBandejaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBandejaMouseEntered
        jButtonBandeja.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonBandejaMouseEntered

    private void jButtonBandejaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBandejaMouseExited
        jButtonBandeja.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonBandejaMouseExited

    private void jButtonKitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonKitMouseEntered
        jButtonKit.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonKitMouseEntered

    private void jButtonKitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonKitMouseExited
        jButtonKit.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonKitMouseExited

    private void jButtonPesquisarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPesquisarMouseEntered
        jButtonPesquisar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonPesquisarMouseEntered

    private void jButtonPesquisarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPesquisarMouseExited
        jButtonPesquisar.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonPesquisarMouseExited

    private void jButtonDanifiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDanifiMouseEntered
        jButtonDanifi.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonDanifiMouseEntered

    private void jButtonDanifiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDanifiMouseExited
        jButtonDanifi.setForeground(new java.awt.Color(70, 70, 70));
    }//GEN-LAST:event_jButtonDanifiMouseExited

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGerenciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuGerenciar dialog = new MenuGerenciar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonArsenal;
    private javax.swing.JButton jButtonBandeja;
    private javax.swing.JButton jButtonCaixa;
    private javax.swing.JButton jButtonDanifi;
    private javax.swing.JButton jButtonKit;
    private javax.swing.JButton jButtonKit3;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonReferência;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabelFundo;
    // End of variables declaration//GEN-END:variables
}
