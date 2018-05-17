package com.rev.ui;

public class App {
	
    public static void main(String[] args) {
		ConsoleUI ui = new ConsoleUI(System.in, System.out);
		ui.start();
		ui.close();
    }
}
