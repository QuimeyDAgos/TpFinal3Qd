import java.util.HashSet;
import java.util.Scanner;

import PersonasPack.*;

public class MenuGestor {
public static void main(String[] args) {
    

    Scanner in = new Scanner(System.in);
    System.out.println("Gestion de todo xd");
    System.out.print(">>");
     int opcion = in.nextInt();
    switch (opcion) {
        case 1:
                HashSet<Admin> listaAdmin = new HashSet<>();
                HashSet<Artista> listaArtistas = new HashSet<>();
                HashSet<Cliente> listaClientes = new HashSet<>();
                 Sistema<Persona> sistemaUno = new Sistema<Persona>(listaAdmin, listaArtistas, listaClientes);
                 sistemaUno.menuGestionarPersonas();

            break;
            case 2:
                //Aca va el menu de gestor de productos
            
            break;
            case 3:
                  //gestionar conciertos
            
            break;




    
        default:
            break;
    }


in.close();
}

}
