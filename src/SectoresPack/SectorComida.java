package SectoresPack;

import Interfaces.Gestorable;
import ProductosPack.Comida;
import ProductosPack.Productos;
import java.util.LinkedHashSet;
import java.util.Scanner;

import Excepciones.CapacidadExcedidaExcepcion;
import Excepciones.ProductoNoDisponibleExepcion;

public class SectorComida extends Sectores implements Gestorable<Comida> {

    LinkedHashSet<Comida> menu = new LinkedHashSet<>();

    public LinkedHashSet<Comida> getMenu() {
        return menu;
    }

    public void setMenu(LinkedHashSet<Comida> menu) {
        this.menu = menu;
    }

    public SectorComida(int capacidad, LinkedHashSet<Comida> menu) {
        super(capacidad);
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "SectoresPack.SectorComida{" +
                "menu=" + menu +
                '}';
    }

    @Override
    public void agregar(Comida producto) {

        try {
            int cantidad = menu.size();
            cantidad++;
            if (cantidad <= capacidad) {
                menu.add(producto);
            } else {
                throw new CapacidadExcedidaExcepcion("Capacidad maxima alcanzada");
            }
        } catch (CapacidadExcedidaExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(Comida producto) {
        try {
            if (menu.contains(producto)) {
                menu.remove(producto);
            } else {
                throw new ProductoNoDisponibleExepcion("El producto no existe");
            }
        } catch (ProductoNoDisponibleExepcion e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Comida buscar(Comida producto) {
        Comida retorno = null;
        try {
            if (menu.contains(producto)) {
                for (Comida p : menu) {
                    if (p.equals(producto)) {
                        retorno = p;
                    }
                }
            } else {
                throw new ProductoNoDisponibleExepcion("El producto no se encuentra en el menu");
            }
        } catch (ProductoNoDisponibleExepcion e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }


    @Override
    public void mostrar() {
        for (Productos producto : menu) {
            System.out.println(producto);
        }
    }

    @Override
    public void modificar(Comida producto) {
        if (menu.contains(producto)) {
            for (Comida c : menu) {
                if (c.equals(producto)) {
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
                            c.setNombre(sc1.nextLine());
                            sc1.close();

                        case 2:
                            Scanner sc2 = new Scanner(System.in);
                            System.out.println("Ingrese el nuevo precio");
                            c.setPrecio(sc2.nextDouble());
                            sc2.close();

                        case 3:
                            Scanner sc3 = new Scanner(System.in);
                            System.out.println("Ingrese el nuevo stock");
                            c.setStock(sc3.nextInt());
                            sc3.close();

                        case 4:
                            Scanner sc4 = new Scanner(System.in);
                            System.out.println("Ingrese el nuevo tipo");
                            c.setTipo(sc4.nextLine());
                            sc4.close();

                    }
                }
            }
        }
    }
}