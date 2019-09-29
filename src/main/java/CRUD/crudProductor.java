/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Modelo.Productor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ghost
 */
public class crudProductor {
    public static void agregarProductor(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        Productor nuevoProductor = new Productor();
        System.out.println("Digite el documento de identidad.");
        nuevoProductor.setDocumento(entradaInt.nextInt());
        System.out.println("Digite el nombre.");
        nuevoProductor.setNombre(entradaStr.nextLine());
        System.out.println("Digite el apellido.");
        nuevoProductor.setApellido(entradaStr.nextLine());
        if (productores.add(nuevoProductor))
        {
            System.out.println("Productor agregado con exito");
        }else
        {
            System.out.println("Error al añadir productor");
        } 
    }
    public static void buscarProductor(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        if(productores.isEmpty())
        {
            System.out.println("No ha añadido productores");
        }else
        {
            System.out.println("BUSQUEDA DE PRODUCTOR");
            Productor productorEncontrado = encontrarProductor(productores,entradaInt);
            if (productorEncontrado==null)
            {
                System.out.println("No se ha encontrado ningun productor con ese numero de documento");
            }else
            {
                productorEncontrado.imprimir();
                CrudVivero.mostrarViveros(productorEncontrado.getViveros());
            }
        }
    }
    public static Productor encontrarProductor (ArrayList<Productor> productores, Scanner entradaInt)
    {
        int documento;
        Productor productorEncontrado = null;
        System.out.println("Digite el documento de identidad.");
        //documento = entradaInt.nextInt();
        documento=12345;
        for (Productor productore : productores) {
            if (productore.getDocumento()==documento)
            {
                productorEncontrado=productore;
            }
        }
        return productorEncontrado;
    }
    public static void listarProductor (ArrayList<Productor> productores)
    {
        if (productores.isEmpty())
        {
            System.out.println("No hay productores para mostrar");
        }else
        {
            System.out.println("LISTAR PRODUCTORES");
            for (Productor productore : productores) {
                productore.imprimir();
            }
        }
    }
    public static void actualizarProductor(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        if(productores.isEmpty())
        {
            System.out.println("No ha añadido productores.");
        }else
        {
            System.out.println("BUSQUEDA DE PRODUCTOR.");
            Productor productorEncontrado = encontrarProductor(productores,entradaInt);
            if (productorEncontrado==null)
            {
                System.out.println("No se ha encontrado ningun productor con ese numero de documento.");
            }else
            {
                int opcion;
                
                do {
                    menuActualizar();
                    opcion=entradaInt.nextInt();
                    switch (opcion) {
                        case 1:
                            editarDocumento(productorEncontrado, entradaInt);
                            break;
                        case 2:
                            editarNombre(productorEncontrado, entradaStr);
                            break;
                        case 3:
                            editarApellido(productorEncontrado, entradaStr);
                            break;
                        default:
                            System.out.println("Digite una opcion valida");
                            break;
                    }
                } while (opcion != 4);
                
            }
        }
    }
    private static void menuActualizar()
    {
        System.out.println("1<-     Actualice el documento.");
        System.out.println("2<-     Actualice el nombre.");
        System.out.println("3<-     Actualice el apellido.");
    }
    private static void editarDocumento(Productor productorEncontrado, Scanner entradaInt) 
    {
        int documento;
        System.out.println("Nuevo documento de identidad");
        documento = entradaInt.nextInt();
        productorEncontrado.setDocumento(documento);
        System.out.println("DOCUMENTO ACTUALIZADO");
    }
    private static void editarNombre(Productor productorEncontrado, Scanner entradaStr)
    {
        String nombre;
        System.out.println("Nuevo nombre");
        nombre=entradaStr.nextLine();
        productorEncontrado.setNombre(nombre);
        System.out.println("NOMBRE ACTUALIZADO");
    }
    private static void editarApellido(Productor productorEncontrado, Scanner entradaStr)
    {
        String apellido;
        System.out.println("Nuevo apellido");
        apellido=entradaStr.nextLine();
        productorEncontrado.setApellido(apellido);
        System.out.println("APELLIDO ACTUALIZADO");
    }
    
    public static void eliminarProductor(ArrayList<Productor> productores, Scanner entradaInt, Scanner entradaStr)
    {
        if(productores.isEmpty())
        {
            System.out.println("No ha añadido productores");
        }else
        {
            System.out.println("BUSQUEDA DE PRODUCTOR");
            Productor productorEncontrado = encontrarProductor(productores,entradaInt);
            if (productorEncontrado==null)
            {
                System.out.println("No se ha encontrado ningun productor con ese numero de documento");
            }else
            {
                System.out.println("ELIMINACION DE PRODUCTOR");
                if (productores.remove(productorEncontrado))
                {
                    System.out.println("Productor eliminado con exito");
                }else
                {
                    System.out.println("No se pudo eliminar productor");
                }
            }
        }
    }
}
