package com.Ohad.Phase2.beans;

public enum Category {
	Food ,
	Shopping,
	Restaurant,
	Hotel,
	Pool,
	Amusement_Park;
	
	public static final Category values[] = values();

	public static Category values(long j) {
		return values[(int) j];
	}

}
