import models.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        List<Prestamo> prestamos = new ArrayList<>();

        Bibliotecario bibliotecario = new Bibliotecario(inventario, prestamos);
        Scanner scanner = new Scanner(System.in);

        boolean ejecucion = true;
        while (ejecucion) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    altaLibro(bibliotecario, scanner);
                    break;
                case 2:
                    registrarPrestamo(scanner, inventario, bibliotecario);
                    break;
                case 3:
                    registrarDevolucion(scanner, inventario, bibliotecario);
                    break;
                case 4:
                    mostrarLibros(inventario);
                    break;
                case 5:
                    ejecucion = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Alta de libro");
        System.out.println("2. Registrar préstamo");
        System.out.println("3. Registrar devolución");
        System.out.println("4. Mostrar libros disponibles");
        System.out.println("5. Salir");
        System.out.println("Elige una opción:");
    }

    public static void altaLibro(Bibliotecario bibliotecario, Scanner scanner) {
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        System.out.println("Ingrese la editorial del libro:");
        String editorial = scanner.nextLine();

        bibliotecario.altaLibro(titulo, autor, editorial);
        System.out.println("Libro agregado correctamente.");
    }

    public static void mostrarLibros(Inventario inventario) {
        System.out.println("Libros disponibles:");
        for (Libro libro : inventario.getLibros()) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getEditorial());
        }
    }

    public static void registrarPrestamo(Scanner scanner, Inventario inventario, Bibliotecario bibliotecario) {
        if (inventario.getLibros().isEmpty()) {
            System.out.println("No hay libros disponibles para préstamo.");
        } else {
            System.out.println("Ingrese el título del libro a prestar:");
            String tituloPrestamo = scanner.nextLine();
            boolean encontrado = false;
            for (Libro libro : inventario.getLibros()) {
                if (libro.getTitulo().equalsIgnoreCase(tituloPrestamo)) {
                    encontrado = true;
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingrese el apellido del usuario:");
                    String apellidoUsuario = scanner.nextLine();
                    System.out.println("Ingrese la dirección del usuario:");
                    String direccionUsuario = scanner.nextLine();

                    Usuario usuario = new Usuario(nombreUsuario, apellidoUsuario, direccionUsuario);

                    bibliotecario.registrarPrestamo(libro, usuario);
                    System.out.println("Préstamo registrado correctamente.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("El libro no se encuentra en el inventario.");
            }
        }
    }
    public static void registrarDevolucion(Scanner scanner, Inventario inventario, Bibliotecario bibliotecario) {
        if (bibliotecario.getPrestamos().isEmpty()) {
            System.out.println("No hay libros prestados para devolver.");
        } else {
            System.out.println("Ingrese el título del libro a devolver:");
            String tituloDevolucion = scanner.nextLine();
            boolean encontrado = false;
            for (Prestamo prestamo : bibliotecario.getPrestamos()) {
                if (prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloDevolucion)) {
                    encontrado = true;
                    bibliotecario.registrarDevolucion(prestamo);
                    System.out.println("Devolución registrada correctamente.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún préstamo para el libro especificado.");
            }
        }
    }
}
