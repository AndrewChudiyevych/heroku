package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Diseases {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private String nameOfDisease;
    @NotBlank(message = "Please fill the field")
    private String medicine;
    @NotBlank(message = "Please fill the field")
    private String materials;

    public Diseases() {
    }

    public Diseases(String id, String nameOfDisease, String medicine, String materials) {
        this.id = id;
        this.nameOfDisease = nameOfDisease;
        this.medicine = medicine;
        this.materials = materials;
    }

    public Diseases(String nameOfDisease, String medicine, String materials) {
        this.nameOfDisease = nameOfDisease;
        this.medicine = medicine;
        this.materials = materials;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfDisease() {
        return nameOfDisease;
    }

    public void setNameOfDisease(String nameOfDisease) {
        this.nameOfDisease = nameOfDisease;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "Diseases{" +
                "id='" + id + '\'' +
                ", nameOfDisease='" + nameOfDisease + '\'' +
                ", medicine='" + medicine + '\'' +
                ", materials='" + materials + '\'' +
                '}';
    }
}
