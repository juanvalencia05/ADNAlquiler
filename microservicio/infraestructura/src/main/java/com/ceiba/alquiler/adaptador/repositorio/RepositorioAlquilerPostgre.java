package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.alquiler.adaptador.dao.MapeoAlquiler;
import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.puerto.RepositorioAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioAlquilerPostgre implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoAlquiler mapeoAlquiler;

    public RepositorioAlquilerPostgre(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoAlquiler mapeoAlquiler) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoAlquiler = mapeoAlquiler;
    }

    @SqlStatement(namespace = "alquiler", value = "obteneralquilerporid")
    private static String sqlObtenerAlquilePorId;

    @SqlStatement(namespace = "alquiler", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "alquiler", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "alquiler", value = "consultar")
    private static String sqlConsultar;

    @SqlStatement(namespace = "alquiler", value = "existe")
    private static String sqlExiste;


    @Override
    public int crear(AlquilerResumenDto alquilerResumenDto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tiempo_alquiler", alquilerResumenDto.getTiempoAlquilado());
        paramSource.addValue("fecha_alquiler", alquilerResumenDto.getFechaAlquiler());
        paramSource.addValue("fecha_devolucion", alquilerResumenDto.getFechaDevolucion());
        paramSource.addValue("fecha_devolucion_real", alquilerResumenDto.getFechaDevolucionReal());
        paramSource.addValue("pago", alquilerResumenDto.getTotalAPagar());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear).intValue();
    }

    @Override
    public AlquilerResumenDto consultarPorId(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                        .queryForObject(sqlObtenerAlquilePorId,paramSource, new MapeoAlquiler()));

    }

    @Override
    public boolean existe(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource,Boolean.class);

    }

    @Override
    public int eliminar(int id) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        EjecucionBaseDeDatos.obtenerUnObjetoONull(()->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,paramSource));

        return id;
    }

    @Override
    public List<AlquilerResumenDto> listar() {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.getValues();

        List<AlquilerResumenDto> alquiler = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlConsultar, paramSource, mapeoAlquiler );

        return alquiler.stream().map(alqui -> new AlquilerResumenDto(alqui.getTiempoAlquilado(),alqui.getFechaAlquiler(),
                alqui.getFechaDevolucion(),alqui.getFechaDevolucionReal(),alqui.getTotalAPagar())).toList();
    }
}
