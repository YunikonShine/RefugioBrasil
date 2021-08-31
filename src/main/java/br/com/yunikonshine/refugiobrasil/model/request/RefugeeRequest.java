package br.com.yunikonshine.refugiobrasil.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefugeeRequest extends RefugeeBaseRequest {

    @Valid
    @NotNull
    @Size(min = 1)
    private List<DocumentRequest> documents;

    @Valid
    private List<ProfessionRequest> professions;

    @Valid
    @NotNull
    @Size(min = 1)
    private List<LanguageRequest> languages;

    @Valid
    private List<FormationRequest> formations;

    @Valid
    private List<PhoneRequest> phones;

}
