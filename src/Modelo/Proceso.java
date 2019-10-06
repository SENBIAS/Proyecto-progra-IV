/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Ghost
 */
public class Proceso {
    //Atributos
    private int codigo;
    private String nombre;
    private int horas;
    private int costo;
    ArrayList<Labor> labores = new ArrayList<>();
    
    //Metodos.

    public Proceso(int codigo, String nombre, int horas, int costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horas = horas;
        this.costo = costo;
    }

    public Proceso() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ArrayList<Labor> getLabores() {
        return labores;
    }

    public void setLabores(ArrayList<Labor> labores) {
        this.labores = labores;
    }
    
    public void imprimir()
    {
        System.out.println("Codigo:  "+codigo);
        System.out.println("Nombre:  "+nombre);
        System.out.println("Horas: "+horas);
        System.out.println("Costo:  "+costo);
    }
    
    
}
