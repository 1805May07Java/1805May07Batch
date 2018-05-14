package com.ex.inheritance;

public class Dog extends Animal{
//Dog d = new Dog();
	public void wagTail() {}
	
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
	
	@Override
	public void stayinAlive() {
		System.out.println("dogs stay alive");
	}
	
	
	public static void main(String[] args) {
		Livable d = new Dog();
		d.stayinAlive();
		
		
		
		
		Animal originalHuman = new Dog() {

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
			
			public void test() {
				System.out.println("testing");
			}
			
		};
		
		originalHuman.consume();
		originalHuman.reproduce();
		//originalHuman.test();
	//	originalHuman.wagTail();
		
		
	}

}
