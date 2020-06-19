package edu.andrew.kursach.form;

public class VisitsOfClinicForm {

    private int patientsPerDay;
    private int patientsPerMonth;
    private String day;
    private String month;

    public VisitsOfClinicForm() {
    }

    public VisitsOfClinicForm(int patientsPerDay, int patientsPerMonth, String day, String month) {
        this.patientsPerDay = patientsPerDay;
        this.patientsPerMonth = patientsPerMonth;
        this.day = day;
        this.month = month;
    }

    public int getPatientsPerDay() {
        return patientsPerDay;
    }

    public void setPatientsPerDay(int patientsPerDay) {
        this.patientsPerDay = patientsPerDay;
    }

    public int getPatientsPerMonth() {
        return patientsPerMonth;
    }

    public void setPatientsPerMonth(int patientsPerMonth) {
        this.patientsPerMonth = patientsPerMonth;
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
        return "VisitsOfClinicForm{" +
                "patientsPerDay=" + patientsPerDay +
                ", patientsPerMonth=" + patientsPerMonth +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
