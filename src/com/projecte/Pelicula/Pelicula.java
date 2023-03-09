package com.projecte.Pelicula;

import com.projecte.Director.Director;

public class Pelicula {
	
	private static int id=1;
	private String titulo;
	private int año;
	private Director director;
	
	//geters seters
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Pelicula.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	
	
	
	//constructor
	public Pelicula(String titulo, int año, Director director) {
		super();
		this.titulo = titulo;
		this.año = año;
		this.director = director;
	}
	
		
	
	
}
