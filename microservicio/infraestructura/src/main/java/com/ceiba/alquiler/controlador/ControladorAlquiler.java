package com.ceiba.alquiler.controlador;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.dto.DtoAlquiler;
import com.ceiba.dto.DtoRespuesta;
import com.ceiba.servicio.ServicioAplicacionCrearAlquiler;
import com.ceiba.servicio.ServicioAplicacionEliminarAlquiler;
import com.ceiba.servicio.ServicioAplicacionListarAlquiler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alquiler")
@Tag(name = "Controlador alquiler")
public class ControladorAlquiler {
    private  final ServicioAplicacionCrearAlquiler servicioCrearAlquiler;
    private final ServicioAplicacionListarAlquiler servicioAplicacionListarAlquiler;

    private final ServicioAplicacionEliminarAlquiler servicioAplicacionEliminarAlquiler;

    public ControladorAlquiler(ServicioAplicacionCrearAlquiler servicioCrearAlquiler, ServicioAplicacionListarAlquiler servicioAplicacionListarAlquiler, ServicioAplicacionEliminarAlquiler servicioAplicacionEliminarAlquiler) {
        this.servicioCrearAlquiler = servicioCrearAlquiler;
        this.servicioAplicacionListarAlquiler = servicioAplicacionListarAlquiler;
        this.servicioAplicacionEliminarAlquiler = servicioAplicacionEliminarAlquiler;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DtoRespuesta<Integer> crear(@RequestBody DtoAlquiler dto) {
        return this.servicioCrearAlquiler.crear(dto);
    }

    @GetMapping
    public List<AlquilerResumenDto> listar()
    {
        return servicioAplicacionListarAlquiler.listar();
    }

    @GetMapping("/{id}")
    public AlquilerResumenDto listar(@PathVariable int id)
    {
        return servicioAplicacionListarAlquiler.consultar(id);
    }

    @DeleteMapping({"/{id}"})
    public DtoRespuesta<Integer> eliminar(@PathVariable int id)
    {
        return this.servicioAplicacionEliminarAlquiler.eliminar(id);
    }

}


