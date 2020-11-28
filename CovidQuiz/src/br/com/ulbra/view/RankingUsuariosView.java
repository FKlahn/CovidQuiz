package br.com.ulbra.view;

import br.com.ulbra.controller.UsuarioController;
import br.com.ulbra.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class RankingUsuariosView extends javax.swing.JFrame{

    private javax.swing.JButton botaoVoltar;
    private javax.swing.JScrollPane listaScrollPanel;
    private javax.swing.JPanel rankingPanel;
    private JList<String> rankingUsuariosList;
    private javax.swing.JLabel tituloLabel;
    private DefaultListModel<String> model = new DefaultListModel<>();

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RankingUsuariosView().setVisible(true);
            }
        });
    }

    public RankingUsuariosView() {
        carregaComponentes();
        atualizaRanking();
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

    public RankingUsuariosView(Usuario usuario) {
        carregaComponentes();
    }

    private void carregaComponentes() {

        rankingPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        listaScrollPanel = new javax.swing.JScrollPane();
        rankingUsuariosList = new javax.swing.JList<>();
        botaoVoltar = new javax.swing.JButton();
        Icon botaoVoltarIcon = new ImageIcon("src/br/com/ulbra/img/arrow_back_white_24x24.png");
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
        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Ranking");

        rankingUsuariosList.setBackground(new java.awt.Color(193, 174, 255));
        rankingUsuariosList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rankingUsuariosList.setForeground(new java.awt.Color(255, 255, 255));
        listaScrollPanel.setViewportView(rankingUsuariosList);

        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

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
        this.listaScrollPanel.getHorizontalScrollBar().setBackground(new Color(83,29,255));
        this.rankingUsuariosList.setSelectionBackground(new Color(158,128,255));

        pack();
    }

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
