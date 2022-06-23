package com.ceiba.alquiler.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoCrearAlquiler;
import com.ceiba.modelo.entidad.Alquiler;
import com.ceiba.servicio.ServicioCrearAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearAlquiler {

    private final ServicioCrearAlquiler servicioCrearAlquiler;

    public ManejadorCrearAlquiler(ServicioCrearAlquiler servicioCrearAlquiler) {
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }

    public ComandoRespuesta<Integer> crear(ComandoCrearAlquiler comandoCrearAlquiler)
    {
        Alquiler alquiler = Alquiler.of(comandoCrearAlquiler.getTiempoAlquilado(), comandoCrearAlquiler.getFechaAlquiler(), comandoCrearAlquiler.getFechaDevolucion());
        return new ComandoRespuesta<>(this.servicioCrearAlquiler.crear(alquiler));
    }
}
