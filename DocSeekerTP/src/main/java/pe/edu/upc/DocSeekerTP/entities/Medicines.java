package pe.edu.upc.DocSeekerTP.entities;

public class Medicines {
    private int id_Medicines;
    private String name_Medicines;

    public Medicines(int id_Medicines, String name_Medicines) {
        this.id_Medicines = id_Medicines;
        this.name_Medicines = name_Medicines;
    }

    public int getId_Medicines() {
        return id_Medicines;
    }

    public void setId_Medicines(int id_Medicines) {
        this.id_Medicines = id_Medicines;
    }

    public String getName_Medicines() {
        return name_Medicines;
    }

    public void setName_Medicines(String name_Medicines) {
        this.name_Medicines = name_Medicines;
    }
}
