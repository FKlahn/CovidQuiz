package br.com.ulbra.view;

import br.com.ulbra.controller.UsuarioController;
import br.com.ulbra.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class RankingUsuariosView extends javax.swing.JFrame{

    private JList<String> rankingUsuariosList;
    private DefaultListModel<String> model = new DefaultListModel<>();
    Usuario usuarioLogado;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new RankingUsuariosView().setVisible(true));
    }

    public RankingUsuariosView() {
        carregaComponentes();
        atualizaRanking();
    }

    public RankingUsuariosView(Usuario usuario) {
        carregaComponentes();
        atualizaRanking();
        this.usuarioLogado = usuario;
    }

    private void atualizaRanking() {
        UsuarioController usuarioController = new UsuarioController();
        try {
            ArrayList<Usuario> ranking = usuarioController.rankearUsuarios();
            for(int i = 0; i < ranking.size(); i++) {
                this.model.addElement(i+1 + "º " + ranking.get(i).getNomeUsuario() + " Pontuação: " + ranking.get(i).getPontuacao());
            }
            this.rankingUsuariosList.setModel(this.model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                    "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaComponentes() {

        JPanel rankingPanel = new JPanel();
        JLabel tituloLabel = new JLabel();
        JScrollPane listaScrollPanel = new JScrollPane();
        rankingUsuariosList = new javax.swing.JList<>();
        Icon botaoVoltarIcon = new ImageIcon(getClass().getResource("/arrow_back_white_24x24.png"));
        javax.swing.JButton botaoVoltar = new javax.swing.JButton(botaoVoltarIcon);
        botaoVoltar.setBorder(null);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setFocusPainted(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Ranking Usuarios");
        setResizable(false);

        rankingPanel.setBackground(new java.awt.Color(35, 0, 149));
        rankingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tituloLabel.setBackground(new java.awt.Color(35, 0, 149));
        tituloLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36));
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Ranking");

        rankingUsuariosList.setBackground(new java.awt.Color(193, 174, 255));
        rankingUsuariosList.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        rankingUsuariosList.setForeground(new java.awt.Color(255, 255, 255));
        listaScrollPanel.setViewportView(rankingUsuariosList);

        botaoVoltar.addActionListener(this::botaoVoltarActionPerformed);

        javax.swing.GroupLayout rankingPanelLayout = new javax.swing.GroupLayout(rankingPanel);
        rankingPanel.setLayout(rankingPanelLayout);
        rankingPanelLayout.setHorizontalGroup(
                rankingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rankingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(rankingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(listaScrollPanel)
                                        .addGroup(rankingPanelLayout.createSequentialGroup()
                                                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(tituloLabel)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        rankingPanelLayout.setVerticalGroup(
                rankingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rankingPanelLayout.createSequentialGroup()
                                .addGroup(rankingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(rankingPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(tituloLabel))
                                        .addGroup(rankingPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(listaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(108, Short.MAX_VALUE)
                                .addComponent(rankingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rankingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
        );

        getContentPane().setBackground(new java.awt.Color(27,0,115));
        listaScrollPanel.getHorizontalScrollBar().setBackground(new Color(83,29,255));
        this.rankingUsuariosList.setSelectionBackground(new Color(158,128,255));

        pack();
    }

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        MenuUsuarioView menuUsuarioView = new MenuUsuarioView(this.usuarioLogado);
        setVisible(false);
        menuUsuarioView.setVisible(true);
    }

}
