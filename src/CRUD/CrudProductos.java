/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Modelo.ControlFertilizante;
import Modelo.ControlPlaga;
import Modelo.Labor;
import Modelo.Proceso;
import Modelo.ProductoControl;
import Modelo.Productor;
import Modelo.Vivero;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ghost
 */
public class CrudProductos {
    
    private static ArrayList<ProductoControl> validar(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<ProductoControl> productos = null;
       
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
                           productos=labores.getProductoControl();
                       }
                   }
               }
           }
       }
       return productos;
    }
    public static void ingresarProducto (ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr, int opcion)
    {
        ArrayList<ProductoControl> productos = validar(productores, entradaInt, entradaStr);
        System.out.println("\nDIGITE:\n");
        System.out.println("El registro ICA");
        int registroICA=entradaInt.nextInt();
        System.out.println("El nombre del producto");
        String nombreProducto=entradaStr.nextLine();
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        int FrecuenciaAplicacion =entradaInt.nextInt();
        if(opcion == 1)
        {
            System.out.println("El Periodo de carencia del producto (en numero de dias)");
            int periodoCarencia=entradaInt.nextInt();
            ControlPlaga nuevoControlPlaga = new ControlPlaga(registroICA, nombreProducto, FrecuenciaAplicacion, periodoCarencia);
            productos.add(nuevoControlPlaga);
        }else
        {
           
            System.out.println("El numero de dias desde cuando se aplico el producto (en numero de dias)");
            int ultimaAplicacion=entradaInt.nextInt();
            ControlFertilizante nuevoControlFertilizante = new ControlFertilizante(registroICA, nombreProducto, FrecuenciaAplicacion, ultimaAplicacion);
            productos.add(nuevoControlFertilizante);
        }
    }
    
    public static void BuscarProducto(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<ProductoControl> productos = validar(productores, entradaInt, entradaStr);
        if(productos.isEmpty())
        {
            System.out.println("No hay productos para buscar");
        }else
        {
            ProductoControl productoEncontrado = EncontrarProducto(productos,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("No se encuentra un producto con ese registro");
            }else
            {
                if (productoEncontrado instanceof ControlPlaga)
                {
                    ControlPlaga controlPlagaEncontrado = (ControlPlaga) productoEncontrado;
                    controlPlagaEncontrado.imprimir();
                }else
                {
                    ControlFertilizante controlFertilizanteEncontrado = (ControlFertilizante) productoEncontrado;
                    controlFertilizanteEncontrado.imprimir();
                }
            }
        }
    }
    
    private static ProductoControl EncontrarProducto(ArrayList<ProductoControl> Productos, Scanner entradaInt, Scanner entradaStr)
    {
        int registroICA;
        ProductoControl productoEncontrado=null;
        System.out.println("Digite el registro ICA");
        registroICA = entradaInt.nextInt();
        for (ProductoControl Producto : Productos) {
            if(Producto.getRegistroICA()==registroICA)
            {
                productoEncontrado=Producto;
            }
        }
        return productoEncontrado;
    }
    
    public static void ActualizarProductos(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        
        int opcion;
        ArrayList<ProductoControl> productos = validar(productores, entradaInt, entradaStr);
        ProductoControl productoEncontrado = EncontrarProducto(productos, entradaInt, entradaStr);
            if (productoEncontrado==null)
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
                            actualizarRegistroICA(productoEncontrado,entradaInt);
                            break;
                        case 2:
                            actualizarNombre(productoEncontrado,entradaStr);
                            break;
                        case 3:
                            actualizarFrecuencia(productoEncontrado,entradaInt);
                            break;
                        case 4:
                            actualizarAtributoIndividual(productoEncontrado,entradaInt);
                            break;
                   }
                }while(opcion != 5); 
            }   
    }
    private static void actualizarRegistroICA(ProductoControl productoEncontrado, Scanner entradaInt)
    {
        System.out.println("El registro ICA");
        productoEncontrado.setRegistroICA(entradaInt.nextInt());
    }
    private static void actualizarNombre(ProductoControl productoEncontrado, Scanner entradaStr) 
    {
        System.out.println("El nombre del producto");
        productoEncontrado.setNombreProducto(entradaStr.nextLine());
    }
    private static void actualizarFrecuencia(ProductoControl productoEncontrado, Scanner entradaInt) 
    {
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        productoEncontrado.setFrecuenciaAPlicacion(entradaInt.nextInt());
    }
    private static void actualizarAtributoIndividual(ProductoControl productoEncontrado, Scanner entradaInt)
    {
        if (productoEncontrado instanceof ControlPlaga)
                {
                    ControlPlaga almacenaControlPlaga = (ControlPlaga) productoEncontrado;
                    System.out.println("El Periodo de carencia del producto (en numero de dias)");
                    almacenaControlPlaga.setPeriodoCarencia(entradaInt.nextInt());
                }else
                {
                    ControlFertilizante almacenaControlFertilizante = (ControlFertilizante) productoEncontrado;
                    System.out.println("El Periodo de aplicacion del producto (en numero de dias)");
                    almacenaControlFertilizante.setUltimaAplicacion(entradaInt.nextInt());
                }
    }
    private static void menuAtributos(){
        System.out.println("1<- Actualizar el registroICA");
        System.out.println("2<- Actualizar el nombre");
        System.out.println("3<- Actualizar la frecuencia de aplicacion");
        System.out.println("4<- Actualizar el periodo carencia/periodo aplicacion");
        System.out.println("5<- Salir\n");
    }
    
    public static void EliminarProductos(ArrayList<Productor> productores,Scanner entradaInt, Scanner entradaStr)
    {
        ArrayList<ProductoControl> productos = validar(productores, entradaInt, entradaStr);
        ProductoControl productoEncontrado = EncontrarProducto(productos, entradaInt, entradaStr);
        if (productoEncontrado==null)
        {
            System.out.println("No se encuentra un producto con ese registro");
        }else
        {
            if (productos.remove(productoEncontrado))
            {
                System.out.println("producto eliminado");
            }else
            {
                System.out.println("No se pudo eliminar este producto");
            }
        }
    }
}
