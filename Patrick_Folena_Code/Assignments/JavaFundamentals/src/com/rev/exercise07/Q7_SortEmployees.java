package com.rev.exercise07;

public class Q7_SortEmployees{
	
	public static void main(String[] args)
	{
		Q7_SortEmployees main = new Q7_SortEmployees();
		
		Employee[] contractList = new Employee[6];
		
		contractList[0] = new Employee("Folena", "Patrick", "Engineer", 25);
		contractList[1] = new Employee("Stuart", "Joseph", "Architect", 23);
		contractList[2] = new Employee("Folena", "Lenn", "Artist  ", 24);
		contractList[3] = new Employee("Delta", "Patrick", "Manager ", 30);
		contractList[4]= new Employee("Comwell", "Thomas", "Engineer", 28);
		contractList[5] = new Employee("Bunson", "Booker", "Writer  ", 25);
		
		main.printTable(contractList);
		main.sortList(contractList, "LastName");
		main.printTable(contractList);
		main.sortList(contractList, "FirstName");
		main.printTable(contractList);
		main.sortList(contractList, "Department");
		main.printTable(contractList);
		main.sortList(contractList, "Age");
		main.printTable(contractList);
	}
	
	public void sortList(Employee[] list, String sortBy)
	{
		Employee temp;
		int a = 0;
		int z = list.length-1;
		while(a != z-1)
		{
			for(;a < z; a++)
			{
				int compare = list[a].compareTo(list[a+1], sortBy);
				if(compare == 1)
				{
					temp = list[a];
					list[a] = list[a+1];
					list[a+1] = temp;
				}
				else if(compare == 0 && list[a].compareTo(list[a+1]) == 1)
				{
					temp = list[a];
					list[a] = list[a+1];
					list[a+1] = temp;
				}
			}
			a = 0;
			z--;
		}
	}
	
	public void printTable(Employee[] list)
	{
		System.out.println("Order\tLast Name\tFirst Name\tDepartment\tAge");
		System.out.println("--------------------------------------------------------------------------------------");
		for(int x = 0; x < list.length; x++)
		{
			System.out.print((x+1) + "\t");
			printEmployee(list[x]);
		}
		System.out.println("======================================================================================");
	}
	
	public void printEmployee(Employee emp)
	{
		System.out.println(emp.getLastName() + "\t\t" + emp.getFirstName() + "\t\t" + emp.getDepartment() + "\t" + emp.getAge());
	}
}