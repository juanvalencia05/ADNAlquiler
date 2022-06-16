package com.ceiba.servicio;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.dao.DaoAlquiler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarAlquiler {

    private final DaoAlquiler daoAlquiler;

    public ServicioAplicacionListarAlquiler(DaoAlquiler daoAlquiler) {
        this.daoAlquiler = daoAlquiler;

    }
    public List<AlquilerResumenDto> listar()
    {
        return this.daoAlquiler.listar();
    }

    public AlquilerResumenDto consultar(int id){
        return this.daoAlquiler.consultarPorId(id);
    }
}
