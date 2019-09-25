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
public class Productor {
    //Atributo
    private int documento;
    private String nombre;
    private String apellido;
    ArrayList<Vivero> viveros = new ArrayList<>();
    
    //Metodos
    
    public Productor() {
    }
    
    public Productor(int documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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

    public ArrayList<Vivero> getViveros() {
        return viveros;
    }

    public void setViveros(ArrayList<Vivero> viveros) {
        this.viveros = viveros;
    }
    
    public void imprimir()
    {
        System.out.println("Documento:  "+documento);
        System.out.println("Nombre:  "+nombre);
        System.out.println("Apellido: "+apellido);
    }
    
}
