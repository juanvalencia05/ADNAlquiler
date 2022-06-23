package com.ceiba.alquiler.comando.manejador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.servicio.ServicioEliminarAlquiler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAlquiler {
    private final ServicioEliminarAlquiler servicioEliminarAlquiler;

    public ManejadorEliminarAlquiler(ServicioEliminarAlquiler servicioEliminarAlquiler) {
        this.servicioEliminarAlquiler = servicioEliminarAlquiler;
    }

    public ComandoRespuesta<Integer> eliminar(int id)
    {
        return new ComandoRespuesta<>(this.servicioEliminarAlquiler.eliminar(id));
    }
}
