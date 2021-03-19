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
public class Reparto {
    private List<Actor> actores= new ArrayList<>();
    
    public Reparto(){
        
    }
    
    public Reparto(JsonArray a){
        for(int i=0;i<a.size();i++){
            JsonObject o=a.getJsonObject(i);
            actores.add(new Actor(o));
        }
    }
    
    public void add(Actor a){
        actores.add(a);
    }

    public List<Actor> getActores() {
        return actores;
    }
    
    public String toXml()
    {
        String s="<Reparto>";
        for(Actor a : actores){
            s=s+a.toXml();
        }
        s=s+"</Reparto>";
        return s;
        
    }
        
    public JsonArrayBuilder toJson(){
        JsonArrayBuilder ja=Json.createArrayBuilder();
        for(Actor actor : actores){
            ja.add(actor.toJson());
        }
        return ja;
    }
    
    @Override
    public String toString(){
        String s="";
        for (Actor actor : actores)
        {
            s+=actor.toString()+"\n";
        }
        return s;
    }
   
    
}
