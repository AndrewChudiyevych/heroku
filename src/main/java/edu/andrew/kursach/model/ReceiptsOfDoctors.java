package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class ReceiptsOfDoctors {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private Doctor doctor;
    @NotBlank(message = "Please fill the field")
    private double inADay;
    @NotBlank(message = "Please fill the field")
    private double inAMounth;
    @NotBlank(message = "Please fill the field")
    private String day;
    @NotBlank(message = "Please fill the field")
    private String month;

    public ReceiptsOfDoctors() {
    }

    public ReceiptsOfDoctors(String id, Doctor doctor, double inADay, double inAMounth, String day, String month) {
        this.id = id;
        this.doctor = doctor;
        this.inADay = inADay;
        this.inAMounth = inAMounth;
        this.day = day;
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
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
        return "ReceiptsOfDoctors{" +
                "id='" + id + '\'' +
                ", doctor=" + doctor +
                ", inADay=" + inADay +
                ", inAMounth=" + inAMounth +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
