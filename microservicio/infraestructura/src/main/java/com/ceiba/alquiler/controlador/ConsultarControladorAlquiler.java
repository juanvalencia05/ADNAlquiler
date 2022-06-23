package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.consulta.ManejadorListarAlquiler;
import com.ceiba.modelo.dto.AlquilerResumenDto;
import com.ceiba.alquiler.consulta.ManejadorConsultarAlquiler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/alquiler")
@Tag(name = "Controlador alquiler")
public class ConsultarControladorAlquiler {

    private final ManejadorListarAlquiler manejadorListarAlquiler;
    private final ManejadorConsultarAlquiler manejadorConsultarAlquiler;

    public ConsultarControladorAlquiler( ManejadorListarAlquiler manejadorListarAlquiler, ManejadorConsultarAlquiler manejadorConsultarAlquiler) {
        this.manejadorListarAlquiler = manejadorListarAlquiler;
        this.manejadorConsultarAlquiler = manejadorConsultarAlquiler;
    }

    @GetMapping
    public List<AlquilerResumenDto> listar()
    {
        return manejadorListarAlquiler.listar();
    }

    @GetMapping("/{id}")
    public AlquilerResumenDto listar(@PathVariable int id)
    {
        return manejadorConsultarAlquiler.consultarPorId(id);
    }
}
