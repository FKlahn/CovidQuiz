package br.com.ulbra.view;

import br.com.ulbra.controller.PerguntaController;
import br.com.ulbra.controller.UsuarioController;
import br.com.ulbra.model.Pergunta;
import br.com.ulbra.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorizarPerguntasView extends javax.swing.JFrame {

    private javax.swing.JButton autorizarBotao;
    private javax.swing.JButton negarBotao;
    private javax.swing.JTable perguntasTable;
    private DefaultTableModel model;
    private Usuario usuarioLogado;
    private Pergunta perguntaSelecionada;
    private static final int STATUS_NEGADA = 0;
    private static final int STATUS_APROVADA = 1;

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> new AutorizarPerguntasView().setVisible(true));
    }

    public AutorizarPerguntasView() {
        carregaComponentes();
        carregarDadosTabela();

    }

    public AutorizarPerguntasView(Usuario usuario) {
        this.usuarioLogado = usuario;
        carregaComponentes();
        carregarDadosTabela();
    }

    private void carregaComponentes() {

        JPanel cadastroPanel = new JPanel();
        JPanel acoesPanel = new JPanel();
        autorizarBotao = new javax.swing.JButton();
        negarBotao = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        perguntasTable = new javax.swing.JTable();
        JLabel tituloLabel = new JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Cadastro Pergunta");
        setResizable(false);

        cadastroPanel.setBackground(new java.awt.Color(35, 0, 149));
        cadastroPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadastroPanel.setMinimumSize(new java.awt.Dimension(393, 355));
        cadastroPanel.setPreferredSize(new java.awt.Dimension(450, 450));


        Icon botaoVoltarIcon = new ImageIcon("src/br/com/ulbra/img/arrow_back_white_24x24.png");
        javax.swing.JButton botaoVoltar = new javax.swing.JButton(botaoVoltarIcon);
        botaoVoltar.setBorder(null);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.addActionListener(this::voltarBotaoClick);

        acoesPanel.setBackground(new java.awt.Color(83, 29, 255));
        acoesPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        autorizarBotao.setBackground(new java.awt.Color(158, 128, 255));
        autorizarBotao.setText("Autorizar");
        autorizarBotao.setEnabled(false);
        autorizarBotao.addActionListener(this::autorizarBotaoClick);

        negarBotao.setBackground(new java.awt.Color(158, 128, 255));
        negarBotao.setText("Negar");
        negarBotao.setEnabled(false);
        negarBotao.addActionListener(this::negarBotaoClick);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(acoesPanel);
        acoesPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(autorizarBotao, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(negarBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(autorizarBotao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(negarBotao)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        perguntasTable.setBackground(new java.awt.Color(158, 128, 255));
        perguntasTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "IDPergunta", "Pergunta", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa Correta", "Dificuldade", "Usuario"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        perguntasTable.getColumnModel().removeColumn(perguntasTable.getColumn("IDPergunta"));
        perguntasTable.setGridColor(new java.awt.Color(0, 0, 0));
        perguntasTable.setSelectionBackground(new java.awt.Color(83, 29, 255));
        perguntasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perguntasTableMouseClicked();
            }
        });
        jScrollPane1.setViewportView(perguntasTable);

        tituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Covid Quiz - Autorizar perguntas");

        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(192, 192, 192)
                                                .addComponent(tituloLabel))
                                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                                .addComponent(acoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))
        );
        cadastroPanelLayout.setVerticalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tituloLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(acoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().setBackground(new java.awt.Color(27, 0, 115));

        pack();
    }

    private void voltarBotaoClick(java.awt.event.ActionEvent evt) {
        MenuAdminView menuAdminView = new MenuAdminView(this.usuarioLogado);
        setVisible(false);
        menuAdminView.setVisible(true);
    }

    private void autorizarBotaoClick(java.awt.event.ActionEvent evt) {
        String msg = "Autorizar a pergunta: " + perguntaSelecionada.getPergunta() + "(?)";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Autorização", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            perguntaSelecionada.setStatusPergunta(STATUS_APROVADA);
            atualizarPergunta();
            darPontosUsuario();
        }
    }

    private void negarBotaoClick(java.awt.event.ActionEvent evt) {
        String msg = "Negar a pergunta: " + perguntaSelecionada.getPergunta() + "(?)";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Negação", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            perguntaSelecionada.setStatusPergunta(STATUS_NEGADA);
            atualizarPergunta();
        }
    }

    private void perguntasTableMouseClicked() {
        this.autorizarBotao.setEnabled(true);
        this.negarBotao.setEnabled(true);
        this.perguntaSelecionada = new Pergunta();
        ListSelectionModel tableSelectionModel = perguntasTable.getSelectionModel();

        perguntasTable.setSelectionModel(tableSelectionModel);

        perguntaSelecionada.setId(Integer.parseInt(perguntasTable.getModel().getValueAt(perguntasTable.getSelectedRow(), 0).toString()));
        perguntaSelecionada.setPergunta(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 0).toString());
        perguntaSelecionada.setAlternativa1(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 1).toString());
        perguntaSelecionada.setAlternativa2(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 2).toString());
        perguntaSelecionada.setAlternativa3(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 3).toString());
        perguntaSelecionada.setAlternativaCorreta(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 4).toString());
        String dificuldade = perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 5).toString();
        perguntaSelecionada.setDificuldadePergunta(dificuldade.equals("FÁCIL") ? 1 : dificuldade.equals("MÉDIO") ? 2 : 3);
        perguntaSelecionada.setIdUsuario(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 6).toString());

    }

    private void atualizarPergunta() {
        PerguntaController perguntaController = new PerguntaController();
        try {
            if (perguntaController.atualizarPergunta(this.perguntaSelecionada)) {
                JOptionPane.showMessageDialog(null, "A pergunta " + perguntaSelecionada.getPergunta() + " foi Atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                model.removeRow(perguntasTable.getSelectedRow());
            }
        } catch (
                SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarDadosTabela() {
        try {
            PerguntaController perguntaController = new PerguntaController();
            ArrayList<Pergunta> perguntasEmAtualizacao = perguntaController.listarPerguntasAdmin();
            model = (DefaultTableModel) perguntasTable.getModel();
            for (Pergunta pergunta : perguntasEmAtualizacao) {
                model.addRow(new Object[]{
                        pergunta.getId(),
                        pergunta.getPergunta(),
                        pergunta.getAlternativa1(),
                        pergunta.getAlternativa2(),
                        pergunta.getAlternativa3(),
                        pergunta.getAlternativaCorreta(),
                        pergunta.getDificuldadePergunta() == 1 ? "FÁCIL" : pergunta.getDificuldadePergunta() == 2 ? "MÉDIO" : "DIFÍCIL",
                        pergunta.getIdUsuario()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void darPontosUsuario() {
        try {
            UsuarioController usuarioController = new UsuarioController();
            usuarioController.darPontosUsuario(perguntaSelecionada.getIdUsuario());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
