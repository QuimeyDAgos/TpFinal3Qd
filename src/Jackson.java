import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class Jackson <T>{

    

    //INSERTAR LISTAS DE DATOS GENERICOS
    public void guardarUno (String nombreArchivo,T dato){

        File archivo = new File(nombreArchivo);

        ObjectMapper  mapper = new ObjectMapper();

        try {

            mapper.writeValue (archivo,dato);

        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    public void guardarArray (String nombreArchivo, ArrayList<T> lista){

        File archivo = new File(nombreArchivo);

        ObjectMapper mapper = new ObjectMapper();

        try{

            mapper.write (archivo,lista);

        }catch (IOException e){

            throw new RuntimeException(e);

        }


    }

    public void guardarLinkedList (String nombreArchivo, LinkedList<T> lista){


        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();

        try{

            mapper.write (archivo,lista);

        }catch (IOException e){

            throw new RuntimeException(e);

        }


    }

    public void guardarHashSet (String nombreArchivo,HashSet<T>lista){
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();

        try{

            mapper.write (archivo,lista);

        }catch (IOException e){

            throw new RuntimeException(e);

        }


    }

    public void guardarHashMap (String nombreArchivo, HashMap<T> map){
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();

        try{

            mapper.write (archivo,lista);

        }catch (IOException e){

            throw new RuntimeException(e);

        }


    }

    //LECTURA DE LISTA DE DATOS GENERICOS
    public T leerDato (String nombreArchivo){

        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper ();
        T dato =null;

        try{

            dato = mapper.readValue (archivo,T.class);
            return dato;

        }catch(IOException e){

            throw new RuntimeException(e);

        }


    }

    public ArrayList<T> leerArray (String nombreArchivo){
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper ();
        ArrayList <T> lista;

        try{

            lista = mapper.readValue (archivo,new TypeReference <ArrayList<T>>(){});
            return lista;

        }catch(IOException e){

            throw new RuntimeException(e);

        }

    }

    public LinkedList <T> leerLinked (String nombreArchivo){
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper ();
        LinkedList <T> lista;

        try{

            lista = mapper.readValue (archivo,new TypeReference <LinkedList<T>>(){});
            return lista;

        }catch(IOException e){

            throw new RuntimeException(e);

        }
    }

    public HashSet<T> leerHashSet (String nombreArchivo){
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper ();
        HashSet <T> lista;

        try{

            lista = mapper.readValue (archivo,new TypeReference <HashSet<T>>(){});
            return lista;

        }catch(IOException e){

            throw new RuntimeException(e);

        }

    }
   
    public HashMap<T> leerHashMap(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper ();
        HashMap<T> lista;

        try{

            map = mapper.readValue (archivo,new TypeReference <HashMap<T>>(){});
            return map;

        }catch(IOException e){

            throw new RuntimeException(e);

        }

    }
}
