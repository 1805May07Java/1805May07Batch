package app;

import org.hibernate.Session;

public class Test {

	public static void main(String[] args){


		try{
			Session session = HibernateUtility.getSessionFactory().openSession();	
			session.beginTransaction();
			session.clear();

			//Fetch for the first time (Database)
			int id = 209;
			Employee employee = (Employee)session.load(Employee.class, id);
			System.out.println(employee.toString());


			//Fetch for the second time (First Level Cache)
			employee = (Employee)session.load(Employee.class, id);
			System.out.println(employee.toString());

			//Close the session
			session.getTransaction().commit();
			session.close();

			//New session
			Session session2 = HibernateUtility.getSessionFactory().openSession();	
			session2.beginTransaction();

			//Fetch for the third time (EH Cache)
			employee = (Employee)session2.load(Employee.class, id);
			System.out.println(employee.toString());

			session2.getTransaction().commit();
			session2.close();
			
		}catch(Exception ex){
			ex.printStackTrace();

		}finally{
			long dbhit = HibernateUtility.getSessionFactory().getStatistics().getEntityFetchCount();
			long L2hit = HibernateUtility.getSessionFactory().getStatistics().getSecondLevelCacheHitCount();
			System.out.println("Trips to the database = " + dbhit);
			System.out.println("Trips to the EH cache = " + L2hit);
		}

	}

}
