package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Doctor {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private String FIO;
    @NotBlank(message = "Please fill the field")
    private String  speciality;
    @NotBlank(message = "Please fill the field")
    private String adress;
    @NotBlank(message = "Please fill the field")
    private String phoneNumber;
    @NotBlank(message = "Please fill the field")
    private int costPerSession;

    public Doctor() {
    }

    public Doctor(String FIO, String speciality, String adress, String phoneNumber, int costPerSession) {
        this.FIO = FIO;
        this.speciality = speciality;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.costPerSession = costPerSession;
    }

    public Doctor(String id, String FIO, String speciality, String adress, String phoneNumber, int costPerSession) {
        this.id = id;
        this.FIO = FIO;
        this.speciality = speciality;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.costPerSession = costPerSession;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCostPerSession() {
        return costPerSession;
    }

    public void setCostPerSession(int costPerSession) {
        this.costPerSession = costPerSession;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", FIO='" + FIO + '\'' +
                ", speciality='" + speciality + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", costPerSession=" + costPerSession +
                '}';
    }
}
