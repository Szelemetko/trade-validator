package pl.szelemetko.tradevalidator.model;

import lombok.Getter;


@Getter
public enum LegalEntity {
	
	CS_ZURICH("CS Zurich");

	private String name;
	
	private LegalEntity (String name) {
		this.name = name;
	}
}
