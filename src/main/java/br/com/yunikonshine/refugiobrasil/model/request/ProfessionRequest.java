package br.com.yunikonshine.refugiobrasil.model.request;

import br.com.yunikonshine.refugiobrasil.model.request.anotation.ValidDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionRequest {

    @NotBlank
    private String description;

    @NotBlank
    private String workload;

    @NotBlank
    private String company;

    @NotNull
    @ValidDate
    private String startDate;

    @NotNull
    @ValidDate
    private String endDate;

    @NotNull
    private Boolean current;

    @NotNull
    private Boolean recommendation;

    @NotNull
    @Positive
    private Long country;

}
