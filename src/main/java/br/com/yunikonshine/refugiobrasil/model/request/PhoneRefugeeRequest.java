package br.com.yunikonshine.refugiobrasil.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRefugeeRequest extends PhoneRequest {

    @NotBlank
    private String refugeeId;

}
