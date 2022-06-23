package com.ceiba.servicio;

import com.ceiba.puerto.dao.DaoAlquiler;
import com.ceiba.puerto.repositorio.RepositorioAlquiler;



public class ServicioEliminarAlquiler {

    private static final String MENSAJE_NO_EXISTE = "No existe el Alquiler con los datos ingresados";

    private final RepositorioAlquiler repositorioAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ServicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler, DaoAlquiler daoAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.daoAlquiler = daoAlquiler;
    }

    public int eliminar(int id)
    {
        if(this.daoAlquiler.consultarPorId(id) == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return this.repositorioAlquiler.eliminar(id);
    }
}
