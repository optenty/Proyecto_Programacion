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
	
	
	//crea la carpeta del usuario con su correo y hace los 3 archivos para las listas
	{
		File carpeta = new File(correoElectronico);
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
	
	
	//constructor usuari
	public Usuario(String nom, String apellidos, String correoElectronico, String contra, String dataNacimiento,
			ArrayList<Pelicula> pelicules, ArrayList<Director> directors, ArrayList<Actor> actors, String poblacio, int id) {
		super();
		this.nom = nom;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.contra = contra;
		this.dataNacimiento = dataNacimiento;
		this.pelicules = pelicules;
		this.directors = directors;
		this.actors = actors;
		this.rol="ROL_USUARIO";
		this.poblacio=poblacio;
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
	}

	//constructor admin
	public Usuario(String nom, String apellidos, String correoElectronico, String contra, String dataNacimiento,
			String rol,ArrayList<Pelicula> pelicules, ArrayList<Director> directors, ArrayList<Actor> actors, String poblacio, int id) {
		super();
		this.id = id;
		this.nom = nom;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.contra = contra;
		this.dataNacimiento = dataNacimiento;
		this.pelicules = pelicules;
		this.directors = directors;
		this.actors = actors;
		this.rol = rol;
		this.poblacio=poblacio;
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
	
	
	//afegix una llista a la llista general
	public void afegirLlista(Usuario usuario, String rutaCarpeta) {
		// Crear los Sets para evitar duplicados
	    Set<Pelicula> peliculasSet = new HashSet<>(usuario.getPelicules());
	    Set<Director> directoresSet = new HashSet<>(usuario.getDirectors());
	    Set<Actor> actoresSet = new HashSet<>(usuario.getActors());

	    // Crear los archivos
	    File peliculasFile = new File(rutaCarpeta, "pelicules.txt");
	    File directoresFile = new File(rutaCarpeta, "directors.txt");
	    File actoresFile = new File(rutaCarpeta, "actors.txt");

	    // Escribir los datos en los archivos
	    try {
	        // Escribir en peliculas.txt
	        FileWriter peliculasWriter = new FileWriter(peliculasFile);
	        for (Pelicula pelicula : peliculasSet) {
	            peliculasWriter.write(pelicula.toString() + "\n");
	        }
	        peliculasWriter.close();

	        // Escribir en directores.txt
	        FileWriter directoresWriter = new FileWriter(directoresFile);
	        for (Director director : directoresSet) {
	            directoresWriter.write(director.toString() + "\n");
	        }
	        directoresWriter.close();

	        // Escribir en actores.txt
	        FileWriter actoresWriter = new FileWriter(actoresFile);
	        for (Actor actor : actoresSet) {
	            actoresWriter.write(actor.toString() + "\n");
	        }
	        actoresWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//per parametre li pases la ruta de la carpeta
	public void consultarPrincipal(String carpeta) {
		File peliculasFile = new File(carpeta, "pelicules.txt");
	    File directoresFile = new File(carpeta, "directors.txt");
	    File actoresFile = new File(carpeta, "actors.txt");

	    try {
	        // Mostrar el contenido de peliculas.txt
	        Scanner peliculasScanner = new Scanner(peliculasFile);
	        System.out.println("Pelicules de la llista general:");
	        while (peliculasScanner.hasNextLine()) {
	            System.out.println(peliculasScanner.nextLine());
	        }
	        peliculasScanner.close();

	        // Mostrar el contenido de directores.txt
	        Scanner directoresScanner = new Scanner(directoresFile);
	        System.out.println("\nDirectors de la llista general:");
	        while (directoresScanner.hasNextLine()) {
	            System.out.println(directoresScanner.nextLine());
	        }
	        directoresScanner.close();

	        // Mostrar el contenido de actors.txt
	        Scanner actoresScanner = new Scanner(actoresFile);
	        System.out.println("\nActors de la llista general:");
	        while (actoresScanner.hasNextLine()) {
	            System.out.println(actoresScanner.nextLine());
	        }
	        actoresScanner.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	}