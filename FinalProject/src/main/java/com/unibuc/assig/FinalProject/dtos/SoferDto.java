package com.unibuc.assig.FinalProject.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class SoferDto {

    @NotBlank(message = "Nume connot be null")
    @ApiModelProperty(value = "nume", required = true, notes = "The name of the Sofer", example = "Stan", position = 1)
    private String nume;

    @NotBlank(message = "Prenume connot be null")
    @ApiModelProperty(value = "prenume", required = true, notes = "The prenume of the Sofer", example = "Cristina-Maria", position = 2)
    private String prenume;

    @NotBlank(message = "telefon connot be null")
    @ApiModelProperty(value = "telefon", required = true, notes = "The telefon of the Sofer", example = "0756986325", position = 3)
    private String telefon;

    @JsonProperty("serie_nr")
    @NotBlank(message = "Seria connot be null")
    @ApiModelProperty(value = "serie_nr", required = true, notes = "The Seria and Nr of the Sofer's document Identity", example = "One Trans SRL", position = 4)
    private String serieNr;

    @NotBlank(message = "Cnp connot be null")
    @ApiModelProperty(value = "cnp", required = true, notes = "The cnp of the Sofer", example = "2891206560025", position = 5)
    private String cnp;

    @JsonProperty("numar_masina")
    @NotBlank(message = "Numar Masina connot be null")
    @ApiModelProperty(value = "numar_masina", required = true, notes = "The number of the Masina of the Sofer", example = "IF-56-SGG", position = 6)
    private String numar_masina;

    @ApiModelProperty(value = "capacitate", required = false, notes = "The capacitate of the Masina(car) of the Sofer",  position = 7)
    private Integer capacitate;




    public SoferDto() {
    }



    public SoferDto(String nume, String prenume, String telefon, String numarNr, String cnp, String numar_masina, Integer capacitate) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.serieNr = numarNr;
        this.cnp = cnp;
        this.numar_masina = numar_masina;
        this.capacitate = capacitate;
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



    public String getNumar_nr() {
        return serieNr;
    }

    public void setNumar_nr(String numar_nr) {
        this.serieNr = numar_nr;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNumar_masina() {
        return numar_masina;
    }

    public void setNumar_masina(String numar_masina) {
        this.numar_masina = numar_masina;
    }

    public Integer getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(Integer capacitate) {
        this.capacitate = capacitate;
    }

    }

