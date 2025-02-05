package com.scofield.que_aula_api.exceptions;

public class LoadException extends RuntimeException {

    public LoadException(){
        super("Carregue as disciplinas antes de obtê-las.");
    }

    public LoadException(String mensagem){
        super("Carregue as disciplinas antes de obtê-las: " + mensagem);
    }
}
