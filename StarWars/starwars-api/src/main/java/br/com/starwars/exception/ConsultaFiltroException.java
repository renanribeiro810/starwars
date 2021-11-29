package br.com.starwars.exception;

public class ConsultaFiltroException extends Exception {
    public ConsultaFiltroException(String message) {
        super(message);
    }

    public ConsultaFiltroException(String message, Throwable cause) {
        super(message, cause);
    }
}
