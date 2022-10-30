package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.modelo.dto.AlquilerResumenDto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.puerto.dao.DaoAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DaoAlquilerPostgre implements DaoAlquiler {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoAlquiler mapeoAlquiler;

    public DaoAlquilerPostgre(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoAlquiler mapeoAlquiler) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoAlquiler = mapeoAlquiler;
    }
    @SqlStatement(namespace = "alquiler", value = "consultar")
    private static String sqlConsultar;

    @SqlStatement(namespace = "alquiler", value = "obteneralquilerporid")
    private static String sqlObtenerAlquilePorId;

    @Override
    public List<AlquilerResumenDto> listar() {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.getValues();

        List<AlquilerResumenDto> alquiler = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlConsultar, paramSource, mapeoAlquiler );

        return alquiler.stream().map(alqui -> new AlquilerResumenDto(alqui.getId(), alqui.getTiempoAlquilado(),alqui.getFechaAlquiler(),
                alqui.getFechaDevolucion(),alqui.getFechaDevolucionReal(),alqui.getTotalAPagar())).toList();
    }

    @Override
    public AlquilerResumenDto consultarPorId(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                        .queryForObject(sqlObtenerAlquilePorId,paramSource, new MapeoAlquiler()));

    }

}
