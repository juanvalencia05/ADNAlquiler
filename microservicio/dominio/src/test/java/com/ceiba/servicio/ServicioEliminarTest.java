package com.ceiba.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.puerto.RepositorioAlquiler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



public class ServicioEliminarTest {

    @AfterEach
    @Test
    void deberiaEliminarElAlquiler() {
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existe(Mockito.anyInt())).thenReturn(false);

        ServicioEliminarAlquiler servicioEliminarAlquiler = new ServicioEliminarAlquiler(repositorioAlquiler);

        BasePrueba.assertThrows(() -> servicioEliminarAlquiler.eliminar((int) Mockito.anyLong()), ExcepcionDuplicidad.class, "No existe el Alquiler con los datos ingresados");

    }
}
