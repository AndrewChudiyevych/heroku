package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class Medicine {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private Manufacter manufacter;
    @NotBlank(message = "Please fill the field")
    private double price;
    @NotBlank(message = "Please fill the field")
    private String typeOfMedicine;
    @NotBlank(message = "Please fill the field")
    private String nameOfMedicine;
    @NotBlank(message = "Please fill the field")
    private Diseases disiase;

    public Medicine() {
    }

    public Medicine(String id, Manufacter manufacter, double price, String typeOfMedicine, String nameOfMedicine, Diseases disiase) {
        this.id = id;
        this.manufacter = manufacter;
        this.price = price;
        this.typeOfMedicine = typeOfMedicine;
        this.nameOfMedicine = nameOfMedicine;
        this.disiase = disiase;
    }

    public Medicine(Manufacter manufacter, double price, String typeOfMedicine, String nameOfMedicine, Diseases disiase) {
        this.manufacter = manufacter;
        this.price = price;
        this.typeOfMedicine = typeOfMedicine;
        this.nameOfMedicine = nameOfMedicine;
        this.disiase = disiase;
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

    public String getTypeOfMedicine() {
        return typeOfMedicine;
    }

    public void setTypeOfMedicine(String typeOfMedicine) {
        this.typeOfMedicine = typeOfMedicine;
    }

    public String getNameOfMedicine() {
        return nameOfMedicine;
    }

    public void setNameOfMedicine(String nameOfMedicine) {
        this.nameOfMedicine = nameOfMedicine;
    }

    public Diseases getDisiase() {
        return disiase;
    }

    public void setDisiase(Diseases disiase) {
        this.disiase = disiase;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", manufacter=" + manufacter +
                ", price=" + price +
                ", typeOfMedicine='" + typeOfMedicine + '\'' +
                ", nameOfMedicine='" + nameOfMedicine + '\'' +
                ", disiase=" + disiase +
                '}';
    }
}
