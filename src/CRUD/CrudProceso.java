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
 * @author ghost
 */
public class CrudProceso {
    private static ArrayList<Proceso> validar(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<Proceso> procesos=null;
        if(productores.isEmpty())
        {
            System.out.println("No se puede añadir procesos sino no hay productores");
        }else
        {
            System.out.println("Digite el documento del productor.");
            Productor encontrarProductor = CrudProductor.encontrarProductor(productores, entradaInt);
            if (encontrarProductor == null)
            {
                System.out.println("No se encuentra ese productor.");
            }else
            {
                //ENCONTRAR VIVERO
                Vivero encontrarVivero;
                encontrarVivero = CrudVivero.encontrarVivero(encontrarProductor.getViveros(), entradaInt);
                if (encontrarVivero == null)
                {
                    System.out.println("No se encuentra este vivero.");
                }else
                {
                    System.out.println("Vivero encontrado");
                    procesos=encontrarVivero.getProcesos();
                }
            }
        }
        return procesos;
    }
    public static void agregarProceso(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<Proceso> procesos = validar(productores, entradaInt, entradaStr);
        Proceso nuevoProceso = new Proceso();
        System.out.println("INFORMACION DEL PROCESO:");
        
        System.out.println("Digite el codigo .");
        nuevoProceso.setCodigo(entradaInt.nextInt());
        System.out.println("Digite el nombre.");
        nuevoProceso.setNombre(entradaStr.nextLine());
        System.out.println("Digite las horas.");
        nuevoProceso.setHoras(entradaInt.nextInt());
        System.out.println("Digite el costo");
        nuevoProceso.setCosto(entradaInt.nextInt());
        if (procesos.add(nuevoProceso))
        {
            System.out.println("Proceso agregado con exito");
        }else
        {
            System.out.println("Error al añadir proceso");
        } 
    }
    public static void buscarProceso(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<Proceso> procesos = validar(productores, entradaInt, entradaStr);
        if (procesos==null)
        {
            System.out.println("No hay procesos para buscar");
        }else
        {
            System.out.println("BUSQUEDA DE PROCESO");
            Proceso procesoEncontrado = encontrarProceso(procesos,entradaInt);
            if (procesoEncontrado==null)
            {
                System.out.println("No se ha encontrado ningun proceso con ese codigo");
            }else
            {
                procesoEncontrado.imprimir();
                CrudLabor.imprimirLabores(procesoEncontrado.getLabores());
            }
        }
    }
    public static Proceso encontrarProceso (ArrayList<Proceso> procesos, Scanner entradaInt)
    {
        int codigo;
        Proceso procesoEncontrado = null;
        System.out.println("Digite el codigo del proceso.");
        codigo = entradaInt.nextInt();
        for (Proceso proceso1 : procesos) {
            if (proceso1.getCodigo()==codigo)
            {
                procesoEncontrado=proceso1;
            }
        }
        return procesoEncontrado;
    }
    public static void actualizarProceso(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<Proceso> procesos = validar(productores, entradaInt, entradaStr);
        if (procesos == null) {
            System.out.println("No se han añadido procesos");
        }else
        {
            System.out.println("BUSQUEDA DE PROCESO");
            Proceso procesoEncontrado = encontrarProceso(procesos,entradaInt);
            if (procesoEncontrado==null)
            {
                System.out.println("No se ha encontrado ningun proceso con ese codigo");
            }else
            {
                int opcion;
                
                do {
                    menuActualizar();
                    opcion= entradaInt.nextInt();
                    switch (opcion) {
                        case 1:
                            editarCodigo(procesoEncontrado, entradaInt);
                            break;
                        case 2:
                            editarNombre(procesoEncontrado, entradaStr);
                            break;
                        case 3:
                            editarHoras(procesoEncontrado, entradaInt);
                            break;
                        case 4:
                            editarCosto(procesoEncontrado, entradaInt);
                            break;
                        default:
                            System.out.println("Digite una opcion valida");
                            break;
                    }
                } while (opcion != 5);
            }
        }
    }
    private static void menuActualizar()
    {
        System.out.println("1<-     Actualice el codigo.");
        System.out.println("2<-     Actualice el nombre.");
        System.out.println("3<-     Actualice las horas.");
        System.out.println("3<-     Actualice el costo.");
    }
    private static void editarCodigo(Proceso procesoEncontrado, Scanner entradaInt)
    {
        int codigo;
        System.out.println("Nuevo codigo");
        codigo = entradaInt.nextInt();
        procesoEncontrado.setCodigo(codigo);
        System.out.println("CODIGO ACTUALIZADO");
    }
    private static void editarNombre(Proceso procesoEncontrado, Scanner entradaStr)
    {
        String nombre;
        System.out.println("Nuevo nombre");
        nombre = entradaStr.nextLine();
        procesoEncontrado.setNombre(nombre);
        System.out.println("NOMBRE ACTUALIZADO");
    }
    private static void editarHoras(Proceso procesoEncontrado, Scanner entradaInt)
    {
        int horas;
        System.out.println("Nuevas horas");
        horas = entradaInt.nextInt();
        procesoEncontrado.setHoras(horas);
        System.out.println("HORAS ACTUALIZADAS");
    }
    private static void editarCosto(Proceso procesoEncontrado, Scanner entradaInt)
    {
        int costo;
        System.out.println("Nuevo costo");
        costo = entradaInt.nextInt();
        procesoEncontrado.setCosto(costo);
        System.out.println("COSTO ACTUALIZADO");
    }
    public static void eliminarProceso(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<Proceso> procesos = validar(productores, entradaInt, entradaStr);
        if (procesos==null)
        {
            System.out.println("No se han añadido procesos");
        }else
        {
            System.out.println("BUSQUEDA DE PROCESO");
            Proceso procesoEncontrado = encontrarProceso(procesos,entradaInt);
            if (procesoEncontrado==null)
            {
                System.out.println("No se ha encontrado ningun proceso con ese codigo");
            }else
            {
                if (procesos.remove(procesoEncontrado)) {
                    System.out.println("Proceso eliminado con exito");
                }else
                {
                    System.out.println("No se pudo eliminar el proceso");
                }
            }
        }
    }
}
