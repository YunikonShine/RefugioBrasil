package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MaritalStatus {

	SINGLE("Solteiro"),
	MARRIED("Casado"),
	SEPARATE("Separado"),
	DIVORCED("Divorciado"),
	WIDOWER("Viúvo");
	
	private final String description;
	
}
