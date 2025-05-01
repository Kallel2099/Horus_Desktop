package com.knowledge.horus.views;

import com.knowledge.horus.controls.ArsenalDAO;
import com.knowledge.horus.controls.ManipularImagem;
import com.knowledge.horus.models.Arsenal;
import com.knowledge.horus.models.Caixa;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NovaCaixa extends javax.swing.JDialog {
    
    BufferedImage novaImagem;
    int n = 0;
    int e = 0;
    public static MenuGerenciar novacx;
    List<Arsenal> lista = null;
    Arsenal instru = new Arsenal();
    Caixa caixa = new Caixa();
    int tot = 0;
    
    public NovaCaixa(MenuGerenciar parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //caixa.setStatus(0);
        //caixa.setPos(0);
    }
    
    public void buscarArsenal(Long inst){
        lista = new ArsenalDAO().findByCod(inst);
        tot = lista.size();
    }
    
    public void buscarMov(Long inst){
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNomeCx = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCódCx = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCódInst = new javax.swing.JTextField();
        jTextFieldDescrição = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelImagem = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldItens = new javax.swing.JTextField();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonExcluirCaixa = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Conteúdo da caixa");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 450, 20));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setColumnSelectionAllowed(true);
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(100);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 450));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nova caixa");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jTextFieldNomeCx.setEnabled(false);
        jTextFieldNomeCx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeCxActionPerformed(evt);
            }
        });
        jTextFieldNomeCx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeCxKeyTyped(evt);
            }
        });
        jPanel2.add(jTextFieldNomeCx);
        jTextFieldNomeCx.setBounds(90, 40, 260, 20);

        jLabel3.setText("Código");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 60, 20);

        jLabel5.setText("Nome da Caixa");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 40, 80, 20);

        jTextFieldCódCx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódCxActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldCódCx);
        jTextFieldCódCx.setBounds(90, 10, 260, 20);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 360, 70));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel6.setText("Código");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 10, 70, 20);

        jTextFieldCódInst.setEnabled(false);
        jTextFieldCódInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódInstActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCódInst);
        jTextFieldCódInst.setBounds(80, 10, 270, 20);

        jTextFieldDescrição.setEnabled(false);
        jTextFieldDescrição.setFocusable(false);
        jPanel1.add(jTextFieldDescrição);
        jTextFieldDescrição.setBounds(80, 40, 270, 20);

        jLabel7.setText("Descrição");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 40, 70, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 360, 70));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Instrumental");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 360, 20));

        jLabelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabelImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 360, 270));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ítens");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 490, 40, 20));

        jTextFieldItens.setEditable(false);
        jTextFieldItens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 40, 20));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 70, 23));

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 70, 23));

        jButtonExcluir.setText("Excluir Ítem");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 100, 23));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 70, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 70, 23));

        jButtonExcluirCaixa.setText("Excluir Caixa");
        jButtonExcluirCaixa.setEnabled(false);
        jButtonExcluirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirCaixaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluirCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 100, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 520));

        setSize(new java.awt.Dimension(839, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCódInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódInstActionPerformed
        buscarArsenal(Long.parseLong(jTextFieldCódInst.getText()));
        if (tot == 1) {
            instru = lista.get(0);
            if (instru.getTipo().equalsIgnoreCase("Instrumental") && !instru.getItem().equalsIgnoreCase("Caixa") ||
                instru.getTipo().equalsIgnoreCase("Instrumental") && !instru.getItem().equalsIgnoreCase("Bandeja") ||
                instru.getTipo().equalsIgnoreCase("Instrumental") && !instru.getItem().equalsIgnoreCase("Kit")) {
                jTextFieldDescrição.setText(instru.getDescricao().trim());
                ManipularImagem.exibiImagemLabel(instru.getImagem(), jLabelImagem);
                jButtonSalvar.setEnabled(true);
                int n = 0;
                int rows = jTable.getRowCount();
                if (rows == 0) {
                    DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                    Object[] conteúdo = {jTextFieldCódInst.getText(), jTextFieldDescrição.getText(), novaImagem};
                    Tabela1.addRow(conteúdo);
                }
                if (rows != 0){
                    for (int i = 0; i < rows; i++) {
                        if (jTextFieldCódInst.getText().intern().trim().equals 
                        (((String) jTable.getValueAt(i, 0)).intern().trim())){
                            n = 1;
                            int duplicado = JOptionPane.showConfirmDialog(rootPane, "Atençao.\nEste instrumental já foi "
                                    + "incluído na caixa!\nGostaria de exclui-lo?\n");
                            if (duplicado == JOptionPane.YES_OPTION) {
                                DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                                Tabela1.removeRow(i);
                                jTextFieldDescrição.setText("");
                                jLabelImagem.setIcon(null);
                                JOptionPane.showMessageDialog(rootPane, "Excluido!");
                                rows = jTable.getRowCount();
                                jTextFieldItens.setText(String.valueOf(rows));
                            }
                        }  
                    }
                    if (n == 0) {
                        DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                        Object[] conteúdo = {jTextFieldCódInst.getText(), jTextFieldDescrição.getText(), novaImagem};
                        Tabela1.addRow(conteúdo);
                    }
                }
                rows = jTable.getRowCount();
                jTextFieldItens.setText(String.valueOf(rows));
                jTextFieldCódInst.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "O código não pertence a um instrumental.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ítem não encontrado.");
        }
    }//GEN-LAST:event_jTextFieldCódInstActionPerformed
        
    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        /*if (caixa.getStatus() == 1) {
            jTextFieldCódCx.setText("");
            jTextFieldNomeCx.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódCx.setEnabled(true);
            jTextFieldCódCx.grabFocus();
            jLabelImagem.setIcon(null);
            jButtonEditar.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonSalvar.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonExcluirCaixa.setEnabled(!true);
            caixa.setPos(0);
        }
        else{
            int limpar = JOptionPane.showConfirmDialog(rootPane, "Atençao.\nTodos os ítens da tabela serão "
                    + "excluídos.\nContinuar?\n");
            if (limpar == JOptionPane.YES_OPTION) {
                jTextFieldCódCx.setText("");
                jTextFieldNomeCx.setText("");
                jTextFieldEspecialidade.setText("");
                jTextFieldCódInst.setText("");
                jTextFieldDescrição.setText("");
                jTextFieldItens.setText("");
                DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                while ( 0 != jTable.getRowCount()){
                    Tabela1.removeRow(0);
                }
                jTextFieldCódInst.setEnabled(!true);
                jTextFieldCódCx.setEnabled(true);
                jTextFieldCódCx.grabFocus();
                jLabelImagem.setIcon(null);
                jButtonEditar.setEnabled(!true);
                jButtonExcluir.setEnabled(!true);
                jButtonSalvar.setEnabled(!true);
                jButtonLimpar.setEnabled(!true);
                jButtonExcluirCaixa.setEnabled(!true);
            }
        }*/
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int tupla = JOptionPane.showConfirmDialog(rootPane, "Retirar instrumental da caixa?\n");
        if (tupla == JOptionPane.YES_OPTION) {
            if (jTable.isRowSelected(jTable.getSelectedRow())) {
                DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                Tabela1.removeRow(jTable.getSelectedRow());
            }
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            int o = Tabela1.getRowCount();
            if (o == 0){
                jButtonExcluir.setEnabled(!true);
                jTextFieldNomeCx.grabFocus();
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        /*if (e == 0) {
            caixa.setCódCx(jTextFieldCódCx.getText());
            cxa.Criar(caixa);
            for (int i = 0; i < (jTable.getRowCount()); i++ ){
            caixa.setCódInst((String) jTable.getValueAt(i, 0));
            caixa.setDesInst((String) jTable.getValueAt(i, 1));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            caixa.setImgInst((byte[]) baos.toByteArray());
            cxa.Salvar(caixa);
            }
            jTextFieldCódCx.setText("");
            jTextFieldNomeCx.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódCx.setEnabled(true);
            jTextFieldCódCx.grabFocus();
            jLabelImagem.setIcon(null);
            caixa.setPos(0);
        }else if (e == 1){
            cxa.Limpar(caixa);
            for (int i = 0; i < (jTable.getRowCount()); i++ ){
            caixa.setCódInst((String) jTable.getValueAt(i, 0));
            caixa.setDesInst((String) jTable.getValueAt(i, 1));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            caixa.setImgInst((byte[]) baos.toByteArray());
            cxa.Salvar(caixa);
            }
            jTextFieldCódCx.setText("");
            jTextFieldNomeCx.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódCx.setEnabled(true);
            jTextFieldCódCx.grabFocus();
            jLabelImagem.setIcon(null);
            caixa.setPos(0);
        }
        jButtonSalvar.setEnabled(!true);*/
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        jTable.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jTextFieldCódInst.setEnabled(true);
        jTextFieldCódInst.requestFocus();
        jButtonSalvar.setEnabled(true);
        e = 1;
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirCaixaActionPerformed
        /*int excluir = JOptionPane.showConfirmDialog(rootPane, "Excluir esta caixa do banco de dados?\n");
        if (excluir == JOptionPane.YES_OPTION) {
            cxa.ExcluirCaixa(caixa);
            jTextFieldCódCx.setText("");
            jTextFieldNomeCx.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódCx.setEnabled(true);
            jTextFieldCódCx.grabFocus();
            jLabelImagem.setIcon(null);
            jButtonEditar.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonSalvar.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonExcluirCaixa.setEnabled(!true);
            caixa.setStatus(0);
        }*/
    }//GEN-LAST:event_jButtonExcluirCaixaActionPerformed

    private void jTextFieldCódCxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódCxActionPerformed
        //instru.setBusca(jTextFieldCódCx.getText());
        //InstruMod modeli = inst.Buscar(instru);
        
        buscarArsenal(Long.parseLong(jTextFieldCódCx.getText()));
        if (tot == 1) {
            instru = lista.get(0);
            if (instru.getItem().equalsIgnoreCase("Caixa") && instru.getFantasia().equalsIgnoreCase("")) {
                jTextFieldCódCx.setEnabled(!true);
                jTextFieldNomeCx.setEnabled(true);
                jTextFieldNomeCx.requestFocus();
            } else if (instru.getTipo().equalsIgnoreCase("Caixa") && !instru.getFantasia().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "A caixa já foi cadastrada no sistema.");
            } else {
                JOptionPane.showMessageDialog(null, "O código não pertence a uma caixa.");
                jTextFieldCódCx.setText("");
                jTextFieldCódCx.requestFocus();
            }
        }
        
        
        
        /*
        if (tot == 1){
            instru = lista.get(0);
            jTextFieldCódCx.setEnabled(!true);
            jTextFieldNomeCx.setText(instru.getDescrição().trim());
            jTextFieldEspecialidade.setText(instru.getEspecialidade().trim());
            caixa.setCódCx(jTextFieldCódCx.getText());
            cxa.TestaCaixa(caixa);
            if (caixa.getStatus() == 1){
                JOptionPane.showMessageDialog(null, "Esta caixa já foi cadastrada.\nPara editá-la, clique no botão Editar,"
                + "\nou, para montar uma nova caixa, clique no botão Limpar.");
            }
            jTextFieldCódInst.setEnabled(true);
            jTextFieldCódInst.grabFocus();
            jButtonLimpar.setEnabled(true);
            if (caixa.getStatus() == 1) {
                jTextFieldCódInst.setEnabled(!true);
                jTable.setEnabled(!true);
                caixa.setCódCx(jTextFieldCódCx.getText());
                //CaixaMod model = cxa.Buscar(caixa);
                int f = caixa.getLin();
                caixa.setPos(1);
                for (int i = 0; i < f; i++){
                    model = cxa.Buscar(caixa);
                    DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                    Object[] conteúdo = {model.getCódInst(), model.getDesInst(), model.getImgInst()};
                    Tabela1.addRow(conteúdo);
                    caixa.setPos(i + 2);
                }
            int rows = jTable.getRowCount();
            jTextFieldItens.setText(String.valueOf(rows));
            jButtonEditar.setEnabled(true);
            jButtonExcluirCaixa.setEnabled(true);
            }
        }else if (tot == 0){
            JOptionPane.showMessageDialog(null, "Ítem não encontrado!\n");
            jTextFieldCódCx.setEnabled(true);
            jTextFieldCódCx.setText("");
            instru.setOk(0);
        }*/
    }//GEN-LAST:event_jTextFieldCódCxActionPerformed

    private void jTextFieldNomeCxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeCxKeyTyped
        jTextFieldCódInst.setEnabled(true);
    }//GEN-LAST:event_jTextFieldNomeCxKeyTyped

    private void jTextFieldNomeCxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeCxActionPerformed
        jTextFieldCódInst.requestFocus();
    }//GEN-LAST:event_jTextFieldNomeCxActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovaCaixa dialog = new NovaCaixa(novacx, true);
                //NovaCaixa dialog = new NovaCaixa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExcluirCaixa;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldCódCx;
    private javax.swing.JTextField jTextFieldCódInst;
    private javax.swing.JTextField jTextFieldDescrição;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldNomeCx;
    // End of variables declaration//GEN-END:variables
}
