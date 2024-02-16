package models;
import java.util.ArrayList;
public class Inventario {
    private ArrayList<Libro> libros;

    public Inventario() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

}
