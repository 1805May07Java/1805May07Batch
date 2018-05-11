
public class Singelton {

	private static Singelton instance = new Singelton();
	
	private Singelton() {
		
	}
	
	static Singelton getInstance() {
		
		if (instance == null) {
			instance = new Singelton();
		}
		
		return instance;
	}
	
}
