package br.com.ulbra.controller;


import br.com.ulbra.dao.Dao;
import br.com.ulbra.dao.UsuarioDao;
import br.com.ulbra.model.Usuario;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class UsuarioController extends Dao<Usuario> {

    public ArrayList<Usuario> buscarLoginUsuario() throws SQLException, ClassNotFoundException {
        return UsuarioDao.buscarLoginUsuario();
    }

    public ArrayList<Usuario> buscarLoginAdmin() throws SQLException, ClassNotFoundException {
        return UsuarioDao.buscarLoginAdmin();
    }

    public boolean cadastrarUsuario(Usuario usuario) throws SQLException, SQLIntegrityConstraintViolationException {
        boolean cadastroOk = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        if(usuarioDao.cadastrarUsuario(usuario)){
            cadastroOk = true;
        }

        return cadastroOk;
    }

    public boolean atualizar(Usuario usuario) throws SQLException {
        return false;
    }

    public boolean excluir(Usuario usuario) throws SQLException {
        return false;
    }
}
