package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.enumerable.HomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @NotBlank
    private String street;

    @NotNull
    @Positive
    private Integer number;

    @NotBlank
    private String complement;

    @NotBlank
    @Pattern(regexp = "[\\d]{8}")
    private String cep;

    @NotNull
    @Positive
    private Integer city;

    @NotNull
    private HomeType homeType;

}
