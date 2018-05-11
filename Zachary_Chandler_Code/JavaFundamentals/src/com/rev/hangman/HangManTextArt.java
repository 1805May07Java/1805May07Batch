package com.rev.hangman;

public class HangManTextArt {

	public static final int MAX_ERRORS = 5;
	public static final int MAX_WIDTH = 14;
	public static final int MAX_HEIGHT = 7;

	private final char[][] art;
	private int errors;
	
//	public static void main(String[] args) {
//		HangManTextArt art = new HangManTextArt();
//		
//		System.out.println(art);
//		
//		for (int i = 1; i <=5; i++) {
//			art.setErrors(i);
//			System.out.println(art);
//		}
//	}
	
	public HangManTextArt() {
		this.errors = 0;
		this.art = new char[MAX_HEIGHT][MAX_WIDTH];
		
		resetArt();
	}
	
	public String setErrors(int errors) {
		
		if (errors > MAX_ERRORS) {
			this.errors = MAX_ERRORS;
		} else if (errors < 0) {
			this.errors = 0;
		} else {
			this.errors = errors;
		}

		resetArt();
		
		return this.toString();
	}
	
	private void resetArt() {
		for (int i = 0; i < art.length; i++) {
			for (int j = 0; j < art[i].length; j++) {
				art[i][j] = ' ';
			}
		}
		
		addBackground();
		
		if (errors < 5) {
			addHead();
		}

		if (errors < 4) {
			addBody();
		}

		if (errors < 3) {
			addArm2();
		}
		
		if (errors < 2) {
			addArm1();
		}
		
		if (errors < 1) {
			addLegs();
		}
	}

	private void addBackground() {
		String[] bg = { "  ......", 
						"  :    |", 
						"       |", 
						"       |", 
						"       |",
						"       |", 
						"============="};
		
		for (int row = 0; row < bg.length; row++) {
			for (int i = 0; i < bg[row].length(); i++) {
				if (bg[row].charAt(i) != ' ') {
					art[row][i] = bg[row].charAt(i);
				}
			}
		}
		
		return;
	}
	
	private void addHead() {
		art[2][1] = '[';
		art[2][3] = ']';
	}
	
	private void addBody() {
		art[3][2] = '|';
	}

	private void addArm1() {
		art[3][3] = '\\';
	}
	
	private void addArm2() {
		art[3][1] = '/';
	}
	
	private void addLegs() {
		art[4][1] = '/';
		art[4][3] = '\\';
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		

		result.append(art[0]);
		
		for (int i = 1; i < art.length; i++) {
			result.append('\n');
			result.append(art[i]);
		}
		
		return result.toString();
	}
	
}
