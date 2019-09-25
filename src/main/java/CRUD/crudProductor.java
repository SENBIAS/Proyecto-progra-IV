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
}
