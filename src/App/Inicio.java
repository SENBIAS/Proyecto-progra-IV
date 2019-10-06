/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.ArrayList;
import java.util.Scanner;
import Modelo.*;
import CRUD.*;

/**
 *
 * @author Ghost
 */
public class Inicio {
    
    public static void menuCRUD(){
        System.out.println("1< Agregar");
        System.out.println("2<- Buscar y listar");
        System.out.println("3<- Actualizar");
        System.out.println("4<- Eliminar");
        System.out.println("5<- Salir.");
    }
    
    public static void menuAgregar()
    {
        System.out.println("            INGRESOS\n");
        System.out.println("1<-     Ingrese Productores,");
        System.out.println("2<-     Ingrese viveros.");
        System.out.println("3<-     ingrese procesos.");
        System.out.println("4<-     Ingrse labores.\n");
        System.out.println("5<-     Ingrese un producto de control de plagas");
        System.out.println("6<-     Ingrese un producto de control fertilizante");
        System.out.println("7<-     Salir.");
    }
    public static void menuBuscar()
    {
        System.out.println("            BUSQUEDA Y LISTA.\n");
        System.out.println("1<-     Busque la informacion de un productor.");
        System.out.println("2<-     Busque la informacion de un vivero.");
        System.out.println("3<-     Busque la informacion de un proceso.");
        System.out.println("4<-     Busque la informacion de las labores.");
        System.out.println("5<-     Busque productos de control");
        System.out.println("6<-     Liste los Productores");
        System.out.println("7<-     Liste los viveros.");
        System.out.println("8<-     Salir.");
    }
    
    public static void menuActualizar()
    {
        System.out.println("            ACTUALIZACIONES.\n");
        System.out.println("1<-     Actualice la informacion de Productores.");
        System.out.println("2<-     Actualice la informacion de viveros.");
        System.out.println("3<-     Actualice la informacion de procesos.");
        System.out.println("4<-     Actualice la informacion de labores.\n");
        System.out.println("5<-     Actualice la informacion producto control");
        System.out.println("6<-     Salir.");
    }
    
    public static void menuEliminar()
    {
        
        System.out.println("            ELIMINACION.\n");
        System.out.println("1<-     Elimine Productores,");
        System.out.println("2<-     Elimine viveros.");
        System.out.println("3<-     Elimine procesos.");
        System.out.println("4<-     Elimine labores.\n");
        System.out.println("5<-     Elimine producto de control");
        System.out.println("6<-     Salir.");
    }
    public static void opcionesAgregar(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        do
        {
            menuAgregar();
            opcion=entradaInt.nextInt();
            switch(opcion)
            {
                case 1:
                    CrudProductor.agregarProductor(productores, entradaInt, entradaStr);
                    break;
                case 2:
                    CrudVivero.crearVivero(productores, entradaInt, entradaStr);
                    break;
                case 3:
                    CrudProceso.agregarProceso(productores, entradaInt, entradaStr);
                    break;
                case 4:
                    CrudLabor.crearLabor(productores, entradaStr);
                    break;
                case 5:
                    CrudProductos.ingresarProducto(productores, entradaInt, entradaStr, 1);
                    break;
                case 6:
                    CrudProductos.ingresarProducto(productores, entradaInt, entradaStr, 2);
                    break;
            }
        }while(opcion!=7);
    }
    
    public static void opcionesBuscar(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        Productor prod = null;
        do
        {
            menuBuscar();
            opcion=entradaInt.nextInt();
            switch(opcion)
            {
                case 1:
                    CrudProductor.buscarProductor(productores, entradaInt, entradaStr);
                    break;
                case 2:
                    CrudVivero.buscarVivero(productores);
                    break;
                case 3:
                    CrudProceso.buscarProceso(productores, entradaInt, entradaStr);
                    break;
                case 4:
                    CrudLabor.buscarLabor(productores, entradaStr);
                    break;
                case 5:
                    CrudProductos.BuscarProducto(productores, entradaInt, entradaStr);
                    break;
                case 6:
                    CrudProductor.listarProductor(productores);
                    break;
                case 7:
                    prod = CrudProductor.encontrarProductor(productores, entradaInt);
                    CrudVivero.mostrarViveros(prod.getViveros());
                    break;
                    
            }
        }while(opcion!=8);
    } 

