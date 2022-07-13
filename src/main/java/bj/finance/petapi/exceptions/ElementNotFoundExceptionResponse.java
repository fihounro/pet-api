package bj.finance.petapi.exceptions;

import lombok.Data;

@Data
public class ElementNotFoundExceptionResponse {

    private String projectNotFound;

    public ElementNotFoundExceptionResponse(String projectNotFound){
        this.projectNotFound = projectNotFound;
    }
}
