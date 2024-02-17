package models;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;

    public Libro(String titulo, String editorial, String autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Libro: " +
                 titulo + "-" +
                 autor + "-" +
                 editorial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
