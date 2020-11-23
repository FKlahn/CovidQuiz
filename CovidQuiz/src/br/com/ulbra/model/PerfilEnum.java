package br.com.ulbra.model;

public enum PerfilEnum {

    USUARIO("USUARIO"),
    ADMINISTRADOR("ADMIN");

    private final String perfil;

    private PerfilEnum(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
}
