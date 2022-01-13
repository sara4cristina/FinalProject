package com.unibuc.assig.FinalProject.models;

import javax.persistence.*;

@Entity
public class Masina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long id;

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
