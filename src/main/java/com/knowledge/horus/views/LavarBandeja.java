package com.knowledge.horus.views;

import Controle.Cme.BandejaSQL;
import Controle.Cme.InstruSQL;
import Controle.Cme.MovimentSQL;
import Controle.Sessão;
import Modelos.Cme.BandejaMod;
import java.text.SimpleDateFormat;
import Modelos.Cme.InstruMod;
import Modelos.Cme.MovimentMod;
import Modelos.Cme.TroUsuMod;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class LavarBandeja extends javax.swing.JDialog {

    InstruMod instru = new InstruMod();
    InstruSQL inst = new InstruSQL();
    BandejaMod bandeja = new BandejaMod();
    BandejaSQL band = new BandejaSQL();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    TroUsuMod troca = new TroUsuMod();
    BufferedImage novaImagem;
    public static LeitorCódL lbandeja;
    public static TrocarUsuario sessão;
    DefaultTableModel Tabela1;
    DefaultTableModel Tabela2;
    java.util.Date dt_atual = new java.util.Date();        
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public LavarBandeja(LeitorCódL parent, boolean modal) {
        super (parent, modal);
        initComponents();
        Tabela1 = (DefaultTableModel) jTable1.getModel();
        Tabela2 = (DefaultTableModel) jTable2.getModel();
        jTextFieldOp.setText(Sessão.getLogado());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDefeito = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable1 = new JTable();
        int lin = 3;
        int col = 3;
        //JTable table = new JTable(lin, col) {
            JTable table = new JTable(lin, col) {
                @Override
                public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {

                    DefaultTableModel m = (DefaultTableModel) getModel();
                    Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);

                    // altera a cor de background da linha para vermelho e foreground para branco
                    // quando o valor da coluna 3 for igual a fechado
                    if (m.getValueAt(rowIndex, 0).toString().toLowerCase().equals(jTextFieldCódInst.getText())) {
                        c.setBackground(new Color(192, 0, 0));
                        c.setForeground(Color.white);
                    } else {
                        // mantem a cor padrão de foreground
                        c.setForeground(getForeground());

                        // determina a cor de background da linha selecionada
                        if (isCellSelected(rowIndex, vColIndex)) {
                            c.setBackground(new Color(184, 207, 229));
                        } else {
                            // linhas não selecionadas, manter cor de background padrão
                            c.setBackground(getBackground());
                        }

                    }
                    return c;
                }
            };
            jLabel5 = new javax.swing.JLabel();
            jPanel2 = new javax.swing.JPanel();
            jTextFieldCódBd = new javax.swing.JTextField();
            jLabel1 = new javax.swing.JLabel();
            jTextFieldDescBd = new javax.swing.JTextField();
            jTextFieldEspeciali = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jTextFieldSetor = new javax.swing.JTextField();
            jLabel12 = new javax.swing.JLabel();
            jTextFieldNomeBd = new javax.swing.JTextField();
            jPanel1 = new javax.swing.JPanel();
            jLabel6 = new javax.swing.JLabel();
            jTextFieldCódInst = new javax.swing.JTextField();
            jTextFieldDesc = new javax.swing.JTextField();
            jLabel7 = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jTextFieldItens = new javax.swing.JTextField();
            jLabel13 = new javax.swing.JLabel();
            jTextFieldOp = new javax.swing.JTextField();
            jButtonConcluir = new javax.swing.JButton();
            jButtonExtravio = new javax.swing.JButton();
            jLabelImagem = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTable2 = new javax.swing.JTable();
            jLabel8 = new javax.swing.JLabel();
            jLabelFundo = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Recebimento de Material Sujo");
            setUndecorated(true);
            setResizable(false);
            getContentPane().setLayout(null);

            jButtonDefeito.setText("Instrumental com defeito");
            jButtonDefeito.setEnabled(false);
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
            jButtonDefeito.setBounds(10, 540, 320, 23);

            jButtonCancelar.setText("Cancelar o recebimento");
            jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonCancelarActionPerformed(evt);
                }
            });
            getContentPane().add(jButtonCancelar);
            jButtonCancelar.setBounds(10, 600, 320, 23);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Código", "Descrição", "Status", "Data e hora"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jTable1.setEnabled(false);
            jTable1.getTableHeader().setReorderingAllowed(false);
            jScrollPane.setViewportView(jTable1);
            if (jTable1.getColumnModel().getColumnCount() > 0) {
                jTable1.getColumnModel().getColumn(0).setMinWidth(90);
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
                jTable1.getColumnModel().getColumn(0).setMaxWidth(90);
                jTable1.getColumnModel().getColumn(2).setMinWidth(80);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(2).setMaxWidth(80);
                jTable1.getColumnModel().getColumn(3).setMinWidth(110);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
                jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
            }

            getContentPane().add(jScrollPane);
            jScrollPane.setBounds(340, 30, 480, 650);

            jLabel5.setBackground(new java.awt.Color(255, 255, 255));
            jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(255, 255, 255));
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setText("Conteúdo da bandeja");
            getContentPane().add(jLabel5);
            jLabel5.setBounds(830, 10, 350, 20);

            jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jPanel2.setLayout(null);

            jTextFieldCódBd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldCódBdActionPerformed(evt);
                }
            });
            jPanel2.add(jTextFieldCódBd);
            jTextFieldCódBd.setBounds(80, 10, 230, 20);

            jLabel1.setText("Código");
            jPanel2.add(jLabel1);
            jLabel1.setBounds(10, 10, 70, 20);

            jTextFieldDescBd.setEnabled(false);
            jTextFieldDescBd.setFocusable(false);
            jPanel2.add(jTextFieldDescBd);
            jTextFieldDescBd.setBounds(80, 40, 230, 20);

            jTextFieldEspeciali.setEnabled(false);
            jPanel2.add(jTextFieldEspeciali);
            jTextFieldEspeciali.setBounds(80, 100, 230, 20);

            jLabel3.setText("Especialidade");
            jPanel2.add(jLabel3);
            jLabel3.setBounds(10, 100, 70, 20);

            jLabel4.setText("Descrição");
            jPanel2.add(jLabel4);
            jLabel4.setBounds(10, 40, 70, 20);

            jLabel11.setText("Setor");
            jPanel2.add(jLabel11);
            jLabel11.setBounds(10, 130, 60, 20);

            jTextFieldSetor.setEnabled(false);
            jPanel2.add(jTextFieldSetor);
            jTextFieldSetor.setBounds(80, 130, 230, 20);

            jLabel12.setText("Nome");
            jPanel2.add(jLabel12);
            jLabel12.setBounds(10, 70, 70, 20);

            jTextFieldNomeBd.setEnabled(false);
            jTextFieldNomeBd.setFocusable(false);
            jPanel2.add(jTextFieldNomeBd);
            jTextFieldNomeBd.setBounds(80, 70, 230, 20);

            getContentPane().add(jPanel2);
            jPanel2.setBounds(10, 30, 320, 160);

            jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jPanel1.setLayout(null);

            jLabel6.setText("Código do instrumental");
            jPanel1.add(jLabel6);
            jLabel6.setBounds(10, 10, 120, 20);

            jTextFieldCódInst.setEnabled(false);
            jTextFieldCódInst.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextFieldCódInstActionPerformed(evt);
                }
            });
            jPanel1.add(jTextFieldCódInst);
            jTextFieldCódInst.setBounds(140, 10, 170, 20);

            jTextFieldDesc.setEnabled(false);
            jTextFieldDesc.setFocusable(false);
            jPanel1.add(jTextFieldDesc);
            jTextFieldDesc.setBounds(70, 40, 240, 20);

            jLabel7.setText("Descrição");
            jPanel1.add(jLabel7);
            jLabel7.setBounds(10, 40, 60, 20);

            getContentPane().add(jPanel1);
            jPanel1.setBounds(10, 210, 320, 70);

            jLabel9.setBackground(new java.awt.Color(255, 255, 255));
            jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(255, 255, 255));
            jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel9.setText("Instrumental");
            getContentPane().add(jLabel9);
            jLabel9.setBounds(10, 190, 320, 20);

            jLabel10.setBackground(new java.awt.Color(255, 255, 255));
            jLabel10.setForeground(new java.awt.Color(255, 255, 255));
            jLabel10.setText("Ítens restantes");
            getContentPane().add(jLabel10);
            jLabel10.setBounds(200, 660, 80, 20);

            jTextFieldItens.setEditable(false);
            jTextFieldItens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jTextFieldItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextFieldItens.setEnabled(false);
            getContentPane().add(jTextFieldItens);
            jTextFieldItens.setBounds(280, 660, 50, 20);

            jLabel13.setBackground(new java.awt.Color(255, 255, 255));
            jLabel13.setForeground(new java.awt.Color(255, 255, 255));
            jLabel13.setText("Operador");
            getContentPane().add(jLabel13);
            jLabel13.setBounds(10, 660, 50, 20);

            jTextFieldOp.setEnabled(false);
            getContentPane().add(jTextFieldOp);
            jTextFieldOp.setBounds(60, 660, 110, 20);

            jButtonConcluir.setText("Concluir o recebimento");
            jButtonConcluir.setEnabled(false);
            jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonConcluirActionPerformed(evt);
                }
            });
            getContentPane().add(jButtonConcluir);
            jButtonConcluir.setBounds(10, 630, 320, 23);

            jButtonExtravio.setText("Instrumental extraviado");
            jButtonExtravio.setEnabled(false);
            jButtonExtravio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButtonExtravio.setMaximumSize(new java.awt.Dimension(80, 25));
            jButtonExtravio.setMinimumSize(new java.awt.Dimension(80, 25));
            jButtonExtravio.setPreferredSize(new java.awt.Dimension(80, 25));
            jButtonExtravio.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonExtravioActionPerformed(evt);
                }
            });
            getContentPane().add(jButtonExtravio);
            jButtonExtravio.setBounds(10, 570, 320, 23);

            jLabelImagem.setBackground(new java.awt.Color(255, 255, 255));
            jLabelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabelImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jLabelImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabelImagem.setOpaque(true);
            getContentPane().add(jLabelImagem);
            jLabelImagem.setBounds(10, 290, 320, 240);

            jLabel2.setBackground(new java.awt.Color(255, 255, 255));
            jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Lavar bandeja");
            getContentPane().add(jLabel2);
            jLabel2.setBounds(10, 10, 320, 20);

            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Código", "Descrição"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jTable2.setEnabled(false);
            jScrollPane1.setViewportView(jTable2);
            if (jTable2.getColumnModel().getColumnCount() > 0) {
                jTable2.getColumnModel().getColumn(0).setMinWidth(90);
                jTable2.getColumnModel().getColumn(0).setPreferredWidth(90);
                jTable2.getColumnModel().getColumn(0).setMaxWidth(90);
            }

            getContentPane().add(jScrollPane1);
            jScrollPane1.setBounds(830, 30, 350, 650);

            jLabel8.setBackground(new java.awt.Color(255, 255, 255));
            jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel8.setForeground(new java.awt.Color(255, 255, 255));
            jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel8.setText("Ítens recebidos");
            getContentPane().add(jLabel8);
            jLabel8.setBounds(340, 10, 480, 20);

            jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
            jLabelFundo.setOpaque(true);
            getContentPane().add(jLabelFundo);
            jLabelFundo.setBounds(0, 0, 1190, 690);

            setBounds(130, 30, 1190, 690);
        }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCódBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódBdActionPerformed
        instru.setBusca(jTextFieldCódBd.getText());
        InstruMod instrum = inst.Buscar(instru);
        bandeja.setCódBd(jTextFieldCódBd.getText());
        band.TestaBandeja(bandeja);
        moviment.setPos(0);
        moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+jTextFieldCódBd.getText().intern().trim()+"'");
        MovimentMod model = mov.Buscar2(moviment);
        if ((instru.getOk() == 1) && (bandeja.getStatus() == 1)) {
            jTextFieldCódBd.setEnabled(!true);
            jTextFieldDescBd.setText(instrum.getDescrição().trim());
            jTextFieldNomeBd.setText(instrum.getFantasia());
            jTextFieldEspeciali.setText(instrum.getEspecialidade().trim());
            jTextFieldSetor.setText(instrum.getSetor().trim());
            jTextFieldCódInst.setEnabled(true);
            jTextFieldCódInst.grabFocus();
            if (!model.getStatus().intern().trim().equalsIgnoreCase("Lavando")) {
                if (bandeja.getStatus() == 1) {
                    jTextFieldCódInst.setEnabled(!true);
                    jTable1.setEnabled(!true);
                    bandeja.setCódBd(jTextFieldCódBd.getText());
                    BandejaMod modelbd = band.Buscar(bandeja);
                    modelbd.setPos(1);
                    for (int i = 0; i < modelbd.getLin(); i++) {
                        modelbd = band.Buscar(bandeja);
                        Object[] conteúdo = {modelbd.getCódInst(), modelbd.getDesInst()};
                        Tabela2.addRow(conteúdo);
                        bandeja.setPos(i + 2);
                    }
                    jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
                    jTextFieldCódBd.setEnabled(!true);
                    jTextFieldCódInst.setEnabled(true);
                    jTextFieldCódInst.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><center>A bandeja já foi recebida"
                        + " para lavegem.<br>", "", JOptionPane.DEFAULT_OPTION);
                dispose();
            }
        } else if (instrum.getOk() == 0) {
            jTextFieldCódBd.setEnabled(true);
            jTextFieldCódBd.setText("");
            instrum.setOk(0);
        } else if (instrum.getOk() == 1) {
            JOptionPane.showMessageDialog(null, "<html><center>Comece identificando o"
                    + " código da bandeja.<br>", "", JOptionPane.DEFAULT_OPTION);
            jTextFieldCódBd.setEnabled(true);
            jTextFieldCódBd.setText("");
            instrum.setOk(0);
        }
        jButtonDefeito.setEnabled(true);
        jButtonExtravio.setEnabled(true);
    }//GEN-LAST:event_jTextFieldCódBdActionPerformed

    private void jTextFieldCódInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódInstActionPerformed
        instru.setBusca(jTextFieldCódInst.getText());
        InstruMod instrum = inst.Buscar(instru);
        moviment.setPos(0);
        moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+jTextFieldCódInst.getText().intern().trim()+"'");
        MovimentMod model = mov.Buscar2(moviment);
        int rows1 = Tabela1.getRowCount();
        int rows2 = Tabela2.getRowCount();
        int t1 = 0;
        int t2 = 0;
        if ((instrum.getOk() == 1) && (rows2 != 0)){
            if (instrum.getItem().intern().trim().equalsIgnoreCase("Instrumental")) {
                if ((model.getStatus().intern().trim().equalsIgnoreCase("Danificado") && model.getAção() != null) 
                        || (model.getStatus().intern().trim().equalsIgnoreCase("Extraviado") && model.getAção() != null)
                        || (model.getStatus().intern().trim().equalsIgnoreCase(""))
                        || (model.getStatus().intern().trim().equalsIgnoreCase("Sujo"))) {
                    jTextFieldDesc.setText(instrum.getDescrição().intern().trim());
                    InputStream input = new ByteArrayInputStream(instrum.getImagem());
                    try {
                        BufferedImage imagem = ImageIO.read(input);
                        double imgAltura = 240;
                        double imgLargura = 320;
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
                    for (int i = 0; i < rows2; i++) {
                        if (jTextFieldCódInst.getText().intern().trim().equals(((String) Tabela2.getValueAt(i, 0)).intern().trim())){
                            Object[] conteúdo = {instrum.getCód(), instrum.getDescrição(), "Lavando", sdf.format(dt_atual)};
                            Tabela1.addRow(conteúdo);
                            Tabela2.removeRow(i);
                            break;
                        } else {
                            t2++;
                        }
                    }
                    jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
                    if (rows1 != 0) {
                        for (int i = 0; i < rows1; i++) {
                            if (jTextFieldCódInst.getText().intern().trim().equals(((String) Tabela1.getValueAt(i, 0)).intern().trim())){
                                JOptionPane.showMessageDialog(null, "<html><center>Ítem já recebido!<br>", "", JOptionPane.DEFAULT_OPTION);
                            } else {
                                t1++;
                            }
                        }
                    }
                    if (t2 == rows2 && t1 == rows1) {
                        JOptionPane.showMessageDialog(null, "<html><center>Este ítem não pertence"
                                + " a esta bandeja!<br>", "", JOptionPane.DEFAULT_OPTION);
                        jTextFieldCódInst.setText("");
                        jTextFieldDesc.setText("");
                        jLabelImagem.setIcon(null);
                    }
                    rows2 = Tabela2.getRowCount();
                    if (rows2 == 0) {
                        jTextFieldCódInst.setEnabled(!true);
                        jButtonDefeito.setEnabled(!true);
                        jButtonExtravio.setEnabled(!true);
                        jButtonConcluir.setEnabled(true);
                        jButtonConcluir.requestFocus();
                    }
                } else if (model.getStatus().intern().trim().equalsIgnoreCase("Danificado")) {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                            + "Consta no sistema a informação de que <br>"
                            + "o instrumental encontra-se com defeito!<br>"
                            + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCódInst.setText("");
                    jTextFieldCódInst.requestFocus();
                } else if (model.getStatus().intern().trim().equalsIgnoreCase("Extraviado")) {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>"
                            + "Consta no sistema a informação de que <br>"
                            + "o instrumental encontra-se extraviado!<br>"
                            + "Entre em contato com o administrador.<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCódInst.setText("");
                    jTextFieldCódInst.requestFocus();
                } else if (model.getStatus().intern().trim().equalsIgnoreCase("Lavando")) {
                    JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>O instrumental"
                            + " já foi recebido para lavagem.<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCódInst.setText("");
                    jTextFieldCódInst.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><center>Atenção!<br>O código não pertence"
                        + " a um instrumental!<br>", "", JOptionPane.DEFAULT_OPTION);
                jTextFieldCódInst.setText("");
                jTextFieldCódInst.requestFocus();
            }
        } else if (instru.getOk() == 0) {
            jTextFieldCódInst.setEnabled(true);
            jTextFieldCódInst.setText("");
            jTextFieldDesc.setText("");
            jLabelImagem.setIcon(null);
            instru.setOk(0);
        }
        jTextFieldCódInst.setText("");
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
    }//GEN-LAST:event_jTextFieldCódInstActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (Tabela2.getRowCount() != 0) {
            int sair = JOptionPane.showConfirmDialog(rootPane, "<html><center>Cancelar o"
                    + " recebimento?<br>", "", JOptionPane.YES_NO_OPTION);
            if (sair == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        moviment.setCodigo(jTextFieldCódBd.getText());
        moviment.setDesc(jTextFieldDescBd.getText());
        moviment.setStatus("Lavando");
        moviment.setData(sdf.format(dt_atual));
        moviment.setPertence("Bandeja");
        moviment.setFantasia(jTextFieldNomeBd.getText());
        moviment.setSetor(jTextFieldSetor.getText());
        moviment.setOp(jTextFieldOp.getText().trim());
        moviment.setQtd(1);
        mov.Salvar(moviment);
        for (int i = 0; i < Tabela1.getRowCount(); i++ ){
            moviment.setOp(jTextFieldOp.getText());
            moviment.setSuperv("");
            if (Tabela1.getValueAt(i, 2).equals("Danificado") || Tabela1.getValueAt(i, 2).equals("Extraviado")) {
                if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
                    moviment.setOp(jTextFieldOp.getText().trim());
                } else {
                    moviment.setSuperv(troca.getOperador());
                }
            }
            moviment.setCodigo((String) Tabela1.getValueAt(i, 0));
            moviment.setDesc((String) Tabela1.getValueAt(i, 1));
            moviment.setStatus((String) Tabela1.getValueAt(i, 2));
            moviment.setData((String) Tabela1.getValueAt(i, 3));
            moviment.setPertence(jTextFieldCódBd.getText());
            moviment.setFantasia(jTextFieldNomeBd.getText());
            moviment.setSetor(jTextFieldSetor.getText());
            moviment.setQtd(1);
            mov.Salvar(moviment);
        }
        dispose();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonExtravioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExtravioActionPerformed
        int count = 0;
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            count++;
        }
        if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
            troca.setNivel(1);
        } else {
            sessão = new TrocarUsuario(this, true);
            sessão.setVisible(true);
        }
        if (troca.getNivel() == 1) {
            int extr = JOptionPane.showConfirmDialog(rootPane, "<html><center>Informar para o sistema"
                    + " a perda de "+count+" ítem(ns)?<br>", "", JOptionPane.YES_NO_OPTION);
            if (extr == JOptionPane.YES_OPTION) {
                for (int i = 0; i < Tabela2.getRowCount(); i++){
                    Object[] conteúdo = {Tabela2.getValueAt(i, 0), Tabela2.getValueAt(i, 1),
                        "Extraviado", sdf.format(dt_atual)};
                    Tabela1.addRow(conteúdo);
                }
                int n = Tabela2.getRowCount();
                for (int i = 0; i < n; i++){
                    Tabela2.removeRow(0);
                }
            }
            if (Tabela2.getRowCount() == 0) {
                jTextFieldCódInst.setEnabled(!true);
                jButtonDefeito.setEnabled(!true);
                jButtonExtravio.setEnabled(!true);
                jButtonConcluir.setEnabled(true);
                jButtonConcluir.requestFocus();
            }
            jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        }
    }//GEN-LAST:event_jButtonExtravioActionPerformed

    private void jButtonDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefeitoActionPerformed
        int t1 = 0;
        int t2 = 0;
        if (Sessão.getNivel().intern().trim().equalsIgnoreCase("Administrador")) {
            troca.setNivel(1);
        } else {
            sessão = new TrocarUsuario(this, true);
            sessão.setVisible(true);
        }
        if (troca.getNivel() == 1) {
            String cod = JOptionPane.showInputDialog("<html><center>Entre com o Código do Instrumental.<br>");
            instru.setBusca(cod);
            InstruMod model = inst.Buscar(instru);
            InputStream input = new ByteArrayInputStream(model.getImagem());
            try {
                BufferedImage imagem = ImageIO.read(input);
                double imgAltura = 240;
                double imgLargura = 320;
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
            if ((instru.getOk() == 1) && (Tabela2.getRowCount() != 0)){
                if (Tabela1.getRowCount() != 0) {
                    for (int i = 0; i < Tabela1.getRowCount(); i++) {
                        if (model.getCód().intern().trim().equals(((String) Tabela1.getValueAt(i, 0)).intern().trim())
                                && Tabela1.getValueAt(i, 3).equals("Lavando")){
                            int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atençao!"
                                    + "<br>Este ítem foi recebido sem defeito!"
                                    + "<br>Gostaria de recebe-lo como defeituoso?<br>", "", JOptionPane.YES_NO_OPTION);
                            if (c == JOptionPane.YES_OPTION) {
                                Tabela1.setValueAt("Danificado", i, 3);
                            }
                        } else if (model.getCód().intern().trim().equals(((String) Tabela1.getValueAt(i, 0)).intern().trim())
                                && Tabela1.getValueAt(i, 3).equals("Danificado")) {
                            int c = JOptionPane.showConfirmDialog(rootPane, "<html><center>Atençao!"
                                    + "<br>Este ítem já foi recebido como defeituoso!"
                                    + "<br>Gostaria de recebe-lo sem defeito?<br>", "", JOptionPane.YES_NO_OPTION);
                            if (c == JOptionPane.YES_OPTION) {
                                Tabela1.setValueAt("Lavando", i, 3);
                            }
                        } else {
                            t1++;
                        }
                    }
                }
                for (int i = 0; i < Tabela2.getRowCount(); i++) {
                    if (model.getCód().intern().trim().equals(((String) Tabela2.getValueAt(i, 0)).intern().trim())){
                        Object[] conteúdo = {model.getCód().intern().trim(), model.getDescrição().intern().trim(),
                            "Danificado", sdf.format(dt_atual)};
                        Tabela1.addRow(conteúdo);
                        Tabela2.removeRow(i);
                        break;
                    } else {
                        t2++;
                    }
                }
                jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
                if (t2 == Tabela2.getRowCount() && t1 == Tabela1.getRowCount()) {
                    JOptionPane.showMessageDialog(null, "<html><center>Este ítem não pertence"
                            + " a esta bandeja!<br>", "", JOptionPane.DEFAULT_OPTION);
                    jTextFieldCódInst.setText("");
                    jTextFieldDesc.setText("");
                    jLabelImagem.setIcon(null);
                }
                jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
                if (Tabela2.getRowCount() == 0) {
                    jTextFieldCódInst.setEnabled(!true);
                    jButtonDefeito.setEnabled(!true);
                    jButtonExtravio.setEnabled(!true);
                    jButtonConcluir.setEnabled(true);
                    jButtonConcluir.requestFocus();
                }
            } else if (instru.getOk() == 0) {
                jTextFieldCódInst.setEnabled(true);
                jTextFieldCódInst.setText("");
                jTextFieldDesc.setText("");
                jLabelImagem.setIcon(null);
                instru.setOk(0);
            }
            if (Tabela2.getRowCount() == 0) {
                jTextFieldCódInst.setEnabled(!true);
                jButtonDefeito.setEnabled(!true);
                jButtonExtravio.setEnabled(!true);
                jButtonConcluir.setEnabled(true);
                jButtonConcluir.requestFocus();
            } else {
                jTextFieldCódInst.requestFocus();
            }
            jTextFieldCódInst.requestFocus();
            jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        }
    }//GEN-LAST:event_jButtonDefeitoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LavarBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LavarBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LavarBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LavarBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LavarBandeja dialog = new LavarBandeja(lbandeja, true);
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
    private javax.swing.JButton jButtonExtravio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldCódBd;
    private javax.swing.JTextField jTextFieldCódInst;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldDescBd;
    private javax.swing.JTextField jTextFieldEspeciali;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldNomeBd;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldSetor;
    // End of variables declaration//GEN-END:variables

}
