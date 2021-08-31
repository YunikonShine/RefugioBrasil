package br.com.yunikonshine.refugiobrasil.model.response;

import br.com.yunikonshine.refugiobrasil.model.enumerable.AcademicLevel;
import br.com.yunikonshine.refugiobrasil.model.enumerable.AcademicStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormationResponse {

    private String id;

    private String course;

    private String institution;

    private LocalDate startDate;

    private LocalDate endDate;

    private AcademicLevel level;

    private AcademicStatus situation;

    private CountryResponse country;

}
