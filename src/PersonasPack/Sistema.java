package PersonasPack;

import java.util.HashSet;

public class Sistema<T> extends Jackson<T> {

    private HashSet<Admin> listaAdmin;
    private HashSet<Artista> artistas;
    private HashSet<Cliente> clientes;

    public Sistema(HashSet<Admin> listaAdmin, HashSet<Artista> artistas, HashSet<Cliente> clientes) {
        this.listaAdmin = listaAdmin;
        this.artistas = artistas;
        this.clientes = clientes;
        
    }
    // Metodos
    public void leerPersonas(String nombreArchi) {

        for (T persona : leerHashSet(nombreArchi)) {
            if (persona instanceof Admin) {

                listaAdmin.add((Admin) persona);

            } else if (persona instanceof Cliente) {
                clientes.add((Cliente) persona);

            } else {

                artistas.add((Artista) persona);

            }

        }

    }
    //mostrar Listas
    public void mostrarListaArtista() {

        for (Artista artista : artistas) {

            System.out.println(artista);

        }

    }

    public void mostrarListaAdmin() {

        for (Admin admin : listaAdmin) {

            System.out.println(admin);

        }

    }

    public void mostrarListaClientes() {

        for (Cliente cliente: clientes) {

            System.out.println(cliente);
            

        }

    }
    




    
}
