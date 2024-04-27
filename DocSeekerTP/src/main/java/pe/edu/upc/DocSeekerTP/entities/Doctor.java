package pe.edu.upc.DocSeekerTP.entities;

public class Doctor {
    private int id_Doctor;
    private String name;
    private String lastName;
    private String speciality;
    private String hospital;
    private String doctorDetails;
    private int user_Id;
    private String email;
    private String dni;
    private int tuitionNumber;

    public Doctor(int id_Doctor, String name, String lastName, String speciality, String hospital, String doctorDetails, int user_Id, String email, String dni, int tuitionNumber) {
        this.id_Doctor = id_Doctor;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
        this.hospital = hospital;
        this.doctorDetails = doctorDetails;
        this.user_Id = user_Id;
        this.email = email;
        this.dni = dni;
        this.tuitionNumber = tuitionNumber;
    }

    public int getId_Doctor() {
        return id_Doctor;
    }

    public void setId_Doctor(int id_Doctor) {
        this.id_Doctor = id_Doctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(String doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTuitionNumber() {
        return tuitionNumber;
    }

    public void setTuitionNumber(int tuitionNumber) {
        this.tuitionNumber = tuitionNumber;
    }
}
