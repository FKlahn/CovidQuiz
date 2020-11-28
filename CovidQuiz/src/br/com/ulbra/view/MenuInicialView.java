package br.com.ulbra.view;

import br.com.ulbra.controller.UsuarioController;
import br.com.ulbra.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuInicialView extends javax.swing.JFrame {

    private JTextField loginTextField = new JTextField();
    private JPasswordField senhaTextField = new JPasswordField();

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> new MenuInicialView().setVisible(true));
    }

    public MenuInicialView() {
        carregaComponentes();
        getContentPane().setBackground(new java.awt.Color(27,0,115));
    }

    private void carregaComponentes() {

        JPanel loginPanel = new JPanel();
        JLabel loginLabel = new JLabel();
        JLabel senhaLabel = new JLabel();

        JButton entrarUsuario= new JButton();
        JButton entrarAdmin= new JButton();
        JLabel tituloLabel = new JLabel();
        JPanel cadastroPanel = new JPanel();
        JLabel cadastroLabel = new JLabel();
        JButton cadastroButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid Quiz - Menu Inicial");
        setPreferredSize(new java.awt.Dimension(480, 800));
        setResizable(false);

        loginPanel.setBackground(new java.awt.Color(35, 0, 149));
        loginPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        loginLabel.setBackground(new java.awt.Color(35, 0, 149));
        loginLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
        loginLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginLabel.setText("Login:");

        senhaLabel.setBackground(new java.awt.Color(35, 0, 149));
        senhaLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24));
        senhaLabel.setForeground(new java.awt.Color(255, 255, 255));
        senhaLabel.setText("Senha:");

        entrarUsuario.setBackground(new java.awt.Color(83, 29, 255));
        entrarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        entrarUsuario.setText("Entrar como Usuario");
        entrarUsuario.addActionListener(this::entrarUsuarioClick);

        entrarAdmin.setBackground(new java.awt.Color(83, 29, 255));
        entrarAdmin.setForeground(new java.awt.Color(255, 255, 255));
        entrarAdmin.setText("Entrar como Admin");
        entrarAdmin.addActionListener(this::entrarAdminClick);


        tituloLabel.setBackground(new java.awt.Color(35, 0, 149));
        tituloLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 36));
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setText("Covid Quiz");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tituloLabel)
                                .addGap(56, 56, 56))
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(entrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                                .addComponent(senhaLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                                .addComponent(loginLabel)
                                                                .addGap(21, 21, 21)))
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(loginTextField)
                                                        .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(entrarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(73, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(tituloLabel)
                                .addGap(45, 45, 45)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginLabel)
                                        .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(senhaLabel)
                                        .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(entrarUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(entrarAdmin)
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        cadastroPanel.setBackground(new java.awt.Color(35, 0, 149));
        cadastroPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cadastroLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        cadastroLabel.setForeground(new java.awt.Color(255, 255, 255));
        cadastroLabel.setText("Não tem uma conta?");

        cadastroButton.setBackground(new java.awt.Color(35, 0, 149));
        cadastroButton.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        cadastroButton.setForeground(new java.awt.Color(83, 29, 255));
        cadastroButton.setText("Cadastre-se");
        cadastroButton.setBorder(null);
        cadastroButton.setBorderPainted(false);
        cadastroButton.setContentAreaFilled(false);
        cadastroButton.setFocusPainted(false);
        cadastroButton.addActionListener(this::cadastroButtonClick);


        javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
        cadastroPanel.setLayout(cadastroPanelLayout);
        cadastroPanelLayout.setHorizontalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadastroPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(cadastroLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cadastroButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cadastroPanelLayout.setVerticalGroup(
                cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanelLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cadastroLabel)
                                        .addComponent(cadastroButton))
                                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(85, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cadastroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    private void entrarUsuarioClick(java.awt.event.ActionEvent evt) {
        String login = loginTextField.getText();
        char[] senha = senhaTextField.getPassword();

        try{
            UsuarioController uc = new UsuarioController();
            ArrayList<Usuario> usuariosList = uc.buscarLoginUsuario();

            for(Usuario u : usuariosList){
                if(u.getLogin().equalsIgnoreCase(login) && u.getSenha().equalsIgnoreCase(new String(senha))) {
                    MenuUsuarioView menuUsuarioView = new MenuUsuarioView(u);
                    setVisible(false);
                    menuUsuarioView.setVisible(true);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Verifique o usuário e senha!",
                    "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void entrarAdminClick(java.awt.event.ActionEvent evt) {
        String login = loginTextField.getText();
        char[] senha = senhaTextField.getPassword();

        try{
            UsuarioController uc = new UsuarioController();
            ArrayList<Usuario> usuariosList = uc.buscarLoginAdmin();

            for(Usuario u : usuariosList){
                if(u.getLogin().equalsIgnoreCase(login) && u.getSenha().equalsIgnoreCase(new String(senha))) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso! " + u.getNomeUsuario());
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o banco. Verifique o usuário e senha!",
                    "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cadastroButtonClick(java.awt.event.ActionEvent evt) {
        CadastroUsuarioView cadastroUsuarioView = new CadastroUsuarioView();
        setVisible(false);
        cadastroUsuarioView.setVisible(true);
    }


}
