package edu.andrew.kursach.form;

public class ReceiptsOfPoliclinicForm {

    private double inADay;
    private double inAMounth;
    private String day;
    private String month;

    public ReceiptsOfPoliclinicForm() {
    }

    public ReceiptsOfPoliclinicForm(double inADay, double inAMounth, String day, String month) {
        this.inADay = inADay;
        this.inAMounth = inAMounth;
        this.day = day;
        this.month = month;
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
        return "ReceiptsOfPoliclinicForm{" +
                "inADay=" + inADay +
                ", inAMounth=" + inAMounth +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
