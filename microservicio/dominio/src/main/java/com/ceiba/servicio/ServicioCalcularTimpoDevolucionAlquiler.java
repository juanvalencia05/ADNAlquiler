package com.ceiba.servicio;

import com.ceiba.modelo.entidad.Alquiler;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ServicioCalcularTimpoDevolucionAlquiler {

    public String calcularFechaDevolucon(Alquiler alquiler)
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(alquiler.getFechaAlquiler(),formatter);

        localDate = localDate.plusDays(alquiler.getTiempoAlquilado());

       return obtenerTextoFecha(localDate);
    }
    private String obtenerTextoFecha(LocalDate date)
    {

        DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return patron.format(date);
    }

}
