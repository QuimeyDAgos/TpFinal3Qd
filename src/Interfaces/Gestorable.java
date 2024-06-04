package Interfaces;

public interface Gestorable <T> {
    void agregar(T item);
    void eliminar(T item);
    T buscar(T item);
    void mostrar();
    void modificar(T item);
}
