package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlquilerResumenDto {
    private int id;
    private  int tiempoAlquilado;
    private String fechaAlquiler;
    private String  fechaDevolucion;
    private String  fechaDevolucionReal;
    private int totalAPagar;

}
