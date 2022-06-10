package com.ceiba.alquiler.controlador;


import com.ceiba.dto.DtoAlquiler;
import com.ceiba.dto.DtoRespuesta;
import com.ceiba.servicio.ServicioAplicacionCrearAlquiler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alquiler")
@Tag(name = "Controlador alquiler")
public class ControladorAlquiler {
    private  final ServicioAplicacionCrearAlquiler servicioCrearAlquiler;

    public ControladorAlquiler(ServicioAplicacionCrearAlquiler servicioCrearAlquiler) {
        this.servicioCrearAlquiler = servicioCrearAlquiler;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DtoRespuesta<Integer> crear(@RequestBody DtoAlquiler dto) {
        return this.servicioCrearAlquiler.crear(dto);
    }
}


