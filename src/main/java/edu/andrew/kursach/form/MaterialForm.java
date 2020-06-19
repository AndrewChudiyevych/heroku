package edu.andrew.kursach.form;

import edu.andrew.kursach.model.Diseases;
import edu.andrew.kursach.model.Manufacter;

public class MaterialForm {
    private String manufacter;
    private double price;
    private String typeOfMaterial;
    private String nameOfMaterial;
    private String disease;

    public MaterialForm() {
    }

    public MaterialForm(String manufacter, double price, String typeOfMaterial, String nameOfMaterial, String disease) {
        this.manufacter = manufacter;
        this.price = price;
        this.typeOfMaterial = typeOfMaterial;
        this.nameOfMaterial = nameOfMaterial;
        this.disease = disease;
    }

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "MaterialForm{" +
                "manufacter='" + manufacter + '\'' +
                ", price=" + price +
                ", typeOfMaterial='" + typeOfMaterial + '\'' +
                ", nameOfMaterial='" + nameOfMaterial + '\'' +
                ", disease='" + disease + '\'' +
                '}';
    }
}
