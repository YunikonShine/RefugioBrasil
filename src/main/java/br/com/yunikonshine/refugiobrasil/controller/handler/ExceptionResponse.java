package br.com.yunikonshine.refugiobrasil.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private String api;

    private Integer code;

    private String status;

    private String description;

    private String date;

    private List<AttributeMessage> attributes;

    public ExceptionResponse(HttpStatus httpStatus, String description, List<AttributeMessage> attributes, String api) {
        this.api = api;
        this.code = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.description = description;
        this.date = LocalDateTime.now().toString();
        this.attributes = attributes;
    }

    public ExceptionResponse(HttpStatus httpStatus, String description, String api) {
        this.api = api;
        this.code = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.description = description;
        this.date = LocalDateTime.now().toString();
        this.attributes = new ArrayList<>();
    }

    public ExceptionResponse(HttpStatus httpStatus, String api) {
        this.api = api;
        this.code = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.date = LocalDateTime.now().toString();
        this.attributes = new ArrayList<>();
    }

}
