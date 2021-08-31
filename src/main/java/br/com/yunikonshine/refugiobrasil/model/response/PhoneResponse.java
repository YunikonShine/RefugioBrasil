package br.com.yunikonshine.refugiobrasil.model.response;

import br.com.yunikonshine.refugiobrasil.model.enumerable.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResponse {

    private String id;

    private PhoneType type;

    private String idd;

    private String number;

}
