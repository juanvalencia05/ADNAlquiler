package com.ceiba.servicio;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.RepositorioAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionConsultarAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioAplicacionConsultarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public AlquilerResumenDto consultarPorId(int id)
    {
        return this.repositorioAlquiler.consultarPorId(id);
    }
}

