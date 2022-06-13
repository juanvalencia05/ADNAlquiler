package com.ceiba.servicio;

import com.ceiba.AlquilerTestDataBuilder;
import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.RepositorioAlquiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearTest {

    @Test
    void guardarExitoso()
    {
        var alquiler = new AlquilerTestDataBuilder().build();

         var repositorio = Mockito.mock(RepositorioAlquiler.class);
         var servicioCalcularFecha = new ServicioCalcularTimpoDevolucionAlquiler();
         var servicioCalularPago = new ServicioCalcularPago(servicioCalcularFecha);
         var servicio = new ServicioCrearAlquiler(repositorio,servicioCalularPago,servicioCalcularFecha);


         Mockito.when(repositorio.crear(Mockito.any(AlquilerResumenDto.class))).thenReturn(1);

         var id = servicio.crear(alquiler);

         Mockito.verify(repositorio,Mockito.times(1));

        Assertions.assertEquals(1,id);
    }
}
