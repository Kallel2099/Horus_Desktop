package com.knowledge.horus.views;

//import Controle.Cme.MovimentSQL;
//import Controle.Conexão;
//import Controle.Sessão;
//import Modelos.Cme.MovimentMod;
import com.knowledge.horus.controls.Sessão;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Detergente extends javax.swing.JDialog {
    
    //Conexão conex = new Conexão();
    //MovimentMod moviment = new MovimentMod();
    //MovimentSQL mov = new MovimentSQL();
    public static NovoProduto prod;
    
    java.util.Date dt_atual = new java.util.Date();        
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Detergente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buscarNome();
        if (Sessão.getNivel() != null && Sessão.getNivel().contains("Usuário")) {
            jButtonNovoProduto.setEnabled(!true);
        }
    }
    
    public void buscarNome(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Produto' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxNome.removeAllItems();
            do{
                jComboBoxNome.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBox\n" + ex.getMessage());
        }
        conex.desconectar();
    }
    
    public boolean data(String data) {
        try {
            sdf.setLenient(false);
            sdf.parse(data);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldLote = new javax.swing.JTextField();
        jComboBoxNome = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jFormattedTextValid = new javax.swing.JFormattedTextField();
        jButtonNovoProduto = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldLote.setNextFocusableComponent(jFormattedTextValid);
        jTextFieldLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLoteActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 110, -1));

        jComboBoxNome.setNextFocusableComponent(jTextFieldLote);
        jComboBoxNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxNomeItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 180, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lote");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Validade");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Substituir Detergente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 20));

        jButtonSalvar.setBackground(new java.awt.Color(200, 200, 200));
        jButtonSalvar.setForeground(new java.awt.Color(70, 70, 70));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSalvar.setContentAreaFilled(false);
        jButtonSalvar.setNextFocusableComponent(jButtonSair);
        jButtonSalvar.setOpaque(true);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 75, 23));

        jButtonSair.setBackground(new java.awt.Color(200, 200, 200));
        jButtonSair.setForeground(new java.awt.Color(70, 70, 70));
        jButtonSair.setText("Sair");
        jButtonSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSair.setContentAreaFilled(false);
        jButtonSair.setNextFocusableComponent(jComboBoxNome);
        jButtonSair.setOpaque(true);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 75, 23));

        try {
            jFormattedTextValid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextValid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextValid.setToolTipText("");
        jFormattedTextValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextValidActionPerformed(evt);
            }
        });
        getContentPane().add(jFormattedTextValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 70, -1));

        jButtonNovoProduto.setText("...");
        jButtonNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 30, 23));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 300, 160));

        setSize(new java.awt.Dimension(290, 162));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        moviment.setDesc((String) jComboBoxNome.getSelectedItem());
        moviment.setValid(jFormattedTextValid.getText().intern().trim());
        moviment.setNumlote(jTextFieldLote.getText());
        moviment.setData(sdf.format(dt_atual));
        mov.SalvarInsumo(moviment);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNomeItemStateChanged
        jTextFieldLote.requestFocus();
    }//GEN-LAST:event_jComboBoxNomeItemStateChanged

    private void jTextFieldLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLoteActionPerformed
        jFormattedTextValid.requestFocus();
    }//GEN-LAST:event_jTextFieldLoteActionPerformed

    private void jFormattedTextValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextValidActionPerformed
        String validar = jFormattedTextValid.getText();
        data(validar);
        if (data(validar) == !true){
            JOptionPane.showMessageDialog(rootPane, "Formato de data incorreto!");
            jFormattedTextValid.setValue(null);
            jFormattedTextValid.requestFocus();
        } else if (dataMenorQueHoje(validar)) {
            JOptionPane.showMessageDialog(rootPane, "Produto vencido!");
            jFormattedTextValid.setValue(null);
            jFormattedTextValid.requestFocus();
        } else {
            jButtonSalvar.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextValidActionPerformed

    private void jButtonNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoProdutoActionPerformed
        prod = new NovoProduto(this, true);
        prod.setVisible(true);
    }//GEN-LAST:event_jButtonNovoProdutoActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Detergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detergente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detergente dialog = new Detergente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonNovoProduto;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxNome;
    private javax.swing.JFormattedTextField jFormattedTextValid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JTextField jTextFieldLote;
    // End of variables declaration//GEN-END:variables
}
