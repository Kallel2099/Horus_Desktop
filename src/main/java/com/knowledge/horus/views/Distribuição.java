package com.knowledge.horus.views;

import Controle.Cme.MovimentSQL;
import Controle.Conexão;
import Controle.Sessão;
import Modelos.Cme.MovimentMod;
import Telas.ImpressEtiq;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Distribuição extends javax.swing.JDialog {

    Conexão conex = new Conexão();
    MovimentMod moviment = new MovimentMod();
    MovimentSQL mov = new MovimentSQL();
    int rows1 = 0;
    int rows2 = 0;
    String ini = "";
    String fim = "";
    public static Cme dist;
    java.util.Date dt_atual = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel Tabela1;
    DefaultTableModel Tabela2;
    
    public Distribuição(Cme parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextFieldOp.setText(Sessão.getLogado());
        moviment.setQuery("SELECT * FROM movimentação WHERE status = 'Arsenal-CME' AND concluido IS NULL");
        MovimentMod model = mov.Buscar2(moviment);
        Tabela1 = (DefaultTableModel) jTable1.getModel();
        Tabela2 = (DefaultTableModel) jTable2.getModel();
        rows2 = Tabela2.getRowCount();
        int r = model.getR();
        model.setPos(1);
        for (int i = 0; i < r; i++) {
            model = mov.Buscar2(moviment);
            Object[] dados = {model.getCodigo(), model.getDesc()};
            Tabela2.addRow(dados);
            model.setPos(i + 2);
        }
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        buscarSetor();
        jComboBoxSetor.requestFocus();
    }
    
    public void buscarSetor(){
        conex.conectar();
        conex.execSql("SELECT descrição FROM combobox WHERE uso = 'Setor' ORDER BY descrição");
        try {
            conex.rs.first();
            jComboBoxSetor.removeAllItems();
            do{
                jComboBoxSetor.addItem(conex.rs.getString("descrição"));
            }
            while (conex.rs.next());
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html><center>Erro ao preencher ComboBox<br>" + ex.getMessage());
        }
        conex.desconectar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonSair = new javax.swing.JButton();
        jTextFieldOp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldItens = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCód = new javax.swing.JTextField();
        jButtonConcluir = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonDevolver = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxSetor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ));
        jTable2.setEnabled(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(80);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 370, 490));

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, 75, 23));

        jTextFieldOp.setEnabled(false);
        getContentPane().add(jTextFieldOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 120, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Operador:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 60, 20));

        jTextFieldItens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldItens.setEnabled(false);
        getContentPane().add(jTextFieldItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 570, 35, 23));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("N° de ítens:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, 60, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Setor", "Data e Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(80);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(110);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 500, 490));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Distribuir material estéril");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Código do Ítem:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 20));

        jTextFieldCód.setEnabled(false);
        jTextFieldCód.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCódActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCód, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 150, -1));

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 75, 23));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setEnabled(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 75, 23));

        jButtonDevolver.setText("Devolver");
        jButtonDevolver.setEnabled(false);
        jButtonDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDevolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 75, 23));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Amazenado na C.M.E.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 370, 30));

        jComboBoxSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 190, 23));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Destino:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 40, 20));

        jLabelFundo.setBackground(new java.awt.Color(153, 153, 153));
        jLabelFundo.setOpaque(true);
        getContentPane().add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        setBounds(125, 90, 900, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCódActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCódActionPerformed
        rows1 = Tabela1.getRowCount();
        rows2 = Tabela2.getRowCount();
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < rows2; i++) {
            if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela2.getValueAt(i, 0)).intern().trim())){
                Object[] conteúdo = {Tabela2.getValueAt(i, 0), Tabela2.getValueAt(i, 1),
                    jComboBoxSetor.getSelectedItem(), sdf.format(dt_atual)};
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
                if (jTextFieldCód.getText().intern().trim().equals(((String) Tabela1.getValueAt(i, 0)).intern().trim())){
                    JOptionPane.showMessageDialog(null, "<html><center>Material já adicionado!<br>");
                    jTextFieldCód.setText("");
                    jTextFieldCód.requestFocus();
                } else {
                    t1++;
                }
            }
        }
        if (t2 == rows2 && t1 == rows1) {
            JOptionPane.showMessageDialog(null, "<html><center>Este material não consta na lista de"
                    + " materiais armazenados na C.M.E.!<br>");
            jTextFieldCód.setText("");
            jTextFieldCód.requestFocus();
        }
        rows2 = Tabela2.getRowCount();
        if (rows2 == 0) {
            jTextFieldCód.setEnabled(!true);
            jComboBoxSetor.setSelectedIndex(0);
            jComboBoxSetor.setEnabled(!true);
            jButtonConcluir.setEnabled(true);
            jButtonConcluir.requestFocus();
        }
        jTextFieldCód.setText("");
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        jButtonConcluir.setEnabled(true);
        jButtonDevolver.setEnabled(true);
        jButtonLimpar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldCódActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        int r = Tabela1.getRowCount();
        for (int i = 0; i < r; i++) {
            moviment.setPos(0);
            moviment.setQuery("SELECT * FROM movimentação WHERE codigo = '"+(String) Tabela1.getValueAt(i, 0)+"'"
                    + " AND status = 'Arsenal-CME' AND concluido IS NULL");
            MovimentMod model = mov.Buscar2(moviment);
            moviment.setCodigo((String) jTable1.getValueAt(i, 0));
            moviment.setDesc((String) jTable1.getValueAt(i, 1));
            moviment.setSetor((String) jTable1.getValueAt(i, 2));
            moviment.setData((String) jTable1.getValueAt(i, 3));
            moviment.setId(model.getId().intern().trim());
            moviment.setLote(model.getLote());
            moviment.setCiclo(model.getCiclo());
            moviment.setOp(jTextFieldOp.getText());
            moviment.setFim(model.getFim().intern().trim());
            moviment.setInicio(model.getInicio().intern().trim());
            moviment.setMetodo("Esterilização à vapor");
            moviment.setStatus("Em Transito");
            moviment.setProcess(model.getProcess().intern().trim());
            moviment.setValid(model.getValid().intern().trim());
            moviment.setPrazo(model.getPrazo());
            moviment.setEmba(model.getEmba().intern().trim());
            moviment.setIntegri(model.getIntegri().intern().trim());
            moviment.setHumid(model.getHumid().intern().trim());
            moviment.setIntegra(model.getIntegra().intern().trim());
            moviment.setSelag(model.getSelag().intern().trim());
            moviment.setIdent(model.getIdent().intern().trim());
            moviment.setQtd(r);
            mov.Salvar(moviment);
            model.setPos(i + 2);
            moviment.setConcluido("Sim");
            moviment.setQuery("UPDATE movimentação SET concluido = ? WHERE codigo = '"+moviment.getCodigo()+"' AND status = 'Arsenal-CME'");
            mov.Concluir(moviment);
        }
        if (Tabela1.getRowCount() != 0) {
            while ( 0 != jTable1.getRowCount()){
                Tabela1.removeRow(0);
            }
        }
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        jButtonConcluir.setEnabled(!true);
        jButtonDevolver.setEnabled(!true);
        jTextFieldCód.setEnabled(!true);
        jComboBoxSetor.setEnabled(true);
        jComboBoxSetor.setSelectedIndex(0);
        jComboBoxSetor.requestFocus();
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        if (Tabela1.getRowCount() != 0) {
            int sair = JOptionPane.showConfirmDialog(rootPane, "<html><center><br>Cancelar a destribuição de material?<br /><html />");
            if (sair == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldCód.setText("");
        jTextFieldCód.setEnabled(!true);
        while ( 0 != jTable1.getRowCount()){
            Object[] conteúdo = {Tabela1.getValueAt(0, 0), Tabela1.getValueAt(0, 1)};
            Tabela2.addRow(conteúdo);
            Tabela1.removeRow(0);
        }
        jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
        jButtonLimpar.setEnabled(!true);
        jButtonConcluir.setEnabled(!true);
        jButtonDevolver.setEnabled(!true);
        jComboBoxSetor.setEnabled(true);
        jComboBoxSetor.setSelectedIndex(0);
        jTextFieldCód.setEnabled(true);
        jTextFieldCód.requestFocus();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDevolverActionPerformed
        int r = jTable1.getSelectedRowCount();
        if (r != 0) {
            for (int i = 0; i < r; i++) {
                int Dev = jTable1.getSelectedRow();
                Object[] conteúdo = {Tabela1.getValueAt(Dev, 0), Tabela1.getValueAt(Dev, 1)};
                Tabela2.addRow(conteúdo);
                Tabela1.removeRow(Dev);
                jTextFieldItens.setText(String.valueOf(Tabela2.getRowCount()));
            }
            jTextFieldCód.requestFocus();
            if (jTable1.getRowCount() == 0) {
                jButtonConcluir.setEnabled(!true);
                jButtonDevolver.setEnabled(!true);
                jButtonLimpar.setEnabled(!true);
                jComboBoxSetor.setEnabled(true);
                jTextFieldCód.setEnabled(true);
                jTextFieldCód.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonDevolverActionPerformed

    private void jComboBoxSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetorActionPerformed
        if (jComboBoxSetor.getSelectedIndex() > 0) {
            jTextFieldCód.setEnabled(true);
            jTextFieldCód.requestFocus();
        } else {
            jTextFieldCód.setEnabled(!true);
        }
    }//GEN-LAST:event_jComboBoxSetorActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Distribuição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Distribuição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Distribuição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Distribuição.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Distribuição dialog = new Distribuição (dist, true);
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
    private javax.swing.JButton jButtonDevolver;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldCód;
    private javax.swing.JTextField jTextFieldItens;
    private javax.swing.JTextField jTextFieldOp;
    // End of variables declaration//GEN-END:variables
}
