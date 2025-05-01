package com.knowledge.horus.views;

import com.knowledge.horus.controls.ArsenalDAO;
import com.knowledge.horus.controls.ManipularImagem;
import com.knowledge.horus.controls.MovimentaDAO;
import com.knowledge.horus.controls.Sessão;
import com.knowledge.horus.models.Arsenal;
import com.knowledge.horus.models.Movimentacao;
import com.knowledge.horus.models.TrocarUsu;
import java.text.SimpleDateFormat;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LavarAvulso extends javax.swing.JDialog {
    
    TrocarUsu troca = new TrocarUsu();
    BufferedImage novaImagem;
    int e = 0;
    public static LeitorCódL lavulso;
    public static TrocarUsuario sessão;
    DefaultTableModel Tabela;
    java.util.Date dt_atual = new java.util.Date();        
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    List<Arsenal> lista = null;
    Arsenal instru = new Arsenal();
    List<Movimentacao> lista2 = null;
    Movimentacao mov = new Movimentacao();
    int tot = 0;
    int totmov = 0;
    int row = 0;
    
    public LavarAvulso(LeitorCódL parent, boolean modal) {
        super (parent, modal);
        initComponents();
        Tabela = (DefaultTableModel) jTable.getModel();
        jTextFieldOp.setText(Sessão.getLogado());
    }
    
    public void buscarArsenal (Long inst){
        lista = new ArsenalDAO().findByCod(inst);
        tot = lista.size();
        if (tot != 0) {
            instru = lista.get(0);
        }
    }
    
    public void buscarMov (Long moviment){
        lista2 = new MovimentaDAO().findByCod(moviment);
        totmov = lista2.size();
        if (totmov != 0) {
            mov = lista2.get(totmov -1);
        }
    }
    
    public void setarTable (){
        jTextFieldDesc.setText(instru.getDescricao().trim());
        jTextFieldSetor.setText(instru.getSetor().trim());
        ManipularImagem.exibiImagemLabel(instru.getImagem(), jLabelImagem);
        jButtonConcluir.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        e = 0;
        if (Tabela.getRowCount() == 0) {
            Object[] conteúdo = {jTextFieldCód.getText(), jTextFieldDesc.getText(), jTextFieldSetor.getText(),
                "Lavando", sdf.format(dt_atual)};
            Tabela.addRow(conteúdo);
        } else if (Tabela.getRowCount() != 0){
            for (int i = 0; i < Tabela.getRowCount(); i++) {
                if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela.getValueAt(i, 0)).intern().trim())
                        && (Tabela.getValueAt(i, 3).equals("Lavando"))){
                    e = 1;
                    int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atençao!<br>Este instrumental já foi "
                            + "incluído para lavagem!<br>Gostaria de exclui-lo?<br>", "", JOptionPane.YES_NO_OPTION);
                    if (c == 0) {
                        Tabela.removeRow(i);
                        jTextFieldDesc.setText("");
                        jTextFieldSetor.setText("");
                        jLabelImagem.setIcon(null);
                        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                        if (Tabela.getRowCount() == 0) {
                            jButtonExcluir.setEnabled(!true);
                            jButtonConcluir.setEnabled(!true);
                        }
                    }
                }
                if (Tabela.getRowCount() != 0) {
                    if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela.getValueAt(i, 0)).intern().trim()) 
                            && (Tabela.getValueAt(i, 3).equals("Danificado"))){
                        e = 1;
                        JOptionPane.showMessageDialog(null, "<html><center>O ítem já foi recebido!", "", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
            if (e == 0) {
                Object[] conteúdo = {jTextFieldCód.getText(), jTextFieldDesc.getText(), jTextFieldSetor.getText(),
                    "Lavando", sdf.format(dt_atual)};
                Tabela.addRow(conteúdo);
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        jTextFieldCód.setText("");
    }
    
    public void selectedRow (int r){
        if (Tabela.getRowCount() != 0) {
            buscarArsenal(Long.parseLong((String) Tabela.getValueAt(r, 0)));
            jTextFieldDesc.setText(instru.getDescricao());
            jTextFieldSetor.setText(instru.getSetor());
            ManipularImagem.exibiImagemLabel(instru.getImagem(), jLabelImagem);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDefeito = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
        jTextFieldCód = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSetor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldOp = new javax.swing.JTextField();
        jLabelImagem = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldItens = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recebimento de Material Sujo");
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
        jButtonDefeito.setBounds(10, 420, 360, 23);

        jButtonCancelar.setText("Cancelar o recebimento");
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar);
        jButtonCancelar.setBounds(10, 480, 360, 23);

        jButtonConcluir.setText("Concluir o recebimento");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir);
        jButtonConcluir.setBounds(10, 510, 360, 23);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Setor", "Status", "Data e hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(110);
        }

        getContentPane().add(jScrollPane);
        jScrollPane.setBounds(380, 30, 660, 530);

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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 360, 100);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ítens recebidos");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(380, 10, 660, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Lavar instrumental");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 10, 360, 20);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Operador");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 540, 50, 20);

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp);
        jTextFieldOp.setBounds(70, 540, 110, 20);

        jLabelImagem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem.setOpaque(true);
        getContentPane().add(jLabelImagem);
        jLabelImagem.setBounds(10, 140, 360, 270);

        jButtonExcluir.setText("Excluir ítem da lista");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir);
        jButtonExcluir.setBounds(10, 450, 360, 23);

        jTextFieldItens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens);
        jTextFieldItens.setBounds(320, 540, 50, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Ítens");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 540, 40, 20);

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setMaximumSize(new java.awt.Dimension(920, 590));
        jLabelFundo.setMinimumSize(new java.awt.Dimension(920, 590));
        jLabelFundo.setOpaque(true);
        jLabelFundo.setPreferredSize(new java.awt.Dimension(920, 590));
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 1050, 570);

        setBounds(130, 30, 1050, 570);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        if (!jTextFieldCód.getText().equalsIgnoreCase("")) {
            buscarArsenal(Long.parseLong(jTextFieldCód.getText().trim()));
            if (tot != 0) {
                if (instru.getTipo().equalsIgnoreCase("Instrumental")) {
                    buscarMov(Long.parseLong(jTextFieldCód.getText().trim()));
                    if (totmov != 0) {
                        if ((mov.getStatus().trim().equalsIgnoreCase("Danificado") && mov.getAção() != null) 
                            || (mov.getStatus().trim().equalsIgnoreCase("Extraviado") && mov.getAção() != null)
                            || (mov.getStatus().trim().equalsIgnoreCase("")) || (mov.getStatus().trim().equalsIgnoreCase("Sujo"))){
                            setarTable();
                        } else if (mov.getStatus().intern().trim().equalsIgnoreCase("Danificado")) {
                            JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                    + "Consta no sistema a informação de que<br> "
                                    + "o instrumental encontra-se com defeito!<br>"
                                    + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        } else if (mov.getStatus().intern().trim().equalsIgnoreCase("Extraviado")) {
                            JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                    + "Consta no sistema a informação de que <br>"
                                    + "o instrumental encontra-se extraviado!<br>"
                                    + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        } else if (mov.getStatus().intern().trim().equalsIgnoreCase("Lavando")) {
                            JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                    + "Consta no sistema a informação de que <br>"
                                    + "o instrumental já foi lavado!<br>", "", JOptionPane.DEFAULT_OPTION);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        } else if (mov.getStatus().intern().trim().equalsIgnoreCase("Preparando")) {
                            JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                    + "Consta no sistema a informação de que <br>"
                                    + "o instrumental já foi lavado e preparado!<br>", "", JOptionPane.DEFAULT_OPTION);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        }
                    } else {
                        setarTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>O código não pertence"
                            + " a um instrumental!", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><center>O ítem não foi encontrado!", "", JOptionPane.DEFAULT_OPTION);
                jTextFieldCód.setText("");
                jTextFieldCód.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html><center>O campo 'Codigo do instrumental' não pode estar vazio!", "", JOptionPane.DEFAULT_OPTION);
            jTextFieldCód.setText("");
            jTextFieldCód.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        System.out.println(mov.toString());
        for (int i = 0; i < Tabela.getRowCount(); i++ ){
            if (!Tabela.getValueAt(i, 3).equals("Lavando")) {
                if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
                    mov.setOperador(jTextFieldOp.getText().trim());
                } else {
                    mov.setSupervisor(troca.getOperador());
                    mov.setOperador(jTextFieldOp.getText().trim());
                }
            } else {
                mov.setOperador(jTextFieldOp.getText());
                mov.setSupervisor("");
            }
            mov.setCodigo(Long.parseLong((String) Tabela.getValueAt(i, 0)));
            mov.setDescricao((String) Tabela.getValueAt(i, 1));
            mov.setSetor((String) Tabela.getValueAt(i, 2));
            mov.setStatus((String) Tabela.getValueAt(i, 3));
            mov.setData((String) Tabela.getValueAt(i, 4));
            mov.setQtd(1);
            System.out.println(mov.toString());
            new MovimentaDAO().save(mov);
        }
        dispose();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (Tabela.getRowCount() != 0) {
            int sair = JOptionPane.showConfirmDialog(rootPane, "<html><center>Cancelar o recebimento?<br>", "", JOptionPane.YES_NO_OPTION);
            if (sair == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
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
            if (Tabela.getValueAt(rows, 3).equals("Danificado") && troca.getNivel() == 1) {
                Tabela.removeRow(jTable.getSelectedRow());
            } else if (Tabela.getValueAt(rows, 3).equals("Danificado") && troca.getNivel() == 0) {
                sessão = new TrocarUsuario(this, true);
                sessão.setVisible(true);
                if (troca.getNivel() == 1) {
                    Tabela.removeRow(jTable.getSelectedRow());
                }
            } else if (Tabela.getValueAt(rows, 3).equals("Lavando")) {
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
        troca.setNivel(0);
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefeitoActionPerformed
        int t1 = 0;
        troca.setNivel(0);
        if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
            troca.setNivel(1);
        } else {
            sessão = new TrocarUsuario(this, true);
            sessão.setVisible(true);
        }
        if (troca.getNivel() == 1) {
            String cod = JOptionPane.showInputDialog("<html><center>Entre com o código do instrumental<br>");
            buscarArsenal(Long.parseLong(cod));
            if (tot != 0) {
                if (instru.getTipo().intern().trim().equalsIgnoreCase("Instrumental")) {
                    buscarMov(Long.parseLong(cod));
                    if (totmov != 0) {
                        if ((mov.getStatus().intern().trim().equalsIgnoreCase("Danificado") && mov.getAção() != null) 
                            || (mov.getStatus().intern().trim().equalsIgnoreCase("Extraviado") && mov.getAção() != null)
                            || (mov.getStatus().intern().trim().equalsIgnoreCase(""))
                            || (mov.getStatus().intern().trim().equalsIgnoreCase("Sujo"))){
                            setarTable();
                            jTextFieldDesc.setText(instru.getDescricao().intern().trim());
                            jTextFieldSetor.setText(instru.getSetor().trim());
                            ManipularImagem.exibiImagemLabel(instru.getImagem(), jLabelImagem);
                            if (Tabela.getRowCount() != 0) {
                                for (int i = 0; i < Tabela.getRowCount(); i++) {
                                    if (instru.getCod().equals((Long) Tabela.getValueAt(i, 0))
                                            && Tabela.getValueAt(i, 3).equals("Lavando")){
                                        int c = JOptionPane.showConfirmDialog(rootPane,
                                            "<html><center>Atençao!<br>Este ítem foi recebido sem defeito!"
                                            + "<br>Gostaria de recebe-lo como defeituoso?<br>", "", JOptionPane.YES_NO_OPTION);
                                        if (c == JOptionPane.YES_OPTION) {
                                            Tabela.setValueAt("Danificado", i, 3);
                                        }
                                    } else if (instru.getCod().equals((Long) Tabela.getValueAt(i, 0))
                                            && Tabela.getValueAt(i, 3).equals("Danificado")) {
                                        int c = JOptionPane.showConfirmDialog(rootPane,
                                            "<html><center>Atençao!<br>Este ítem já foi recebido como defeituoso!"
                                            + "<br>Gostaria de recebe-lo sem defeito?<br>", "", JOptionPane.YES_NO_OPTION);
                                        if (c == JOptionPane.YES_OPTION) {
                                            Tabela.setValueAt("Lavando", i, 3);
                                        }
                                    } else {
                                        t1++;
                                    }
                                }
                            }
                            if (Tabela.getRowCount() == t1 || Tabela.getRowCount() == 0) {
                                Object[] conteúdo = {instru.getCod(), instru.getDescricao().intern().trim(),
                                instru.getSetor().intern().trim(), "Danificado", sdf.format(dt_atual)};
                                Tabela.addRow(conteúdo);
                            }
                            jButtonConcluir.setEnabled(true);
                            jButtonExcluir.setEnabled(true);
                            jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
                        } else if (mov.getStatus().intern().trim().equalsIgnoreCase("Danificado")) {
                            JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                    + "Consta no sistema a informação de que<br> "
                                    + "o instrumental já encontra-se com defeito!<br>"
                                    + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        } else if (mov.getStatus().intern().trim().equalsIgnoreCase("Extraviado")) {
                            JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                    + "Consta no sistema a informação de que <br>"
                                    + "o instrumental encontra-se extraviado!<br>"
                                    + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        } else if (mov.getStatus().intern().trim().equalsIgnoreCase("Lavando")) {
                            int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atenção!<br>"
                                    + "O instrumental já foi recebido sem defeito!<br>"
                                    + "Gostaria de informar ao sistema<br>"
                                    + "que o mesmo encontra-se defeituoso?", "", JOptionPane.YES_NO_OPTION);
                                if (c == JOptionPane.YES_OPTION) {
                                    Object[] conteúdo = {instru.getCod(), instru.getDescricao().intern().trim(),
                                        instru.getSetor(), "Danificado", sdf.format(dt_atual)};
                                    Tabela.addRow(conteúdo);
                                }
                            jButtonConcluir.setEnabled(true);
                            jButtonExcluir.setEnabled(true);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        }else if (mov.getStatus().intern().trim().equalsIgnoreCase("Preparando")) {
                            JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                                    + "Consta no sistema a informação de que <br>"
                                    + "o instrumental já foi lavado e preparado!<br>", "", JOptionPane.DEFAULT_OPTION);
                            jTextFieldCód.setText("");
                            jTextFieldCód.requestFocus();
                        }
                    } else {
                        Object[] conteúdo = {instru.getCod(), instru.getDescricao().intern().trim(),
                            instru.getSetor().intern().trim(), "Danificado", sdf.format(dt_atual)};
                            Tabela.addRow(conteúdo);
                    }
                } else {
                        JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>O código não pertence"
                                + " a um instrumental!", "", JOptionPane.DEFAULT_OPTION);
                        jTextFieldCód.setText("");
                        jTextFieldCód.requestFocus();
                }
            } else if (tot == 0) {
                JOptionPane.showMessageDialog(null, "<html><center>O ítem não foi encontrado!", "", JOptionPane.DEFAULT_OPTION);
                jTextFieldCód.setEnabled(true);
                jTextFieldCód.setText("");
                jTextFieldDesc.setText("");
                jLabelImagem.setIcon(null);
            }
            jTextFieldCód.requestFocus();
            jTextFieldItens.setText(String.valueOf(Tabela.getRowCount()));
        }
        troca.setNivel(0);
    }//GEN-LAST:event_jButtonDefeitoActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        selectedRow(jTable.getSelectedRow());
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyPressed
        int r = Tabela.getRowCount();
        if (evt.getKeyCode() == 38) {
            if (jTable.getSelectedRow() > 0) {
                selectedRow(jTable.getSelectedRow()-1);
            }
        }
        if (evt.getKeyCode() == 40) {
            if (jTable.getSelectedRow() < (r - 1)) {
                selectedRow(jTable.getSelectedRow()+1);
            }
        }
    }//GEN-LAST:event_jTableKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LavarAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LavarAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LavarAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LavarAvulso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LavarAvulso dialog = new LavarAvulso(lavulso, true);
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
    private javax.swing.JButton jButtonDefeito;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldCód;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldSetor;
    // End of variables declaration//GEN-END:variables
}
