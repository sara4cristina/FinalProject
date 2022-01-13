package com.unibuc.assig.FinalProject.exceptions.notFoundExceptions;

public class AnObjectNotFound extends RuntimeException {

    public AnObjectNotFound(long id, String objType){
        super(objType + " with id " + id + " doesn't exist!");
    }

}
