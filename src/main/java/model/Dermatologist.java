package model;

public class Dermatologist extends Employee{


    public Dermatologist(String name, int id) {
        super(id, name, "DERMATOLOGO");
    }

    @Override
    public String toString() {
        return "Dermatólogo: " + super.getName() + "(ID: " + super.getId() + ")";
    }
}
