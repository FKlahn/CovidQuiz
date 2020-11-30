package br.com.ulbra.controller;


import br.com.ulbra.dao.Dao;
import br.com.ulbra.dao.UsuarioDao;
import br.com.ulbra.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioController extends Dao {

    public ArrayList<Usuario> buscarLoginUsuario() throws SQLException {
        return UsuarioDao.buscarLoginUsuario();
    }

    public ArrayList<Usuario> buscarLoginAdmin() throws SQLException {
        return UsuarioDao.buscarLoginAdmin();
    }

    public ArrayList<Usuario> rankearUsuarios() throws SQLException {
        return UsuarioDao.rankearUsuarios();
    }

    public boolean cadastrarUsuario(Usuario usuario) throws SQLException {
        boolean cadastroOk = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        if(usuarioDao.cadastrarUsuario(usuario)){
            cadastroOk = true;
        }

        return cadastroOk;
    }

    public boolean atualizar(Usuario usuario) {
        boolean atualizacaoOk = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        if(usuarioDao.atualizar(usuario)) {
            atualizacaoOk = true;
        }

        return atualizacaoOk;
    }

    public void darPontosUsuario(String idUsuario) throws SQLException{
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.darPontosUsuario(idUsuario);
    }
}
