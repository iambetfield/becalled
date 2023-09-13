package com.iternova.becalled.user;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msj){
        super(msj);
    }
}
