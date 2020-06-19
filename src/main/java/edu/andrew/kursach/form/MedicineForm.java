package edu.andrew.kursach.form;

public class MedicineForm {
    private String manufacter;
    private double price;
    private String typeOfMedicine;
    private String nameOfMedicine;
    private String disiase;

    public MedicineForm() {
    }

    public MedicineForm(String manufacter, double price, String typeOfMedicine, String nameOfMedicine, String disiase) {
        this.manufacter = manufacter;
        this.price = price;
        this.typeOfMedicine = typeOfMedicine;
        this.nameOfMedicine = nameOfMedicine;
        this.disiase = disiase;
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

    public String getDisiase() {
        return disiase;
    }

    public void setDisiase(String disiase) {
        this.disiase = disiase;
    }

    @Override
    public String toString() {
        return "MedicineForm{" +
                "manufacter='" + manufacter + '\'' +
                ", price=" + price +
                ", typeOfMedicine='" + typeOfMedicine + '\'' +
                ", nameOfMedicine='" + nameOfMedicine + '\'' +
                ", disiase='" + disiase + '\'' +
                '}';
    }
}
