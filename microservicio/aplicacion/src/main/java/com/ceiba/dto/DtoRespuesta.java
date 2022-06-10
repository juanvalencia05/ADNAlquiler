package com.ceiba.dto;

public class DtoRespuesta<T> {
    private T valor;

    public DtoRespuesta(){}

    public DtoRespuesta(T valor)
    {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }
}
