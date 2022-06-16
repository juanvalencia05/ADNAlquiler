package com.ceiba.alquiler.controlador;

import com.ceiba.modelo.dto.DtoAlquiler;
import com.ceiba.modelo.dto.DtoRespuesta;
import com.ceiba.servicio.ServicioAplicacionCrearAlquiler;
import com.ceiba.servicio.ServicioAplicacionEliminarAlquiler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alquiler")
@Tag(name = "Controlador alquiler")
public class ControladorAlquiler {
    private  final ServicioAplicacionCrearAlquiler servicioCrearAlquiler;

    private final ServicioAplicacionEliminarAlquiler servicioAplicacionEliminarAlquiler;

    public ControladorAlquiler(ServicioAplicacionCrearAlquiler servicioCrearAlquiler, ServicioAplicacionEliminarAlquiler servicioAplicacionEliminarAlquiler) {
        this.servicioCrearAlquiler = servicioCrearAlquiler;
        this.servicioAplicacionEliminarAlquiler = servicioAplicacionEliminarAlquiler;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DtoRespuesta<Integer> crear(@RequestBody DtoAlquiler dto) {
        return this.servicioCrearAlquiler.crear(dto);
    }

    @DeleteMapping({"/{id}"})
    public DtoRespuesta<Integer> eliminar(@PathVariable int id)
    {
        return this.servicioAplicacionEliminarAlquiler.eliminar(id);
    }

}


