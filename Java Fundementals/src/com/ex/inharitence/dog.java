package com.ex.inharitence;

public class dog extends Animal{

	public void wagTail() {
		
	}
	
	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int reproduce() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void stayinAlive() {
		System.out.println("dogs stay alive");
	}
	
	
	
	
	public static void main(String[] args) {
		Livable d = new dog();
		d.stayinAlive();
		
		
		/*Animal originalHuman = new Animal() {

			@Override
			public void breathe() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void consume() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int reproduce() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};*/
	}
}
