package br.com.andre.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class CarBrandNotAllowedException extends Exception {

    public CarBrandNotAllowedException(String message) {
        super(message);
    }
}
