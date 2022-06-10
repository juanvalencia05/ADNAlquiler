package com.ceiba.modelo;

import lombok.Getter;

@Getter
public class Alquiler {

    private final int tiempoAlquilado;
    private final String fechaAlquiler;
    private final  String  fechaDevolucion;

    public static Alquiler of(int tiempoAlquilado, String fechaAlquiler, String fechaDevolucion )
    {
        validarDiferenteDeCero(tiempoAlquilado, "El numero de dias de Alquiler no puede ser cero , ni negativo");
        validarObligatorio(fechaAlquiler,"La fecha del dia del alquiler no puede estar vacia");
        validarObligatorio(fechaDevolucion,"La fecha del dia de devolucion no puede estar vacia");

        return new Alquiler(tiempoAlquilado,fechaAlquiler, fechaDevolucion);
    }

    public Alquiler(int tiempoAlquilado, String fechaAlquiler, String fechaDevolucion) {
        this.tiempoAlquilado = tiempoAlquilado;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    public static void validarObligatorio(String valor, String mensaje)
    {
        if(valor== null || valor.isEmpty())
        {
            throw new IllegalArgumentException(mensaje);
        }
    }
    public static void validarDiferenteDeCero(int valor, String mensaje)
    {
        if (valor==0 || valor < 0)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
