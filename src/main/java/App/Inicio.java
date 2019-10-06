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
<<<<<<< HEAD
        System.out.println("8<-     Busque la informacion de una labor.");
        System.out.println("9<-     Liste los Productores");
        System.out.println("10<-    Liste los viveros.\n");
        System.out.println("            ACTUALIZACIONES.\n");
        System.out.println("11<-     Actualice la informacion de Productores.");
        System.out.println("12<-     Actualice la informacion de viveros.");
        System.out.println("13<-     Actualice la informacion de procesos.");
        System.out.println("14<-     Actualice la informacion de labores.\n");
=======
        System.out.println("8<-     Busque la informacion de las labores.");
        System.out.println("9<-     Liste los Productores");
        System.out.println("10<-    Liste los viveros.\n");
        System.out.println("            ACTUALIZACIONES.\n");
        System.out.println("11<-    Actualice la informacion de Productores.");
        System.out.println("12<-    Actualice la informacion de viveros.");
        System.out.println("13<-    Actualice la informacion de procesos.");
        System.out.println("14<-    Actualice la informacion de labores.\n");
>>>>>>> pruebas

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
        Productor prod ;
        int opcion;
        do {
            menu();
            opcion = entradaInt.nextInt();
            switch (opcion) {
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
                    CrudProductor.buscarProductor(productores, entradaInt, entradaStr);
                    break;
                case 6:
                    CrudVivero.buscarVivero(productores);
                    break;
                case 7:
                    CrudProceso.buscarProceso(productores, entradaInt, entradaStr);
                    break;
                case 8:
                    CrudLabor.buscarLabor(productores, entradaStr);
                    break;
                case 9:
                    CrudProductor.listarProductor(productores);
                    break;
                case 10:
                    prod = CrudProductor.encontrarProductor(productores, entradaInt);
                    CrudVivero.mostrarViveros(prod.getViveros());
                    break;
                case 11:
                    CrudProductor.actualizarProductor(productores, entradaInt, entradaStr);
                    break;
                case 12:
                    prod = CrudProductor.encontrarProductor(productores, entradaInt);
                    Vivero vivero = CrudVivero.encontrarVivero(prod.getViveros(), entradaInt);
                    CrudVivero.actualizarVivero(vivero);
                    break;
                case 13:
                    CrudProceso.actualizarProceso(productores, entradaInt, entradaStr);
                    break;
                case 14:
                    CrudLabor.actualizarLabor(productores, entradaInt, entradaStr);
                    break;
                case 15:
                    CrudProductor.eliminarProductor(productores, entradaInt, entradaStr);
                    break;
                case 16:
                    CrudVivero.eliminarVivero(productores);
                    break;
                case 17:
                    CrudProceso.eliminarProceso(productores, entradaInt, entradaStr);
                    break;
                case 18:
                    CrudLabor.eliminarLabor(productores, entradaInt, entradaStr);
                    break;
                default:
                    System.out.println("Digite una opcion correcta");
                break;
            }
        } while (opcion != 19);
        
        
    }
}
