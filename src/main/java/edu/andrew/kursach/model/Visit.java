package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Visit {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private Patient patient;
    @NotBlank(message = "Please fill the field")
    private Doctor doctor;
    @NotBlank(message = "Please fill the field")
    private String firstOrSecondVisit;
    @NotBlank(message = "Please fill the field")
    private String anamnez;
    @NotBlank(message = "Please fill the field")
    private String diagnoz;
    @NotBlank(message = "Please fill the field")
    private String treatment;
    @NotBlank(message = "Please fill the field")
    private double costOfSpendedMedicine;
    @NotBlank(message = "Please fill the field")
    private double costOfSpendedMaterials;
    @NotBlank(message = "Please fill the field")
    private int costOfServices;

    public Visit() {
    }

    public Visit(String id, Patient patient, Doctor doctor, String firstOrSecondVisit, String anamnez, String diagnoz, String treatment, double costOfSpendedMedicine, double costOfSpendedMaterials, int costOfServices) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.firstOrSecondVisit = firstOrSecondVisit;
        this.anamnez = anamnez;
        this.diagnoz = diagnoz;
        this.treatment = treatment;
        this.costOfSpendedMedicine = costOfSpendedMedicine;
        this.costOfSpendedMaterials = costOfSpendedMaterials;
        this.costOfServices = costOfServices;
    }

    public Visit(Patient patient, Doctor doctor, String firstOrSecondVisit, String anamnez, String diagnoz, String treatment, double costOfSpendedMedicine, double costOfSpendedMaterials, int costOfServices) {
        this.patient = patient;
        this.doctor = doctor;
        this.firstOrSecondVisit = firstOrSecondVisit;
        this.anamnez = anamnez;
        this.diagnoz = diagnoz;
        this.treatment = treatment;
        this.costOfSpendedMedicine = costOfSpendedMedicine;
        this.costOfSpendedMaterials = costOfSpendedMaterials;
        this.costOfServices = costOfServices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFirstOrSecondVisit() {
        return firstOrSecondVisit;
    }

    public void setFirstOrSecondVisit(String firstOrSecondVisit) {
        this.firstOrSecondVisit = firstOrSecondVisit;
    }

    public String getAnamnez() {
        return anamnez;
    }

    public void setAnamnez(String anamnez) {
        this.anamnez = anamnez;
    }

    public String getDiagnoz() {
        return diagnoz;
    }

    public void setDiagnoz(String diagnoz) {
        this.diagnoz = diagnoz;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public double getCostOfSpendedMedicine() {
        return costOfSpendedMedicine;
    }

    public void setCostOfSpendedMedicine(double costOfSpendedMedicine) {
        this.costOfSpendedMedicine = costOfSpendedMedicine;
    }

    public double getCostOfSpendedMaterials() {
        return costOfSpendedMaterials;
    }

    public void setCostOfSpendedMaterials(double costOfSpendedMaterials) {
        this.costOfSpendedMaterials = costOfSpendedMaterials;
    }

    public int getCostOfServices() {
        return costOfServices;
    }

    public void setCostOfServices(int costOfServices) {
        this.costOfServices = costOfServices;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id='" + id + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", firstOrSecondVisit='" + firstOrSecondVisit + '\'' +
                ", anamnez='" + anamnez + '\'' +
                ", diagnoz='" + diagnoz + '\'' +
                ", treatment='" + treatment + '\'' +
                ", costOfSpendedMedicine=" + costOfSpendedMedicine +
                ", costOfSpendedMaterials=" + costOfSpendedMaterials +
                ", costOfServices=" + costOfServices +
                '}';
    }
}
