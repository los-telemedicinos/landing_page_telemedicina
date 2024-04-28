package pe.edu.upc.DocSeekerTP.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Medicines {
    private int id_Medicines;
    private String name_Medicines;

    public Medicines() {}

    public Medicines(int id_Medicines, String name_Medicines) {
        this.id_Medicines = id_Medicines;
        this.name_Medicines = name_Medicines;
    }

}
