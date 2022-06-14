package com.ceiba.servicio;

import com.ceiba.puerto.RepositorioAlquiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarTest {

    @Test
    void noExistaAlquiler()
    {
        var repositorio = Mockito.mock(RepositorioAlquiler.class);
        var servicio = new ServicioEliminarAlquiler(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Alquiler con los datos ingresados",
                Assertions.assertThrows(IllegalArgumentException.class,() -> servicio.eliminar(1)).getMessage());


    }
}
