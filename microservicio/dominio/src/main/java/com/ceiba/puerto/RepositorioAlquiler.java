package com.ceiba.puerto;

import com.ceiba.dto.AlquilerResumenDto;

public interface RepositorioAlquiler {
    int crear(AlquilerResumenDto alquilerResumenDto);
    AlquilerResumenDto consultarPorId(int id);
    boolean existe(AlquilerResumenDto alquilerResumenDto);
    int eliminar(int id);
}
