package com.akapapaj.mylib;

public enum SpecialDays {
	MONDAY("Monday no specials"),
	TUESDAY("Tuesday-iPhone 4"),
	WEDNESDAY("Wednesday-iMac"),
	THURSDAY("Thursday-MacBook Pro"),
	FRIDAY("Friday-Mac Pro"),
	SATURDAY("Saturday-Weekend Flyer"),
	SUNDAY("Sunday-Closed");
	
	private SpecialDays(final String daily) {
		this.daily = daily;
	}
	private final String daily;
	@Override
	public String toString(){
		// TODO Auto-generated method stub
		return daily;
	}
}
