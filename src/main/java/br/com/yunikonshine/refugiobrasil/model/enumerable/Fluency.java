package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Fluency {

	BASIC("Básico"), 
	INTERMEDIATE("Intermediário"), 
	ADVANCED("Avançado"), 
	FLUENT("Fluente");

	private final String description;

}
