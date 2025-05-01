package com.knowledge.horus.views;

import Controle.Cme.InstruSQL;
import Controle.Conexão;
import Modelos.Cme.InstruMod;

public class LeitorCódP extends javax.swing.JDialog {

    Conexão conex = new Conexão();
    InstruMod instru = new InstruMod();
    InstruSQL inst = new InstruSQL();
    public static PrepararCaixa pcaixa;
    public static PrepararAvulso pavulso;
    public static PrepararTermo ptermo;
    public static PrepararEquipa pequipa;
    public static PrepararBandeja pbandeja;
    public static PrepararKit pkit;
    public static Cme cme;
    
    public LeitorCódP(Cme parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCód = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Localize o código de identificação");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, 30));

        jTextFieldCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, 20));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Preparar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 20));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 270, 130));

        setSize(new java.awt.Dimension(260, 120));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        instru.setBusca(jTextFieldCód.getText());
        jTextFieldCód.setText("");
        InstruMod model = inst.Buscar(instru);
        if (model.getOk() == 1) {
            String c = "Caixa";
            String b = "Bandeja";
            String e = "Equipamento";
            String k = "Kit";
            String i = "Instrumental";
            String t = "Termossensível";
            if (model.getItem().intern().trim().equalsIgnoreCase(c)) {
                pcaixa = new PrepararCaixa(this, true);
                pcaixa.setVisible(true);
            }else if (model.getItem().intern().trim().equalsIgnoreCase(b)) {
                pbandeja = new PrepararBandeja(this, true);
                pbandeja.setVisible(true);
            }else if (model.getItem().intern().trim().equalsIgnoreCase(e)) {
                pequipa = new PrepararEquipa(this, true);
                pequipa.setVisible(true);
            }else if (model.getItem().intern().trim().equalsIgnoreCase(k)) {
                pkit = new PrepararKit(this, true);
                pkit.setVisible(true);
            }else if (model.getItem().intern().trim().equalsIgnoreCase(i)) {
                pavulso = new PrepararAvulso(this, true);
                pavulso.setVisible(true);
            }else if (model.getItem().intern().trim().equalsIgnoreCase(t)) {
                ptermo = new PrepararTermo(this, true);
                ptermo.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeitorCódP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeitorCódP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeitorCódP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeitorCódP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LeitorCódP dialog = new LeitorCódP(cme, true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JTextField jTextFieldCód;
    // End of variables declaration//GEN-END:variables
}
