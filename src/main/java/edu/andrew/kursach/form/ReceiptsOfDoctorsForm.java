package edu.andrew.kursach.form;


public class ReceiptsOfDoctorsForm {

    private String doctor;
    private double inADay;
    private double inAMounth;
    private String day;
    private String month;

    public ReceiptsOfDoctorsForm() {
    }

    public ReceiptsOfDoctorsForm(String doctor, double inADay, double inAMounth, String day, String month) {
        this.doctor = doctor;
        this.inADay = inADay;
        this.inAMounth = inAMounth;
        this.day = day;
        this.month = month;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public double getInADay() {
        return inADay;
    }

    public void setInADay(double inADay) {
        this.inADay = inADay;
    }

    public double getInAMounth() {
        return inAMounth;
    }

    public void setInAMounth(double inAMounth) {
        this.inAMounth = inAMounth;
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
        return "ReceiptsOfDoctorsForm{" +
                "doctor='" + doctor + '\'' +
                ", inADay=" + inADay +
                ", inAMounth=" + inAMounth +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
