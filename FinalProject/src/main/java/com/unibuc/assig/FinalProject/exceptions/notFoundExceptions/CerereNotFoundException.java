package com.unibuc.assig.FinalProject.exceptions.notFoundExceptions;

public class CerereNotFoundException extends AnObjectNotFound {

    public CerereNotFoundException(long i)
    {
        super(i, "Cerere");
    }
}
