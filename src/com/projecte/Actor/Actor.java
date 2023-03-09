package com.projecte.Actor;


import java.util.ArrayList;
import com.projecte.Pelicula.Pelicula;

public class Actor {

    private static int id=1;
    private String nombre;
    private int dataNacimiento;
    private ArrayList<Pelicula> peliculas;


    //getters setters
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Actor.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDataNacimiento() {
        return dataNacimiento;
    }
    public void setDataNacimiento(int dataNacimiento) {
        this.dataNacimiento = dataNacimiento;
    }
    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }


    //constructor
    public Actor(String nombre, int dataNacimiento, ArrayList<Pelicula> peliculas) {
        super();
        this.nombre = nombre;
        this.dataNacimiento = dataNacimiento;
        this.peliculas = peliculas;
    }

    public void mostrarPelicules() {
        System.out.println("Peliculas donde ha participado el actor "+getNombre()+":");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo());
        }

    }



}
