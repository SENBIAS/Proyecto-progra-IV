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
    public static void menu ()
    {
        System.out.println("Bienvenido al menu principal.\n");
        System.out.println("            INGRESOS\n");
        System.out.println("1<-     Ingrese Productores,");
        System.out.println("2<-     Ingrese viveros.");
        System.out.println("3<-     ingrese procesos.");
        System.out.println("4<-     Ingrse labores.\n");
        System.out.println("            BUSQUEDA Y LISTA.\n");
        System.out.println("5<-     Busque la informacion de un productor.");
        System.out.println("6<-     Busque la informacion de un vivero.");
        System.out.println("7<-     Busque la informacion de un proceso.");
        System.out.println("8<-     Liste las labores.");
        System.out.println("9<-     Liste los Productores");
        System.out.println("10<-    Liste los viveros.\n");
        System.out.println("            ACTUALIZACIONES.\n");
        System.out.println("11<-    Actualice la informacion de Productores.");
        System.out.println("12<-    Actualice la informacion de viveros.");
        System.out.println("13<-    Actualice la informacion de procesos.");
        System.out.println("14<-    Actualice la informacion de labores.\n");

        System.out.println("            ELIMINACION.\n");
        System.out.println("15<-    Elimine Productores,");
        System.out.println("16<-    Elimine viveros.");
        System.out.println("17<-    Elimine procesos.");
        System.out.println("18<-    Elimine labores.\n");
        
    }
    
    public static void main(String[] args) {
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaStr= new Scanner(System.in);
        ArrayList<Productor> productores = new ArrayList<>();
       Productor nuevoproductor = new Productor (12345,"Anderson","Gomez");
       Productor nuevoproductor1= new Productor (9876,"Sebastian","londono");
       productores.add(nuevoproductor);
        productores.add(nuevoproductor1);
        Productor prod ;
        int opcion;
        do {
            menu();
            opcion = entradaInt.nextInt();
            switch (opcion) {
                case 1:
                    crudProductor.agregarProductor(productores, entradaInt, entradaStr);
                    break;
                case 2:
                    CrudVivero.crearVivero(productores, entradaInt, entradaStr);
                    break;
                case 3:
                    crudProceso.agregarProceso(productores, entradaInt, entradaStr);
                    break;
                case 4:
                    CrudLabor.crearLabor(productores, entradaStr);
                    break;
                case 5:
                    crudProductor.buscarProductor(productores, entradaInt, entradaStr);
                    break;
                case 6:
                    CrudVivero.buscarVivero(productores);
                    break;
                case 7:
                    crudProceso.buscarProceso(productores, entradaInt, entradaStr);
                    break;
                case 8:
                    CrudLabor.listarLabor(productores, entradaStr);
                    break;
                case 9:
                    crudProductor.listarProductor(productores);
                    break;
                case 10:
                    prod = crudProductor.encontrarProductor(productores, entradaInt);
                    CrudVivero.mostrarViveros(prod.getViveros());
                    break;
                case 11:
                    crudProductor.actualizarProductor(productores, entradaInt, entradaStr);
                    break;
                case 12:
                    prod = crudProductor.encontrarProductor(productores, entradaInt);
                    Vivero vivero = CrudVivero.encontrarVivero(prod.getViveros(), entradaInt);
                    CrudVivero.actualizarVivero(vivero);
                    break;
                case 13:
                    crudProceso.ActualizarProceso(productores, entradaInt, entradaStr);
                    break;
                case 14:
                    
                    break;
                case 15:
                    crudProductor.eliminarProductor(productores, entradaInt, entradaStr);
                    break;
                case 16:
                    CrudVivero.eliminarVivero(productores);
                    break;
                case 17:
                    crudProceso.eliminarProceso(productores, entradaInt, entradaStr);
                    break;
                case 18:
                    
                    break;
                default:
                    System.out.println("Digite una opcion correcta");
                break;
            }
        } while (opcion != 19);
        
        
    }
}
