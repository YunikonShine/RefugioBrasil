package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.enumerable.Gender;
import br.com.yunikonshine.refugiobrasil.model.enumerable.MaritalStatus;
import br.com.yunikonshine.refugiobrasil.model.request.validator.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefugeeRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @ValidDate
    private String bornDate;

    @NotNull
    @ValidDate
    private String arrivalDate;

    @NotNull
    private MaritalStatus maritalStatus;

    @NotNull
    private Gender gender;

    @NotNull
    private Boolean institutionCourse;

    @NotNull
    private Long birthCountry;

    @NotNull
    private Long originCountry;

    @Valid
    @NotNull
    private NecessityRequest necessity;

    @Valid
    @NotNull
    private AddressRequest address;

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
