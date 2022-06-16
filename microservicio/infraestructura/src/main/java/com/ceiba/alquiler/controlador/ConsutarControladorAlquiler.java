package com.ceiba.alquiler.controlador;

import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.servicio.ServicioAplicacionListarAlquiler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/alquiler")
@Tag(name = "Controlador alquiler")
public class ConsutarControladorAlquiler {

    private final ServicioAplicacionListarAlquiler servicioAplicacionListarAlquiler;

    public ConsutarControladorAlquiler(ServicioAplicacionListarAlquiler servicioAplicacionListarAlquiler) {
        this.servicioAplicacionListarAlquiler = servicioAplicacionListarAlquiler;
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
}
