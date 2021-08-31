package br.com.yunikonshine.refugiobrasil.model.response;

import br.com.yunikonshine.refugiobrasil.model.enumerable.HomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private String id;

    private String street;

    private Integer number;

    private String complement;

    private String cep;

    private HomeType homeType;

    private CityStateResponse city;

}
