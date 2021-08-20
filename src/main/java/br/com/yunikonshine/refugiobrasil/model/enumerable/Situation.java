package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Situation {

	AID("Socorro"),
	INTEGRATION("Integração"),
	CONSOLIDATION("Consolidação");
	
	private final String description;
	
}
