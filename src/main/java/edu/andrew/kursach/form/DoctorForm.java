package edu.andrew.kursach.form;

public class DoctorForm {

    private String FIO;
    private String speciality;
    private String adress;
    private String phoneNumber;
    private int costPerSession;

    public DoctorForm() {
    }

    public DoctorForm(String FIO, String speciality, String adress, String phoneNumber, int costPerSession) {
        this.FIO = FIO;
        this.speciality = speciality;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.costPerSession = costPerSession;
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
        return "DoctorForm{" +
                "FIO='" + FIO + '\'' +
                ", speciality='" + speciality + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", costPerSession=" + costPerSession +
                '}';
    }
}
