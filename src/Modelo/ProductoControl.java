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
public class ProductoControl {
    //Atributos
    private int registroICA;
    private String nombreProducto;
    private int frecuenciaAPlicacion;
    
    //Metodos.

    public ProductoControl() {
    }

   public ProductoControl(int registroICA, String nombreProducto, int frecuenciaAPlicacion) {
        this.registroICA = registroICA;
        this.nombreProducto = nombreProducto;
        this.frecuenciaAPlicacion = frecuenciaAPlicacion;
    }

    public int getRegistroICA() {
        return registroICA;
    }

    public void setRegistroICA(int registroICA) {
        this.registroICA = registroICA;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getFrecuenciaAPlicacion() {
        return frecuenciaAPlicacion;
    }

    public void setFrecuenciaAPlicacion(int frecuenciaAPlicacion) {
        this.frecuenciaAPlicacion = frecuenciaAPlicacion;
    }
    
    public void impresionParcial()
    {
        System.out.println("REGISTRO ICA            :"+registroICA);
        System.out.println("NOMBRE PRODUCTO         : "+nombreProducto);
        System.out.println("FRECUENCIA APLICACION   :"+frecuenciaAPlicacion);
    }
}
