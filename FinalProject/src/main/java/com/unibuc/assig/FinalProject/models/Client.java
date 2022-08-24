package com.unibuc.assig.FinalProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long id;

    @NotBlank(message = "Nume cannot be null or blank")
    @Column(name = "nume_client")
    private String nume;

    @NotBlank(message = "Telefon cannot be null or blank")
    @Column(name = "telefon_client")
    private String telefon;

    @NotBlank(message = "Cui cannot be null or blank")
    @Column(name = "cui")
    private String cui;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Cerere> cereri;

    public Client() {
    }

    public Client(String nume, String telefon, String cui, List<Cerere> cereri) {
        this.nume = nume;
        this.telefon = telefon;
        this.cui = cui;
        this.cereri = cereri;
    }

    public Client(String nume, String telefon, String cui) {
        this.nume = nume;
        this.telefon = telefon;
        this.cui = cui;
    }

    public Client(long id, String nume, String telefon, String cui) {
        this.id = id;
        this.nume = nume;
        this.telefon = telefon;
        this.cui = cui;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public List<Cerere> getCereri() {
        return cereri;
    }

    public void setCereri(List<Cerere> cereri) {
        this.cereri = cereri;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", cui='" + cui + '\'' +
                ", cereri=" + cereri +
                '}';
    }
}
