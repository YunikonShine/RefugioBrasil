package br.com.yunikonshine.refugiobrasil.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateRequest {

    @Pattern(regexp = "[\\d]*")
    private String id;

}
