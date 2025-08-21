package com.example.mv.common;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String,Object> handleValidation(MethodArgumentNotValidException ex){
    Map<String,Object> body = new LinkedHashMap<>();
    body.put("message","Validation failed");
    body.put("errors", ex.getBindingResult().getFieldErrors().stream()
        .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (a,b)->a)));
    return body;
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String,String> notFound(NoSuchElementException ex){ return Map.of("message","Not found"); }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String,String> generic(Exception ex){ return Map.of("message","Server error"); }
}
