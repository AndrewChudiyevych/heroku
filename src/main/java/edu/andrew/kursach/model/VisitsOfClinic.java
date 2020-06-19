package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class VisitsOfClinic {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private int patientsPerDay;
    @NotBlank(message = "Please fill the field")
    private int patientsPerMonth;
    @NotBlank(message = "Please fill the field")
    private String day;
    @NotBlank(message = "Please fill the field")
    private String month;

    public VisitsOfClinic() {
    }

    public VisitsOfClinic(String id, int patientsPerDay, int patientsPerMonth, String day, String month) {
        this.id = id;
        this.patientsPerDay = patientsPerDay;
        this.patientsPerMonth = patientsPerMonth;
        this.day = day;
        this.month = month;
    }

    public VisitsOfClinic(int patientsPerDay, int patientsPerMonth, String day, String month) {
        this.patientsPerDay = patientsPerDay;
        this.patientsPerMonth = patientsPerMonth;
        this.day = day;
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "VisitsOfClinic{" +
                "id='" + id + '\'' +
                ", patientsPerDay=" + patientsPerDay +
                ", patientsPerMonth=" + patientsPerMonth +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
