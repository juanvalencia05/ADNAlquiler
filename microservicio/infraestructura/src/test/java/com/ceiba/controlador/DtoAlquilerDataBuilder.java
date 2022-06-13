package com.ceiba.controlador;

import com.ceiba.dto.DtoAlquiler;

public class DtoAlquilerDataBuilder {

    private  int tiempoAlquilado;
    private  String fechaAlquiler;
    private  String  fechaDevolucion;

    public DtoAlquilerDataBuilder() {
        this.tiempoAlquilado = 5;
        this.fechaAlquiler = "06/06/2022";
        this.fechaDevolucion ="10/06/2022" ;

    }

    public DtoAlquiler build() {
        return new DtoAlquiler(tiempoAlquilado,fechaAlquiler,fechaDevolucion);
    }
}
