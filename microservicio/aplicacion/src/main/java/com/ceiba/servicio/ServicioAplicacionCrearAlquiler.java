package com.ceiba.servicio;

import com.ceiba.modelo.dto.DtoAlquiler;
import com.ceiba.modelo.dto.DtoRespuesta;
import com.ceiba.modelo.entidad.Alquiler;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionCrearAlquiler {

    private final ServicioCrearAlquiler servicioCrearAlquiler;

    public ServicioAplicacionCrearAlquiler(ServicioCrearAlquiler servicioCrearAlquiler) {
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }

    public DtoRespuesta<Integer> crear(DtoAlquiler dtoAlquiler)
    {
        Alquiler alquiler = Alquiler.of(dtoAlquiler.getTiempoAlquilado(), dtoAlquiler.getFechaAlquiler(), dtoAlquiler.getFechaDevolucion());
        return new DtoRespuesta<>(this.servicioCrearAlquiler.crear(alquiler));
    }
}
