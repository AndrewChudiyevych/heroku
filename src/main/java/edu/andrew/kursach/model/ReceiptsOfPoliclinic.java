package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class ReceiptsOfPoliclinic {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private double inADay;
    @NotBlank(message = "Please fill the field")
    private double inAMounth;
    @NotBlank(message = "Please fill the field")
    private String day;
    @NotBlank(message = "Please fill the field")
    private String month;

    public ReceiptsOfPoliclinic() {
    }

    public ReceiptsOfPoliclinic(String id, double inADay, double inAMounth, String day, String month) {
        this.id = id;
        this.inADay = inADay;
        this.inAMounth = inAMounth;
        this.day = day;
        this.month = month;
    }

    public ReceiptsOfPoliclinic(double inADay, double inAMounth, String day, String month) {
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
        return "ReceiptsOfPoliclinic{" +
                "id='" + id + '\'' +
                ", inADay=" + inADay +
                ", inAMounth=" + inAMounth +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
