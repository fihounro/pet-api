package bj.finance.petapi.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidationService(BindingResult result){

        if(result.hasErrors()){

            Map<String, String> errorMap = new HashMap<>();

            /*
            for (FieldError fieldError: result.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }*/

            result.getFieldErrors().forEach(fieldError -> {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            });

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return  null;
    }
}
