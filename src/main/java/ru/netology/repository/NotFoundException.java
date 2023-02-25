package ru.netology.repository;

import ru.netology.repository.ProductRepository;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}

