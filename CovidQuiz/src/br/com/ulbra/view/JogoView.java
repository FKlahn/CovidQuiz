package br.com.ulbra.view;

import br.com.ulbra.controller.PerguntaController;
import br.com.ulbra.controller.UsuarioController;
import br.com.ulbra.model.Pergunta;
import br.com.ulbra.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Random;

public class JogoView extends javax.swing.JFrame {

    private Icon botaoVoltarIcon = new ImageIcon(getClass().getResource("/arrow_back_white_24x24.png"));
    private Icon botaoCartasIcon = new ImageIcon(getClass().getResource("/poker-cards.png"));
    private Icon botaoUniversitarios = new ImageIcon(getClass().getResource("/people_white_24x24.png"));
    private javax.swing.JButton voltarBotao = new javax.swing.JButton(botaoVoltarIcon);
    private javax.swing.JPanel cadastroPanel = new javax.swing.JPanel();
    private javax.swing.JPanel perguntaPanel = new javax.swing.JPanel();
    private javax.swing.JButton alternativa1Botao = new javax.swing.JButton();
    private javax.swing.JButton alternativa3Botao = new javax.swing.JButton();
    private javax.swing.JButton alternativa2Botao = new javax.swing.JButton();
    private javax.swing.JButton alternativaCorretaBotao = new javax.swing.JButton();
    private javax.swing.JButton cartasBotao = new javax.swing.JButton(botaoCartasIcon);
    private javax.swing.JButton universitariosBotao = new javax.swing.JButton(botaoUniversitarios);
    private javax.swing.JLabel holderLabel = new javax.swing.JLabel();
    private javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    private JTextArea perguntaTextArea = new JTextArea();
    private javax.swing.JButton proximaPerguntaBotao = new javax.swing.JButton();
    private javax.swing.JButton voltarAoMenuBotao = new javax.swing.JButton();
    private javax.swing.JLabel descricaoDicasLabel = new javax.swing.JLabel();
    private javax.swing.JLabel dicasLabel = new javax.swing.JLabel();
    private javax.swing.JLabel usuarioLabel = new javax.swing.JLabel();
    private javax.swing.JLabel pontuacaoLabel = new javax.swing.JLabel();

