package com.ceiba.controlador;

import com.ceiba.ApplicationMock;

import com.ceiba.alquiler.controlador.ConsutarControladorAlquiler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsutarControladorAlquiler.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorAlquilerTest {
    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Debe listar los alquiler luego de crearlas")
    void listarTest() throws Exception {

        var dto = new DtoAlquilerDataBuilder().build();


        mocMvc.perform(MockMvcRequestBuilders.get("/alquiler")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].tiempoAlquilado", is(dto.getTiempoAlquilado())))
                .andExpect(jsonPath("$[0].fechaAlquiler",is(dto.getFechaAlquiler())))
                .andExpect(jsonPath("$[0].fechaDevolucion", is(dto.getFechaDevolucion())));
    }

}
