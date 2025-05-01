package com.knowledge.horus.views;

import com.knowledge.horus.controls.Sessão;
import com.knowledge.horus.models.Movimentacao;
import com.knowledge.horus.controls.MovimentaDAO;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamException;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReceberEsteril extends javax.swing.JDialog {

    Movimentacao moviment = new Movimentacao();
    MovimentaDAO mov = new MovimentaDAO();
    List<Movimentacao> lista = null;
    public static MenuReceber esteril;
    private Dimension dimensao_default;
    private Webcam WebCam;
    boolean exec = true;
    byte[] bytes;
    BufferedImage foto;
    int b = 0;
    int q = 0;
    int x = 0;
    int tot;
    java.util.Date dt_atual = new java.util.Date();        
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat cod = new SimpleDateFormat ("ddMMyy");
    DefaultTableModel Tabela;
    String buscar = "";
       
    public ReceberEsteril(MenuReceber parent, boolean modal){
        super (parent, modal);
        initComponents();
        jTextFieldOp.setText(Sessão.getLogado());
        Start();
        Tabela = (DefaultTableModel) jTable.getModel();
        jTextFieldItem.requestFocus();
        jTextFieldItem.select(0, 0);
        System.out.println(bytes);
    }
    
    private void Start(){
        try{
            dimensao_default = WebcamResolution.VGA.getSize();
            WebCam = Webcam.getDefault();
            WebCam.setViewSize(dimensao_default);
        }catch (WebcamException e){
        }
    }
    
    private void Vídeo(){
        new Thread(){
            @Override
            public void run(){
                try {
                    while (true && exec){
                        try {
                            Image imagem = WebCam.getImage();
                            ImageIcon icon = new ImageIcon(imagem);
                            icon.setImage(icon.getImage().getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), 100));
                            jLabelFoto.setIcon(icon);
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                        }
                    }
                } catch (Exception e) {
                }
            }
        }.start();
    }
    
    public boolean data(String data) {
        try {
            sdf2.setLenient(false);
            sdf2.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public boolean dataMenorQueHoje(String data) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVerificada = LocalDate.parse(data, dtf);
            LocalDate hoje = LocalDate.now();
            return dataVerificada.compareTo(hoje) < 0;
        } catch (Exception e){
            return !true;
        }
    }
    
    public boolean dataMaiorQueHoje(String data) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVerificada = LocalDate.parse(data, dtf);
            LocalDate hoje = LocalDate.now();
            return dataVerificada.compareTo(hoje) > 0;
        } catch (Exception e){
            return !true;
        }
    }
    
    public boolean dataMaiorQueValidade(String data1, String data2) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataProced = LocalDate.parse(data1, dtf);
            LocalDate dataValid = LocalDate.parse(data2, dtf);
            return dataProced.compareTo(dataValid) > 0;
        } catch (Exception e){
            return !true;
        }
    }
    
    public void buscarMov(String psq){
        lista = new MovimentaDAO().findByDetalhes(psq);
        tot = lista.size();
    }
    
    public void limparCampos() {
        jTextFieldCirur.setText("");
        jTextFieldEster.setText("");
        jTextFieldForn.setText("");
        jTextFieldItem.setText("");
        jTextFieldLote.setText("");
        jTextFieldPac.setText("");
        jTextFieldQtd.setText("");
        jFormattedTextProced.setText("");
        jFormattedTextProcess.setText("");
        jComboBoxResult.setSelectedIndex(0);
        jFormattedTextValid.setText("");
        jTextFieldPesqOp.setText("");
        jTextFieldPesqOp.setEnabled(!true);
        jFormattedTextPesqData.setText("");
        jTextFieldPesqCód.setText("");
        jTextFieldPesqCód.setEnabled(!true);
        jLabelFoto.setIcon(null);
        jFormattedTextPesqData.setEnabled(!true);
        jCheckBox1.setSelected(!true);
        jCheckBox1.setEnabled(true);
        jTextFieldCirur.setEnabled(true);
        jTextFieldEster.setEnabled(true);
        jTextFieldForn.setEnabled(true);
        jTextFieldItem.setEnabled(true);
        jTextFieldLote.setEnabled(true);
        jTextFieldPac.setEnabled(true);
        jTextFieldQtd.setEnabled(true);
        jFormattedTextProced.setEnabled(true);
        jFormattedTextProcess.setEnabled(true);
        jComboBoxResult.setEnabled(true);
        jFormattedTextValid.setEnabled(true);
        jTextFieldOp.setText(Sessão.getLogado());
        if (jTable.getRowCount() == 0) {
            jButtonConcluir.setEnabled(!true);
        }
        jButtonExcluir.setEnabled(!true);
        jButtonIncluir.setEnabled(!true);
        jButtonLimCamp.setEnabled(!true);
        jButtonSair.setEnabled(true);
        jButtonBuscar.setEnabled(!true);
        jButtonCam.setEnabled(!true);
        jButtonAnexar.setEnabled(!true);
        jTextFieldItem.requestFocus();
    }
    
    public void limparTab(){
        while ( 0 != Tabela.getRowCount()){
            Tabela.removeRow(0);
        }
        jButtonLimTab.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldItem = new javax.swing.JTextField();
        jTextFieldQtd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldOp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonIncluir = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonConcluir = new javax.swing.JButton();
        jTextFieldPac = new javax.swing.JTextField();
        jTextFieldCirur = new javax.swing.JTextField();
        jTextFieldForn = new javax.swing.JTextField();
        jTextFieldLote = new javax.swing.JTextField();
        jTextFieldEster = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonLimTab = new javax.swing.JButton();
        jFormattedTextProced = new javax.swing.JFormattedTextField();
        jFormattedTextProcess = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            jFormattedTextProcess = new javax.swing.JFormattedTextField(data);
        }
        catch(Exception e){
        }
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jFormattedTextValid = new javax.swing.JFormattedTextField();
        jComboBoxResult = new javax.swing.JComboBox<>();
        jLabelTítulo = new javax.swing.JLabel();
        jButtonLimCamp = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldPesqOp = new javax.swing.JTextField();
        jFormattedTextPesqData = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jButtonAnexar = new javax.swing.JButton();
        jLabelFoto = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButtonCam = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldPesqCód = new javax.swing.JTextField();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldItem.setNextFocusableComponent(jTextFieldQtd);
        jTextFieldItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldItemFocusGained(evt);
            }
        });
        jTextFieldItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItemActionPerformed(evt);
            }
        });
        jTextFieldItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldItemKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, -1));

        jTextFieldQtd.setNextFocusableComponent(jTextFieldEster);
        jTextFieldQtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldQtdFocusGained(evt);
            }
        });
        jTextFieldQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdActionPerformed(evt);
            }
        });
        jTextFieldQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldQtdKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 30, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cirurgião:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Paciente:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, 20));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Operador:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 60, 20));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fornecedor:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Processamento:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 90, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Validade:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 60, 20));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 130, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data do procedimento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 130, 20));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setNextFocusableComponent(jButtonLimTab);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ítem", "Qtd.", "Fornecedor", "Esterilizadora", "Cirurgião", "Paciente", "Procedimento", "Lote", "Teste", "Processam.", "Validade", "Operador", "Data e Hora", "Cód.", "Anexo"
            }
        ));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTableComponentAdded(evt);
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(140);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(140);
            jTable.getColumnModel().getColumn(0).setMaxWidth(140);
            jTable.getColumnModel().getColumn(1).setMinWidth(40);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable.getColumnModel().getColumn(2).setMinWidth(110);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(2).setMaxWidth(110);
            jTable.getColumnModel().getColumn(3).setMinWidth(100);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(5).setResizable(false);
            jTable.getColumnModel().getColumn(6).setMinWidth(75);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(75);
            jTable.getColumnModel().getColumn(6).setMaxWidth(75);
            jTable.getColumnModel().getColumn(7).setMinWidth(70);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(7).setMaxWidth(70);
            jTable.getColumnModel().getColumn(8).setMinWidth(50);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(8).setMaxWidth(50);
            jTable.getColumnModel().getColumn(9).setMinWidth(75);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(75);
            jTable.getColumnModel().getColumn(9).setMaxWidth(75);
            jTable.getColumnModel().getColumn(10).setMinWidth(75);
            jTable.getColumnModel().getColumn(10).setPreferredWidth(75);
            jTable.getColumnModel().getColumn(10).setMaxWidth(75);
            jTable.getColumnModel().getColumn(11).setMinWidth(100);
            jTable.getColumnModel().getColumn(11).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(11).setMaxWidth(100);
            jTable.getColumnModel().getColumn(12).setMinWidth(110);
            jTable.getColumnModel().getColumn(12).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(12).setMaxWidth(110);
            jTable.getColumnModel().getColumn(13).setMinWidth(75);
            jTable.getColumnModel().getColumn(13).setPreferredWidth(75);
            jTable.getColumnModel().getColumn(13).setMaxWidth(75);
            jTable.getColumnModel().getColumn(14).setMinWidth(50);
            jTable.getColumnModel().getColumn(14).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(14).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1220, 270));

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.setEnabled(false);
        jButtonIncluir.setNextFocusableComponent(jButtonLimCamp);
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 70, 23));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 70, 23));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 460, 80, 23));

        jTextFieldPac.setNextFocusableComponent(jFormattedTextProced);
        jTextFieldPac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPacFocusGained(evt);
            }
        });
        jTextFieldPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPacActionPerformed(evt);
            }
        });
        jTextFieldPac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPacKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 340, -1));

        jTextFieldCirur.setNextFocusableComponent(jTextFieldPac);
        jTextFieldCirur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldCirurFocusGained(evt);
            }
        });
        jTextFieldCirur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCirurActionPerformed(evt);
            }
        });
        jTextFieldCirur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCirurKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldCirur, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 340, -1));

        jTextFieldForn.setNextFocusableComponent(jTextFieldCirur);
        jTextFieldForn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFornFocusGained(evt);
            }
        });
        jTextFieldForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFornActionPerformed(evt);
            }
        });
        jTextFieldForn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFornKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldForn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 340, -1));

        jTextFieldLote.setNextFocusableComponent(jFormattedTextProcess);
        jTextFieldLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLoteFocusGained(evt);
            }
        });
        jTextFieldLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoteActionPerformed(evt);
            }
        });
        jTextFieldLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLoteKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 80, -1));

        jTextFieldEster.setNextFocusableComponent(jTextFieldLote);
        jTextFieldEster.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEsterFocusGained(evt);
            }
        });
        jTextFieldEster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEsterActionPerformed(evt);
            }
        });
        jTextFieldEster.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEsterKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldEster, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 160, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ítem:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Resultado do teste: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 110, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Esterilizadora:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 90, 20));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Lote:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 40, 20));

        jButtonLimTab.setText("Limpar Tabela");
        jButtonLimTab.setEnabled(false);
        jButtonLimTab.setNextFocusableComponent(jTextFieldItem);
        jButtonLimTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimTabActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 110, 23));

        try {
            jFormattedTextProced.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextProced.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextProced.setToolTipText("");
        jFormattedTextProced.setNextFocusableComponent(jButtonCam);
        jFormattedTextProced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextProcedActionPerformed(evt);
            }
        });
        jFormattedTextProced.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextProcedKeyTyped(evt);
            }
        });
        getContentPane().add(jFormattedTextProced, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 70, -1));

        try {
            jFormattedTextProcess.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextProcess.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextProcess.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFormattedTextProcess.setName(""); // NOI18N
        jFormattedTextProcess.setNextFocusableComponent(jFormattedTextValid);
        jFormattedTextProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextProcessActionPerformed(evt);
            }
        });
        jFormattedTextProcess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextProcessKeyTyped(evt);
            }
        });
        getContentPane().add(jFormattedTextProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 70, -1));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setEnabled(false);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 70, 23));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 70, 23));

        try {
            jFormattedTextValid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextValid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextValid.setToolTipText("");
        jFormattedTextValid.setNextFocusableComponent(jTextFieldForn);
        jFormattedTextValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextValidActionPerformed(evt);
            }
        });
        jFormattedTextValid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextValidKeyTyped(evt);
            }
        });
        getContentPane().add(jFormattedTextValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 70, -1));

        jComboBoxResult.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Positivo", "Negativo" }));
        jComboBoxResult.setNextFocusableComponent(jFormattedTextProcess);
        jComboBoxResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxResultActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 100, -1));

        jLabelTítulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelTítulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTítulo.setText("Recebimento de Material Estéril");
        getContentPane().add(jLabelTítulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 20));

        jButtonLimCamp.setText("Limpar Campos");
        jButtonLimCamp.setEnabled(false);
        jButtonLimCamp.setNextFocusableComponent(jButtonLimTab);
        jButtonLimCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimCampActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimCamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 120, 23));

        jCheckBox1.setBackground(new java.awt.Color(153, 153, 153));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Operador:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 60, 20));

        jTextFieldPesqOp.setEnabled(false);
        jTextFieldPesqOp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPesqOpFocusLost(evt);
            }
        });
        jTextFieldPesqOp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPesqOpKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldPesqOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 40, 120, 20));

        try {
            jFormattedTextPesqData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextPesqData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextPesqData.setEnabled(false);
        jFormattedTextPesqData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextPesqDataFocusLost(evt);
            }
        });
        jFormattedTextPesqData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextPesqDataKeyTyped(evt);
            }
        });
        getContentPane().add(jFormattedTextPesqData, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 70, 70, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Data de Recebimento:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 130, 20));

        jButtonAnexar.setText("<html>Anexar<br />Resultado<html>");
        jButtonAnexar.setEnabled(false);
        jButtonAnexar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAnexar.setMinimumSize(new java.awt.Dimension(0, 0));
        jButtonAnexar.setNextFocusableComponent(jButtonIncluir);
        jButtonAnexar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnexarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnexar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 75, 35));

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelFoto.setOpaque(true);
        getContentPane().add(jLabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 187, 140));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Resultado:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 100, 20));

        jButtonCam.setText("Camera");
        jButtonCam.setEnabled(false);
        jButtonCam.setNextFocusableComponent(jButtonAnexar);
        jButtonCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCamActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 75, 35));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Qtd.:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, 20));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Pesquisar");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 60, 20));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Código:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 100, 60, 20));

        jTextFieldPesqCód.setEnabled(false);
        jTextFieldPesqCód.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPesqCódFocusLost(evt);
            }
        });
        jTextFieldPesqCód.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPesqCódKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldPesqCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 100, 120, 20));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 490));

        setBounds(125, 150, 1237, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        int r = jTable.getRowCount();
        for (int i = 0; i < r; i++ ){
            moviment.setId(null);
            moviment.setDescricao((String) jTable.getValueAt(i, 0));
            int qtd = Integer.parseInt(String.valueOf(jTable.getValueAt(i, 1)));
            moviment.setQtd((Integer) qtd);
            moviment.setStatus("Lavando");
            moviment.setFornecedor((String) jTable.getValueAt(i, 2));
            moviment.setEsterilizador((String) jTable.getValueAt(i, 3));
            moviment.setCirurgia((String) jTable.getValueAt(i, 4));
            moviment.setPaciente((String) jTable.getValueAt(i, 5));
            moviment.setProcedimento((String) jTable.getValueAt(i, 6));
            moviment.setNumlote((String) jTable.getValueAt(i, 7));
            moviment.setTeste((String) jTable.getValueAt(i, 8));
            moviment.setProcessamento((String) jTable.getValueAt(i, 9));
            moviment.setValidade((String) jTable.getValueAt(i, 10));
            moviment.setOperador((String) jTable.getValueAt(i, 11));
            moviment.setData((String) jTable.getValueAt(i, 12));
            moviment.setCodigo((Long) jTable.getValueAt(i, 13));
            moviment.setAnexo((byte[]) jTable.getValueAt(i, 14));
            
            mov.save(moviment);
        }
        DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
        while ( 0 != jTable.getRowCount()){
            Tabela1.removeRow(0);
        }
        jButtonConcluir.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonIncluir.setEnabled(!true);
        jButtonLimTab.setEnabled(!true);
        jButtonLimCamp.setEnabled(!true);
        jButtonSair.setEnabled(true);
        jButtonBuscar.setEnabled(!true);
        jTextFieldCirur.setText("");
        jTextFieldEster.setText("");
        jTextFieldForn.setText("");
        jTextFieldItem.setText("");
        jTextFieldLote.setText("");
        jTextFieldPac.setText("");
        jTextFieldQtd.setText("");
        jFormattedTextProced.setValue(null);
        jFormattedTextProcess.setValue(null);
        jComboBoxResult.setSelectedIndex(0);
        jFormattedTextValid.setValue(null);
        jTextFieldPesqOp.setText("");
        jTextFieldPesqOp.setEnabled(!true);
        jFormattedTextPesqData.setValue(null);
        jFormattedTextPesqData.setEnabled(!true);
        jLabelFoto.setIcon(null);
        jCheckBox1.setSelected(!true);
        jCheckBox1.setEnabled(true);
        jTextFieldCirur.setEnabled(true);
        jTextFieldEster.setEnabled(true);
        jTextFieldForn.setEnabled(true);
        jTextFieldItem.setEnabled(true);
        jTextFieldLote.setEnabled(true);
        jTextFieldPac.setEnabled(true);
        jFormattedTextProced.setEnabled(true);
        jFormattedTextProcess.setEnabled(true);
        jComboBoxResult.setEnabled(true);
        jFormattedTextValid.setEnabled(true);
        jTextFieldOp.setText(Sessão.getLogado());
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        long cód = 0;
        if (jTextFieldItem.getText().isEmpty() || jTextFieldForn.getText().isEmpty() || jTextFieldEster.getText().isEmpty() || 
                jTextFieldLote.getText().isEmpty() || jFormattedTextProcess.getText().equals("  /  /    ") ||
                jFormattedTextValid.getText().equals("  /  /    ") || jComboBoxResult.getSelectedItem().equals(" ") ||
                jTextFieldCirur.getText().isEmpty() || jTextFieldPac.getText().isEmpty() || jFormattedTextProced.getText().equals("  /  /    ")
                || bytes == null) {
            JOptionPane.showMessageDialog(rootPane, "Atenção!\nÉ obrigatório o preenchimento de todos os campos,\nInclusive a imagem do teste. ");
        } else {
            lista = mov.findOcorre();   
            if (!lista.isEmpty()) {
                String hoje = String.valueOf(cod.format(dt_atual));
                String ultimo = String.valueOf(lista.get(tot - 1).getCodigo());
                if (ultimo.substring(1, 7).equals(hoje)) {
                    moviment.setCodigo(lista.get(tot - 1).getCodigo());
                } else {
                    moviment.setCodigo(null);
                }
            }
            
            int qtd = 1;
            int sep = 1;
            
            if (!jTextFieldQtd.getText().isEmpty()) {
                qtd = Integer.parseInt(jTextFieldQtd.getText().intern().trim());
            }
            
            if (qtd != sep) {
                int varios = JOptionPane.showConfirmDialog(rootPane, "Os ítens serão embalados separadamente?");
                if (varios == JOptionPane.YES_OPTION) {
                    sep = qtd;
                }
            }
            
            for (int n = 0; n < sep; n++){
                if (moviment.getCodigo() == null && jTable.getRowCount() == 0) {
                    cód = Long.parseLong("8" + String.valueOf(cod.format(dt_atual)) + "001");
                } else if (moviment.getCodigo() != null && jTable.getRowCount() == 0) {
                    cód = (moviment.getCodigo() + 1);
                } else if (jTable.getRowCount() != 0) {
                    int a = jTable.getRowCount();
                    cód = (Long.parseLong(String.valueOf(jTable.getValueAt(a - 1, 13))) + 1);
                }
                
                if (qtd > 1 && sep > 1) {
                    Object[] dados = {jTextFieldItem.getText(), "1", jTextFieldForn.getText(), jTextFieldEster.getText(), jTextFieldCirur.getText(),
                        jTextFieldPac.getText(), jFormattedTextProced.getText(), jTextFieldLote.getText(), jComboBoxResult.getSelectedItem(),
                        jFormattedTextProcess.getText(), jFormattedTextValid.getText(), jTextFieldOp.getText(), sdf.format(dt_atual), cód, bytes};
                    Tabela.addRow(dados);
                } else {
                    Object[] dados = {jTextFieldItem.getText(), qtd, jTextFieldForn.getText(), jTextFieldEster.getText(), jTextFieldCirur.getText(),
                        jTextFieldPac.getText(), jFormattedTextProced.getText(), jTextFieldLote.getText(), jComboBoxResult.getSelectedItem(),
                        jFormattedTextProcess.getText(), jFormattedTextValid.getText(), jTextFieldOp.getText(), sdf.format(dt_atual), cód, bytes};
                    Tabela.addRow(dados);
                }
            }
            jTextFieldItem.setText("");
            jTextFieldQtd.setText("");
            jButtonConcluir.setEnabled(true);
            jButtonExcluir.setEnabled(!true);
            jButtonLimTab.setEnabled(true);
            jButtonLimCamp.setEnabled(true);
            jButtonCam.setEnabled(!true);
            jButtonAnexar.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonBuscar.setEnabled(!true);
            jTextFieldItem.requestFocus();
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int Ex = jTable.getSelectedRowCount();
        if (Ex != 0) {
            while ( 0 != jTable.getSelectedRowCount()){
                Tabela.removeRow(jTable.getSelectedRow());
            }
            jTextFieldCirur.setText("");
            jTextFieldEster.setText("");
            jTextFieldForn.setText("");
            jTextFieldItem.setText("");
            jTextFieldLote.setText("");
            jTextFieldPac.setText("");
            jTextFieldQtd.setText("");
            jFormattedTextProced.setValue(null);
            jFormattedTextProcess.setValue(null);
            jComboBoxResult.setSelectedIndex(0);
            jFormattedTextValid.setValue(null);
            jTextFieldPesqOp.setText("");
            jTextFieldPesqOp.setEnabled(!true);
            jFormattedTextPesqData.setText("");
            jLabelFoto.setIcon(null);
            jFormattedTextPesqData.setEnabled(!true);
            jCheckBox1.setSelected(!true);
            jCheckBox1.setEnabled(true);
            jTextFieldCirur.setEnabled(true);
            jTextFieldEster.setEnabled(true);
            jTextFieldForn.setEnabled(true);
            jTextFieldItem.setEnabled(true);
            jTextFieldLote.setEnabled(true);
            jTextFieldPac.setEnabled(true);
            jTextFieldQtd.setEnabled(true);
            jFormattedTextProced.setEnabled(true);
            jFormattedTextProcess.setEnabled(true);
            jComboBoxResult.setEnabled(true);
            jFormattedTextValid.setEnabled(true);
            jTextFieldOp.setText(Sessão.getLogado());
            if (Tabela.getRowCount() == 0) {
                jButtonConcluir.setEnabled(!true);
                jButtonLimCamp.setEnabled(!true);
                jButtonLimTab.setEnabled(!true);
                jButtonBuscar.setEnabled(!true);
                jTextFieldItem.requestFocus();
            }
            jButtonExcluir.setEnabled(!true);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonLimTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimTabActionPerformed
        limparTab();
    }//GEN-LAST:event_jButtonLimTabActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        if (!jTextFieldItem.getText().isEmpty()) {
            buscar = jTextFieldItem.getText().intern().trim();
        }
        if (!jTextFieldQtd.getText().equals("")) {
            buscar = jTextFieldQtd.getText().intern().trim();
        }
        if (!jTextFieldForn.getText().isEmpty()) {
            buscar = jTextFieldForn.getText().intern().trim();
        }
        if (!jTextFieldEster.getText().isEmpty()) {
            buscar = jTextFieldEster.getText().intern().trim();
        }
        if (!jTextFieldCirur.getText().isEmpty()) {
            buscar = jTextFieldCirur.getText().intern().trim();
        }
        if (!jTextFieldPac.getText().isEmpty()) {
            buscar = jTextFieldPac.getText().intern().trim();
        }
        if (!jFormattedTextProced.getText().equalsIgnoreCase("  /  /    ")) {
            buscar = jFormattedTextProced.getText().intern().trim();
        }
        if (!jTextFieldLote.getText().isEmpty()) {
            buscar = jTextFieldLote.getText().intern().trim();
        }
        if (!jComboBoxResult.getSelectedItem().equals(" ")) {
            buscar = (String) jComboBoxResult.getSelectedItem();
        }
        if (!jFormattedTextProcess.getText().equalsIgnoreCase("  /  /    ")) {
            buscar = jFormattedTextProcess.getText().intern().trim();
        }
        if (!jFormattedTextValid.getText().equalsIgnoreCase("  /  /    ")) {
            buscar = jFormattedTextValid.getText().intern().trim();
        }
        if (jCheckBox1.isSelected()){
            if (!jTextFieldPesqOp.getText().isEmpty()) {
                buscar = jTextFieldPesqOp.getText().intern().trim();
            }
            if (!jFormattedTextPesqData.getText().equalsIgnoreCase("  /  /    ")) {
                String validar = jFormattedTextPesqData.getText();
                dataMaiorQueHoje(validar);
                if (dataMaiorQueHoje(validar)) {
                    JOptionPane.showMessageDialog(rootPane, "Data maior que a data de hoje!");
                    jFormattedTextPesqData.setText("");
                    jFormattedTextPesqData.requestFocus();
                } else {
                    buscar = jFormattedTextPesqData.getText().intern().trim();
                }
            }
            if (!jTextFieldPesqCód.getText().isEmpty()) {
                buscar = jTextFieldPesqCód.getText().intern().trim();
            }
        }
        
        buscarMov(buscar);
        if (tot != 0) {
            for (int i = 0; i < tot; i++) {
                Object[] dados = {lista.get(i).getDescricao(), lista.get(i).getQtd(), lista.get(i).getFornecedor(), lista.get(i).getEsterilizador(),
                 lista.get(i).getCirurgia(), lista.get(i).getPaciente(), lista.get(i).getProcedimento(), lista.get(i).getNumlote(), lista.get(i).getTeste(),
                  lista.get(i).getProcessamento(), lista.get(i).getValidade(), lista.get(i).getOperador(), lista.get(i).getData(), lista.get(i).getCodigo(),
                   lista.get(i).getAnexo()};
                Tabela.addRow(dados);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma correspondencia encontrada.");
            limparCampos();
            jTextFieldItem.requestFocus();
        }
        /*} catch(Exception e){
            
            
        }*/
        
        
        
        /*
         moviment.setFornecedor((String) jTable.getValueAt(i, 2));
            moviment.setEsterilizador((String) jTable.getValueAt(i, 3));
            moviment.setCirurgia((String) jTable.getValueAt(i, 4));
            moviment.setPaciente((String) jTable.getValueAt(i, 5));
            moviment.setProcedimento((String) jTable.getValueAt(i, 6));
            moviment.setNumlote((String) jTable.getValueAt(i, 7));
            moviment.setTeste((String) jTable.getValueAt(i, 8));
            moviment.setProcessamento((String) jTable.getValueAt(i, 9));
            moviment.setValidade((String) jTable.getValueAt(i, 10));
            moviment.setOperador((String) jTable.getValueAt(i, 11));
            moviment.setData((String) jTable.getValueAt(i, 12));
            moviment.setCodigo((Long) jTable.getValueAt(i, 13));
            moviment.setAnexo((byte[]) jTable.getValueAt(i, 14));
        */
        
        
        
        /*if (model.getDesc() != null && model.getFornec() != null) {
            jTextFieldItem.setText(model.getDesc().trim());
            jTextFieldForn.setText(model.getFornec().trim());
            jTextFieldEster.setText(model.getEsteri().trim());
            jTextFieldLote.setText(model.getNumlote());
            jTextFieldCirur.setText(model.getCirurg().trim());
            jTextFieldPac.setText(model.getPac().trim());
            jFormattedTextProced.setText(model.getProced().trim());
            jFormattedTextProcess.setText(model.getProcess().trim());
            jFormattedTextValid.setText(model.getValid());
            jComboBoxResult.setSelectedItem(model.getTeste().trim());
            jTextFieldPesqOp.setText(model.getOp().trim());
            jFormattedTextPesqData.setText(model.getData().trim());
            jTextFieldQtd.setText(String.valueOf(model.getQtd()));
            InputStream input = new ByteArrayInputStream(model.getAnexo());
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
            q = model.getR();
            for (int i = 0; i < q; i++) {
                /*moviment.setDir("prox");
                moviment.setSql(i + 1);
                model = mov.BuscarEster(moviment);
                DefaultTableModel Tabela1 = (DefaultTableModel) jTable.getModel();
                Object[] dados = {model.getDesc().trim(), model.getQtd(), model.getFornec().trim(),
                model.getEsteri().trim(), model.getCirurg().trim(), model.getPac().trim(),
                model.getProced().trim(), model.getNumlote(), model.getTeste().trim(),
                model.getProcess().trim(), model.getValid().trim(), model.getOp().trim(),
                model.getData().trim(), model.getCodigo().intern().trim(), model.getAnexo()};
                Tabela1.addRow(dados);
            }
            moviment.setDir("fim");
            moviment.setCodigo(null);
            moviment.setDesc(null);
            moviment.setStatus(null);
            moviment.setFornec(null);
            moviment.setEsteri(null);
            moviment.setCirurg(null);
            moviment.setPac(null);
            moviment.setProcess(null);
            moviment.setValid(null);
            moviment.setProced(null);
            moviment.setQtd(0);
            moviment.setData(null);
            moviment.setOp(null);
            moviment.setNumlote(null);
            moviment.setTeste(null);
            moviment.setAnexo(null);
            jButtonLimTab.setEnabled(true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
            jButtonBuscar.setEnabled(!true);
            jCheckBox1.setSelected(!true);
            jTextFieldPesqOp.setEnabled(!true);
            jFormattedTextPesqData.setEnabled(!true);
            jTextFieldPesqCód.setEnabled(!true);
            jTextFieldCirur.setEnabled(!true);
            jTextFieldEster.setEnabled(!true);
            jTextFieldForn.setEnabled(!true);
            jTextFieldItem.setEnabled(!true);
            jTextFieldLote.setEnabled(!true);
            jTextFieldPac.setEnabled(!true);
            jTextFieldQtd.setEnabled(!true);
            jFormattedTextProced.setEnabled(!true);
            jFormattedTextProcess.setEnabled(!true);
            jComboBoxResult.setEnabled(!true);
            jFormattedTextValid.setEnabled(!true);
            jTextFieldPesqOp.setEnabled(!true);
        }
        else if (model.getStatus() == "Erro") {
            jButtonConcluir.setEnabled(!true);
            jButtonExcluir.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonBuscar.setEnabled(!true);
            jButtonLimTab.setEnabled(!true);
            jButtonLimCamp.setEnabled(!true);
            jButtonCam.setEnabled(!true);
            jCheckBox1.setSelected(!true);
            jTextFieldCirur.setText("");
            jTextFieldEster.setText("");
            jTextFieldForn.setText("");
            jTextFieldItem.setText("");
            jTextFieldLote.setText("");
            jTextFieldPac.setText("");
            jTextFieldQtd.setText("");
            jFormattedTextProced.setValue(null);
            jFormattedTextProcess.setValue(null);
            jComboBoxResult.setSelectedIndex(0);
            jFormattedTextValid.setValue(null);
            jTextFieldPesqOp.setText("");
            jFormattedTextPesqData.setValue(null);
            jTextFieldPesqCód.setText("");
            jLabelFoto.setIcon(null);
            jTextFieldCirur.setEnabled(true);
            jTextFieldEster.setEnabled(true);
            jTextFieldForn.setEnabled(true);
            jTextFieldItem.setEnabled(true);
            jTextFieldLote.setEnabled(true);
            jTextFieldPac.setEnabled(true);
            jTextFieldQtd.setEnabled(true);
            jFormattedTextProced.setEnabled(true);
            jFormattedTextProcess.setEnabled(true);
            jComboBoxResult.setEnabled(true);
            jFormattedTextValid.setEnabled(true);
            jTextFieldPesqOp.setEnabled(!true);
            jFormattedTextPesqData.setEnabled(!true);
            jTextFieldPesqCód.setEnabled(!true);
            jTextFieldItem.requestFocus();
        }*/
        jTextFieldPesqOp.setText("");
        jFormattedTextPesqData.setText("");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

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

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jTextFieldPesqOp.setEnabled(true);
            jFormattedTextPesqData.setEnabled(true);
            jTextFieldPesqCód.setEnabled(true);
        }else{
            jTextFieldPesqOp.setText("");
            jTextFieldPesqOp.setEnabled(!true);
            jFormattedTextPesqData.setText("");
            jFormattedTextPesqData.setEnabled(!true);
            jTextFieldPesqCód.setText("");
            jTextFieldPesqCód.setEnabled(!true);
            jButtonBuscar.setEnabled(!true);
            jButtonLimCamp.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int i = jTable.getSelectedRow();
        jTextFieldItem.setText((String) jTable.getValueAt(i, 0));
        jTextFieldQtd.setText(String.valueOf(jTable.getValueAt(i, 1)));
        jTextFieldForn.setText((String) jTable.getValueAt(i, 2));
        jTextFieldEster.setText((String) jTable.getValueAt(i, 3));
        jTextFieldLote.setText((String) jTable.getValueAt(i, 7));
        jTextFieldCirur.setText((String) jTable.getValueAt(i, 4));
        jTextFieldPac.setText((String) jTable.getValueAt(i, 5));
        jFormattedTextProced.setText((String) jTable.getValueAt(i, 6));
        jFormattedTextProcess.setText((String) jTable.getValueAt(i, 9));
        jFormattedTextValid.setText((String) jTable.getValueAt(i, 10));
        jComboBoxResult.setSelectedItem((String) jTable.getValueAt(i, 8));
        jTextFieldPesqOp.setText((String) jTable.getValueAt(i, 11));
        jFormattedTextPesqData.setText((String) jTable.getValueAt(i, 12));
        jTextFieldPesqCód.setText(String.valueOf(jTable.getValueAt(i, 13)));
        InputStream input = new ByteArrayInputStream((byte[]) jTable.getValueAt(i, 14));
        if (jTextFieldItem.isEnabled()) {
            jButtonExcluir.setEnabled(true);
        } else {
            jButtonExcluir.setEnabled(!true);
        }
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
    }//GEN-LAST:event_jTableMouseClicked

    private void jTextFieldItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldItemKeyTyped
        if (jTextFieldForn.getText().equals("") && jTextFieldEster.getText().equals("") && jTextFieldLote.getText().equals("")
            && jFormattedTextProcess.getText().equals("  /  /    ") && jFormattedTextValid.getText().equals("  /  /    ")
            && jComboBoxResult.getSelectedItem().equals(" ") && jTextFieldCirur.getText().equals("") && jTextFieldPac.getText().equals("")
            && jFormattedTextProced.getText().equals("  /  /    ") && jTextFieldPesqCód.getText().equals("")
            && jTextFieldPesqOp.getText().isEmpty()) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldItem.getText().length() > (x + 1)){
            jButtonBuscar.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            x = 2;
        } else if (jTextFieldItem.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldItem.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldItem.getText().length() - 1) <= 0 && (b  == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldItemKeyTyped

    private void jTextFieldEsterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEsterKeyTyped
        if (jTextFieldItem.getText().equals("") && jTextFieldForn.getText().equals("") && jTextFieldPesqCód.getText().equals("")
            && jTextFieldPesqOp.getText().isEmpty() && jTextFieldLote.getText().equals("") && jFormattedTextProcess.getText().equals("  /  /    ")
            && jFormattedTextValid.getText().equals("  /  /    ") && jComboBoxResult.getSelectedItem().equals(" ") 
            && jTextFieldCirur.getText().equals("") && jTextFieldPac.getText().equals("") && jFormattedTextProced.getText().equals("  /  /    ")) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldEster.getText().length() > (x + 1)){
            jButtonBuscar.setEnabled(true);
            x = 2;
        } else if (jTextFieldEster.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldEster.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldEster.getText().length() - 1) <= 0 && (b == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldEsterKeyTyped

    private void jTextFieldLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoteKeyTyped
        if (jTextFieldItem.getText().equals("") && jTextFieldForn.getText().equals("") && jTextFieldEster.getText().equals("") 
            && jTextFieldPesqCód.getText().equals("") && jTextFieldPesqOp.getText().isEmpty() && jFormattedTextProcess.getText().equals("  /  /    ")
            && jFormattedTextValid.getText().equals("  /  /    ") && jComboBoxResult.getSelectedItem().equals(" ")
            && jTextFieldCirur.getText().equals("") && jTextFieldPac.getText().equals("") && jFormattedTextProced.getText().equals("  /  /    ")) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldLote.getText().length() > 0){
            jButtonBuscar.setEnabled(true);
            x = 2;
        } else if (jTextFieldLote.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldLote.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldLote.getText().length() - 1) <= 0 && (b  == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldLoteKeyTyped

    private void jTextFieldFornKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFornKeyTyped
        if (jTextFieldItem.getText().equals("") && jTextFieldPesqCód.getText().equals("") && jTextFieldPesqOp.getText().isEmpty()
            && jTextFieldEster.getText().equals("") && jTextFieldLote.getText().equals("") && jFormattedTextProcess.getText().equals("  /  /    ")
            && jFormattedTextValid.getText().equals("  /  /    ") && jComboBoxResult.getSelectedItem().equals(" ")
            && jTextFieldCirur.getText().equals("") && jTextFieldPac.getText().equals("") && jFormattedTextProced.getText().equals("  /  /    ")) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldForn.getText().length() > (x + 1)){
            jButtonBuscar.setEnabled(true);
            x = 2;
        } else if (jTextFieldForn.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldForn.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldForn.getText().length() - 1) <= 0 && (b  == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldFornKeyTyped

    private void jTextFieldCirurKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCirurKeyTyped
        if (jTextFieldItem.getText().equals("") && jTextFieldForn.getText().equals("") && jTextFieldEster.getText().equals("")
            && jTextFieldLote.getText().equals("") && jFormattedTextProcess.getText().equals("  /  /    ")
            && jFormattedTextValid.getText().equals("  /  /    ") && jComboBoxResult.getSelectedItem().equals(" ")
            && jTextFieldPesqCód.getText().equals("") && jTextFieldPesqOp.getText().isEmpty() && jTextFieldPac.getText().equals("")
            && jFormattedTextProced.getText().equals("  /  /    ")) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldCirur.getText().length() > (x + 1)){
            jButtonBuscar.setEnabled(true);
            x = 2;
        } else if (jTextFieldCirur.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldCirur.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldCirur.getText().length() - 1) <= 0 && (b  == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldCirurKeyTyped

    private void jTextFieldPacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPacKeyTyped
        if (jTextFieldItem.getText().equals("") && jTextFieldForn.getText().equals("") && jTextFieldEster.getText().equals("")
            && jTextFieldLote.getText().equals("") && jFormattedTextProcess.getText().equals("  /  /    ")
            && jFormattedTextValid.getText().equals("  /  /    ") && jComboBoxResult.getSelectedItem().equals(" ")
            && jTextFieldCirur.getText().equals("") && jTextFieldPesqCód.getText().equals("") && jTextFieldPesqOp.getText().isEmpty()
            && jFormattedTextProced.getText().equals("  /  /    ")) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldPac.getText().length() > (x + 1)){
            jButtonBuscar.setEnabled(true);
            x = 2;
        } else if (jTextFieldPac.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldPac.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldPac.getText().length() - 1) <= 0 && (b  == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldPacKeyTyped

    private void jFormattedTextProcedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextProcedKeyTyped
        if (!jFormattedTextProced.getText().contains("  ")) {
            jButtonBuscar.setEnabled(true);
        } else {
            jButtonBuscar.setEnabled(!true);
        }
        jButtonLimCamp.setEnabled(true);
    }//GEN-LAST:event_jFormattedTextProcedKeyTyped

    private void jFormattedTextValidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextValidKeyTyped
        if (!jFormattedTextValid.getText().contains("  ")) {
            jButtonBuscar.setEnabled(true);
        } else {
            jButtonBuscar.setEnabled(!true);
        }
        jButtonLimCamp.setEnabled(true);
    }//GEN-LAST:event_jFormattedTextValidKeyTyped

    private void jTextFieldPesqOpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesqOpKeyTyped
        if (jTextFieldItem.getText().equals("") && jTextFieldForn.getText().equals("") && jTextFieldEster.getText().equals("")
            && jTextFieldLote.getText().equals("") && jFormattedTextProcess.getText().equals("  /  /    ")
            && jFormattedTextValid.getText().equals("  /  /    ") && jComboBoxResult.getSelectedItem().equals(" ")
            && jTextFieldCirur.getText().equals("") && jTextFieldPac.getText().equals("") && jFormattedTextProced.getText().equals("  /  /    ")
            && jTextFieldPesqCód.getText().isEmpty()) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldPesqOp.getText().length() > (x + 1)){
            jButtonBuscar.setEnabled(true);
            x = 2;
        } else if (jTextFieldPesqOp.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldPesqOp.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldPesqOp.getText().length() - 1) <= 0 && (b  == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldPesqOpKeyTyped

    private void jFormattedTextPesqDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextPesqDataKeyTyped
        if (!jFormattedTextPesqData.getText().contains("  ")) {
            jButtonBuscar.setEnabled(true);
        } else {
            jButtonBuscar.setEnabled(!true);
        }
        jButtonLimCamp.setEnabled(true);
    }//GEN-LAST:event_jFormattedTextPesqDataKeyTyped

    private void jTextFieldLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoteActionPerformed
        if (jComboBoxResult.getSelectedIndex() == 0) {
            jComboBoxResult.requestFocus();
        } else {
            jFormattedTextProcess.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldLoteActionPerformed

    private void jTextFieldFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFornActionPerformed
        jTextFieldCirur.requestFocus();
        jTextFieldCirur.selectAll();
    }//GEN-LAST:event_jTextFieldFornActionPerformed

    private void jTextFieldCirurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCirurActionPerformed
        jTextFieldPac.requestFocus();
        jTextFieldPac.selectAll();
    }//GEN-LAST:event_jTextFieldCirurActionPerformed

    private void jTextFieldPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPacActionPerformed
        jFormattedTextProced.requestFocus();
    }//GEN-LAST:event_jTextFieldPacActionPerformed

    private void jFormattedTextProcedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextProcedActionPerformed
        jButtonBuscar.setEnabled(true);
        jButtonLimCamp.setEnabled(true);
        String validar = jFormattedTextProced.getText();
        String vencim = jFormattedTextValid.getText();
        data(validar);
        if (data(validar) == !true){
            JOptionPane.showMessageDialog(rootPane, "Formato de data incorreto!");
            jFormattedTextProced.setValue(null);
            jFormattedTextProced.requestFocus();
        } else if (dataMenorQueHoje(validar)) {
            JOptionPane.showMessageDialog(rootPane, "Data menor que a data de hoje!");
            jFormattedTextProced.setValue(null);
            jFormattedTextProced.requestFocus();
        } else if (dataMaiorQueValidade(validar, vencim)){
            JOptionPane.showMessageDialog(rootPane, "Data do procedimento maior que a data de validade!");
            jFormattedTextProced.setValue(null);
            jFormattedTextProced.requestFocus();
        } else {
            jButtonCam.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextProcedActionPerformed

    private void jTextFieldItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemActionPerformed
        jTextFieldQtd.requestFocus();
    }//GEN-LAST:event_jTextFieldItemActionPerformed

    private void jTextFieldEsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEsterActionPerformed
        jTextFieldLote.requestFocus();
        jTextFieldLote.selectAll();
    }//GEN-LAST:event_jTextFieldEsterActionPerformed

    private void jFormattedTextProcessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextProcessKeyTyped
        if (!jFormattedTextProcess.getText().contains("  ")) {
            jButtonBuscar.setEnabled(true);
        } else {
            jButtonBuscar.setEnabled(!true);
        }
        jButtonLimCamp.setEnabled(true);
    }//GEN-LAST:event_jFormattedTextProcessKeyTyped

    private void jButtonLimCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimCampActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonLimCampActionPerformed

    private void jTableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTableComponentAdded
        jButtonLimTab.setEnabled(true);
    }//GEN-LAST:event_jTableComponentAdded

    private void jFormattedTextProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextProcessActionPerformed
        jButtonBuscar.setEnabled(true);
        jButtonLimCamp.setEnabled(true);
        String validar = jFormattedTextProcess.getText();
        data(validar);
        dataMaiorQueHoje(validar);
        if (data(validar) != true){
            JOptionPane.showMessageDialog(rootPane, "Formato de data incorreto!");
            jFormattedTextProcess.setValue(null);
            jFormattedTextProcess.requestFocus();
        } else if (dataMaiorQueHoje(validar)) {
            JOptionPane.showMessageDialog(rootPane, "Data maior que a data de hoje!");
            jFormattedTextProcess.setValue(null);
            jFormattedTextProcess.requestFocus();
        } else {
            jFormattedTextValid.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextProcessActionPerformed

    private void jFormattedTextValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextValidActionPerformed
        jButtonBuscar.setEnabled(true);
        jButtonLimCamp.setEnabled(true);
        String validar = jFormattedTextValid.getText();
        data(validar);
        if (data(validar) == !true){
            JOptionPane.showMessageDialog(rootPane, "Formato de data incorreto!");
            jFormattedTextValid.setValue(null);
            jFormattedTextValid.requestFocus();
        } else if (dataMenorQueHoje(validar)) {
            JOptionPane.showMessageDialog(rootPane, "Esterilização vencida!");
            jFormattedTextValid.setValue(null);
            jFormattedTextValid.requestFocus();
        } else {
            jTextFieldForn.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextValidActionPerformed

    private void jButtonAnexarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnexarActionPerformed
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(WebCam.getImage(), "jpg", baos);
            bytes = baos.toByteArray();
            
            ByteArrayInputStream is = new ByteArrayInputStream(bytes);
            BufferedImage imagem = ImageIO.read(is);
            
            int NovaLargura = 187, NovaAltura = 140;
            foto = new BufferedImage(NovaLargura, NovaAltura, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = foto.createGraphics();
            g.drawImage(imagem, 0, 0, NovaLargura, NovaAltura, null);
            new Thread(){
                @Override
                public void run(){
                    WebCam.close();
                    exec = !true;
                }
            }.start();
            jLabelFoto.setIcon(new ImageIcon(foto));
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        jButtonAnexar.setEnabled(!true);
        jButtonIncluir.requestFocus();
    }//GEN-LAST:event_jButtonAnexarActionPerformed

    private void jButtonCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCamActionPerformed
        new Thread(){
            @Override
            public void run(){
                exec = true;
                WebCam.open();
                Vídeo();
            }
        }.start();
        jButtonAnexar.setEnabled(true);
        jButtonCam.setEnabled(!true);
        jButtonAnexar.requestFocus();
    }//GEN-LAST:event_jButtonCamActionPerformed

    private void jTextFieldQtdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQtdKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
        jButtonBuscar.setEnabled(true);
        jButtonLimCamp.setEnabled(true);
    }//GEN-LAST:event_jTextFieldQtdKeyTyped

    private void jTextFieldQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdActionPerformed
        jTextFieldEster.requestFocus();
        jTextFieldEster.selectAll();
    }//GEN-LAST:event_jTextFieldQtdActionPerformed

    private void jTextFieldFornFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFornFocusGained
        jTextFieldForn.selectAll();
        jTable.clearSelection();
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jTextFieldFornFocusGained

    private void jTextFieldCirurFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCirurFocusGained
        jTextFieldCirur.selectAll();
        jTable.clearSelection();
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jTextFieldCirurFocusGained

    private void jTextFieldPacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPacFocusGained
        jTextFieldPac.selectAll();
        jTable.clearSelection();
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jTextFieldPacFocusGained

    private void jTextFieldItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldItemFocusGained
        jTextFieldItem.selectAll();
        jTable.clearSelection();
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jTextFieldItemFocusGained

    private void jTextFieldQtdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQtdFocusGained
        jTextFieldQtd.selectAll();
        jTable.clearSelection();
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jTextFieldQtdFocusGained

    private void jTextFieldEsterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEsterFocusGained
        jTextFieldEster.selectAll();
        jTable.clearSelection();
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jTextFieldEsterFocusGained

    private void jTextFieldLoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLoteFocusGained
        jTextFieldLote.selectAll();
        jTable.clearSelection();
        jButtonExcluir.setEnabled(!true);
    }//GEN-LAST:event_jTextFieldLoteFocusGained

    private void jTextFieldPesqOpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesqOpFocusLost
        String a = jTextFieldPesqOp.getText();
        if (a.isEmpty()) {
            jButtonBuscar.setEnabled(!true);
            jButtonLimCamp.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldPesqOpFocusLost

    private void jFormattedTextPesqDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextPesqDataFocusLost
        String a = jFormattedTextPesqData.getText();
        if (a.equalsIgnoreCase("  /  /    ")) {
            jButtonBuscar.setEnabled(!true);
            jButtonLimCamp.setEnabled(!true);
        }
    }//GEN-LAST:event_jFormattedTextPesqDataFocusLost

    private void jTextFieldPesqCódFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesqCódFocusLost
        String a = jTextFieldPesqCód.getText();
        if (a.isEmpty()) {
            jButtonBuscar.setEnabled(!true);
            jButtonLimCamp.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldPesqCódFocusLost

    private void jTextFieldPesqCódKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesqCódKeyTyped
        if (jTextFieldItem.getText().equals("") && jTextFieldForn.getText().equals("") && jTextFieldEster.getText().equals("")
            && jTextFieldLote.getText().equals("") && jFormattedTextProcess.getText().equals("  /  /    ")
            && jFormattedTextValid.getText().equals("  /  /    ") && jComboBoxResult.getSelectedItem().equals(" ")
            && jTextFieldCirur.getText().equals("") && jTextFieldPac.getText().equals("") && jFormattedTextProced.getText().equals("  /  /    ")
            && jTextFieldPesqOp.getText().isEmpty()) {
            b = 0;
        } else {
        b = 1;
        }
        if (jTextFieldPesqCód.getText().length() > (x + 1)){
            jButtonBuscar.setEnabled(true);
            x = 2;
        } else if (jTextFieldPesqCód.getText().length() < (x + 1)){
            jButtonBuscar.setEnabled(!true);
            x = 0;
        }
        if (jTextFieldPesqCód.getText().length() > 0 && (b == 0)) {
            jButtonLimCamp.setEnabled(true);
            jButtonIncluir.setEnabled(true);
            jButtonCam.setEnabled(true);
        } else if ((jTextFieldPesqCód.getText().length() - 1) <= 0 && (b  == 0)){
            jButtonLimCamp.setEnabled(!true);
            jButtonIncluir.setEnabled(!true);
            jButtonCam.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldPesqCódKeyTyped

    private void jComboBoxResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxResultActionPerformed
        jButtonBuscar.setEnabled(true);
        jButtonLimCamp.setEnabled(true);
    }//GEN-LAST:event_jComboBoxResultActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceberEsteril.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            ReceberEsteril dialog = new ReceberEsteril(esteril, true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnexar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCam;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimCamp;
    private javax.swing.JButton jButtonLimTab;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBoxResult;
    private javax.swing.JFormattedTextField jFormattedTextPesqData;
    private javax.swing.JFormattedTextField jFormattedTextProced;
    private javax.swing.JFormattedTextField jFormattedTextProcess;
    private javax.swing.JFormattedTextField jFormattedTextValid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabelTítulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldCirur;
    private javax.swing.JTextField jTextFieldEster;
    private javax.swing.JTextField jTextFieldForn;
    private javax.swing.JTextField jTextFieldItem;
    private javax.swing.JTextField jTextFieldLote;
    private javax.swing.JTextField jTextFieldOp;
    private javax.swing.JTextField jTextFieldPac;
    private javax.swing.JTextField jTextFieldPesqCód;
    private javax.swing.JTextField jTextFieldPesqOp;
    private javax.swing.JTextField jTextFieldQtd;
    // End of variables declaration//GEN-END:variables

}
