package com.labinvent.task.web;

import com.labinvent.task.serivice.exception.BadEntityException;
import com.labinvent.task.serivice.exception.NotFoundEntityException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String ACCESS_DENIED = "Access denied";

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundExceptions(NotFoundEntityException exception) {
        return new ResponseEntity<>(getObjectErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadEntityException.class)
    public ResponseEntity<ErrorResponse> handleBadEntityExceptionException(BadEntityException exception) {
        return new ResponseEntity<>(getObjectErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> accessDenied(AccessDeniedException e) {
        return new ResponseEntity<>(getObjectErrorResponse(ACCESS_DENIED), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleOtherException(Throwable exception) {
        return new ResponseEntity<>(getObjectErrorResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        errorResponse.setErrors(errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getObjectErrorResponse(String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.addError(message);
        return errorResponse;
    }
}
