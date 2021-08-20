package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AcademicStatus {

	STUDYING("Cursando"),
	COMPLETED("Completo"),
	INCOMPLETE("Incompleto");
	
	private final String description;

}
