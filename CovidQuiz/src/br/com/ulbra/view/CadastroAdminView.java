package br.com.ulbra.view;

import br.com.ulbra.controller.UsuarioController;
import br.com.ulbra.model.PerfilEnum;
import br.com.ulbra.model.Usuario;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroAdminView extends javax.swing.JFrame {

    private javax.swing.JTextField loginTextField;
    private javax.swing.JTextField nomeUsuarioTextField;
    private javax.swing.JPasswordField senhaPassword;
    private static final int PONTUACAO_INICIAL = 0;
    private static final int STATUS_INICIAL = 1;
    private static final int DICA_ATIVA_INICIAL = 1;
    private static final int SEMPRE_DIFICIL_INICIAL = 0;
    private Usuario usuarioLogado;


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new CadastroAdminView().setVisible(true));
    }

    public CadastroAdminView() {
        carregaComponentes();
    }

    public CadastroAdminView(Usuario usuario) {
        this.usuarioLogado = usuario;
        carregaComponentes();
    }

    private void carregaComponentes() {

        javax.swing.JPanel loginPanel = new javax.swing.JPanel();
        loginTextField = new javax.swing.JTextField();
        senhaPassword = new javax.swing.JPasswordField();
        javax.swing.JButton cadastrarUsuario = new javax.swing.JButton();
        javax.swing.JLabel tituloLabel = new javax.swing.JLabel();
        nomeUsuarioTextField = new javax.swing.JTextField();
        javax.swing.JLabel subtituloLabel = new javax.swing.JLabel();
        Icon botaoVoltarIcon = new ImageIcon("src/br/com/ulbra/img/arrow_back_white_24x24.png");
        javax.swing.JButton botaoVoltar = new javax.swing.JButton(botaoVoltarIcon);
        botaoVoltar.setBorder(null);
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setFocusPainted(false);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Cadastro Admin");
        setResizable(false);

        loginPanel.setBackground(new java.awt.Color(35, 0, 149));
        loginPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cadastrarUsuario.setBackground(new java.awt.Color(83, 29, 255));
        cadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarUsuario.setText("Cadastrar");
        cadastrarUsuario.addActionListener(this::cadastrarClick);

        tituloLabel.setBackground(new java.awt.Color(35, 0, 149));
        tituloLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Covid Quiz");

        subtituloLabel.setBackground(new java.awt.Color(35, 0, 149));
        subtituloLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        subtituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        subtituloLabel.setText("Cadastre um novo administrador");

        botaoVoltar.addActionListener(this::botaoVoltarClick);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                        .addGap(39, 39, 39)
                                                        .addComponent(tituloLabel)
                                                        .addGap(50, 50, 50))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(cadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(loginTextField)
                                                                .addComponent(senhaPassword)
                                                                .addComponent(nomeUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(38, 38, 38))
                                                .addComponent(subtituloLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tituloLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subtituloLabel)
                                .addGap(18, 18, 18)
                                .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(senhaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nomeUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(cadastrarUsuario)
                                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(397, Short.MAX_VALUE))
        );

        getContentPane().setBackground(new java.awt.Color(27,0,115));
        PromptSupport.setPrompt("Login", loginTextField);
        PromptSupport.setPrompt("Senha", senhaPassword);
        PromptSupport.setPrompt("Nome de Usuario", nomeUsuarioTextField);

        pack();
    }

    private void cadastrarClick(java.awt.event.ActionEvent evt) {
        String login = loginTextField.getText();
        String senha = new String(senhaPassword.getPassword());
        String nomeUsuario = nomeUsuarioTextField.getText();
        boolean isTodosOsCamposPreenchidos = true;
        String camposRestantes = "";

        if(login.isEmpty()){
            isTodosOsCamposPreenchidos = false;
            camposRestantes = "Login";
        }

        if(senhaPassword.getPassword().length==0){
            isTodosOsCamposPreenchidos = false;
            camposRestantes = camposRestantes + " Senha";
        }

        if(nomeUsuario.isEmpty()){
            isTodosOsCamposPreenchidos = false;
            camposRestantes = camposRestantes + " Nome de Usuario";
        }

        if(isTodosOsCamposPreenchidos) {
            UsuarioController usuarioController = new UsuarioController();
            Usuario usuario = new Usuario();
            usuario.setId(UUID.randomUUID().toString());
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setNomeUsuario(nomeUsuario);
            usuario.setPontuacao(PONTUACAO_INICIAL);
            usuario.setTipoUsuario(PerfilEnum.ADMINISTRADOR);
            usuario.setStatus(STATUS_INICIAL);
            usuario.setDicaAtiva(DICA_ATIVA_INICIAL);
            usuario.setSempreDificil(SEMPRE_DIFICIL_INICIAL);
            try {
                if(usuarioController.cadastrarUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, "O Usuario " + usuario.getNomeUsuario() + " foi criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Login já existe " + camposRestantes,
                        "Erro",JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                Logger.getLogger(CadastroUsuarioView.class.getName()).log(Level.SEVERE, null, e);
            }

        }else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos! Campos restantes: " + camposRestantes,
                    "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void botaoVoltarClick(java.awt.event.ActionEvent evt) {
        MenuAdminView menuAdminView = new MenuAdminView(this.usuarioLogado);
        setVisible(false);
        menuAdminView.setVisible(true);
    }

}
