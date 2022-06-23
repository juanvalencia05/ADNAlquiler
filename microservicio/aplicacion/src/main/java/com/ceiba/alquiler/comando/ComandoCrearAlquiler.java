package com.ceiba.alquiler.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComandoCrearAlquiler {
    private  int tiempoAlquilado;
    private  String fechaAlquiler;
    private  String  fechaDevolucion;

}
