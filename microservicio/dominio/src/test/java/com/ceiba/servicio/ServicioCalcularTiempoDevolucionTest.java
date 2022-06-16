package com.ceiba.servicio;

import com.ceiba.modelo.entidad.Alquiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicioCalcularTiempoDevolucionTest {
    @Test
    void ValidaCalculoTiempoDevolucion()
    {
        int tiempoAlquilado = 5;
        String fechaAlquiler= "07/06/2022";
        String  fechaDevolucion= "13/06/2022";
        Alquiler alquiler = Alquiler.of(tiempoAlquilado,fechaAlquiler,fechaDevolucion);

        ServicioCalcularTimpoDevolucionAlquiler servicio= new ServicioCalcularTimpoDevolucionAlquiler();

        String fecha = servicio.calcularFechaDevolucon(alquiler);

        Assertions.assertEquals("12/06/2022",fecha);

    }
}
