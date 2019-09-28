/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class CrudVivero {
    
    private static ArrayList<Vivero> validar(ArrayList<Productor> listaProductores){
        ArrayList<Vivero> viveros = null;
        Scanner entradaInt = new Scanner(System.in);
        
        if(listaProductores.isEmpty()){
            System.out.println("Sin productores no se pueden añadir viveros");
        }else{
            Productor productor;
            productor = CrudProductor.encontrarProductor(listaProductores, entradaInt);
            viveros = productor.getViveros();
        }
        return viveros;
    }
    
    public static Vivero encontrarVivero(Productor productor,Scanner tecladoInt){
        int codigoVivero;
        System.out.print("Digite el codigo del vivero: ");
        codigoVivero = tecladoInt.nextInt();
        ArrayList<Vivero> listaViveros;
        listaViveros = productor.getViveros();
        
        for(Vivero vivero : listaViveros){
            if(vivero.getCodigo() == codigoVivero){
                return vivero;
            }
        }
        
        return null;
    }
    
    public static void eliminarVivero(ArrayList<Productor> listaProductores){
        Vivero vivero;
        Scanner entradaInt = new Scanner(System.in);
        if(listaProductores.isEmpty()){
            System.out.println("No existen productores, por tal no hay viveros");
        }else{
            Productor productor = CrudProductor.encontrarProductor(listaProductores, entradaInt);
            
            if(productor == null){
                System.out.println("No existe un productor con este documento.");
            }else{
                vivero = encontrarVivero(productor, entradaInt); 
                
                if(vivero == null){
                    System.out.println("No existe un viveo con este codigo.");
                }else{
                    productor.getViveros().remove(vivero);
                    System.out.println("Vivero eliminado.");
                }
            }
        }
    }
    
    public static void mostrarViveros(Productor productor){
        ArrayList<Vivero> listaViveros = productor.getViveros();
        int i=1;
        System.out.println("Viveros asociados a el productor:");
        for(Vivero vivero : listaViveros){
            System.out.println("Vivero #"+i);
            vivero.imprimir();
            i++;
        }
    }
    
    public static void crearVivero(Productor productor,Scanner entradaInt,Scanner entradaString){
        int codigo;
        String nombre;
        String departamento;
        String municipio;
        Vivero vivero;
        
        System.out.print("Ingrese el nombre del vivero: ");
        nombre = entradaString.nextLine();
        System.out.print("Ingrese el codigo del vivero: ");
        codigo = entradaInt.nextInt();
        System.out.print("Ingrese el departamento del vivero: ");
        departamento = entradaString.nextLine();
        System.out.print("Ingrese el municipio del vivero: ");
        municipio = entradaString.nextLine();
        
        vivero = new Vivero(codigo,nombre,departamento,municipio);
        
        productor.getViveros().add(vivero);
        
        System.out.println("Vivero agregado.");
        
    }
    
    private static void menuActualizar(){
        System.out.println("ACTUALIZAR VIVERO");
        System.out.println("1.Actualizar codigo.");
        System.out.println("2.Actualizar nombre.");
        System.out.println("3.Actualizar departamento.");
        System.out.println("4.Actualizar municipio.");
        System.out.println("5.Salir.");
    }
    
    private static void actualizarCodigo(Vivero vivero,Scanner tecladoInt){
        int nuevoCodigo;
        System.out.print("Ingrese el nuevo codigo: ");
        nuevoCodigo = tecladoInt.nextInt();
        
        vivero.setCodigo(nuevoCodigo);
        
        System.out.println("Codigo actualizado");
    }
    
    private static void actualizarNombre(Vivero vivero,Scanner tecladoString){
        String nuevoNombre;
        System.out.print("Ingrese el nuevo nombre del vivero: ");
        nuevoNombre = tecladoString.nextLine();
        
        vivero.setNombre(nuevoNombre);
        
        System.out.println("Nombre actualizado.");
    }
    
    private static void actualizarDepartamento(Vivero vivero,Scanner tecladoString){
        String nuevoDepartamento;
        System.out.print("Ingrese el nuevo departamento del vivero: ");
        nuevoDepartamento = tecladoString.nextLine();
        
        vivero.setDepartamento(nuevoDepartamento);
        
        System.out.println("Departamento actualizado.");
    }

    private static void actualizarMunicipio(Vivero vivero,Scanner tecladoString){
        String nuevoMunicipio;
        System.out.print("Ingrese el nuevo municipio del vivero: ");
        nuevoMunicipio = tecladoString.nextLine();
        
        vivero.setMunicipio(nuevoMunicipio);
        
        System.out.println("Municipio actualizado.");
    }
    
    public static void actualizarVivero(Productor productor){
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        Vivero vivero = encontrarVivero(productor, tecladoInt);
        int opcion;
        
        do {   
            menuActualizar();
            System.out.print("OPCION ESCOGIDA: ");
            opcion = tecladoInt.nextInt();
            switch (opcion) {
                case 1:
                    actualizarCodigo(vivero, tecladoInt);
                    break;
                case 2:
                    actualizarNombre(vivero, tecladoString);
                    break;
                case 3:
                    actualizarDepartamento(vivero, tecladoString);
                    break;
                case 4:
                    actualizarMunicipio(vivero, tecladoString);
                    break;
            }
        } while (opcion < 5);
    }
 
}
