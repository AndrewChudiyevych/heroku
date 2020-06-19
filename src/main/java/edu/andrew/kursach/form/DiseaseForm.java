package edu.andrew.kursach.form;

public class DiseaseForm {
    private String nameOfDisease;
    private String medicine;
    private String materials;

    public DiseaseForm() {
    }

    public DiseaseForm(String nameOfDisease, String medicine, String materials) {
        this.nameOfDisease = nameOfDisease;
        this.medicine = medicine;
        this.materials = materials;
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
        return "diseaseForm{" +
                "nameOfDisease='" + nameOfDisease + '\'' +
                ", medicine='" + medicine + '\'' +
                ", materials='" + materials + '\'' +
                '}';
    }
}
