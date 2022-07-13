package bj.finance.petapi.exceptions;

import lombok.Data;

@Data
public class ProjectIdentifierExceptionResponse {

    private String projectIdentifier;

    public ProjectIdentifierExceptionResponse(String projectIdentifier){
        this.projectIdentifier = projectIdentifier;
    }
}
