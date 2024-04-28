package pe.edu.upc.DocSeekerTP.entities;

public class Specialities {
    private int id_speciality;
    private String speciality_name;

    public Specialities(int id_speciality, String speciality_name) {
        this.id_speciality = id_speciality;
        this.speciality_name = speciality_name;
    }
    public Specialities() {}

    public int getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(int id_speciality) {
        this.id_speciality = id_speciality;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }

    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }
}
