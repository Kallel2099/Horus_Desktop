package com.knowledge.horus.views;

//import Controle.Conexão;
//import Controle.Cme.UsuáriosSQL;
//import Controle.Sessão;
//import Modelos.Cme.UsuáriosMod;
//import Telas.Login;
import com.knowledge.horus.controls.Sessão;
import com.knowledge.horus.views.MenuReceber;
import java.awt.Graphics2D;
//import java.awt.Toolkit; //Necessário para mudar o icone da janela
//import java.awt.event.ActionEvent; //Necessário para exibir a hora num jLabel
//import java.awt.event.ActionListener; //Necessário para exibir a hora num jLabel
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
//import java.util.Calendar; //Necessário para exibir a hora num jLabel
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import javax.swing.Timer; //Necessário para exibir a hora num jLabel

public class Cme extends javax.swing.JFrame {

    //public static CarregarAuto car;
    //public static DescarregarAuto des;
    //public static Arsenal caditem;
    public static LeitorCódL lavar;
    //public static LeitorCódP preparar;
    public static MenuGerenciar gerir;
    public static MenuReceber rec;
    //public static MenuDescarr mdes;
    //public static Distribuição dist;
    int m = 0;
    //UsuáriosMod usu = new UsuáriosMod();
    //UsuáriosSQL u = new UsuáriosSQL();
    //Conexão conex = new Conexão();
    
    public Cme(String user) {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Barcode1.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        //Timer timer = new Timer(1000, new hora()); //Necessário para exibir a hora num jLabel
        //timer.start(); //Necessário para exibir a hora num jLabel
        jLabelUsuário.setText(Sessão.getLogado());
        jLabelNivel.setText(Sessão.getNivel());
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(Sessão.getFoto());
            BufferedImage imagem = ImageIO.read(is);
            int NovaLargura = 67, NovaAltura = 50;
            BufferedImage foto = new BufferedImage(NovaLargura, NovaAltura, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = foto.createGraphics();
            g.drawImage(imagem, 0, 0, NovaLargura, NovaAltura, null);
            jLabelFoto.setIcon(new ImageIcon(foto));
        } catch (IOException e){
            System.out.println("*********** Oooppsss!! ****************  " + e);
        }
    }
    
