/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binariospersonas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Principal {

    /**
     * Crearemos una lista de contactos, los resultados se guardarán en ficheros binarios
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ListaContactos ListaCon=new ListaContactos();
        ListaCon=ListaCon.importarContactos(ListaCon);
        boolean salir=false;
        byte elec=0;
      //  System.out.println("BIENVENIDO AL SISTEMA DE CONTACTOS");
        while (salir==false) {
            System.out.printf("\n\n%1s\n","BIENVENIDO AL SISTEMA DE CONTACTOS");
            System.out.println("----------------------------------");
            System.out.println("1. Crear un nuevo contacto");
            System.out.println("2. Ver lista de contactos");
            System.out.println("5. Salir");
            System.out.println("----------------------------------");
            System.out.printf("\n\n%1s","Introduce una opción:  ");
            
            elec=sc.nextByte();
            
            switch (elec) {
                case 1 -> {
                    ListaCon.anadirContacto();
                }
                case 2 -> {
                    ListaCon.verContactos();
                }
                
                case 5 -> {
                    
                    System.out.println("Guardando cambios...");
                    ListaCon.guardarCambios(ListaCon);
                    salir=true;
                }
                default -> {
                    System.out.println("Opción incorrecta, solo puede marcar 1,2,5");
                }
            }
        }
        
      
        
    }
    
}
