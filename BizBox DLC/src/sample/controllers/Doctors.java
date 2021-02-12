package sample.controllers;

public class Doctors {
    private String ID;
    private String Name;


    public Doctors(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
