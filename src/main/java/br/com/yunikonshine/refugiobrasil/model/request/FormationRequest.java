package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.enumerable.AcademicLevel;
import br.com.yunikonshine.refugiobrasil.model.enumerable.AcademicStatus;
import br.com.yunikonshine.refugiobrasil.model.request.anotation.ValidDate;
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
public class FormationRequest {

    @NotBlank
    private String course;

    @NotBlank
    private String institution;

    @NotNull
    @ValidDate
    private String startDate;

    @NotNull
    @ValidDate
    private String endDate;

    @NotNull
    private AcademicLevel level;

    @NotNull
    private AcademicStatus situation;

    @NotNull
    private Long country;

}
