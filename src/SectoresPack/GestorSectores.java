package SectoresPack;

import ProductosPack.*;
import java.util.ArrayList;
import java.util.List;
import Excepciones.*;

public class GestorSectores<T extends Sectores> {

    private List<T> sectoresComida;
    private List<T> sectoresMerch;

    public GestorSectores() {
        this.sectoresComida = new ArrayList<T>();
        this.sectoresMerch = new ArrayList<T>();
    }

    public void agregarSector(T s) {
        try {
            if (s instanceof SectorComida) {
                if (!sectoresComida.contains(s)) {
                    sectoresComida.add(s);
                }
            } else if (s instanceof SectorMerch) {
                if (!sectoresMerch.contains(s)) {
                    sectoresMerch.add(s);
                }
            } else {
                throw new TipoDeSectorNoValidoExcepcion("El tipo de sector no existe");
            }
        } catch (TipoDeSectorNoValidoExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarSectores() {
        System.out.println("Sectores de comida disponibles");
        for (T s : sectoresComida) {
            System.out.println(s);
        }

        System.out.println("Sectpres de Merchandising disponibles");
        for (T s : sectoresMerch) {
            System.out.println(s);
        }
    }

    public double calcularVentasSectores() {
        double ingreso = 0;
        for (T s : sectoresMerch) {
            for (Merch m : ((SectorMerch) s).getArbol().values()) {
                ingreso = ingreso + m.getPrecio();
            }

        }

        for (T c : sectoresComida) {
            for (Comida a : ((SectorComida) c).getMenu()) {
                ingreso = ingreso + a.getPrecio();
            }
        }

        return ingreso;
    }

}
