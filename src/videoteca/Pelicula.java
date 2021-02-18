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
public class Pelicula {
    private int id;
    private String titulo;
    private String sinopsis;
    private Reparto reparto;
    private String genero;
    private String IMDB;

    public Pelicula(int id, String titulo, String sinopsis, Reparto reparto, String genero, String IMDB) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.genero = genero;
        this.IMDB = IMDB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIMDB() {
        return IMDB;
    }

    public void setIMDB(String IMDB) {
        this.IMDB = IMDB;
    }
    
    public String toXml ()
    {
        String s="<Pelicula><id>"+id+"</id><titulo>"+titulo+"</titulo><sinopsis>"+sinopsis+"</sinopsis>"+reparto.toXml()+"<genero>"+genero+"</genero><IMDB>"+IMDB+"</IMDB></Pelicula>";
        return s;
        
    }
    
    
    
}


