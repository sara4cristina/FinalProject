package com.unibuc.assig.FinalProject.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Masina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long id;

    @JsonProperty("numar_masina")
    @NotBlank(message = "Numar Masina connot be null")
    @Column(name = "numar_masina")
    private String numar;

    @Column(name = "capacitate_masina")
    private Integer capacitate;

    public Masina() {
    }

    public Masina(String numar, Integer capacitate) {
        this.numar = numar;
        this.capacitate = capacitate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public Integer getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(Integer capacitate) {
        this.capacitate = capacitate;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", numar='" + numar + '\'' +
                ", capacitate=" + capacitate +
                '}';
    }
}
