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
public class Labor {
    //Autor
    private String tipoLabor;
    private String fecha;
    private String descripcion;
    ArrayList<ProductoControl> productos = new ArrayList<>();
    
    //Metodos.
    
    public Labor() {
    }

    public Labor(String tipoLabor, String fecha, String descripcion) {
        this.tipoLabor = tipoLabor;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getTipoLabor() {
        return tipoLabor;
    }

    public void setTipoLabor(String tipoLabor) {
        this.tipoLabor = tipoLabor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public ArrayList<ProductoControl> getProductoControl() {
        return productos;
    }

    public void setProductoControl(ArrayList<ProductoControl> productoControl) {
        this.productos = productoControl;
    }
    public void imprimir()
    {
        System.out.println("Tipo de labor:  "+tipoLabor);
        System.out.println("fecha:  "+fecha);
        System.out.println("Descripcio: "+descripcion);
    }
}
