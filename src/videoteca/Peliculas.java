/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;

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
      
    public JsonArrayBuilder toJson(){
        JsonArrayBuilder ja=Json.createArrayBuilder();
        for(Pelicula pelicula : peliculas){
            ja.add(pelicula.toJson());
        }
        
        return ja;
        
        
    }
        
        
        
        
    
}
