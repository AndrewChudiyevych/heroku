package edu.andrew.kursach.form;

public class HistoryOfDiseasesForm {
    private String disease;
    private String patient;
    private String doctor;
    private String beginOfDesease;
    private String endOfDisease;
    private String status;
    private double spendedMoneyOnDesease;
    private String spendingCard;

    public HistoryOfDiseasesForm() {
    }

    public HistoryOfDiseasesForm(String disease, String patient, String doctor, String beginOfDesease, String endOfDisease, String status, double spendedMoneyOnDesease, String spendingCard) {
        this.disease = disease;
        this.patient = patient;
        this.doctor = doctor;
        this.beginOfDesease = beginOfDesease;
        this.endOfDisease = endOfDisease;
        this.status = status;
        this.spendedMoneyOnDesease = spendedMoneyOnDesease;
        this.spendingCard = spendingCard;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
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

    public String getSpendingCard() {
        return spendingCard;
    }

    public void setSpendingCard(String spendingCard) {
        this.spendingCard = spendingCard;
    }

    @Override
    public String toString() {
        return "HistoryOfDiseasesForm{" +
                "disease='" + disease + '\'' +
                ", patient='" + patient + '\'' +
                ", doctor='" + doctor + '\'' +
                ", beginOfDesease='" + beginOfDesease + '\'' +
                ", endOfDisease='" + endOfDisease + '\'' +
                ", status='" + status + '\'' +
                ", spendedMoneyOnDesease=" + spendedMoneyOnDesease +
                ", spendingCard='" + spendingCard + '\'' +
                '}';
    }
}
