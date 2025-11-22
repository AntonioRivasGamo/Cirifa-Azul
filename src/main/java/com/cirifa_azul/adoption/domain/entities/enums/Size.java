package com.cirifa_azul.adoption.domain.entities.enums;

public enum Size {
	//<6kg
	TOY,
	//6-10kg
	SMALL,
	//10-28kg
	MEDIUM,
	//28-45kg
	LARGE,
	//>45kg
	GIANT;
	
	
	
	public static Size sizeCategory(Double w) {
		if(w < 6) return TOY;
		if(w >= 6 && w < 10) return SMALL;
		if(w >= 10 && w < 28) return MEDIUM;
		if(w >= 28 && w < 45) return LARGE;
		return GIANT;
	}
}
