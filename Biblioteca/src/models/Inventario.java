package models;

import java.util.ArrayList;

public class Inventario {
    ArrayList <Libro> libros;
    ArrayList <Libro> librosPrestamos;

    public Inventario(ArrayList<Libro> libros, ArrayList<Libro> librosPrestamos) {
        this.libros = libros;
        this.librosPrestamos = librosPrestamos;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
}
