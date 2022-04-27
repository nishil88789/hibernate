package in.co.rays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {

	public static void main(String[] args) {
		
		Employee m = new  Employee();
		m.setFirstname("Rahul");
		m.setLastname("Gupta");

		Address add = new Address();
		
		add.setState("MP");
		add.setStreet("Vijay Nagar");
		add.setCity("Indore");
		m.setEmpdAdd(add);
		

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionfactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(m);

		tx.commit();
		s.close();
		System.out.println("One to One Done");
	}
}
