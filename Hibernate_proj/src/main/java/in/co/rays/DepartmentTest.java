package in.co.rays;

import java.util.Iterator;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class DepartmentTest {

	public static void main(String[] args) {
		
		//testadd();
		testJoin();
		
		
	}

	private static void testJoin() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
		 Session s = sf.openSession();
		
		 List c = (List)s.createCriteria(User.class).setFetchMode("Department",FetchMode.JOIN).add(Restrictions.eq("Dept_ID", 1)).list();

		 Iterator it = c.iterator();
		 
		 while (it.hasNext()) {
			User d = (User) it.next();
			
			System.out.println(d.getId());
			System.out.println(d.getFname());
			
		}
		
	}

	private static void testadd() {
		
		Department dp = new Department();
		 dp.setDepartment("Client");
		 
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
		 Session s = sf.openSession();
		 
		 Transaction tx = s.beginTransaction();
		 
		 s.save(dp);
		 
		 tx.commit();
		 
		 s.close();
		 
		System.out.println("Inserted");
	}
}
