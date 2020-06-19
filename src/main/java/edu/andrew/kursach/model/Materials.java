package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Materials {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private Manufacter manufacter;
    @NotBlank(message = "Please fill the field")
    private double price;
    @NotBlank(message = "Please fill the field")
    private String typeOfMaterial;
    @NotBlank(message = "Please fill the field")
    private String nameOfMaterial;
    @NotBlank(message = "Please fill the field")
    private Diseases disease;

    public Materials() {
    }

    public Materials(String id, Manufacter manufacter, double price, String typeOfMaterial, String nameOfMaterial, Diseases disease) {
        this.id = id;
        this.manufacter = manufacter;
        this.price = price;
        this.typeOfMaterial = typeOfMaterial;
        this.nameOfMaterial = nameOfMaterial;
        this.disease = disease;
    }

    public Materials(Manufacter manufacter, double price, String typeOfMaterial, String nameOfMaterial, Diseases disease) {
        this.manufacter = manufacter;
        this.price = price;
        this.typeOfMaterial = typeOfMaterial;
        this.nameOfMaterial = nameOfMaterial;
        this.disease = disease;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Manufacter getManufacter() {
        return manufacter;
    }

    public void setManufacter(Manufacter manufacter) {
        this.manufacter = manufacter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public String getNameOfMaterial() {
        return nameOfMaterial;
    }

    public void setNameOfMaterial(String nameOfMaterial) {
        this.nameOfMaterial = nameOfMaterial;
    }

    public Diseases getDisease() {
        return disease;
    }

    public void setDisease(Diseases disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "id='" + id + '\'' +
                ", manufacter=" + manufacter +
                ", price=" + price +
                ", typeOfMaterial='" + typeOfMaterial + '\'' +
                ", nameOfMaterial='" + nameOfMaterial + '\'' +
                ", disease=" + disease +
                '}';
    }
}
