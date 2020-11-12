package com.br.desenvolvimento.error;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.desenvolvimento.entity.ErrorResponse;
import com.br.desenvolvimento.entity.ObjectError;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, 
	                                                              HttpStatus status, WebRequest request) {
		List<ObjectError> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
	}
	
	private List<ObjectError> getErrors(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult().getFieldErrors().stream()
	            .map(error -> new ObjectError(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
	            .collect(Collectors.toList());
	}
	
	private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ObjectError> errors) {
        return new ErrorResponse("Requisição possui campos inválidos", status.value(),
                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }


}
