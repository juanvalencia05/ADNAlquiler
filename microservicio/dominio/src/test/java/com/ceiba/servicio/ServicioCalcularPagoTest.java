package com.ceiba.servicio;

import com.ceiba.modelo.Alquiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicioCalcularPagoTest {
    @Test
    void ValidarCalculoDelPagoSinDiasExtra()
    {
        int tiempoAlquilado = 5;
        String fechaAlquiler= "07/06/2022";
        String  fechaDevolucion= "12/06/2022";
        Alquiler alquiler = Alquiler.of(tiempoAlquilado,fechaAlquiler,fechaDevolucion);

        ServicioCalcularPago servicio = new ServicioCalcularPago(new ServicioCalcularTimpoDevolucionAlquiler());

        int pago = servicio.calcularPago(alquiler);

        Assertions.assertEquals(200000,pago);
    }
    @Test
    void ValidarCalculoDelPagoConDiasExtra()
    {
        int tiempoAlquilado = 5;
        String fechaAlquiler= "07/06/2022";
        String  fechaDevolucion= "13/06/2022";
        Alquiler alquiler = Alquiler.of(tiempoAlquilado,fechaAlquiler,fechaDevolucion);

        ServicioCalcularPago servicio = new ServicioCalcularPago(new ServicioCalcularTimpoDevolucionAlquiler());

        int pago = servicio.calcularPago(alquiler);

        Assertions.assertEquals(260000,pago);
    }
    @Test
    void ValidarCalculoDelPagoSinCumplidoDiaDevolucion()
    {
        int tiempoAlquilado = 10;
        String fechaAlquiler= "07/06/2022";
        String  fechaDevolucion= "12/06/2022";
        Alquiler alquiler = Alquiler.of(tiempoAlquilado,fechaAlquiler,fechaDevolucion);

        ServicioCalcularPago servicio = new ServicioCalcularPago(new ServicioCalcularTimpoDevolucionAlquiler());

        int pago = servicio.calcularPago(alquiler);

        Assertions.assertEquals(200000,pago);
    }
}
