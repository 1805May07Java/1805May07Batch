package MultiplePackages;

import com.rev.mulpack.FloatHolder;

public class FloatGetter {

	public static void main(String[] args) {
		FloatHolder fh = new FloatHolder();
		
		float localFloat1 = fh.f1;
		float localFloat2 = fh.f2;
		
		System.out.println(localFloat1);
		System.out.println(localFloat2);

	}

}
