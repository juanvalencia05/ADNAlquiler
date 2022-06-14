package com.ceiba.puerto;

import com.ceiba.dto.AlquilerResumenDto;

import java.util.List;

public interface RepositorioAlquiler {
    int crear(AlquilerResumenDto alquilerResumenDto);
    AlquilerResumenDto consultarPorId(int id);
    boolean existe(int  id);
    int eliminar(int id);
    List<AlquilerResumenDto> listar();

}
