package com.unibuc.assig.FinalProject.dtos;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

public class RezervareDto {

    @NotNull(message = "idSofer not be null")
    private long idSofer;

    @NotNull (message = "idCerere cannot be null")
    private long idCerere;

    public RezervareDto(long idSofer, long idCerere) {
        this.idSofer = idSofer;
        this.idCerere = idCerere;
    }


    public long getIdSofer() {
        return idSofer;
    }

    public void setIdSofer(long idSofer) {
        this.idSofer = idSofer;
    }

    public long getIdCerere() {
        return idCerere;
    }

    public void setIdCerere(long idCerere) {
        this.idCerere = idCerere;
    }
}
