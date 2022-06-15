package com.ceiba.servicio;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.RepositorioAlquiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAlquilerTest {

    @Test
    void noExistaAlquiler()
    {
        var repositorio = Mockito.mock(RepositorioAlquiler.class);
        var servicio = new ServicioEliminarAlquiler(repositorio);

        Mockito.when(repositorio.consultarPorId(Mockito.anyInt())).thenReturn(null);

        Assertions.assertEquals("No existe el Alquiler con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class,() -> servicio.eliminar(1)).getMessage());
    }

    @Test
    void eliminarAlquiler()
    {
        AlquilerResumenDto alquilerResumenDto = new AlquilerResumenDto();
        var repositorio = Mockito.mock(RepositorioAlquiler.class);
        var servicio = new ServicioEliminarAlquiler(repositorio);

        Mockito.when(repositorio.consultarPorId(Mockito.anyInt())).thenReturn(alquilerResumenDto);

        servicio.eliminar(1);

        Mockito.verify(repositorio,Mockito.times(1)).eliminar(1);

    }

}
