package com.viettel.vds.springexample.exception;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String notFound(NoSuchElementException e) {
    log.error("notFound: {}", e.getMessage());
    return e.getMessage();
  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String badRequest(BindException e) {
    log.error("badRequest: {}", e.getMessage());
    List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
    // Show first error message
    return allErrors.get(0).getDefaultMessage();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String internalServerError(Exception e) {
    log.error("internalServerError: {}", e.getMessage());
    return "Unknown Error!";
  }
}
