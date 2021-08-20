package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

	MALE("Masculino"),
	FEMALE("Feminino"),
	NOT_BINARY("Não binario");

	private final String description;

}
