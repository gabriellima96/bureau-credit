package site.gabriellima.bureau.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseError {

    private String error;
    private String message;
}
