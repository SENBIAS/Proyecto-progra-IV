<<<<<<< HEAD:src/CRUD/CrudVivero.java
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
    
    public static Vivero encontrarVivero(ArrayList<Vivero> listaViveros,Scanner tecladoInt){
        int codigoVivero;
        System.out.print("Digite el codigo del vivero: ");
        codigoVivero = tecladoInt.nextInt();
        
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
                vivero = encontrarVivero(productor.getViveros(), entradaInt); 
                
                if(vivero == null){
                    System.out.println("No existe un viveo con este codigo.");
                }else{
                    productor.getViveros().remove(vivero);
                    System.out.println("Vivero eliminado.");
                }
            }
        }
    }
    
    public static void mostrarViveros(ArrayList<Vivero> listaViveros){
        int i=1;
        if(listaViveros.isEmpty()){
            System.out.println("No hay viveron asociados al productor.");
        }else{
            System.out.println("Viveros asociados a el productor:");
            for(Vivero vivero : listaViveros){
                 System.out.println("Vivero #"+i);
                 vivero.imprimir();
                 i++;
            }
        }
    }
    
    public static void crearVivero(ArrayList<Productor> productor,Scanner entradaInt,Scanner entradaString){
        Vivero nuevoVivero= new Vivero();
        ArrayList<Vivero> vivero = validar(productor);
        if(productor.isEmpty()){
            System.out.println("No exiten productores, no pueden agregarse viveros");
        }else{
            System.out.print("Ingrese el codigo del vivero: ");

            nuevoVivero.setCodigo(entradaInt.nextInt());

            System.out.print("Ingrese el nombre del vivero: ");

            nuevoVivero.setNombre(entradaString.nextLine());

            System.out.print("Ingrese el departamento del vivero: ");

            nuevoVivero.setDepartamento(entradaString.nextLine());

            System.out.print("Ingrese el municipio del vivero: ");

            nuevoVivero.setMunicipio(entradaString.nextLine());
            
            if(vivero.add(nuevoVivero))
            {
                System.out.println("Vivero agregado.");
            }else
            {
                System.out.println("Vivero no pudo ser agregado.");
            }
        }     
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
    
    public static void actualizarVivero(Vivero vivero){
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
 
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
    
    public static void buscarVivero(ArrayList<Productor> listaProductores){
        ArrayList<Vivero> listaViveros = validar(listaProductores);
        Scanner tecladoInt = new Scanner(System.in);
        if(listaViveros.isEmpty()){
            System.out.println("No hay vivevos.");
        }else{
            System.out.println("Bucar vivero.");
            Vivero vivero = encontrarVivero(listaViveros, tecladoInt);
            
            if(vivero == null){
                System.out.println("Vivero no encontrado.");
            }else{
                vivero.imprimir();
                Proceso proceso = CrudProceso.encontrarProceso(vivero.getProcesos(), tecladoInt);
                proceso.imprimir();
                CrudLabor.imprimirLabores(proceso.getLabores());
            }
        }       
    }
 
}
=======
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
    
    public static Vivero encontrarVivero(ArrayList<Vivero> listaViveros,Scanner tecladoInt){
        int codigoVivero;
        System.out.print("Digite el codigo del vivero: ");
        codigoVivero = tecladoInt.nextInt();
        
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
                vivero = encontrarVivero(productor.getViveros(), entradaInt); 
                
                if(vivero == null){
                    System.out.println("No existe un viveo con este codigo.");
                }else{
                    productor.getViveros().remove(vivero);
                    System.out.println("Vivero eliminado.");
                }
            }
        }
    }
    
    public static void mostrarViveros(ArrayList<Vivero> listaViveros){
        int i=1;
        if(listaViveros.isEmpty()){
            System.out.println("No hay viveron asociados al productor.");
        }else{
            System.out.println("Viveros asociados a el productor:");
            for(Vivero vivero : listaViveros){
                 System.out.println("Vivero #"+i);
                 vivero.imprimir();
                 i++;
            }
        }
    }
    
    public static void crearVivero(ArrayList<Productor> productor,Scanner entradaInt,Scanner entradaString){
        Vivero nuevoVivero= new Vivero();
        ArrayList<Vivero> vivero = validar(productor);
        if(productor.isEmpty()){
            System.out.println("No exiten productores, no pueden agregarse viveros");
        }else{
            System.out.print("Ingrese el codigo del vivero: ");

            nuevoVivero.setCodigo(entradaInt.nextInt());

            System.out.print("Ingrese el nombre del vivero: ");

            nuevoVivero.setNombre(entradaString.nextLine());

            System.out.print("Ingrese el departamento del vivero: ");

            nuevoVivero.setDepartamento(entradaString.nextLine());

            System.out.print("Ingrese el municipio del vivero: ");

            nuevoVivero.setMunicipio(entradaString.nextLine());
            
            if(vivero.add(nuevoVivero))
            {
                System.out.println("Vivero agregado.");
            }else
            {
                System.out.println("Vivero no pudo ser agregado.");
            }
        }     
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
    
    public static void actualizarVivero(Vivero vivero){
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
 
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
    
    public static void buscarVivero(ArrayList<Productor> listaProductores){
        ArrayList<Vivero> listaViveros = validar(listaProductores);
        Scanner tecladoInt = new Scanner(System.in);
        if(listaViveros.isEmpty()){
            System.out.println("No hay vivevos.");
        }else{
            System.out.println("Bucar vivero.");
            Vivero vivero = encontrarVivero(listaViveros, tecladoInt);
            
            if(vivero == null){
                System.out.println("Vivero no encontrado.");
            }else{
                vivero.imprimir();
                Proceso proceso = CrudProceso.encontrarProceso(vivero.getProcesos(), tecladoInt);
                proceso.imprimir();
                CrudLabor.imprimirLabores(proceso.getLabores());
            }
        }       
    }
 
}
>>>>>>> 1522fe7ead2db402877b9485bd594f5eb934dee0:src/main/java/CRUD/CrudVivero.java
