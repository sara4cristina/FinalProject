package com.unibuc.assig.FinalProject.exceptions.notFoundExceptions;

public class CursaNotFoundException extends AnObjectNotFound {

    public CursaNotFoundException(long id)
    {
        super(id, "Cursa");
    }
}
