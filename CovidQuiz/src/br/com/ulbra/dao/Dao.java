package br.com.ulbra.dao;

import br.com.ulbra.util.ConnectionFactory;

import java.sql.Connection;

public abstract class Dao {

    protected static Connection obterConexao() {
        return ConnectionFactory.getConexao();
    }

}
