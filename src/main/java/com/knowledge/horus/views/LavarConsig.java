package com.knowledge.horus.views;

import Controle.Cme.MovimentSQL;
import Controle.Conexão;
import Controle.Sessão;
import Modelos.Cme.MovimentMod;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class LavarConsig extends javax.swing.JDialog {

    Conexão conex = new Conexão();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    public static NovoFornec forn;
    public static NovoConsig cons;
    public static MenuReceber consignado;
    int sep = 1;
    java.util.Date dt_atual = new java.util.Date();        
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat cod = new SimpleDateFormat ("ddMMyy");
    
    public LavarConsig(MenuReceber parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buscarForn();
        buscarConsig();
        moviment.setQuery("SELECT codigo FROM movimentação WHERE codigo LIKE '7%'");
        MovimentMod model = mov.Buscar2(moviment);
        BigInteger cód = new BigInteger("0");
        BigInteger t = new BigInteger("1");
        if (model.getCodigo() == null) {
            cód = new BigInteger("7" + String.valueOf(cod.format(dt_atual)) + "001");
        } else if (model.getCodigo() != null) {
            if (!model.getCodigo().intern().trim().startsWith("7" + String.valueOf(cod.format(dt_atual)))) {
                cód = new BigInteger("7" + String.valueOf(cod.format(dt_atual)) + "001");
                cód.add(t);
            } else if (model.getCodigo().intern().trim().startsWith("7" + String.valueOf(cod.format(dt_atual)))) {
                cód = new BigInteger(model.getCodigo().intern().trim());
                cód = cód.add(t);
            }
        }
        jTextFieldCod.setText(String.valueOf(cód));
        jTextFieldData.setText(sdf.format(dt_atual));
        jTextFieldOp.setText(Sessão.getLogado());
        if (Sessão.getNivel() != null && Sessão.getNivel().contains("Usuário")) {
            jButtonNovoForn.setEnabled(!true);
            jButtonNovoConsig.setEnabled(!true);
        }
    }
    
    public void buscarForn(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Fornecedor' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxForn.removeAllItems();
            do{
                jComboBoxForn.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBox\n" + ex.getMessage());
        }
        conex.desconectar();
    }
    
    public void buscarConsig(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Consignado' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxConsig.removeAllItems();
            do{
                jComboBoxConsig.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBox\n" + ex.getMessage());
        }
        conex.desconectar();
    }
    
    public boolean data(String data) {
        try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            sdf2.setLenient(false);
            sdf2.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public boolean dataMenorQueHoje(String data) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVerificada = LocalDate.parse(data, dtf);
            LocalDate hoje = LocalDate.now();
            return dataVerificada.compareTo(hoje) < 0;
        } catch (Exception e){
            return !true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxForn = new javax.swing.JComboBox<>();
        jComboBoxConsig = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCirur = new javax.swing.JTextField();
        jTextFieldPac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldOp = new javax.swing.JTextField();
        jButtonLimpar = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jFormattedTextProced = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            jFormattedTextProced = new javax.swing.JFormattedTextField(data);
        }
        catch(Exception e){
        }
        jButtonNovoConsig = new javax.swing.JButton();
        jButtonNovoForn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jTextFieldCod = new javax.swing.JTextField();
        jTextFieldData = new javax.swing.JTextField();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(480, 280));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fornecedor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 20));

        jComboBoxForn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "teste" }));
        jComboBoxForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFornActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxForn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 300, 23));

        jComboBoxConsig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "teste", " " }));
        getContentPane().add(jComboBoxConsig, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 300, 23));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descrição:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cirurgião:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Paciente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Procedimento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 20));

        jTextFieldCirur.setNextFocusableComponent(jTextFieldPac);
        jTextFieldCirur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCirurActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCirur, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 300, -1));

        jTextFieldPac.setNextFocusableComponent(jFormattedTextProced);
        jTextFieldPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPacActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 300, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Operador:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Início do Recebimento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 110, 20));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 120, -1));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 70, 23));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 70, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 70, 23));

        jFormattedTextProced.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextProced.setText("  /  /    ");
        jFormattedTextProced.setCaretPosition(0);
        jFormattedTextProced.setNextFocusableComponent(jButtonConcluir);
        jFormattedTextProced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextProcedActionPerformed(evt);
            }
        });
        jFormattedTextProced.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextProcedKeyTyped(evt);
            }
        });
        getContentPane().add(jFormattedTextProced, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 70, -1));

        jButtonNovoConsig.setText("...");
        jButtonNovoConsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoConsigActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovoConsig, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 30, 23));

        jButtonNovoForn.setText("...");
        jButtonNovoForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoFornActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovoForn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 30, 23));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lavar consignado");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 20));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Qtd. de peças:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Código:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 40, 20));

        jTextFieldQtd.setNextFocusableComponent(jTextFieldCirur);
        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 40, -1));

        jTextFieldCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCod.setEnabled(false);
        getContentPane().add(jTextFieldCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 80, -1));

        jTextFieldData.setEnabled(false);
        getContentPane().add(jTextFieldData, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 110, -1));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 300));

        setSize(new java.awt.Dimension(480, 291));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoFornActionPerformed
        forn = new NovoFornec (this, true);
        forn.setVisible(true);
    }//GEN-LAST:event_jButtonNovoFornActionPerformed

    private void jButtonNovoConsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoConsigActionPerformed
        cons = new NovoConsig (this, true);
        cons.setVisible(true);
    }//GEN-LAST:event_jButtonNovoConsigActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldCirur.setText("");
        jTextFieldPac.setText("");
        jTextFieldQtd.setText("");
        jFormattedTextProced.setText("");
        jComboBoxForn.setSelectedIndex(0);
        jComboBoxConsig.setSelectedIndex(0);
        jButtonLimpar.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jButtonSair.setEnabled(true);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        int qtd = 1;
        if (!jTextFieldQtd.getText().isEmpty()) {
            qtd = Integer.parseInt(jTextFieldQtd.getText().intern().trim());
        }
        if (qtd > 1) {
            int varios = JOptionPane.showConfirmDialog(rootPane, "Os ítens serão embalados separadamente?");
            if (varios == JOptionPane.YES_OPTION) {
                sep = qtd;
            }
        }
        BigInteger cód = new BigInteger("0");
        BigInteger t = new BigInteger("1");
        for (int n = 0; n < sep; n++){
            moviment.setQuery("SELECT codigo FROM movimentação WHERE codigo LIKE '7%'");
            MovimentMod model = mov.Buscar2(moviment);
            if (model.getCodigo() == null) {
                cód = new BigInteger("7" + String.valueOf(cod.format(dt_atual)) + "001");
            } else if (model.getCodigo() != null) {
                if (!model.getCodigo().intern().trim().startsWith("7" + String.valueOf(cod.format(dt_atual)))) {
                    cód = new BigInteger("7" + String.valueOf(cod.format(dt_atual)) + "001");
                    cód.add(t);
                } else if (model.getCodigo().intern().trim().startsWith("7" + String.valueOf(cod.format(dt_atual)))) {
                    cód = new BigInteger(model.getCodigo().intern().trim());
                    cód = cód.add(t);
                }
            }
            moviment.setFornec(jComboBoxForn.getSelectedItem().toString());
            moviment.setDesc(jComboBoxConsig.getSelectedItem().toString());
            if (qtd > 1 && sep > 1) {
                moviment.setQtd(1);
                moviment.setCodigo(String.valueOf(cód));
            } else if (sep == 1){
                moviment.setQtd(qtd);
                moviment.setCodigo(jTextFieldCod.getText().intern().trim());
            }
            moviment.setCirurg(jTextFieldCirur.getText().intern().trim());
            moviment.setPac(jTextFieldPac.getText().intern().trim());
            moviment.setProced(jFormattedTextProced.getText().intern().trim());
            moviment.setData(sdf.format(dt_atual));
            moviment.setRecebi(jTextFieldData.getText().intern().trim());
            moviment.setOp(jTextFieldOp.getText().intern().trim());
            moviment.setStatus("Recebido");
            mov.Salvar(moviment);
        }
        jTextFieldCirur.setText("");
        jTextFieldPac.setText("");
        jTextFieldQtd.setText("");
        jFormattedTextProced.setText("");
        jComboBoxForn.setSelectedIndex(0);
        jComboBoxConsig.setSelectedIndex(0);
        jButtonLimpar.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jButtonSair.setEnabled(true);
        moviment.setQuery("SELECT codigo FROM movimentação WHERE codigo LIKE '7%'");
        MovimentMod model = mov.Buscar2(moviment);
        if (model.getCodigo() == null) {
            cód = new BigInteger("7" + String.valueOf(cod.format(dt_atual)) + "001");
        } else if (model.getCodigo() != null) {
            if (!model.getCodigo().intern().trim().startsWith("7" + String.valueOf(cod.format(dt_atual)))) {
                cód = new BigInteger("7" + String.valueOf(cod.format(dt_atual)) + "001");
                cód.add(t);
            } else if (model.getCodigo().intern().trim().startsWith("7" + String.valueOf(cod.format(dt_atual)))) {
                cód = new BigInteger(model.getCodigo().intern().trim());
                cód = cód.add(t);
            }
        }
        jTextFieldCod.setText(String.valueOf(cód));
        jTextFieldData.setText(sdf.format(dt_atual));
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(rootPane, "Deseja cancelar o recebimento?\n");
        if (sair == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFornActionPerformed
        jButtonLimpar.setEnabled(true);
    }//GEN-LAST:event_jComboBoxFornActionPerformed

    private void jFormattedTextProcedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextProcedKeyTyped
        jButtonConcluir.setEnabled(true);
    }//GEN-LAST:event_jFormattedTextProcedKeyTyped

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
        jTextFieldCirur.requestFocus();
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

    private void jTextFieldCirurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCirurActionPerformed
        jTextFieldPac.requestFocus();
    }//GEN-LAST:event_jTextFieldCirurActionPerformed

    private void jTextFieldPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPacActionPerformed
        jFormattedTextProced.requestFocus();
    }//GEN-LAST:event_jTextFieldPacActionPerformed

    private void jFormattedTextProcedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextProcedActionPerformed
        String validar = jFormattedTextProced.getText();
        data(validar);
        dataMenorQueHoje(validar);
        if (data(validar) != true){
            JOptionPane.showMessageDialog(rootPane, "Formato de data incorreto!");
            jFormattedTextProced.setText("");
            jFormattedTextProced.requestFocus();
        } else if (dataMenorQueHoje(validar)) {
            JOptionPane.showMessageDialog(rootPane, "Data menor que a data de hoje!");
            jFormattedTextProced.setText("");
            jFormattedTextProced.requestFocus();
        } else {
            jButtonConcluir.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextProcedActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LavarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LavarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LavarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LavarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LavarConsig dialog = new LavarConsig(consignado, true);
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
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovoConsig;
    private javax.swing.JButton jButtonNovoForn;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxConsig;
    private javax.swing.JComboBox<String> jComboBoxForn;
    private javax.swing.JFormattedTextField jFormattedTextProced;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JTextField jTextFieldCirur;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldPac;
    private javax.swing.JTextField jTextFieldQtd;
    // End of variables declaration//GEN-END:variables
}
