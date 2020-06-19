package edu.andrew.kursach.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class HistoryOfDiseases {
    @Id
    private String idOfHistoryOfDiseases;
    @NotBlank(message = "Please fill the field")
    private Diseases disease;
    @NotBlank(message = "Please fill the field")
    private Patient patient;
    @NotBlank(message = "Please fill the field")
    private Doctor doctor;
    @NotBlank(message = "Please fill the field")
    private String beginOfDesease;
    @NotBlank(message = "Please fill the field")
    private String endOfDisease;
    @NotBlank(message = "Please fill the field")
    private String status;
    @NotBlank(message = "Please fill the field")
    private double spendedMoneyOnDesease;
    @NotBlank(message = "Please fill the field")
    private PatientSpendingCard spendingCard;

    public HistoryOfDiseases() {
    }

    public HistoryOfDiseases(String idOfHistoryOfDiseases, Diseases disease, Patient patient, Doctor doctor, String beginOfDesease, String endOfDisease, String status, double spendedMoneyOnDesease, PatientSpendingCard spendingCard) {
        this.idOfHistoryOfDiseases = idOfHistoryOfDiseases;
        this.disease = disease;
        this.patient = patient;
        this.doctor = doctor;
        this.beginOfDesease = beginOfDesease;
        this.endOfDisease = endOfDisease;
        this.status = status;
        this.spendedMoneyOnDesease = spendedMoneyOnDesease;
        this.spendingCard = spendingCard;
    }

    public HistoryOfDiseases(Diseases disease, Patient patient, Doctor doctor, String beginOfDesease, String endOfDisease, String status, double spendedMoneyOnDesease, PatientSpendingCard spendingCard) {
        this.disease = disease;
        this.patient = patient;
        this.doctor = doctor;
        this.beginOfDesease = beginOfDesease;
        this.endOfDisease = endOfDisease;
        this.status = status;
        this.spendedMoneyOnDesease = spendedMoneyOnDesease;
        this.spendingCard = spendingCard;
    }

    public String getIdOfHistoryOfDiseases() {
        return idOfHistoryOfDiseases;
    }

    public void setIdOfHistoryOfDiseases(String idOfHistoryOfDiseases) {
        this.idOfHistoryOfDiseases = idOfHistoryOfDiseases;
    }

    public Diseases getDisease() {
        return disease;
    }

    public void setDisease(Diseases disease) {
        this.disease = disease;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getBeginOfDesease() {
        return beginOfDesease;
    }

    public void setBeginOfDesease(String beginOfDesease) {
        this.beginOfDesease = beginOfDesease;
    }

    public String getEndOfDisease() {
        return endOfDisease;
    }

    public void setEndOfDisease(String endOfDisease) {
        this.endOfDisease = endOfDisease;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSpendedMoneyOnDesease() {
        return spendedMoneyOnDesease;
    }

    public void setSpendedMoneyOnDesease(double spendedMoneyOnDesease) {
        this.spendedMoneyOnDesease = spendedMoneyOnDesease;
    }

    public PatientSpendingCard getSpendingCard() {
        return spendingCard;
    }

    public void setSpendingCard(PatientSpendingCard spendingCard) {
        this.spendingCard = spendingCard;
    }

    @Override
    public String toString() {
        return "HistoryOfDiseases{" +
                "idOfHistoryOfDiseases='" + idOfHistoryOfDiseases + '\'' +
                ", disease=" + disease +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", beginOfDesease='" + beginOfDesease + '\'' +
                ", endOfDisease='" + endOfDisease + '\'' +
                ", status='" + status + '\'' +
                ", spendedMoneyOnDesease=" + spendedMoneyOnDesease +
                ", spendingCard=" + spendingCard +
                '}';
    }

}
