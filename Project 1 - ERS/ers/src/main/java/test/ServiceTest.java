package test;

import reimburse.service.Service;

public class ServiceTest {
	public static void main(String[] args) {
		Service service = new Service();
		int fail = service.register("alexmoon", "password", "alex", "moon", "amo@gmail.com", "employee");
		System.out.println(fail);
		int log = service.login("alexmoon", "password");
		System.out.println(log);
		
	}
}
