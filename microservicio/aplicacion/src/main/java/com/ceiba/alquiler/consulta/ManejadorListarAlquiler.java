package com.ceiba.alquiler.consulta;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.dao.DaoAlquiler;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ManejadorListarAlquiler {
    private final DaoAlquiler daoAlquiler;

    public ManejadorListarAlquiler(DaoAlquiler daoAlquiler) {
        this.daoAlquiler = daoAlquiler;

    }
    public List<AlquilerResumenDto> listar()
    {
        return this.daoAlquiler.listar();
    }
}
