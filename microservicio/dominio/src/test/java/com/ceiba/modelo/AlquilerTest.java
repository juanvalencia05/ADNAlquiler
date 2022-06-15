package com.ceiba.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlquilerTest {
    @Test
    void validarCreacionExitos()
    {
        int tiempoAlquilado = 5;
        String fechaAlquiler= "07/06/2022";
        String  fechaDevolucion= "12/06/2022";

        Alquiler alquiler = Alquiler.of(tiempoAlquilado,fechaAlquiler,fechaDevolucion);

        Assertions.assertEquals(5,alquiler.getTiempoAlquilado());
        Assertions.assertEquals("07/06/2022",alquiler.getFechaAlquiler());
        Assertions.assertEquals("12/06/2022", alquiler.getFechaDevolucion());
    }
    @Test
    void ValidarCamposFaltante()
    {

      Assertions.assertEquals("La fecha del dia del alquiler no puede estar vacia",Assertions.assertThrows(IllegalArgumentException.class,() ->
              Alquiler.of(5,"","12/06/2022")).getMessage());

        Assertions.assertEquals("La fecha del dia de devolucion no puede estar vacia",Assertions.assertThrows(IllegalArgumentException.class,() ->
                Alquiler.of(5,"07/06/2022","")).getMessage());

        Assertions.assertEquals("El numero de dias de Alquiler no puede ser cero, ni negativo",Assertions.assertThrows(IllegalArgumentException.class,() ->
                Alquiler.of(0,"07/06/2022","12/06/2022")).getMessage());

    }
}
