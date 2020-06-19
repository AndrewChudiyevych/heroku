package edu.andrew.kursach.form;

import edu.andrew.kursach.model.Doctor;
import edu.andrew.kursach.model.Patient;

import javax.xml.soap.SAAJResult;

public class VisitForm {

    private String patient;
    private String doctor;
    private String firstOrSecondVisit;
    private String anamnez;
    private String diagnoz;
    private String treatment;
    private double costOfSpendedMedicine;
    private double costOfSpendedMaterials;
    private int costOfServices;

    public VisitForm() {
    }

    public VisitForm(String patient, String doctor, String firstOrSecondVisit, String anamnez, String diagnoz, String treatment, double costOfSpendedMedicine, double costOfSpendedMaterials, int costOfServices) {
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

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
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
        return "VisitForm{" +
                "patient='" + patient + '\'' +
                ", doctor='" + doctor + '\'' +
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
