package com.dresen.agePers.exceptioin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceTakenException extends IllegalStateException {

    private String resourceName;

    private String fieldName;

    private Object fieldValue;

    public ResourceTakenException(String resourceName, String fieldName, Object fieldValue) {

        super(String.format("Value '%s' already used as %s in another %s.", fieldValue, fieldName, resourceName));
    }
}
