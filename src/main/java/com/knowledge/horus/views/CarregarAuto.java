package com.knowledge.horus.views;

import Controle.Cme.EquipamentosSQL;
import Controle.Cme.InstruSQL;
import Controle.Cme.MovimentSQL;
import Controle.Sessão;
import Modelos.Cme.EquipamentosMod;
import Modelos.Cme.InstruMod;
import Modelos.Cme.MovimentMod;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CarregarAuto extends javax.swing.JDialog {
    
    EquipamentosMod equipa = new EquipamentosMod();
    EquipamentosSQL equip = new EquipamentosSQL();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    InstruMod instru = new InstruMod();
    InstruSQL inst = new InstruSQL();
    public static Cme car;
    public static CicloIni ini;
    int e = 0;
    String v = "";
    java.util.Date dt_atual = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel Tabela;

    public CarregarAuto(Cme parent, boolean modal) {
        super (parent, modal);
        initComponents();
        Tabela = (DefaultTableModel) jTable.getModel();
        jTextFieldOp.setText(Sessão.getLogado());
        jTextFieldAutoCód.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldAutoCód = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jTextFieldCód = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAutoNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCiclo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldLote = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonLimpar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jTextFieldOp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldItens = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonTestes = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldAutoCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAutoCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAutoCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código do Autoclave:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 20));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Embalagem", "Validade", "Data e Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setCellSelectionEnabled(false);
        jTable.setRowSelectionAllowed(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(100);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable.getColumnModel().getColumn(2).setMinWidth(100);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable.getColumnModel().getColumn(3).setMinWidth(80);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable.getColumnModel().getColumn(4).setMinWidth(110);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(4).setMaxWidth(110);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 730, 450));

        jTextFieldCód.setEnabled(false);
        jTextFieldCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 130, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código do ítem:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 80, 20));

        jTextFieldDesc.setEnabled(false);
        getContentPane().add(jTextFieldDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 450, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descrição:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 80, 20));

        jTextFieldAutoNum.setEnabled(false);
        getContentPane().add(jTextFieldAutoNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 70, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Autoclave:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 20));

        jTextFieldCiclo.setEnabled(false);
        getContentPane().add(jTextFieldCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 50, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ciclo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 30, 20));

        jTextFieldLote.setEnabled(false);
        getContentPane().add(jTextFieldLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 70, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lote:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 30, 20));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 80, 23));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 80, 23));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 80, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, 80, 23));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 120, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Operador");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 60, 20));

        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 40, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("N° de ítens");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 570, 60, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Carregar Autoclave");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 30));

        jButtonTestes.setText("Testes");
        jButtonTestes.setEnabled(false);
        jButtonTestes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTestes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 80, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 630));

        setSize(new java.awt.Dimension(748, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAutoCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAutoCódActionPerformed
        equipa.setBusca(jTextFieldAutoCód.getText().intern().trim());
        EquipamentosMod equipam = equip.Buscar(equipa);
        if (equipam.getCódigo() != null) {
            if (equipam.getStatus().intern().trim().equalsIgnoreCase("Ocupado")) {
                JOptionPane.showMessageDialog(null, "<html><center>Este equipamento"
                        + " encontra-se ocupado!<br>", "", JOptionPane.DEFAULT_OPTION);
                jTextFieldAutoCód.setText("");
                jTextFieldAutoCód.requestFocus();
            } else {
                jTextFieldCód.setEnabled(true);
                jTextFieldCód.requestFocus();
                jTextFieldAutoCód.setEnabled(!true);
                jTextFieldAutoNum.setText(equipam.getId().intern().trim());
                moviment.setPos(0);
                moviment.setQuery("SELECT * FROM movimentação WHERE id = '"+equipam.getId()+"'"
                        + " AND data LIKE '%"+sdf2.format(dt_atual)+"%'");
                MovimentMod newciclo = mov.Buscar2(moviment);
                if (newciclo.getCiclo() == 0) {
                    jTextFieldCiclo.setText("1");
                } else {
                    jTextFieldCiclo.setText(Integer.toString(newciclo.getCiclo() + 1));
                }
                jButtonTestes.setEnabled(true);
            }
        } else {
            jTextFieldAutoCód.setText("");
            jTextFieldAutoCód.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldAutoCódActionPerformed

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        instru.setBusca(jTextFieldCód.getText());
        InstruMod instrum = inst.Buscar(instru);
        if (instrum.getOk() == 1){
            moviment.setPos(0);
            moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+jTextFieldCód.getText().intern().trim()+"' "
                    + "AND concluido IS NULL");
            MovimentMod model = mov.Buscar2(moviment);
            e = 0;
            if (model.getStatus().intern().trim().equals("Preparando")) {
                if (model.getEmba().intern().trim().equals("Grau Cirúrgico")) {
                    v = "180 dias";
                }
                if (model.getEmba().intern().trim().equals("SMS")) {
                    v = "90 dias";
                }
                if (model.getEmba().intern().trim().equals("Tecido")) {
                    v = "14 dias";
                }
                if (Tabela.getRowCount() == 0) {
                    if (model.getPertence() == null) {
                        Object[] conteúdo = {model.getCodigo(), model.getDesc(), model.getEmba(), v, sdf.format(dt_atual)};
                        Tabela.addRow(conteúdo);
                    } else if (model.getPertence().intern().trim().equalsIgnoreCase("Bandeja")
                            || model.getPertence().intern().trim().equalsIgnoreCase("Caixa")
                            || model.getPertence().intern().trim().equalsIgnoreCase("Kit")) {
                        Object[] conteúdo = {model.getCodigo(), model.getFantasia(), model.getEmba(), v, sdf.format(dt_atual)};
                        Tabela.addRow(conteúdo);
                    } else {
                        int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atençao!<br>Este ítem pertence à(o) "
                                + model.getFantasia() + " <br>Gostaria carrega-lo separadamente?<br>", "", JOptionPane.YES_NO_OPTION);
                        if (c == 0) {
                        Object[] conteúdo = {model.getCodigo(), model.getDesc(), model.getEmba(), v, sdf.format(dt_atual)};
                        Tabela.addRow(conteúdo);
                        } else {
                            jTextFieldCód.setText("");
                            jTextFieldDesc.setText("");
                            jTextFieldCód.requestFocus();
                        }
                    }
                    jButtonLimpar.setEnabled(true);
                    jButtonExcluir.setEnabled(true);
                    jButtonConcluir.setEnabled(true);
                    jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                    jTextFieldLote.setText(String.valueOf(model.getLote()));
                } else if (model.getLote() == (Integer.parseInt(jTextFieldLote.getText().intern().trim()))) {
                    jTextFieldDesc.setText(model.getDesc().intern().trim());
                    if (Tabela.getRowCount() != 0) {
                        for (int i = 0; i < Tabela.getRowCount(); i++) {
                            if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela.getValueAt(i, 0)).intern().trim())){
                                e = 1;
                                int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atençao!<br>Este ítem já foi "
                                        + "incluído à carga!<br>Gostaria de exclui-lo?<br>", "", JOptionPane.YES_NO_OPTION);
                                if (c == 0) {
                                    Tabela.removeRow(i);
                                    jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                                    if (Tabela.getRowCount() == 0) {
                                        jButtonLimpar.setEnabled(!true);
                                        jButtonExcluir.setEnabled(!true);
                                        jButtonConcluir.setEnabled(!true);
                                    }
                                }
                            }
                        }
                        if (e == 0){
                            if (model.getPertence() == null) {
                                Object[] conteúdo = {model.getCodigo(), model.getDesc(), model.getEmba(), v, sdf.format(dt_atual)};
                                Tabela.addRow(conteúdo);
                            } else if (model.getPertence().intern().trim().equalsIgnoreCase("Bandeja")
                                    || model.getPertence().intern().trim().equalsIgnoreCase("Caixa")
                                    || model.getPertence().intern().trim().equalsIgnoreCase("Kit")) {
                                Object[] conteúdo = {model.getCodigo(), model.getFantasia(), model.getEmba(), v, sdf.format(dt_atual)};
                                Tabela.addRow(conteúdo);
                            } else {
                                int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atençao!<br>Este ítem pertence à(o) "
                                        + model.getFantasia() + " <br>Gostaria carrega-lo separadamente?<br>", "", JOptionPane.YES_NO_OPTION);
                                if (c == 0) {
                                Object[] conteúdo = {model.getCodigo(), model.getDesc(), model.getEmba(), v, sdf.format(dt_atual)};
                                Tabela.addRow(conteúdo);
                                } else {
                                    jTextFieldCód.setText("");
                                    jTextFieldDesc.setText("");
                                    jTextFieldCód.requestFocus();
                                }
                            }
                        }
                    }
                    jButtonLimpar.setEnabled(true);
                    jButtonExcluir.setEnabled(true);
                    jButtonConcluir.setEnabled(true);
                    jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                } else {
                    JOptionPane.showMessageDialog(null, "<html><center>O ítem não pertence ao lote "
                        + (jTextFieldLote.getText().intern().trim()) + "!<br>", "", JOptionPane.DEFAULT_OPTION);
                }
            } else if (model.getStatus().intern().trim().equals("Esterilizando")) {
                    JOptionPane.showMessageDialog(null, "<html><center>O ítem já foi carregado!<br>", "", JOptionPane.DEFAULT_OPTION);
            }else if (model.getStatus().intern().trim().equals("Lavando")) {
                JOptionPane.showMessageDialog(null, "<html><center>O ítem não foi preparado!<br>", "", JOptionPane.DEFAULT_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "<html><center>O ítem não foi preparado!<br>", "", JOptionPane.DEFAULT_OPTION);
            }
        }
        jTextFieldCód.setText("");
        jTextFieldDesc.setText("");
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        if (Tabela.getRowCount() != 0) {
            int limpar = JOptionPane.showConfirmDialog(rootPane, "<html><center>Limpar a lista"
                    + " de itens carregados?<br>", "", JOptionPane.YES_NO_OPTION);
            if (limpar == JOptionPane.YES_OPTION) {
                while ( 0 != Tabela.getRowCount()){
                    Tabela.removeRow(0);
                }
            }
        }
        jTextFieldLote.setText("");
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        jButtonLimpar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int Ex = jTable.getSelectedRowCount();
        if (Ex != 0) {
            while ( 0 != jTable.getSelectedRowCount()){
                Tabela.removeRow(jTable.getSelectedRow());
            }
        }
        if (Tabela.getRowCount() == 0) {
            jTextFieldLote.setText("");
        }
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonTestesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTestesActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        do {
            ini = new CicloIni (this, true);
            ini.setVisible(true);
        } while(!ini.equipa.getCódigo().intern().trim().equalsIgnoreCase(equipa.getCódigo().intern().trim()));
        for (int i = 0; i < Tabela.getRowCount(); i++ ){
            moviment.setPos(0);
            moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+(String) Tabela.getValueAt(i, 0)+"' "
                    + "AND status = 'Preparando' AND concluido IS NULL");
            MovimentMod model = mov.Buscar2(moviment);
            moviment.setCodigo((String) Tabela.getValueAt(i, 0));
            moviment.setDesc(model.getDesc().intern().trim());
            moviment.setEmba((String) Tabela.getValueAt(i, 2));
            moviment.setData((String) Tabela.getValueAt(i, 4));
            moviment.setId(jTextFieldAutoNum.getText());
            moviment.setLote(Integer.parseInt(jTextFieldLote.getText()));
            moviment.setCiclo(Integer.parseInt(jTextFieldCiclo.getText()));
            moviment.setOp(jTextFieldOp.getText());
            moviment.setQtd(Integer.parseInt(jTextFieldItens.getText()));
            moviment.setInicio(String.valueOf(sdf.format(dt_atual)));
            moviment.setSetor(model.getSetor().intern().trim());
            moviment.setMetodo("Esterilização à vapor");
            moviment.setStatus("Esterilizando");
            moviment.setProcess(model.getProcess().intern().trim());
            moviment.setValid(model.getValid().intern().trim());
            moviment.setPrazo(model.getPrazo());
            moviment.setPertence(model.getPertence());
            moviment.setFantasia(model.getFantasia());
            mov.Salvar(moviment);
            moviment.setQuery("UPDATE movimentação SET concluido = 'Ok' "
                + "WHERE codigo = '"+(String) Tabela.getValueAt(i, 0)+"' AND status = 'Preparando' "
                    + "AND concluido IS NULL");
            mov.Atualizar(moviment);
            if (model.getPertence() != null) {
                if (model.getPertence().intern().trim().equalsIgnoreCase("Bandeja")
                        || model.getPertence().intern().trim().equalsIgnoreCase("Caixa")
                        || model.getPertence().intern().trim().equalsIgnoreCase("Kit")) {
                    moviment.setPos(0);
                    moviment.setQuery("SELECT * FROM movimentação WHERE pertence = '"+(String) Tabela.getValueAt(i, 0)+"'"
                            + " AND status = 'Esterilizando' AND concluido IS NULL");
                    MovimentMod model2 = mov.Buscar2(moviment);
                    int r = model2.getR();
                    model2.setPos(1);
                    for (int j = 0; j < r; j++) {
                        model2 = mov.Buscar2(moviment);
                        moviment.setCodigo(model2.getCodigo().intern().trim());
                        moviment.setDesc(model2.getDesc().intern().trim());
                        moviment.setEmba(model2.getEmba().intern().trim());
                        moviment.setData((String) Tabela.getValueAt(i, 4));
                        moviment.setId(jTextFieldAutoNum.getText());
                        moviment.setLote(Integer.parseInt(jTextFieldLote.getText()));
                        moviment.setCiclo(Integer.parseInt(jTextFieldCiclo.getText()));
                        moviment.setOp(jTextFieldOp.getText());
                        moviment.setQtd(Integer.parseInt(jTextFieldItens.getText()));
                        moviment.setInicio(sdf.format(dt_atual));
                        moviment.setSetor(model2.getSetor().intern().trim());
                        moviment.setMetodo("Esterilização à vapor");
                        moviment.setStatus("Esterilizando");
                        moviment.setProcess(model2.getProcess().intern().trim());
                        moviment.setValid(model2.getValid().intern().trim());
                        moviment.setPrazo(model2.getPrazo());
                        moviment.setPertence(model2.getPertence());
                        moviment.setFantasia(model2.getFantasia());
                        mov.Salvar(moviment);
                        model2.setPos(j + 2);
                    }
                    moviment.setQuery("UPDATE movimentação SET concluido = 'Ok' "
                        + "WHERE pertence = '"+(String) Tabela.getValueAt(i, 0)+"' AND status = 'Preparando' "
                            + "AND concluido IS NULL");
                    mov.Atualizar(moviment);
                }
            }
        }
        equipa.setStatus("Ocupado");
        equip.Editar(equipa);
        if (Tabela.getRowCount() != 0) {
            while ( 0 != jTable.getRowCount()){
                Tabela.removeRow(0);
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        jButtonLimpar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonTestes.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jTextFieldAutoNum.setText("");
        jTextFieldCiclo.setText("");
        jTextFieldLote.setText("");
        jTextFieldCód.setEnabled(!true);
        jTextFieldAutoCód.setEnabled(true);
        jTextFieldAutoCód.setText("");
        jTextFieldAutoCód.requestFocus();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        if (Tabela.getRowCount() != 0) {
            int sair = JOptionPane.showConfirmDialog(rootPane, "<html><center>Deseja "
                    + "cancelar o carregamento?<br>", "", JOptionPane.YES_NO_OPTION);
            if (sair == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
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
            java.util.logging.Logger.getLogger(CarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CarregarAuto dialog = new CarregarAuto(car, true);
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
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonTestes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldAutoCód;
    private javax.swing.JTextField jTextFieldAutoNum;
    private javax.swing.JTextField jTextFieldCiclo;
    private javax.swing.JTextField jTextFieldCód;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldOp;
    // End of variables declaration//GEN-END:variables
}
