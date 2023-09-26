package ru.zifrkoks.delivery_service.domain.exceptions;

public class SignUpException extends Exception {

    public SignUpStatus status;

    public SignUpException(SignUpStatus status) {
        super(status.toString());
        this.status = status;
    }

    public enum SignUpStatus{
        NAME_TAKEN,
        NOT_VALID,
        SERVER_ERROR,
    }
}
