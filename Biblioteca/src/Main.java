import models.Inventario;
import models.Libro;
import models.Usuario;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Libro> libroPrestamos = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Inventario inventario = new Inventario(libros, libroPrestamos);

        boolean login = true;

        do {
            menu();
            int eleccion = scan.nextInt();
            int eleccionAux;
            scan.nextLine();
            switch (eleccion) {
                case 1:
                    menuAdmin();
                    eleccionAux = scan.nextInt();
                    switch (eleccionAux){
                        case 1:
                            scan.nextLine();
                            System.out.println("Ingresa el titulo: ");
                            String titulo = scan.nextLine();

                            System.out.println("Ingresa la editorial: ");
                            String editorial = scan.nextLine();

                            System.out.println("Ingresa el autor: ");
                            String autor = scan.nextLine();

                            System.out.println("Libro creado");

                            Libro libro = new Libro(titulo, editorial, autor);
                            inventario.agregarLibro(libro);
                            break;
                        case 2:
                            imprimirLibros(libros);
                            break;
                        case 3:
                            scan.nextLine();
                            imprimirLibros(libros);

                            System.out.println("Ingresa el libro a prestar: ");
                            String libroBusqueda = scan.nextLine();
                            int indexAux = 0;
                            int borrarLibro = 0;
                            boolean libroFinded = false;
                            for (Libro libro1 : libros) {
                                if (libro1.getTitulo().equalsIgnoreCase(libroBusqueda)) {
                                    libroPrestamos.add(libros.get(indexAux));
                                    borrarLibro = indexAux;
                                    libroFinded = true;
                                }
                                indexAux++;
                            }
                            if (libroFinded){
                                System.out.println("Ingresa un nombre: ");
                                String nombre = scan.nextLine();

                                System.out.println("Ingrese su apellido: ");
                                String apellido = scan.nextLine();

                                System.out.println("Ingrese su domicilio");
                                String domicilio = scan.nextLine();

                                System.out.println("Ingrese su numero de telefono: ");
                                int telefono = scan.nextInt();
                                scan.nextLine();
                                Usuario usuario = new Usuario(nombre, apellido, domicilio, telefono);
                                usuarios.add(usuario);
                                System.out.println("Libro agregado a prestamo");
                                libros.remove(borrarLibro);
                            } else {
                                System.out.println("Libro no encontrado");
                            }
                            break;
                        case 4:
                            scan.nextLine();
                            System.out.println("Ingresa el libro a devolver: ");
                            String libroDevolver = scan.nextLine();
                            int iAux = 0;
                            int borrarLibro1 = 0;
                            boolean libroFinded1 = false;
                            for (Libro libro1 : libroPrestamos) {
                                if (libro1.getTitulo().equalsIgnoreCase(libroDevolver)) {
                                    libros.add(libroPrestamos.get(iAux));
                                    borrarLibro1 = iAux;
                                    libroFinded1 = true;
                                }
                                iAux++;
                            }
                            if (libroFinded1){
                                System.out.println("Libro devuelto");
                                libroPrestamos.remove(borrarLibro1);
                                usuarios.remove(borrarLibro1);
                            } else {
                                System.out.println("Libro no encontrado");
                            }
                            break;
                        case 5:
                            imprimirPrestamos(libroPrestamos, usuarios);
                            break;
                        case 6:
                            break;

                    }
                    break;
                case 2:
                    menuUser();
                    eleccionAux = scan.nextInt();
                    switch (eleccionAux) {
                        case 1:
                            imprimirLibros(libros);
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 3:
                    login = false;
                    break;

            }
        } while (login);
    }
    public static void menu() {
        System.out.println("----Inicia sesión----");
        System.out.println("Quién inicia sesión? ");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
        System.out.println("3. Salir");
    }

    public static void menuAdmin() {
        System.out.println("-----Bienvenido-----");
        System.out.println("----Menú----");
        System.out.println("1. Alta Libro");
        System.out.println("2. Imprimir Libros");
        System.out.println("3. Generar Prestamo");
        System.out.println("4. Devolver Libro");
        System.out.println("5. Imprimir prestamos");
        System.out.println("6. salir");
    }

    public static void menuUser() {
        System.out.println("----Menú----");
        System.out.println("1. Imprimir libros");
        System.out.println("2. Salir");
    }

    public static void imprimirLibros(ArrayList <Libro> libros){
        if (libros.isEmpty()){
            System.out.println("No hay libros");
        } else {
            System.out.println("-----Libros-----");
            System.out.println("-----Titulo//Autor//Editorial----");
            for (Libro libro:libros){
                System.out.println(libro);
            }
        }
    }
    public static void imprimirPrestamos(ArrayList<Libro> librosPrestamos,ArrayList<Usuario> usuarios){
        if (librosPrestamos.isEmpty()){
            System.out.println("No hay prestamos pendientes");
        }else {
            int indexAux = 0;
            for (Libro presto: librosPrestamos) {
                System.out.println("Prestamo "+ "[ " + usuarios.get(indexAux).toString() + "||" + presto + " ]");
                indexAux++;
            }
        }
    }

}