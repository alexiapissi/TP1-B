package com.example.clase1.clase1.Model;

/**
 * Created by 41824471 on 26/4/2016.
 */
public class Profesor extends Person{

    private String materia;

    @Override
    public String imprimir() throws Exception {
        return super.imprimir()+ ", "+ materia;
    }

    public Profesor(String nombre, String a, int sexo, String materia) {
        super(nombre, a, sexo);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    public Profesor(String nombre, String a, int sexo) {
        super(nombre, a, sexo);
    }
}
