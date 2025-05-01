package com.knowledge.horus.views;

import Controle.Cme.EquipamentosSQL;
import Controle.Cme.MovimentSQL;
import Modelos.Cme.EquipamentosMod;
import Modelos.Cme.MovimentMod;
import java.text.SimpleDateFormat;
import static java.lang.Thread.sleep;

public class CicloFim extends javax.swing.JDialog {

    public static CicloFim fim;
    EquipamentosMod equipa = new EquipamentosMod();
    EquipamentosSQL equip = new EquipamentosSQL();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    java.util.Date dt_atual = new java.util.Date();        
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        
    public CicloFim(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAutoCód = new javax.swing.JTextField();
        jTextFieldFim = new javax.swing.JTextField();
        jTextFieldIni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Finalizar ciclo de esterilização.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Autoclave:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 60, 20));

        jTextFieldAutoCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAutoCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAutoCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 140, -1));
        getContentPane().add(jTextFieldFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, -1));
        getContentPane().add(jTextFieldIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Final do ciclo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 70, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Início do ciclo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 20));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 75, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 190));

        setSize(new java.awt.Dimension(299, 185));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAutoCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAutoCódActionPerformed
        equipa.setBusca(jTextFieldAutoCód.getText().intern().trim());
        equip.Buscar(equipa);
        if (equipa.getId() != null) {
            moviment.setId(equipa.getId());
            moviment.setBusca(sdf2.format(dt_atual));
            mov.FimCiclo(moviment);
            moviment.setFim(sdf.format(dt_atual));
            if (!moviment.getInicio().intern().trim().equals("")) {
                jTextFieldAutoCód.setText(equipa.getId().intern().trim());
                jTextFieldIni.setText(moviment.getInicio().intern().trim());
                jTextFieldFim.setText(moviment.getFim().intern().trim());
                mov.Fim(moviment);
                new Thread(){
                    public void run(){
                        try {
                            sleep(1800);
                            jTextFieldAutoCód.setText("");
                            jTextFieldIni.setText("");
                            jTextFieldFim.setText("");
                        } catch (InterruptedException e) {
                        }
                    }
                }.start();
                jTextFieldAutoCód.requestFocus();
            } else {
                jTextFieldAutoCód.setText("");
                jTextFieldAutoCód.requestFocus();
            }
        } else {
            jTextFieldAutoCód.setText("");
            jTextFieldAutoCód.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldAutoCódActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CicloFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CicloFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CicloFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CicloFim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CicloFim dialog = new CicloFim(fim, true);
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
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JTextField jTextFieldAutoCód;
    private javax.swing.JTextField jTextFieldFim;
    private javax.swing.JTextField jTextFieldIni;
    // End of variables declaration//GEN-END:variables
}
