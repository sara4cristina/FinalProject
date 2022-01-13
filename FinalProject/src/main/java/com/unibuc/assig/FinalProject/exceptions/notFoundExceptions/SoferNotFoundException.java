package com.unibuc.assig.FinalProject.exceptions.notFoundExceptions;

public class SoferNotFoundException extends AnObjectNotFound {

    public SoferNotFoundException(long id) {
        super(id, "Sofer");
    }
}
