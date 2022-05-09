/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binariospersonas;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private int telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

   
   
    
    
    public Persona(){}
    
    public Persona crearPersona(Persona p){
        Scanner sc=new Scanner(System.in);
        boolean bien=false;
        
        while (bien!=true) {
        
        System.out.printf("\n%1s","Introduce el nombre:  ");
        p.setNombre(sc.next());
        System.out.printf("\n%1s","Introduce el apellido:  ");
        p.setApellido(sc.next());
        System.out.printf("\n%1s","Introduce el telefono:  ");
        p.setTelefono(sc.nextInt());
        System.out.printf("%1s%5s%5d\n",p.getNombre(),p.getApellido(),p.getTelefono());
        System.out.println("¿Quieres añadir a esta persona? (true/false)");
        bien=sc.nextBoolean();
        }
        return p;
    }
    
    public void describeContacto(Persona p){
        System.out.printf("%1s%6s%6d%2s",p.getNombre(),p.getApellido(),p.getTelefono()," años");
    }
    
    public Persona modContacto(Persona p){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el telefono");
        p.setTelefono(sc.nextByte());
        return p;
    }
}
