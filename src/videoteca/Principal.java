/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.util.Scanner;

/**
 *
 * @author patricio
 */
public class Principal {
    
    
    private static Videoteca videoteca=null;
    
    public static void main(String[] args) {
        
        
        
    }
    
    public static void menu()
    {
        
       System.out.println("1. Nueva pelicula");
       System.out.println("2. Nueva Videoteca");
       System.out.println("3. Guardar datos");
       System.out.println("4. Recuperar datos");
       System.out.println("5. Consultar genero de películas");
       System.out.println("6. Consultar película");
       
    }
    
    public static int opcion ()
    {
        int opcion=0;
        System.out.println("Introduce opcion");
        Scanner sc=new Scanner(System.in);
        while(opcion<1 && opcion>5)
        {
            opcion= sc.nextInt();
            sc.nextLine();
        }
        return opcion;
        
    }
    
    public void ejecutar (int opcion)
    {
        switch (opcion){
            case 1:
                nuevaPelicula();
                break;
           
            case 2:
               nuevaVideoteca();
               break;
        
        }
    }
    
    public static void nuevaVideoteca(){
        String nombre, ubicacion;
        System.out.println("introduce nombre");
        Scanner sc=new Scanner(System.in);
        nombre=sc.nextLine();
        System.out.println("introduce ubicacion");
        ubicacion=sc.nextLine();
        videoteca=new Videoteca(nombre, ubicacion);

        
    }
    
    public static void nuevaPelicula(){
        
        String titulo, sinopsis,genero, IMDB;
        Reparto reparto;
        System.out.println("introduce titulo");
        Scanner sc=new Scanner(System.in);
        titulo=sc.nextLine();
        System.out.println("introduce sinopsis");
        sinopsis=sc.nextLine();
        System.out.println("introduce genero");
        genero=sc.nextLine();
        System.out.println("introduce IMDB");
        IMDB=sc.nextLine();
        
        reparto=pedirReparto();
        
        Pelicula pelicula=new Pelicula(titulo,sinopsis,reparto,genero,IMDB);
        videoteca.add(pelicula);
    }
    
    public static Reparto pedirReparto(){
        Reparto reparto=new Reparto();
        boolean seguir=true;
        String nombre,enlace;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce 1 si quieres introducir un actor, 0 si no quieres");
        seguir=sc.nextBoolean();
        while(seguir)
        {
           System.out.println("Introduce nombre del actor");
           nombre=sc.nextLine();
           System.out.println("Introduce enlace");
           enlace=sc.nextLine();
           
           Actor a=new Actor(nombre, enlace);
           reparto.add(a);
           System.out.println("Introduce 1 si quieres seguir e intoducir otro actor, 0 si no quieres añadir más");
           seguir=sc.nextBoolean();
        }
        
        
        return reparto;
    }
    
}
