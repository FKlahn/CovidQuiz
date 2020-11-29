package br.com.ulbra.dao;

import br.com.ulbra.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Dao<Entity> {

    protected Connection obterConexao()throws SQLException {
        return ConnectionFactory.getConexao();
    }

}
