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

    public static ArrayList<Pergunta> listarPerguntasUsuario(Usuario usuario) throws SQLException{
        ArrayList<Pergunta> perguntaAux = new ArrayList<>();
        String sql = "select cq_id_pergunta, cq_pergunta, cq_alternativa1, cq_alternativa2, cq_alternativa3, cq_alternativa_correta, cq_dificuldade_pergunta, cq_status_pergunta from cq_pergunta where cq_id_usuario_pergunta = ?";

        Connection conn = ConnectionFactory.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, usuario.getId());

        ResultSet rs = ps.executeQuery();
        while (rs.next()){
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

    public boolean cadastrarPergunta(Pergunta pergunta) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO cq_pergunta (" +
                "cq_id_pergunta, " +
                "cq_pergunta, " +
                "cq_alternativa1, " +
                "cq_alternativa2, " +
                "cq_alternativa3, " +
                "cq_alternativa_correta, " +
                "cq_status_pergunta " +
                "cq_dificuldade_pergunta " +
                " cq_id_usuario_pergunta" +
                "values(SEQ_PERGUNTA.NEXTVAL,?,?,?,?,?,?,?,?)";

        try {
            Connection conn = this.obterConexao();
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
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
