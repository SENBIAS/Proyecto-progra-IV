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
public class Vivero {
    //Atributos
    private int codigo;
    private String nombre;
    private String departamento;
    private String municipio;
    ArrayList<Proceso> procesos = new ArrayList<>();
    
    
    //Metodos.

    public Vivero() {
    }

    public Vivero(int codigo, String nombre, String Departamento, String municipio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = Departamento;
        this.municipio = municipio;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String Departamento) {
        this.departamento = Departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }
    
    public void imprimir()
    {
        System.out.println("Codigo:  "+codigo);
        System.out.println("Nombre:  "+nombre);
        System.out.println("Departamento: "+departamento);
        System.out.println("Municipio:  "+municipio);
    }
}
