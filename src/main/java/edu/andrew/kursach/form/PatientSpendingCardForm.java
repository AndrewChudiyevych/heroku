package edu.andrew.kursach.form;

import edu.andrew.kursach.model.Patient;

public class PatientSpendingCardForm {

    private String patient;
    private String number;
    private double spendPerDay;
    private double spendPerMonth;
    private String day;
    private String month;

    public PatientSpendingCardForm() {
    }

    public PatientSpendingCardForm(String patient, String number, double spendPerDay, double spendPerMonth, String day, String month) {
        this.patient = patient;
        this.number = number;
        this.spendPerDay = spendPerDay;
        this.spendPerMonth = spendPerMonth;
        this.day = day;
        this.month = month;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getSpendPerDay() {
        return spendPerDay;
    }

    public void setSpendPerDay(double spendPerDay) {
        this.spendPerDay = spendPerDay;
    }

    public double getSpendPerMonth() {
        return spendPerMonth;
    }

    public void setSpendPerMonth(double spendPerMonth) {
        this.spendPerMonth = spendPerMonth;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "PatientSpendingCardForm{" +
                "patient='" + patient + '\'' +
                ", number='" + number + '\'' +
                ", spendPerDay=" + spendPerDay +
                ", spendPerMonth=" + spendPerMonth +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
