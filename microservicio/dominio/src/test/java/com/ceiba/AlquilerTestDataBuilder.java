package com.ceiba;

import com.ceiba.modelo.entidad.Alquiler;

public class AlquilerTestDataBuilder {
    private int tiempoAlquilado;
    private String fechaAlquiler;
    private String  fechaDevolucion;

    public AlquilerTestDataBuilder()
    {
        this.tiempoAlquilado = 5;
        this.fechaDevolucion = "06/06/2022";
        this.fechaAlquiler = "05/06/2022";
    }

    public AlquilerTestDataBuilder conTiempoAlquiler(int tiempoAlquilado) {
        this.tiempoAlquilado = tiempoAlquilado;
        return this;
    }
    public AlquilerTestDataBuilder conFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        return this;
    }
    public AlquilerTestDataBuilder conFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        return this;
    }
    public Alquiler build()
    {
        return Alquiler.of(tiempoAlquilado,fechaAlquiler,fechaDevolucion);
    }
}
