package model;

import java.io.Serializable;

public class Employee implements Serializable {
    public static int MAX_ID;

    private  int id;
    private String name;
    private String type;

    public Employee(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Empleado [Clave: " + id + ", Nombre: " + name + "," + "Especialidad: " + type + "]";
    }
}
