package br.com.ulbra.util;

public class ConexaoException extends Exception{
    public ConexaoException() {

    }

    public ConexaoException(String arg0) {
        super(arg0);
    }

    public ConexaoException(Throwable arg0) {
        super(arg0);
    }

    public ConexaoException(String arg0, Throwable arg1) {
        super(arg0,arg1);
    }
}
