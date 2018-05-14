import java.lang.reflect.*;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class ReflectionDemo {

	interface TypeHandler {
		void handleType(Object self, Scanner input, Field f) throws IllegalArgumentException, IllegalAccessException; 
	}
	
	static Map<Class<?>, TypeHandler> validTypes = new TreeMap<>(new Comparator<Class<?>>() {

		@Override
		public int compare(Class<?> arg0, Class<?> arg1) {
			return arg0.getName().compareTo(arg1.getName());
		}
		
	});
	
	static {
		validTypes.put(String.class, (self, input, f) -> {
			System.out.printf("%s: ", f.getName());
			f.set(self, input.nextLine());
		});
		
		validTypes.put(Integer.class, (self, input, f) -> {
			System.out.printf("%s: ", f.getName());
			f.set(self, Integer.parseInt(input.nextLine()));
		});

		validTypes.put(Float.class, (self, input, f) -> {
			System.out.printf("%s: ", f.getName());
			f.set(self, Float.parseFloat(input.nextLine()));
		});

	}
	
	private String name;
	private Integer age;
	private Float height;
	
	
	public static void main(String[] args) {
		
		ReflectionDemo rd = new ReflectionDemo();
		
		rd.loadValues();
		
		System.out.println();
		System.out.print(rd.toString());
		
	}

	public void loadValues() {

		Field[] attributes = this.getClass().getDeclaredFields();
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < attributes.length; i++) {
			Field f = attributes[i];
			
			if (Modifier.isFinal(f.getModifiers())) {
				continue;
			}
			
			boolean repeat = loadAttribute(s, f);
			
			if (repeat) {
				i--;
			}
			
		}
		
		s.close();
		
	}

	private boolean loadAttribute(Scanner s, Field f) {
		
		boolean repeat = false;
		
		try {
			
			TypeHandler th = validTypes.get(f.getType());
			
			if (th != null) {
				th.handleType(this, s, f);
			}
			
		} catch (InputMismatchException | NumberFormatException e) {
			System.out.println("Error, invalid format.");
			repeat = true;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// do nothing
		}
		
		return repeat;
		
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (Field f : this.getClass().getDeclaredFields()) {
			
			
			try {
				
				if (Modifier.isStatic(f.getModifiers())) {
					continue;
				}
				
				String value = f.get(this).toString();
				
				result.append(f.getName());
				result.append(": ");
				result.append(value);
				result.append('\n');
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
		return result.toString();
	}
	
}
