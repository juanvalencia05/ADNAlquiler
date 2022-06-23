package com.ceiba.modelo.entidad;

import lombok.Getter;

@Getter
public class Alquiler {

    private static final String NUMERO_DIAS_MAYOR_A_CERO = "El numero de dias de Alquiler no puede ser cero, ni negativo";
    private static final String FECHA_ALQUILER_NO_VACIA = "La fecha del dia del alquiler no puede estar vacia";
    private static final String FECHA_DEVOLUCION_NO_VACIA = "La fecha del dia de devolucion no puede estar vacia";
    private final int tiempoAlquilado;
    private final String fechaAlquiler;
    private final  String  fechaDevolucion;

    public static Alquiler of(int tiempoAlquilado, String fechaAlquiler, String fechaDevolucion )
    {
        validarDiferenteDeCero(tiempoAlquilado, NUMERO_DIAS_MAYOR_A_CERO);
        validarObligatorio(fechaAlquiler,FECHA_ALQUILER_NO_VACIA);
        validarObligatorio(fechaDevolucion,FECHA_DEVOLUCION_NO_VACIA);

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
        if (valor <= 0)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
