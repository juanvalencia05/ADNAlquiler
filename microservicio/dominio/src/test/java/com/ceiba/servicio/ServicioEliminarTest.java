package com.ceiba.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.puerto.RepositorioAlquiler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarTest {
    @Test
    void debeLanzarUnaExcepcionEliminandoAlquiler()
    {
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existe(Mockito.anyInt())).thenReturn(true);

        ServicioEliminarAlquiler servicioEliminarAlquiler = new ServicioEliminarAlquiler(repositorioAlquiler);

        BasePrueba.assertThrows(()->servicioEliminarAlquiler.eliminar(Mockito.anyInt()),IllegalArgumentException.class
        ,"No existe el Alquiler con los datos ingresados");

    }
}
