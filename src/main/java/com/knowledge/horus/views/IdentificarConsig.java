package com.knowledge.horus.views;

import Controle.Conexão;
import Controle.Sessão;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class IdentificarConsig extends javax.swing.JDialog {
    
    Conexão conex = new Conexão();
    public static NovoFornec fornec;
    public static NovoConsig consig;

    public IdentificarConsig(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextFieldOp.setText(Sessão.getLogado());
        buscarFornec();
        buscarItem();
    }
    
    public void buscarFornec(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Fornecedor' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxFornec.removeAllItems();
            do{
                jComboBoxFornec.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBox\n" + ex.getMessage());
        }
        conex.desconectar();
    }
    
    public void buscarItem(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Tipo' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxItem.removeAllItems();
            do{
                jComboBoxItem.addItem(conex.rs.getString("descrição"));
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRef = new javax.swing.JTextField();
        jTextFieldCirurg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxFornec = new javax.swing.JComboBox<>();
        jButtonNovoFornec = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQtd = new javax.swing.JTextField();
        jCheckBoxMarrom = new javax.swing.JCheckBox();
        jCheckBoxAmarelo = new javax.swing.JCheckBox();
        jCheckBoxRoxo = new javax.swing.JCheckBox();
        jCheckBoxLaranja = new javax.swing.JCheckBox();
        jCheckBoxVermelho = new javax.swing.JCheckBox();
        jCheckBoxVerde = new javax.swing.JCheckBox();
        jCheckBoxPreto = new javax.swing.JCheckBox();
        jCheckBoxCinza = new javax.swing.JCheckBox();
        jCheckBoxLilás = new javax.swing.JCheckBox();
        jCheckBoxBege = new javax.swing.JCheckBox();
        jCheckBoxAzulClaro = new javax.swing.JCheckBox();
        jCheckBoxVerdeClaro = new javax.swing.JCheckBox();
        jCheckBoxRosa = new javax.swing.JCheckBox();
        jCheckBoxPurpura = new javax.swing.JCheckBox();
        jCheckBoxAzul = new javax.swing.JCheckBox();
        jCheckBoxBranco = new javax.swing.JCheckBox();
        jCheckBoxVerdeMenta = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonNovo = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOp = new javax.swing.JTextField();
        jTextFieldData = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxItem = new javax.swing.JComboBox<>();
        jButtonNovoItem = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Fornecedor:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 20));

        jLabel4.setText("Cirurgião:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jTextFieldRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRefActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 280, -1));

        jTextFieldCirurg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCirurgActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCirurg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 280, -1));

        jLabel5.setText("Ítem:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 30, 20));

        jComboBoxFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFornecActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxFornec, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 220, 23));

        jButtonNovoFornec.setText("...");
        jButtonNovoFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoFornecActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovoFornec, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 30, 23));

        jLabel6.setText("Qtd. de ítens / peças:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 110, 20));

        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 40, -1));

        jCheckBoxMarrom.setBackground(new java.awt.Color(153, 51, 0));
        jCheckBoxMarrom.setToolTipText("Marron");
        jCheckBoxMarrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMarromActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxMarrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 36, 20));

        jCheckBoxAmarelo.setBackground(new java.awt.Color(255, 255, 0));
        jCheckBoxAmarelo.setToolTipText("Amarelo");
        jCheckBoxAmarelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAmareloActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxAmarelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 36, 20));

        jCheckBoxRoxo.setBackground(new java.awt.Color(102, 0, 102));
        jCheckBoxRoxo.setToolTipText("Roxo");
        jCheckBoxRoxo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRoxoActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxRoxo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 36, 20));

        jCheckBoxLaranja.setBackground(new java.awt.Color(255, 153, 0));
        jCheckBoxLaranja.setToolTipText("Laranja");
        jCheckBoxLaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLaranjaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxLaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 36, 20));

        jCheckBoxVermelho.setBackground(new java.awt.Color(255, 0, 0));
        jCheckBoxVermelho.setToolTipText("Vermelho");
        jCheckBoxVermelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVermelhoActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxVermelho, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 36, 20));

        jCheckBoxVerde.setBackground(new java.awt.Color(0, 102, 51));
        jCheckBoxVerde.setToolTipText("Verde");
        jCheckBoxVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVerdeActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 36, 20));

        jCheckBoxPreto.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBoxPreto.setToolTipText("Preto");
        jCheckBoxPreto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPretoActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxPreto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 36, 20));

        jCheckBoxCinza.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBoxCinza.setToolTipText("Cinza");
        jCheckBoxCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCinzaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxCinza, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 36, 20));

        jCheckBoxLilás.setBackground(new java.awt.Color(204, 153, 255));
        jCheckBoxLilás.setToolTipText("Lilás");
        jCheckBoxLilás.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLilásActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxLilás, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 36, 20));

        jCheckBoxBege.setBackground(new java.awt.Color(211, 177, 143));
        jCheckBoxBege.setToolTipText("Bege");
        jCheckBoxBege.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBegeActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxBege, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 36, 20));

        jCheckBoxAzulClaro.setBackground(new java.awt.Color(102, 204, 255));
        jCheckBoxAzulClaro.setToolTipText("Azul Claro");
        jCheckBoxAzulClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAzulClaroActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxAzulClaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 36, 20));

        jCheckBoxVerdeClaro.setBackground(new java.awt.Color(130, 209, 50));
        jCheckBoxVerdeClaro.setToolTipText("Verde Claro");
        jCheckBoxVerdeClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVerdeClaroActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxVerdeClaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 36, 20));

        jCheckBoxRosa.setBackground(new java.awt.Color(255, 204, 204));
        jCheckBoxRosa.setToolTipText("Rosa");
        jCheckBoxRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRosaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 36, 20));

        jCheckBoxPurpura.setBackground(new java.awt.Color(204, 0, 153));
        jCheckBoxPurpura.setToolTipText("Púrpura");
        jCheckBoxPurpura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPurpuraActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxPurpura, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 36, 20));

        jCheckBoxAzul.setBackground(new java.awt.Color(0, 0, 153));
        jCheckBoxAzul.setToolTipText("Azul");
        jCheckBoxAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAzulActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 36, 20));

        jCheckBoxBranco.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxBranco.setToolTipText("Branco");
        jCheckBoxBranco.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jCheckBoxBranco.setBorderPainted(true);
        jCheckBoxBranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBrancoActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxBranco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 36, 20));

        jCheckBoxVerdeMenta.setBackground(new java.awt.Color(34, 205, 162));
        jCheckBoxVerdeMenta.setToolTipText("Verde Menta");
        jCheckBoxVerdeMenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVerdeMentaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxVerdeMenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 36, 20));

        jLabel7.setText("Cores:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 20));

        jLabel8.setText("Referência: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Identificar material consignado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 230, 20));

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 70, 23));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 70, 23));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 70, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 70, 23));

        jLabel1.setText("Operador:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 110, -1));

        jTextFieldData.setEnabled(false);
        getContentPane().add(jTextFieldData, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 120, -1));

        jLabel10.setText("Data:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 50, 20));

        getContentPane().add(jComboBoxItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 320, 23));

        jButtonNovoItem.setText("...");
        jButtonNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoItemActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovoItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 30, 23));

        jLabelFundo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 200));

        setSize(new java.awt.Dimension(768, 191));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFornecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFornecActionPerformed

    private void jButtonNovoFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoFornecActionPerformed
        fornec = new NovoFornec(this, true);
        fornec.setVisible(true);
    }//GEN-LAST:event_jButtonNovoFornecActionPerformed

    private void jTextFieldCirurgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCirurgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCirurgActionPerformed

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

    private void jCheckBoxBrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBrancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxBrancoActionPerformed

    private void jCheckBoxAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAzulActionPerformed

    private void jCheckBoxVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVerdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxVerdeActionPerformed

    private void jCheckBoxVermelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVermelhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxVermelhoActionPerformed

    private void jCheckBoxAmareloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAmareloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAmareloActionPerformed

    private void jCheckBoxRoxoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRoxoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxRoxoActionPerformed

    private void jCheckBoxLaranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxLaranjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxLaranjaActionPerformed

    private void jCheckBoxMarromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMarromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMarromActionPerformed

    private void jCheckBoxPretoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPretoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxPretoActionPerformed

    private void jCheckBoxCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCinzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCinzaActionPerformed

    private void jCheckBoxLilásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxLilásActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxLilásActionPerformed

    private void jCheckBoxBegeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBegeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxBegeActionPerformed

    private void jCheckBoxAzulClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAzulClaroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAzulClaroActionPerformed

    private void jCheckBoxVerdeClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVerdeClaroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxVerdeClaroActionPerformed

    private void jCheckBoxRosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRosaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxRosaActionPerformed

    private void jCheckBoxPurpuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPurpuraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxPurpuraActionPerformed

    private void jCheckBoxVerdeMentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVerdeMentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxVerdeMentaActionPerformed

    private void jTextFieldRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRefActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        java.util.Date dt_atual = new java.util.Date();        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        jTextFieldData.setText(sdf.format(dt_atual));
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(rootPane, "Deseja cancelar o recebimento?\n");
        if (sair == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoItemActionPerformed
        consig = new NovoConsig(this, true);
        consig.setVisible(true);
    }//GEN-LAST:event_jButtonNovoItemActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IdentificarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentificarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentificarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentificarConsig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IdentificarConsig dialog = new IdentificarConsig(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonNovoFornec;
    private javax.swing.JButton jButtonNovoItem;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAmarelo;
    private javax.swing.JCheckBox jCheckBoxAzul;
    private javax.swing.JCheckBox jCheckBoxAzulClaro;
    private javax.swing.JCheckBox jCheckBoxBege;
    private javax.swing.JCheckBox jCheckBoxBranco;
    private javax.swing.JCheckBox jCheckBoxCinza;
    private javax.swing.JCheckBox jCheckBoxLaranja;
    private javax.swing.JCheckBox jCheckBoxLilás;
    private javax.swing.JCheckBox jCheckBoxMarrom;
    private javax.swing.JCheckBox jCheckBoxPreto;
    private javax.swing.JCheckBox jCheckBoxPurpura;
    private javax.swing.JCheckBox jCheckBoxRosa;
    private javax.swing.JCheckBox jCheckBoxRoxo;
    private javax.swing.JCheckBox jCheckBoxVerde;
    private javax.swing.JCheckBox jCheckBoxVerdeClaro;
    private javax.swing.JCheckBox jCheckBoxVerdeMenta;
    private javax.swing.JCheckBox jCheckBoxVermelho;
    private javax.swing.JComboBox<String> jComboBoxFornec;
    private javax.swing.JComboBox<String> jComboBoxItem;
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
    private javax.swing.JTextField jTextFieldCirurg;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldQtd;
    private javax.swing.JTextField jTextFieldRef;
    // End of variables declaration//GEN-END:variables
}
