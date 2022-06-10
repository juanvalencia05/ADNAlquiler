package com.ceiba.servicio;

import com.ceiba.modelo.Alquiler;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
@Service
public class ServicioCalcularPago {
    private static final int VALOR_DIA = 40000;
    private static final int VALOR_MULTA = 60000;

    private final ServicioCalcularTimpoDevolucionAlquiler servicioCalcularTimpoDevolucionAlquiler;

    public ServicioCalcularPago(ServicioCalcularTimpoDevolucionAlquiler servicioCalcularTimpoDevolucionAlquiler) {
        this.servicioCalcularTimpoDevolucionAlquiler = servicioCalcularTimpoDevolucionAlquiler;
    }

    public int CalcularPago(Alquiler alquiler)
    {
        String fechadevolucionCalculada = this.servicioCalcularTimpoDevolucionAlquiler.CalcularFechaDevolucon(alquiler);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechadevolucionReal = LocalDate.parse(alquiler.getFechaDevolucion(), formatter);
        LocalDate fechadevolucion = LocalDate.parse(fechadevolucionCalculada,formatter);

        if(alquiler.getFechaDevolucion().equals(fechadevolucionCalculada))
        {
              return alquiler.getTiempoAlquilado()*VALOR_DIA;

        } else{

            Long dias = DAYS.between(fechadevolucion,fechadevolucionReal);


            if(dias<0)
            {
                return (int) (dias+ alquiler.getTiempoAlquilado())*VALOR_DIA;
            }else
            {
                int pago = alquiler.getTiempoAlquilado()*VALOR_DIA;
                int pagoMulta = (int) (dias*VALOR_MULTA);
                return pago+pagoMulta;
            }
        }
    }
}
