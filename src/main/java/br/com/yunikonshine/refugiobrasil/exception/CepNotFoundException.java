package br.com.yunikonshine.refugiobrasil.exception;

public class CepNotFoundException extends Exception {

    public CepNotFoundException() {
        super("CEP not found");
    }

}
