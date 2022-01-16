package com.viettel.vds.springexample.controller;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> notFound(NoSuchElementException e) {
    log.error("Not Found: {}", e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<String> badRequest(BindException e) {
    log.error("Bad Request: {}", e.getMessage());
    List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
    // Show first error message
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors.get(0).getDefaultMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> exception(Exception e) {
    log.error("Internal Server Error: {}", e.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
  }
}
