package com.ceiba.configuracion;

import com.ceiba.puerto.dao.DaoAlquiler;
import com.ceiba.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.servicio.ServicioCalcularPago;
import com.ceiba.servicio.ServicioCalcularTimpoDevolucionAlquiler;
import com.ceiba.servicio.ServicioCrearAlquiler;
import com.ceiba.servicio.ServicioEliminarAlquiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCalcularTimpoDevolucionAlquiler servicioCalcularTimpoDevolucionAlquiler(){
        return new ServicioCalcularTimpoDevolucionAlquiler();
    }

    @Bean
    public ServicioCalcularPago servicioCalcularPago(ServicioCalcularTimpoDevolucionAlquiler servicioCalcularTimpoDevolucionAlquiler){
        return new ServicioCalcularPago(servicioCalcularTimpoDevolucionAlquiler);
    }

    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, ServicioCalcularPago servicioCalcularPago, ServicioCalcularTimpoDevolucionAlquiler servicioCalcularTimpoDevolucionAlquiler){
        return new ServicioCrearAlquiler(repositorioAlquiler,servicioCalcularPago,servicioCalcularTimpoDevolucionAlquiler);
    }
    @Bean
    public ServicioEliminarAlquiler servicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler, DaoAlquiler daoAlquiler)
    {
        return new ServicioEliminarAlquiler(repositorioAlquiler,daoAlquiler);
    }
}
