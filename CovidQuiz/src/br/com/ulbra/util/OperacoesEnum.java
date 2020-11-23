package br.com.ulbra.util;

public enum OperacoesEnum {

    NOVO(1), EDITAR(2), EXCLUIR(3);

    private final Integer operacao;

    private OperacoesEnum(Integer operacao) {
        this.operacao = operacao;
    }

    public Integer getOperacao() {
        return operacao;
    }
}
