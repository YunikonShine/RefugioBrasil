package br.com.yunikonshine.refugiobrasil.model.response;

import br.com.yunikonshine.refugiobrasil.model.enumerable.Gender;
import br.com.yunikonshine.refugiobrasil.model.enumerable.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefugeeResponse {

    private String id;

    private LocalDateTime creationDate;

    private String name;

    private String email;

    private LocalDate bornDate;

    private LocalDate arrivalDate;

    private MaritalStatus maritalStatus;

    private Gender gender;

    private Boolean institutionCourse;

    private NecessityResponse necessity;

    private CountryResponse birthCountry;

    private CountryResponse originCountry;

    private AddressResponse address;

    private List<DocumentResponse> documents;

    private List<ProfessionResponse> professions;

    private List<LanguageResponse> languages;

    private List<FormationResponse> formations;

    private List<PhoneResponse> phones;

}
