package com.knowledge.horus.views;

import Controle.Cme.BandejaSQL;
import Controle.Cme.InstruSQL;
import Modelos.Cme.BandejaMod;
import Modelos.Cme.InstruMod;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NovaBandeja extends javax.swing.JDialog {
    
    InstruMod instru = new InstruMod();
    InstruSQL inst = new InstruSQL();
    BandejaMod bandeja = new BandejaMod();
    BandejaSQL bdj = new BandejaSQL();
    BufferedImage novaImagem;
    int n = 0;
    int e = 0;
    public static MenuGerenciar novabd;

    public NovaBandeja(MenuGerenciar parent, boolean modal) {
        super(parent, modal);
        initComponents();
        bandeja.setStatus(0);
        bandeja.setPos(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldCódBd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomeBd = new javax.swing.JTextField();
        jTextFieldEspecialidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jButtonExcluirBandeja = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Conteúdo da bandeja");
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
        jTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(100);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 490));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nova bandeja");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jTextFieldCódBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódBdActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldCódBd);
        jTextFieldCódBd.setBounds(90, 10, 260, 20);

        jLabel3.setText("Código");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 60, 20);

        jTextFieldNomeBd.setEnabled(false);
        jTextFieldNomeBd.setFocusable(false);
        jPanel2.add(jTextFieldNomeBd);
        jTextFieldNomeBd.setBounds(90, 40, 260, 20);

        jTextFieldEspecialidade.setEnabled(false);
        jPanel2.add(jTextFieldEspecialidade);
        jTextFieldEspecialidade.setBounds(90, 70, 260, 20);

        jLabel4.setText("Especialidade");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 70, 90, 20);

        jLabel5.setText("Descrição");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 40, 90, 20);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 360, 100));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel6.setText("Código");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 10, 110, 20);

        jTextFieldCódInst.setEnabled(false);
        jTextFieldCódInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódInstActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCódInst);
        jTextFieldCódInst.setBounds(90, 10, 260, 20);

        jTextFieldDescrição.setEnabled(false);
        jTextFieldDescrição.setFocusable(false);
        jPanel1.add(jTextFieldDescrição);
        jTextFieldDescrição.setBounds(10, 50, 340, 20);

        jLabel7.setText("Descrição");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 30, 70, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 360, 80));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Instrumental");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 360, 20));

        jLabelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabelImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 360, 270));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ítens");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, 40, 20));

        jTextFieldItens.setEditable(false);
        jTextFieldItens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 40, 20));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 70, 23));

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 70, 23));

        jButtonExcluir.setText("Excluir Ítem");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 100, 23));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, 70, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, 70, 23));

        jButtonExcluirBandeja.setText("Excluir Bandeja");
        jButtonExcluirBandeja.setEnabled(false);
        jButtonExcluirBandeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirBandejaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluirBandeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 120, -1));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 560));

        setSize(new java.awt.Dimension(839, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCódBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódBdActionPerformed
        instru.setBusca(jTextFieldCódBd.getText());
        InstruMod modeli = inst.Buscar(instru);
        if (instru.getOk() == 1){
            jTextFieldCódBd.setEnabled(!true);
            jTextFieldNomeBd.setText(modeli.getDescrição().trim());
            jTextFieldEspecialidade.setText(modeli.getEspecialidade().trim());
            bandeja.setCódBd(jTextFieldCódBd.getText());
            bdj.TestaBandeja(bandeja);
            if (bandeja.getStatus() == 1){
                JOptionPane.showMessageDialog(null, "Esta bandeja já foi cadastrada.\nPara editá-la, clique no botão Editar,"
                + "\nou, para montar uma nova bandeja, clique no botão Limpar.");
            }
            jTextFieldCódInst.setEnabled(true);
            jTextFieldCódInst.grabFocus();
            jButtonLimpar.setEnabled(true);
            if (bandeja.getStatus() == 1) {
                jTextFieldCódInst.setEnabled(!true);
                jTable.setEnabled(!true);
                bandeja.setCódBd(jTextFieldCódBd.getText());
                BandejaMod model = bdj.Buscar(bandeja);
                int f = bandeja.getLin();
                bandeja.setPos(1);
                for (int i = 0; i < f; i++){
                    model = bdj.Buscar(bandeja);
                    DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                    Object[] conteúdo = {model.getCódInst(), model.getDesInst(), model.getImgInst()};
                    Tabela1.addRow(conteúdo);
                    bandeja.setPos(i + 2);
                }
            int rows = jTable.getRowCount();
            jTextFieldItens.setText(String.valueOf(rows));
            jButtonEditar.setEnabled(true);
            jButtonExcluirBandeja.setEnabled(true);
            }
        }else if (instru.getOk() == 0){
            JOptionPane.showMessageDialog(null, "Ítem não encontrado!\n");
            jTextFieldCódBd.setEnabled(true);
            jTextFieldCódBd.setText("");
            instru.setOk(0);
        }
    }//GEN-LAST:event_jTextFieldCódBdActionPerformed
        
    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        if (bandeja.getStatus() == 1) {
            jTextFieldCódBd.setText("");
            jTextFieldNomeBd.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódBd.setEnabled(true);
            jTextFieldCódBd.grabFocus();
            jLabelImagem.setIcon(null);
            jButtonEditar.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonSalvar.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonExcluirBandeja.setEnabled(!true);
            bandeja.setPos(0);
        }
        else{
            int limpar = JOptionPane.showConfirmDialog(rootPane, "Atençao.\nTodos os ítens da tabela serão "
                    + "excluídos.\nContinuar?\n");
            if (limpar == JOptionPane.YES_OPTION) {
                jTextFieldCódBd.setText("");
                jTextFieldNomeBd.setText("");
                jTextFieldEspecialidade.setText("");
                jTextFieldCódInst.setText("");
                jTextFieldDescrição.setText("");
                jTextFieldItens.setText("");
                DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                while ( 0 != jTable.getRowCount()){
                    Tabela1.removeRow(0);
                }
                jTextFieldCódInst.setEnabled(!true);
                jTextFieldCódBd.setEnabled(true);
                jTextFieldCódBd.grabFocus();
                jLabelImagem.setIcon(null);
                jButtonEditar.setEnabled(!true);
                jButtonExcluir.setEnabled(!true);
                jButtonSalvar.setEnabled(!true);
                jButtonLimpar.setEnabled(!true);
                jButtonExcluirBandeja.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int tupla = JOptionPane.showConfirmDialog(rootPane, "Retirar instrumental da bandeja?\n");
        if (tupla == JOptionPane.YES_OPTION) {
            if (jTable.isRowSelected(jTable.getSelectedRow())) {
                DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                Tabela1.removeRow(jTable.getSelectedRow());
            }
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            int o = Tabela1.getRowCount();
            if (o == 0){
                jButtonExcluir.setEnabled(!true);
                jTextFieldCódBd.grabFocus();
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (e == 0) {
            bandeja.setCódBd(jTextFieldCódBd.getText());
            bdj.Criar(bandeja);
            for (int i = 0; i < (jTable.getRowCount()); i++ ){
            bandeja.setCódInst((String) jTable.getValueAt(i, 0));
            bandeja.setDesInst((String) jTable.getValueAt(i, 1));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bandeja.setImgInst((byte[]) baos.toByteArray());
            bdj.Salvar(bandeja);
            }
            jTextFieldCódBd.setText("");
            jTextFieldNomeBd.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódBd.setEnabled(true);
            jTextFieldCódBd.grabFocus();
            jLabelImagem.setIcon(null);
            bandeja.setPos(0);
        }else if (e == 1){
            bdj.Limpar(bandeja);
            for (int i = 0; i < (jTable.getRowCount()); i++ ){
            bandeja.setCódInst((String) jTable.getValueAt(i, 0));
            bandeja.setDesInst((String) jTable.getValueAt(i, 1));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bandeja.setImgInst((byte[]) baos.toByteArray());
            bdj.Salvar(bandeja);
            }
            jTextFieldCódBd.setText("");
            jTextFieldNomeBd.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódBd.setEnabled(true);
            jTextFieldCódBd.grabFocus();
            jLabelImagem.setIcon(null);
            bandeja.setPos(0);
        }
        jButtonSalvar.setEnabled(!true);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        jTable.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jTextFieldCódInst.setEnabled(true);
        jTextFieldCódInst.requestFocus();
        jButtonSalvar.setEnabled(true);
        e = 1;
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirBandejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirBandejaActionPerformed
        int excluir = JOptionPane.showConfirmDialog(rootPane, "Excluir esta bandeja do banco de dados?\n");
        if (excluir == JOptionPane.YES_OPTION) {
            bdj.ExcluirBandeja(bandeja);
            jTextFieldCódBd.setText("");
            jTextFieldNomeBd.setText("");
            jTextFieldEspecialidade.setText("");
            jTextFieldCódInst.setText("");
            jTextFieldDescrição.setText("");
            jTextFieldItens.setText("");
            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
            while ( 0 != jTable.getRowCount()){
                Tabela1.removeRow(0);
            }
            jTextFieldCódInst.setEnabled(!true);
            jTextFieldCódBd.setEnabled(true);
            jTextFieldCódBd.grabFocus();
            jLabelImagem.setIcon(null);
            jButtonEditar.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonSalvar.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonExcluirBandeja.setEnabled(!true);
            bandeja.setStatus(0);
        }
    }//GEN-LAST:event_jButtonExcluirBandejaActionPerformed

    private void jTextFieldCódInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódInstActionPerformed
        instru.setBusca(jTextFieldCódInst.getText());
        InstruMod model = inst.Buscar(instru);
        if (instru.getOk() == 1){
            jTextFieldDescrição.setText(model.getDescrição().intern().trim());
            InputStream input = new ByteArrayInputStream(model.getImagem());
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
                            + "incluído na bandeja!\nGostaria de exclui-lo?\n");
                        if (duplicado == JOptionPane.YES_OPTION) {
                            DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                            Tabela1.removeRow(i);
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
        }else if (instru.getOk() == 0){
            JOptionPane.showMessageDialog(null, "Ítem não encontrado!\n");
            jTextFieldCódInst.setEnabled(true);
            jTextFieldCódInst.setText("");
            instru.setOk(0);
        }
    }//GEN-LAST:event_jTextFieldCódInstActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovaBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaBandeja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovaBandeja dialog = new NovaBandeja(novabd, true);
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
    private javax.swing.JButton jButtonExcluirBandeja;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTextField jTextFieldCódBd;
    private javax.swing.JTextField jTextFieldCódInst;
    private javax.swing.JTextField jTextFieldDescrição;
    private javax.swing.JTextField jTextFieldEspecialidade;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldNomeBd;
    // End of variables declaration//GEN-END:variables
}
