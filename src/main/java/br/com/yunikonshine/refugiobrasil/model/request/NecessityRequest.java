package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.enumerable.Situation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NecessityRequest {

    @NotBlank
    private String description;

    @NotNull
    private Boolean food;

    @NotNull
    private Boolean home;

    @NotNull
    private Boolean medicine;

    @NotNull
    private Situation situation;

}
