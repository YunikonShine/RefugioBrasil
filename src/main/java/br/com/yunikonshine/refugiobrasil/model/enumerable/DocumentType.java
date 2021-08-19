package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DocumentType {

	PROTOCOL("Protocolo"),
	RNM("RNM"),
	CPF("CPF"), 
	RG("RG"), 
	PASSPORT("Passaporte"),
	CNH("CNH"),
	PIS("PIS"), 
	WORK_CARD("Carteira de trabalho");

	private final String description;

}
