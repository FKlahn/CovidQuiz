package br.com.ulbra.controller;

import br.com.ulbra.dao.Dao;
import br.com.ulbra.dao.PerguntaDao;
import br.com.ulbra.model.Pergunta;
import br.com.ulbra.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class PerguntaController extends Dao {
    public boolean cadastrarPergunta(Pergunta pergunta) throws SQLException {
        boolean cadastroOk = false;
        PerguntaDao perguntaDao = new PerguntaDao();
        if (perguntaDao.cadastrarPergunta(pergunta)) {
            cadastroOk = true;
        }

        return cadastroOk;
    }

    public ArrayList<Pergunta> listarPerguntasUsuario(Usuario usuario) throws SQLException {
        return PerguntaDao.listarPerguntasUsuario(usuario);
    }

    public boolean atualizarPergunta(Pergunta pergunta) throws SQLException {
        return PerguntaDao.atualizarPergunta(pergunta);
    }

    public boolean deletarPergunta(int idPergunta) throws SQLException {
        return PerguntaDao.deletarPergunta(idPergunta);
    }

    public int getIdPergunta(String idUsuario) throws SQLException {
        return PerguntaDao.getIdPergunta(idUsuario);
    }

    public ArrayList<Pergunta> listarPerguntasAdmin() throws SQLException{
        return PerguntaDao.listarPerguntasAdmin();
    }

    public Pergunta carregarPergunta(String id) throws SQLException{
        return PerguntaDao.carregarPergunta(id);
    }
}
