import java.util.LinkedHashSet;

public class SectorComida extends  Sectores implements Gestorable<Productos> {

    LinkedHashSet <Productos> menu = new LinkedHashSet<>();

    public LinkedHashSet<Productos> getMenu() {
        return menu;
    }

    public void setMenu(LinkedHashSet<Productos> menu) {
        this.menu = menu;
    }

    public SectorComida(int capacidad, LinkedHashSet<Productos> menu) {
        super(capacidad);
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "SectorComida{" +
                "menu=" + menu +
                '}';
    }

    @Override
    public void agregar(Productos producto) {
        menu.add(producto);
    }

    @Override
    public void eliminar(Productos producto) {
        menu.remove(producto);
    }

    @Override
    public Productos buscar(Productos producto) {
        for (Productos p : menu) {
            if (p.equals(producto)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void mostrar() {
        for (Productos producto : menu) {
            System.out.println(producto);
        }
    }

    @Override
    public void modificar(Productos producto) {
        if (menu.contains(producto)) {
            menu.remove(producto);
            menu.add(producto);
        }
    }
}