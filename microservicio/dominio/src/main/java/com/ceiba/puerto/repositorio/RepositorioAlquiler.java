package com.ceiba.puerto.repositorio;

import com.ceiba.dto.AlquilerResumenDto;

public interface RepositorioAlquiler {
    int crear(AlquilerResumenDto alquilerResumenDto);
    int eliminar(int id);

}
