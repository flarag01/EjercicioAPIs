package com.example.ejercicioapis;

public class Personaje {
    String nombre;
    String altura;
    String peso;
    String nacimiento;
    String genero;

    public Personaje(String nombre, String genero, String nacimiento, String altura, String peso) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.nacimiento = nacimiento;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
