package GestoresPack;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import PersonasPack.*;
import ProductosPack.Productos;

public class MenuGestor {
    public void menu () {
    boolean salir =false;
    Scanner in = new Scanner(System.in);
    System.out.println("Gestion de todo xd");
    System.out.print(">>");
     int opcion = in.nextInt();
     while (!salir)
     {
         switch (opcion) {
             case 1:
                 HashSet<Admin> listaAdmin = new HashSet<>();
                 HashSet<Artista> listaArtistas = new HashSet<>();
                 HashSet<Cliente> listaClientes = new HashSet<>();
                 SistemaPersona<Persona> sistemaUno = new SistemaPersona<Persona>(listaAdmin, listaArtistas, listaClientes);
                 sistemaUno.gestionarPersonas("Personas.json",in);
                 break;
             case 2:
                 TreeSet<Productos> listaProductos=new TreeSet<>();
                 GestorProductos gestorProductos= new GestorProductos(listaProductos);
                 gestorProductos.gestionarProductos();
                 break;
             case 3:
                 //gestionar conciertos

                 break;
             case 4 :
                 salir = true;
                 System.out.println("Volviendo...");
                 break;
             default:
                 System.out.println("Opcion no valida");
                 break;
         }

        in.close();
     }




}
}


