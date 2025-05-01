package com.knowledge.horus.views;

import Controle.Cme.InstruSQL;
import Controle.Cme.MovimentSQL;
import Controle.Sessão;
import Modelos.Cme.InstruMod;
import Modelos.Cme.LoteMod;
import Modelos.Cme.MovimentMod;
import Modelos.Cme.TroUsuMod;
import Telas.ImpressEtiq;
import java.text.SimpleDateFormat;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import static java.lang.Thread.sleep;

public class PrepararAvulso extends javax.swing.JDialog {

    InstruMod instru = new InstruMod();
    InstruSQL inst = new InstruSQL();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    LoteMod lote = new LoteMod();
    TroUsuMod troca = new TroUsuMod();
    BufferedImage novaImagem;
    int e = 0;
    int l = 0;
    public static LeitorCódP pavulso;
    public static TrocarUsuario sessão;
    public static ImpressEtiq imp;
    java.util.Date dt_atual = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel Tabela;
    
    public PrepararAvulso(LeitorCódP parent, boolean modal) {
        super (parent, modal);
        initComponents();
        Tabela = (DefaultTableModel) jTable.getModel();
        jTextFieldOp.setText(Sessão.getLogado());
        jRadioButton1.setSelected(true);
    }
    
    public void close(){
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonDefeito = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
        jTextFieldCód = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSetor = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldOp = new javax.swing.JTextField();
        jLabelImagem = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldItens = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLote = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preparar Avulso");
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButtonDefeito.setText("Instrumental com defeito");
        jButtonDefeito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDefeito.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonDefeito.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonDefeito.setPreferredSize(new java.awt.Dimension(80, 25));
        jButtonDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefeitoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDefeito);
        jButtonDefeito.setBounds(10, 450, 360, 23);

