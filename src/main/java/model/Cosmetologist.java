package model;

public class Cosmetologist extends Employee{

    public Cosmetologist(String name, int id) {
        super(id, name, "COSMETOLOGO");
    }

    @Override
    public String toString() {
        return "Cosmetólogo: " + super.getName() + "(ID: " + super.getId() + ")";
    }
}
