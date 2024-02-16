package models;
import java.time.LocalDate;
public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
    }

    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
    }

    public Libro getLibro() {
        return libro;
    }
}
