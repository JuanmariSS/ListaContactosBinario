/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binariospersonas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;
/**
 *
 * @author Alumno
 */
public class ListaContactos implements Serializable {
    private List <Persona> ListaP=new ArrayList<>();
    
    public ListaContactos(){}
    
    public ListaContactos importarContactos(ListaContactos ListaC){
       
        try {
          ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream("contactos.bin")));
            ListaC=(ListaContactos)ois.readObject();
            ois.close();
        }
        catch (IOException ex) {
           
            System.out.println("No se ha encontrado ningún fichero de contactos");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaContactos.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ListaC;
    }
    
    public void verContactos() {
        Scanner sc=new Scanner(System.in);
        int cnt;
        //En caso de que no haya ningún usuario en la lista
        if (ListaP.size()==0) {
            System.out.printf("\n%1s\n\n","No hay contactos en el registro.");
            return;
        }
        //Ya habiendo usuarios en la lista
        
        for (int i = 0; i < ListaP.size(); i++) {
            System.out.printf("%1d%1s%5s\n",i,".",ListaP.get(i).getNombre());
        }
        System.out.println("Indica qué persona quieres ver");
        cnt=sc.nextInt();
        while (cnt<0 || (cnt>ListaP.size()-1)) {
            System.out.println("Numero incorrecto, introduce un usuario correcto");
        }
        ListaP.get(cnt).describeContacto(ListaP.get(cnt));
        
        System.out.printf("\n\n","Quiere modificar este contacto (true/false)");
        boolean mod=sc.nextBoolean();
        if (mod==true) {
          ListaP.get(cnt).modContacto(ListaP.get(cnt));
          return;
        }
        
        System.out.println("¿Quiere eliminar este contacto (true/false)?");
        boolean del=sc.nextBoolean();
        if (del==true) {
            System.out.println("El contacto" + ListaP.get(cnt) + " ha sido eliminado");
            ListaP.remove(ListaP.get(cnt));
        }
        
    }
    
    public void anadirContacto () {
        Persona p=new Persona();
        p.crearPersona(p);
        ListaP.add(p);
    }
    
    public void guardarCambios (ListaContactos ListaC) {
      ObjectOutputStream oos;
     
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("contactos.bin")));
            oos.writeObject(ListaC);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaContactos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListaContactos.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
    
    
}
