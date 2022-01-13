package com.unibuc.assig.FinalProject.dtos;

import com.unibuc.assig.FinalProject.models.Cerere;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@ApiModel(value = "Client Dto", description = "Required details needed to create a new Client")
public class ClientDto {



    @NotBlank(message = "Nume cannot be null or blank")
    @ApiModelProperty(value = "nume", required = true, notes = "The name of the Client", example = "One Trans SRL", position = 1)
    private String nume;

    @NotBlank(message = "Telefon cannot be null or blank")
    @ApiModelProperty(value = "telefon", required = true, notes = "The telefon of the Client", example = "0745985896", position = 2)
    private String telefon;

    @NotBlank(message = "Cui cannot be null or blank")
    @ApiModelProperty(value = "cui", required = true, notes = "The CUI(Cod Unic de Identificare of the Client", example = "RO8569321", position = 3)
    private String cui;


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
}
