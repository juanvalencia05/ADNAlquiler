package com.ceiba.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.RepositorioAlquiler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarAlquilerTest {

    @Test
    void existaAlquiler()
    {
        AlquilerResumenDto alquilerResumenDto = new AlquilerResumenDto();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.consultarPorId(1)).thenReturn(alquilerResumenDto);

        ServicioEliminarAlquiler servicioEliminarAlquiler = new ServicioEliminarAlquiler(repositorioAlquiler);
        servicioEliminarAlquiler.eliminar(1);
        Mockito.verify(repositorioAlquiler,Mockito.times(1)).eliminar(1);
    }
}
