package pe.edu.upc.DocSeekerTP.entities;

import java.util.Date;

public class Doctor_Time {
    private int id_time;
    private int Doctor_id_doctor;
    private Date day;
    private String startTime;
    private String endTime;

    public Doctor_Time(int id_time, int doctor_id_doctor, Date day, String startTime, String endTime) {
        this.id_time = id_time;
        Doctor_id_doctor = doctor_id_doctor;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public int getDoctor_id_doctor() {
        return Doctor_id_doctor;
    }

    public void setDoctor_id_doctor(int doctor_id_doctor) {
        Doctor_id_doctor = doctor_id_doctor;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
