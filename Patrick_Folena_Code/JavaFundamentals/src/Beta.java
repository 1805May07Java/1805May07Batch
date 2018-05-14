class Baap
{
	public int h = 4;
	public int getH() 
	{
		System.out.println("Baap " + h);
		return h;
	}
}

public class Beta extends Baap
{
	public int h = 44;
	public int getH() 
	{
		System.out.println("Beta " + h);
		return h;
	}

public static void main(String[] args) {
	
}

//b.h = 4
//bb.h = 44
//b.getH() = Beta 44 \n 44
//bb.getH() = Beta 44 \n 44
}
