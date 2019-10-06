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
public class ControlFertilizante extends ProductoControl{
    //Atributos
    private int ultimaAplicacion;
    
    //Metodos

    public ControlFertilizante() {
    }

    public ControlFertilizante(int registroICA, String nombreProducto, int frecuenciaAPlicacion, int ultimaAplicacion) {
        super(registroICA, nombreProducto, frecuenciaAPlicacion);
        this.ultimaAplicacion = ultimaAplicacion;
    }

    public int getUltimaAplicacion() {
        return ultimaAplicacion;
    }

    public void setUltimaAplicacion(int ultimaAplicacion) {
        this.ultimaAplicacion = ultimaAplicacion;
    }
    
    public void imprimir()
    {
        impresionParcial();
        System.out.println("ULTIMA APLICACION           :"+ultimaAplicacion);
    }
}
