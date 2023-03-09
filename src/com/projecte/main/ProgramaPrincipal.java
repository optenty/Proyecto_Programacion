package com.projecte.main;

import com.projecte.jorge.Jorge;
import com.projecte.daniel.Daniel;
import com.projecte.angel.Angel;
import com.projecte.maikol.Maikol;
import com.projecte.Usuario.Usuario;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class ProgramaPrincipal {

    public static void main(String[] args) throws IOException {
        //Exercici 01
		/*
		Jorge p1 = new Jorge();
		Daniel p2 = new Daniel();
		Angel p3 = new Angel();
		Maikol p4 = new Maikol();
		
		p1.MostrarNom();
		p2.MostrarNom();
		p3.MostrarNom();
		p4.MostrarNom();
		*/

        //Quan s'executa la aplicació s'inicia un menú
        ProgramaPrincipal Programa = new ProgramaPrincipal();
        Programa.inici();
    }

    public void inici() throws IOException {
        Scanner entrada = new Scanner(System.in);
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

          //Con esto creamos las listas si no están creadas, si están creadas se crean nuevas. Aparte, ya tenemos las variables
          //que apuntan a los archivos File para trabajar con ellos

        menu(entrada);


    }

    public static void menu(Scanner entrada) throws IOException {
        boolean semafor = true;
            System.out.println("Benvingut al menú de la APP, qué desitges fer:");
            System.out.println("Polsa 1 per: Registrar-te");
            System.out.println("Polsa 2 per: Iniciar sessió");
            System.out.println("Polsa 3 per: Ixir del programa");
        while (semafor) {
            String opcio = entrada.nextLine();
            switch (opcio) {
                case "1":
                    System.out.println("Has polsat 1: Inici del procediment de registre.");
                    registre();
                    semafor = false;
                    break;
                case "2":
                    System.out.println("Has polsat 2: Inici del procediment d'Inici de sessió.");
                    if (logIn(entrada)) {
                        System.out.println("Inicio de sesión exitoso.");
                    } else {
                        System.out.println("Inicio de sesión fallido.");
                    }
                    semafor = false;
                    break;
                case "3":
                    System.out.println("Has polsat 3: Has ixit del programa satisfactoriament.");
                    semafor = false;
                    break;
                default:
                    System.out.println("No has polsat una opció correcta, torna a intentar-ho.");
            }

        }
    }
    public static void registre() throws IOException {
        File file = new File("Usuarios.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        Scanner input = new Scanner(System.in);

        int id = 1;
        if (file.length() != 0) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                id++;
            }
            reader.close();
        }

        System.out.println("Benvingut/da al registre d'usuaris.");
        System.out.println("Introdueix les dades següents:");

        String nom;
        do {
            System.out.print("Nom: ");
            nom = input.nextLine();
        } while (nom.isEmpty());

        String cognoms;
        do {
            System.out.print("Cognoms: ");
            cognoms = input.nextLine();
        } while (cognoms.isEmpty());

        String correu;
        do {
            System.out.print("Correu electrònic: ");
            correu = input.nextLine();
        } while (correu.isEmpty());

        String contrasenya;
        String contrasenyaConfirmada;
        do {
            System.out.println("Introdueix la mateixa contrasenya dues vegades:");
            System.out.print("Contrasenya: ");
            contrasenya = input.nextLine();
            //Mejorar la contraseña, que no esté vacía y tal
            System.out.print("Confirma la contrasenya: ");
            contrasenyaConfirmada = input.nextLine();
        } while (!contrasenya.equals(contrasenyaConfirmada));

        String poblacio;
        do {
            System.out.print("Població: ");
            poblacio = input.nextLine();
        } while (poblacio.isEmpty());

        String rol;
        do {
            System.out.print("Rol: ");
            rol = input.nextLine();
        } while (rol.isEmpty());

        String dataNaixement;
        do {
            System.out.print("Data de naixement (DD/MM/AAAA): ");
            dataNaixement = input.nextLine();
        } while (dataNaixement.isEmpty());

        String usuari = String.format("%d;;%s;;%s;;%s;;%s;;%s;;%s;;%s\n", id, nom, cognoms, correu, contrasenya, poblacio, rol, dataNaixement);

        FileWriter writer = new FileWriter(file, true);
        writer.write(usuari);
        writer.close();

        //Ara creem l'objecte usuari en els datos anteriorment arreplegats, si rol == admin, creem l'usuari amb el costructor de admin, sino el altre constructor
        if(rol.equals("admin")){
            new Usuario(nom,cognoms,correu,contrasenya,dataNaixement,rol, poblacio, id);

            }
        else{
            //constructor usuari
            new Usuario(nom,cognoms,correu,contrasenya,dataNaixement, poblacio, id);
        }











        System.out.println("Usuari registrat correctament.");

        //Si s'ha iniciat correctament, es pasará un menú paregunt a esto:
        // 1. Polsa 1 per a anyadir un autor en la llista
        // 2. Polsa 2 per a anyadir una pelicula a la llista
        // 3. Polsa 3 per a anyadir un director a la llista
        // Depenent de el que polses, se't preguntarà si vols anyadir a la general o a la personal
        // A la general pots anyadir el que vullgues però a la personal sols pots anyadir el que ja existeix de la general
        // Si vols anyadir a la personal i no hi ha res en la general, es mostrará un missatge d'error i es sugerirá
        // que introdueixques primer alguna ocurrència en la general.
    }




    public static boolean logIn(Scanner entrada){
        String linea;
        System.out.print("Introdueix el teu correu: ");
        String correo = entrada.nextLine();
        System.out.print("Introdueix la teua contrasenya: ");
        String contrasenya = entrada.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"));
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";;");
                System.out.println(Arrays.toString(campos));
                if (campos[3].equals(correo) && campos[4].equals(contrasenya)) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        return false;
    }
    }




