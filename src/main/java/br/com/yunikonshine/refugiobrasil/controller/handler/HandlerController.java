package br.com.yunikonshine.refugiobrasil.controller.handler;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.FeignServerInternalServerError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class HandlerController {

    private static final String REFUGIO_BRASIL = "Refugio Brasil";

    private static final String EXTERNAL_API = "API externa";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> genericError(Exception e) {
        log.error("Erro interno do servidor ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), REFUGIO_BRASIL));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Erro ao receber parâmetros ", e);
        ExceptionResponse err = new ExceptionResponse(HttpStatus.BAD_REQUEST, "Parâmetros inválidos", REFUGIO_BRASIL);
        e.getBindingResult().getFieldErrors().forEach(x -> err.getAttributes().add(new AttributeMessage(x.getField(), x.getDefaultMessage())));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("Erro ao receber parâmetros ", e);
        ExceptionResponse err = new ExceptionResponse(HttpStatus.BAD_REQUEST, "Parâmetros inválidos", REFUGIO_BRASIL);
        e.getConstraintViolations().forEach(x -> err.getAttributes().add(new AttributeMessage("query param", x.getMessage())));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(FeignServerInternalServerError.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(FeignServerInternalServerError e) {
        log.error("Erro ao se conectar com um servidor via Feign ", e);
        ExceptionResponse err = new ExceptionResponse(HttpStatus.SERVICE_UNAVAILABLE, "Erro no servidor externo", EXTERNAL_API);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(err);
    }

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCepNotFoundException(CepNotFoundException e) {
        log.error("CEP not found ", e);
        ExceptionResponse err = new ExceptionResponse(HttpStatus.NOT_FOUND, "CEP not found", REFUGIO_BRASIL);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DocumentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleDocumentAlreadyExistsException(DocumentAlreadyExistsException e) {
        log.error("Document already exists ", e);
        ExceptionResponse err = new ExceptionResponse(HttpStatus.FOUND, "Document already exists", REFUGIO_BRASIL);
        return ResponseEntity.status(HttpStatus.FOUND).body(err);
    }

}
