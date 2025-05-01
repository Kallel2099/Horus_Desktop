package com.knowledge.horus.views;

import com.knowledge.horus.controls.ArsenalDAO;
import com.knowledge.horus.models.Arsenal;
import java.util.List;
import javax.swing.JOptionPane;

public class LeitorCódL extends javax.swing.JDialog {
    
    public static LavarCaixa lcaixa;
    public static LavarAvulso lavulso;
    public static LavarTermo ltermo;
    public static LavarEquipa lequipa;
    public static LavarBandeja lbandeja;
    public static LavarKit lkit;
    public static Cme cme;
    List<Arsenal> lista = null;
    int tot = 0;
    
    public LeitorCódL(Cme parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void buscarArsenal (Long inst){
        lista = new ArsenalDAO().findByCod(inst);
        tot = lista.size();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCód = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonTestes = new javax.swing.JButton();
        jButtonDeter = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Localize o código de identificação");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 280, 30));

        jTextFieldCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 20));

        jButtonCancelar.setBackground(new java.awt.Color(200, 200, 200));
        jButtonCancelar.setForeground(new java.awt.Color(70, 70, 70));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCancelar.setContentAreaFilled(false);
        jButtonCancelar.setOpaque(true);
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseExited(evt);
            }
        });
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lavar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 20));

        jButtonTestes.setBackground(new java.awt.Color(200, 200, 200));
        jButtonTestes.setForeground(new java.awt.Color(70, 70, 70));
        jButtonTestes.setText("<html><center>Anexar<br>testes");
        jButtonTestes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonTestes.setContentAreaFilled(false);
        jButtonTestes.setOpaque(true);
        jButtonTestes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonTestesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonTestesMouseExited(evt);
            }
        });
        getContentPane().add(jButtonTestes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 80, 50));

        jButtonDeter.setBackground(new java.awt.Color(200, 200, 200));
        jButtonDeter.setForeground(new java.awt.Color(70, 70, 70));
        jButtonDeter.setText("<html><center>Trocar<br>detergente");
        jButtonDeter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonDeter.setContentAreaFilled(false);
        jButtonDeter.setOpaque(true);
        jButtonDeter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDeterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDeterMouseExited(evt);
            }
        });
        getContentPane().add(jButtonDeter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 50));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 160));

        setSize(new java.awt.Dimension(281, 155));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        buscarArsenal(Long.parseLong(jTextFieldCód.getText().trim()));
        System.out.println(lista.get(0)+" * "+tot);
        
        if (tot == 0) {
            JOptionPane.showMessageDialog(null, "Código inválido.");
            jTextFieldCód.setText("");
            jTextFieldCód.requestFocus();
        } else {
            String tipo = lista.get(0).getTipo();
            switch(tipo){
                case "Caixa" :
                    lcaixa = new LavarCaixa(this, true);
                    lcaixa.setVisible(true);
                case "Bandeja" :
                    lbandeja = new LavarBandeja(this, true);
                    lbandeja.setVisible(true);
                case "Equipamento" :
                    lequipa = new LavarEquipa(this, true);
                    lequipa.setVisible(true);
                case "Kit" :
                    lkit = new LavarKit(this, true);
                    lkit.setVisible(true);
                case "Instrumental" :
                    lavulso = new LavarAvulso(this, true);
                    lavulso.setVisible(true);
                case "Termossensível" :
                    ltermo = new LavarTermo(this, true);
                    ltermo.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    private void jButtonDeterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeterMouseEntered
        jButtonDeter.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonDeterMouseEntered

    private void jButtonDeterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeterMouseExited
        jButtonDeter.setForeground(new java.awt.Color(70,70,70));
    }//GEN-LAST:event_jButtonDeterMouseExited

    private void jButtonCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseEntered
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonCancelarMouseEntered

    private void jButtonCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseExited
        jButtonCancelar.setForeground(new java.awt.Color(70,70,70));
    }//GEN-LAST:event_jButtonCancelarMouseExited

    private void jButtonTestesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTestesMouseEntered
        jButtonTestes.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButtonTestesMouseEntered

    private void jButtonTestesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTestesMouseExited
        jButtonTestes.setForeground(new java.awt.Color(70,70,70));
    }//GEN-LAST:event_jButtonTestesMouseExited

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeitorCódL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeitorCódL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeitorCódL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeitorCódL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LeitorCódL dialog = new LeitorCódL(cme, true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDeter;
    private javax.swing.JButton jButtonTestes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JTextField jTextFieldCód;
    // End of variables declaration//GEN-END:variables
}
