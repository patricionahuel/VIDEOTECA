/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.time.LocalDate;

/**
 *
 * @author patricio
 */
public class Videoteca {

    private String nombre;
    private String ubicacion;
    private Peliculas peliculas;
    private LocalDate fechaActualizacion;

    public Videoteca(String nombre, String ubicacion, Peliculas peliculas, LocalDate fechaActualizacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.peliculas = peliculas;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Peliculas getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Peliculas peliculas) {
        this.peliculas = peliculas;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public String toXml()
    {
        String s="<Videoteca><nombre>"+nombre+"</nombre><ubicacion"+ubicacion+"</ubicacion>"+peliculas.toXml()+"<fechaActualizacion>"+fechaActualizacion+"</fechaActualizacion></Videoteca>";
        return s;
    
        
    }
    
    
   
    
}
