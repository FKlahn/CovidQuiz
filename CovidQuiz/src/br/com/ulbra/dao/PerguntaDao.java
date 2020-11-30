package br.com.ulbra.dao;

import br.com.ulbra.model.Pergunta;
import br.com.ulbra.model.Usuario;
import br.com.ulbra.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerguntaDao extends Dao<Pergunta> {

    private static final int STATUS_EXCLUIDO = -1;
    private static final int STATUS_EM_AVALIACAO = 2;

    public static ArrayList<Pergunta> listarPerguntasUsuario(Usuario usuario) throws SQLException {
        ArrayList<Pergunta> perguntaAux = new ArrayList<>();
        String sql = "select cq_id_pergunta, cq_pergunta, cq_alternativa1, cq_alternativa2, cq_alternativa3, cq_alternativa_correta, cq_dificuldade_pergunta, cq_status_pergunta from cq_pergunta where cq_id_usuario_pergunta = ? and cq_status_pergunta != ?";

        Connection conn = ConnectionFactory.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, usuario.getId());
        ps.setInt(2, STATUS_EXCLUIDO);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pergunta pergunta = new Pergunta();
            pergunta.setId(rs.getInt("cq_id_pergunta"));
            pergunta.setPergunta(rs.getString("cq_pergunta"));
            pergunta.setAlternativa1(rs.getString("cq_alternativa1"));
            pergunta.setAlternativa2(rs.getString("cq_alternativa2"));
            pergunta.setAlternativa3(rs.getString("cq_alternativa3"));
            pergunta.setAlternativaCorreta(rs.getString("cq_alternativa_correta"));
            pergunta.setDificuldadePergunta(rs.getInt("cq_dificuldade_pergunta"));
            pergunta.setStatusPergunta(rs.getInt("cq_status_pergunta"));

            perguntaAux.add(pergunta);
        }

        return perguntaAux;
    }

    public static boolean atualizarPergunta(Pergunta pergunta) throws SQLException {
        PreparedStatement ps = null;
        String sql = "update cq_pergunta set cq_pergunta = ?, cq_alternativa1 = ?, cq_alternativa2 = ?, cq_alternativa3 = ?, cq_alternativa_correta = ?, cq_status_pergunta = ?, cq_dificuldade_pergunta = ? where cq_id_pergunta = ?";
        try {
            Connection conn = obterConexao();
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, pergunta.getPergunta());
                ps.setString(2, pergunta.getAlternativa1());
                ps.setString(3, pergunta.getAlternativa2());
                ps.setString(4, pergunta.getAlternativa3());
                ps.setString(5, pergunta.getAlternativaCorreta());
                ps.setInt(6, STATUS_EM_AVALIACAO);
                ps.setInt(7, pergunta.getDificuldadePergunta());
                ps.setInt(8, pergunta.getId());

                ps.executeUpdate();
            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, ps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return true;
    }

    public static boolean deletarPergunta(int idPergunta) throws SQLException{
        PreparedStatement ps = null;
        String sql = "update cq_pergunta set cq_status_pergunta = ? where cq_id_pergunta = ?";
        try {
            Connection conn = obterConexao();
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, STATUS_EXCLUIDO);
                ps.setInt(2, idPergunta);

                ps.executeUpdate();
            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, ps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return true;
    }

    public static int getIdPergunta(String idUsuario) throws SQLException{
        Integer idPergunta = null;
        PreparedStatement ps = null;
        String sql = "select cq_id_pergunta from cq_pergunta where cq_id_usuario_pergunta = ? and rownum = 1 order by cq_id_pergunta DESC";

        try {
            Connection conn = obterConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idUsuario);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                idPergunta = rs.getInt("cq_id_pergunta");
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }

        return idPergunta;
    }

    public boolean cadastrarPergunta(Pergunta pergunta) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO cq_pergunta (" +
                "cq_id_pergunta, " +
                "cq_pergunta, " +
                "cq_alternativa1, " +
                "cq_alternativa2, " +
                "cq_alternativa3, " +
                "cq_alternativa_correta, " +
                "cq_status_pergunta, " +
                "cq_dificuldade_pergunta, " +
                "cq_id_usuario_pergunta) " +
                "values(SEQ_PERGUNTA.NEXTVAL,?,?,?,?,?,?,?,?)";

        try {
            Connection conn = obterConexao();
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, pergunta.getPergunta());
                ps.setString(2, pergunta.getAlternativa1());
                ps.setString(3, pergunta.getAlternativa2());
                ps.setString(4, pergunta.getAlternativa3());
                ps.setString(5, pergunta.getAlternativaCorreta());
                ps.setInt(6, pergunta.getStatusPergunta());
                ps.setInt(7, pergunta.getDificuldadePergunta());
                ps.setString(8, pergunta.getIdUsuario());

                ps.executeUpdate();
            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, ps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return true;
    }
}
