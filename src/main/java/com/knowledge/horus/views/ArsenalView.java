package com.knowledge.horus.views;

import javax.swing.JOptionPane;
import com.knowledge.horus.controls.ArsenalDAO;
import com.knowledge.horus.controls.BancoDAO;
import com.knowledge.horus.controls.ComboBoxDAO;
import com.knowledge.horus.controls.ManipularImagem;
import com.knowledge.horus.models.Arsenal;
import com.knowledge.horus.models.Banco;
import com.knowledge.horus.models.ComboBox;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ArsenalView extends javax.swing.JDialog {

    BufferedImage imagem;
    Image imagem1;
    int e = 0;
    int serie = 0;
    public static NovaEspec espec;
    public static NovoItem itens;
    public static NovoTipo tipo;
    public static NovoSetor setor;
    public static MenuGerenciar caditem;
    Arsenal instru = new Arsenal();
    List<Arsenal> lista = null;
    List<Banco> banco = null;
    int tot;
    int index;
    Long id;
    String mode = "buscar";
        
    public ArsenalView(MenuGerenciar parent, boolean modal) {
        super (parent, modal);
        initComponents();
        buscarItem();
        buscarTipo();
        buscarEsp();
        buscarSetor();
        jTextFieldCód.requestFocus();
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
    
    public void buscarSetor(){
        List<ComboBox> combo = new ComboBoxDAO().findItem("Setor");
        jComboBoxSetor.removeAllItems();
        combo.forEach(d -> jComboBoxSetor.addItem(d.getDescrição()));
    }
    
    public void buscarInstru(String psq){
        if (psq.equalsIgnoreCase("")) {
            lista = new ArsenalDAO().findAll();
            tot = lista.size();
        } else {
            lista = new ArsenalDAO().findByDetalhes(psq);
            tot = lista.size();
        }
    }
    
    public void buscarArsenal (Long inst){
        lista = new ArsenalDAO().findByCod(inst);
        tot = lista.size();
    }
    
    public void buscarBanco(String psq){
        if (psq.equalsIgnoreCase("")) {
            banco = new BancoDAO().findAll();
            tot = banco.size();
        } else {
            banco = new BancoDAO().findByDetalhes(psq);
            tot = banco.size();
        }
    }
    
    public void setarCampos(Arsenal instru){
        id = instru.getId();
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
        int q = jComboBoxSetor.getItemCount();
        for (int i = 0; i < q; i++) {
            if (instru.getSetor().trim().equals(jComboBoxSetor.getItemAt(i).intern().trim())) {
                jComboBoxSetor.setSelectedIndex(i);
            }
        }
        jTextFieldDescrição.setText(instru.getDescricao().trim());
        jTextFieldCód.setText(Long.toString(instru.getCod()));
        jTextFieldFantasia.setText(instru.getFantasia().trim());
        if (!instru.getFormato().equalsIgnoreCase("")) {
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
        jComboBoxPonta.setSelectedItem(instru.getPonta().trim());
        jComboBoxOrientação.setSelectedItem(instru.getOrientacao().trim());
        jComboBoxAngulo.setSelectedItem(instru.getAngulo().trim());
        jComboBoxNum.setSelectedItem(instru.getNum().trim());
        jComboBoxSerrilha.setSelectedItem(instru.getSerrilha().trim());
        jComboBoxWidia.setSelectedItem(instru.getWidia().trim());
        jComboBoxDente.setSelectedItem(instru.getDente().trim());
        jComboBoxTrava.setSelectedItem(instru.getTrava().trim());
        jComboBoxFuro.setSelectedItem(instru.getFuro().trim());
        jTextFieldOutro1.setText(instru.getOutro1().trim());
        jTextFieldOutro2.setText(instru.getOutro2().trim());
        jTextFieldOutro3.setText(instru.getOutro3().trim());
        ManipularImagem.exibiImagemLabel(instru.getImagem(), jLabelImagem);
    }
    
    public void setarBanco(Banco instru){
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
        if (instru.getFormato() != null) {
            jComboBoxFormato.setSelectedItem(instru.getFormato().trim());
        }
        if (instru.getTamanho() != 0 && instru.getUnidade1() != null) {
            jTextFieldTamanho.setText(Double.toString(instru.getTamanho()));
            jComboBoxTamanho.setSelectedItem(instru.getUnidade1().trim());
        }else{
            jComboBoxTamanho.setSelectedItem("");
        }
        if (instru.getLarguraa() != 0 && instru.getUnidade2() != null) {
            jTextFieldLarguraA.setText(Double.toString(instru.getLarguraa()));
            jComboBoxLarguraA.setSelectedItem(instru.getUnidade2().trim());
        }else{
            jComboBoxLarguraA.setSelectedItem("");
        }
        if (instru.getLargurab() != 0 && instru.getUnidade3() != null) {
            jTextFieldLarguraB.setText(Double.toString(instru.getLargurab()));
            jComboBoxLarguraB.setSelectedItem(instru.getUnidade3().trim());
        }else{
            jComboBoxLarguraB.setSelectedItem("");
        }
        if (instru.getComp() != 0 && instru.getUnidade4() != null) {
            jTextFieldComp.setText(Double.toString(instru.getComp()));
            jComboBoxComp.setSelectedItem(instru.getUnidade4().trim());
        }else{
            jComboBoxComp.setSelectedItem("");
        }
        if(instru.getDiametro()!= 0 && instru.getUnidade5() != null){
            jTextFieldDiametro.setText(Double.toString(instru.getDiametro()));
            jComboBoxDiametro.setSelectedItem(instru.getUnidade5().trim());
        }else{
            jComboBoxDiametro.setSelectedItem("");
        }
        if (instru.getPonta() != null) {
            jComboBoxPonta.setSelectedItem(instru.getPonta().trim());
        }
        if (instru.getOrientação() != null) {
            jComboBoxOrientação.setSelectedItem(instru.getOrientação().trim());
        }
        if (instru.getAngulo() != null) {
            jComboBoxAngulo.setSelectedItem(instru.getAngulo().trim());
        }
        if (instru.getNum() != null) {
            jComboBoxNum.setSelectedItem(instru.getNum().trim());
        }
        if (instru.getSerrilha() != null) {
            jComboBoxSerrilha.setSelectedItem(instru.getSerrilha().trim());
        }
        if (instru.getWidia() != null) {
            jComboBoxWidia.setSelectedItem(instru.getWidia().trim());
        }
        if (instru.getDente() != null) {
            jComboBoxDente.setSelectedItem(instru.getDente().trim());
        }
        if (instru.getTrava() != null) {
            jComboBoxTrava.setSelectedItem(instru.getTrava().trim());
        }
        if (instru.getFuro() != null) {
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
        buscarSetor();
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
        if (!mode.equalsIgnoreCase("novo")) {
            jTextFieldCód.setText("");
        }
        jTextFieldFantasia.setText("");
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
        jCheckBoxSerie.setSelected(!true);
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
        jComboBoxItem.setEnabled(!true);
        jComboBoxTipo.setEnabled(!true);
        jComboBoxEspecialidade.setEnabled(!true);
        jComboBoxSetor.setEnabled(!true);
        jButtonItem.setEnabled(!true);
        jButtonTipo.setEnabled(!true);
        jButtonEsp.setEnabled(!true);
        jButtonSetor.setEnabled(!true);
        jTextFieldCód.setEnabled(true);
        jTextFieldDescrição.setEnabled(!true);
        jTextFieldFantasia.setEnabled(!true);
        jTextFieldPesquisar.setEnabled(true);
        jButtonNovo.setEnabled(true);
        jButtonImagem.setEnabled(!true);
        jButtonLimpar.setEnabled(!true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(!true);
        jButtonCancelar.setEnabled(!true);
        jButtonSair.setEnabled(true);
        jButtonBuscar.setEnabled(true);
        jButtonPrimeiro.setEnabled(!true);
        jButtonAnterior.setEnabled(!true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);
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
        jCheckBoxSerie.setEnabled(!true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jTextFieldDescrição = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLimpar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonEsp = new javax.swing.JButton();
        jComboBoxEspecialidade = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButtonItem = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
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
        jComboBoxItem = new javax.swing.JComboBox<>();
        jButtonTipo = new javax.swing.JButton();
        jLabelImagem = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPrimeiro = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();
        jButtonUltimo = new javax.swing.JButton();
        jTextFieldCód = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonImagem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSetor = new javax.swing.JComboBox<>();
        jButtonSetor = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxSerie = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldFantasia = new javax.swing.JTextField();
        jRadioButtonArsenal = new javax.swing.JRadioButton();
        jRadioButtonCatalogo = new javax.swing.JRadioButton();
        jLabelFundo = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Ítens");
        setMinimumSize(new java.awt.Dimension(760, 620));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxTipo.setEnabled(false);
        jComboBoxTipo.setMaximumSize(new java.awt.Dimension(177, 25));
        jComboBoxTipo.setMinimumSize(new java.awt.Dimension(177, 25));
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(177, 25));
        jComboBoxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, 23));

        jTextFieldDescrição.setEnabled(false);
        jTextFieldDescrição.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldDescrição.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldDescrição.setPreferredSize(new java.awt.Dimension(6, 25));
        jTextFieldDescrição.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescriçãoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldDescrição, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 270, 20));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("* Descrição:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 70, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("* Especialidade:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 100, 20));

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
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 80, 23));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("* Ítem:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 20));

        jButtonEsp.setText("...");
        jButtonEsp.setEnabled(false);
        jButtonEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 30, 23));

        jComboBoxEspecialidade.setEnabled(false);
        jComboBoxEspecialidade.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxEspecialidade.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxEspecialidade.setPreferredSize(new java.awt.Dimension(157, 25));
        jComboBoxEspecialidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEspecialidadeItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 190, 23));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("* Imagem:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 20));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("* Tipo:");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 40, 20));

        jButtonItem.setText("...");
        jButtonItem.setEnabled(false);
        jButtonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 30, 23));

        jButtonSair.setText("Sair");
        jButtonSair.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonSair.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonSair.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, 80, 23));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Detalhes");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 250, 40);

        jCheckBox001.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox001.setEnabled(false);
        jCheckBox001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox001ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox001);
        jCheckBox001.setBounds(220, 40, 20, 19);

        jTextFieldComp.setEnabled(false);
        jTextFieldComp.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldComp.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldComp.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldComp);
        jTextFieldComp.setBounds(90, 160, 40, 23);

        jComboBoxFormato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Curva(o)", "Semi curva(o)", "Curva(o) forte", "Curvo(a) direito(a)", "Curvo(a) esquerdo(a)", "Reta(o)", "Angulado(a)", "Goivo(a)" }));
        jComboBoxFormato.setEnabled(false);
        jComboBoxFormato.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxFormato.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxFormato.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxFormato);
        jComboBoxFormato.setBounds(90, 40, 130, 23);

        jLabel7.setText("Tamanho:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 70, 80, 20);

        jCheckBox002.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox002.setEnabled(false);
        jCheckBox002.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox002ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox002);
        jCheckBox002.setBounds(220, 70, 20, 19);

        jLabel8.setText("Altura :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 100, 80, 20);

        jCheckBox003.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox003.setEnabled(false);
        jCheckBox003.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox003ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox003);
        jCheckBox003.setBounds(220, 100, 20, 19);

        jComboBoxLarguraA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxLarguraA.setEnabled(false);
        jComboBoxLarguraA.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraA.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraA.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxLarguraA);
        jComboBoxLarguraA.setBounds(150, 100, 70, 23);

        jLabel9.setText("Comprimento:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 160, 80, 20);

        jCheckBox005.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox005.setEnabled(false);
        jCheckBox005.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox005ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox005);
        jCheckBox005.setBounds(220, 160, 20, 19);

        jComboBoxComp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxComp.setEnabled(false);
        jComboBoxComp.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxComp.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxComp.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxComp);
        jComboBoxComp.setBounds(150, 160, 70, 23);

        jLabel10.setText("Tipo de ponta:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 220, 80, 20);

        jCheckBox007.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox007.setEnabled(false);
        jCheckBox007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox007ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox007);
        jCheckBox007.setBounds(220, 220, 20, 19);

        jComboBoxPonta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Agudo", "Rombo", "Agudo/Rombo" }));
        jComboBoxPonta.setEnabled(false);
        jComboBoxPonta.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxPonta.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxPonta.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxPonta);
        jComboBoxPonta.setBounds(90, 220, 130, 23);

        jLabel11.setText("Serrilha:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 340, 80, 20);

        jCheckBox011.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox011.setEnabled(false);
        jCheckBox011.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox011ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox011);
        jCheckBox011.setBounds(220, 340, 20, 19);

        jComboBoxSerrilha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "C/ Serrilha", "S/ Serrilha" }));
        jComboBoxSerrilha.setEnabled(false);
        jComboBoxSerrilha.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxSerrilha.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxSerrilha.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxSerrilha);
        jComboBoxSerrilha.setBounds(90, 340, 130, 23);

        jLabel12.setText("Widia:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 370, 80, 20);

        jCheckBox012.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox012.setEnabled(false);
        jCheckBox012.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox012ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox012);
        jCheckBox012.setBounds(220, 370, 20, 19);

        jComboBoxWidia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "C/ Widia", "S/ Widia" }));
        jComboBoxWidia.setEnabled(false);
        jComboBoxWidia.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxWidia.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxWidia.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxWidia);
        jComboBoxWidia.setBounds(90, 370, 130, 23);

        jLabel13.setText("Largura :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 130, 80, 20);

        jCheckBox004.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox004.setEnabled(false);
        jCheckBox004.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox004ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox004);
        jCheckBox004.setBounds(220, 130, 20, 19);

        jComboBoxLarguraB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxLarguraB.setEnabled(false);
        jComboBoxLarguraB.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraB.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxLarguraB.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxLarguraB);
        jComboBoxLarguraB.setBounds(150, 130, 70, 23);

        jTextFieldOutro1.setEnabled(false);
        jTextFieldOutro1.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro1.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro1.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldOutro1);
        jTextFieldOutro1.setBounds(90, 490, 130, 23);

        jTextFieldLarguraA.setEnabled(false);
        jTextFieldLarguraA.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraA.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraA.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldLarguraA);
        jTextFieldLarguraA.setBounds(90, 100, 40, 23);

        jTextFieldLarguraB.setEnabled(false);
        jTextFieldLarguraB.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraB.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldLarguraB.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldLarguraB);
        jTextFieldLarguraB.setBounds(90, 130, 40, 23);

        jComboBoxTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxTamanho.setEnabled(false);
        jComboBoxTamanho.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxTamanho.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxTamanho.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxTamanho);
        jComboBoxTamanho.setBounds(150, 70, 70, 23);

        jLabel14.setText("Dente:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 400, 80, 20);

        jCheckBox013.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox013.setEnabled(false);
        jCheckBox013.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox013ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox013);
        jCheckBox013.setBounds(220, 400, 20, 19);

        jComboBoxDente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "C/ Dente", "S/ Dente", "2 dentes", "3 dentes", "4 dentes", "5 dentes", "6 dentes" }));
        jComboBoxDente.setEnabled(false);
        jComboBoxDente.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxDente.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxDente.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxDente);
        jComboBoxDente.setBounds(90, 400, 130, 23);

        jTextFieldDiametro.setEnabled(false);
        jTextFieldDiametro.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldDiametro.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldDiametro.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldDiametro);
        jTextFieldDiametro.setBounds(90, 190, 40, 23);

        jLabel15.setText("Diâmetro:    Ø");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 190, 80, 20);

        jCheckBox006.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox006.setEnabled(false);
        jCheckBox006.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox006ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox006);
        jCheckBox006.setBounds(220, 190, 20, 19);

        jComboBoxDiametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "cm", "mm", "pol." }));
        jComboBoxDiametro.setEnabled(false);
        jComboBoxDiametro.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxDiametro.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxDiametro.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxDiametro);
        jComboBoxDiametro.setBounds(150, 190, 70, 23);

        jLabel16.setText("Outro:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(10, 490, 80, 20);

        jCheckBox016.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox016.setEnabled(false);
        jCheckBox016.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox016ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox016);
        jCheckBox016.setBounds(220, 490, 20, 19);

        jComboBoxFuro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Perfurada", "Fenestrada", "Fenestrada / Perfurada" }));
        jComboBoxFuro.setEnabled(false);
        jComboBoxFuro.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxFuro.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxFuro.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxFuro);
        jComboBoxFuro.setBounds(90, 460, 130, 23);

        jLabel17.setText("Orientação:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(10, 250, 80, 20);

        jCheckBox008.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox008.setEnabled(false);
        jCheckBox008.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox008ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox008);
        jCheckBox008.setBounds(220, 250, 20, 19);

        jComboBoxOrientação.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Esquerda", "Direita", "Para cima", "Para baixo" }));
        jComboBoxOrientação.setEnabled(false);
        jComboBoxOrientação.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxOrientação.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxOrientação.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxOrientação);
        jComboBoxOrientação.setBounds(90, 250, 130, 23);

        jLabel18.setText("Angulo:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(10, 280, 80, 20);

        jCheckBox009.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox009.setEnabled(false);
        jCheckBox009.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox009ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox009);
        jCheckBox009.setBounds(220, 280, 20, 19);

        jComboBoxAngulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Acotovelado 90°", "Angulado 90°", "Angulado 45°", "25°", "30°", "45°", "60º", "90º", "130º", "Reto" }));
        jComboBoxAngulo.setEnabled(false);
        jComboBoxAngulo.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxAngulo.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxAngulo.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxAngulo);
        jComboBoxAngulo.setBounds(90, 280, 130, 23);

        jLabel19.setText("Numeração:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(10, 310, 80, 20);

        jCheckBox010.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox010.setEnabled(false);
        jCheckBox010.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox010ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox010);
        jCheckBox010.setBounds(220, 310, 20, 19);

        jComboBoxNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Virgem", "P", "M", "G", "Nº 1", "Nº 2", "Nº 3", "Nº 4", "Nº 5", "Nº 6", "Nº 7", "Nº 8", "Nº 9", "Nº 10", "Nº 11", "Nº 12", "Nº 13", "Nº 14", "Nº 15", "Nº 16", "Nº 17", "Nº 18", "Nº 19", "Nº 20 " }));
        jComboBoxNum.setEnabled(false);
        jComboBoxNum.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxNum.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxNum.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxNum);
        jComboBoxNum.setBounds(90, 310, 130, 23);

        jLabel20.setText("Trava:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(10, 430, 80, 20);

        jCheckBox014.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox014.setEnabled(false);
        jCheckBox014.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox014ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox014);
        jCheckBox014.setBounds(220, 430, 20, 19);

        jComboBoxTrava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "C/ Trava", "S/ Trava" }));
        jComboBoxTrava.setEnabled(false);
        jComboBoxTrava.setMaximumSize(new java.awt.Dimension(157, 25));
        jComboBoxTrava.setMinimumSize(new java.awt.Dimension(157, 25));
        jComboBoxTrava.setPreferredSize(new java.awt.Dimension(157, 25));
        jPanel2.add(jComboBoxTrava);
        jComboBoxTrava.setBounds(90, 430, 130, 23);

        jCheckBox015.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox015.setEnabled(false);
        jCheckBox015.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox015ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox015);
        jCheckBox015.setBounds(220, 460, 20, 19);

        jLabel21.setText("Furo:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(10, 460, 80, 20);

        jTextFieldOutro2.setEnabled(false);
        jTextFieldOutro2.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro2.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro2.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldOutro2);
        jTextFieldOutro2.setBounds(90, 520, 130, 23);

        jCheckBox017.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox017.setEnabled(false);
        jCheckBox017.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox017ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox017);
        jCheckBox017.setBounds(220, 520, 20, 19);

        jLabel23.setText("Formato:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(10, 40, 80, 20);

        jLabel25.setText("Outro:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(10, 520, 80, 20);

        jLabel26.setText("Outro:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(10, 550, 80, 20);

        jTextFieldOutro3.setEnabled(false);
        jTextFieldOutro3.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro3.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldOutro3.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldOutro3);
        jTextFieldOutro3.setBounds(90, 550, 130, 23);

        jCheckBox018.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox018.setEnabled(false);
        jCheckBox018.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox018ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox018);
        jCheckBox018.setBounds(220, 550, 20, 19);

        jTextFieldTamanho.setEnabled(false);
        jTextFieldTamanho.setMaximumSize(new java.awt.Dimension(6, 25));
        jTextFieldTamanho.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextFieldTamanho.setPreferredSize(new java.awt.Dimension(6, 25));
        jPanel2.add(jTextFieldTamanho);
        jTextFieldTamanho.setBounds(90, 70, 40, 23);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 250, 580));

        jComboBoxItem.setEnabled(false);
        jComboBoxItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxItemItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 200, 23));

        jButtonTipo.setText("...");
        jButtonTipo.setEnabled(false);
        jButtonTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 30, 23));

        jLabelImagem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagem.setOpaque(true);
        getContentPane().add(jLabelImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 480, 310));

        jButtonBuscar.setText("Pesquisar");
        jButtonBuscar.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonBuscar.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(60, 30));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 90, 23));

        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 170, 23));

        jButtonPrimeiro.setText("|<");
        jButtonPrimeiro.setEnabled(false);
        jButtonPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimeiroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPrimeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 50, -1));

        jButtonAnterior.setText("<");
        jButtonAnterior.setEnabled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, 50, -1));

        jButtonProximo.setText(">");
        jButtonProximo.setEnabled(false);
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 50, -1));

        jButtonUltimo.setText(">|");
        jButtonUltimo.setEnabled(false);
        jButtonUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, 50, -1));

        jTextFieldCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 20));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("* Código do Ítem:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 20));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, 80, 23));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 80, 23));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 80, 23));

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 80, 23));

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 80, 23));

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
        getContentPane().add(jButtonImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 80, 23));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gerenciar Arsenal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 20));

        jComboBoxSetor.setEnabled(false);
        jComboBoxSetor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSetorItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 190, 23));

        jButtonSetor.setText("...");
        jButtonSetor.setEnabled(false);
        jButtonSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 30, 23));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("* Setor de Orígem:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 100, 20));

        jCheckBoxSerie.setBackground(new java.awt.Color(153, 153, 153));
        jCheckBoxSerie.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxSerie.setEnabled(false);
        jCheckBoxSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSerieActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Cadastrar lote");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 90, 20));

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Pertence à:");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 20));

        jTextFieldFantasia.setEnabled(false);
        jTextFieldFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFantasiaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 250, 20));

        jRadioButtonArsenal.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButtonArsenal);
        jRadioButtonArsenal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jRadioButtonArsenal.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonArsenal.setText("Arsenal");
        jRadioButtonArsenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonArsenalActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonArsenal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 590, -1, 23));

        jRadioButtonCatalogo.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButtonCatalogo);
        jRadioButtonCatalogo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jRadioButtonCatalogo.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCatalogo.setSelected(true);
        jRadioButtonCatalogo.setText("Catálogo");
        jRadioButtonCatalogo.setBorder(null);
        jRadioButtonCatalogo.setFocusPainted(false);
        jRadioButtonCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCatalogoActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, -1, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 630));

        setSize(new java.awt.Dimension(760, 630));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente sair?\n");
        if (sair == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jCheckBox001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox001ActionPerformed
        if (jCheckBox001.isSelected()) {
            jComboBoxFormato.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxFormato.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
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
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxAngulo.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox009ActionPerformed

    private void jCheckBox018ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox018ActionPerformed
        if (jCheckBox018.isSelected()) {
            jTextFieldOutro3.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jTextFieldOutro3.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox018ActionPerformed

    private void jCheckBox002ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox002ActionPerformed
        if (jCheckBox002.isSelected()) {
            jComboBoxTamanho.setEnabled(true);
            jTextFieldTamanho.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxTamanho.setEnabled(!true);
            jTextFieldTamanho.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox002ActionPerformed

    private void jCheckBox003ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox003ActionPerformed
        if (jCheckBox003.isSelected()) {
            jComboBoxLarguraA.setEnabled(true);
            jTextFieldLarguraA.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxLarguraA.setEnabled(!true);
            jTextFieldLarguraA.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox003ActionPerformed

    private void jCheckBox004ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox004ActionPerformed
        if (jCheckBox004.isSelected()) {
            jComboBoxLarguraB.setEnabled(true);
            jTextFieldLarguraB.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxLarguraB.setEnabled(!true);
            jTextFieldLarguraB.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox004ActionPerformed

    private void jCheckBox005ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox005ActionPerformed
        if (jCheckBox005.isSelected()) {
            jComboBoxComp.setEnabled(true);
            jTextFieldComp.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxComp.setEnabled(!true);
            jTextFieldComp.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox005ActionPerformed

    private void jCheckBox006ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox006ActionPerformed
        if (jCheckBox006.isSelected()) {
            jComboBoxDiametro.setEnabled(true);
            jTextFieldDiametro.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxDiametro.setEnabled(!true);
            jTextFieldDiametro.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox006ActionPerformed

    private void jCheckBox007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox007ActionPerformed
        if (jCheckBox007.isSelected()) {
            jComboBoxPonta.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxPonta.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox007ActionPerformed

    private void jCheckBox008ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox008ActionPerformed
        if (jCheckBox008.isSelected()) {
            jComboBoxOrientação.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxOrientação.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox008ActionPerformed

    private void jCheckBox010ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox010ActionPerformed
        if (jCheckBox010.isSelected()) {
            jComboBoxNum.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxNum.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox010ActionPerformed

    private void jCheckBox011ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox011ActionPerformed
        if (jCheckBox011.isSelected()) {
            jComboBoxSerrilha.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxSerrilha.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox011ActionPerformed

    private void jCheckBox012ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox012ActionPerformed
        if (jCheckBox012.isSelected()) {
            jComboBoxWidia.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxWidia.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox012ActionPerformed

    private void jCheckBox013ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox013ActionPerformed
        if (jCheckBox013.isSelected()) {
            jComboBoxDente.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxDente.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox013ActionPerformed

    private void jCheckBox014ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox014ActionPerformed
        if (jCheckBox014.isSelected()) {
            jComboBoxTrava.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxTrava.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox014ActionPerformed

    private void jCheckBox015ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox015ActionPerformed
        if (jCheckBox015.isSelected()) {
            jComboBoxFuro.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jComboBoxFuro.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox015ActionPerformed

    private void jCheckBox016ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox016ActionPerformed
        if (jCheckBox016.isSelected()) {
            jTextFieldOutro1.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jTextFieldOutro1.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox016ActionPerformed

    private void jCheckBox017ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox017ActionPerformed
        if (jCheckBox017.isSelected()) {
            jTextFieldOutro2.setEnabled(true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(true);
            }
        }else{
            jTextFieldOutro2.setEnabled(!true);
            if (mode.equalsIgnoreCase("editar")) {
                jButtonSalvar.setEnabled(!true);
            }
        }
    }//GEN-LAST:event_jCheckBox017ActionPerformed

    @SuppressWarnings("StringEquality")
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        if (!mode.equalsIgnoreCase("novo")) {
            mode = "buscar";
        }
        if (jRadioButtonCatalogo.isSelected()) {
            buscarBanco(jTextFieldPesquisar.getText().trim());
        } else {
            buscarInstru(jTextFieldPesquisar.getText().trim());
        }
        limparCampos();
        if (tot != 0) {
            index = 0;
            if (jRadioButtonCatalogo.isSelected()) {
                setarBanco(banco.get(index));
            } else {
                setarCampos(lista.get(index));
                jButtonEditar.setEnabled(true);
                jButtonExcluir.setEnabled(true);
            }
            if (mode.equalsIgnoreCase("buscar")) {
                jTextFieldCód.setEnabled(!true);
            } else {
                jTextFieldCód.setEnabled(true);
                jButtonSalvar.setEnabled(true);
            }
            jTextFieldPesquisar.setText("");
            jButtonNovo.setEnabled(!true);
            jButtonCancelar.setEnabled(true);
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
            resetCampos();
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimoActionPerformed
        index = (int)tot - 1;
        limparCampos();
        if (jRadioButtonCatalogo.isSelected()) {
            setarBanco(banco.get(index));
        } else {
            setarCampos(lista.get(index));
        }
        jButtonPrimeiro.setEnabled(true);
        jButtonAnterior.setEnabled(true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);
        jButtonAnterior.requestFocus();
    }//GEN-LAST:event_jButtonUltimoActionPerformed

    private void jButtonPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimeiroActionPerformed
        index = 0;
        limparCampos();
        if (jRadioButtonCatalogo.isSelected()) {
            setarBanco(banco.get(index));
        } else {
            setarCampos(lista.get(index));
        }
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
            if (jRadioButtonCatalogo.isSelected()) {
                setarBanco(banco.get(index));
            } else {
                setarCampos(lista.get(index));
            }
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
            if (jRadioButtonCatalogo.isSelected()) {
                setarBanco(banco.get(index));
            } else {
                setarCampos(lista.get(index));
            }
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

    private void jButtonImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagemActionPerformed
        JFileChooser fc = new JFileChooser("C:\\Users\\kal_e\\Documents\\Inteligência Criativa\\NetBeansProjects\\Horus\\src\\main\\resources\\database");
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

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        limparCampos();
        jComboBoxItem.setEnabled(true);
        jComboBoxTipo.setEnabled(true);
        jComboBoxEspecialidade.setEnabled(true);
        jComboBoxSetor.setEnabled(true);
        jButtonItem.setEnabled(true);
        jButtonTipo.setEnabled(true);
        jButtonEsp.setEnabled(true);
        jButtonSetor.setEnabled(true);
        jTextFieldCód.setEnabled(true);
        jTextFieldDescrição.setEnabled(true);
        jTextFieldFantasia.setEnabled(true);
        jButtonNovo.setEnabled(!true);
        jButtonImagem.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(!true);
        jButtonCancelar.setEnabled(true);
        jButtonSair.setEnabled(true);
        jTextFieldPesquisar.setEnabled(true);
        jTextFieldPesquisar.requestFocus();
        jButtonBuscar.setEnabled(true);
        jButtonPrimeiro.setEnabled(!true);
        jButtonAnterior.setEnabled(!true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);
        jCheckBoxSerie.setEnabled(true);
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
        serie = 0;
        mode = "novo";
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jTextFieldCód.getText().equalsIgnoreCase("") || jLabelImagem.getIcon() == null || 
                jComboBoxItem.getSelectedIndex() == 0 || jComboBoxSetor.getSelectedIndex() == 0 ||
                jComboBoxEspecialidade.getSelectedIndex() == 0 || jComboBoxTipo.getSelectedIndex() == 0 ||
                jTextFieldDescrição.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(rootPane, "Os campos iniciados com * são obrigatórios!");
        } else {
            if (mode.equalsIgnoreCase("editar")) {
                instru.setId(id);
            } else {
                instru.setId(null);
            }
            instru.setCod(Long.parseLong(jTextFieldCód.getText()));
            instru.setItem((String) jComboBoxItem.getSelectedItem());
            instru.setTipo((String) jComboBoxTipo.getSelectedItem());
            instru.setEspecialidade((String) jComboBoxEspecialidade.getSelectedItem());
            instru.setDescricao(jTextFieldDescrição.getText());
            instru.setFantasia(jTextFieldFantasia.getText());
            instru.setSetor((String) jComboBoxSetor.getSelectedItem());
            instru.setFormato((String) jComboBoxFormato.getSelectedItem());
            if (jTextFieldTamanho.getText().equalsIgnoreCase("") && jComboBoxTamanho.getSelectedItem() != " ") {
                double tam = Double.parseDouble(jTextFieldTamanho.getText());
                instru.setTamanho((double) tam);
                instru.setUnidade1((String) jComboBoxTamanho.getSelectedItem());
            } else {
                instru.setTamanho(0);
                instru.setUnidade1(" ");
            }
            if (jTextFieldLarguraA.getText().equalsIgnoreCase("") && jComboBoxLarguraA.getSelectedItem() != " ") {
                double larga = Double.parseDouble(jTextFieldLarguraA.getText());
                instru.setLarguraa((double) larga);
                instru.setUnidade2((String) jComboBoxLarguraA.getSelectedItem());
            } else {
                instru.setLarguraa(0);
                instru.setUnidade2(" ");
            }
            if (jTextFieldLarguraB.getText().equalsIgnoreCase("") && jComboBoxLarguraB.getSelectedItem() != " ") {
                double largb = Double.parseDouble(jTextFieldLarguraB.getText());
                instru.setLargurab((double) largb);
                instru.setUnidade3((String) jComboBoxLarguraB.getSelectedItem());
            } else {
                instru.setLargurab(0);
                instru.setUnidade3(" ");
            }
            if (jTextFieldComp.getText().equalsIgnoreCase("") && jComboBoxComp.getSelectedItem() != " ") {
                double comp = Double.parseDouble(jTextFieldComp.getText());
                instru.setComp((double) comp);
                instru.setUnidade4((String) jComboBoxComp.getSelectedItem());
            } else {
                instru.setComp(0);
                instru.setUnidade4(" ");
            }
            if (jTextFieldDiametro.getText().equalsIgnoreCase("") && jComboBoxDiametro.getSelectedItem() != " ") {
                double dia = Double.parseDouble(jTextFieldDiametro.getText());
                instru.setDiametro((double) dia);
                instru.setUnidade5((String) jComboBoxDiametro.getSelectedItem());
            } else {
                instru.setDiametro(0);
                instru.setUnidade5(" ");
            }
            instru.setPonta((String) jComboBoxPonta.getSelectedItem());
            instru.setOrientacao((String) jComboBoxOrientação.getSelectedItem());
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
            if (e == 0 && serie == 0) {
                new ArsenalDAO().save(instru);
                instru = null;
                limparCampos();
                resetCampos();
                banco = null;
                jTextFieldCód.requestFocus();
            } else if (e == 0 && serie == 1) {
                new ArsenalDAO().save(instru);
                instru = null;
                jTextFieldCód.setText("");
                jTextFieldCód.requestFocus();
            } else if (e == 1){
                new ArsenalDAO().update(instru);
                instru = null;
                limparCampos();
                resetCampos();
                mode = "buscar";
                e = 0;
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        jComboBoxItem.setEnabled(true);
        jComboBoxTipo.setEnabled(true);
        jComboBoxEspecialidade.setEnabled(true);
        jComboBoxSetor.setEnabled(true);
        jButtonItem.setEnabled(true);
        jButtonTipo.setEnabled(true);
        jButtonEsp.setEnabled(true);
        jButtonSetor.setEnabled(true);
        jButtonNovo.setEnabled(!true);
        jButtonImagem.setEnabled(true);
        jButtonLimpar.setEnabled(true);
        jButtonEditar.setEnabled(!true);
        jButtonExcluir.setEnabled(!true);
        jButtonSalvar.setEnabled(!true);
        jButtonCancelar.setEnabled(true);
        jButtonSair.setEnabled(true);
        jButtonBuscar.setEnabled(!true);
        jButtonPrimeiro.setEnabled(!true);
        jButtonAnterior.setEnabled(!true);
        jButtonProximo.setEnabled(!true);
        jButtonUltimo.setEnabled(!true);
        jTextFieldCód.setEnabled(!true);
        jTextFieldDescrição.setEnabled(true);
        jTextFieldFantasia.setEnabled(true);
        jTextFieldPesquisar.setEnabled(!true);
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
        e = 1;
        mode = "editar";
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        buscarArsenal(Long.parseLong(jTextFieldCód.getText().trim()));
        if (!lista.isEmpty()) {
            if (mode.equalsIgnoreCase("novo")) {
                int existe = JOptionPane.showConfirmDialog(rootPane, "<html><center>Este código já está sendo usado."
                    + "<br>Clique em SIM para modificar o registro,<br> ou NÃO para entra um novo código.<br>");
                if (existe == JOptionPane.YES_OPTION) {
                    limparCampos();
                    resetCampos();
                    instru = lista.get(0);
                    setarCampos(instru);
                    jButtonEditar.setEnabled(true);
                    jButtonExcluir.setEnabled(true);
                    jButtonNovo.setEnabled(!true);
                    jButtonSalvar.setEnabled(!true);
                    jButtonCancelar.setEnabled(true);
                    jButtonBuscar.setEnabled(!true);
                    jTextFieldPesquisar.setEnabled(!true);
                    jTextFieldCód.setEnabled(!true);
                    mode  = "editar";
                    e = 1;
                }
                if (existe == JOptionPane.NO_OPTION) {
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                }
            } else if (!mode.equalsIgnoreCase("novo")) {
                instru = lista.get(0);
                limparCampos();
                setarCampos(instru);
                jButtonNovo.setEnabled(!true);
                jButtonBuscar.setEnabled(!true);
                jButtonEditar.setEnabled(true);
                jButtonExcluir.setEnabled(true);
                jButtonSalvar.setEnabled(!true);
                jButtonCancelar.setEnabled(true);
                jTextFieldPesquisar.setEnabled(!true);
                jTextFieldCód.selectAll();
                jTextFieldCód.requestFocus();
            }
        } else if (lista.isEmpty()) {
            if (mode.equalsIgnoreCase("novo")) {
                if (!jTextFieldCód.getText().equalsIgnoreCase("") && jLabelImagem.getIcon() != null && 
                        jComboBoxItem.getSelectedIndex() != 0 && jComboBoxSetor.getSelectedIndex() != 0 &&
                        jComboBoxEspecialidade.getSelectedIndex() != 0 && !jTextFieldDescrição.getText().equalsIgnoreCase("")) {
                    if (serie == 0) {
                       instru = new Arsenal(); 
                    }
                    instru.setCod(Long.parseLong(jTextFieldCód.getText()));
                    instru.setItem((String) jComboBoxItem.getSelectedItem());
                    instru.setTipo((String) jComboBoxTipo.getSelectedItem());
                    instru.setEspecialidade((String) jComboBoxEspecialidade.getSelectedItem());
                    instru.setDescricao(jTextFieldDescrição.getText());
                    instru.setFantasia(jTextFieldFantasia.getText());
                    instru.setSetor((String) jComboBoxSetor.getSelectedItem());
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
                    instru.setOrientacao((String) jComboBoxOrientação.getSelectedItem());
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
                    if (serie == 1) {
                        instru.setId(null);
                        new ArsenalDAO().save(instru);
                        jTextFieldCód.setText("");
                        jTextFieldCód.setEnabled(true);
                        jTextFieldCód.requestFocus();
                        banco = null;
                        jButtonPrimeiro.setEnabled(!true);
                        jButtonAnterior.setEnabled(!true);
                        jButtonProximo.setEnabled(!true);
                        jButtonUltimo.setEnabled(!true);
                    } else {
                        new ArsenalDAO().save(instru);
                        limparCampos();
                        banco = null;
                        jButtonPrimeiro.setEnabled(!true);
                        jButtonAnterior.setEnabled(!true);
                        jButtonProximo.setEnabled(!true);
                        jButtonUltimo.setEnabled(!true);
                        jTextFieldCód.setText("");
                        jTextFieldCód.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Os campos iniciados com * são obrigatórios!");
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ítem não cadastrado. Clique em 'Novo' para iniciar o cadastro.");
                limparCampos();
                resetCampos();
                jTextFieldCód.setText("");
                jTextFieldCód.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limparCampos();
        resetCampos();
        mode = "buscar";
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        if (!mode.equalsIgnoreCase("novo")) {
            mode = "buscar";
        }
        if (jRadioButtonCatalogo.isSelected()) {
            buscarBanco(jTextFieldPesquisar.getText().trim());
        } else {
            buscarInstru(jTextFieldPesquisar.getText().trim());
        }
        limparCampos();
        if (tot != 0) {
            index = 0;
            if (jRadioButtonCatalogo.isSelected()) {
                setarBanco(banco.get(index));
            } else {
                setarCampos(lista.get(index));
                jButtonEditar.setEnabled(true);
                jButtonExcluir.setEnabled(true);
            }
            if (mode.equalsIgnoreCase("buscar")) {
                jTextFieldCód.setEnabled(!true);
            } else {
                jTextFieldCód.setEnabled(true);
                jButtonSalvar.setEnabled(true);
            }
            jTextFieldPesquisar.setText("");
            jButtonNovo.setEnabled(!true);
            jButtonCancelar.setEnabled(true);
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
            resetCampos();
        }
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    private void jButtonSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetorActionPerformed
        setor = new NovoSetor(this, true);
        setor.setVisible(true);
    }//GEN-LAST:event_jButtonSetorActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int excluir = JOptionPane.showConfirmDialog(rootPane, "O registro será excuído, continuar?");
        if (excluir == JOptionPane.YES_OPTION) {
            new ArsenalDAO().delete(instru.getId());
            limparCampos();
            resetCampos();
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jComboBoxSetorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSetorItemStateChanged
        if (mode.equalsIgnoreCase("editar") || mode.equalsIgnoreCase("novo") && serie == 0) {
            jButtonSalvar.setEnabled(true);
        } else {
            jButtonSalvar.setEnabled(!true);
        }
    }//GEN-LAST:event_jComboBoxSetorItemStateChanged

    private void jComboBoxItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxItemItemStateChanged
        if (mode.equalsIgnoreCase("editar") || mode.equalsIgnoreCase("novo") && serie == 0) {
            jButtonSalvar.setEnabled(true);
        } else {
            jButtonSalvar.setEnabled(!true);
        }
    }//GEN-LAST:event_jComboBoxItemItemStateChanged

    private void jTextFieldDescriçãoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescriçãoKeyTyped
        if (mode.equalsIgnoreCase("editar") || mode.equalsIgnoreCase("novo") && serie == 0) {
            jButtonSalvar.setEnabled(true);
        } else {
            jButtonSalvar.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldDescriçãoKeyTyped

    private void jCheckBoxSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSerieActionPerformed
        if (jCheckBoxSerie.isSelected()) {
            serie = 1;
            jButtonSalvar.setEnabled(!true);
        } else if (!jCheckBoxSerie.isSelected()) {
            jButtonSalvar.setEnabled(true);
            serie = 0;
        }
    }//GEN-LAST:event_jCheckBoxSerieActionPerformed

    private void jTextFieldFantasiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFantasiaKeyTyped
        if (mode.equalsIgnoreCase("editar") || mode.equalsIgnoreCase("novo") && serie == 0) {
            jButtonSalvar.setEnabled(true);
        } else {
            jButtonSalvar.setEnabled(!true);
        }
    }//GEN-LAST:event_jTextFieldFantasiaKeyTyped

    private void jComboBoxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoItemStateChanged
        if (mode.equalsIgnoreCase("editar") || mode.equalsIgnoreCase("novo") && serie == 0) {
            jButtonSalvar.setEnabled(true);
        } else {
            jButtonSalvar.setEnabled(!true);
        }
    }//GEN-LAST:event_jComboBoxTipoItemStateChanged

    private void jComboBoxEspecialidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEspecialidadeItemStateChanged
        if (mode.equalsIgnoreCase("editar") || mode.equalsIgnoreCase("novo") && serie == 0) {
            jButtonSalvar.setEnabled(true);
        } else {
            jButtonSalvar.setEnabled(!true);
        }
    }//GEN-LAST:event_jComboBoxEspecialidadeItemStateChanged

    private void jRadioButtonCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCatalogoActionPerformed
        limparCampos();
        resetCampos();
    }//GEN-LAST:event_jRadioButtonCatalogoActionPerformed

    private void jRadioButtonArsenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonArsenalActionPerformed
        limparCampos();
        resetCampos();
    }//GEN-LAST:event_jRadioButtonArsenalActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArsenalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            ArsenalView dialog = new ArsenalView(caditem, true);
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
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JButton jButtonSetor;
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
    private javax.swing.JCheckBox jCheckBoxSerie;
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
    private javax.swing.JComboBox<String> jComboBoxSetor;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonArsenal;
    private javax.swing.JRadioButton jRadioButtonCatalogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldComp;
    private javax.swing.JTextField jTextFieldCód;
    private javax.swing.JTextField jTextFieldDescrição;
    private javax.swing.JTextField jTextFieldDiametro;
    private javax.swing.JTextField jTextFieldFantasia;
    private javax.swing.JTextField jTextFieldLarguraA;
    private javax.swing.JTextField jTextFieldLarguraB;
    private javax.swing.JTextField jTextFieldOutro1;
    private javax.swing.JTextField jTextFieldOutro2;
    private javax.swing.JTextField jTextFieldOutro3;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldTamanho;
    // End of variables declaration//GEN-END:variables
}
