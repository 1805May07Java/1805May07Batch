
public class App {
public static void main(String [] agrs) throws InterruptedException {
	Header();
	loadScreen();
	Ad();
	menuLogin();
	

	        

 
	        
	        
	
}

private static void loadScreen() throws InterruptedException {
	// TODO Auto-generated method stub
	display("Loading Screen Please Wait.........\r\n\r\n");
	Thread.sleep(5000);
}

private static void menuLogin() {
	// TODO Auto-generated method stub
	   
    display("Let's Get Started Choose form the list below:\r\n"
    + "1.   Login\r\n"
    + "2.   Sign-Up\r\n"
    + "Please Enter, Type in a #:"
    );	
}

private static void Ad() {
	// TODO Auto-generated method stub
    display("                      Access Your Banking Needs via Console\r\n\r\n"+
	        "                         Feature Include:\r\n\r\n"
	        + "                           *Desposit/Withdraw Money\r\n"
	        + "                           *Check you Balance\r\n"
	        + "                           *Create Accounts\r\n"
	        + "\r\n"
	        + "\r\n");	
}

private static void Header() {
	// TODO Auto-generated method stub
	display("#ACME Banking Solutions\r\n"+
		    "     #   ||_  \r\n" + 
			"     #  (_-< \r\n" +   
			"     #  / _/ \r\n" + 
			"     #   ||    \r\n"+
	        "     #          \r\n"+
	        "     Welcome!!!    \r\n"
	        + "\r\n"
	        + "\r\n"
	        + "\r\n");
}

private static void display(String string) {
	// TODO Auto-generated method stub
	System.out.println(string);
}
}
