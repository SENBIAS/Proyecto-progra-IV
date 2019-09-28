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
public class CrudLabor {
    
    private static ArrayList<Labor> validar(ArrayList<Productor> listaProductores){
       ArrayList<Labor> listaLabores = null;
       Scanner entradaInt = new Scanner(System.in);
       
       if(listaProductores.isEmpty()){
           System.out.println("Sin productores no pueden existir labores");
       }else{
           Productor productor;
           productor = crudProductor.encontrarProductor(listaProductores, entradaInt);
           
           if(productor == null){
               System.out.println("No existe un productor asociado a este documento.");
           }else{
               Vivero vivero;
               vivero = CrudVivero.encontrarVivero(productor.getViveros(), entradaInt);
               
               if(vivero == null){
                   System.out.println("No se encontro un vivero con este codigo.");
               }else{
                   Proceso proceso;
                   proceso = crudProceso.encontrarProceso(vivero.getProcesos(), entradaInt);
                   
                   if(proceso == null){
                       System.out.println("No exite el proceso en este vivero.");
                   }else{
                       listaLabores = proceso.getLabores();
                   }
               }
           }
       }
       return listaLabores;
    } 
    
    public static void crearLabor(ArrayList<Productor> listaProductores,Scanner entradaString){
        ArrayList<Labor>listaLabores = validar(listaProductores);
        
        if(listaLabores == null){
            System.out.println("No se puede agregar labores.");
        }else{
            String tipoLabor;
            String fecha;
            String descripcion;
            Labor labor;
            System.out.print("Ingrese el tipo de labor: ");
            tipoLabor = entradaString.nextLine();
            System.out.print("Ingrese la fecha de la labor: ");
            fecha = entradaString.nextLine();
            System.out.print("Añada una descripcion: ");
            descripcion = entradaString.nextLine();
            labor = new Labor(tipoLabor,fecha,descripcion);
            
            listaLabores.add(labor);
            System.out.println("Labor agregada.");
        }
    }
    
    public static void imprimirLabores(ArrayList<Labor> listaLabores){
        int i = 1;
        if(listaLabores.isEmpty()){
            System.out.println("No hay labores para mostrar. ");
        }else{
            for(Labor labor : listaLabores){
                System.out.println("Labor #"+i);
                labor.imprimir();
                i++;
            }
        }
    }
    
    private static void menuActualizarLabor(){
        System.out.println("ACTUALIZAR LABOR.");
        System.out.println("1.Actualizar tipo de labor.");
        System.out.println("2.Actualizar fecha.");
        System.out.println("3.Actualizar descripcion.");
        System.out.println("4.Salir.");
    }
    
    private static void actualizarTipoLabor(Labor labor){
        String nuevoTipoLabor;
        Scanner entradaString = new Scanner(System.in);
        System.out.print("Ingrese el nuevo tipo de labor");
        nuevoTipoLabor = entradaString.nextLine();
        
        labor.setTipoLabor(nuevoTipoLabor);
        
        System.out.println("Tipo de labor actualizado.");
    }
    
    private static void actualizarFecha(Labor labor){
        String nuevaFecha;
        Scanner entradaString = new Scanner(System.in);
        System.out.print("Ingrese la nueva fecha: ");
        nuevaFecha = entradaString.nextLine();
        
        labor.setFecha(nuevaFecha);
        
        System.out.println("Fecha actualizada.");
    }
    
    private static void actualizarDescripcion(Labor labor){
        String nuevaDescripcion;
        Scanner entradaString = new Scanner(System.in);
        System.out.print("Ingrese una nueva descripcion: ");
        nuevaDescripcion = entradaString.nextLine();
        
        labor.setDescripcion(nuevaDescripcion);
        
        System.out.println("Descripcion actualizada.");
    }
    
    public static void actualizarLabor(Labor labor){
        int opcion;
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaString = new Scanner(System.in);
        
        do {            
            menuActualizarLabor();
            System.out.print("Opcion escogida: ");
            opcion = entradaInt.nextInt();
            switch (opcion) {
                case 1:
                    actualizarTipoLabor(labor);
                    break;
                case 2:
                    actualizarFecha(labor);
                    break;
                case 3:
                    actualizarDescripcion(labor);
                    break;          
            }
        } while (opcion < 4);
    }
    
    public static void eliminarLabor(Labor labor,ArrayList<Labor>listaLabores){
        if(listaLabores.isEmpty()){
            System.out.println("No hay labores.");
        }else{
            try {
                listaLabores.remove(labor);
                System.out.println("Labor eliminada");
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
        }
    }
    
}
