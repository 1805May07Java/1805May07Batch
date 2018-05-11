package com.rev.questions;

public abstract class MiscStringFunctions {

	public abstract boolean containsLowerCase(String n);
	public abstract String toUpperCase(String n);
	public abstract int add10(String number);
	
	public static class MiscStringFunctionsImp extends MiscStringFunctions {

		@Override
		public boolean containsLowerCase(String n) {
			return !n.toUpperCase().equals(n);
		}

		@Override
		public String toUpperCase(String n) {
			return n.toUpperCase();
		}

		@Override
		public int add10(String number) {
			return Integer.parseInt(number) + 10;
		}
		
	}
}
