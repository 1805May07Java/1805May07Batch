package com.rev.numtri;

public class NumberTriangle {

	public static void main(String[] args) {
		System.out.println("in main");
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if( i == 0 && j == 0)
					System.out.print("0 ");
					else if( i == 1 && j == 0)
						System.out.print("1 ");
					else
						if( i == 1 && j == 1)
							System.out.print("0 ");
						else if( i == 2 && j == 0)
							System.out.print("1 ");
						else if( i == 2 && j == 1)
							System.out.print("0 ");
						else if( i == 2 && j == 2)
							System.out.print("1 ");
						else if( i == 3 && j % 2 == 0)
							System.out.print("0 ");
						else if( i == 3 && j % 2 == 1)
							System.out.print("1 ");
						else
							System.out.print(" ");
				
			}
			System.out.println();
		}	
	}

}
