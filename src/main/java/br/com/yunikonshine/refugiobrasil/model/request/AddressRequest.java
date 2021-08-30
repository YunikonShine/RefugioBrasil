package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.enumerable.HomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @NotBlank
    private String street;

    @NotNull
    private Integer number;

    @NotBlank
    private String complement;

    @NotBlank
    @Pattern(regexp = "[\\d]{8}")
    private String cep;

    @NotNull
    private Integer city;

    @NotNull
    private HomeType homeType;

}
