package br.com.yunikonshine.refugiobrasil.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityStateResponse extends CityResponse {

    private StateResponse state;

}
