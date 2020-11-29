package br.com.ulbra.model;

public class Pergunta {
    private int id;
    private String pergunta;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String alternativaCorreta;
    private int statusPergunta;
    private int dificuldadePergunta;
    private String idUsuario;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public int getStatusPergunta() {
        return statusPergunta;
    }

    public void setStatusPergunta(int statusPergunta) {
        this.statusPergunta = statusPergunta;
    }

    public int getDificuldadePergunta() {
        return dificuldadePergunta;
    }

    public void setDificuldadePergunta(int dificuldadePergunta) {
        this.dificuldadePergunta = dificuldadePergunta;
    }
}
