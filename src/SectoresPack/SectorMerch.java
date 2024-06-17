package SectoresPack;

import Excepciones.ProductoNoDisponibleExepcion;
import ProductosPack.Merch;
import ProductosPack.Productos;
import Interfaces.Gestorable;

import java.util.Scanner;
import java.util.TreeMap;


public class SectorMerch extends GestorProductos implements Gestorable<Merch> {
    private TreeMap<Integer, Merch> arbol;

    public TreeMap<Integer, Merch> getArbol() {
        return arbol;
    }

    public void setArbol(TreeMap<Integer, Merch> arbol) {
        this.arbol = arbol;
    }

    public SectorMerch(int capacidad, TreeMap<Integer, Merch> arbol) {
        super(capacidad);
        this.arbol = arbol;
    }

    @Override
    public String toString() {
        return "SectoresPack.SectorMerch{" +
                "arbol=" + arbol +
                '}';
    }


    @Override
    public void agregar(Merch item) {
        arbol.put(item.getCodigo(), item);
    }

    @Override
    public void eliminar(Merch item) {
       Merch eliminado=buscar(item);
       if(eliminado!=null){
arbol.remove(eliminado.getCodigo());
       }
    }

    @Override
    public Merch buscar(Merch item) {
        Merch retorno=null;
        for (Merch aux : arbol.values()) {
            if (aux.equals(item)) {
                retorno=aux;
            }
        }
    try {
        if (retorno==null) {
            throw new ProductoNoDisponibleExepcion("Producto No Encontrado");
        }
    } catch (ProductoNoDisponibleExepcion e) {
        System.out.println(e.getMessage());
    }
        return retorno;
    }

        @Override
        public void mostrar () {
            for (Productos producto : arbol.values()) {
                System.out.println(producto);
            }
        }

        @Override
        public void modificar (Merch item){
                if (arbol.containsValue(item)) {
                    for (Merch m : arbol.values()) {
                        if (m.equals(item)) {
                            int value = 0;
                            Scanner sc = new Scanner(System.in);
                            System.out.println("Si desea mmodificar el nombre del producto oprima 1");
                            System.out.println("Si desea modificiar el precio oprima 2");
                            System.out.println("Si desea modificiar el stock oprima 3");
                            System.out.println("Si desea modificar el tipo oprima 4");
                            value = sc.nextInt();
                            sc.close();

                            switch (value) {

                                case 1:
                                    Scanner sc1 = new Scanner(System.in);
                                    System.out.println("Ingrese el nuevo nombre");
                                    m.setNombre(sc1.nextLine());
                                    sc1.close();

                                case 2:
                                    Scanner sc2 = new Scanner(System.in);
                                    System.out.println("Ingrese el nuevo precio");
                                    m.setPrecio(sc2.nextDouble());
                                    sc2.close();

                                case 3:
                                    Scanner sc3 = new Scanner(System.in);
                                    System.out.println("Ingrese el nuevo stock");
                                    m.setStock(sc3.nextInt());
                                    sc3.close();
                                default:break;

                            }
                        }
                    }
                }
            }
        }







