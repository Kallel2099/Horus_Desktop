package com.knowledge.horus.views;

import Controle.Cme.InstruSQL;
import Controle.Cme.MovimentSQL;
import Controle.Sessão;
import Modelos.Cme.InstruMod;
import Modelos.Cme.MovimentMod;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Danificados extends javax.swing.JDialog {
    
    InstruMod instru = new InstruMod();
    InstruSQL inst = new InstruSQL();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    public static MenuGerenciar dani;

    public Danificados(MenuGerenciar parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextFieldOp.setText(Sessão.getLogado());
        jButtonBuscar.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonConcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jTextFieldCód = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDano = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldOp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jLabelFoto = new javax.swing.JLabel();
        jTextFieldSetor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldOpe = new javax.swing.JTextField();
        jTextFieldSuperv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1230, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Ítem", "Status", "Data do Ocorrido", "Setor de Origem", "Operador", "Supervisor", "Descrição do Ocorrido", "Ação", "Imagem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setOpaque(false);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(80);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable.getColumnModel().getColumn(1).setMinWidth(200);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable.getColumnModel().getColumn(2).setMinWidth(70);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(2).setMaxWidth(70);
            jTable.getColumnModel().getColumn(3).setMinWidth(110);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(3).setMaxWidth(110);
            jTable.getColumnModel().getColumn(4).setMinWidth(150);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable.getColumnModel().getColumn(5).setMinWidth(90);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTable.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable.getColumnModel().getColumn(6).setMinWidth(90);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(90);
            jTable.getColumnModel().getColumn(6).setMaxWidth(90);
            jTable.getColumnModel().getColumn(8).setMinWidth(175);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(8).setMaxWidth(175);
            jTable.getColumnModel().getColumn(9).setMinWidth(50);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(9).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1210, 230));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 70, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 70, 23));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 70, 23));

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.setEnabled(false);
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 70, 23));

        jTextFieldCód.setEnabled(false);
        getContentPane().add(jTextFieldCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 210, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 60, 20));

        jTextFieldDano.setEnabled(false);
        jTextFieldDano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDanoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldDano, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 460, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Descrição do ocorrido");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 110, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ítens danificados ou extraviados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 30));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Operador");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 50, 20));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 110, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Setor de origem");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, 20));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 70, 23));

        jLabelFoto.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setOpaque(true);
        getContentPane().add(jLabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, 180));

        jTextFieldSetor.setEnabled(false);
        getContentPane().add(jTextFieldSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 210, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descrição");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 60, 20));

        jTextFieldDesc.setEnabled(false);
        getContentPane().add(jTextFieldDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 210, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Operador");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 50, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Supervisor");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 60, 20));

        jTextFieldOpe.setEnabled(false);
        getContentPane().add(jTextFieldOpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 210, -1));

        jTextFieldSuperv.setEnabled(false);
        getContentPane().add(jTextFieldSuperv, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 210, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Selecione uma ação.");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 140, 30));

        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, 200));

        jRadioButton1.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Solucionado no local.");
        jRadioButton1.setEnabled(false);
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, 20));

        jRadioButton2.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Enviado para manutenção.");
        jRadioButton2.setEnabled(false);
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, -1, 20));

        jRadioButton3.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Descartado.");
        jRadioButton3.setEnabled(false);
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 80, -1, 20));

        jRadioButton4.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Descartado e substituído.");
        jRadioButton4.setEnabled(false);
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, -1, 20));

        jRadioButton5.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Descartado e aguardando compra.");
        jRadioButton5.setToolTipText("");
        jRadioButton5.setEnabled(false);
        getContentPane().add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 240, 20));

        jRadioButton6.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("Extraviado.");
        jRadioButton6.setEnabled(false);
        getContentPane().add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, -1, 20));

        jRadioButton7.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setText("Extraviado e substituído.");
        jRadioButton7.setEnabled(false);
        getContentPane().add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, -1, 20));

        jRadioButton8.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setText("Extraviado e aguardando compra.");
        jRadioButton8.setEnabled(false);
        getContentPane().add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, -1, 20));

        jRadioButton9.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("Encontrado.");
        jRadioButton9.setEnabled(false);
        getContentPane().add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, -1, 20));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1240, 510));

        setBounds(125, 125, 1230, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(rootPane, "Cancelar o tratamento?\n");
        if (sair == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        if (jRadioButton1.isSelected() || jRadioButton2.isSelected() ||
            jRadioButton3.isSelected() || jRadioButton4.isSelected() ||
            jRadioButton5.isSelected() || jRadioButton6.isSelected() ||
            jRadioButton7.isSelected() || jRadioButton8.isSelected() ||
            jRadioButton9.isSelected()){
            if (jTable.isRowSelected(jTable.getSelectedRow())) {
                int lin = jTable.getSelectedRow();
                jTable.setValueAt(jTextFieldDano.getText(), lin, 7);
                if (jRadioButton1.isSelected()) {
                    jTable.setValueAt("Solucionado no local.", lin, 8);
                }
                if (jRadioButton2.isSelected()) {
                    jTable.setValueAt("Enviado para manutenção.", lin, 8);
                }
                if (jRadioButton3.isSelected()) {
                    jTable.setValueAt("Descartado.", lin, 8);
                }
                if (jRadioButton4.isSelected()) {
                    jTable.setValueAt("Descartado e substituído.", lin, 8);
                }
                if (jRadioButton5.isSelected()) {
                    jTable.setValueAt("Descartado e aguardando compra.", lin, 8);
                }
                if (jRadioButton6.isSelected()) {
                    jTable.setValueAt("Extraviado.", lin, 8);
                }
                if (jRadioButton7.isSelected()) {
                    jTable.setValueAt("Extraviado e substituído.", lin, 8);
                }
                if (jRadioButton8.isSelected()) {
                    jTable.setValueAt("Extraviado e aguardando compra.", lin, 8);
                }
                if (jRadioButton9.isSelected()) {
                    jTable.setValueAt("Encontrado.", lin, 8);
                }
                jTable.clearSelection();
            }
            jButtonConcluir.setEnabled(true);
            jTextFieldCód.setText("");
            jTextFieldDesc.setText("");
            jTextFieldOpe.setText("");
            jTextFieldSetor.setText("");
            jTextFieldSuperv.setText("");
            jTextFieldDano.setText("");
            jTextFieldDano.setEnabled(!true);
            buttonGroup1.clearSelection();
            jButtonIncluir.setEnabled(!true);
            jRadioButton1.setEnabled(!true);
            jRadioButton2.setEnabled(!true);
            jRadioButton3.setEnabled(!true);
            jRadioButton4.setEnabled(!true);
            jRadioButton5.setEnabled(!true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma ação antes de continuar.");
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldCód.setText("");
        jTextFieldDano.setText("");
        jTextFieldDesc.setText("");
        jTextFieldOpe.setText("");
        jTextFieldSetor.setText("");
        jTextFieldSuperv.setText("");
        jLabelFoto.setIcon(null);
        buttonGroup1.clearSelection();
        DefaultTableModel Tabela = (DefaultTableModel) jTable.getModel();
        while ( 0 != jTable.getRowCount()){
            Tabela.removeRow(0);
        }
        jTextFieldDano.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jButtonLimpar.setEnabled(!true);
        jButtonBuscar.setEnabled(true);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        java.util.Date dt_atual = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data = sdf.format(dt_atual);
        int r = jTable.getRowCount();
        for (int i = 0; i < r; i++ ){
            String M = (String) jTable.getValueAt(i, 8);
            if (M != null) {
                if (M.intern().trim().equals("Enviado para manutenção.")) {
                    moviment.setStatus("Em manutenção");
                }
                if (M.intern().trim().contains("Descartado")) {
                    moviment.setStatus("Descartado");
                }
                if (M.intern().trim().contains("Solucionado")) {
                    moviment.setStatus("Tratado");
                }
                if (M.intern().trim().contains("Extraviado")) {
                    moviment.setStatus("Extraviado");
                }
                if (M.intern().trim().contains("Encontrado")) {
                    moviment.setStatus("Tratado");
                }
                moviment.setCodigo((String) jTable.getValueAt(i, 0));
                moviment.setDesc((String) jTable.getValueAt(i, 1));
                moviment.setOcor((String) jTable.getValueAt(i, 3));
                moviment.setData(data);
                moviment.setSetor((String) jTable.getValueAt(i, 4));
                moviment.setDano((String) jTable.getValueAt(i, 7));
                moviment.setAção((String) jTable.getValueAt(i, 8));
                moviment.setOp(jTextFieldOp.getText());
                moviment.setSuperv("");
                moviment.setQtd(1);
                mov.Salvar(moviment);
                mov.EditarDanif(moviment);
            }
        }
        DefaultTableModel Tabela = (DefaultTableModel) jTable.getModel();
        while ( 0 != jTable.getRowCount()){
            Tabela.removeRow(0);
        }
        jTextFieldCód.setText("");
        jTextFieldDano.setText("");
        jTextFieldDesc.setText("");
        jTextFieldOpe.setText("");
        jTextFieldSetor.setText("");
        jTextFieldSuperv.setText("");
        jLabelFoto.setIcon(null);
        buttonGroup1.clearSelection();
        jButtonConcluir.setEnabled(!true);
        jButtonLimpar.setEnabled(!true);
        jButtonIncluir.setEnabled(!true);
        jButtonBuscar.setEnabled(true);
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        moviment.setBusca("");
        MovimentMod model = mov.BuscarDanif(moviment);
        int r = model.getR();
        model.setPos(1);
        for (int i = 0; i < r; i++) {
            model = mov.BuscarDanif(moviment);
            instru.setBusca(model.getCodigo().intern().trim());
            inst.Buscar(instru);
            DefaultTableModel Tabela = (DefaultTableModel) jTable.getModel();
            Object[] dados = {model.getCodigo(), model.getDesc(), model.getStatus(), model.getData(), 
                model.getSetor(), model.getOp(), model.getSuperv(), model.getDano(), model.getAção(), instru.getImagem()};
            Tabela.addRow(dados);
            moviment.setPos(i + 2);
        }
        if (jTable.getRowCount() != 0){
            jButtonLimpar.setEnabled(true);
            jButtonBuscar.setEnabled(!true);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int i = jTable.getSelectedRow();
        jTextFieldCód.setText((String) jTable.getValueAt(i, 0));
        jTextFieldDesc.setText((String) jTable.getValueAt(i, 1));
        jTextFieldOpe.setText((String) jTable.getValueAt(i, 5));
        jTextFieldSuperv.setText((String) jTable.getValueAt(i, 6));
        jTextFieldSetor.setText((String) jTable.getValueAt(i, 4));
        InputStream input = new ByteArrayInputStream((byte[]) jTable.getValueAt(i, 9));
        try {
            BufferedImage imagem = ImageIO.read(input);
            double imgAltura = 140;
            double imgLargura = 187;
            Double novaImgLargura = (double) imagem.getWidth();
            Double novaImgAltura = (double) imagem.getHeight();
            if (novaImgLargura >= imgLargura) {
                Double imgProporcao = (double) (novaImgAltura / novaImgLargura);
                novaImgLargura = (double) imgLargura;
                novaImgAltura = (novaImgLargura * imgProporcao);
                while (novaImgAltura > imgAltura) {
                    novaImgLargura = (double) (--imgLargura);
                    novaImgAltura = (novaImgLargura * imgProporcao);
                }
            } else if (novaImgAltura >= imgAltura) {
                Double imgProporcao = (double) (novaImgLargura / novaImgAltura);
                novaImgAltura = (double) imgAltura;
                while (novaImgLargura > imgLargura) {
                    novaImgAltura = (double) (--imgAltura);
                    novaImgLargura = (novaImgAltura * imgProporcao);
                }
            }
            BufferedImage novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(),
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = novaImagem.createGraphics();
            g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);
            jLabelFoto.setIcon(new ImageIcon(novaImagem));
        } catch (IOException ex) {

        }
        jTextFieldDano.setEnabled(true);
        jTextFieldDano.requestFocus();
    }//GEN-LAST:event_jTableMouseClicked

    private void jTextFieldDanoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDanoKeyTyped
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jRadioButton5.setEnabled(true);
        jRadioButton6.setEnabled(true);
        jRadioButton7.setEnabled(true);
        jRadioButton8.setEnabled(true);
        jRadioButton9.setEnabled(true);
        jButtonIncluir.setEnabled(true);
    }//GEN-LAST:event_jTextFieldDanoKeyTyped

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Danificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Danificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Danificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Danificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Danificados dialog = new Danificados(dani, true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldCód;
    private javax.swing.JTextField jTextFieldDano;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldOpe;
    private javax.swing.JTextField jTextFieldSetor;
    private javax.swing.JTextField jTextFieldSuperv;
    // End of variables declaration//GEN-END:variables
}
