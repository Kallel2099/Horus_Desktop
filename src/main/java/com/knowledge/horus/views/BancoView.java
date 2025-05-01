package com.knowledge.horus.views;

import javax.swing.JOptionPane;
import com.knowledge.horus.controls.BancoDAO;
import com.knowledge.horus.controls.ComboBoxDAO;
import com.knowledge.horus.controls.ManipularImagem;
import com.knowledge.horus.models.Banco;
import com.knowledge.horus.models.ComboBox;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class BancoView extends javax.swing.JDialog {

    BufferedImage imagem;
    Image imagem1;
    int e = 0;
    public static NovaEspec espec;
    public static NovoItem itens;
    public static NovoTipo tipo;
    public static MenuGerenciar banco;
    Banco instru = new Banco();
    List<Banco> lista = null;
    int tot;
    int index;
    Long id;
    
    public BancoView(MenuGerenciar parent, boolean modal) {
        super (parent, modal);
        initComponents();
        buscarItem();
        buscarTipo();
        buscarEsp();
    }
    
    public void buscarItem(){
        List<ComboBox> combo = new ComboBoxDAO().findItem("Ítem");
        jComboBoxItem.removeAllItems();
        combo.forEach(d -> jComboBoxItem.addItem(d.getDescrição()));
    }
    
    public void buscarTipo(){
        List<ComboBox> combo = new ComboBoxDAO().findItem("Tipo");
        jComboBoxTipo.removeAllItems();
        combo.forEach(d -> jComboBoxTipo.addItem(d.getDescrição()));
    }
    
    public void buscarEsp(){
        List<ComboBox> combo = new ComboBoxDAO().findItem("Especialidade");
        jComboBoxEspecialidade.removeAllItems();
        combo.forEach(d -> jComboBoxEspecialidade.addItem(d.getDescrição()));
    }
    
    public void buscarInstru(String psq){
        if (psq.equalsIgnoreCase("")) {
            lista = new BancoDAO().findAll();
            tot = lista.size();
        } else {
            lista = new BancoDAO().findByDetalhes(psq);
            tot = lista.size();
        }
    }
    
    public void setarCampos(Banco instru){
        buscarItem();
        buscarTipo();
        buscarEsp();
        limparCampos();
        int n = jComboBoxItem.getItemCount();
        for (int i = 0; i < n; i++) {
            if (instru.getItem().trim().equals(jComboBoxItem.getItemAt(i).intern().trim())) {
                jComboBoxItem.setSelectedIndex(i);
            }
        }
        int o = jComboBoxTipo.getItemCount();
        for (int i = 0; i < o; i++) {
            if (instru.getTipo().trim().equals(jComboBoxTipo.getItemAt(i).intern().trim())) {
                jComboBoxTipo.setSelectedIndex(i);
            }
        }
        int p = jComboBoxEspecialidade.getItemCount();
        for (int i = 0; i < p; i++) {
            if (instru.getEspecialidade().trim().equals(jComboBoxEspecialidade.getItemAt(i).intern().trim())) {
                jComboBoxEspecialidade.setSelectedIndex(i);
            }
        }
        jTextFieldDescrição.setText(instru.getDescrição().trim());
        id = instru.getId();
        if (instru.getFormato().equalsIgnoreCase("")) {
            jComboBoxFormato.setSelectedItem(instru.getFormato().trim());
        }
        if (instru.getTamanho() != 0 && !instru.getUnidade1().equalsIgnoreCase("")) {
            jTextFieldTamanho.setText(Double.toString(instru.getTamanho()));
            jComboBoxTamanho.setSelectedItem(instru.getUnidade1().trim());
        }else{
            jComboBoxTamanho.setSelectedItem(" ");
        }
        if (instru.getLarguraa() != 0 && !instru.getUnidade2().equalsIgnoreCase("")) {
            jTextFieldLarguraA.setText(Double.toString(instru.getLarguraa()));
            jComboBoxLarguraA.setSelectedItem(instru.getUnidade2().trim());
        }else{
            jComboBoxLarguraA.setSelectedItem(" ");
        }
        if (instru.getLargurab() != 0 && !instru.getUnidade3().equalsIgnoreCase("")) {
            jTextFieldLarguraB.setText(Double.toString(instru.getLargurab()));
            jComboBoxLarguraB.setSelectedItem(instru.getUnidade3().trim());
        }else{
            jComboBoxLarguraB.setSelectedItem(" ");
        }
        if (instru.getComp() != 0 && !instru.getUnidade4().equalsIgnoreCase("")) {
            jTextFieldComp.setText(Double.toString(instru.getComp()));
            jComboBoxComp.setSelectedItem(instru.getUnidade4().trim());
        }else{
            jComboBoxComp.setSelectedItem(" ");
        }
        if(instru.getDiametro()!= 0 && !instru.getUnidade5().equalsIgnoreCase("")){
            jTextFieldDiametro.setText(Double.toString(instru.getDiametro()));
            jComboBoxDiametro.setSelectedItem(instru.getUnidade5().trim());
        }else{
            jComboBoxDiametro.setSelectedItem(" ");
        }
        if (!instru.getPonta().equalsIgnoreCase("")) {
            jComboBoxPonta.setSelectedItem(instru.getPonta().trim());
        }
        if (!instru.getOrientação().equalsIgnoreCase("")) {
            jComboBoxOrientação.setSelectedItem(instru.getOrientação().trim());
        }
        if (!instru.getAngulo().equalsIgnoreCase("")) {
            jComboBoxAngulo.setSelectedItem(instru.getAngulo().trim());
        }
        if (!instru.getNum().equalsIgnoreCase("")) {
            jComboBoxNum.setSelectedItem(instru.getNum().trim());
        }
        if (!instru.getSerrilha().equalsIgnoreCase("")) {
            jComboBoxSerrilha.setSelectedItem(instru.getSerrilha().trim());
        }
        if (!instru.getWidia().equalsIgnoreCase("")) {
            jComboBoxWidia.setSelectedItem(instru.getWidia().trim());
        }
        if (!instru.getDente().equalsIgnoreCase("")) {
            jComboBoxDente.setSelectedItem(instru.getDente().trim());
        }
        if (!instru.getTrava().equalsIgnoreCase("")) {
            jComboBoxTrava.setSelectedItem(instru.getTrava().trim());
        }
        if (!instru.getFuro().equalsIgnoreCase("")) {
            jComboBoxFuro.setSelectedItem(instru.getFuro().trim());
        }
        jTextFieldOutro1.setText(instru.getOutro1().trim());
        jTextFieldOutro2.setText(instru.getOutro2().trim());
        jTextFieldOutro3.setText(instru.getOutro3().trim());
        ManipularImagem.exibiImagemLabel(instru.getImagem(), jLabelImagem);
    }
    
    public void limparCampos(){
        buscarItem();
        buscarTipo();
        buscarEsp();
        jTextFieldTamanho.setText("");
        jTextFieldLarguraA.setText("");
        jTextFieldLarguraB.setText("");
        jTextFieldComp.setText("");
        jTextFieldDiametro.setText("");
        jTextFieldOutro1.setText("");
        jTextFieldOutro2.setText("");
        jTextFieldOutro3.setText("");
        jTextFieldDescrição.setText("");
        jTextFieldPesquisar.setText("");
        jLabelImagem.setIcon(null);
        jComboBoxFormato.setSelectedIndex(0);
        jComboBoxTamanho.setSelectedIndex(0);
        jComboBoxLarguraA.setSelectedIndex(0);
        jComboBoxLarguraB.setSelectedIndex(0);
        jComboBoxComp.setSelectedIndex(0);
        jComboBoxDiametro.setSelectedIndex(0);
        jComboBoxPonta.setSelectedIndex(0);
        jComboBoxOrientação.setSelectedIndex(0);
        jComboBoxAngulo.setSelectedIndex(0);
        jComboBoxNum.setSelectedIndex(0);
        jComboBoxSerrilha.setSelectedIndex(0);
        jComboBoxWidia.setSelectedIndex(0);
        jComboBoxDente.setSelectedIndex(0);
        jComboBoxTrava.setSelectedIndex(0);
        jComboBoxFuro.setSelectedIndex(0);
        jCheckBox001.setSelected(!true);
        jCheckBox002.setSelected(!true);
        jCheckBox003.setSelected(!true);
        jCheckBox004.setSelected(!true);
        jCheckBox005.setSelected(!true);
        jCheckBox006.setSelected(!true);
        jCheckBox007.setSelected(!true);
        jCheckBox008.setSelected(!true);
        jCheckBox009.setSelected(!true);
        jCheckBox010.setSelected(!true);
        jCheckBox011.setSelected(!true);
        jCheckBox012.setSelected(!true);
        jCheckBox013.setSelected(!true);
        jCheckBox014.setSelected(!true);
        jCheckBox015.setSelected(!true);
        jCheckBox016.setSelected(!true);
        jCheckBox017.setSelected(!true);
        jCheckBox018.setSelected(!true);
        jTextFieldTamanho.setEnabled(!true);
        jTextFieldLarguraA.setEnabled(!true);
        jTextFieldLarguraB.setEnabled(!true);
        jTextFieldComp.setEnabled(!true);
        jTextFieldDiametro.setEnabled(!true);
        jTextFieldOutro1.setEnabled(!true);
        jTextFieldOutro2.setEnabled(!true);
        jTextFieldOutro3.setEnabled(!true);
        jComboBoxFormato.setEnabled(!true);
        jComboBoxTamanho.setEnabled(!true);
        jComboBoxLarguraA.setEnabled(!true);
        jComboBoxLarguraB.setEnabled(!true);
        jComboBoxComp.setEnabled(!true);
        jComboBoxDiametro.setEnabled(!true);
        jComboBoxPonta.setEnabled(!true);
        jComboBoxOrientação.setEnabled(!true);
        jComboBoxAngulo.setEnabled(!true);
        jComboBoxNum.setEnabled(!true);
        jComboBoxSerrilha.setEnabled(!true);
        jComboBoxWidia.setEnabled(!true);
        jComboBoxDente.setEnabled(!true);
        jComboBoxTrava.setEnabled(!true);
        jComboBoxFuro.setEnabled(!true);
    }
    
    public void resetCampos(){
        jCheckBox001.setEnabled(!true);
        jCheckBox002.setEnabled(!true);
        jCheckBox003.setEnabled(!true);
        jCheckBox004.setEnabled(!true);
        jCheckBox005.setEnabled(!true);
        jCheckBox006.setEnabled(!true);
        jCheckBox007.setEnabled(!true);
        jCheckBox008.setEnabled(!true);
        jCheckBox009.setEnabled(!true);
        jCheckBox010.setEnabled(!true);
        jCheckBox011.setEnabled(!true);
        jCheckBox012.setEnabled(!true);
        jCheckBox013.setEnabled(!true);
        jCheckBox014.setEnabled(!true);
        jCheckBox015.setEnabled(!true);
        jCheckBox016.setEnabled(!true);
        jCheckBox017.setEnabled(!true);
        jCheckBox018.setEnabled(!true);
        jComboBoxItem.setEnabled(!true);
        jComboBoxTipo.setEnabled(!true);
        jComboBoxEspecialidade.setEnabled(!true);
        jButtonItem.setEnabled(!true);
        jButtonTipo.setEnabled(!true);
        jButtonEsp.setEnabled(!true);
        jTextFieldDescrição.setEnabled(!true);
        jButtonNovo.setEnabled(true);
        jButtonImagem.setEnabled(!true);
        jButtonLimpar.setEnabled(!true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(!true);
        jButtonCancelar.setEnabled(!true);
        jButtonSair.setEnabled(true);
        jTextFieldPesquisar.setEnabled(true);
        jButtonBuscar.setEnabled(true);
        jButtonPrimeiro.setEnabled(!true);
        jButtonAnterior.setEnabled(!true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxItem = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEspecialidade = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDescrição = new javax.swing.JTextField();
        jButtonItem = new javax.swing.JButton();
        jButtonTipo = new javax.swing.JButton();
        jButtonEsp = new javax.swing.JButton();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonPrimeiro = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();
        jButtonUltimo = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonImagem = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabelImagem = new javax.swing.JLabel();
        jPanelDetalhes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox001 = new javax.swing.JCheckBox();
        jTextFieldComp = new javax.swing.JTextField();
        jComboBoxFormato = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox002 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox003 = new javax.swing.JCheckBox();
        jComboBoxLarguraA = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox005 = new javax.swing.JCheckBox();
        jComboBoxComp = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox007 = new javax.swing.JCheckBox();
        jComboBoxPonta = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox011 = new javax.swing.JCheckBox();
        jComboBoxSerrilha = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox012 = new javax.swing.JCheckBox();
        jComboBoxWidia = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox004 = new javax.swing.JCheckBox();
        jComboBoxLarguraB = new javax.swing.JComboBox<>();
        jTextFieldOutro1 = new javax.swing.JTextField();
        jTextFieldLarguraA = new javax.swing.JTextField();
        jTextFieldLarguraB = new javax.swing.JTextField();
        jComboBoxTamanho = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox013 = new javax.swing.JCheckBox();
        jComboBoxDente = new javax.swing.JComboBox<>();
        jTextFieldDiametro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox006 = new javax.swing.JCheckBox();
        jComboBoxDiametro = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox016 = new javax.swing.JCheckBox();
        jComboBoxFuro = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox008 = new javax.swing.JCheckBox();
        jComboBoxOrientação = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox009 = new javax.swing.JCheckBox();
        jComboBoxAngulo = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox010 = new javax.swing.JCheckBox();
        jComboBoxNum = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jCheckBox014 = new javax.swing.JCheckBox();
        jComboBoxTrava = new javax.swing.JComboBox<>();
        jCheckBox015 = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldOutro2 = new javax.swing.JTextField();
        jCheckBox017 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldOutro3 = new javax.swing.JTextField();
        jCheckBox018 = new javax.swing.JCheckBox();
        jTextFieldTamanho = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Banco de Dados");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gerenciar Catálogo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("* Ítem:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 20));

        jComboBoxItem.setEnabled(false);
        getContentPane().add(jComboBoxItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 23));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("* Tipo:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, 20));

        jComboBoxTipo.setEnabled(false);
        jComboBoxTipo.setMaximumSize(new java.awt.Dimension(177, 25));
        jComboBoxTipo.setMinimumSize(new java.awt.Dimension(177, 25));
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(177, 25));
        getContentPane().add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, 23));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("* Especialidade:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 100, 20));

        jComboBoxEspecialidade.setEnabled(false);
        jComboBoxEspecialidade.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxEspecialidade.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxEspecialidade.setPreferredSize(new java.awt.Dimension(157, 25));
        getContentPane().add(jComboBoxEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 190, 23));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("* Descrição:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, 20));

        jTextFieldDescrição.setEnabled(false);
        jTextFieldDescrição.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldDescrição.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldDescrição.setPreferredSize(new java.awt.Dimension(6, 25));
        getContentPane().add(jTextFieldDescrição, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 300, 23));

        jButtonItem.setText("...");
        jButtonItem.setEnabled(false);
        jButtonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 30, 23));

        jButtonTipo.setText("...");
        jButtonTipo.setEnabled(false);
        jButtonTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 30, 23));

        jButtonEsp.setText("...");
        jButtonEsp.setEnabled(false);
        jButtonEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 30, 23));

        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 170, 23));

        jButtonBuscar.setText("Pesquisar");
        jButtonBuscar.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonBuscar.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 90, 23));

        jButtonPrimeiro.setText("|<");
        jButtonPrimeiro.setEnabled(false);
        jButtonPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimeiroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPrimeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 50, 23));

        jButtonAnterior.setText("<");
        jButtonAnterior.setEnabled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 50, 23));

        jButtonProximo.setText(">");
        jButtonProximo.setEnabled(false);
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 50, 23));

        jButtonUltimo.setText(">|");
        jButtonUltimo.setEnabled(false);
        jButtonUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 50, 23));

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 80, 23));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonLimpar.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonLimpar.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 80, 23));

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonEditar.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonEditar.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 80, 23));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonExcluir.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonExcluir.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 80, 23));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonSalvar.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonSalvar.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 80, 23));

        jButtonImagem.setText("Imagem");
        jButtonImagem.setEnabled(false);
        jButtonImagem.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonImagem.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonImagem.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImagemActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 80, 23));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 80, 23));

        jButtonSair.setText("Sair");
        jButtonSair.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonSair.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonSair.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 80, 23));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("* Imagem:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 20));

        jLabelImagem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem.setOpaque(true);
        getContentPane().add(jLabelImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 480, 310));

        jPanelDetalhes.setBackground(new java.awt.Color(204, 204, 204));
        jPanelDetalhes.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Detalhes");
        jPanelDetalhes.add(jLabel3);
        jLabel3.setBounds(0, 0, 250, 40);

        jCheckBox001.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox001.setEnabled(false);
        jCheckBox001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox001ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox001);
        jCheckBox001.setBounds(220, 40, 20, 19);

        jTextFieldComp.setEnabled(false);
        jTextFieldComp.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldComp.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldComp.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldComp);
        jTextFieldComp.setBounds(90, 160, 40, 23);

        jComboBoxFormato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Curva(o)", "Semi curva(o)", "Curva(o) forte", "Curvo(a) direito(a)", "Curvo(a) esquerdo(a)", "Reta(o)", "Angulado(a)", "Goivo(a)" }));
        jComboBoxFormato.setEnabled(false);
        jComboBoxFormato.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxFormato.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxFormato.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxFormato);
        jComboBoxFormato.setBounds(90, 40, 130, 23);

        jLabel7.setText("Tamanho:");
        jPanelDetalhes.add(jLabel7);
        jLabel7.setBounds(10, 70, 80, 20);

        jCheckBox002.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox002.setEnabled(false);
        jCheckBox002.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox002ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox002);
        jCheckBox002.setBounds(220, 70, 20, 19);

        jLabel8.setText("Altura :");
        jPanelDetalhes.add(jLabel8);
        jLabel8.setBounds(10, 100, 80, 20);

        jCheckBox003.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox003.setEnabled(false);
        jCheckBox003.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox003ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox003);
        jCheckBox003.setBounds(220, 100, 20, 19);

        jComboBoxLarguraA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxLarguraA.setEnabled(false);
        jComboBoxLarguraA.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraA.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraA.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxLarguraA);
        jComboBoxLarguraA.setBounds(150, 100, 70, 23);

        jLabel9.setText("Comprimento:");
        jPanelDetalhes.add(jLabel9);
        jLabel9.setBounds(10, 160, 80, 20);

        jCheckBox005.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox005.setEnabled(false);
        jCheckBox005.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox005ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox005);
        jCheckBox005.setBounds(220, 160, 20, 19);

        jComboBoxComp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxComp.setEnabled(false);
        jComboBoxComp.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxComp.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxComp.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxComp);
        jComboBoxComp.setBounds(150, 160, 70, 23);

        jLabel10.setText("Tipo de ponta:");
        jPanelDetalhes.add(jLabel10);
        jLabel10.setBounds(10, 220, 80, 20);

        jCheckBox007.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox007.setEnabled(false);
        jCheckBox007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox007ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox007);
        jCheckBox007.setBounds(220, 220, 20, 19);

        jComboBoxPonta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Agudo", "Rombo", "Rombo/Agudo" }));
        jComboBoxPonta.setEnabled(false);
        jComboBoxPonta.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxPonta.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxPonta.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxPonta);
        jComboBoxPonta.setBounds(90, 220, 130, 23);

        jLabel11.setText("Serrilha:");
        jPanelDetalhes.add(jLabel11);
        jLabel11.setBounds(10, 340, 80, 20);

        jCheckBox011.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox011.setEnabled(false);
        jCheckBox011.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox011ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox011);
        jCheckBox011.setBounds(220, 340, 20, 19);

        jComboBoxSerrilha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "C/ Serrilha", "S/ Serrilha" }));
        jComboBoxSerrilha.setEnabled(false);
        jComboBoxSerrilha.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxSerrilha.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxSerrilha.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxSerrilha);
        jComboBoxSerrilha.setBounds(90, 340, 130, 23);

        jLabel12.setText("Widia:");
        jPanelDetalhes.add(jLabel12);
        jLabel12.setBounds(10, 370, 80, 20);

        jCheckBox012.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox012.setEnabled(false);
        jCheckBox012.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox012ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox012);
        jCheckBox012.setBounds(220, 370, 20, 19);

        jComboBoxWidia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "C/ Widia", "S/ Widia" }));
        jComboBoxWidia.setEnabled(false);
        jComboBoxWidia.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxWidia.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxWidia.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxWidia);
        jComboBoxWidia.setBounds(90, 370, 130, 23);

        jLabel13.setText("Largura :");
        jPanelDetalhes.add(jLabel13);
        jLabel13.setBounds(10, 130, 80, 20);

        jCheckBox004.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox004.setEnabled(false);
        jCheckBox004.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox004ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox004);
        jCheckBox004.setBounds(220, 130, 20, 19);

        jComboBoxLarguraB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxLarguraB.setEnabled(false);
        jComboBoxLarguraB.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraB.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraB.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxLarguraB);
        jComboBoxLarguraB.setBounds(150, 130, 70, 23);

        jTextFieldOutro1.setEnabled(false);
        jTextFieldOutro1.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro1.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro1.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldOutro1);
        jTextFieldOutro1.setBounds(90, 490, 130, 23);

        jTextFieldLarguraA.setEnabled(false);
        jTextFieldLarguraA.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraA.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraA.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldLarguraA);
        jTextFieldLarguraA.setBounds(90, 100, 40, 23);

        jTextFieldLarguraB.setEnabled(false);
        jTextFieldLarguraB.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraB.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraB.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldLarguraB);
        jTextFieldLarguraB.setBounds(90, 130, 40, 23);

        jComboBoxTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxTamanho.setEnabled(false);
        jComboBoxTamanho.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxTamanho.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxTamanho.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxTamanho);
        jComboBoxTamanho.setBounds(150, 70, 70, 23);

        jLabel14.setText("Dente:");
        jPanelDetalhes.add(jLabel14);
        jLabel14.setBounds(10, 400, 80, 20);

        jCheckBox013.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox013.setEnabled(false);
        jCheckBox013.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox013ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox013);
        jCheckBox013.setBounds(220, 400, 20, 19);

        jComboBoxDente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "C/ Dente", "S/ Dente", "2 dentes", "3 dentes", "4 dentes", "5 dentes", "6 dentes" }));
        jComboBoxDente.setEnabled(false);
        jComboBoxDente.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxDente.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxDente.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxDente);
        jComboBoxDente.setBounds(90, 400, 130, 23);

        jTextFieldDiametro.setEnabled(false);
        jTextFieldDiametro.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldDiametro.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldDiametro.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldDiametro);
        jTextFieldDiametro.setBounds(90, 190, 40, 23);

        jLabel15.setText("Diâmetro:    Ø");
        jPanelDetalhes.add(jLabel15);
        jLabel15.setBounds(10, 190, 80, 20);

        jCheckBox006.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox006.setEnabled(false);
        jCheckBox006.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox006ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox006);
        jCheckBox006.setBounds(220, 190, 20, 19);

        jComboBoxDiametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxDiametro.setEnabled(false);
        jComboBoxDiametro.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxDiametro.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxDiametro.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxDiametro);
        jComboBoxDiametro.setBounds(150, 190, 70, 23);

        jLabel16.setText("Outro:");
        jPanelDetalhes.add(jLabel16);
        jLabel16.setBounds(10, 490, 80, 20);

        jCheckBox016.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox016.setEnabled(false);
        jCheckBox016.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox016ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox016);
        jCheckBox016.setBounds(220, 490, 20, 19);

        jComboBoxFuro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Perfurada", "Fenestrada", "Fenestrada / Perfurada" }));
        jComboBoxFuro.setEnabled(false);
        jComboBoxFuro.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxFuro.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxFuro.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxFuro);
        jComboBoxFuro.setBounds(90, 460, 130, 23);

        jLabel17.setText("Orientação:");
        jPanelDetalhes.add(jLabel17);
        jLabel17.setBounds(10, 250, 80, 20);

        jCheckBox008.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox008.setEnabled(false);
        jCheckBox008.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox008ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox008);
        jCheckBox008.setBounds(220, 250, 20, 19);

        jComboBoxOrientação.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Esquerda", "Direita", "Para cima", "Para baixo" }));
        jComboBoxOrientação.setEnabled(false);
        jComboBoxOrientação.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxOrientação.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxOrientação.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxOrientação);
        jComboBoxOrientação.setBounds(90, 250, 130, 23);

        jLabel18.setText("Angulo:");
        jPanelDetalhes.add(jLabel18);
        jLabel18.setBounds(10, 280, 80, 20);

        jCheckBox009.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox009.setEnabled(false);
        jCheckBox009.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox009ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox009);
        jCheckBox009.setBounds(220, 280, 20, 19);

        jComboBoxAngulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Acotovelado 90°", "Angulado 90°", "Angulado 45°", "25°", "30°", "45°", "60º", "90º", "130º", "Reto" }));
        jComboBoxAngulo.setEnabled(false);
        jComboBoxAngulo.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxAngulo.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxAngulo.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxAngulo);
        jComboBoxAngulo.setBounds(90, 280, 130, 23);

        jLabel19.setText("Numeração:");
        jPanelDetalhes.add(jLabel19);
        jLabel19.setBounds(10, 310, 80, 20);

        jCheckBox010.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox010.setEnabled(false);
        jCheckBox010.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox010ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox010);
        jCheckBox010.setBounds(220, 310, 20, 19);

        jComboBoxNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Virgem", "P", "M", "G", "Nº 1", "Nº 2", "Nº 3", "Nº 4", "Nº 5", "Nº 6", "Nº 7", "Nº 8", "Nº 9", "Nº 10", "Nº 11", "Nº 12", "Nº 13", "Nº 14", "Nº 15", "Nº 16", "Nº 17", "Nº 18", "Nº 19", "Nº 20 " }));
        jComboBoxNum.setEnabled(false);
        jComboBoxNum.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxNum.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxNum.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxNum);
        jComboBoxNum.setBounds(90, 310, 130, 23);

        jLabel20.setText("Trava:");
        jPanelDetalhes.add(jLabel20);
        jLabel20.setBounds(10, 430, 80, 20);

        jCheckBox014.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox014.setEnabled(false);
        jCheckBox014.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox014ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox014);
        jCheckBox014.setBounds(220, 430, 20, 19);

        jComboBoxTrava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "C/ Trava", "S/ Trava" }));
        jComboBoxTrava.setEnabled(false);
        jComboBoxTrava.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxTrava.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxTrava.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanelDetalhes.add(jComboBoxTrava);
        jComboBoxTrava.setBounds(90, 430, 130, 23);

        jCheckBox015.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox015.setEnabled(false);
        jCheckBox015.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox015ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox015);
        jCheckBox015.setBounds(220, 460, 20, 19);

        jLabel21.setText("Furo:");
        jPanelDetalhes.add(jLabel21);
        jLabel21.setBounds(10, 460, 80, 20);

        jTextFieldOutro2.setEnabled(false);
        jTextFieldOutro2.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro2.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro2.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldOutro2);
        jTextFieldOutro2.setBounds(90, 520, 130, 23);

        jCheckBox017.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox017.setEnabled(false);
        jCheckBox017.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox017ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox017);
        jCheckBox017.setBounds(220, 520, 20, 19);

        jLabel23.setText("Formato:");
        jPanelDetalhes.add(jLabel23);
        jLabel23.setBounds(10, 40, 80, 20);

        jLabel25.setText("Outro:");
        jPanelDetalhes.add(jLabel25);
        jLabel25.setBounds(10, 520, 80, 20);

        jLabel26.setText("Outro:");
        jPanelDetalhes.add(jLabel26);
        jLabel26.setBounds(10, 550, 100, 20);

        jTextFieldOutro3.setEnabled(false);
        jTextFieldOutro3.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro3.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro3.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldOutro3);
        jTextFieldOutro3.setBounds(90, 550, 130, 23);

        jCheckBox018.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox018.setEnabled(false);
        jCheckBox018.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox018ActionPerformed(evt);
            }
        });
        jPanelDetalhes.add(jCheckBox018);
        jCheckBox018.setBounds(220, 550, 20, 19);

        jTextFieldTamanho.setEnabled(false);
        jTextFieldTamanho.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldTamanho.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldTamanho.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanelDetalhes.add(jTextFieldTamanho);
        jTextFieldTamanho.setBounds(90, 70, 40, 23);

        getContentPane().add(jPanelDetalhes, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 250, 580));

        jTextFieldId.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldId.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldId.setEnabled(false);
        getContentPane().add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 40, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 600));

        setSize(new java.awt.Dimension(760, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagemActionPerformed
        JFileChooser fc = new JFileChooser("src\\main\\resources\\database");
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 480, 310);
                jLabelImagem.setIcon(new ImageIcon(imagem));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar a imagem.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado.");
        }
    }//GEN-LAST:event_jButtonImagemActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente sair?\n");
        if (sair == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jCheckBox001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox001ActionPerformed
        if (jCheckBox001.isSelected()) {
            jComboBoxFormato.setEnabled(true);
        }else{
            jComboBoxFormato.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox001ActionPerformed

    private void jButtonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemActionPerformed
        itens = new NovoItem(this, true);
        itens.setVisible(true);
    }//GEN-LAST:event_jButtonItemActionPerformed

    private void jButtonTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTipoActionPerformed
        tipo = new NovoTipo(this, true);
        tipo.setVisible(true);
    }//GEN-LAST:event_jButtonTipoActionPerformed

    private void jButtonEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspActionPerformed
        espec = new NovaEspec(this, true);
        espec.setVisible(true);
    }//GEN-LAST:event_jButtonEspActionPerformed

    private void jCheckBox009ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox009ActionPerformed
        if (jCheckBox009.isSelected()) {
            jComboBoxAngulo.setEnabled(true);
        }else{
            jComboBoxAngulo.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox009ActionPerformed

    private void jCheckBox018ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox018ActionPerformed
        if (jCheckBox018.isSelected()) {
            jTextFieldOutro3.setEnabled(true);
        }else{
            jTextFieldOutro3.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox018ActionPerformed

    private void jCheckBox002ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox002ActionPerformed
        if (jCheckBox002.isSelected()) {
            jComboBoxTamanho.setEnabled(true);
            jTextFieldTamanho.setEnabled(true);
        }else{
            jComboBoxTamanho.setEnabled(!true);
            jTextFieldTamanho.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox002ActionPerformed

    private void jCheckBox003ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox003ActionPerformed
        if (jCheckBox003.isSelected()) {
            jComboBoxLarguraA.setEnabled(true);
            jTextFieldLarguraA.setEnabled(true);
        }else{
            jComboBoxLarguraA.setEnabled(!true);
            jTextFieldLarguraA.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox003ActionPerformed

    private void jCheckBox004ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox004ActionPerformed
        if (jCheckBox004.isSelected()) {
            jComboBoxLarguraB.setEnabled(true);
            jTextFieldLarguraB.setEnabled(true);
        }else{
            jComboBoxLarguraB.setEnabled(!true);
            jTextFieldLarguraB.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox004ActionPerformed

    private void jCheckBox005ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox005ActionPerformed
        if (jCheckBox005.isSelected()) {
            jComboBoxComp.setEnabled(true);
            jTextFieldComp.setEnabled(true);
        }else{
            jComboBoxComp.setEnabled(!true);
            jTextFieldComp.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox005ActionPerformed

    private void jCheckBox006ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox006ActionPerformed
        if (jCheckBox006.isSelected()) {
            jComboBoxDiametro.setEnabled(true);
            jTextFieldDiametro.setEnabled(true);
        }else{
            jComboBoxDiametro.setEnabled(!true);
            jTextFieldDiametro.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox006ActionPerformed

    private void jCheckBox007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox007ActionPerformed
        if (jCheckBox007.isSelected()) {
            jComboBoxPonta.setEnabled(true);
        }else{
            jComboBoxPonta.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox007ActionPerformed

    private void jCheckBox008ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox008ActionPerformed
        if (jCheckBox008.isSelected()) {
            jComboBoxOrientação.setEnabled(true);
        }else{
            jComboBoxOrientação.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox008ActionPerformed

    private void jCheckBox010ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox010ActionPerformed
        if (jCheckBox010.isSelected()) {
            jComboBoxNum.setEnabled(true);
        }else{
            jComboBoxNum.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox010ActionPerformed

    private void jCheckBox011ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox011ActionPerformed
        if (jCheckBox011.isSelected()) {
            jComboBoxSerrilha.setEnabled(true);
        }else{
            jComboBoxSerrilha.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox011ActionPerformed

    private void jCheckBox012ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox012ActionPerformed
        if (jCheckBox012.isSelected()) {
            jComboBoxWidia.setEnabled(true);
        }else{
            jComboBoxWidia.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox012ActionPerformed

    private void jCheckBox013ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox013ActionPerformed
        if (jCheckBox013.isSelected()) {
            jComboBoxDente.setEnabled(true);
        }else{
            jComboBoxDente.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox013ActionPerformed

    private void jCheckBox014ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox014ActionPerformed
        if (jCheckBox014.isSelected()) {
            jComboBoxTrava.setEnabled(true);
        }else{
            jComboBoxTrava.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox014ActionPerformed

    private void jCheckBox015ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox015ActionPerformed
        if (jCheckBox015.isSelected()) {
            jComboBoxFuro.setEnabled(true);
        }else{
            jComboBoxFuro.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox015ActionPerformed

    private void jCheckBox016ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox016ActionPerformed
        if (jCheckBox016.isSelected()) {
            jTextFieldOutro1.setEnabled(true);
        }else{
            jTextFieldOutro1.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox016ActionPerformed

    private void jCheckBox017ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox017ActionPerformed
        if (jCheckBox017.isSelected()) {
            jTextFieldOutro2.setEnabled(true);
        }else{
            jTextFieldOutro2.setEnabled(!true);
        }
    }//GEN-LAST:event_jCheckBox017ActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jLabelImagem.getIcon() == null || jComboBoxItem.getSelectedIndex() == 0 ||
                jComboBoxEspecialidade.getSelectedIndex() == 0 || jComboBoxTipo.getSelectedIndex() == 0 ||
                jTextFieldDescrição.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(rootPane, "Os campos iniciados com * são obrigatórios!");
        } else {
            if (e == 1) {
                instru.setId(id);
            } else {
                instru.setId(null);
            }
            instru.setItem((String) jComboBoxItem.getSelectedItem());
            instru.setTipo((String) jComboBoxTipo.getSelectedItem());
            instru.setEspecialidade((String) jComboBoxEspecialidade.getSelectedItem());
            instru.setDescrição(jTextFieldDescrição.getText());
            instru.setFormato((String) jComboBoxFormato.getSelectedItem());
            if (!jTextFieldTamanho.getText().equalsIgnoreCase("") && jComboBoxTamanho.getSelectedItem() != " ") {
                double tam = Double.parseDouble(jTextFieldTamanho.getText());
                instru.setTamanho((double) tam);
                instru.setUnidade1((String) jComboBoxTamanho.getSelectedItem());
            } else {
                instru.setTamanho(0);
                instru.setUnidade1(" ");
            }
            if (!jTextFieldLarguraA.getText().equalsIgnoreCase("") && jComboBoxLarguraA.getSelectedItem() != " ") {
                double larga = Double.parseDouble(jTextFieldLarguraA.getText());
                instru.setLarguraa((double) larga);
                instru.setUnidade2((String) jComboBoxLarguraA.getSelectedItem());
            } else {
                instru.setLarguraa(0);
                instru.setUnidade2(" ");
            }
            if (!jTextFieldLarguraB.getText().equalsIgnoreCase("") && jComboBoxLarguraB.getSelectedItem() != " ") {
                double largb = Double.parseDouble(jTextFieldLarguraB.getText());
                instru.setLargurab((double) largb);
                instru.setUnidade3((String) jComboBoxLarguraB.getSelectedItem());
            } else {
                instru.setLargurab(0);
                instru.setUnidade3(" ");
            }
            if (!jTextFieldComp.getText().equalsIgnoreCase("") && jComboBoxComp.getSelectedItem() != " ") {
                double comp = Double.parseDouble(jTextFieldComp.getText());
                instru.setComp((double) comp);
                instru.setUnidade4((String) jComboBoxComp.getSelectedItem());
            } else {
                instru.setComp(0);
                instru.setUnidade4(" ");
            }
            if (!jTextFieldDiametro.getText().equalsIgnoreCase("") && jComboBoxDiametro.getSelectedItem() != " ") {
                double dia = Double.parseDouble(jTextFieldDiametro.getText());
                instru.setDiametro((double) dia);
                instru.setUnidade5((String) jComboBoxDiametro.getSelectedItem());
            } else {
                instru.setDiametro(0);
                instru.setUnidade5(" ");
            }
            instru.setPonta((String) jComboBoxPonta.getSelectedItem());
            instru.setOrientação((String) jComboBoxOrientação.getSelectedItem());
            instru.setAngulo((String) jComboBoxAngulo.getSelectedItem());
            instru.setNum((String) jComboBoxNum.getSelectedItem());
            instru.setSerrilha((String) jComboBoxSerrilha.getSelectedItem());
            instru.setWidia((String) jComboBoxWidia.getSelectedItem());
            instru.setDente((String) jComboBoxDente.getSelectedItem());
            instru.setTrava((String) jComboBoxTrava.getSelectedItem());
            instru.setFuro((String) jComboBoxFuro.getSelectedItem());
            instru.setOutro1(jTextFieldOutro1.getText());
            instru.setOutro2(jTextFieldOutro2.getText());
            instru.setOutro3(jTextFieldOutro3.getText());
            imagem1 = ManipularImagem.iconToImage(jLabelImagem.getIcon());
            instru.setImagem(ManipularImagem.getImgBytes((BufferedImage) imagem1));
            if (e == 0) {
                new BancoDAO().save(instru);
            } else {
                new BancoDAO().update(instru);
                e = 0;
            }
            limparCampos();
            resetCampos();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        e = 1;
        jComboBoxItem.setEnabled(true);
        jComboBoxTipo.setEnabled(true);
        jComboBoxEspecialidade.setEnabled(true);
        jButtonItem.setEnabled(true);
        jButtonTipo.setEnabled(true);
        jButtonEsp.setEnabled(true);
        jTextFieldDescrição.setEnabled(true);
        jButtonNovo.setEnabled(!true);
        jButtonImagem.setEnabled(true);
        jButtonLimpar.setEnabled(!true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonSair.setEnabled(true);
        jTextFieldPesquisar.setEnabled(!true);
        jButtonBuscar.setEnabled(!true);
        jButtonPrimeiro.setEnabled(!true);
        jButtonAnterior.setEnabled(!true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);
        jCheckBox001.setEnabled(true);
        jCheckBox002.setEnabled(true);
        jCheckBox003.setEnabled(true);
        jCheckBox004.setEnabled(true);
        jCheckBox005.setEnabled(true);
        jCheckBox006.setEnabled(true);
        jCheckBox007.setEnabled(true);
        jCheckBox008.setEnabled(true);
        jCheckBox009.setEnabled(true);
        jCheckBox010.setEnabled(true);
        jCheckBox011.setEnabled(true);
        jCheckBox012.setEnabled(true);
        jCheckBox013.setEnabled(true);
        jCheckBox014.setEnabled(true);
        jCheckBox015.setEnabled(true);
        jCheckBox016.setEnabled(true);
        jCheckBox017.setEnabled(true);
        jCheckBox018.setEnabled(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    @SuppressWarnings("StringEquality")
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        buscarInstru(jTextFieldPesquisar.getText().trim());
        if (tot != 0) {
            index = 0;
            setarCampos(lista.get(index));
            jButtonNovo.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonEditar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonCancelar.setEnabled(true);
            jTextFieldPesquisar.setText("");
            if (tot != 1) {
                jButtonProximo.setEnabled(true);
                jButtonUltimo.setEnabled(true);
            } else {
                jButtonPrimeiro.setEnabled(!true);
                jButtonAnterior.setEnabled(!true);
                jButtonProximo.setEnabled(!true);
                jButtonUltimo.setEnabled(!true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum ítem encontrado!");
            limparCampos();
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int excluir = JOptionPane.showConfirmDialog(rootPane, "O registro será excuído, continuar?");
        if (excluir == JOptionPane.YES_OPTION) {
            Long id = parseLong(jTextFieldId.getText());
            instru.setId(id);
            new BancoDAO().delete(instru.getId());
            int o = lista.indexOf(instru);
            if (o != 0 && o == tot - 1) {
                index = o - 1;
                setarCampos(lista.get(index));
                lista.remove(lista.get(o));
                tot = lista.size();
                if (tot == 1) {
                    jButtonPrimeiro.setEnabled(!true);
                    jButtonAnterior.setEnabled(!true);
                    jButtonProximo.setEnabled(!true);
                    jButtonUltimo.setEnabled(!true);
                }
            } else if (o >= 0 && o < tot - 1) {
                index = o + 1;
                setarCampos(lista.get(index));
                lista.remove(lista.get(o));
                tot = lista.size();
                if (tot == 1) {
                    jButtonPrimeiro.setEnabled(!true);
                    jButtonAnterior.setEnabled(!true);
                    jButtonProximo.setEnabled(!true);
                    jButtonUltimo.setEnabled(!true);
                }
            } else if (o == 0 && tot == 1) {
                limparCampos();
                resetCampos();
                JOptionPane.showMessageDialog(null, "Nenhum ítem encontrado!");
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimoActionPerformed
        index = (int)tot - 1;
        limparCampos();
        setarCampos(lista.get(index));
        jButtonPrimeiro.setEnabled(true);
        jButtonAnterior.setEnabled(true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);
        jButtonAnterior.requestFocus();
    }//GEN-LAST:event_jButtonUltimoActionPerformed

    private void jButtonPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimeiroActionPerformed
        index = 0;
        limparCampos();
        setarCampos(lista.get(index));
        jButtonPrimeiro.setEnabled(!true);
        jButtonAnterior.setEnabled(!true);
        jButtonProximo.setEnabled(true);
        jButtonUltimo.setEnabled(true);
        jButtonProximo.requestFocus();
    }//GEN-LAST:event_jButtonPrimeiroActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        if (index > 0) {
            index--;
            limparCampos();
            setarCampos(lista.get(index));
            jButtonPrimeiro.setEnabled(true);
            jButtonAnterior.setEnabled(true);
            jButtonProximo.setEnabled(true);
            jButtonUltimo.setEnabled(true);
        }
        if (index == 0) {
            jButtonPrimeiro.setEnabled(!true);
            jButtonAnterior.setEnabled(!true);
            jButtonProximo.setEnabled(true);
            jButtonUltimo.setEnabled(true);
            jButtonProximo.requestFocus();
        }
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed
        if (index < ((int)tot -1) ) {
            index++;
            limparCampos();
            setarCampos(lista.get(index));
            jButtonPrimeiro.setEnabled(true);
            jButtonAnterior.setEnabled(true);
            jButtonProximo.setEnabled(true);
            jButtonUltimo.setEnabled(true);
        }
        if (index == ((int)tot -1)) {
            jButtonPrimeiro.setEnabled(true);
            jButtonAnterior.setEnabled(true);
            jButtonProximo.setEnabled(!true);
            jButtonUltimo.setEnabled(!true);
            jButtonAnterior.requestFocus();
        }
    }//GEN-LAST:event_jButtonProximoActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        limparCampos();
        jComboBoxItem.setEnabled(true);
        jComboBoxTipo.setEnabled(true);
        jComboBoxEspecialidade.setEnabled(true);
        jButtonItem.setEnabled(true);
        jButtonTipo.setEnabled(true);
        jButtonEsp.setEnabled(true);
        jTextFieldDescrição.setEnabled(true);
        jButtonNovo.setEnabled(!true);
        jButtonImagem.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonSair.setEnabled(true);
        jTextFieldPesquisar.setEnabled(!true);
        jButtonBuscar.setEnabled(!true);
        jButtonPrimeiro.setEnabled(!true);
        jButtonAnterior.setEnabled(!true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);
        jCheckBox001.setEnabled(true);
        jCheckBox002.setEnabled(true);
        jCheckBox003.setEnabled(true);
        jCheckBox004.setEnabled(true);
        jCheckBox005.setEnabled(true);
        jCheckBox006.setEnabled(true);
        jCheckBox007.setEnabled(true);
        jCheckBox008.setEnabled(true);
        jCheckBox009.setEnabled(true);
        jCheckBox010.setEnabled(true);
        jCheckBox011.setEnabled(true);
        jCheckBox012.setEnabled(true);
        jCheckBox013.setEnabled(true);
        jCheckBox014.setEnabled(true);
        jCheckBox015.setEnabled(true);
        jCheckBox016.setEnabled(true);
        jCheckBox017.setEnabled(true);
        jCheckBox018.setEnabled(true);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limparCampos();
        resetCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        buscarInstru(jTextFieldPesquisar.getText().trim());
        if (tot != 0) {
            index = 0;
            setarCampos(lista.get(index));
            jButtonNovo.setEnabled(!true);
            jButtonLimpar.setEnabled(!true);
            jButtonEditar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonCancelar.setEnabled(true);
            jTextFieldPesquisar.setText("");
            if (tot != 1) {
                jButtonProximo.setEnabled(true);
                jButtonUltimo.setEnabled(true);
            } else {
                jButtonPrimeiro.setEnabled(!true);
                jButtonAnterior.setEnabled(!true);
                jButtonProximo.setEnabled(!true);
                jButtonUltimo.setEnabled(!true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum ítem encontrado!");
        }
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BancoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            BancoView dialog = new BancoView(banco, true);
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
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEsp;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonImagem;
    private javax.swing.JButton jButtonItem;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPrimeiro;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonTipo;
    private javax.swing.JButton jButtonUltimo;
    private javax.swing.JCheckBox jCheckBox001;
    private javax.swing.JCheckBox jCheckBox002;
    private javax.swing.JCheckBox jCheckBox003;
    private javax.swing.JCheckBox jCheckBox004;
    private javax.swing.JCheckBox jCheckBox005;
    private javax.swing.JCheckBox jCheckBox006;
    private javax.swing.JCheckBox jCheckBox007;
    private javax.swing.JCheckBox jCheckBox008;
    private javax.swing.JCheckBox jCheckBox009;
    private javax.swing.JCheckBox jCheckBox010;
    private javax.swing.JCheckBox jCheckBox011;
    private javax.swing.JCheckBox jCheckBox012;
    private javax.swing.JCheckBox jCheckBox013;
    private javax.swing.JCheckBox jCheckBox014;
    private javax.swing.JCheckBox jCheckBox015;
    private javax.swing.JCheckBox jCheckBox016;
    private javax.swing.JCheckBox jCheckBox017;
    private javax.swing.JCheckBox jCheckBox018;
    private javax.swing.JComboBox<String> jComboBoxAngulo;
    private javax.swing.JComboBox<String> jComboBoxComp;
    private javax.swing.JComboBox<String> jComboBoxDente;
    private javax.swing.JComboBox<String> jComboBoxDiametro;
    private javax.swing.JComboBox<String> jComboBoxEspecialidade;
    private javax.swing.JComboBox<String> jComboBoxFormato;
    private javax.swing.JComboBox<String> jComboBoxFuro;
    private javax.swing.JComboBox<String> jComboBoxItem;
    private javax.swing.JComboBox<String> jComboBoxLarguraA;
    private javax.swing.JComboBox<String> jComboBoxLarguraB;
    private javax.swing.JComboBox<String> jComboBoxNum;
    private javax.swing.JComboBox<String> jComboBoxOrientação;
    private javax.swing.JComboBox<String> jComboBoxPonta;
    private javax.swing.JComboBox<String> jComboBoxSerrilha;
    private javax.swing.JComboBox<String> jComboBoxTamanho;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JComboBox<String> jComboBoxTrava;
    private javax.swing.JComboBox<String> jComboBoxWidia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanelDetalhes;
    private javax.swing.JTextField jTextFieldComp;
    private javax.swing.JTextField jTextFieldDescrição;
    private javax.swing.JTextField jTextFieldDiametro;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldLarguraA;
    private javax.swing.JTextField jTextFieldLarguraB;
    private javax.swing.JTextField jTextFieldOutro1;
    private javax.swing.JTextField jTextFieldOutro2;
    private javax.swing.JTextField jTextFieldOutro3;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldTamanho;
    // End of variables declaration//GEN-END:variables
}