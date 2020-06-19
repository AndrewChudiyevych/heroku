package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Document
public class Archive {
    @Id
    private String idOfHistoryOfDisease;
    @NotBlank(message = "Please fill the field")
    private String beginningOfTreatment;
    @NotBlank(message = "Please fill the field")
    private String endOfTreatment;
    @NotBlank(message = "Please fill the field")
    private Doctor doctor;
    @NotBlank(message = "Please fill the field")
    private Patient patient;
    @NotBlank(message = "Please fill the field")
    private Diseases disease;

    public Archive() {
    }

    public Archive(String idOfHistoryOfDisease, String beginningOfTreatment, String endOfTreatment, Doctor doctor, Patient patient, Diseases disease) {
        this.idOfHistoryOfDisease = idOfHistoryOfDisease;
        this.beginningOfTreatment = beginningOfTreatment;
        this.endOfTreatment = endOfTreatment;
        this.doctor = doctor;
        this.patient = patient;
        this.disease = disease;
    }

    public Archive(String beginningOfTreatment, String endOfTreatment, Doctor doctor, Patient patient, Diseases disease) {
        this.beginningOfTreatment = beginningOfTreatment;
        this.endOfTreatment = endOfTreatment;
        this.doctor = doctor;
        this.patient = patient;
        this.disease = disease;
    }

    public String getIdOfHistoryOfDisease() {
        return idOfHistoryOfDisease;
    }

    public void setIdOfHistoryOfDisease(String idOfHistoryOfDisease) {
        this.idOfHistoryOfDisease = idOfHistoryOfDisease;
    }

    public String getBeginningOfTreatment() {
        return beginningOfTreatment;
    }

    public void setBeginningOfTreatment(String beginningOfTreatment) {
        this.beginningOfTreatment = beginningOfTreatment;
    }

    public String getEndOfTreatment() {
        return endOfTreatment;
    }

    public void setEndOfTreatment(String endOfTreatment) {
        this.endOfTreatment = endOfTreatment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Diseases getDisease() {
        return disease;
    }

    public void setDisease(Diseases disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Archive{" +
                "idOfHistoryOfDisease='" + idOfHistoryOfDisease + '\'' +
                ", beginningOfTreatment='" + beginningOfTreatment + '\'' +
                ", endOfTreatment='" + endOfTreatment + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", disease=" + disease +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archive archive = (Archive) o;
        return getIdOfHistoryOfDisease().equals(archive.getIdOfHistoryOfDisease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdOfHistoryOfDisease());
    }
}
