package pe.edu.upc.DocSeekerTP.entities;

public class Prescription {
    private int id;
    private String medicine;
    private String details;

    public Prescription(int id, String medicine, String details) {
        this.id = id;
        this.medicine = medicine;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
