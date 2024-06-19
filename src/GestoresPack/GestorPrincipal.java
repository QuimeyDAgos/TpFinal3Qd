package GestoresPack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import ConcertPack.Concierto;
import ConcertPack.Entradas;

public class GestorPrincipal {
    private HashMap<Integer, Entradas> entradasTotales;
    private LinkedList<Concierto> conciertos;

    public GestorPrincipal(){
        this.entradasTotales=new HashMap<>();
        this.conciertos= new LinkedList<>();
    }

    public void setGestiona ()
    {
        //se crean los eventos, y se le añaden a todos los mismos parametros, es un ejemplo da igual;
        Concierto eventoVelaPuerca = new Concierto("Vela Puerca", "22/06/2024", "Movistar Arena");
        Concierto eventoNathyPeluso = new Concierto("Nathy Peluso", "23/06/2024", "Movistar Arena");
        Concierto eventoDuki= new Concierto("Duki", "29/06/2024", "Movistar Arena");
        Concierto eventoTini = new Concierto("Tini", "30/06/2024", "Movistar Arena");
        Concierto eventoDuaLipa = new Concierto("Dua Lipa", "06/07/2024", "Movistar Arena");
        conciertos.add(eventoVelaPuerca);
        conciertos.add(eventoNathyPeluso);
        conciertos.add(eventoDuki);
        conciertos.add(eventoTini);
        conciertos.add(eventoDuaLipa);
        // se elije un evento y llamamos a MenuAdmin
        System.out.println("Elija un evento");
        System.out.println("1. Vela Puerca");
        System.out.println("2. Nathy Peluso");
        System.out.println("3. Duki");
        System.out.println("4. Tini");
        System.out.println("5. Dua Lipa");
        System.out.println("Ingrese el numero que desee: ");
        Scanner sc=new Scanner(System.in);
        int value=sc.nextInt();
        MenuAdmin menuAdmin=new MenuAdmin();
        menuAdmin.menu(sc);
        sc.close();
        


        /// mientras tanto esta en register menu admin asi lo van probando
    }

    
}
