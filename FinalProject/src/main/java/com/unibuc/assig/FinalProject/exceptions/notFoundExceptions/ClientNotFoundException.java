package com.unibuc.assig.FinalProject.exceptions.notFoundExceptions;

public class ClientNotFoundException extends AnObjectNotFound {

    public ClientNotFoundException(long id) {
        super(id, "Client");
    }
}
