package com.unibuc.assig.FinalProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Buletin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long id;

    @Column(name = "serie_nr")
    private String serie_nr;

    @Column(name = "cnp")
    private String cnp;

    public Buletin() {
    }

    public Buletin(String serieNr, String cnp) {
        this.serie_nr = serieNr;

        this.cnp = cnp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerie_nr() {
        return serie_nr;
    }

    public void setSerie_nr(String serie_nr) {
        this.serie_nr = serie_nr;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }


    @Override
    public String toString() {
        return "Buletin{" +
                "id=" + id +
                ", serie_nr='" + serie_nr + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
