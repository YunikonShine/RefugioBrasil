package br.com.yunikonshine.refugiobrasil.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionResponse {

    private String id;

    private String description;

    private String workload;

    private String company;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean current;

    private Boolean recommendation;

    private CountryResponse country;

}
