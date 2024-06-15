import java.util.HashSet;

import PersonasPack.Admin;
import PersonasPack.Artista;
import PersonasPack.Banda;
import PersonasPack.Cliente;
import PersonasPack.Solista;

public class Sistema<T> extends Jackson<T>{

    private HashSet <Admin> listaAdmin;
    private HashSet <Artista> artistas;
    private HashSet <Cliente> clientes;
    private HashSet <Solista> solistas;
    private HashSet<Banda> bandas;

    public Sistema(HashSet<Admin> listaAdmin, HashSet<Artista> artistas, HashSet<Cliente> clientes,
            HashSet<Solista> solistas, HashSet<Banda> bandas) {
        this.listaAdmin = listaAdmin;
        this.artistas = artistas;
        this.clientes = clientes;
        this.solistas = solistas;
        this.bandas = bandas;
    }


    
    //Metodos

    public void leerAdministradores(String nombreArchi){

        for (T persona :leerHashSet(nombreArchi)) {
            if (persona instanceof Admin){

                listaAdmin.add((Admin)persona);

            }else if (persona instanceof Cliente){
                clientes.add((Cliente)persona);

            }else if (persona instanceof Solista){
                solistas.add((Solista)persona);


            }else if (persona instanceof Banda){

                bandas.add((Banda)persona);

            }else{

                artistas.add((Artista)persona);

            }
            
        }


    

    }


    
}
