package com.ceiba.servicio;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.puerto.RepositorioAlquiler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;


    public ServicioAplicacionListarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }
    public List<AlquilerResumenDto> listar()
    {
        return this.repositorioAlquiler.listar();
    }

    public AlquilerResumenDto consultar(int id){
        return this.repositorioAlquiler.consultarPorId(id);
    }
}
