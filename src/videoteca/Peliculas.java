/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author patricio
 */
public class Peliculas {
      private List<Pelicula> peliculas= new ArrayList<>();
    
    public void add(Pelicula a){
        peliculas.add(a);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }
    
    public String toXml()
    
    {
        String s="<Peliculas>";
        for(Pelicula a : peliculas){
            s=s+a.toXml();
        }
        s=s+"</Peliculas>";
        return s;
        
    }
        
    
}
