package ru.zifrkoks.delivery_service.domain.services.exceptions;

public class SendException extends Exception {
    
    public SendException(String msg){
        super(msg);
    }
}
