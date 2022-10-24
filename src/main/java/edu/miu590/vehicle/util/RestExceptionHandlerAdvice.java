package edu.miu590.vehicle.util;

import edu.miu590.vehicle.exceptions.ErrorResponse;
import edu.miu590.vehicle.exceptions.VehicleNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class RestExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({VehicleNotFound.class})
    public ResponseEntity<ErrorResponse> badRequestException(VehicleNotFound exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                request.getDescription(false)),
                HttpStatus.BAD_REQUEST);
    }
}
