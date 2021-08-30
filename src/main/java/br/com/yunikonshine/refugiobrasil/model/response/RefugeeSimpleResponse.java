package br.com.yunikonshine.refugiobrasil.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefugeeSimpleResponse {

    private String id;

    private String name;

    private String originCountry;

    private String birthCountry;

    private String bornDate;

    private String arrivalDate;

    private String creationDate;

}
