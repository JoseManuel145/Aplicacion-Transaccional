package models;
import java.util.ArrayList;
public class Usuario {
    private String nombre;
    private String apellido;
    private String domicilio;
    private int telefono;
    ArrayList <Usuario> usuarios;

    public Usuario(String nombre, String apellido, String domicilio, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario: "  + nombre + "-" +
                apellido + "-" +
                domicilio + "-" +
                telefono ;
    }
}