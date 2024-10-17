package utils;


import model.Appointment;
import model.Employee;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Util {
    private static final String FILE_NAME = System.getProperty("user.home") + "/history";
    private static final String FILE_NAME_EMPLOYEES = System.getProperty("user.home") + "/Empleados";
    private static final String FILE_NAME_APPOINTMENT = System.getProperty("user.home") + "/Citas";

    public static void saveEmployees(List<Employee> employees) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(FILE_NAME_EMPLOYEES)));
        oos.writeObject(employees);
        System.out.printf("Se guardaron %d empleados\n", employees.size());
    }

    public static List<Employee> employeesLoad() throws IOException, ClassNotFoundException { // throws Exception
        List<Employee> history = new ArrayList<>();
        if (new File(FILE_NAME_EMPLOYEES).exists()) {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(FILE_NAME_EMPLOYEES)));
            history = (List<Employee>) ois.readObject();
        }
        return history;
    }

    public static void saveAppointments(List<Appointment> appointments) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(FILE_NAME_APPOINTMENT)));
        oos.writeObject(appointments);
        System.out.printf("Se guardaron %d citas\n", appointments.size());
    }

    public static List<Appointment> appointmentsLoad() throws IOException, ClassNotFoundException {
        List<Appointment> history = new ArrayList<>();
        if (new File(FILE_NAME_APPOINTMENT).exists()) {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(FILE_NAME_APPOINTMENT)));
            history = (List<Appointment>) ois.readObject();
        }
        return history;
    }

}
