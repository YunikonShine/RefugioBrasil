package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HomeType {

	PARTICULAR("Própria"),
	RENT("Alugada"),
	ASSISTANCE("Auxilio governamental"),
	OTHER("Outro");
	
	private final String description;
	
}
