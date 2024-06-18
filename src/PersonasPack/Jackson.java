package PersonasPack;
import ConcertPack.Entradas;
import ProductosPack.Comida;
import ProductosPack.Merch;
import ProductosPack.Productos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Jackson <T> {

    //Insertar datos en json 
    public void guardarUnoEnlista(String nombreArchivo, T dato) {

        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            HashSet<T> lista_Personas = leerHashSet(nombreArchivo);
            lista_Personas.add(dato);

            mapper.writeValue(archivo, lista_Personas);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*public void guardarUnoEnlista(String nombreArchivo, T dato) {
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            HashSet<T> lista_Personas = leerHashSet(nombreArchivo);
            lista_Personas.add(dato);

            mapper.writeValue(archivo, lista_Personas);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    public void guardarArray(String nombreArchivo, ArrayList<T> lista) {

        File archivo = new File(nombreArchivo);

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(archivo, lista);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }

    public void guardarLinkedList(String nombreArchivo, LinkedList<T> lista) {


        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(archivo, lista);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }

    public void guardarHashSet(String nombreArchivo, HashSet<T> lista) {
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        HashSet<T> datosExistente = new HashSet<>();
        try {
            if (archivo.exists()) {
                datosExistente = mapper.readValue(archivo, new TypeReference<HashSet<T>>() {
                });
                // Eliminar elementos existentes que están en lista
                datosExistente.removeAll(lista);
            }
            datosExistente.addAll(lista);
            mapper.writeValue(archivo, datosExistente);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Lectura en diferentes colecciones
    public ArrayList<T> leerArray(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> lista;

        try {

            lista = mapper.readValue(archivo, new TypeReference<ArrayList<T>>() {
            });
            return lista;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public LinkedList<T> leerLinked(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();
        LinkedList<T> lista;

        try {

            lista = mapper.readValue(archivo, new TypeReference<LinkedList<T>>() {
            });
            return lista;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }

    public HashSet<T> leerHashSet(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();
        HashSet<T> lista;

        try {

            lista = mapper.readValue(archivo, new TypeReference<HashSet<T>>() {
            });
            return lista;

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    //Busqueda de diferentes personas
    public T buscarCliente(HashSet<T> lista, int id) {

        for (T dato : lista) {
            if (dato instanceof Cliente) {
                Cliente aux = (Cliente) dato;
                if (aux.getDni() == id) {
                    return dato;
                }
            }

        }
        return null;
    }

    public T buscarArtista(HashSet<T> lista, int id) {

        for (T dato : lista) {
            if (dato instanceof Artista) {
                Artista aux = (Artista) dato;
                if (aux.getDni() == id) {
                    return dato;
                }
            }

        }
        return null;
    }

    public T buscarAdmin(HashSet<T> lista, int id) {

        for (T dato : lista) {
            if (dato instanceof Admin) {
                Admin aux = (Admin) dato;
                if (aux.getDni() == id) {
                    return dato;
                }
            }

        }
        return null;
    }

    //Eliminacion de Personas
    public void eliminarArtista(String nombreArchi, int id) {

        try {
            File archi = new File(nombreArchi);
            ObjectMapper map = new ObjectMapper();
            HashSet<T> lista = leerHashSet(nombreArchi);
            Artista aux = (Artista) buscarArtista(lista, id);
            lista.remove(aux);
            map.writeValue(archi, lista);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public void eliminarCliente(String nombreArchi, int id) {

        try {
            File archi = new File(nombreArchi);
            ObjectMapper map = new ObjectMapper();
            HashSet<T> lista = leerHashSet(nombreArchi);
            Cliente aux = (Cliente) buscarArtista(lista, id);
            lista.remove(aux);
            map.writeValue(archi, lista);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public void eliminarAdmin(String nombreArchi, int id) {

        try {
            File archi = new File(nombreArchi);
            ObjectMapper map = new ObjectMapper();
            HashSet<T> lista = leerHashSet(nombreArchi);
            Admin aux = (Admin) buscarArtista(lista, id);
            lista.remove(aux);
            map.writeValue(archi, lista);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public void guardarHashMap(String nombreArchivo, HashMap<Integer, Entradas> mapa) {
        File archivo = new File(nombreArchivo);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(archivo, mapa);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TreeSet<Productos> cargarTreeSet(String archivo) {
        ObjectMapper mapper = new ObjectMapper();
        TreeSet<Productos> retorno = new TreeSet<>();

        // Registrar subtipos para deserialización
        mapper.registerSubtypes(new NamedType(Comida.class, "Comida"));
        mapper.registerSubtypes(new NamedType(Merch.class, "Merch"));

        try {
            File file = new File(archivo);
            retorno = mapper.readValue(file, TypeFactory.defaultInstance().constructCollectionType(TreeSet.class, Productos.class));
        } catch (IOException e) {
            System.out.println("Error al cargar el TreeSet desde el archivo: " + archivo);
            System.out.println("Mensaje de error: " + e.getMessage());
            e.printStackTrace();
        }

        return retorno;
    }

    public void guardarTreeSet(String archivo, TreeSet<Productos> treeSet) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            File file = new File(archivo);
            mapper.writeValue(file, treeSet);
        } catch (IOException e) {
            System.out.println("Error al guardar el TreeSet en el archivo: " + archivo);
            System.out.println("Mensaje de error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

