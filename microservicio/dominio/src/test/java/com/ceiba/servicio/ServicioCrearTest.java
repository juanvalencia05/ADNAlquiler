package com.ceiba.servicio;

import com.ceiba.AlquilerTestDataBuilder;
import com.ceiba.modelo.dto.AlquilerResumenDto;
import com.ceiba.puerto.repositorio.RepositorioAlquiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearTest {

    @Test
    void crearExitoso()
    {
        var alquiler = new AlquilerTestDataBuilder().build();
        var alquilerDto = new AlquilerResumenDto();

         var repositorio = Mockito.mock(RepositorioAlquiler.class);
         var servicioCalcularFecha = new ServicioCalcularTimpoDevolucionAlquiler();
         var servicioCalularPago = new ServicioCalcularPago(servicioCalcularFecha);
         var servicio = new ServicioCrearAlquiler(repositorio,servicioCalularPago,servicioCalcularFecha);


         Mockito.when(repositorio.crear((alquilerDto))).thenReturn(1);

         var id = servicio.crear(alquiler);

        Assertions.assertEquals(0,id);


    }


}
