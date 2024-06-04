import java.util.TreeMap;


public class SectorMerch extends Sectores implements Gestorable <Productos> {
    private TreeMap<Double,Productos> arbol=new TreeMap<>();

    public TreeMap<Double, Productos> getArbol() {
        return arbol;
    }

    public void setArbol(TreeMap<Double, Productos> arbol) {
        this.arbol = arbol;
    }

    public SectorMerch(int capacidad, TreeMap<Double, Productos> arbol) {
        super(capacidad);
        this.arbol = arbol;
    }

    @Override
    public String toString() {
        return "SectorMerch{" +
                "arbol=" + arbol +
                '}';
    }

    @Override
    public void agregar(Productos producto) {
        arbol.put(producto.getPrecio(), producto);
    }

    @Override
    public void eliminar(Productos producto) {
        arbol.remove(producto.getPrecio());
    }

    @Override
    public Productos buscar(Productos producto) {
        return arbol.get(producto.getPrecio());
    }

    @Override
    public void mostrar() {
        for (Productos producto : arbol.values()) {
            System.out.println(producto);
        }
    }

    @Override
    public void modificar(Productos producto) {
        if (arbol.containsKey(producto.getPrecio())) {
            arbol.put(producto.getPrecio(), producto);
        }
    }
}



