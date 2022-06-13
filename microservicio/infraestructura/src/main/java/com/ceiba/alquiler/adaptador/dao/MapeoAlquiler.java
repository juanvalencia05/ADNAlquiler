package com.ceiba.alquiler.adaptador.dao;
import com.ceiba.dto.AlquilerResumenDto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class MapeoAlquiler implements RowMapper<AlquilerResumenDto>, MapperResult {
    @Override
    public AlquilerResumenDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        var tiempoAlquiler = rs.getInt("tiempo_alquiler");
        var fechaAlquiler = rs.getString("fecha_alquiler");
        var fechaDevolucion = rs.getString("fecha_devolucion");
        var fechaDevolucionReal = rs.getString("fecha_devolucion_real");
        var pago = rs.getInt("pago");

        return new AlquilerResumenDto(tiempoAlquiler,fechaAlquiler,fechaDevolucion,fechaDevolucionReal,pago);
    }
}
