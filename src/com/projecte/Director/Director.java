package com.projecte.Director;


    public class Director {

        private static int id=1;
        private String nombre;


        public static int getId() {
            return id;
        }
        public static void setId(int id) {
            Director.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        //constructor
        public Director(String nombre) {
            super();
            this.nombre = nombre;
        }



    }

