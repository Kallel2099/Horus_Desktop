package com.knowledge.horus.views;

import Controle.Cme.MovimentSQL;
import Controle.Conexão;
import Controle.Sessão;
import Modelos.Cme.LoteMod;
import Modelos.Cme.MovimentMod;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReceberTextil extends javax.swing.JDialog {
    
    Conexão conex = new Conexão();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    LoteMod lote = new LoteMod();
    public static MenuReceber textil;
    public static NovoTextil text;
    public static NovoMétodo met;
    public static NovoSetor setor;
    int v = 14;
    int l = 0;
    java.util.Date dt_atual = new java.util.Date(); 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat cod = new SimpleDateFormat("ddMMyy");
    DefaultTableModel Tabela;
    
    public ReceberTextil(MenuReceber parent, boolean modal) {
        super (parent, modal);
        initComponents();
        Tabela = (DefaultTableModel) jTable.getModel();
        jFormattedTextProcess.setText(sdf2.format(dt_atual));
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, v);
        jFormattedTextValid.setText(sdf2.format(c.getTime()));
        jTextFieldOp.setText(Sessão.getLogado());
        buscarProduto();
        buscarMétodo();
        buscarSetor();
        if (Sessão.getNivel() != null && Sessão.getNivel().contains("Usuário")) {
            jButtonCadProd.setEnabled(!true);
            jButtonCadMetod.setEnabled(!true);
            jButtonCadSetor.setEnabled(!true);
        }
        lote.setData(sdf2.format(dt_atual));
        mov.Lote(lote);
        lote.setNum(lote.getNum() + 1);
        mov.NovoLote(lote);
        l = lote.getNum();
        jTextFieldLote.setText(String.valueOf(l));
        /*moviment.setBusca(jFormattedTextProcess.getText());
        MovimentMod newlote = mov.ProxLote(moviment);
        if (newlote.getNovolote() == 0) {
            jTextFieldLote.setText("1");
        } else {
            jTextFieldLote.setText(Integer.toString(newlote.getNovolote() + 1));
        }*/
        jTextFieldQtd.requestFocus();
    }
    
    public void buscarProduto(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Textil' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxProduto.removeAllItems();
            do{
                jComboBoxProduto.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBox\n" + ex.getMessage());
        }
        conex.desconectar();
    }
    
    public void buscarMétodo(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Método' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxMetodo.removeAllItems();
            do{
                jComboBoxMetodo.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBox\n" + ex.getMessage());
        }
        conex.desconectar();
    }
    
    public void buscarSetor(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Setor' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxOrigem.removeAllItems();
            do{
                jComboBoxOrigem.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBox\n" + ex.getMessage());
        }
        conex.desconectar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxMetodo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldOp = new javax.swing.JTextField();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jComboBoxOrigem = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonIncluir = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jFormattedTextValid = new javax.swing.JFormattedTextField();
        jFormattedTextProcess = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldValid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonAtualizar = new javax.swing.JButton();
        jLabelTítulo = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldItens = new javax.swing.JTextField();
        jButtonCadProd = new javax.swing.JButton();
        jButtonCadMetod = new javax.swing.JButton();
        jButtonCadSetor = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldLote = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1300, 490));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Método:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 50, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Setor de destino:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 90, 20));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Operador:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 60, 20));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Produto:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 20));

        getContentPane().add(jComboBoxMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 160, 23));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Processamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Validade:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 60, 20));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 130, -1));

        getContentPane().add(jComboBoxProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, 23));

        jComboBoxOrigem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOrigemItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxOrigem, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 170, 23));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Método", "Setor", "Processam.", "Validade", "Operador", "Data e Hora", "Cód.", "Prazo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setMinWidth(150);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable.getColumnModel().getColumn(2).setMinWidth(150);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable.getColumnModel().getColumn(3).setMinWidth(80);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable.getColumnModel().getColumn(4).setMinWidth(80);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(4).setMaxWidth(80);
            jTable.getColumnModel().getColumn(5).setMinWidth(100);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(5).setMaxWidth(100);
            jTable.getColumnModel().getColumn(6).setMinWidth(110);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(6).setMaxWidth(110);
            jTable.getColumnModel().getColumn(7).setMinWidth(80);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(7).setMaxWidth(80);
            jTable.getColumnModel().getColumn(8).setMinWidth(40);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(40);
            jTable.getColumnModel().getColumn(8).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1030, 330));

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 70, 23));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 70, 23));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 70, 23));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 70, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 70, 23));

        jFormattedTextValid.setEditable(false);
        try {
            jFormattedTextValid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextValid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jFormattedTextValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 80, -1));

        jFormattedTextProcess.setEditable(false);
        try {
            jFormattedTextProcess.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextProcess.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jFormattedTextProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 80, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Período:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 50, 20));

        jTextFieldValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValidActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 30, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("dias");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 30, 20));

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jLabelTítulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelTítulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTítulo.setText("Recebimento de Têxteis");
        getContentPane().add(jLabelTítulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 20));

        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 30, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Qtd.:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 30, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ítens recebidos:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 90, 20));

        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 40, -1));

        jButtonCadProd.setText("...");
        jButtonCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadProdActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 30, 23));

        jButtonCadMetod.setText("...");
        jButtonCadMetod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMetodActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadMetod, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 30, 23));

        jButtonCadSetor.setText("...");
        jButtonCadSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadSetorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 30, 23));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lote:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 30, 20));

        jTextFieldLote.setEnabled(false);
        getContentPane().add(jTextFieldLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 70, -1));

        jButtonNovo.setText("Novo");
        jButtonNovo.setEnabled(false);
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 70, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 490));

        setSize(new java.awt.Dimension(1050, 490));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        int r = Tabela.getRowCount();
        for (int i = 0; i < r; i++ ){
            moviment.setDesc((String) Tabela.getValueAt(i, 0));
            moviment.setMetodo((String) Tabela.getValueAt(i, 1));
            moviment.setSetor((String) Tabela.getValueAt(i, 2));
            moviment.setProcess((String) Tabela.getValueAt(i, 3));
            moviment.setValid((String) Tabela.getValueAt(i, 4));
            moviment.setOp((String) Tabela.getValueAt(i, 5));
            moviment.setData((String) Tabela.getValueAt(i, 6));
            moviment.setCodigo((String)Tabela.getValueAt(i, 7).toString());
            moviment.setPrazo(Integer.parseInt(Tabela.getValueAt(i, 8).toString()));
            moviment.setLote(Integer.parseInt(jTextFieldLote.getText()));
            moviment.setStatus("Recebido");
            moviment.setEmba("Tecido");
            moviment.setQtd(1);
            mov.Salvar(moviment);
        }
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, v);
        jComboBoxProduto.setSelectedIndex(0);
        jComboBoxMetodo.setSelectedIndex(0);
        jComboBoxOrigem.setSelectedIndex(0);
        jFormattedTextProcess.setText(sdf2.format(dt_atual));
        jFormattedTextValid.setText(sdf2.format(c.getTime()));
        
        while ( 0 != Tabela.getRowCount()){
            Tabela.removeRow(0);
        }
        jTextFieldValid.setText("");
        jButtonExcluir.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jButtonNovo.setEnabled(true);
        jButtonLimpar.setEnabled(!true);
        jButtonIncluir.setEnabled(!true);
        jButtonAtualizar.setEnabled(!true);
        jComboBoxMetodo.setEnabled(!true);
        jComboBoxOrigem.setEnabled(!true);
        jComboBoxProduto.setEnabled(!true);
        jTextFieldQtd.setEnabled(!true);
        jTextFieldValid.setEnabled(!true);
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        if (Tabela.getRowCount() != 0) {
            int sair = JOptionPane.showConfirmDialog(null,"<html><center>Cancelar o recebimento?<br>", "", JOptionPane.YES_NO_OPTION);
            if (sair == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else{
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        moviment.setQuery("SELECT codigo FROM movimentação WHERE codigo LIKE '9%'");
        MovimentMod model = mov.Buscar2(moviment);
        BigInteger cód = new BigInteger("0");
        BigInteger t = new BigInteger("1");
        int q = 1;
        if (!jTextFieldQtd.getText().isEmpty()) {
            q = Integer.parseInt(jTextFieldQtd.getText().intern().trim());
        }
        for (int i = 0; i < q; i++){
            if (model.getCodigo() == null && jTable.getRowCount() == 0) {
                cód = new BigInteger("9" + String.valueOf(cod.format(dt_atual)) + "001");
            } else if (model.getCodigo() != null && jTable.getRowCount() == 0) {
                if (!model.getCodigo().intern().trim().startsWith("9" + String.valueOf(cod.format(dt_atual)))) {
                    cód = new BigInteger("9" + String.valueOf(cod.format(dt_atual)) + "001");
                    cód.add(t);
                } else if (model.getCodigo().intern().trim().startsWith("9" + String.valueOf(cod.format(dt_atual)))) {
                    cód = new BigInteger(model.getCodigo().intern().trim());
                    cód = cód.add(t);
                }
            } else if (model.getCodigo() != null && jTable.getRowCount() != 0) {
                int a = jTable.getRowCount();
                cód = new BigInteger(String.valueOf(jTable.getValueAt(a - 1, 7)));
                cód = cód.add(t);
            } else if (model.getCodigo() == null && jTable.getRowCount() != 0) {
                int a = jTable.getRowCount();
                cód = new BigInteger(String.valueOf(jTable.getValueAt(a - 1, 7)));
                cód = cód.add(t);
            }
            Object[] dados = {jComboBoxProduto.getSelectedItem(), jComboBoxMetodo.getSelectedItem(), jComboBoxOrigem.getSelectedItem(),
                jFormattedTextProcess.getText(), jFormattedTextValid.getText(), jTextFieldOp.getText(), sdf.format(dt_atual), cód, v};
            Tabela.addRow(dados);
        }
        v = 14;
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        jComboBoxProduto.setSelectedIndex(0);
        jComboBoxMetodo.setSelectedIndex(0);
        jComboBoxOrigem.setSelectedIndex(0);
        jTextFieldQtd.setText("");
        jTextFieldValid.setText("");
        jButtonExcluir.setEnabled(true);
        jButtonConcluir.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jFormattedTextProcess.setText(sdf2.format(dt_atual));
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, v);
        jFormattedTextValid.setText(sdf2.format(c.getTime()));
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, v);
        jComboBoxProduto.setSelectedIndex(0);
        jComboBoxMetodo.setSelectedIndex(0);
        jComboBoxOrigem.setSelectedIndex(0);
        jFormattedTextProcess.setText(sdf2.format(dt_atual));
        jFormattedTextValid.setText(sdf2.format(c.getTime()));
        while ( 0 != Tabela.getRowCount()){
            Tabela.removeRow(0);
        }
        jTextFieldValid.setText("");
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        jButtonLimpar.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int Ex = jTable.getSelectedRowCount();
        if (Ex != 0) {
            while ( 0 != jTable.getSelectedRowCount()){
                Tabela.removeRow(jTable.getSelectedRow());
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        if (jTextFieldValid.getText().intern().trim().equals("")) {
        }else{
            v = Integer.parseInt(jTextFieldValid.getText());
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, v);
            jFormattedTextValid.setText(sdf2.format(c.getTime()));
            jTextFieldQtd.requestFocus();
        }
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
        moviment.setQuery("SELECT codigo FROM movimentação WHERE codigo LIKE '9%'");
        MovimentMod model = mov.Buscar2(moviment);
        BigInteger cód = new BigInteger("0");
        BigInteger t = new BigInteger("1");
        int q = 1;
        if (!jTextFieldQtd.getText().isEmpty()) {
            q = Integer.parseInt(jTextFieldQtd.getText().intern().trim());
        }
        for (int i = 0; i < q; i++){
            if (model.getCodigo() == null && jTable.getRowCount() == 0) {
                cód = new BigInteger("9" + String.valueOf(cod.format(dt_atual)) + "001");
            } else if (model.getCodigo() != null && jTable.getRowCount() == 0) {
                if (!model.getCodigo().intern().trim().startsWith("9" + String.valueOf(cod.format(dt_atual)))) {
                    cód = new BigInteger("9" + String.valueOf(cod.format(dt_atual)) + "001");
                    cód.add(t);
                } else if (model.getCodigo().intern().trim().startsWith("9" + String.valueOf(cod.format(dt_atual)))) {
                    cód = new BigInteger(model.getCodigo().intern().trim());
                    cód = cód.add(t);
                }
            } else if (model.getCodigo() != null && jTable.getRowCount() != 0) {
                int a = jTable.getRowCount();
                cód = new BigInteger(String.valueOf(jTable.getValueAt(a - 1, 7)));
                cód = cód.add(t);
            } else if (model.getCodigo() == null && jTable.getRowCount() != 0) {
                int a = jTable.getRowCount();
                cód = new BigInteger(String.valueOf(jTable.getValueAt(a - 1, 7)));
                cód = cód.add(t);
            }
            Object[] dados = {jComboBoxProduto.getSelectedItem(), jComboBoxMetodo.getSelectedItem(), jComboBoxOrigem.getSelectedItem(),
                jFormattedTextProcess.getText(), jFormattedTextValid.getText(), jTextFieldOp.getText(), sdf.format(dt_atual), cód, v};
            Tabela.addRow(dados);
        }
        v = 14;
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        jComboBoxProduto.setSelectedIndex(0);
        jComboBoxMetodo.setSelectedIndex(0);
        jComboBoxOrigem.setSelectedIndex(0);
        jTextFieldQtd.setText("");
        jTextFieldValid.setText("");
        jButtonExcluir.setEnabled(true);
        jButtonConcluir.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jFormattedTextProcess.setText(sdf2.format(dt_atual));
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, v);
        jFormattedTextValid.setText(sdf2.format(c.getTime()));
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

    private void jTextFieldValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValidActionPerformed
        if (jTextFieldValid.getText().intern().trim().equals("")) {
        }else{
            v = Integer.parseInt(jTextFieldValid.getText());
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, v);
            jFormattedTextValid.setText(sdf2.format(c.getTime()));
            jTextFieldQtd.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldValidActionPerformed

    private void jButtonCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadProdActionPerformed
        text = new NovoTextil(this, true);
        text.setVisible(true);
    }//GEN-LAST:event_jButtonCadProdActionPerformed

    private void jButtonCadMetodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMetodActionPerformed
        met = new NovoMétodo(this, true);
        met.setVisible(true);
    }//GEN-LAST:event_jButtonCadMetodActionPerformed

    private void jButtonCadSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadSetorActionPerformed
        setor = new NovoSetor(this, true);
        setor.setVisible(true);
    }//GEN-LAST:event_jButtonCadSetorActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        /*moviment.setBusca(jFormattedTextProcess.getText());
        MovimentMod newlote = mov.ProxLote(moviment);
        if (newlote.getNovolote() == 0) {
            jTextFieldLote.setText("1");
        } else {
            jTextFieldLote.setText(Integer.toString(newlote.getNovolote() + 1));
        }*/
        
        lote.setData(sdf2.format(dt_atual));
        mov.Lote(lote);
        lote.setNum(lote.getNum() + 1);
        mov.NovoLote(lote);
        l = lote.getNum();
        jTextFieldLote.setText(String.valueOf(l));
        
        jButtonNovo.setEnabled(!true);
        jButtonLimpar.setEnabled(true);
        jButtonIncluir.setEnabled(true);
        jButtonAtualizar.setEnabled(true);
        jComboBoxMetodo.setEnabled(true);
        jComboBoxOrigem.setEnabled(true);
        jComboBoxProduto.setEnabled(true);
        jTextFieldQtd.setEnabled(true);
        jTextFieldValid.setEnabled(true);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jComboBoxOrigemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOrigemItemStateChanged
        if (jComboBoxOrigem.getSelectedIndex() > 0) {
            jButtonIncluir.setEnabled(true);
            jTextFieldQtd.setEnabled(true);
        } else {
            jButtonIncluir.setEnabled(!true);
            jTextFieldQtd.setEnabled(!true);
        }
    }//GEN-LAST:event_jComboBoxOrigemItemStateChanged

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceberTextil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceberTextil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceberTextil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceberTextil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReceberTextil dialog = new ReceberTextil(textil, true);
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
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCadMetod;
    private javax.swing.JButton jButtonCadProd;
    private javax.swing.JButton jButtonCadSetor;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxMetodo;
    private javax.swing.JComboBox<String> jComboBoxOrigem;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JFormattedTextField jFormattedTextProcess;
    private javax.swing.JFormattedTextField jFormattedTextValid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelTítulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JTextField jTextFieldValid;
    // End of variables declaration//GEN-END:variables
}
