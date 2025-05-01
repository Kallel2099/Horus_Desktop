package com.knowledge.horus.views;

public class Dispensação extends javax.swing.JDialog {
    
    public static Cme dis;

    public Dispensação(Cme parent, boolean modal) {
        this.dis = parent;
        this.setModal(modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEspec = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldItens2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldEspec1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recebimento de Material Sujo");
        setResizable(false);
        getContentPane().setLayout(null);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ));
        jTable3.setEnabled(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(90);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(90);
        }

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(840, 160, 460, 450);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jTextFieldID.setEnabled(false);
        jPanel2.add(jTextFieldID);
        jTextFieldID.setBounds(10, 50, 130, 20);

        jLabel1.setText("Código de barras:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 30, 120, 20);

        jTextFieldEspec.setEnabled(false);
        jTextFieldEspec.setFocusable(false);
        jPanel2.add(jTextFieldEspec);
        jTextFieldEspec.setBounds(570, 50, 110, 20);

        jTextFieldNome.setEnabled(false);
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldNome);
        jTextFieldNome.setBounds(150, 50, 410, 20);

        jLabel3.setText("Descrição:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(150, 30, 110, 20);

        jLabel4.setText("Data e hora:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(570, 30, 110, 20);

        jTextFieldItens2.setEditable(false);
        jTextFieldItens2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextFieldItens2.setEnabled(false);
        jTextFieldItens2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItens2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldItens2);
        jTextFieldItens2.setBounds(1120, 10, 60, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Centro Cirúrgico", "UTI Geral", "UTI Cardiológica", "Emergência", "ALA A", "ALA B", "ALA C", "Centro Médico", "Endoscopia", "Hemodinâmica", "Tomografia", "Ressonância", " " }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(110, 10, 240, 20);

        jLabel2.setText("Setor de destino:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 100, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Ítens restantes");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(1190, 20, 100, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 50, 1300, 80);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dispensação");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(10, 0, 330, 50);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1300, 50);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar);
        jButtonCancelar.setBounds(650, 620, 90, 23);

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir);
        jButtonConcluir.setBounds(550, 620, 90, 23);

        jLabel5.setText("Dispensado por:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1090, 620, 100, 20);

        jTextFieldEspec1.setEnabled(false);
        jTextFieldEspec1.setFocusable(false);
        getContentPane().add(jTextFieldEspec1);
        jTextFieldEspec1.setBounds(1190, 620, 110, 20);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Setor", "Data e hora", "Qtd."
            }
        ));
        jTable4.setEnabled(false);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMinWidth(90);
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable4.getColumnModel().getColumn(0).setMaxWidth(90);
            jTable4.getColumnModel().getColumn(2).setMinWidth(150);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable4.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable4.getColumnModel().getColumn(3).setMinWidth(100);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable4.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable4.getColumnModel().getColumn(4).setMinWidth(50);
            jTable4.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable4.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 160, 820, 450);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ítens dispensados");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 130, 820, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ítens a dispensar");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(840, 130, 460, 30);

        setSize(new java.awt.Dimension(1316, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldItens2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItens2ActionPerformed
        
    }//GEN-LAST:event_jTextFieldItens2ActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        /*DefaultTableModel Tabela1 = (DefaultTableModel) jTable1.getModel();
        int r = jTable1.getRowCount();
        for (int i = 0; i < r; i++ ){
            mov.setOrigem((String) jComboBoxOrigem.getSelectedItem());
            mov.setDestino((String) jComboBoxDestino.getSelectedItem());
            mov.setLeito((String) jComboBoxLeito.getSelectedItem());
            mov.setCód((String) jTable1.getValueAt(i, 0));
            mov.setDescrição((String) jTable1.getValueAt(i, 1));
            mov.setData((String) jTable1.getValueAt(i, 2));
            mov.setTipo("Dispensação");
            mov.setUsuário(Controle.Sessão.getInstance());
            banc1.Salvar(mov);
        }*/
        dispose();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dispensação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dispensação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dispensação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dispensação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dispensação dialog = new Dispensação(dis, true);
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
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextFieldEspec;
    private javax.swing.JTextField jTextFieldEspec1;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldItens2;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
