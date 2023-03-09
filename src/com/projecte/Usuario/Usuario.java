package com.projecte.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import com.projecte.Actor.*;
import com.projecte.Pelicula.*;
import com.projecte.Director.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Usuario {
    private static int id=1;
    private String nom;
    private String apellidos;
    private String correoElectronico;
    private String contra;
    private String dataNacimiento;
    private String rol;

    private String poblacio;
    private ArrayList<Pelicula> pelicules;
    private ArrayList<Director> directors;
    private ArrayList<Actor> actors;


    //geters seters
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Usuario.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getDataNacimiento() {
        return dataNacimiento;
    }

    public void setDataNacimiento(String dataNacimiento) {
        this.dataNacimiento = dataNacimiento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ArrayList<Pelicula> getPelicules() {
        return pelicules;
    }

    public void setPeliculas(ArrayList<Pelicula> pelicules) {
        this.pelicules = pelicules;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }





    //costructor sin listas
    public Usuario(String nom, String apellidos, String correoElectronico, String contra, String dataNacimiento,
                   String poblacio, int id) {
        super();
        this.id = id;
        this.nom = nom;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.contra = contra;
        this.dataNacimiento = dataNacimiento;
        this.rol="ROL_USUARIO";
        this.poblacio=poblacio;
        crearCarpetas();
    }


    //costructor sin listas
    public Usuario(String nom, String apellidos, String correoElectronico, String contra, String dataNacimiento,
                   String rol, String poblacio, int id) {
        super();
        this.id = id;
        this.nom = nom;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.contra = contra;
        this.dataNacimiento = dataNacimiento;
        this.rol = rol;
        this.poblacio=poblacio;
        crearCarpetas();
    }

    //crea la carpeta del usuario con su correo y hace los 3 archivos para las listas
    public void crearCarpetas() {
        String usuario = correoElectronico.substring(0, correoElectronico.indexOf('@'));
        File carpeta = new File(usuario);
        carpeta.mkdir();

        // Crear tres archivos de texto dentro de la carpeta
        String[] archivosNombres = {"actors.txt", "directors.txt", "pelicules.txt"};
        for (String nombreArchivo : archivosNombres) {
            File archivo = new File(carpeta, nombreArchivo);
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo " + nombreArchivo);
            }
        }
    }



    //metodos usuario
    public void afegirPelicula(ArrayList<Pelicula> pelicules, Pelicula pelicula) {
        System.out.println("Afegint pelicula: "+pelicula.getTitulo()+" a la llista pelicules de l'usuari: "+getNom());
        pelicules.add(pelicula);
    }

    public void afegirActor(ArrayList<Actor> actors, Actor actor) {
        System.out.println("Afegint actor: "+actor.getNombre()+" a la llista actors de l'usuari: "+getNom());
        actors.add(actor);
    }

    public void afegirDirector(ArrayList<Director> directors, Director director) {
        System.out.println("Afegint director: "+director.getNombre()+" a la llista directors de l'usuari: "+getNom());
        directors.add(director);
    }

    public void consultarPeliculas(ArrayList<Pelicula> pelicules) {
        System.out.println("Llista pelicules de l'usuari: "+getNom());
        for(Pelicula pelicula: pelicules) {
            System.out.println("Id: "+pelicula.getId()+", titul: "+pelicula.getTitulo()+", any: "+pelicula.getAño()+", director: "+pelicula.getDirector());
        }

    }

    public void consultarActors(ArrayList<Actor> actors) {
        System.out.println("Llista actors de l'usuari: "+getNom());
        for(Actor actor: actors) {
            System.out.println("Id: "+actor.getId()+", nom: "+actor.getNombre()+", naixement: "+actor.getDataNacimiento()+", pelicules: ");

            for (Pelicula pelicula : actor.getPeliculas()) {
                System.out.println(pelicula.getTitulo());
            }
        }
    }

    public void consultarDirectors(ArrayList<Director> directors) {
        System.out.println("Llista actors de l'usuari: "+getNom());
        for(Director director: directors) {
            System.out.println("Id: "+director.getId()+", nom: "+director.getNombre());
        }
    }

    //crea listas general
    public void crearLlistasGeneral() {
        File archivoDirector = new File("src/com/projecte/listasGenerales/ListaDirector.txt");
        if (!archivoDirector.exists()) {
            try {
                // Crear el archivo si no existe
                archivoDirector.createNewFile();
                System.out.println("Archivo creado correctamente");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo que contiene las Listas Director ya existe, no se ha creado uno nuevo");
        }
        File archivoPeliculas = new File("src/com/projecte/listasGenerales/ListaPeliculas.txt");
        if (!archivoPeliculas.exists()) {
            try {
                // Crear el archivo si no existe
                archivoPeliculas.createNewFile();
                System.out.println("Archivo creado correctamente");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo que contiene las Listas Peliculas ya existe, no se ha creado uno nuevo");
        }
        File archivoActores = new File("src/com/projecte/listasGenerales/ListaActores.txt");
        if (!archivoActores.exists()) {
            try {
                // Crear el archivo si no existe
                archivoActores.createNewFile();
                System.out.println("Archivo creado correctamente");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo que contiene las Listas Actores ya existe, no se ha creado uno nuevo");
        }
    }

    public static int obtenerOpcion(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.println("Selecciona una opción del "+min+" al "+max+":");
            String entrada = scanner.nextLine();

            try {
                opcion = Integer.parseInt(entrada);

                if (opcion >= min && opcion <= max) {
                    opcionValida = true;
                } else {
                    System.out.println("La opción debe ser del "+min+" al "+max);
                }
            } catch (NumberFormatException e) {
                System.out.println("La entrada debe ser un número entero");
            }
        }

        return opcion;
    }


    //afegix una llista a la llista general
    public void afegirLlista(Usuario usuario) {
        String rutaCarpeta="src/com/projecte/listasGenerales";
        // Crear los Sets para evitar duplicados
        Set<Pelicula> peliculasSet = new HashSet<>(usuario.getPelicules());
        Set<Director> directoresSet = new HashSet<>(usuario.getDirectors());
        Set<Actor> actoresSet = new HashSet<>(usuario.getActors());

        // Crear los archivos
        File peliculasFile = new File(rutaCarpeta, "ListaPeliculas.txt");
        File directoresFile = new File(rutaCarpeta, "ListaDirector.txt");
        File actoresFile = new File(rutaCarpeta, "ListaActores.txt");

        // Escribir los datos en los archivos
        try {
            System.out.println("Que lista quieres subir?");
            System.out.println("(1) Lista de pelicules.");
            System.out.println("(2) Lista de directors.");
            System.out.println("(3) Lista de actors.");
            int opcion = obtenerOpcion(1, 3);

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido la opción 1");
                    // Escribir en peliculas.txt
                    FileWriter peliculasWriter = new FileWriter(peliculasFile);
                    for (Pelicula pelicula : peliculasSet) {
                        peliculasWriter.write(pelicula.toString() + "\n");
                    }
                    peliculasWriter.close();
                    break;
                case 2:
                    System.out.println("Has elegido la opción 2");
                    // Escribir en directores.txt
                    FileWriter directoresWriter = new FileWriter(directoresFile);
                    for (Director director : directoresSet) {
                        directoresWriter.write(director.toString() + "\n");
                    }
                    directoresWriter.close();
                    break;
                case 3:
                    System.out.println("Has elegido la opción 3");
                    // Escribir en actores.txt
                    FileWriter actoresWriter = new FileWriter(actoresFile);
                    for (Actor actor : actoresSet) {
                        actoresWriter.write(actor.toString() + "\n");
                    }
                    actoresWriter.close();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //per parametre li pases la ruta de la carpeta
    public void consultarPrincipal() {

        String carpeta="src/com/projecte/listasGenerales";

        File peliculasFile = new File(carpeta, "ListaPeliculas.txt");
        File directoresFile = new File(carpeta, "ListaDirector.txt");
        File actoresFile = new File(carpeta, "ListaActores.txt");

        try {
            System.out.println("Que lista quieres ver?");
            System.out.println("(1) Lista de pelicules.");
            System.out.println("(2) Lista de directors.");
            System.out.println("(3) Lista de actors.");
            int opcion = obtenerOpcion(1, 3);

            switch (opcion) {
                case 1:
                    // Mostrar el contenido de peliculas.txt
                    Scanner peliculasScanner = new Scanner(peliculasFile);
                    System.out.println("Pelicules de la llista general:");
                    while (peliculasScanner.hasNextLine()) {
                        System.out.println(peliculasScanner.nextLine());
                    }
                    peliculasScanner.close();
                    break;

                case 2:
                    // Mostrar el contenido de directores.txt
                    Scanner directoresScanner = new Scanner(directoresFile);
                    System.out.println("\nDirectors de la llista general:");
                    while (directoresScanner.hasNextLine()) {
                        System.out.println(directoresScanner.nextLine());
                    }
                    directoresScanner.close();
                    break;

                case 3:
                    // Mostrar el contenido de actors.txt
                    Scanner actoresScanner = new Scanner(actoresFile);
                    System.out.println("\nActors de la llista general:");
                    while (actoresScanner.hasNextLine()) {
                        System.out.println(actoresScanner.nextLine());
                    }
                    actoresScanner.close();
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}