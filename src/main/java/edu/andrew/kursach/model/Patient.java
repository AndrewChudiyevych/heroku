package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Document
public class Patient {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private int medicalHistoryNumber;
    @NotBlank(message = "Please fill the field")
    private String FIO;
    @NotBlank(message = "Please fill the field")
    private String adress;
    @NotBlank(message = "Please fill the field")
    private String phoneNumber;

    public Patient() {
    }

    public Patient(String id, int medicalHistoryNumber, String FIO, String adress, String phoneNumber) {
        this.id = id;
        this.medicalHistoryNumber = medicalHistoryNumber;
        this.FIO = FIO;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMedicalHistoryNumber() {
        return medicalHistoryNumber;
    }

    public void setMedicalHistoryNumber(int medicalHistoryNumber) {
        this.medicalHistoryNumber = medicalHistoryNumber;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
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

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", medicalHistoryNumber=" + medicalHistoryNumber +
                ", FIO='" + FIO + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return getId().equals(patient.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
