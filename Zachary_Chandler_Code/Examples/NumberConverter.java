import java.util.Scanner;

public class NumberConverter {

	public static void main(String[] args) {

		int value = -1;
		boolean error = false;
		String sValue = getNumberFromUser();
		
		try {
			value = parseInt(sValue);
		} catch (NumberFormatException e) {
			System.out.println("Could not understand number.");
			error = true;
		}
		
		if (!error) {
			displayInt(value);
		}
	}

	private static String getNumberFromUser() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		String sValue = s.nextLine();
		
		s.close();
		return sValue;
	}

	private static void displayInt(int value) {
		System.out.printf("Dec: %d\n", value);
		System.out.printf("Hex: 0x%X\n", value);
		System.out.printf("Oct: 0%o\n", value);
		System.out.printf("Binary: 0b%s\n", Integer.toBinaryString(value));
	}

	private static int parseInt(String sValue) {
		int value;
		
		try {
			value = Integer.decode(sValue);
		} catch (NumberFormatException e) {
			if (sValue.startsWith("0b")) {
				value = parseBinaryString(sValue.substring(2));
			} else {
				throw new NumberFormatException();
			}
		}
		
		return value;
	}

	private static int parseBinaryString(String binary) {
		int value = 0;
		
		if (binary.length() > 32) {
			System.out.println("Number too large.");
			throw new NumberFormatException();
		}
		
		for (int i = 0; i < binary.length(); i++) {
			value <<= 1;
			
			if (binary.charAt(i) == '1') {
				value |= 1;
			} else if (binary.charAt(i) !=  '0') {
				throw new NumberFormatException();
			}
		}
		
		return value;
	}
	
}
