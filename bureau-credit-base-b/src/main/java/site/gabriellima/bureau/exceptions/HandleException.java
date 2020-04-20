package site.gabriellima.bureau.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;
import site.gabriellima.bureau.exceptions.model.ResponseError;
import site.gabriellima.bureau.exceptions.model.ResponseErrorValidation;

@ControllerAdvice
@Slf4j
public class HandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handleIResourceNotFoundError(ResourceNotFoundException ex) {
        log.error("ResourceNotFoundException: '{}'", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseError("Recurso não encontrado", ex.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        ResponseErrorValidation responseErrorValidation = new ResponseErrorValidation("Erro de validação",
                "Verifique todos os campos");

        ex.getBindingResult().getFieldErrors()
                .forEach(f -> responseErrorValidation.adicionarCampo(f.getField(), f.getDefaultMessage()));

        return new ResponseEntity<>(responseErrorValidation, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ResponseError("Erro interno", ex.getMessage()), headers, status);
    }

}
