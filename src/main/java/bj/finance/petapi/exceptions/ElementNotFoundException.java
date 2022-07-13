package bj.finance.petapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ElementNotFoundException extends  RuntimeException{

    public ElementNotFoundException(String message) {
        super(message);
    }
}
