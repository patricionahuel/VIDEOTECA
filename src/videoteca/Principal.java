/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;

/**
 *
 * @author patricio
 */
public class Principal {
    // comentario prueba
    private static Videoteca videoteca = null;

    public static void main(String[] args) {

        int o = -1;
        while (o != 7) {
            menu();
            o = opcion();
            ejecutar(o);

        }

    }

    public static void menu() {

        System.out.println("1. Nueva pelicula");
        System.out.println("2. Nueva Videoteca");
        System.out.println("3. Guardar datos");
        System.out.println("4. Recuperar datos");
        System.out.println("5. Consultar genero de películas");
        System.out.println("6. Consultar película");
        System.out.println("7. Salir");

    }

    public static int opcion() {
        int opcion = 0;
        System.out.println("Introduce opcion");
        Scanner sc = new Scanner(System.in);
        while (opcion < 1 || opcion > 7) {
            opcion = sc.nextInt();
            sc.nextLine();
        }
        return opcion;

    }

    public static void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                nuevaPelicula();
                break;

            case 2:
                nuevaVideoteca();
                break;
            case 3:
                guardar();
                break;
            case 4:
                cargar();
                break;
            case 5:
                consultarGenero();
                break;
            case 6:
                consultarPelicula();
                break;
            case 7:
                System.out.println("adios");
                break;

        }
    }

    public static void nuevaVideoteca() {
        String nombre, ubicacion;
        System.out.println("introduce nombre");
        Scanner sc = new Scanner(System.in);
        nombre = sc.nextLine();
        System.out.println("introduce ubicacion");
        ubicacion = sc.nextLine();
        videoteca = new Videoteca(nombre, ubicacion);

    }

    public static void nuevaPelicula() {

        String titulo, sinopsis, genero, IMDB;
        Reparto reparto;
        System.out.println("introduce titulo");
        Scanner sc = new Scanner(System.in);
        titulo = sc.nextLine();
        System.out.println("introduce sinopsis");
        sinopsis = sc.nextLine();
        System.out.println("introduce genero");
        genero = sc.nextLine();
        System.out.println("introduce IMDB");
        IMDB = sc.nextLine();

        reparto = pedirReparto();

        Pelicula pelicula = new Pelicula(titulo, sinopsis, reparto, genero, IMDB);
        videoteca.add(pelicula);
    }

    public static Reparto pedirReparto() {
        Reparto reparto = new Reparto();
        boolean seguir = true;
        String nombre, enlace;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 1 si quieres introducir un actor, 0 si no quieres");
        int aux = sc.nextInt();
        sc.nextLine();
        seguir = aux == 1;
        while (seguir) {
            System.out.println("Introduce nombre del actor");
            nombre = sc.nextLine();
            System.out.println("Introduce enlace");
            enlace = sc.nextLine();

            Actor a = new Actor(nombre, enlace);
            reparto.add(a);
            System.out.println("Introduce 1 si quieres seguir e intoducir otro actor, 0 si no quieres añadir más");
            aux = sc.nextInt();
            sc.nextLine();
            seguir = aux == 1;
        }

        return reparto;
    }

    static void guardar() {
        String a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del fichero donde guardar");
        a = sc.nextLine();
        File f = new File(a);
        try (FileOutputStream fos = new FileOutputStream(f);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw);) {

            JsonObjectBuilder j = videoteca.toJson();

            pw.print(j.build().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void cargar() {
        String a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre del fichero a cargar");
        a = sc.nextLine();

        File f = new File(a);
        try (FileInputStream fis = new FileInputStream(f);
                InputStreamReader isr = new InputStreamReader(fis);
                JsonParser parser = Json.createParser(isr);) {
            parser.next();
            JsonObject o = parser.getObject();

            videoteca = new Videoteca(o);
            System.out.println("Base de datos JSON cargada.");
        } catch (IOException e) {

        }

    }
    
    public static void consultarPelicula()
    {
        int id;
        System.out.println("introduce id de pelicula");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        sc.nextLine();
        Pelicula p=videoteca.getPelicula(id);
        if(p!=null){
            System.out.println(p);
        }
        else{
            System.out.println("Pelicula no encontrada");
        }
        
        
    }
    public static void consultarGenero()
    {
       String g;
       System.out.println("intriduce genero");
       Scanner sc= new Scanner(System.in);
       g=sc.nextLine();
       
       List<Pelicula> l=videoteca.buscarGenero(g);
       for (Pelicula pelicula: l)
       {
           System.out.println(pelicula);
       }
       
    }
}
