package com.ceiba.controlador;

import com.ceiba.ApplicationMock;

import com.ceiba.alquiler.controlador.ControladorAlquiler;
import com.ceiba.modelo.dto.DtoAlquiler;
import com.ceiba.modelo.dto.DtoRespuesta;
import com.ceiba.puerto.dao.DaoAlquiler;
import com.ceiba.puerto.repositorio.RepositorioAlquiler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ControladorAlquiler.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ControladoAlquilerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoAlquiler daoAlquiler;

    @Test
    void crearAlquilerTest() throws Exception {
        var dto = new DtoAlquilerDataBuilder().build();

        crear(dto);
    }

    private void crear(DtoAlquiler dto) throws Exception{

        var resultado = mocMvc.perform(MockMvcRequestBuilders.post("/alquiler")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        var jsonResult = resultado.getResponse().getContentAsString();

        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult,DtoRespuesta.class);

        int id = respuesta.getValor().intValue();
        Assertions.assertNotNull(id);

        var alquiler = daoAlquiler.consultarPorId(id);

        Assertions.assertEquals(dto.getTiempoAlquilado(),alquiler.getTiempoAlquilado());
        Assertions.assertEquals(dto.getFechaAlquiler(),alquiler.getFechaAlquiler());
        Assertions.assertEquals(dto.getFechaDevolucion(),alquiler.getFechaDevolucion());

    }

    @Test
    @DisplayName("Deberia eliminar un vehiculo")
    void deberiaEliminarVehiculo() throws Exception {
        // arrange
        int  id = 1;
        // act - assert
        mocMvc.perform(delete("/alquiler/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        mocMvc.perform(get("/alquiler")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

    }
}
