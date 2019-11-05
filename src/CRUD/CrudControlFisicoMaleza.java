/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;


import Modelo.Labor;
import Modelo.Proceso;
import Modelo.Productor;
import Modelo.Vivero;
import Modelo.ControlFisicoMaleza;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ghost
 */
public class CrudControlFisicoMaleza {
    
    private static ArrayList<ControlFisicoMaleza> validar(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<ControlFisicoMaleza> controlFisico = new ArrayList<>();
       
       if(productores.isEmpty()){
           System.out.println("Sin productores no pueden existir labores");
       }else{
           Productor productor;
           productor = CrudProductor.encontrarProductor(productores, entradaInt);
           
           if(productor == null){
               System.out.println("No existe un productor asociado a este documento.");
           }else{
               Vivero vivero;
               vivero = CrudVivero.encontrarVivero(productor.getViveros(), entradaInt);
               
               if(vivero == null){
                   System.out.println("No se encontro un vivero con este codigo.");
               }else{
                   Proceso proceso;
                   proceso = CrudProceso.encontrarProceso(vivero.getProcesos(), entradaInt);
                   
                   if(proceso == null){
                       System.out.println("No exite el proceso en este vivero.");
                   }else{
                       Labor labores;
                       labores = CrudLabor.encontrarLabor(proceso.getLabores(), entradaStr);
                       
                       if(labores == null)
                       {
                           System.out.println("No existe esta labor en el proceso.");
                       }
                       else
                       {
                           controlFisico=labores.getControlFisicoMalezas();
                       }
                   }
               }
           }
       }
       return controlFisico;
    }
    public static void ingresarControlFisico (ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        int frecuenciaPoda;
        String fechaUltimaPoda;
        ArrayList<ControlFisicoMaleza> controlFisico = validar(productores, entradaInt, entradaStr);
        System.out.println("\nDIGITE:\n");
        System.out.println("La frecuencia de poda.");
        frecuenciaPoda=entradaInt.nextInt();
        System.out.println("Fecha ultima poda DD/MM/AA");
        fechaUltimaPoda=entradaStr.nextLine();
        ControlFisicoMaleza nuevoControlFisico = new ControlFisicoMaleza (frecuenciaPoda,fechaUltimaPoda);
        controlFisico.add(nuevoControlFisico);
    }
    
    public static void BuscarControlFisico(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<ControlFisicoMaleza> controlFisico = validar(productores, entradaInt, entradaStr);
        if(controlFisico.isEmpty())
        {
            System.out.println("No hay productos para buscar");
        }else
        {
            ControlFisicoMaleza controlFisicoEncontrado = EncontrarProducto(controlFisico,entradaInt,entradaStr);
            if (controlFisicoEncontrado==null)
            {
                System.out.println("No se encuentra un producto con ese registro");
            }else
            {
                controlFisicoEncontrado.imprimir();
            }
        }
    }
    
    private static ControlFisicoMaleza EncontrarProducto(ArrayList<ControlFisicoMaleza> controlFisico, Scanner entradaInt, Scanner entradaStr)
    {
        int codigo;
        ControlFisicoMaleza controlFisicoEncontrado=null;
        System.out.println("codigo del control fisico maleza");
        codigo = entradaInt.nextInt();
        for (ControlFisicoMaleza control : controlFisico) {
            if(control.getCodigo()==codigo)
            {
                controlFisicoEncontrado=control;
            }
        }
        return controlFisicoEncontrado;
    }
    
    public static void ActualizarControlFisico(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        
        int opcion;
        ArrayList<ControlFisicoMaleza> controlFisico = validar(productores, entradaInt, entradaStr);
        ControlFisicoMaleza controlFisicoEncontrado = EncontrarProducto(controlFisico, entradaInt, entradaStr);
            if (controlFisicoEncontrado==null)
            {
                System.out.println("No se encuentra un producto con ese registro");
            }else
            {
                do
                {
                   menuAtributos();
                   opcion=entradaInt.nextInt();
                   switch(opcion)
                   {
                       case 1:
                            actualizarFrecuenciaPoda(controlFisicoEncontrado,entradaInt);
                            break;
                        case 2:
                            actualizarFechaPoda(controlFisicoEncontrado,entradaStr);
                            break;
                   }
                }while(opcion != 3); 
            }   
    }
    private static void actualizarFrecuenciaPoda(ControlFisicoMaleza controlFisicoEncontrado, Scanner entradaInt)
    {
        System.out.println("Frecuencia de la poda");
        controlFisicoEncontrado.setFrecuenciaPoda(entradaInt.nextInt());
    }
    private static void actualizarFechaPoda(ControlFisicoMaleza controlFisicoEncontrado, Scanner entradaStr) 
    {
        System.out.println("La fecha de la ultima  poda");
        controlFisicoEncontrado.setFechaUltimaPoda(entradaStr.nextLine());
    }
    
    private static void menuAtributos(){
        System.out.println("1<- Actualizar frecuencia de poda");
        System.out.println("2<- Actualizar la fecha de la poda");
        System.out.println("5<- Salir\n");
    }
    
    public static void EliminarControlFisico(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<ControlFisicoMaleza> productos = validar(productores, entradaInt, entradaStr);
        ControlFisicoMaleza controlFisicoEncontrado = EncontrarProducto(productos, entradaInt, entradaStr);
        if (controlFisicoEncontrado==null)
        {
            System.out.println("No se encuentra el control fisico con ese registro");
        }else
        {
            if (productos.remove(controlFisicoEncontrado))
            {
                System.out.println("control fisico eliminado");
            }else
            {
                System.out.println("No se pudo eliminar este control fisico");
            }
        }
    }
}
