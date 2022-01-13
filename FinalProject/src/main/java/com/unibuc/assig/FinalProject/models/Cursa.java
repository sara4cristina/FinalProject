package com.unibuc.assig.FinalProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Cursa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long id;

    @Column(name = "executie")
    @Enumerated(EnumType.STRING)
    private EfectuareType executie;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_sofer")
    private Sofer sofer;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_cerere")
    private Cerere cerere;

    public Cursa() {
    }

    public Cursa(EfectuareType executie, Sofer sofer, Cerere cerere) {
        this.executie = executie;
        this.sofer = sofer;
        this.cerere = cerere;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EfectuareType getExecutie() {
        return executie;
    }

    public void setExecutie(EfectuareType executie) {
        this.executie = executie;
    }

    public Sofer getSofer() {
        return sofer;
    }

    public void setSofer(Sofer sofer) {
        this.sofer = sofer;
    }

    public Cerere getCerere() {
        return cerere;
    }

    public void setCerere(Cerere cerere) {
        this.cerere = cerere;
    }


    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", executie=" + executie +
                ", sofer=" + sofer +
                ", cerere=" + cerere +
                '}';
    }
}
