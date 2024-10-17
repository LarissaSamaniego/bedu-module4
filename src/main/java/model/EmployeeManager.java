package model;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import utils.Lector;
import utils.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    public static List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        if(employees.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (int i = 0; i < employees.size(); i++){
                System.out.println(i + ": " + employees.get(i));
            }
        }
    }

    public void createNewEmployee() {
        String name = Lector.readEntry("Ingresa el nombre del empleado: ");
        String type = Lector.readEntry("Ingresa la especialidad del empleado (DERMATOLOGO/COSMETOLOGO): ");

        switch (type.toUpperCase()) {
            case "DERMATOLOGO":
                addEmployee(new Dermatologist(name, Employee.MAX_ID++));
                break;
            case "COSMETOLOGO":
                addEmployee(new Cosmetologist(name, Employee.MAX_ID++));
                break;
            default:
                addEmployee(new Employee(Employee.MAX_ID++, name, type.toUpperCase()));
                break;
        }

    }

    public void deleteEmployee() {
        if (employees != null){
          if(!employees.isEmpty()){
              String nameToRemove = Lector.readEntry("Ingresa el nombre del empleado que deseas eliminar: ");
              if(employees.removeIf(e -> e.getName().equals(nameToRemove))) { System.out.printf("Se eliminó a %s de la lista.\n", nameToRemove);}
          }
        } else {
            System.out.println("No hay empleados registrados.");
        }
    }

    public void printEmployees() {
        System.out.println("Guardando archivo...");
        try {
            Util.saveEmployees(employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadInformation() {
        try {
           employees = Util.employeesLoad();
           Employee.MAX_ID = employees.size();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