        jButtonCancelar.setText("Cancelar o preparo");
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar);
        jButtonCancelar.setBounds(10, 510, 360, 23);

        jButtonConcluir.setText("Concluir o preparo");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir);
        jButtonConcluir.setBounds(10, 540, 360, 23);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Setor", "Status", "Embalagem", "Process.", "Validade", "Data e hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(90);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable.getColumnModel().getColumn(0).setMaxWidth(90);
            jTable.getColumnModel().getColumn(3).setMinWidth(80);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable.getColumnModel().getColumn(4).setMinWidth(80);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(4).setMaxWidth(80);
            jTable.getColumnModel().getColumn(5).setMinWidth(70);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(5).setMaxWidth(70);
            jTable.getColumnModel().getColumn(6).setMinWidth(70);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(6).setMaxWidth(70);
            jTable.getColumnModel().getColumn(7).setMinWidth(110);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(7).setMaxWidth(110);
        }

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(380, 30, 760, 560);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel6.setText("Código do instrumental");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 10, 120, 20);

        jTextFieldDesc.setEnabled(false);
        jTextFieldDesc.setFocusable(false);
        jPanel1.add(jTextFieldDesc);
        jTextFieldDesc.setBounds(70, 40, 280, 20);

        jTextFieldCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCód);
        jTextFieldCód.setBounds(130, 10, 220, 20);

        jLabel8.setText("Descrição");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 40, 60, 20);

        jLabel2.setText("Setor");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 70, 40, 20);

        jTextFieldSetor.setEnabled(false);
        jPanel1.add(jTextFieldSetor);
        jTextFieldSetor.setBounds(70, 70, 280, 20);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Grau Cirúrgico");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(130, 100, 93, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("SMS");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(230, 100, 50, 23);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Tecido");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(290, 100, 60, 23);

        jLabel3.setText("Tipo de embalagem");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 100, 110, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 360, 130);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ítens recebidos");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(380, 10, 760, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Preparar instrumental");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 10, 360, 20);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Operador");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 570, 50, 20);

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp);
        jTextFieldOp.setBounds(70, 570, 110, 20);

        jLabelImagem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelImagem.setOpaque(true);
        getContentPane().add(jLabelImagem);
        jLabelImagem.setBounds(10, 170, 360, 270);

        jButtonExcluir.setText("Excluir ítem da lista");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir);
        jButtonExcluir.setBounds(10, 480, 360, 23);

        jTextFieldItens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens);
        jTextFieldItens.setBounds(320, 570, 50, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Ítens");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 570, 40, 20);

        jTextFieldLote.setEnabled(false);
        getContentPane().add(jTextFieldLote);
        jTextFieldLote.setBounds(230, 570, 35, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lote:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 570, 30, 20);

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setMaximumSize(new java.awt.Dimension(920, 590));
        jLabelFundo.setMinimumSize(new java.awt.Dimension(920, 590));
        jLabelFundo.setOpaque(true);
        jLabelFundo.setPreferredSize(new java.awt.Dimension(920, 590));
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 1150, 600);

        setBounds(130, 30, 1150, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        instru.setBusca(jTextFieldCód.getText());
        InstruMod instrum = inst.Buscar(instru);
        moviment.setPos(0);
        moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+jTextFieldCód.getText().intern().trim()+"' AND concluido IS NULL");
        MovimentMod model = mov.Buscar2(moviment);
        if (instrum.getOk() == 1) {
            if (instrum.getItem().intern().trim().equalsIgnoreCase("Instrumental")) {
                if (model.getStatus().intern().trim().equalsIgnoreCase("Lavando")) {
                    if (jTextFieldLote.getText().isEmpty()) {
                        lote.setData(sdf2.format(dt_atual));
                        mov.Lote(lote);
                        lote.setNum(lote.getNum() + 1);
                        mov.NovoLote(lote);
                        l = lote.getNum();
                    }
                    jTextFieldLote.setText(String.valueOf(l));
                    jTextFieldDesc.setText(instrum.getDescrição().intern().trim());
                    jTextFieldSetor.setText(instrum.getSetor().trim());
                    InputStream input = new ByteArrayInputStream(instrum.getImagem());
                    try {
                        BufferedImage imagem = ImageIO.read(input);
                        double imgAltura = 270;
                        double imgLargura = 360;
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
                        novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(),
                            BufferedImage.TYPE_INT_RGB);
                        Graphics2D g2d = novaImagem.createGraphics();
                        g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);
                        jLabelImagem.setIcon(new ImageIcon(novaImagem));
                    } catch (IOException ex) {

                    }
                    jButtonConcluir.setEnabled(true);
                    jButtonExcluir.setEnabled(true);
                    String data = sdf.format(dt_atual);
                    String proc = sdf2.format(dt_atual);
                    e = 0;
                    String emb = "";
                    int v = 0;
                    if (jRadioButton1.isSelected()) {
                        emb = "Grau Cirúrgico";
                        v = 180;
                        jTextFieldCód.requestFocus();
                    } else if (jRadioButton2.isSelected()) {
                        emb = "SMS";
                        v = 90;
                        jTextFieldCód.requestFocus();
                    } else if (jRadioButton3.isSelected()) {
                        emb = "Tecido";
                        v = 14;
                        jTextFieldCód.requestFocus();
                    }
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DAY_OF_MONTH, v);
                    String valid = sdf2.format(cal.getTime());
                    if (Tabela.getRowCount() == 0) {
                        Object[] conteúdo = {jTextFieldCód.getText(), jTextFieldDesc.getText(), jTextFieldSetor.getText(), "Preparando",
                            emb, proc, valid, data};
                        Tabela.addRow(conteúdo);
                    } else if (Tabela.getRowCount() != 0){
                        for (int i = 0; i < Tabela.getRowCount(); i++) {
                            if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela.getValueAt(i, 0)).intern().trim())
                                    && (Tabela.getValueAt(i, 3).equals("Preparando"))){
                                e = 1;
                                int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atençao!<br>Este instrumental já foi "
                                    + "incluído para o preparo!<br>Gostaria de exclui-lo?",
                                    "", JOptionPane.YES_NO_OPTION);
                                if (c == 0) {
                                    Tabela.removeRow(i);
                                    jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                                    if (Tabela.getRowCount() == 0) {
                                        jLabelImagem.setIcon(null);
                                        jButtonExcluir.setEnabled(!true);
                                        jButtonConcluir.setEnabled(!true);
                                    }
                                    jTextFieldCód.setText("");
                                    jTextFieldCód.requestFocus();
                                }
                            }
                            if (Tabela.getRowCount() != 0){
                                if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela.getValueAt(i, 0)).intern().trim()) 
                                        && (Tabela.getValueAt(i, 3).equals("Danificado"))){
                                    e = 1;
                                    JOptionPane.showMessageDialog(rootPane, "<html><center>O ítem já foi "
                                            + "recebido como danificado!<br>", "", JOptionPane.DEFAULT_OPTION);
                                    jTextFieldCód.setText("");
                                    jTextFieldCód.requestFocus();
                                }
                            }
                        }
                        if (e == 0) {
                            Object[] conteúdo = {jTextFieldCód.getText(), jTextFieldDesc.getText(), jTextFieldSetor.getText(), "Preparando",
                                emb, proc, valid, data};
                            Tabela.addRow(conteúdo);
                        }
                    }
                    jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                    jTextFieldCód.setText("");
                } else if (model.getStatus().intern().trim().equalsIgnoreCase("Danificado")) {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                            + "Consta no sistema a informação de que<br> "
                            + "o instrumental encontra-se com defeito!<br>"
                            + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                } else if (model.getStatus().intern().trim().equalsIgnoreCase("Extraviado")) {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                            + "Consta no sistema a informação de que <br>"
                            + "o instrumental encontra-se extraviado!<br>"
                            + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                }else if (model.getStatus().intern().trim().equalsIgnoreCase("Preparando")) {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                            + "Consta no sistema a informação de que <br>"
                            + "o instrumental já foi preparado!<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                            + "O instrumental não passou pela lavagem!<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>O código não pertence"
                        + " a um instrumental!<br>", "", JOptionPane.DEFAULT_OPTION);
                jTextFieldCód.setText("");
                jTextFieldCód.requestFocus();
            }
        } else if (instrum.getOk() == 0){
            jTextFieldCód.setText("");
            jTextFieldCód.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        int v = 0;
        for (int i = 0; i < Tabela.getRowCount(); i++ ){
            if (!Tabela.getValueAt(i, 3).equals("Preparando")) {
                if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
                    moviment.setOp(jTextFieldOp.getText().trim());
                } else {
                    moviment.setSuperv(troca.getOperador());
                    moviment.setOp(jTextFieldOp.getText().trim());
                }
            } else {
                moviment.setOp(jTextFieldOp.getText());
                moviment.setSuperv("");
            }
            moviment.setCodigo((String) Tabela.getValueAt(i, 0));
            moviment.setDesc((String) Tabela.getValueAt(i, 1));
            moviment.setSetor((String) Tabela.getValueAt(i, 2));
            moviment.setStatus((String) Tabela.getValueAt(i, 3));
            moviment.setEmba((String) Tabela.getValueAt(i, 4));
            if (moviment.getEmba().intern().trim().equals("Grau Cirúrgico")) {
                v = 180;
            }
            if (moviment.getEmba().intern().trim().equals("SMS")) {
                v = 90;
            }
            if (moviment.getEmba().intern().trim().equals("Tecido")) {
                v = 14;
            }
            moviment.setProcess((String) Tabela.getValueAt(i, 5));
            moviment.setValid((String) Tabela.getValueAt(i, 6));
            moviment.setData((String) Tabela.getValueAt(i, 7));
            moviment.setPrazo(v);
            moviment.setQtd(1);
            moviment.setLote(l);
            mov.Salvar(moviment);
            moviment.setQuery("UPDATE movimentação SET concluido = 'Ok' "
                + "WHERE codigo = '"+moviment.getCodigo().intern().trim()+"' AND status = 'Lavando'");
            mov.Atualizar(moviment);
        }
        imp = new ImpressEtiq (this, true);
        imp.setVisible(true);
        new Thread(){
            public void run(){
                try {
                    sleep(60);
                    close();
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (Tabela.getRowCount() != 0) {
            int sair = JOptionPane.showConfirmDialog(null,"<html><center>Cancelar o preparo?<br>", "", JOptionPane.YES_NO_OPTION);
            if (sair == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else{
            dispose();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        troca.setNivel(0);
        if (jTable.isRowSelected(jTable.getSelectedRow())) {
            int rows = jTable.getSelectedRow();
            if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
                troca.setNivel(1);
            }
            if (jTable.getValueAt(rows, 3).equals("Danificado") && troca.getNivel() == 1) {
                Tabela.removeRow(jTable.getSelectedRow());
            } else if (Tabela.getValueAt(rows, 3).equals("Danificado") && troca.getNivel() == 0) {
                sessão = new TrocarUsuario(this, true);
                sessão.setVisible(true);
                if (troca.getNivel() == 1) {
                    Tabela.removeRow(jTable.getSelectedRow());
                }
            } else if (Tabela.getValueAt(rows, 3).equals("Preparando")) {
                Tabela.removeRow(jTable.getSelectedRow());
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        if (Tabela.getRowCount() == 0){
            jButtonExcluir.setEnabled(!true);
            jButtonConcluir.setEnabled(!true);
            jTextFieldCód.grabFocus();
            jLabelImagem.setIcon(null);
            jTextFieldDesc.setText("");
            jTextFieldSetor.setText("");
        }
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefeitoActionPerformed
        troca.setNivel(0);
        if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
            troca.setNivel(1);
        } else {
            sessão = new TrocarUsuario(this, true);
            sessão.setVisible(true);
        }
        if (troca.getNivel() == 1) {
            String cod = JOptionPane.showInputDialog("<html><center>Entre com o código do instrumental<br>");
            instru.setBusca(cod);
            InstruMod instrum = inst.Buscar(instru);
            moviment.setPos(0);
            moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+cod+"' AND concluido IS NULL");
            MovimentMod model = mov.Buscar2(moviment);
            if (instrum.getOk() == 1) {
                if (instrum.getItem().intern().trim().equalsIgnoreCase("Instrumental")) {
                    if (model.getStatus().intern().trim().equalsIgnoreCase("Lavando")) {
                        if (jTextFieldLote.getText().isEmpty()) {
                            lote.setData(sdf2.format(dt_atual));
                            mov.Lote(lote);
                            lote.setNum(lote.getNum() + 1);
                            mov.NovoLote(lote);
                            l = lote.getNum();
                        }
                        jTextFieldLote.setText(String.valueOf(l));
                        jTextFieldDesc.setText(instrum.getDescrição().intern().trim());
                        jTextFieldSetor.setText(instrum.getSetor().trim());
                        InputStream input = new ByteArrayInputStream(instrum.getImagem());
                        try {
                            BufferedImage imagem = ImageIO.read(input);
                            double imgAltura = 270;
                            double imgLargura = 360;
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
                            novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(),
                                BufferedImage.TYPE_INT_RGB);
                            Graphics2D g2d = novaImagem.createGraphics();
                            g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);
                            jLabelImagem.setIcon(new ImageIcon(novaImagem));
                        } catch (IOException ex) {

                        }
                        jButtonConcluir.setEnabled(true);
                        jButtonExcluir.setEnabled(true);
                        if (Tabela.getRowCount() == 0) {
                            Object[] conteúdo = {instrum.getCód().intern().trim(), jTextFieldDesc.getText(),
                                jTextFieldSetor.getText(), "Danificado", "", "", "", sdf.format(dt_atual)};
                            Tabela.addRow(conteúdo);
                        } else if (Tabela.getRowCount() != 0){
                            for (int i = 0; i < Tabela.getRowCount(); i++) {
                                if (instrum.getCód().intern().trim().equals(((String) Tabela.getValueAt(i, 0)).intern().trim())
                                        && Tabela.getValueAt(i, 3).equals("Preparando")){
                                    int c = JOptionPane.showConfirmDialog(rootPane,
                                        "<html><center>Atençao!<br>Este ítem foi recebido sem defeito!"
                                        + "<br>Gostaria de recebe-lo como defeituoso?<br>", "", JOptionPane.YES_NO_OPTION);
                                    if (c == JOptionPane.YES_OPTION) {
                                        Tabela.setValueAt("Danificado", i, 3);
                                        Tabela.setValueAt("", i, 4);
                                        Tabela.setValueAt("", i, 5);
                                        Tabela.setValueAt("", i, 6);
                                    }
                                } else if (instrum.getCód().intern().trim().equals(((String) Tabela.getValueAt(i, 0)).intern().trim())
                                        && Tabela.getValueAt(i, 3).equals("Danificado")) {
                                    JOptionPane.showMessageDialog(rootPane, "<html><center>O ítem já foi "
                                            + "recebido!<br>", "", JOptionPane.DEFAULT_OPTION);
                                } 
                            }
                        }
                        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                        jTextFieldCód.setText("");
                    } else if (model.getStatus().intern().trim().equalsIgnoreCase("Danificado")) {
                        JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                + "Consta no sistema a informação de que<br> "
                                + "o instrumental encontra-se com defeito!<br>"
                                + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                        jTextFieldCód.setText("");
                        jTextFieldCód.requestFocus();
                    } else if (model.getStatus().intern().trim().equalsIgnoreCase("Extraviado")) {
                        JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                + "Consta no sistema a informação de que <br>"
                                + "o instrumental encontra-se extraviado!<br>"
                                + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                        jTextFieldCód.setText("");
                        jTextFieldCód.requestFocus();
                    }else if (model.getStatus().intern().trim().equalsIgnoreCase("Preparando")) {
                        JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                + "Consta no sistema a informação de que <br>"
                                + "o instrumental já foi preparado!<br>", "", JOptionPane.DEFAULT_OPTION);
                        jTextFieldCód.setText("");
                        jTextFieldCód.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                + "O instrumental não passou pela lavagem!<br>", "", JOptionPane.DEFAULT_OPTION);
                        jTextFieldCód.setText("");
                        jTextFieldCód.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>O código não pertence"
                            + " a um instrumental!<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                }
            } else if (instrum.getOk() == 0){
                jTextFieldCód.setText("");
                jTextFieldCód.requestFocus();
            }
        }
        jTextFieldCód.setText("");
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jButtonDefeitoActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrepararAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrepararAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrepararAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrepararAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrepararAvulso dialog = new PrepararAvulso(pavulso, true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonDefeito;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldCód;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldSetor;
    // End of variables declaration//GEN-END:variables
}
