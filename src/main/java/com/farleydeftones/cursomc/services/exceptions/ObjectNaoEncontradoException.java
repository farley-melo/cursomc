package com.farleydeftones.cursomc.services.exceptions;

public class ObjectNaoEncontradoException extends RuntimeException{
    public ObjectNaoEncontradoException(String mensagem){
        super(mensagem);
    }
    public ObjectNaoEncontradoException(String mensagem,Throwable error){
        super(mensagem,error);
    }
}
