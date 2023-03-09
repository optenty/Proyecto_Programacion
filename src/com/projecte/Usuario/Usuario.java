/*
package com.projecte.Usuario;




import java.util.ArrayList;

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

	public ArrayList<Pelicula> getpelicules() {
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
		System.out.println("Afegint pelicula: "+pelicula.getNom()+" a la llista pelicules de l'usuari: "+getNom());
		peliculas.add(pelicula);
	}
	
	public void afegirActor(ArrayList<Actor> actors, Actor actor) {
		System.out.println("Afegint actor: "+actor.getNom()+" a la llista actors de l'usuari: "+getNom());
		actors.add(actor);
	}
	
	public void afegirDirector(ArrayList<Director> directors, Director director) {
		System.out.println("Afegint director: "+director.getNom()+" a la llista directors de l'usuari: "+getNom());
		directors.add(director);
	}
	
	public void consultarPeliculas(ArrayList<Pelicula> pelicules) {
		System.out.println("Llista pelicules de l'usuari: "+getNom());
		for(Pelicula pelicula: pelicules) {
			System.out.println("Id: "+pelicula.getId()+", titul: "+pelicula.getTitul()+", any: "+pelicula.getAño()+", director: "+pelicula.getDirector);
		}
		
	}
	
	public void consultarActors(ArrayList<Actor> actors) {
		System.out.println("Llista actors de l'usuari: "+getNom());
		for(Actor actor: actors) {
			System.out.println("Id: "+actor.getId()+", nom: "+actor.getNom()+", naixement: "+actor.getNaixement()+", pelicules: "+actor.mostrarPelicules());
		}
	}
	
	public void consultarDirectors(ArrayList<Director> directors) {
		System.out.println("Llista actors de l'usuari: "+getNom());
		for(Director director: directors) {
			System.out.println("Id: "+director.getId()+", nom: "+director.getNom());
		}
	}
	
	
	//per fer
	public void afegirLlista() {
		
	}
	
	public void consultarPrincipal() {
		
	}
	}
*/
