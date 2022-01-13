package com.unibuc.assig.FinalProject.dtos;

import com.unibuc.assig.FinalProject.models.Client;
import com.unibuc.assig.FinalProject.models.Cursa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;

@ApiModel(value = "Cerere Dto", description = "Required details needed to create a new Cerere")
public class CerereDto {

    @NotBlank(message = "Plecare connot be null")
    @ApiModelProperty(value = "plecare", required = true, notes = "The name of departure of the Cerere", example = "Bucuresti", position = 1)
    private String plecare;

    @NotBlank(message = "Sosire connot be null")
    @ApiModelProperty(value = "sosire", required = true, notes = "The name of arrival of the Cerere", example = "Suceava", position = 2)
    private String sosire;

    @NotBlank(message = "Data connot be null")
    @ApiModelProperty(value = "data", required = true, notes = "The data of the Cerere", example = "12.03.2022", position = 3)
    private String data;


    @NotNull(message = "Pret connot be null")
    @Min(0)
    @ApiModelProperty(value = "pret", required = true, notes = "The price of the Cerere",  position = 4)
    private Double pret;

    public CerereDto() {
    }

    public CerereDto(String plecare, String sosire, String data, Double pret) {
        this.plecare = plecare;
        this.sosire = sosire;
        this.data = data;
        this.pret = pret;
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

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }
}
