package pe.edu.upc.DocSeekerTP.entities;

import java.util.Date;

public class Patient {
    private int id_Patient;
    private String name;
    private String lastName;
    private Date bithdate;
    private String address;
    private int userId;
    private String email;
    private String phoneNumber;
    private String DNI;

    public Patient(int id_Patient, String name, String lastName, Date bithdate, String address, int userId, String email, String phoneNumber, String DNI) {
        this.id_Patient = id_Patient;
        this.name = name;
        this.lastName = lastName;
        this.bithdate = bithdate;
        this.address = address;
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.DNI = DNI;
    }

    public int getId_Patient() {
        return id_Patient;
    }

    public void setId_Patient(int id_Patient) {
        this.id_Patient = id_Patient;
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

    public Date getBithdate() {
        return bithdate;
    }

    public void setBithdate(Date bithdate) {
        this.bithdate = bithdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
