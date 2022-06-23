package com.ceiba.alquiler.consulta;

import com.ceiba.modelo.dto.AlquilerResumenDto;
import com.ceiba.puerto.dao.DaoAlquiler;

import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarAlquiler {

    private final DaoAlquiler daoAlquiler;

    public ManejadorConsultarAlquiler(DaoAlquiler daoAlquiler) {
        this.daoAlquiler = daoAlquiler;
    }

    public AlquilerResumenDto consultarPorId(int id)
    {
        return this.daoAlquiler.consultarPorId(id);
    }
}

