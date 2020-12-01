package br.com.ulbra.dao;

import br.com.ulbra.model.PerfilEnum;
import br.com.ulbra.model.Usuario;
import br.com.ulbra.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends Dao {

    public static ArrayList<Usuario> rankearUsuarios() throws SQLException{
        String sql = "select cq_nome_usuario, cq_pontuacao_usuario from cq_usuario where cq_tipo_usuario = ? order by cq_pontuacao_usuario desc";
        Connection conn = ConnectionFactory.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql);
        ArrayList<Usuario> usuarioAux = new ArrayList<>();
        ps.setString(1, PerfilEnum.USUARIO.getPerfil());

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setNomeUsuario(rs.getString("cq_nome_usuario"));
            usuario.setPontuacao(rs.getInt("cq_pontuacao_usuario"));

            usuarioAux.add(usuario);
        }

        return usuarioAux;
    }

    public void darPontosUsuario(String idUsuario, int pontos) throws SQLException{
        PreparedStatement ps = null;
        String sql = "update cq_usuario set cq_pontuacao_usuario = cq_pontuacao_usuario + ? where cq_id_usuario = ?";

        try {
            Connection conn = obterConexao();
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, pontos);
                ps.setString(2, idUsuario);

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
    }

    public boolean cadastrarUsuario(Usuario usuario) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO cq_usuario (" +
                "cq_id_usuario, " +
                "cq_login_usuario, " +
                "cq_senha_usuario, " +
                "cq_nome_usuario, " +
                "cq_pontuacao_usuario, " +
                "cq_tipo_usuario, " +
                "cq_status_usuario, " +
                "cq_dica_usuario, " +
                " cq_sempre_dificil_usuario)" +
                "values(?,?,?,?,?,?,?,?,?)";

        try {
            Connection conn = obterConexao();
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, usuario.getId());
                ps.setString(2, usuario.getLogin());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getNomeUsuario());
                ps.setInt(5, usuario.getPontuacao());
                ps.setString(6, usuario.getTipoUsuario().getPerfil());
                ps.setInt(7, usuario.getStatus());
                ps.setInt(8, usuario.getDicaAtiva());
                ps.setInt(9, usuario.getSempreDificil());

                ps.executeUpdate();

            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, ps);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new SQLIntegrityConstraintViolationException();
        }
        catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean atualizar(Usuario usuario) {
        PreparedStatement ps = null;
        String sql = "update cq_usuario set cq_pontuacao_usuario = ?, cq_dica_usuario = ?, cq_sempre_dificil_usuario = ? where cq_id_usuario = ?";

        try {
            Connection conn = obterConexao();
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, usuario.getPontuacao());
                ps.setInt(2, usuario.getDicaAtiva());
                ps.setInt(3, usuario.getSempreDificil());
                ps.setString(4, usuario.getId());

                ps.executeUpdate();
            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, ps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public static ArrayList<Usuario> buscarLoginUsuario() throws SQLException {
        ArrayList<Usuario> usuarioAux = new ArrayList<>();
        String sql = "select cq_id_usuario, cq_login_usuario, cq_senha_usuario, cq_nome_usuario, cq_pontuacao_usuario, cq_status_usuario, cq_dica_usuario, cq_sempre_dificil_usuario from cq_usuario where cq_tipo_usuario = ? and cq_status_usuario = ?";

        Connection conn = ConnectionFactory.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, PerfilEnum.USUARIO.getPerfil());
        ps.setInt(2,1);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getString("cq_id_usuario"));
            usuario.setLogin(rs.getString("cq_login_usuario"));
            usuario.setSenha(rs.getString("cq_senha_usuario"));
            usuario.setNomeUsuario(rs.getString("cq_nome_usuario"));
            usuario.setPontuacao(rs.getInt("cq_pontuacao_usuario"));
            usuario.setStatus(rs.getInt("cq_status_usuario"));
            usuario.setDicaAtiva(rs.getInt("cq_dica_usuario"));
            usuario.setSempreDificil(rs.getInt("cq_sempre_dificil_usuario"));

            usuarioAux.add(usuario);
        }

        return usuarioAux;
    }


    public static ArrayList<Usuario> buscarLoginAdmin() throws SQLException {
        ArrayList<Usuario> usuarioAux = new ArrayList<>();
        String sql = "select cq_id_usuario, cq_login_usuario, cq_senha_usuario, cq_nome_usuario, cq_status_usuario from cq_usuario where cq_tipo_usuario = ? and cq_status_usuario = ?";

        Connection conn = ConnectionFactory.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, PerfilEnum.ADMINISTRADOR.getPerfil());
        ps.setInt(2,1);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getString("cq_id_usuario"));
            usuario.setLogin(rs.getString("cq_login_usuario"));
            usuario.setSenha(rs.getString("cq_senha_usuario"));
            usuario.setNomeUsuario(rs.getString("cq_nome_usuario"));
            usuario.setStatus(rs.getInt("cq_status_usuario"));

            usuarioAux.add(usuario);
        }

        return usuarioAux;
    }

    public void cadastrarPerguntaVisualizada(String idUsuario, int idPergunta) throws SQLException{
        PreparedStatement ps = null;
        String sql = "INSERT INTO CQ_PERGUNTA_RESPONDIDA (cq_id_pergunta, cq_id_usuario) VALUES (?, ?)";

        try {
            Connection conn = obterConexao();
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, idPergunta);
                ps.setString(2, idUsuario);


                ps.executeUpdate();

            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, ps);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new SQLIntegrityConstraintViolationException();
        }
        catch (SQLException e) {
            throw new SQLException();
        }
    }
}
