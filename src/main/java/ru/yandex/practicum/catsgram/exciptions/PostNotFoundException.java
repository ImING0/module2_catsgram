package ru.yandex.practicum.catsgram.exciptions;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(String message) {
        super(message);
    }
}
