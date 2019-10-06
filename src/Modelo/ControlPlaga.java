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
public class ControlPlaga extends ProductoControl{
    //Atributos
    private int periodoCarencia;
    
    //Metodos

    public ControlPlaga() {
        
    }

    public ControlPlaga(int registroICA, String nombreProducto, int frecuenciaAPlicacion, int periodoCarencia) {
        super(registroICA, nombreProducto, frecuenciaAPlicacion);
        this.periodoCarencia = periodoCarencia;
    }

    public int getPeriodoCarencia() {
        return periodoCarencia;
    }

    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }

    public void imprimir()
    {
        impresionParcial();
        System.out.println("PERIODO CARENCIA            :"+periodoCarencia);
    }  
}
