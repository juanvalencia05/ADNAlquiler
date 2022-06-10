package com.ceiba.servicio;

import com.ceiba.modelo.Alquiler;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ServicioCalcularTimpoDevolucionAlquiler {

    public String CalcularFechaDevolucon(Alquiler alquiler)
    {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(alquiler.getFechaAlquiler(),formatter);

        localDate = localDate.plusDays(alquiler.getTiempoAlquilado());

       return obtenerTextoFecha(localDate);
    }
    private String obtenerTextoFecha(LocalDate date)
    {
        String FORMATO_DD_MM_YYYY = "dd/MM/yyyy";

        DateTimeFormatter patron = DateTimeFormatter.ofPattern(FORMATO_DD_MM_YYYY);
        return patron.format(date);
    }

}
