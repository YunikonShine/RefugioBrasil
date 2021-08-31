package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.enumerable.Gender;
import br.com.yunikonshine.refugiobrasil.model.enumerable.MaritalStatus;
import br.com.yunikonshine.refugiobrasil.model.request.anotation.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefugeeBaseRequest {

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
    @Positive
    private Long birthCountry;

    @NotNull
    @Positive
    private Long originCountry;

    @Valid
    @NotNull
    private NecessityRequest necessity;

    @Valid
    @NotNull
    private AddressRequest address;

}
