package com.ceiba.servicio;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.dao.DaoAlquiler;

import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionConsultarAlquiler {

    private final DaoAlquiler daoAlquiler;

    public ServicioAplicacionConsultarAlquiler(DaoAlquiler daoAlquiler) {
        this.daoAlquiler = daoAlquiler;
    }

    public AlquilerResumenDto consultarPorId(int id)
    {
        return this.daoAlquiler.consultarPorId(id);
    }
}

