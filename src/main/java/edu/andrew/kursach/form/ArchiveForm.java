package edu.andrew.kursach.form;

public class ArchiveForm {
    private String beginningOfTreatment;
    private String endOfTreatment;
    private String doctor;
    private String patient;
    private String disease;

    public ArchiveForm() {
    }

    public ArchiveForm(String beginningOfTreatment, String endOfTreatment, String doctor, String patient, String disease) {
        this.beginningOfTreatment = beginningOfTreatment;
        this.endOfTreatment = endOfTreatment;
        this.doctor = doctor;
        this.patient = patient;
        this.disease = disease;
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

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "ArchiveForm{" +
                "beginningOfTreatment='" + beginningOfTreatment + '\'' +
                ", endOfTreatment='" + endOfTreatment + '\'' +
                ", doctor='" + doctor + '\'' +
                ", patient='" + patient + '\'' +
                ", disease='" + disease + '\'' +
                '}';
    }
}
