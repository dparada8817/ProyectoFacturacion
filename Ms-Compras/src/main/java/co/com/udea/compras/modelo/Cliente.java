package co.com.udea.compras.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cliente {
    @Id
    private String dni;
    private String nombre;
    private String direccion;

    public Cliente() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
