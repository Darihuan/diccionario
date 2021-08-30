package web.darihuan.diccionario.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParametrosIncorrectosException extends RuntimeException {
    public ParametrosIncorrectosException(String message) {
        super(message);
    }
}