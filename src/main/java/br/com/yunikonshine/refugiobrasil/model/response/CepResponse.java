package br.com.yunikonshine.refugiobrasil.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CepResponse {

    private String cep;

    private String street;

    private String complement;

    private String district;

    private CityResponse city;

}
