package pe.edu.upc.DocSeekerTP.entities;

public class PatientXIllness {
    private int id;
    private String Patient_Id_Patient;
    private String bloodType;
    private String privateMedicine;
    private int chronicIllnesses_id_Illness;

    public PatientXIllness(int id, String patient_Id_Patient, String bloodType, String privateMedicine, int chronicIllnesses_id_Illness) {
        this.id = id;
        Patient_Id_Patient = patient_Id_Patient;
        this.bloodType = bloodType;
        this.privateMedicine = privateMedicine;
        this.chronicIllnesses_id_Illness = chronicIllnesses_id_Illness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_Id_Patient() {
        return Patient_Id_Patient;
    }

    public void setPatient_Id_Patient(String patient_Id_Patient) {
        Patient_Id_Patient = patient_Id_Patient;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPrivateMedicine() {
        return privateMedicine;
    }

    public void setPrivateMedicine(String privateMedicine) {
        this.privateMedicine = privateMedicine;
    }

    public int getChronicIllnesses_id_Illness() {
        return chronicIllnesses_id_Illness;
    }

    public void setChronicIllnesses_id_Illness(int chronicIllnesses_id_Illness) {
        this.chronicIllnesses_id_Illness = chronicIllnesses_id_Illness;
    }
}
