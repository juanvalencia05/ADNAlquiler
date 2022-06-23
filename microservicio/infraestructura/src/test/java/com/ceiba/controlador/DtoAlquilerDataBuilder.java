package com.ceiba.controlador;

import com.ceiba.alquiler.comando.ComandoCrearAlquiler;

public class DtoAlquilerDataBuilder {

    private  int tiempoAlquilado;
    private  String fechaAlquiler;
    private  String  fechaDevolucion;

    public DtoAlquilerDataBuilder() {
        this.tiempoAlquilado = 5;
        this.fechaAlquiler = "06/06/2022";
        this.fechaDevolucion ="10/06/2022" ;

    }

    public ComandoCrearAlquiler build() {
        return new ComandoCrearAlquiler(tiempoAlquilado,fechaAlquiler,fechaDevolucion);
    }
}
