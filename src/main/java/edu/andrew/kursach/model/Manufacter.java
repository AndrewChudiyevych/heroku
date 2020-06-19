package edu.andrew.kursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
public class Manufacter {
    @Id
    private String id;
    @NotBlank(message = "Please fill the field")
    private String name;
    @NotBlank(message = "Please fill the field")
    private String typeOfProduction;

    public Manufacter() {
    }

    public Manufacter(String id, String name, String typeOfProduction) {
        this.id = id;
        this.name = name;
        this.typeOfProduction = typeOfProduction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Manufacter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", typeOfProduction='" + typeOfProduction + '\'' +
                '}';
    }
}