    private Usuario usuarioLogado;
    private Pergunta perguntaCarregada;
    private static final int CUSTO_DICA_CARTAS = 15;
    private static final int CUSTO_DICA_UNIVERSITARIOS = 25;
    private static final int PONTOS_RESPOSTA_CORRETA = 40;
    private boolean isDicaCartasUsada = false;
    private boolean isDicaUniversitariosUsada = false;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new JogoView().setVisible(true));
    }

    public JogoView() {
        carregaComponentes();
    }

    public JogoView(Usuario usuario) {
        this.usuarioLogado = usuario;
        carregaComponentes();
    }

    private void carregaComponentes() {

        carregarPergunta();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Quiz");
        setResizable(false);

        cadastroPanel.setBackground(new java.awt.Color(35, 0, 149));
        cadastroPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadastroPanel.setMinimumSize(new java.awt.Dimension(393, 355));
        cadastroPanel.setPreferredSize(new java.awt.Dimension(450, 450));


        voltarBotao.setBorder(null);
        voltarBotao.setBorderPainted(false);
        voltarBotao.setContentAreaFilled(false);
        voltarBotao.setFocusPainted(false);
        voltarBotao.addActionListener(this::voltarBotaoClick);

        perguntaPanel.setBackground(new java.awt.Color(83, 29, 255));
        perguntaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, this.perguntaCarregada.getDificuldadePergunta() == 1 ? "FÁCIL" : this.perguntaCarregada.getDificuldadePergunta() == 2 ? "MÉDIO" : "DIFÍCIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", Font.PLAIN, 24), this.perguntaCarregada.getDificuldadePergunta() == 1 ? Color.GREEN : this.perguntaCarregada.getDificuldadePergunta() == 2 ? Color.YELLOW : Color.RED));
        perguntaPanel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));

        alternativa1Botao.setBackground(new java.awt.Color(158, 128, 255));
        alternativa1Botao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        alternativa1Botao.setForeground(new java.awt.Color(255, 255, 255));
        alternativa1Botao.setText(this.perguntaCarregada.getAlternativa1());
        alternativa1Botao.addActionListener(evt2 -> alternativa1BotaoClick());

        alternativa3Botao.setBackground(new java.awt.Color(158, 128, 255));
        alternativa3Botao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        alternativa3Botao.setForeground(new java.awt.Color(255, 255, 255));
        alternativa3Botao.setText(this.perguntaCarregada.getAlternativa3());
        alternativa3Botao.addActionListener(this::alternativa3BotaoClick);

        alternativa2Botao.setBackground(new java.awt.Color(158, 128, 255));
        alternativa2Botao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        alternativa2Botao.setForeground(new java.awt.Color(255, 255, 255));
        alternativa2Botao.setText(this.perguntaCarregada.getAlternativa2());
        alternativa2Botao.addActionListener(evt1 -> alternativa2BotaoClick());

        alternativaCorretaBotao.setBackground(new java.awt.Color(158, 128, 255));
        alternativaCorretaBotao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        alternativaCorretaBotao.setForeground(new java.awt.Color(255, 255, 255));
        alternativaCorretaBotao.setText(this.perguntaCarregada.getAlternativaCorreta());
        alternativaCorretaBotao.addActionListener(evt -> alternativaCorretaBotaoClick());

        cartasBotao.setBorder(null);
        cartasBotao.setBorderPainted(false);
        cartasBotao.setContentAreaFilled(false);
        cartasBotao.setFocusPainted(false);
        cartasBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartasBotaoMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartasBotaoMouseExited();
            }
        });
        cartasBotao.addActionListener(this::cartasBotaoClick);


        universitariosBotao.setBorder(null);
        universitariosBotao.setBorderPainted(false);
        universitariosBotao.setContentAreaFilled(false);
        universitariosBotao.setFocusPainted(false);
        universitariosBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                universitariosBotaoMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                universitariosBotaoMouseExited();
            }
        });
        universitariosBotao.addActionListener(this::universitariosBotaoClick);

        perguntaTextArea.setEditable(false);
        perguntaTextArea.setBackground(new java.awt.Color(158, 128, 255));
        perguntaTextArea.setColumns(20);
        perguntaTextArea.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        perguntaTextArea.setForeground(new java.awt.Color(255, 255, 255));
        perguntaTextArea.setRows(5);
        perguntaTextArea.setText(this.perguntaCarregada.getPergunta());
        jScrollPane1.setViewportView(perguntaTextArea);

        proximaPerguntaBotao.setBackground(new java.awt.Color(158, 128, 255));
        proximaPerguntaBotao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        proximaPerguntaBotao.setText("Proxima pergunta");
        proximaPerguntaBotao.setEnabled(false);
        proximaPerguntaBotao.addActionListener(this::proximaPerguntaBotaoClick);

        voltarAoMenuBotao.setBackground(new java.awt.Color(158, 128, 255));
        voltarAoMenuBotao.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        voltarAoMenuBotao.setForeground(new java.awt.Color(255, 255, 255));
        voltarAoMenuBotao.setText("Voltar ao menu");
        voltarAoMenuBotao.setEnabled(false);
        voltarAoMenuBotao.addActionListener(evt -> voltarAoMenuBotaoClick());

        descricaoDicasLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        descricaoDicasLabel.setForeground(new java.awt.Color(255, 255, 255));

        dicasLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        dicasLabel.setForeground(new java.awt.Color(255, 255, 255));

        int preset = gerarvalorRandomico(3);
        switch (preset) {
            case 0:
                preset1();
                break;

            case 1:
                preset2();
                break;

            case 2:
                preset3();
                break;

            case 3:
                preset4();
                break;
        }

        usuarioLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
        usuarioLabel.setForeground(new java.awt.Color(255, 255, 255));
        usuarioLabel.setText(this.usuarioLogado.getNomeUsuario());

        pontuacaoLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
        pontuacaoLabel.setForeground(new java.awt.Color(255, 255, 255));
        pontuacaoLabel.setText("Pontuação: " + this.usuarioLogado.getPontuacao());

        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                                .addComponent(perguntaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                                .addComponent(voltarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(usuarioLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pontuacaoLabel)
                                                .addGap(142, 142, 142))))
        );
        cadastroPanelLayout.setVerticalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usuarioLabel)
                                        .addComponent(pontuacaoLabel)
                                        .addComponent(voltarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(perguntaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                                .addContainerGap())
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
        perguntaTextArea.setLineWrap(true);
        perguntaTextArea.setWrapStyleWord(true);
        voltarAoMenuBotao.setVisible(false);
        proximaPerguntaBotao.setVisible(false);

        pack();
    }

    private void carregarPergunta() {
        try {
            PerguntaController perguntaController = new PerguntaController();
            this.perguntaCarregada = perguntaController.carregarPergunta(this.usuarioLogado.getId());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private int gerarvalorRandomico(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    private void alternativaErradaHandle() {
        String msg = "Confirmar a alternativa '" + this.perguntaCarregada.getAlternativa2() + "' como correta?";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Confirmar escolha", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            try {
                UsuarioController usuarioController = new UsuarioController();
                usuarioController.cadastrarPerguntaVisualizada(this.usuarioLogado.getId(), this.perguntaCarregada.getId());
                alternativa1Botao.setBackground(Color.RED);
                alternativa2Botao.setBackground(Color.RED);
                alternativa3Botao.setBackground(Color.RED);
                alternativaCorretaBotao.setBackground(Color.GREEN);
                alternativa1Botao.setEnabled(false);
                alternativa2Botao.setEnabled(false);
                alternativa3Botao.setEnabled(false);
                alternativaCorretaBotao.setEnabled(false);
                proximaPerguntaBotao.setVisible(true);
                voltarAoMenuBotao.setVisible(true);
                proximaPerguntaBotao.setEnabled(true);
                voltarAoMenuBotao.setEnabled(true);
                universitariosBotao.setEnabled(false);
                cartasBotao.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Resposta incorreta, alternativa correta: " + alternativaCorretaBotao.getText(),
                        "Resposta", JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void voltarBotaoClick(java.awt.event.ActionEvent evt) {
        String msg = "Voltar para o menu inicial? Você perderá os pontos gastos e não poderá repetir a pergunta.";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Confirmar escolha", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            try {
                UsuarioController usuarioController = new UsuarioController();
                usuarioController.cadastrarPerguntaVisualizada(this.usuarioLogado.getId(), this.perguntaCarregada.getId());
                MenuUsuarioView menuUsuarioView = new MenuUsuarioView(this.usuarioLogado);
                setVisible(false);
                menuUsuarioView.setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cartasBotaoClick(java.awt.event.ActionEvent evt) {
        String msg = "Comprar a dica 'Cartas' por: " + CUSTO_DICA_CARTAS + "?";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Confirmar escolha", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            if (this.isDicaCartasUsada) {
                JOptionPane.showMessageDialog(null, "Você já pediu dica para essa pergunta",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (this.usuarioLogado.getPontuacao() < CUSTO_DICA_CARTAS) {
                JOptionPane.showMessageDialog(null, "Você não possui pontos suficientes para comprar essa dica",
                        "Pontos insuficientes", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    UsuarioController usuarioController = new UsuarioController();
                    usuarioController.darPontosUsuario(this.perguntaCarregada.getIdUsuario(), -CUSTO_DICA_CARTAS);
                    this.usuarioLogado.setPontuacao(this.usuarioLogado.getPontuacao() - CUSTO_DICA_CARTAS);
                    atualizarPontuacao();
                    this.isDicaCartasUsada = true;
                    int cartaEscolhida = gerarvalorRandomico(4);
                    switch (cartaEscolhida) {
                        case 0:
                            dicasLabel.setText("Você retirou um rei, nenhuma alternativa errada será eliminada");
                            break;
                        case 1:
                            dicasLabel.setText("Você retirou um ás, 1 alternativa errada será eliminada");
                            alternativa1Botao.setEnabled(false);
                            break;
                        case 2:
                            dicasLabel.setText("Você retirou um 2, 2 alternativas erradas serão eliminadas");
                            alternativa1Botao.setEnabled(false);
                            alternativa2Botao.setEnabled(false);
                            break;
                        case 3:
                            dicasLabel.setText("Você retirou um 3, todas as alternativas erradas serão eliminadas");
                            alternativa1Botao.setEnabled(false);
                            alternativa2Botao.setEnabled(false);
                            alternativa3Botao.setEnabled(false);
                            break;
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void universitariosBotaoClick(java.awt.event.ActionEvent evt) {
        String msg = "Comprar a dica 'Universitarios' por: " + CUSTO_DICA_UNIVERSITARIOS + "?";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Confirmar escolha", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            if (this.isDicaUniversitariosUsada) {
                JOptionPane.showMessageDialog(null, "Você já pediu dica para essa pergunta",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (this.usuarioLogado.getPontuacao() < CUSTO_DICA_UNIVERSITARIOS) {
                JOptionPane.showMessageDialog(null, "Você não possui pontos suficientes para comprar essa dica",
                        "Pontos insuficientes", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    UsuarioController usuarioController = new UsuarioController();
                    usuarioController.darPontosUsuario(this.perguntaCarregada.getIdUsuario(), -CUSTO_DICA_UNIVERSITARIOS);
                    this.usuarioLogado.setPontuacao(this.usuarioLogado.getPontuacao() - CUSTO_DICA_UNIVERSITARIOS);
                    atualizarPontuacao();
                    this.isDicaUniversitariosUsada = true;
                    int escolhaUniversitarios = gerarvalorRandomico(4);
                    if (escolhaUniversitarios == 0) {
                        int escolhaAlternativa = gerarvalorRandomico(3);
                        switch (escolhaAlternativa) {
                            case 0:
                                alternativa1Botao.setBackground(Color.YELLOW);
                                break;
                            case 1:
                                alternativa2Botao.setBackground(Color.YELLOW);
                                break;
                            case 2:
                                alternativa3Botao.setBackground(Color.YELLOW);
                        }
                    } else {
                        alternativaCorretaBotao.setBackground(Color.YELLOW);
                    }
                    dicasLabel.setText("Os universitários acham que a alternativa destacada é a correta");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void alternativaCorretaBotaoClick() {
        String msg = "Confirmar a alternativa '" + this.perguntaCarregada.getAlternativaCorreta() + "' como correta?";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Confirmar escolha", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            try {
                UsuarioController usuarioController = new UsuarioController();
                usuarioController.cadastrarPerguntaVisualizada(this.usuarioLogado.getId(), this.perguntaCarregada.getId());
                usuarioController.darPontosUsuario(this.usuarioLogado.getId(),PONTOS_RESPOSTA_CORRETA);
                this.usuarioLogado.setPontuacao(this.usuarioLogado.getPontuacao() + PONTOS_RESPOSTA_CORRETA);
                alternativa1Botao.setBackground(Color.RED);
                alternativa2Botao.setBackground(Color.RED);
                alternativa3Botao.setBackground(Color.RED);
                alternativaCorretaBotao.setBackground(Color.GREEN);
                alternativa1Botao.setEnabled(false);
                alternativa2Botao.setEnabled(false);
                alternativa3Botao.setEnabled(false);
                alternativaCorretaBotao.setEnabled(false);
                proximaPerguntaBotao.setVisible(true);
                voltarAoMenuBotao.setVisible(true);
                proximaPerguntaBotao.setEnabled(true);
                voltarAoMenuBotao.setEnabled(true);
                universitariosBotao.setEnabled(false);
                cartasBotao.setEnabled(false);
                atualizarPontuacao();
                JOptionPane.showMessageDialog(null, "Resposta correta! Você ganhou " + PONTOS_RESPOSTA_CORRETA + " pontos!",
                        "Resposta", JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void atualizarPontuacao() {
        pontuacaoLabel.setText("Pontuação: " + usuarioLogado.getPontuacao());
    }

    private void alternativa2BotaoClick() {
        alternativaErradaHandle();
    }

    private void alternativa1BotaoClick() {
        alternativaErradaHandle();
    }

    private void alternativa3BotaoClick(java.awt.event.ActionEvent evt) {
        alternativaErradaHandle();
    }


    private void cartasBotaoMouseEntered() {
        descricaoDicasLabel.setText("Cartas: Carta aleatória, podendo tirar de 1 à 3 opções incorretas. Custo: " + CUSTO_DICA_CARTAS + " Pontos");
    }

    private void cartasBotaoMouseExited() {
        descricaoDicasLabel.setText("");
    }

    private void universitariosBotaoMouseEntered() {
        descricaoDicasLabel.setText("Universitários: Universitários opinarão qual é a resposta correta.  Custo: " + CUSTO_DICA_UNIVERSITARIOS + " Pontos");
    }

    private void universitariosBotaoMouseExited() {
        descricaoDicasLabel.setText("");
    }

    private void proximaPerguntaBotaoClick(java.awt.event.ActionEvent evt) {
        JogoView jogoView = new JogoView(this.usuarioLogado);
        setVisible(false);
        jogoView.setVisible(true);
    }

    private void voltarAoMenuBotaoClick() {
        MenuUsuarioView menuUsuarioView = new MenuUsuarioView(this.usuarioLogado);
        setVisible(false);
        menuUsuarioView.setVisible(true);
    }


    private void preset1() {
        javax.swing.GroupLayout perguntaPanelLayout = new javax.swing.GroupLayout(perguntaPanel);
        perguntaPanel.setLayout(perguntaPanelLayout);
        perguntaPanelLayout.setHorizontalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cartasBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(universitariosBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa3Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa2Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa1Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap())
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        perguntaPanelLayout.setVerticalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cartasBotao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(universitariosBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(alternativa1Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa2Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa3Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }

    private void preset2() {
        javax.swing.GroupLayout perguntaPanelLayout = new javax.swing.GroupLayout(perguntaPanel);
        perguntaPanel.setLayout(perguntaPanelLayout);
        perguntaPanelLayout.setHorizontalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cartasBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(universitariosBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(alternativa3Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa2Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa1Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap())
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        perguntaPanelLayout.setVerticalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cartasBotao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(universitariosBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(alternativa1Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa2Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa3Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }

    private void preset3() {
        javax.swing.GroupLayout perguntaPanelLayout = new javax.swing.GroupLayout(perguntaPanel);
        perguntaPanel.setLayout(perguntaPanelLayout);
        perguntaPanelLayout.setHorizontalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cartasBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(universitariosBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(alternativa3Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa2Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa1Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap())
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        perguntaPanelLayout.setVerticalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cartasBotao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(universitariosBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(alternativa1Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa2Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa3Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

    }

    private void preset4() {
        javax.swing.GroupLayout perguntaPanelLayout = new javax.swing.GroupLayout(perguntaPanel);
        perguntaPanel.setLayout(perguntaPanelLayout);
        perguntaPanelLayout.setHorizontalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cartasBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(universitariosBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(alternativa3Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa1Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativa2Botao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perguntaPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap())
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        perguntaPanelLayout.setVerticalGroup(
                perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cartasBotao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(universitariosBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(descricaoDicasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(alternativaCorretaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(perguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(holderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proximaPerguntaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(voltarAoMenuBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36))
                                        .addGroup(perguntaPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa2Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa1Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(alternativa3Botao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }

}
