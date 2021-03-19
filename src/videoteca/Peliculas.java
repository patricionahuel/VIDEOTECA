/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 *
 * @author patricio
 */
public class Peliculas {
    private List<Pelicula> peliculas= new ArrayList<>();
    
    public Peliculas(){
        
    }
    
    public Peliculas (JsonArray a)
    {
        for (int i=0; i<a.size();i++)
        {
            JsonObject o=a.getJsonObject(i);
            peliculas.add(new Pelicula(o));
        }
        
    }
    
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
        
    public Pelicula get(int id){
        
       
        for(Pelicula pelicula : peliculas){
           if(pelicula.getId()==id){
               return pelicula;
           }
        }
        return null;
    }
        
    public List<Pelicula> buscarGenero(String genero){
        List<Pelicula> l=new ArrayList<>();
        for(Pelicula pelicula : peliculas)
        {
            if(pelicula.getGenero().equals(genero))
            {
                l.add(pelicula);
            }
        }
        
        
        return l;
    }
        
    
}
