package com.dresen.agePers.exceptioin.advice;

public record InvalidArgument(

        String code,
        String field,
        String message
) {

}
