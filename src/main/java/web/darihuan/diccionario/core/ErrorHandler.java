package web.darihuan.diccionario.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import web.darihuan.diccionario.core.error.CustomError;
import web.darihuan.diccionario.core.error.ErrorInParams;
import web.darihuan.diccionario.core.error.ParameterViolations;
import web.darihuan.diccionario.core.exception.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<?> handleBadRequest(BadRequestException exception, WebRequest request) {

        CustomError error = new CustomError(new Date(), 404, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<?> ConflictException(ConflictException exception, WebRequest request) {

        CustomError error = new CustomError(new Date(), 409, exception.getMessage());
        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(NotAcceptableException.class)
    public final ResponseEntity<?> ConflictException(NotAcceptableException exception, WebRequest request) {

        CustomError error = new CustomError(new Date(), 406, exception.getMessage());
        return ResponseEntity.status(406).body(error);
    }

    @ExceptionHandler(ParametrosIncorrectosException.class)
    public final ResponseEntity<?> parametrosIncorrectosException(ParametrosIncorrectosException exception, WebRequest request) {
        List<ParameterViolations> parameterViolations = new ArrayList<>();
        ParameterViolations elemento = new ParameterViolations("PARAMETER");
        parameterViolations.add(elemento);
        ErrorInParams error = new ErrorInParams(new Date(), 400, exception.getMessage(), parameterViolations);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<?> NotFountExceptionhandler(NotFoundException exception, WebRequest request) {
        CustomError error = new CustomError(new Date(), 404, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
