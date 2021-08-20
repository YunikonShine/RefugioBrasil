package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AcademicLevel {
	
	FUNDAMENTAL("Fundamental"),
	HIGH_SCHOOL("Médio"),
	UNIVERSITY("Superior"),
	POST_GRADUATE("Pós graduação"),
	MASTER("Mestrado"),
	DOCTORATE("Doutorado"),
	POST_DOCTORATE("Pós doutorado"),
	FREE_TEACHING("Livre docência");
	
	private final String description;

}
