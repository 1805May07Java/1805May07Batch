import java.util.Arrays;

public class Accumul {
	
	public static void main(String[] args)
	{
		System.out.println(accum("HeLlLo"));
	}
	public static String accum(String s) {
		String out = "";
		for(int i = 0; i < s.length(); i++)
		{
			char upper = Character.toUpperCase(s.charAt(i));
			char lower = Character.toLowerCase(s.charAt(i));
			
			if(i != 0)
			{
				char[] lowerSubString = new char[i];
				Arrays.fill(lowerSubString, lower);
				out += "-" + upper + new String(lowerSubString);
			}
			else
			{
				out += upper;
			}
		}
		return out;
	}
}
