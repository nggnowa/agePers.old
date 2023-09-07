package com.dresen.agePers.exceptioin;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends EntityNotFoundException {

    private String resourceName;

    private String fieldName;

    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {

        super(String.format("%s with %s '%s' doesn't exist.", resourceName, fieldName, fieldValue));
    }
}
