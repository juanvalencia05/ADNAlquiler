package com.ceiba.servicio;

import com.ceiba.modelo.dto.AlquilerResumenDto;
import com.ceiba.modelo.entidad.Alquiler;
import com.ceiba.puerto.repositorio.RepositorioAlquiler;



public class ServicioCrearAlquiler {
    private final RepositorioAlquiler repositorioAlquiler;
    private final ServicioCalcularPago servicioCalcularPago;
    private final ServicioCalcularTimpoDevolucionAlquiler servicioCalcularTimpoDevolucionAlquiler;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, ServicioCalcularPago servicioCalcularPago, ServicioCalcularTimpoDevolucionAlquiler servicioCalcularTimpoDevolucionAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.servicioCalcularPago = servicioCalcularPago;
        this.servicioCalcularTimpoDevolucionAlquiler = servicioCalcularTimpoDevolucionAlquiler;
    }
    public int crear(Alquiler alquiler)
    {
        String fechaDevolucionCalculada =this.servicioCalcularTimpoDevolucionAlquiler.calcularFechaDevolucon(alquiler);
        int pago =this.servicioCalcularPago.calcularPago(alquiler);
        AlquilerResumenDto alquilerResumen = new AlquilerResumenDto(1, alquiler.getTiempoAlquilado(),
                alquiler.getFechaAlquiler(),alquiler.getFechaDevolucion(),fechaDevolucionCalculada,pago);
        return this.repositorioAlquiler.crear(alquilerResumen);
    }
}
