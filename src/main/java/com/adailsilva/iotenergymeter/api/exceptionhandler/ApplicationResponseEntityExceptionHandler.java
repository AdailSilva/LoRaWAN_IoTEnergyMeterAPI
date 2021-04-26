package com.adailsilva.iotenergymeter.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adailsilva.iotenergymeter.api.system.service.exception.NonexistentOrInactivePersonException;

@ControllerAdvice
public class ApplicationResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	private List<UserAndDeveloperError> createListErrors(BindingResult bindingResult) {
		List<UserAndDeveloperError> userAndDeveloperErrors = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String userMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String developMessage = fieldError.toString();
			userAndDeveloperErrors.add(new UserAndDeveloperError(userMessage, developMessage));
		}
		return userAndDeveloperErrors;
	}

//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(
//			HttpMessageNotReadableException httpMessageNotReadableException, HttpHeaders httpHeaders,
//			HttpStatus httpStatus, WebRequest webRequest) {
//
//		String userMessage = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
//		String developMessage = httpMessageNotReadableException.getCause() != null
//				? httpMessageNotReadableException.getCause().toString()
//				: httpMessageNotReadableException.toString();
//		List<UserAndDeveloperError> userAndDeveloperErrors = Arrays
//				.asList(new UserAndDeveloperError(userMessage, developMessage));
//
//		return handleExceptionInternal(httpMessageNotReadableException, userAndDeveloperErrors, httpHeaders,
//				HttpStatus.BAD_REQUEST, webRequest);
//	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException httpMessageNotReadableException, HttpHeaders httpHeaders,
			HttpStatus httpStatus, WebRequest webRequest) {

		String userMessage = this.messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
		String developMessage = Optional.ofNullable(httpMessageNotReadableException.getCause())
				.orElse(httpMessageNotReadableException).toString();

		List<UserAndDeveloperError> userAndDeveloperErrors = Arrays
				.asList(new UserAndDeveloperError(userMessage, developMessage));

		return handleExceptionInternal(httpMessageNotReadableException, userAndDeveloperErrors, httpHeaders,
				HttpStatus.BAD_REQUEST, webRequest);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders httpHeaders,
			HttpStatus httpStatus, WebRequest webRequest) {
		List<UserAndDeveloperError> userAndDeveloperErrors = createListErrors(
				methodArgumentNotValidException.getBindingResult());
		return handleExceptionInternal(methodArgumentNotValidException, userAndDeveloperErrors, httpHeaders,
				HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(
			EmptyResultDataAccessException emptyResultDataAccessException, WebRequest webRequest) {
		String userMessage = messageSource.getMessage("resource.not-found", null, LocaleContextHolder.getLocale());
		String developMessage = emptyResultDataAccessException.toString();
		List<UserAndDeveloperError> userAndDeveloperErrors = Arrays
				.asList(new UserAndDeveloperError(userMessage, developMessage));
		return handleExceptionInternal(emptyResultDataAccessException, userAndDeveloperErrors, new HttpHeaders(),
				HttpStatus.NOT_FOUND, webRequest);
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(
			DataIntegrityViolationException dataIntegrityViolationException, WebRequest webRequest) {
		String userMessage = messageSource.getMessage("resource.operation-not-allowed", null,
				LocaleContextHolder.getLocale());
		// String developMessage = dataIntegrityViolationException.toString();
		/* Using "org.apache.commons dependency" below */
		String developMessage = ExceptionUtils.getRootCauseMessage(dataIntegrityViolationException);
		List<UserAndDeveloperError> userAndDeveloperErrors = Arrays
				.asList(new UserAndDeveloperError(userMessage, developMessage));
		return handleExceptionInternal(dataIntegrityViolationException, userAndDeveloperErrors, new HttpHeaders(),
				HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler({ NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException nullPointerException,
			WebRequest webRequest) {

		String userMessage = messageSource.getMessage("resource.not-found.null-object", null,
				LocaleContextHolder.getLocale());
		String developMessage = nullPointerException.toString();
		List<UserAndDeveloperError> userAndDeveloperErrors = Arrays
				.asList(new UserAndDeveloperError(userMessage, developMessage));

		return handleExceptionInternal(nullPointerException, userAndDeveloperErrors, new HttpHeaders(),
				HttpStatus.NOT_FOUND, webRequest);

	}

	@ExceptionHandler({ NonexistentOrInactivePersonException.class })
	public ResponseEntity<Object> handleNonexistentOrInactivePerson(
			NonexistentOrInactivePersonException nonexistentOrInactivePersonException, WebRequest webRequest) {

		String userMessage = messageSource.getMessage("nonexistent-or-inactive-person", null,
				LocaleContextHolder.getLocale());
		String developMessage = nonexistentOrInactivePersonException.getCause() != null
				? nonexistentOrInactivePersonException.getCause().toString()
				: nonexistentOrInactivePersonException.toString();
		List<UserAndDeveloperError> userAndDeveloperErrors = Arrays
				.asList(new UserAndDeveloperError(userMessage, developMessage));

		return handleExceptionInternal(nonexistentOrInactivePersonException, userAndDeveloperErrors, new HttpHeaders(),
				HttpStatus.BAD_REQUEST, webRequest);
	}

}