    private Cme() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
        //Timer timer = new Timer(1000, new hora()); //Necessário para exibir a hora num jLabel
        //timer.start(); //Necessário para exibir a hora num jLabel
        jLabelUsuário.setText("Programando");
        jLabelNivel.setText("Programador");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBarra = new javax.swing.JPanel();
        jLabelUsuário = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();
        jButtonReceber = new javax.swing.JButton();
        jButtonLavar = new javax.swing.JButton();
        jButtonPreparar = new javax.swing.JButton();
        jButtonEsterilizar = new javax.swing.JButton();
        jButtonArmazenar = new javax.swing.JButton();
        jButtonDistribuir = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonGerenciar = new javax.swing.JButton();
        jButtonAjuda = new javax.swing.JButton();
        jButtonLogof = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Horus - Rastreabilidade em Processos - Módulo CME");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("TelaPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBarra.setBackground(new java.awt.Color(0, 0, 0));
        jPanelBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanelBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 120, 110));

        jLabelUsuário.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUsuário.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabelUsuário, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, 100, 20));

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Foto.png"))); // NOI18N
        jLabelFoto.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabelFoto.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(jLabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, 50, 60));

        jLabelNivel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNivel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabelNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 40, 100, 20));

        jButtonReceber.setBackground(new java.awt.Color(200, 200, 200));
        jButtonReceber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonReceber.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Receber.png"))); // NOI18N
        jButtonReceber.setText("<html>Têxtil e<br />Consignados</html>");
        jButtonReceber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonReceber.setContentAreaFilled(false);
        jButtonReceber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonReceber.setOpaque(true);
        jButtonReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonReceberMouseEntered(evt);
            }
        });
        jButtonReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReceberActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jButtonLavar.setBackground(new java.awt.Color(180, 180, 180));
        jButtonLavar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLavar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLavar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Lavar.png"))); // NOI18N
        jButtonLavar.setText("Lavar");
        jButtonLavar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonLavar.setBorderPainted(false);
        jButtonLavar.setContentAreaFilled(false);
        jButtonLavar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonLavar.setOpaque(true);
        jButtonLavar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLavarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLavar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, 60));

        jButtonPreparar.setBackground(new java.awt.Color(160, 160, 160));
        jButtonPreparar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPreparar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPreparar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Preparar.png"))); // NOI18N
        jButtonPreparar.setText("Preparar");
        jButtonPreparar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonPreparar.setBorderPainted(false);
        jButtonPreparar.setContentAreaFilled(false);
        jButtonPreparar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonPreparar.setOpaque(true);
        jButtonPreparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrepararActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPreparar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 120, 60));

        jButtonEsterilizar.setBackground(new java.awt.Color(140, 140, 140));
        jButtonEsterilizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEsterilizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEsterilizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Esterilizar.png"))); // NOI18N
        jButtonEsterilizar.setText("Esterilizar");
        jButtonEsterilizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonEsterilizar.setBorderPainted(false);
        jButtonEsterilizar.setContentAreaFilled(false);
        jButtonEsterilizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonEsterilizar.setOpaque(true);
        jButtonEsterilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsterilizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEsterilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, 60));

        jButtonArmazenar.setBackground(new java.awt.Color(120, 120, 120));
        jButtonArmazenar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonArmazenar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonArmazenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Armazenar.png"))); // NOI18N
        jButtonArmazenar.setText("Armazenar");
        jButtonArmazenar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonArmazenar.setBorderPainted(false);
        jButtonArmazenar.setContentAreaFilled(false);
        jButtonArmazenar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonArmazenar.setOpaque(true);
        jButtonArmazenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArmazenarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonArmazenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 120, 60));

        jButtonDistribuir.setBackground(new java.awt.Color(100, 100, 100));
        jButtonDistribuir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDistribuir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDistribuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Distribuir.png"))); // NOI18N
        jButtonDistribuir.setText("Distribuir");
        jButtonDistribuir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonDistribuir.setBorderPainted(false);
        jButtonDistribuir.setContentAreaFilled(false);
        jButtonDistribuir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonDistribuir.setOpaque(true);
        jButtonDistribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDistribuirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDistribuir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 120, 60));

        jButtonBuscar.setBackground(new java.awt.Color(60, 60, 60));
        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Busca.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setContentAreaFilled(false);
        jButtonBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBuscar.setOpaque(true);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 120, 60));

        jButtonGerenciar.setBackground(new java.awt.Color(40, 40, 40));
        jButtonGerenciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonGerenciar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Config.png"))); // NOI18N
        jButtonGerenciar.setText("Gerenciar");
        jButtonGerenciar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonGerenciar.setBorderPainted(false);
        jButtonGerenciar.setContentAreaFilled(false);
        jButtonGerenciar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonGerenciar.setOpaque(true);
        jButtonGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGerenciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 120, 60));

        jButtonAjuda.setBackground(new java.awt.Color(80, 80, 80));
        jButtonAjuda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAjuda.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ajuda.png"))); // NOI18N
        jButtonAjuda.setText("Ajuda");
        jButtonAjuda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAjuda.setBorderPainted(false);
        jButtonAjuda.setContentAreaFilled(false);
        jButtonAjuda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonAjuda.setOpaque(true);
        jButtonAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjudaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAjuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 120, 60));

        jButtonLogof.setBackground(new java.awt.Color(20, 20, 20));
        jButtonLogof.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLogof.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logoff.png"))); // NOI18N
        jButtonLogof.setText("Logoff");
        jButtonLogof.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonLogof.setBorderPainted(false);
        jButtonLogof.setContentAreaFilled(false);
        jButtonLogof.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonLogof.setOpaque(true);
        jButtonLogof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogofActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogof, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 120, 60));

        jButtonSair.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setContentAreaFilled(false);
        jButtonSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonSair.setOpaque(true);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 120, 60));

        jLabelFundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Fundo.jpg"))); // NOI18N
        jLabelFundo.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabelFundo.setOpaque(true);
        jLabelFundo.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(1382, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceberActionPerformed
        jButtonReceber.setForeground(new java.awt.Color(255, 255, 0));
        jButtonReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Receber2.png")));
        rec = new MenuReceber(this, true);
        rec.setVisible(true);
        jButtonReceber.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Receber.png")));
    }//GEN-LAST:event_jButtonReceberActionPerformed

    private void jButtonLavarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLavarActionPerformed
        jButtonLavar.setForeground(new java.awt.Color(255, 255, 0));
        jButtonLavar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Lavar2.png")));
        int sair = JOptionPane.showConfirmDialog(rootPane, "<html><center>Foi realizada a substituição do detergente enzimático?<br>", "", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            
        }
        lavar = new LeitorCódL(this, true);
        lavar.setVisible(true);
        jButtonLavar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLavar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Lavar.png")));
    }//GEN-LAST:event_jButtonLavarActionPerformed

    private void jButtonPrepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrepararActionPerformed
        jButtonPreparar.setForeground(new java.awt.Color(255, 255, 0));
        jButtonPreparar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Preparar2.png")));
        //preparar = new LeitorCódP(this, true);
        //preparar.setVisible(true);
        jButtonPreparar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPreparar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Preparar.png")));
    }//GEN-LAST:event_jButtonPrepararActionPerformed

    private void jButtonEsterilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsterilizarActionPerformed
        jButtonEsterilizar.setForeground(new java.awt.Color(255, 255, 0));
        jButtonEsterilizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Esterilizar2.png")));
        //car = new CarregarAuto(this, true);
        //car.setVisible(true);
        jButtonEsterilizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEsterilizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Esterilizar.png")));
    }//GEN-LAST:event_jButtonEsterilizarActionPerformed

    private void jButtonArmazenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArmazenarActionPerformed
        jButtonArmazenar.setForeground(new java.awt.Color(255, 255, 0));
        jButtonArmazenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Armazenar2.png")));
        //mdes = new MenuDescarr (this, true);
        //mdes.setVisible(true);
        jButtonArmazenar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonArmazenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Armazenar.png")));
    }//GEN-LAST:event_jButtonArmazenarActionPerformed

    private void jButtonDistribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDistribuirActionPerformed
        jButtonDistribuir.setForeground(new java.awt.Color(255, 255, 0));
        jButtonDistribuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Distribuir2.png")));
        //dist = new Distribuição (this, true);
        //dist.setVisible(true);
        jButtonDistribuir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDistribuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Distribuir.png")));
    }//GEN-LAST:event_jButtonDistribuirActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarActionPerformed
        jButtonGerenciar.setForeground(new java.awt.Color(255, 255, 0));
        jButtonGerenciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Config2.png")));
        if (jLabelNivel.getText().intern().trim().equals("Administrador")) {
            gerir = new MenuGerenciar(this, true);
            gerir.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Somente administradores!\n");
        }
        jButtonGerenciar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Config.png")));
    }//GEN-LAST:event_jButtonGerenciarActionPerformed

    private void jButtonAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjudaActionPerformed
        //jButtonAjuda.setForeground(new java.awt.Color(255, 255, 0));
        //jButtonAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ajuda2.png")));
    }//GEN-LAST:event_jButtonAjudaActionPerformed

    private void jButtonLogofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogofActionPerformed
        Login log = new Login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonLogofActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        jButtonSair.setForeground(new java.awt.Color(255, 255, 0));
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair2.png")));
        int sair = JOptionPane.showConfirmDialog(rootPane, "<html><center>Deseja realmente sair do sistema?<br>", "", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        jButtonSair.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png")));
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonReceberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonReceberMouseEntered
        jButtonReceber.setToolTipText("<html>Receber têxteis para esterilização<br />ou material consignado</html>");
    }//GEN-LAST:event_jButtonReceberMouseEntered

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Cme().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjuda;
    private javax.swing.JButton jButtonArmazenar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonDistribuir;
    private javax.swing.JButton jButtonEsterilizar;
    private javax.swing.JButton jButtonGerenciar;
    private javax.swing.JButton jButtonLavar;
    private javax.swing.JButton jButtonLogof;
    private javax.swing.JButton jButtonPreparar;
    private javax.swing.JButton jButtonReceber;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelUsuário;
    private javax.swing.JPanel jPanelBarra;
    // End of variables declaration//GEN-END:variables

    /*private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/barcode3.png")));
    }*/
    
    /*class hora implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Calendar now = Calendar.getInstance();
            jLabelHora.setText(String.format("%1$tH:%1$tM", now));
            //jLabelHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }*/
}
