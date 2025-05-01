package com.knowledge.horus.views;

import Controle.Cme.EquipamentosSQL;
import Controle.Cme.MovimentSQL;
import Controle.Sessão;
import Modelos.Cme.EquipamentosMod;
import Modelos.Cme.MovimentMod;
import Telas.ImpressEtiq;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DescarregarAuto extends javax.swing.JDialog {

    EquipamentosMod equipa = new EquipamentosMod();
    EquipamentosSQL equip = new EquipamentosSQL();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    public static MenuDescarr des;
    public static NãoConforme desc;
    public static ImpressEtiq imp;
    java.util.Date dt_atual = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel Tabela1;
    DefaultTableModel Tabela2;
    
    public DescarregarAuto(MenuDescarr parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Tabela1 = (DefaultTableModel) jTable1.getModel();
        Tabela2 = (DefaultTableModel) jTable2.getModel();
        jTextFieldOp.setText(Sessão.getLogado());
        jTextFieldAutoCód.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldAutoCód = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextFieldAutoId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCiclo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldLote = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonNão = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jTextFieldOp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldItens = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCód = new javax.swing.JTextField();
        jButtonConcluir = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldAutoCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAutoCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldAutoCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código do Autoclave:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ));
        jTable2.setEnabled(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(80);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 370, 470));

        jTextFieldAutoId.setEnabled(false);
        getContentPane().add(jTextFieldAutoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 100, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Autoclave:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 20));

        jTextFieldCiclo.setEnabled(false);
        getContentPane().add(jTextFieldCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 50, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ciclo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 30, 20));

        jTextFieldLote.setEnabled(false);
        getContentPane().add(jTextFieldLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 50, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lote:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 30, 20));

        jButtonNão.setText("Não Conformidade");
        jButtonNão.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNãoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNão, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, 125, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 570, 75, 23));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 120, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Operador:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 60, 20));

        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 570, 40, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("N° de ítens:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 570, 60, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Integridade", "Humidade", "Integrador", "Selagem", "Identificação", "Data e Hora"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(80);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(75);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(3).setMinWidth(75);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(4).setMinWidth(75);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(5).setMinWidth(75);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(6).setMinWidth(75);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(7).setMinWidth(110);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(110);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 840, 470));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conteúdo do Autoclave");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 370, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descarregar Autoclave");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Código do Ítem:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 80, 20));

        jTextFieldCód.setEnabled(false);
        jTextFieldCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 150, -1));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 570, 75, 23));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 75, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1240, 610));

        setBounds(125, 90, 1239, 599);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAutoCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAutoCódActionPerformed
        equipa.setBusca(jTextFieldAutoCód.getText().intern().trim());
        EquipamentosMod equipam = equip.Buscar(equipa);
        if (equipam.getCódigo() != null) {
            if (equipam.getStatus().intern().trim().equalsIgnoreCase("Livre")) {
                JOptionPane.showMessageDialog(null, "<html><center>Este equipamento"
                        + " já foi descarregado!<br>", "", JOptionPane.DEFAULT_OPTION);
                jTextFieldAutoCód.setText("");
                jTextFieldAutoCód.requestFocus();
            } else {
                moviment.setPos(0);
                moviment.setQuery("SELECT * FROM movimentação WHERE id = '"+equipam.getId()+"' "
                        + "AND status = 'Esterilizando' AND fim IS NOT NULL AND concluido IS NULL");
                MovimentMod model = mov.Buscar2(moviment);
                if (model.getStatus() != "") {
                    jTextFieldCód.setEnabled(true);
                    jTextFieldCód.requestFocus();
                    jTextFieldAutoCód.setEnabled(!true);
                    jTextFieldAutoId.setText(equipam.getId().intern().trim());
                    jTextFieldLote.setText(Integer.toString(model.getLote()));
                    jTextFieldCiclo.setText(Integer.toString(model.getCiclo()));
                    jButtonLimpar.setEnabled(true);
                    int r = model.getR();
                    model.setPos(1);
                    for (int i = 0; i < r; i++) {
                        model = mov.Buscar2(moviment);
                        if (model.getPertence() == null) {
                            Object[] dados = {model.getCodigo(), model.getDesc()};
                            Tabela2.addRow(dados);
                        } else if (model.getPertence().intern().trim().equalsIgnoreCase("Bandeja")
                                || model.getPertence().intern().trim().equalsIgnoreCase("Caixa")
                                || model.getPertence().intern().trim().equalsIgnoreCase("Kit")) {
                            Object[] dados = {model.getCodigo(), model.getFantasia()};
                            Tabela2.addRow(dados);
                        } else {
                            Object[] dados = {model.getCodigo(), model.getDesc()};
                            Tabela2.addRow(dados);
                        }
                        moviment.setPos(i + 2);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                            + "O autoclave não foi carregado.<br>"
                            + "ou<br>o ciclo não foi encerrado.", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldAutoCód.setText("");
                    jTextFieldAutoCód.requestFocus();
                }
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
    }//GEN-LAST:event_jTextFieldAutoCódActionPerformed

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        int rows1 = Tabela1.getRowCount();
        int rows2 = Tabela2.getRowCount();
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < rows2; i++) {
            if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela2.getValueAt(i, 0)).intern().trim())){
                Object[] conteúdo = {Tabela2.getValueAt(i, 0), Tabela2.getValueAt(i, 1),
                    "Conforme", "Conforme", "Conforme", "Conforme", "Conforme",  sdf.format(dt_atual)};
                Tabela1.addRow(conteúdo);
                Tabela2.removeRow(i);
                imp = new ImpressEtiq (this, true);
                imp.setVisible(true);
                break;
            } else {
                t2++;
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        if (rows1 != 0) {
            for (int i = 0; i < rows1; i++) {
                if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela1.getValueAt(i, 0)).intern().trim())){
                    JOptionPane.showMessageDialog(null, "<html><center>Ítem já recebido!<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                } else {
                    t1++;
                }
            }
        }
        if (t2 == rows2 && t1 == rows1) {
            JOptionPane.showMessageDialog(null, "<html><center>Este ítem não pertence"
                    + " a esta carga!<br>", "", JOptionPane.DEFAULT_OPTION);
            jTextFieldCód.setText("");
            jTextFieldCód.requestFocus();
        }
        rows2 = Tabela2.getRowCount();
        if (rows2 == 0) {
            jTextFieldCód.setEnabled(!true);
            jButtonConcluir.setEnabled(true);
            jButtonConcluir.requestFocus();
        }
        jTextFieldCód.setText("");
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    private void jButtonNãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNãoActionPerformed
        desc = new NãoConforme (this, true);
        desc.setVisible(true);
        if (desc.confor.getCodig() != null) {
            int rows1 = Tabela1.getRowCount();
            int rows2 = Tabela2.getRowCount();
            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < rows2; i++) {
                if (desc.confor.getCodig().intern().trim().equals(((String) Tabela2.getValueAt(i, 0)).intern().trim())){
                    Object[] conteúdo = {((String) Tabela2.getValueAt(i, 0)).intern().trim(),
                        ((String) Tabela2.getValueAt(i, 1)).intern().trim(), desc.confor.getInteg(), desc.confor.getHumid(),
                        desc.confor.getTeste(), desc.confor.getSelag(), desc.confor.getIdent(), sdf.format(dt_atual)};
                    Tabela1.addRow(conteúdo);
                    Tabela2.removeRow(i);
                    imp = new ImpressEtiq (this, true);
                    imp.setVisible(true);
                    break;
                } else {
                    t2++;
                }
            }
            jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
            if (rows1 != 0) {
                for (int i = 0; i < rows1; i++) {
                    if (desc.confor.getCodig().intern().trim().equals(((String) Tabela1.getValueAt(i, 0)).intern().trim())){
                        Tabela1.setValueAt((String) Tabela1.getValueAt(i, 0), i, 0);
                        Tabela1.setValueAt((String) Tabela1.getValueAt(i, 1), i, 1);
                        Tabela1.setValueAt(desc.confor.getInteg(), i, 2);
                        Tabela1.setValueAt(desc.confor.getHumid(), i, 3);
                        Tabela1.setValueAt(desc.confor.getTeste(), i, 4);
                        Tabela1.setValueAt(desc.confor.getSelag(), i, 5);
                        Tabela1.setValueAt(desc.confor.getIdent(), i, 6);
                        Tabela1.setValueAt(sdf.format(dt_atual), i, 7);
                        jTextFieldCód.setText("");
                        jTextFieldCód.requestFocus();
                    } else {
                        t1++;
                    }
                }
            }
            if (t2 == rows2 && t1 == rows1) {
                JOptionPane.showMessageDialog(null, "<html><center>Este ítem não pertence"
                        + " a esta carga!<br>", "", JOptionPane.DEFAULT_OPTION);
                jTextFieldCód.setText("");
                jTextFieldCód.requestFocus();
            }
            rows2 = Tabela2.getRowCount();
            if (rows2 == 0) {
                jTextFieldCód.setEnabled(!true);
                jButtonConcluir.setEnabled(true);
                jButtonConcluir.requestFocus();
            }
            jTextFieldCód.setText("");
            jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        }
    }//GEN-LAST:event_jButtonNãoActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        int qtd = Tabela1.getRowCount();
        for (int i = 0; i < Tabela1.getRowCount(); i++ ){
            moviment.setPos(0);
            moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+(String) Tabela1.getValueAt(i, 0)+"'"
                    + " AND status = 'Esterilizando' AND fim IS NOT NULL AND concluido IS NULL");
            MovimentMod model = mov.Buscar2(moviment);
            moviment.setCodigo((String) Tabela1.getValueAt(i, 0));
            moviment.setDesc(model.getDesc().intern().trim());
            moviment.setIntegri((String) Tabela1.getValueAt(i, 2));
            moviment.setHumid((String) Tabela1.getValueAt(i, 3));
            moviment.setIntegra((String) Tabela1.getValueAt(i, 4));
            moviment.setSelag((String) Tabela1.getValueAt(i, 5));
            moviment.setIdent((String) Tabela1.getValueAt(i, 6));
            moviment.setData((String) Tabela1.getValueAt(i, 7));
            moviment.setId(jTextFieldAutoId.getText());
            moviment.setLote(Integer.parseInt(jTextFieldLote.getText()));
            moviment.setCiclo(Integer.parseInt(jTextFieldCiclo.getText()));
            moviment.setOp(jTextFieldOp.getText());
            moviment.setFim(model.getFim().intern().trim());
            moviment.setInicio(model.getInicio().intern().trim());
            moviment.setMetodo("Esterilização à vapor");
            moviment.setSetor(model.getSetor().intern().trim());
            moviment.setStatus("Arsenal-CME");
            moviment.setProcess(model.getProcess().intern().trim());
            moviment.setValid(model.getValid().intern().trim());
            moviment.setPrazo(model.getPrazo());
            moviment.setEmba(model.getEmba().intern().trim());
            moviment.setQtd(qtd);
            moviment.setPertence(model.getPertence());
            moviment.setFantasia(model.getFantasia());
            mov.Salvar(moviment);
            moviment.setQuery("UPDATE movimentação SET concluido = 'Ok' "
                + "WHERE codigo = '"+(String) Tabela1.getValueAt(i, 0)+"' AND status = 'Esterilizando' "
                    + "AND concluido IS NULL");
            mov.Atualizar(moviment);
            if (model.getPertence() != null){
                if (model.getPertence().intern().trim().equalsIgnoreCase("Bandeja")
                        || model.getPertence().intern().trim().equalsIgnoreCase("Caixa")
                        || model.getPertence().intern().trim().equalsIgnoreCase("Kit")) {
                    moviment.setPos(0);
                    moviment.setQuery("SELECT * FROM movimentação WHERE pertence = '"+(String) Tabela1.getValueAt(i, 0)+"'"
                            + " AND status = 'Esterilizando' AND concluido IS NULL");
                    MovimentMod model2 = mov.Buscar2(moviment);
                    int r = model2.getR();
                    model2.setPos(1);
                    for (int j = 0; j < r; j++) {
                        model2 = mov.Buscar2(moviment);
                        moviment.setCodigo(model2.getCodigo().intern().trim());
                        moviment.setDesc(model2.getDesc().intern().trim());
                        moviment.setEmba(model2.getEmba().intern().trim());
                        moviment.setData((String) Tabela1.getValueAt(i, 7));
                        moviment.setId(jTextFieldAutoId.getText());
                        moviment.setLote(Integer.parseInt(jTextFieldLote.getText()));
                        moviment.setCiclo(Integer.parseInt(jTextFieldCiclo.getText()));
                        moviment.setOp(jTextFieldOp.getText());
                        moviment.setQtd(qtd);
                        moviment.setInicio(model2.getInicio());
                        moviment.setSetor(model2.getSetor().intern().trim());
                        moviment.setMetodo("Esterilização à vapor");
                        moviment.setStatus("Arsenal-CME");
                        moviment.setProcess(model2.getProcess().intern().trim());
                        moviment.setValid(model2.getValid().intern().trim());
                        moviment.setPrazo(model2.getPrazo());
                        moviment.setIntegri((String) Tabela1.getValueAt(i, 2));
                        moviment.setHumid((String) Tabela1.getValueAt(i, 3));
                        moviment.setIntegra((String) Tabela1.getValueAt(i, 4));
                        moviment.setSelag((String) Tabela1.getValueAt(i, 5));
                        moviment.setIdent((String) Tabela1.getValueAt(i, 6));
                        moviment.setPertence(model2.getPertence().intern().trim());
                        moviment.setFantasia(model2.getFantasia().intern().trim());
                        moviment.setSetor(model2.getSetor().intern().trim());
                        mov.Salvar(moviment);
                        model2.setPos(j + 2);
                    }
                    moviment.setQuery("UPDATE movimentação SET concluido = 'Ok' "
                        + "WHERE pertence = '"+(String) Tabela1.getValueAt(i, 0)+"' AND status = 'Esterilizando' "
                            + "AND concluido IS NULL");
                    mov.Atualizar(moviment);
                }
            }
        }
        equipa.setStatus("Livre");
        equip.Editar(equipa);
        if (Tabela1.getRowCount() != 0) {
            while ( 0 != Tabela1.getRowCount()){
                Tabela1.removeRow(0);
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela1.getRowCount()));
        jButtonConcluir.setEnabled(!true);
        jButtonLimpar.setEnabled(!true);
        jButtonSair.setEnabled(true);
        jTextFieldAutoId.setText("");
        jTextFieldCiclo.setText("");
        jTextFieldLote.setText("");
        jTextFieldCód.setEnabled(!true);
        jTextFieldAutoCód.setEnabled(true);
        jTextFieldAutoCód.setText("");
        jTextFieldAutoCód.requestFocus();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        if (Tabela1.getRowCount() != 0) {
            int sair = JOptionPane.showConfirmDialog(rootPane, "<html><center>Cancelar a descarga"
                    + " do autoclave?<br>", "", JOptionPane.DEFAULT_OPTION);
            if (sair == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldAutoId.setText("");
        jTextFieldCiclo.setText("");
        jTextFieldLote.setText("");
        jTextFieldCód.setText("");
        jTextFieldAutoCód.setText("");
        jTextFieldCód.setEnabled(!true);
        while ( 0 != Tabela1.getRowCount()){
            Tabela1.removeRow(0);
        }
        while ( 0 != Tabela2.getRowCount()){
            Tabela2.removeRow(0);
        }
        jButtonLimpar.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jTextFieldAutoCód.setEnabled(true);
        jTextFieldAutoCód.requestFocus();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DescarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DescarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DescarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DescarregarAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DescarregarAuto dialog = new DescarregarAuto (des, true);
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
    private javax.swing.JButton jButtonNão;
    private javax.swing.JButton jButtonSair;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldAutoCód;
    private javax.swing.JTextField jTextFieldAutoId;
    private javax.swing.JTextField jTextFieldCiclo;
    private javax.swing.JTextField jTextFieldCód;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldOp;
    // End of variables declaration//GEN-END:variables
}
