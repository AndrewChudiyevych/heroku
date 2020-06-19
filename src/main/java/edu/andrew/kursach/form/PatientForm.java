package edu.andrew.kursach.form;


import javax.validation.constraints.NotBlank;

public class PatientForm {
    private int medicalHistoryNumber;
    private String FIO;
    private String adress;
    private String phoneNumber;

    public PatientForm() {
    }

    public PatientForm(int medicalHistoryNumber, String FIO, String adress, String phoneNumber) {
        this.medicalHistoryNumber = medicalHistoryNumber;
        this.FIO = FIO;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
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
        return "PatientForm{" +
                " medicalHistoryNumber=" + medicalHistoryNumber +
                ", FIO='" + FIO + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
