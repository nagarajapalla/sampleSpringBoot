package com.nts.firstMicroService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response handle(MethodArgumentNotValidException exception) {
		List<String> errorMessages = (exception.getBindingResult().getFieldErrors().stream()
				.map(FieldError::getDefaultMessage).collect(Collectors.toList()));
		return new Response().builder().status("ERROR").statusMessages(errorMessages).build();
	}

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response handle(ConstraintViolationException exception) {
		List<String> errorMessages = (exception.getConstraintViolations().stream()
				.map((cv)->{String s = cv.getPropertyPath().toString(); return s.concat(cv.getMessage());})
				.collect(Collectors.toList()));
		return new Response().builder().status("ERROR").statusMessages(errorMessages).build();
	}

}
