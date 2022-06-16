package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.comando.manejador.ManejadorEliminarAlquiler;
import com.ceiba.modelo.dto.DtoAlquiler;
import com.ceiba.modelo.dto.DtoRespuesta;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearAlquiler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alquiler")
@Tag(name = "Controlador alquiler")
public class ControladorAlquiler {
    private  final ManejadorCrearAlquiler servicioCrearAlquiler;

    private final ManejadorEliminarAlquiler manejadorEliminarAlquiler;

    public ControladorAlquiler(ManejadorCrearAlquiler servicioCrearAlquiler, ManejadorEliminarAlquiler manejadorEliminarAlquiler) {
        this.servicioCrearAlquiler = servicioCrearAlquiler;
        this.manejadorEliminarAlquiler = manejadorEliminarAlquiler;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DtoRespuesta<Integer> crear(@RequestBody DtoAlquiler dto) {
        return this.servicioCrearAlquiler.crear(dto);
    }

    @DeleteMapping({"/{id}"})
    public DtoRespuesta<Integer> eliminar(@PathVariable int id)
    {
        return this.manejadorEliminarAlquiler.eliminar(id);
    }

}


