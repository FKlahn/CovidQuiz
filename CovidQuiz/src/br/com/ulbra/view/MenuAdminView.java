package br.com.ulbra.view;

import br.com.ulbra.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class MenuAdminView extends javax.swing.JFrame {

    private Usuario usuarioLogado;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MenuAdminView().setVisible(true));
    }

    public MenuAdminView() {
        carregaComponentes();
        getContentPane().setBackground(new java.awt.Color(27, 0, 115));

    }

    public MenuAdminView(Usuario usuario) {
        this.usuarioLogado = usuario;
        carregaComponentes();


    }

    private void carregaComponentes() {

        JPanel menuPanel = new JPanel();
        JButton botaoSair = new JButton();
        JLabel cadastroLabel1 = new JLabel();
        JButton autorizarPerguntasBotao = new JButton();
        JButton cadastrarAdminBotao = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Menu Admin");
        setResizable(false);

        menuPanel.setBackground(new java.awt.Color(35, 0, 149));
        menuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuPanel.setMinimumSize(new java.awt.Dimension(393, 355));
        menuPanel.setPreferredSize(new java.awt.Dimension(450, 450));

        Icon exit = new ImageIcon("src/br/com/ulbra/img/exit_to_app_white_24x24.png");
        botaoSair.setPreferredSize(new java.awt.Dimension(24, 24));
        botaoSair.setIcon(exit);
        botaoSair.setBorder(null);
        botaoSair.setBorderPainted(false);
        botaoSair.setContentAreaFilled(false);
        botaoSair.setFocusPainted(false);
        botaoSair.addActionListener(this::botaoSairActionPerformed);

        cadastroLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        cadastroLabel1.setForeground(new java.awt.Color(255, 255, 255));
        cadastroLabel1.setText("Bem vindo " +this.usuarioLogado.getNomeUsuario() + "!");

        autorizarPerguntasBotao.setBackground(new java.awt.Color(158, 128, 255));
        autorizarPerguntasBotao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
        autorizarPerguntasBotao.setForeground(new java.awt.Color(255, 255, 255));
        autorizarPerguntasBotao.setText("Autorizar perguntas");
        autorizarPerguntasBotao.addActionListener(this::autorizarPerguntasBotaoActionPerformed);

        cadastrarAdminBotao.setBackground(new java.awt.Color(158, 128, 255));
        cadastrarAdminBotao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
        cadastrarAdminBotao.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarAdminBotao.setText("Cadastrar Admin");
        cadastrarAdminBotao.addActionListener(this::cadastrarAdminBotaoActionPerformed);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addComponent(cadastroLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                                                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(autorizarPerguntasBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cadastrarAdminBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(81, 81, 81))))
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(cadastroLabel1)))
                                .addGap(94, 94, 94)
                                .addComponent(cadastrarAdminBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(autorizarPerguntasBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(181, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(35, Short.MAX_VALUE)
                                .addComponent(menuPanel, 440, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(menuPanel, 444, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().setBackground(new java.awt.Color(27, 0, 115));

        pack();
    }

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {
        MenuInicialView menuInicialView = new MenuInicialView();
        setVisible(false);
        menuInicialView.setVisible(true);
    }

    private void cadastrarAdminBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroAdminView cadastroAdminView = new CadastroAdminView(this.usuarioLogado);
        setVisible(false);
        cadastroAdminView.setVisible(true);
    }

    private void autorizarPerguntasBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        AutorizarPerguntasView autorizarPerguntasView = new AutorizarPerguntasView(this.usuarioLogado);
        setVisible(false);
        autorizarPerguntasView.setVisible(true);
    }


}

