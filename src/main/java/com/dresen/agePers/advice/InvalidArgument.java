package com.dresen.agePers.advice;

public record InvalidArgument(
        String field,
        String message
) {

}
