package br.com.ulbra.view;

import br.com.ulbra.controller.UsuarioController;
import br.com.ulbra.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class MenuUsuarioView extends javax.swing.JFrame {

    private javax.swing.JPanel configuracoesPanel;
    private boolean configVisivel = false;
    private javax.swing.JToggleButton dificuldadeToggle = new javax.swing.JToggleButton();
    private javax.swing.JToggleButton dicaToggle = new javax.swing.JToggleButton();
    private Icon selected = new ImageIcon("src/br/com/ulbra/img/done_white_18x18.png");
    private Icon notSelected = new ImageIcon("src/br/com/ulbra/img/close_white_18x18.png");
    private Icon closeConfig = new ImageIcon("src/br/com/ulbra/img/close_white_12x12.png");
    private Icon settings = new ImageIcon("src/br/com/ulbra/img/settings_white_24x24.png");
    private Icon exit = new ImageIcon("src/br/com/ulbra/img/exit_to_app_white_24x24.png");
    private Usuario usuarioLogado;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MenuUsuarioView().setVisible(true));
    }

    public MenuUsuarioView() {
        carregaComponentes();
        getContentPane().setBackground(new java.awt.Color(27,0,115));

    }

    public MenuUsuarioView(Usuario usuario) {
        this.usuarioLogado = usuario;
        carregaComponentes();
        getContentPane().setBackground(new java.awt.Color(27,0,115));
    }

    private void carregaComponentes() {

        javax.swing.JPanel userPanel = new javax.swing.JPanel();
        javax.swing.JButton botaoSair = new javax.swing.JButton();
        javax.swing.JButton botaoConfiguracoes = new javax.swing.JButton();
        configuracoesPanel = new javax.swing.JPanel();
        javax.swing.JButton botaoFecharConfig = new javax.swing.JButton();
        javax.swing.JButton salvarConfiguracoesBotao = new javax.swing.JButton();
        javax.swing.JLabel modoDificlLabel = new javax.swing.JLabel();
        javax.swing.JLabel dicaLabel = new javax.swing.JLabel();
        javax.swing.JLabel cadastroLabel = new javax.swing.JLabel();
        javax.swing.JLabel cadastroLabel1 = new javax.swing.JLabel();
        javax.swing.JButton cadastroPerguntaBotao = new javax.swing.JButton();
        javax.swing.JButton novoJogoBotao = new javax.swing.JButton();
        javax.swing.JButton rankingButton = new javax.swing.JButton();

        botaoFecharConfig.setIcon(closeConfig);
        botaoFecharConfig.setBorder(null);
        botaoFecharConfig.setBorderPainted(false);
        botaoFecharConfig.setContentAreaFilled(false);
        botaoFecharConfig.setFocusPainted(false);

        botaoConfiguracoes.setIcon(settings);
        botaoConfiguracoes.setBorder(null);
        botaoConfiguracoes.setBorderPainted(false);
        botaoConfiguracoes.setContentAreaFilled(false);
        botaoConfiguracoes.setFocusPainted(false);

        botaoSair.setIcon(exit);
        botaoSair.setBorder(null);
        botaoSair.setBorderPainted(false);
        botaoSair.setContentAreaFilled(false);
        botaoSair.setFocusPainted(false);

        dicaToggle.setContentAreaFilled(false);
        dicaToggle.setFocusPainted(false);

        dificuldadeToggle.setContentAreaFilled(false);
        dificuldadeToggle.setFocusPainted(false);


        this.configuracoesPanel.setVisible(configVisivel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Menu Usuário");
        setResizable(false);

        userPanel.setBackground(new java.awt.Color(35, 0, 149));
        userPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userPanel.setMinimumSize(new java.awt.Dimension(393, 355));
        userPanel.setPreferredSize(new java.awt.Dimension(450, 450));

        botaoSair.setPreferredSize(new java.awt.Dimension(24, 24));
        botaoSair.addActionListener(this::botaoSairActionPerformed);

        botaoConfiguracoes.setPreferredSize(new java.awt.Dimension(24, 24));
        botaoConfiguracoes.addActionListener(this::botaoConfiguracoesActionPerformed);

        configuracoesPanel.setBackground(new java.awt.Color(158, 128, 255));

        botaoFecharConfig.setPreferredSize(new java.awt.Dimension(18, 18));
        botaoFecharConfig.addActionListener(this::botaoFecharConfigActionPerformed);

        salvarConfiguracoesBotao.setText("Salvar");
        salvarConfiguracoesBotao.addActionListener(this::salvarConfiguracoesBotaoActionPerformed);

        dificuldadeToggle.setPreferredSize(new java.awt.Dimension(24, 24));
        dificuldadeToggle.addActionListener(this::dificuldadeToggleActionPerformed);

        dicaToggle.setPreferredSize(new java.awt.Dimension(24, 24));
        dicaToggle.addActionListener(this::dicaToggleActionPerformed);

        modoDificlLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        modoDificlLabel.setForeground(new java.awt.Color(255, 255, 255));
        modoDificlLabel.setText("Modo difícil:");

        dicaLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        dicaLabel.setForeground(new java.awt.Color(255, 255, 255));
        dicaLabel.setText("Dica ativa:");

        javax.swing.GroupLayout configuracoesPanelLayout = new javax.swing.GroupLayout(configuracoesPanel);
        configuracoesPanel.setLayout(configuracoesPanelLayout);
        configuracoesPanelLayout.setHorizontalGroup(
                configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracoesPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoFecharConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracoesPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracoesPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(modoDificlLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dificuldadeToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracoesPanelLayout.createSequentialGroup()
                                                .addComponent(dicaLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dicaToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(configuracoesPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(salvarConfiguracoesBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        configuracoesPanelLayout.setVerticalGroup(
                configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(configuracoesPanelLayout.createSequentialGroup()
                                .addComponent(botaoFecharConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dificuldadeToggle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(modoDificlLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dicaToggle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dicaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salvarConfiguracoesBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                                .addContainerGap())
        );

        cadastroLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        cadastroLabel.setForeground(new java.awt.Color(255, 255, 255));
        cadastroLabel.setText("Sua Pontuação: " + this.usuarioLogado.getPontuacao());

        cadastroLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        cadastroLabel1.setForeground(new java.awt.Color(255, 255, 255));
        cadastroLabel1.setText("Bem vindo "+ this.usuarioLogado.getNomeUsuario() + "!");

        cadastroPerguntaBotao.setBackground(new java.awt.Color(158, 128, 255));
        cadastroPerguntaBotao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        cadastroPerguntaBotao.setForeground(new java.awt.Color(255, 255, 255));
        cadastroPerguntaBotao.setText("Cadastrar Pergunta");
        cadastroPerguntaBotao.addActionListener(this::cadastroPerguntaBotaoActionPerformed);

        novoJogoBotao.setBackground(new java.awt.Color(158, 128, 255));
        novoJogoBotao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        novoJogoBotao.setForeground(new java.awt.Color(255, 255, 255));
        novoJogoBotao.setText("Novo Jogo");
        novoJogoBotao.addActionListener(this::novoJogoBotaoActionPerformed);

        rankingButton.setBackground(new java.awt.Color(158, 128, 255));
        rankingButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        rankingButton.setForeground(new java.awt.Color(255, 255, 255));
        rankingButton.setText("Ranking");
        rankingButton.addActionListener(this::rankingButtonActionPerformed);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addComponent(cadastroLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botaoConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(cadastroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                                .addComponent(configuracoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rankingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cadastroPerguntaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85))
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                        .addContainerGap(118, Short.MAX_VALUE)
                                        .addComponent(novoJogoBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botaoConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(configuracoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(cadastroLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cadastroLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(rankingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cadastroPerguntaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                        .addContainerGap(210, Short.MAX_VALUE)
                                        .addComponent(novoJogoBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(192, 192, 192)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(35, Short.MAX_VALUE)
                                .addComponent(userPanel, 440, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(userPanel, 444, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        ajustaConfiguracoes();

        pack();
    }

    private void ajustaConfiguracoes() {
        if(this.usuarioLogado.getSempreDificil() == 1) {
            this.dificuldadeToggle.setSelected(true);
            this.dificuldadeToggle.setIcon(this.selected);
            this.dificuldadeToggle.setBackground(Color.green);
        } else {
            this.dificuldadeToggle.setSelected(false);
            this.dificuldadeToggle.setIcon(this.notSelected);
            this.dificuldadeToggle.setBackground(Color.red);
        }

        if(this.usuarioLogado.getDicaAtiva() == 1) {
            this.dicaToggle.setSelected(true);
            this.dicaToggle.setIcon(this.selected);
            this.dicaToggle.setBackground(Color.green);
        } else {
            this.dicaToggle.setSelected(false);
            this.dicaToggle.setIcon(this.notSelected);
            this.dicaToggle.setBackground(Color.red);
        }
    }

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {
        MenuInicialView menuInicialView = new MenuInicialView();
        setVisible(false);
        menuInicialView.setVisible(true);
    }

    private void botaoConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {
        this.configVisivel = !this.configVisivel;
        this.configuracoesPanel.setVisible(this.configVisivel);
    }

    private void botaoFecharConfigActionPerformed(java.awt.event.ActionEvent evt) {
        this.configVisivel = !this.configVisivel;
        this.configuracoesPanel.setVisible(this.configVisivel);
    }

    private void salvarConfiguracoesBotaoActionPerformed(java.awt.event.ActionEvent evt) {
            this.usuarioLogado.setSempreDificil(this.dificuldadeToggle.isSelected() ? 1 : 0);
            this.usuarioLogado.setDicaAtiva(this.dicaToggle.isSelected() ? 1 : 0);

        UsuarioController usuarioController = new UsuarioController();
        if(usuarioController.atualizar(usuarioLogado)) {
            JOptionPane.showMessageDialog(null, "Configurações atualizadas com sucesso! ");
            this.configVisivel = !this.configVisivel;
            this.configuracoesPanel.setVisible(this.configVisivel);
        }

    }

    private void dificuldadeToggleActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.dificuldadeToggle.isSelected()) {
            this.dificuldadeToggle.setIcon(this.selected);
            this.dificuldadeToggle.setBackground(Color.green);
        } else {
            this.dificuldadeToggle.setIcon(this.notSelected);
            this.dificuldadeToggle.setBackground(Color.red);
        }
    }

    private void dicaToggleActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.dicaToggle.isSelected()) {
            this.dicaToggle.setIcon(this.selected);
            this.dicaToggle.setBackground(Color.green);
        } else {
            this.dicaToggle.setIcon(this.notSelected);
            this.dicaToggle.setBackground(Color.red);
        }
    }

    private void novoJogoBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void rankingButtonActionPerformed(java.awt.event.ActionEvent evt) {
        RankingUsuariosView rankingUsuariosView = new RankingUsuariosView(this.usuarioLogado);
        setVisible(false);
        rankingUsuariosView.setVisible(true);
    }

    private void cadastroPerguntaBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroPerguntaView cadastroPerguntaView = new CadastroPerguntaView(this.usuarioLogado);
        setVisible(false);
        cadastroPerguntaView.setVisible(true);
    }

}
