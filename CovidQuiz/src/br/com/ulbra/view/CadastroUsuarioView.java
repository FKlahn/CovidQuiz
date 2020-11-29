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

public class CadastroUsuarioView extends javax.swing.JFrame {
    private javax.swing.JTextField loginTextField;
    private javax.swing.JTextField nomeUsuarioTextField;
    private javax.swing.JPasswordField senhaPassword;
    private static final int PONTUACAO_INICIAL = 0;
    private static final int STATUS_INICIAL = 1;
    private static final int DICA_ATIVA_INICIAL = 1;
    private static final int SEMPRE_DIFICIL_INICIAL = 0;


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new CadastroUsuarioView().setVisible(true));
    }

    public CadastroUsuarioView() {
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
        javax.swing.JPanel cadastroPanel = new javax.swing.JPanel();
        javax.swing.JLabel loginRedirectLabel = new javax.swing.JLabel();
        javax.swing.JButton loginButton = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Cadastro Usuário");
        setPreferredSize(new java.awt.Dimension(480, 800));
        setResizable(false);

        loginPanel.setBackground(new java.awt.Color(35, 0, 149));
        loginPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cadastrarUsuario.setBackground(new java.awt.Color(83, 29, 255));
        cadastrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarUsuario.setText("Cadastrar-se");
        cadastrarUsuario.addActionListener(this::cadastrarClick);

        tituloLabel.setBackground(new java.awt.Color(35, 0, 149));
        tituloLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Covid Quiz");

        subtituloLabel.setBackground(new java.awt.Color(35, 0, 149));
        subtituloLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        subtituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        subtituloLabel.setText("Cadastre-se para participar");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(subtituloLabel)
                                                .addGap(55, 55, 55))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(tituloLabel)
                                                .addGap(77, 77, 77))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(loginTextField)
                                                        .addComponent(senhaPassword)
                                                        .addComponent(nomeUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(65, 65, 65))))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
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
                                .addGap(65, 65, 65))
        );

        cadastroPanel.setBackground(new java.awt.Color(35, 0, 149));
        cadastroPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        loginRedirectLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        loginRedirectLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginRedirectLabel.setText("Já tem uma conta?");

        loginButton.setBackground(new java.awt.Color(35, 0, 149));
        loginButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(83, 29, 255));
        loginButton.setText("Conecte-se");
        loginButton.setBorder(null);
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this::loginButtonClick);

        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(loginRedirectLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loginButton)
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        cadastroPanelLayout.setVerticalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginRedirectLabel)
                                        .addComponent(loginButton))
                                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(68, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cadastroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(357, Short.MAX_VALUE))
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
            usuario.setTipoUsuario(PerfilEnum.USUARIO);
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


    private void loginButtonClick(java.awt.event.ActionEvent evt) {
        MenuInicialView menuInicialView = new MenuInicialView();
        setVisible(false);
        menuInicialView.setVisible(true);
    }
}