    public static void opcionesActualizar(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        Productor prod = null;
        do
        {
            menuActualizar();
            opcion=entradaInt.nextInt();
            switch(opcion)
            {
                case 1:
                    CrudProductor.actualizarProductor(productores, entradaInt, entradaStr);
                    break;
                case 2:
                    CrudVivero.eliminarVivero(productores);
                    break;
                case 3:
                    CrudProceso.eliminarProceso(productores, entradaInt, entradaStr);
                    break;
                case 4:
                    CrudLabor.actualizarLabor(productores, entradaInt, entradaStr);
                    break;
                case 5:
                    CrudProductos.ActualizarProductos(productores, entradaInt, entradaStr);
                    break;
            }
        }while(opcion!=6);
    }
    public static void opcionesEliminar(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        Productor prod = null;
        do
        {
            menuEliminar();
            opcion=entradaInt.nextInt();
            switch(opcion)
            {
                case 1:
                    CrudProductor.eliminarProductor(productores, entradaInt, entradaStr);
                    break;
                case 2:
                    prod = CrudProductor.encontrarProductor(productores, entradaInt);
                    Vivero vivero = CrudVivero.encontrarVivero(prod.getViveros(), entradaInt);
                    CrudVivero.actualizarVivero(vivero);
                    break;
                case 3:
                    CrudProceso.actualizarProceso(productores, entradaInt, entradaStr);
                    break;
                case 4:
                    CrudLabor.eliminarLabor(productores, entradaInt, entradaStr);
                    break;
                case 5:
                    CrudProductos.EliminarProductos(productores, entradaInt, entradaStr);
                    break;
            }
        }while(opcion!=6);
    }   
        
    public static void main(String[] args) {
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaStr= new Scanner(System.in);
        ArrayList<Productor> productores = new ArrayList<>();
        Productor nuevoProductor = new Productor (1,"ander","gomez");
        productores.add(nuevoProductor);
        
        ArrayList<Vivero> viveros = new ArrayList<>();
        Vivero nuevoVivero = new Vivero(2,"las acacias","risaralda","pereira");
        viveros.add(nuevoVivero);
        
        ArrayList<Proceso> procesos = new ArrayList<>();
        Proceso nuevoProceso = new Proceso(3,"siembra",15,20);
        procesos.add(nuevoProceso);
        
        ArrayList<Labor> labores = new ArrayList<>();
        Labor nuevaLabor = new Labor ("fumigar","15 jun","nada");
        labores.add(nuevaLabor);
        
        ArrayList<ProductoControl> productoControl = new ArrayList<>();
        ControlPlaga nuevaPlaga= new ControlPlaga(987,"laza",10,20);
        productoControl.add(nuevaPlaga);
        //ControlPlaga(registroICA, nombreProducto, FrecuenciaAplicacion, periodoCarencia);
        labores.get(0).setProductoControl(productoControl);
        procesos.get(0).setLabores(labores);
        viveros.get(0).setProcesos(procesos);
        productores.get(0).setViveros(viveros);
       
        int opcion;
        do {
            menuCRUD();
            opcion = entradaInt.nextInt();
            switch(opcion)
            {
                case 1:
                    opcionesAgregar(productores, entradaInt, entradaStr);
                    break;
                case 2:
                    opcionesBuscar(productores, entradaInt, entradaStr);
                    break;
                case 3:
                    opcionesActualizar(productores, entradaInt, entradaStr);
                    break;
                case 4:
                    opcionesEliminar(productores, entradaInt, entradaStr);
                    break;
            }
        } while (opcion != 5);
        
        
    }
}
