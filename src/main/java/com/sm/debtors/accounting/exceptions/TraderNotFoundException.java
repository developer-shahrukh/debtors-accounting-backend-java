package com.sm.debtors.accounting.exceptions;

public class TraderNotFoundException extends RuntimeException   {
    public TraderNotFoundException(){
        super();
    }
    public TraderNotFoundException(String message){
        super(message);
    }

}
