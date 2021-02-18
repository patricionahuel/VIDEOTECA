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
public class Reparto {
    private List<Actor> actores= new ArrayList<>();
    
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
        
    
}
