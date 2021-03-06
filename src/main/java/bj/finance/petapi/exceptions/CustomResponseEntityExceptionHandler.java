package bj.finance.petapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<ProjectIdentifierExceptionResponse> handleProjectIdentifierException(ProjectIdentifierException ex, WebRequest request){

        ProjectIdentifierExceptionResponse exceptionResponse = new ProjectIdentifierExceptionResponse(ex.getMessage());
        return  new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<ElementNotFoundExceptionResponse> handleProjectNotFoundException(ElementNotFoundException ex, WebRequest request){

        ElementNotFoundExceptionResponse exceptionResponse = new ElementNotFoundExceptionResponse(ex.getMessage());
        return  new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
