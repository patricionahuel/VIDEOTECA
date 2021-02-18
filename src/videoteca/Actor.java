/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

/**
 *
 * @author patricio
 */
public class Actor {
    
    private String nombre;
    private String enlace;
    
    public Actor (String nombre,  String enlace)
    {
        this.nombre=nombre;
        this.enlace=enlace;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    
    
    public String toXml()
    {
        return "<Actor><nombre>"+nombre+"</nombre><enlace>"+enlace+"</enlace></Actor>";
    }
    
    
}
