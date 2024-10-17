package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Serializable {

    private String patientName;
    private String procedure;
    private LocalDateTime dateTime;

    public Appointment(String patientName, String procedure, LocalDateTime dateTime) {
        this.patientName = patientName;
        this.procedure = procedure;
        this.dateTime = dateTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Cita [Paciente: " + patientName + ", Procedimiento: " + procedure + ", Fecha y hora: " + dateTime + "]";
    }
}
