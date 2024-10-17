package model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import utils.Lector;
import utils.Util;

public class AppointmentManager {

    private List<Appointment> appointments;

    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    }

    public void  addAppointment(String patientName, String procedure, LocalDateTime dateTime) {
        appointments.add(new Appointment(patientName, procedure, dateTime));
    }

    public boolean removeAppointment(int index) {
        if(index < 0 || index >= appointments.size()) {
            return false;
        }
        appointments.remove(index);
        return true;
    }

    public void displayAppointments() {
        if(appointments.isEmpty()) {
            System.out.println("No hay citas agendadas.");
        } else {
            for (int i = 0; i < appointments.size(); i++){
                System.out.println(i + ": " + appointments.get(i));
            }
        }
    }

    public void createNewAppointment() {

        String patientName = Lector.readEntry("Ingresa el nombre del paciente: ");
        String procedure = Lector.readEntry("Ingresa el procedimiento: ");

        boolean valid = false;
        LocalDateTime dateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (!valid) {
            try {
                String date = Lector.readEntry("Ingresa la fecha (dd/MM/yyyy): ");
                String time = Lector.readEntry("Ingresa la hora (HH:mm): ");

                dateTime = LocalDateTime.parse(date + " " + time, formatter);

                if(dateTime.isAfter(LocalDateTime.now())) {
                    valid = true;
                } else {
                    System.out.println("La fecha hora del registro debe ser posterior a la actual. Inténtalo de nuevo.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Fecha u hora no válidas. Inténtalo de nuevo.");
            }
        }

        addAppointment(patientName, procedure, dateTime);
    }

    public void printAppointments() {
        System.out.println("Guardando archivo...");
        try {
            Util.saveAppointments(appointments);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadInformation() {
        try {
            appointments = Util.appointmentsLoad();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
