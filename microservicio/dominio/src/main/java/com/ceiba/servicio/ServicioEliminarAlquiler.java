package com.ceiba.servicio;

import com.ceiba.puerto.RepositorioAlquiler;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarAlquiler {

    private static final String MENSAJE_NO_EXISTE = "No existe el Alquiler con los datos ingresados";

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public int eliminar(int id)
    {
        if(this.repositorioAlquiler.consultarPorId(id) == null)
        {
            throw new IllegalArgumentException(MENSAJE_NO_EXISTE);
        }
        return this.repositorioAlquiler.eliminar(id);
    }
}
