package br.com.ulbra.model;

public class Usuario {
    private String id;
    private String login;
    private String senha;
    private String nomeUsuario;
    private int pontuacao;
    private PerfilEnum tipoUsuario;
    private int status;
    private int dicaAtiva;
    private int sempreDificil;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getId() {
        return id;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public PerfilEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public int getStatus() {
        return status;
    }

    public int getDicaAtiva() {
        return dicaAtiva;
    }

    public int getSempreDificil() {
        return sempreDificil;
    }

    public void setTipoUsuario(PerfilEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDicaAtiva(int dicaAtiva) {
        this.dicaAtiva = dicaAtiva;
    }

    public void setSempreDificil(int sempreDificil) {
        this.sempreDificil = sempreDificil;
    }


}
