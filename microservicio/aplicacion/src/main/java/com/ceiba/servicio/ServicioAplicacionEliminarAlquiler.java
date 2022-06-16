package com.ceiba.servicio;

import com.ceiba.modelo.dto.DtoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarAlquiler {
    private final ServicioEliminarAlquiler servicioEliminarAlquiler;

    public ServicioAplicacionEliminarAlquiler(ServicioEliminarAlquiler servicioEliminarAlquiler) {
        this.servicioEliminarAlquiler = servicioEliminarAlquiler;
    }

    public DtoRespuesta<Integer> eliminar(int id)
    {
        return new DtoRespuesta<>(this.servicioEliminarAlquiler.eliminar(id));
    }
}
