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

        //Ara creem l'objecte usuari en els datos anteriorment arreplegats, si rol == admin

        if(rol.equals("admin")){
            new Usuario(nom,cognoms,correu,contrasenya,dataNaixement,rol, poblacio, id);

            }
        else{
            //constructor usuari
            new Usuario(nom,cognoms,correu,contrasenya,dataNaixement, poblacio, id);
        }











        System.out.println("Usuari registrat correctament.");
    }




    public static boolean logIn(Scanner entrada){
        String linea;
        System.out.print("Introdueix el teu correu: ");
        String correo = entrada.nextLine();
        System.out.print("Introdueix la teua contrasenya: ");
        String contrasenya = entrada.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"));
            //pregunta pa optimisar
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




