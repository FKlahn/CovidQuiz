package br.com.ulbra.util;

import javax.swing.*;
import java.sql.*;

public class ConnectionFactory {
    private static final String urlBase = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String usuario = "system";
    private static final String senha = "root123";

    public static Connection getConexao(){

        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(urlBase, usuario, senha);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: "+e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        return conexao;
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) throws ConexaoException {
        close(conn, ps, rs);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) throws ConexaoException {
        close(conn, ps, null);
    }

    public static void closeConnection(Connection conn) throws ConexaoException {
        close(conn, null, null);
    }

    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws ConexaoException {
        try {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
            if(rs != null)
                rs.close();
        } catch (Exception e) {
            throw new ConexaoException(e.getMessage());
        }
    }
}
