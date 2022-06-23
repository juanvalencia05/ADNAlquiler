package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.AlquilerResumenDto;

import java.util.List;

public interface DaoAlquiler {
    List<AlquilerResumenDto> listar();
    AlquilerResumenDto consultarPorId(int id);
}
