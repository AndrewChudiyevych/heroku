package edu.andrew.kursach.form;

public class ManufacterForm {
    private String name;
    private String typeOfProduction;

    public ManufacterForm() {
    }

    public ManufacterForm(String name, String typeOfProduction) {
        this.name = name;
        this.typeOfProduction = typeOfProduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfProduction() {
        return typeOfProduction;
    }

    public void setTypeOfProduction(String typeOfProduction) {
        this.typeOfProduction = typeOfProduction;
    }

    @Override
    public String toString() {
        return "ManufacterForm{" +
                "name='" + name + '\'' +
                ", typeOfProduction='" + typeOfProduction + '\'' +
                '}';
    }
}
