package br.com.yunikonshine.refugiobrasil.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityResponse {

    private Long id;

    private String name;

    private StateResponse state;

}
