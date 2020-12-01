package br.com.ulbra.view;

import br.com.ulbra.controller.PerguntaController;
import br.com.ulbra.model.Pergunta;
import br.com.ulbra.model.Usuario;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class CadastroPerguntaView extends javax.swing.JFrame {
    private static final int STATUS_EM_AVALIACAO = 2;
    private javax.swing.JTextField alternativa1TextField;
    private javax.swing.JTextField alternativa2TextField;
    private javax.swing.JTextField alternativa3TextField;
    private javax.swing.JTextField alternativaCorretaTextField;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private JComboBox<String> dificuldadeComboBox;
    private javax.swing.JTextField perguntaTextField;
    private javax.swing.JTable perguntasTable;
    private Usuario usuarioLogado;
    private DefaultTableModel model;
    private Pergunta perguntaSelecionada;


    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> new CadastroPerguntaView().setVisible(true));
    }

    public CadastroPerguntaView() {
        carregaComponentes();
        desativaCamposCadastro();
    }

    public CadastroPerguntaView(Usuario usuario) {
        this.usuarioLogado = usuario;
        carregaComponentes();
        desativaCamposCadastro();
        carregarDadosTabela();
    }

    private void desativaCamposCadastro() {
        this.perguntaTextField.setEnabled(false);
        this.perguntaTextField.setEditable(false);
        this.alternativa1TextField.setEnabled(false);
        this.alternativa1TextField.setEditable(false);
        this.alternativa2TextField.setEnabled(false);
        this.alternativa2TextField.setEditable(false);
        this.alternativa3TextField.setEnabled(false);
        this.alternativa3TextField.setEditable(false);
        this.alternativaCorretaTextField.setEnabled(false);
        this.alternativaCorretaTextField.setEditable(false);
        this.dificuldadeComboBox.setEnabled(false);
        this.dificuldadeComboBox.setEditable(false);
        this.botaoCancelar.setEnabled(false);
        this.botaoSalvar.setEnabled(false);
        this.botaoAtualizar.setEnabled(false);
    }

    private void ativaCamposCadastro() {
        this.perguntaTextField.setEnabled(true);
        this.perguntaTextField.setEditable(true);
        this.alternativa1TextField.setEnabled(true);
        this.alternativa1TextField.setEditable(true);
        this.alternativa2TextField.setEnabled(true);
        this.alternativa2TextField.setEditable(true);
        this.alternativa3TextField.setEnabled(true);
        this.alternativa3TextField.setEditable(true);
        this.alternativaCorretaTextField.setEnabled(true);
        this.alternativaCorretaTextField.setEditable(true);
        this.dificuldadeComboBox.setEnabled(true);
        this.dificuldadeComboBox.setEditable(true);
        this.botaoCancelar.setEnabled(true);
        this.botaoSalvar.setEnabled(true);
    }


    private void carregarDadosTabela() {
        try {
            PerguntaController perguntaController = new PerguntaController();
            ArrayList<Pergunta> perguntasUsuario = perguntaController.listarPerguntasUsuario(usuarioLogado);
            model = (DefaultTableModel) perguntasTable.getModel();
            for (Pergunta pergunta : perguntasUsuario) {
                model.addRow(new Object[]{
                        pergunta.getId(),
                        pergunta.getPergunta(),
                        pergunta.getAlternativa1(),
                        pergunta.getAlternativa2(),
                        pergunta.getAlternativa3(),
                        pergunta.getAlternativaCorreta(),
                        pergunta.getDificuldadePergunta() == 1 ? "FÁCIL" : pergunta.getDificuldadePergunta() == 2 ? "MÉDIO" : "DIFÍCIL",
                        pergunta.getStatusPergunta() == 0 ? "NEGADA" : pergunta.getStatusPergunta() == 1 ? "ACEITA" : "EM AVALIAÇÃO"});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Tente novamente mais tarde!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void carregaComponentes() {

        JPanel cadastroPanel = new JPanel();
        JPanel menuAcoesPanel = new JPanel();
        botaoNovo = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        JPanel menuCadastroPanel = new JPanel();
        perguntaTextField = new javax.swing.JTextField();
        alternativa1TextField = new javax.swing.JTextField();
        alternativa2TextField = new javax.swing.JTextField();
        alternativa3TextField = new javax.swing.JTextField();
        alternativaCorretaTextField = new javax.swing.JTextField();
        dificuldadeComboBox = new javax.swing.JComboBox<>();
        JLabel dificuldadeLabel = new JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoAtualizar.setEnabled(false);
        botaoSalvar = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        perguntasTable = new javax.swing.JTable();
        JLabel tituloLabel = new JLabel();
        Icon botaoVoltarIcon = new ImageIcon("src/br/com/ulbra/img/arrow_back_white_24x24.png");
        javax.swing.JButton botaoVoltar = new javax.swing.JButton(botaoVoltarIcon);
        botaoVoltar.setBorder(null);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setFocusPainted(false);

        alternativa1TextField.setForeground(Color.BLACK);
        alternativa2TextField.setForeground(Color.BLACK);
        alternativa3TextField.setForeground(Color.BLACK);
        alternativaCorretaTextField.setForeground(Color.BLACK);
        perguntaTextField.setForeground(Color.BLACK);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Cadastro Pergunta");
        setResizable(false);

        cadastroPanel.setBackground(new java.awt.Color(35, 0, 149));
        cadastroPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadastroPanel.setMinimumSize(new java.awt.Dimension(393, 355));
        cadastroPanel.setPreferredSize(new java.awt.Dimension(450, 450));

        botaoVoltar.addActionListener(this::botaoVoltarClick);

        menuAcoesPanel.setBackground(new java.awt.Color(83, 29, 255));
        menuAcoesPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoNovo.setBackground(new java.awt.Color(158, 128, 255));
        botaoNovo.setForeground(Color.WHITE);
        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(this::botaoNovoClick);

        botaoEditar.setBackground(new java.awt.Color(158, 128, 255));
        botaoEditar.setForeground(Color.WHITE);
        botaoEditar.setText("Editar");
        botaoEditar.setEnabled(false);
        botaoEditar.addActionListener(this::botaoEditarClick);

        botaoExcluir.setBackground(new java.awt.Color(158, 128, 255));
        botaoExcluir.setForeground(Color.WHITE);
        botaoExcluir.setText("Excluir");
        botaoExcluir.setEnabled(false);
        botaoExcluir.addActionListener(this::botaoExcluirClick);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(menuAcoesPanel);
        menuAcoesPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(botaoExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botaoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botaoNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoExcluir)
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        menuCadastroPanel.setBackground(new java.awt.Color(83, 29, 255));
        menuCadastroPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        perguntaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                perguntaTextFieldKeyTyped(evt);
            }
        });

        alternativa1TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alternativa1TextFieldKeyTyped(evt);
            }
        });

        alternativa2TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alternativa2TextFieldKeyTyped(evt);
            }
        });

        alternativa3TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alternativa3TextFieldKeyTyped(evt);
            }
        });

        alternativaCorretaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alternativaCorretaTextFieldKeyTyped(evt);
            }
        });

        dificuldadeComboBox.setBackground(new java.awt.Color(158, 128, 255));
        dificuldadeComboBox.setForeground(Color.WHITE);
        dificuldadeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"FÁCIL", "MÉDIO", "DIFÍCIL"}));
        JTextField txtOff = (JTextField) dificuldadeComboBox.getEditor().getEditorComponent();
        txtOff.setEditable(false);

        dificuldadeLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        dificuldadeLabel.setForeground(new java.awt.Color(255, 255, 255));
        dificuldadeLabel.setText("Dificuldade:");

        botaoCancelar.setBackground(new java.awt.Color(158, 128, 255));
        botaoCancelar.setForeground(Color.WHITE);
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setEnabled(true);
        botaoCancelar.addActionListener(this::botaoCancelarClick);

        botaoAtualizar.setBackground(new java.awt.Color(158, 128, 255));
        botaoAtualizar.setForeground(Color.WHITE);
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.setEnabled(true);
        botaoAtualizar.addActionListener(this::botaoAtualizarClick);

        botaoSalvar.setBackground(new java.awt.Color(158, 128, 255));
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setText("Salvar");
        botaoSalvar.setEnabled(true);
        botaoSalvar.addActionListener(this::botaoSalvarClick);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(menuCadastroPanel);
        menuCadastroPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(perguntaTextField)
                                                        .addComponent(alternativa1TextField)
                                                        .addComponent(alternativa2TextField)
                                                        .addComponent(alternativa3TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(alternativaCorretaTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(dificuldadeLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(dificuldadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 92, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(perguntaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alternativa1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alternativa2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(alternativa3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alternativaCorretaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dificuldadeLabel)
                                        .addComponent(dificuldadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoCancelar)
                                        .addComponent(botaoAtualizar)
                                        .addComponent(botaoSalvar))
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        perguntasTable.setBackground(new java.awt.Color(158, 128, 255));
        perguntasTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Codigo", "Pergunta", "Alternativa 1", "Alternativa 2", "Alternativa 3", "Alternativa Correta", "Dificuldade", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        perguntasTable.getColumnModel().removeColumn(perguntasTable.getColumn("Codigo"));
        perguntasTable.setGridColor(new java.awt.Color(0, 0, 0));
        perguntasTable.setSelectionBackground(new java.awt.Color(83, 29, 255));
        perguntasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perguntasTableMouseClicked();
            }
        });
        jScrollPane1.setViewportView(perguntasTable);

        tituloLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Covid Quiz - Cadastro de perguntas");

        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(192, 192, 192)
                                                .addComponent(tituloLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                                .addComponent(menuAcoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(menuCadastroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
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
                                        .addComponent(menuAcoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(menuCadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PromptSupport.setPrompt("Pergunta", perguntaTextField);
        PromptSupport.setPrompt("Alternativa 1", alternativa1TextField);
        PromptSupport.setPrompt("Alternativa 2", alternativa2TextField);
        PromptSupport.setPrompt("Alternativa 3", alternativa3TextField);
        PromptSupport.setPrompt("Alternativa Correta", alternativaCorretaTextField);

        pack();
    }

    private void botaoVoltarClick(java.awt.event.ActionEvent evt) {
        MenuUsuarioView menuUsuarioView = new MenuUsuarioView(this.usuarioLogado);
        setVisible(false);
        menuUsuarioView.setVisible(true);
    }

    private void perguntaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        if (this.perguntaTextField.getText().length() >= 110)
            evt.consume();
    }

    private void alternativa1TextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        if (this.alternativa1TextField.getText().length() >= 70)
            evt.consume();
    }

    private void alternativa2TextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        if (this.alternativa2TextField.getText().length() >= 70)
            evt.consume();
    }

    private void alternativa3TextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        if (this.alternativa3TextField.getText().length() >= 70)
            evt.consume();
    }

    private void alternativaCorretaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        if (this.alternativaCorretaTextField.getText().length() >= 70)
            evt.consume();
    }

    private void botaoNovoClick(java.awt.event.ActionEvent evt) {
        ativaCamposCadastro();
        this.botaoAtualizar.setEnabled(false);
        this.botaoEditar.setEnabled(false);
        this.botaoNovo.setEnabled(false);
        this.botaoExcluir.setEnabled(false);
    }

    private void botaoEditarClick(java.awt.event.ActionEvent evt) {
        this.perguntaTextField.setText(perguntaSelecionada.getPergunta());
        this.alternativa1TextField.setText(perguntaSelecionada.getAlternativa1());
        this.alternativa2TextField.setText(perguntaSelecionada.getAlternativa2());
        this.alternativa3TextField.setText(perguntaSelecionada.getAlternativa3());
        this.alternativaCorretaTextField.setText(perguntaSelecionada.getAlternativaCorreta());
        this.dificuldadeComboBox.setSelectedIndex(perguntaSelecionada.getDificuldadePergunta() - 1);
        this.botaoNovo.setEnabled(false);
        ativaCamposCadastro();
        this.botaoSalvar.setEnabled(false);
        this.botaoAtualizar.setEnabled(true);

    }

    private void botaoExcluirClick(java.awt.event.ActionEvent evt) {
        String msg = "Deletar a pergunta: " + perguntaSelecionada.getPergunta() + "(?)";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Exclusão", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            if (perguntaSelecionada.getStatusPergunta() == 1) {
                JOptionPane.showMessageDialog(null, "Não é possível excluir perguntas já aprovadas ",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    PerguntaController perguntaController = new PerguntaController();
                    if (perguntaController.deletarPergunta(perguntaSelecionada.getId())) {
                        JOptionPane.showMessageDialog(null, "A pergunta " + perguntaSelecionada.getPergunta() + " foi Deletada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        model.removeRow(perguntasTable.getSelectedRow());
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void botaoCancelarClick(java.awt.event.ActionEvent evt) {
        desativaCamposCadastro();
        this.botaoNovo.setEnabled(true);
        this.perguntaSelecionada = new Pergunta();
        this.botaoAtualizar.setEnabled(false);
        this.botaoEditar.setEnabled(false);
        this.botaoExcluir.setEnabled(false);
        limpaCampos();
    }

    private void limpaCampos() {
        this.perguntaTextField.setText("");
        this.alternativa1TextField.setText("");
        this.alternativa2TextField.setText("");
        this.alternativa3TextField.setText("");
        this.alternativaCorretaTextField.setText("");
        this.dificuldadeComboBox.setSelectedIndex(0);
    }

    private void botaoAtualizarClick(java.awt.event.ActionEvent evt) {
        String msg = "Atualizar a pergunta: " + perguntaSelecionada.getPergunta() + "(?)";
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, msg, "Atualização", JOptionPane.YES_NO_OPTION);
        if (opcaoEscolhida == JOptionPane.YES_OPTION) {
            if (perguntaSelecionada.getStatusPergunta() == 1) {
                JOptionPane.showMessageDialog(null, "Não é possível atualizar perguntas já aprovadas ",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                String perguntatxt = perguntaTextField.getText();
                String alternativa1 = alternativa1TextField.getText();
                String alternativa2 = alternativa2TextField.getText();
                String alternativa3 = alternativa3TextField.getText();
                String alternativaCorreta = alternativaCorretaTextField.getText();
                String dificuldade = Objects.requireNonNull(dificuldadeComboBox.getSelectedItem()).toString();
                String camposRestantes = "";
                boolean isTodosOsCamposPreenchidos = true;

                if (perguntatxt.isEmpty()) {
                    isTodosOsCamposPreenchidos = false;
                    camposRestantes = "Login";
                }

                if (alternativa1.isEmpty()) {
                    isTodosOsCamposPreenchidos = false;
                    camposRestantes = camposRestantes + " Alternativa 1";
                }

                if (alternativa2.isEmpty()) {
                    isTodosOsCamposPreenchidos = false;
                    camposRestantes = camposRestantes + " Alternativa 2";
                }

                if (alternativa3.isEmpty()) {
                    isTodosOsCamposPreenchidos = false;
                    camposRestantes = camposRestantes + " Alternativa 3";
                }

                if (alternativaCorreta.isEmpty()) {
                    isTodosOsCamposPreenchidos = false;
                    camposRestantes = camposRestantes + " Alternativa Correta";
                }

                if (isTodosOsCamposPreenchidos) {
                    PerguntaController perguntaController = new PerguntaController();
                    perguntaSelecionada.setPergunta(perguntatxt);
                    perguntaSelecionada.setAlternativa1(alternativa1);
                    perguntaSelecionada.setAlternativa2(alternativa2);
                    perguntaSelecionada.setAlternativa3(alternativa3);
                    perguntaSelecionada.setAlternativaCorreta(alternativaCorreta);
                    perguntaSelecionada.setStatusPergunta(STATUS_EM_AVALIACAO);
                    perguntaSelecionada.setDificuldadePergunta(dificuldade.equals("FÁCIL") ? 1 : dificuldade.equals("MÉDIO") ? 2 : 3);
                    try {
                        if (perguntaController.atualizarPergunta(perguntaSelecionada)) {
                            model.setValueAt(perguntaSelecionada.getPergunta(), perguntasTable.getSelectedRow(), 1);
                            model.setValueAt(perguntaSelecionada.getAlternativa1(), perguntasTable.getSelectedRow(), 2);
                            model.setValueAt(perguntaSelecionada.getAlternativa2(), perguntasTable.getSelectedRow(), 3);
                            model.setValueAt(perguntaSelecionada.getAlternativa3(), perguntasTable.getSelectedRow(), 4);
                            model.setValueAt(perguntaSelecionada.getAlternativaCorreta(), perguntasTable.getSelectedRow(), 5);
                            model.setValueAt(perguntaSelecionada.getDificuldadePergunta() == 1 ? "FÁCIL" : perguntaSelecionada.getDificuldadePergunta() == 2 ? "MÉDIO" : "DIFÍCIL", perguntasTable.getSelectedRow(), 6);
                            model.setValueAt("EM AVALIAÇÃO", perguntasTable.getSelectedRow(), 7);
                            JOptionPane.showMessageDialog(null, "A pergunta " + perguntaSelecionada.getPergunta() + " foi Atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos! Campos restantes: " + camposRestantes,
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void botaoSalvarClick(java.awt.event.ActionEvent evt) {
        String perguntatxt = perguntaTextField.getText();
        String alternativa1 = alternativa1TextField.getText();
        String alternativa2 = alternativa2TextField.getText();
        String alternativa3 = alternativa3TextField.getText();
        String alternativaCorreta = alternativaCorretaTextField.getText();
        String dificuldade = Objects.requireNonNull(dificuldadeComboBox.getSelectedItem()).toString();
        String camposRestantes = "";
        boolean isTodosOsCamposPreenchidos = true;

        if (perguntatxt.isEmpty()) {
            isTodosOsCamposPreenchidos = false;
            camposRestantes = "Login";
        }

        if (alternativa1.isEmpty()) {
            isTodosOsCamposPreenchidos = false;
            camposRestantes = camposRestantes + " Alternativa 1";
        }

        if (alternativa2.isEmpty()) {
            isTodosOsCamposPreenchidos = false;
            camposRestantes = camposRestantes + " Alternativa 2";
        }

        if (alternativa3.isEmpty()) {
            isTodosOsCamposPreenchidos = false;
            camposRestantes = camposRestantes + " Alternativa 3";
        }

        if (alternativaCorreta.isEmpty()) {
            isTodosOsCamposPreenchidos = false;
            camposRestantes = camposRestantes + " Alternativa Correta";
        }

        if (isTodosOsCamposPreenchidos) {
            PerguntaController perguntaController = new PerguntaController();
            Pergunta pergunta = new Pergunta();
            pergunta.setPergunta(perguntatxt);
            pergunta.setAlternativa1(alternativa1);
            pergunta.setAlternativa2(alternativa2);
            pergunta.setAlternativa3(alternativa3);
            pergunta.setAlternativaCorreta(alternativaCorreta);
            pergunta.setStatusPergunta(STATUS_EM_AVALIACAO);
            pergunta.setDificuldadePergunta(dificuldade.equals("FÁCIL") ? 1 : dificuldade.equals("MÉDIO") ? 2 : 3);
            pergunta.setIdUsuario(usuarioLogado.getId());
            try {
                if (perguntaController.cadastrarPergunta(pergunta)) {
                    model.addRow(new Object[]{perguntaController.getIdPergunta(pergunta.getIdUsuario()), pergunta.getPergunta(), pergunta.getAlternativa1(), pergunta.getAlternativa2(), pergunta.getAlternativa3(), pergunta.getAlternativaCorreta(), pergunta.getDificuldadePergunta() == 1 ? "FÁCIL" : pergunta.getDificuldadePergunta() == 2 ? "MÉDIO" : "DIFÍCIL", "EM AVALIAÇÃO"});
                    JOptionPane.showMessageDialog(null, "A pergunta " + pergunta.getPergunta() + " foi criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos! Campos restantes: " + camposRestantes,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void perguntasTableMouseClicked() {
        limpaCampos();
        desativaCamposCadastro();
        this.botaoExcluir.setEnabled(true);
        this.botaoEditar.setEnabled(true);
        this.botaoNovo.setEnabled(true);
        ListSelectionModel tableSelectionModel = perguntasTable.getSelectionModel();
        this.perguntaSelecionada = new Pergunta();

        perguntasTable.setSelectionModel(tableSelectionModel);

        perguntaSelecionada.setId(Integer.parseInt(perguntasTable.getModel().getValueAt(perguntasTable.getSelectedRow(), 0).toString()));
        perguntaSelecionada.setPergunta(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 0).toString());
        perguntaSelecionada.setAlternativa1(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 1).toString());
        perguntaSelecionada.setAlternativa2(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 2).toString());
        perguntaSelecionada.setAlternativa3(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 3).toString());
        perguntaSelecionada.setAlternativaCorreta(perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 4).toString());
        String dificuldade = perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 5).toString();
        String status = perguntasTable.getValueAt(perguntasTable.getSelectedRow(), 6).toString();
        perguntaSelecionada.setDificuldadePergunta(dificuldade.equals("FÁCIL") ? 1 : dificuldade.equals("MÉDIO") ? 2 : 3);
        perguntaSelecionada.setStatusPergunta(status.equals("ACEITA") ? 1 : status.equals("NEGADA") ? 0 : 2);

    }
}
