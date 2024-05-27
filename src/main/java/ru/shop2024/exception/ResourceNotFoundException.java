package ru.shop2024.exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
/*
public ResourceNotFoundException(String message): Этот конструктор принимает сообщение об ошибке
 и передает его в конструктор суперкласса RuntimeException.

public ResourceNotFoundException(String message, Throwable cause):
Этот конструктор принимает сообщение об ошибке и причину (другое исключение),
которая вызвала это исключение. Он передает эти параметры в конструктор суперкласса RuntimeException.
 */