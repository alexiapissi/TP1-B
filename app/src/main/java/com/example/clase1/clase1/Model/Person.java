package com.example.clase1.clase1.Model;
import java.io.Serializable;



public class Person implements Serializable {


    public static int MASCULINO=1;
    public static int FEMENINO=2;

    private String nombre;
    private String apellido;
    private int sexo;

    public Person(String nombre, String a, int sexo) {
        this.nombre = nombre;
        apellido=a;
        this.sexo= sexo;
    }

    public String imprimir() throws Exception {
        return nombre + ", " + apellido;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}