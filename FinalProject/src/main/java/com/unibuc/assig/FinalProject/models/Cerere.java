package com.unibuc.assig.FinalProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cerere {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long id;

    @NotBlank(message = "Plecare connot be null")
    @Column(name = "plecare")
    private String plecare;

    @NotBlank(message = "Sosire connot be null")
    @Column(name = "sosire")
    private String sosire;

    @NotBlank(message = "Data connot be null")
    @Column(name = "data")
    private String data;


    @Column(name = "pret")
    @NotNull(message = "Pret connot be null")
    @Min(0)
    private double pret;


    @Enumerated(EnumType.STRING)
    private RezervareType rezervare;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @JsonIgnore
    @OneToOne(mappedBy = "cerere")
    private Cursa cursa;

    public Cerere() {
    }

    public Cerere(String plecare, String sosire, String data, double pret) {
        this.plecare = plecare;
        this.sosire = sosire;
        this.data = data;
        this.pret = pret;

    }

    public RezervareType getRezervare() {
        return rezervare;
    }

    public void setRezervare(RezervareType rezervare) {
        this.rezervare = rezervare;
    }

    public Cursa getCursa() {
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlecare() {
        return plecare;
    }

    public void setPlecare(String plecare) {
        this.plecare = plecare;
    }

    public String getSosire() {
        return sosire;
    }

    public void setSosire(String sosire) {
        this.sosire = sosire;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Cerere{" +
                "id=" + id +
                ", plecare='" + plecare + '\'' +
                ", sosire='" + sosire + '\'' +
                ", data='" + data + '\'' +
                ", pret=" + pret +
                ", rezervare=" + rezervare +
                ", client=" + client +
                ", cursa=" + cursa +
                '}';
    }
}
