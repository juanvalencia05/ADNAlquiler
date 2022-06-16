package com.ceiba.alquiler.comando.manejador;

import com.ceiba.modelo.dto.DtoRespuesta;
import com.ceiba.servicio.ServicioEliminarAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAlquiler {
    private final ServicioEliminarAlquiler servicioEliminarAlquiler;

    public ManejadorEliminarAlquiler(ServicioEliminarAlquiler servicioEliminarAlquiler) {
        this.servicioEliminarAlquiler = servicioEliminarAlquiler;
    }

    public DtoRespuesta<Integer> eliminar(int id)
    {
        return new DtoRespuesta<>(this.servicioEliminarAlquiler.eliminar(id));
    }
}
