package com.rev.excersizes;

public class nested {
	public static void main(String[] args) {
		
		class LocalClass{
			void message() {
				System.out.println("in local class");
			}
		}
		
		LocalClass lc = new LocalClass();
		lc.message();
		
		LocalClass anonymous = new LocalClass() {
			@Override
			void message() {
				System.out.println("overiding local class msg");
			}
		};
		
		anonymous.message();
	}
	int instancevar = 8;
	static int staticvar = 90;
	
	class instanceClass{
		void message() {
			System.out.println("in instance class method");
		}
	}
	
	static class StaticClass{
		void message() {
			System.out.println("in the static class messge method");
		}
	}
	
	
}

