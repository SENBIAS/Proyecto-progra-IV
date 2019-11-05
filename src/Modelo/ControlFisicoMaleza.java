/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ghost
 */
public class ControlFisicoMaleza {
    private int codigo;
    private int frecuenciaPoda;
    private String fechaUltimaPoda;

    public ControlFisicoMaleza() {
        codigo=0;
    }

    public ControlFisicoMaleza(int frecuenciaPoda, String fechaUltimaPoda) {
        codigo++;
        this.frecuenciaPoda = frecuenciaPoda;
        this.fechaUltimaPoda = fechaUltimaPoda;
    }

    public int getFrecuenciaPoda() {
        return frecuenciaPoda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setFrecuenciaPoda(int frecuenciaPoda) {
        this.frecuenciaPoda = frecuenciaPoda;
    }

    public String getFechaUltimaPoda() {
        return fechaUltimaPoda;
    }

    public void setFechaUltimaPoda(String fechaUltimaPoda) {
        this.fechaUltimaPoda = fechaUltimaPoda;
    }
    
    public void imprimir()
    {
        System.out.println("Codigo control fisico: "+codigo);
        System.out.println("Frecuencia de poda: "+frecuenciaPoda);
        System.out.println("Fecha ultima poda: "+fechaUltimaPoda);
    }
    
}
