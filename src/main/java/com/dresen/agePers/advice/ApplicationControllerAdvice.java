package com.dresen.agePers.advice;

import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    public @ResponseBody EntityErrorDetails handleNotFoundException(ResourceNotFoundException exception) {

        return new EntityErrorDetails("Ressource non trouvée", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ResourceTakenException.class})
    public @ResponseBody EntityErrorDetails handleResourceTakenException(ResourceTakenException exception) {

        return new EntityErrorDetails("Ressource déjà utilisée", exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<InvalidArgument> handeleInvalidArgument(MethodArgumentNotValidException exception) {

        List<InvalidArgument> invalidArguments = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(
                fieldError -> {
                    invalidArguments.add(
                            new InvalidArgument(fieldError.getField(), fieldError.getDefaultMessage())
                    );
                });

        return invalidArguments;
    }

}
