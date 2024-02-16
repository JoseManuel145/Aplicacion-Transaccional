package models;
import java.util.List;
public class Bibliotecario {
    private Inventario inventario;
    private List<Prestamo> prestamos;

    public Bibliotecario(Inventario inventario, List<Prestamo> prestamos) {
        this.inventario = inventario;
    }

    public void altaLibro(String titulo, String autor, String editorial) {
        Libro libro = new Libro(titulo, autor, editorial);
        inventario.agregarLibro(libro);
    }

    public void registrarPrestamo(Libro libro, Usuario usuario) {
        Prestamo prestamo = new Prestamo(libro, usuario);
    }

    public void registrarDevolucion(Prestamo prestamo) {
        prestamo.registrarDevolucion();
    }
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public List<Libro> getLibros() {
        return inventario.getLibros();
    }
}
