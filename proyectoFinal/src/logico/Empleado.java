package logico;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Empleado extends Usuario implements Serializable {

    private static final long serialVersionUID = 284827374366588579L;

    private float salario;
    private boolean manager;
    private String password; // Marcar como transient si no se debe serializar

    public Empleado(String id, String nombre, String email, String numero, String direccion, String password, float salario, boolean manager) {
        super(id, nombre, email, numero, direccion);
        this.password = password;
        this.manager = manager;
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    // Getter and setter for 'password' (if needed), marked transient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Implementación de métodos personalizados para la serialización
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Serializa todos los campos excepto los marcados como transient
        // Puedes agregar código adicional aquí para personalizar la serialización
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Lee todos los campos serializados automáticamente
        // Puedes agregar código adicional aquí para personalizar la deserialización
    }
}

