package br.com.yunikonshine.refugiobrasil.model.enumerable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PhoneType {
	
	RESIDENTIAL("Residêncial"),
	MOBILE("Celular"),
	COMMERCIAL("Comercial");
	
	private final String description;

}
