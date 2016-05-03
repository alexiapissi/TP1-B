package com.example.clase1.clase1.Model;

/**
 * Created by 41824471 on 26/4/2016.
 */
public class Alumno extends Person {

    private String anio;

    public Alumno(String nombre, String a, int sexo, String anio) {
        super(nombre, a, sexo);
        this.anio = anio;
    }

    @Override
    public String imprimir() throws Exception {
        return super.imprimir()+ ", "+ anio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Alumno(String nombre, String a, int sexo) {
        super(nombre, a, sexo);
    }
}
