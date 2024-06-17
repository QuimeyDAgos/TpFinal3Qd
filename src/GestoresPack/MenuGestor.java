package GestoresPack;

import java.util.HashSet;
import java.util.Scanner;

import PersonasPack.*;

public class MenuGestor {
public static void main(String[] args) {
    
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
                 Sistema<Persona> sistemaUno = new Sistema<Persona>(listaAdmin, listaArtistas, listaClientes);
                 sistemaUno.gestionarPersonas(in);

                 break;
             case 2:
                 //Aca va el menu de gestor de productos

                 break;
             case 3:
                 //gestionar conciertos

                 break;
             case 4 :
                 salir = true;
                 System.out.println("Volviendo...");
                 break;
             default:
                 break;
         }
     }



in.close();
}

}
