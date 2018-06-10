package ers.app;

import ers.service.ReimbursementService;
import ers.service.TypeService;

public class Run {

	public static void main(String[] args) {
		TypeService ts = new TypeService();
		ReimbursementService rs = new ReimbursementService();
		rs.modifyStatus(52, 21, 3);
		System.out.println("test2");
	}
}
