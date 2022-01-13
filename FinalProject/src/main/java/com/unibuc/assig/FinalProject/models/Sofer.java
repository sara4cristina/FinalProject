package com.unibuc.assig.FinalProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sofer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private long id;

    @Column(name = "nume_sofer")
    private String nume;

    @Column(name = "prenume_sofer")
    private String prenume;

    @Column(name = "telefon_sofer")
    private String telefon;

    @OneToOne
    @JoinColumn(name = "id_buletin")
    private Buletin buletin;

    @OneToOne
    @JoinColumn(name = "id_masina")
    private Masina masina;

    @JsonIgnore
    @OneToMany(mappedBy = "sofer")
    private List<Cursa> curse;

    public Sofer() {
    }

    public Sofer(String nume, String prenume, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
    }


    public Sofer(String nume, String prenume, String telefon, Buletin buletin, Masina masina) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.buletin = buletin;
        this.masina = masina;
    }


    public List<Cursa> getCurse() {
        return curse;
    }

    public void setCurse(List<Cursa> curse) {
        this.curse = curse;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Buletin getBuletin() {
        return buletin;
    }

    public void setBuletin(Buletin buletin) {
        this.buletin = buletin;
    }

    public Masina getMasina() {
        return masina;
    }

    public void setMasina(Masina masina) {
        this.masina = masina;
    }

    @Override
    public String toString() {
        return "Sofer{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", buletin=" + buletin +
                ", masina=" + masina +
                ", curse=" + curse +
                '}';
    }
}
