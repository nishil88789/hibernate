package in.co.rays;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Usertest {

	public static void main(String[] args) {
		// testadd();
		// testupdate();
		// testdelete();
		// testGet();
		// testList();
		// testColumn();
		// testCriteria();
		// testProjection();
		// testRestriction();
		testNameQuery();

	}

	private static void testNameQuery() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Query q = session.getNamedQuery("allUser");

		List<User> list = q.list();

		Iterator<User> it = list.iterator();

		while (it.hasNext()) {
			User user = it.next();

			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println(user.getDept_ID());

		}

	}

	private static void testRestriction() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("id", 3));

		criteria.add(Restrictions.ilike("Lname", "pawar"));

		ProjectionList p = Projections.projectionList();

		p.add(Projections.property("Fname"));

		p.add(Projections.property("Lname"));

		criteria.setProjection(p);

		List list = criteria.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			String o = (String) it.next();

			System.out.println(o);
		}

	}

	private static void testProjection() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(User.class);

		ProjectionList p = Projections.projectionList();

		p.add(Projections.property("Fname"));

		// p.add(Projections.property("Lname"));

		criteria.setProjection(p);

		List list = criteria.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			String o = (String) it.next();

			System.out.println(o);
		}

	}

	private static void testCriteria() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.like("Lname", "%sharma%"));
		List<User> list = criteria.list();

		Iterator<User> it = list.iterator();

		while (it.hasNext()) {
			User user = it.next();

			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
		}

	}

	private static void testColumn() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Query q = session.createQuery("select u.id, u.Fname from User u");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object[] o = (Object[]) it.next();
			System.out.println(o[0]);
		}

	}

	private static void testList() {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Query q = session.createQuery("from User");

		List<User> list = q.list();

		Iterator<User> it = list.iterator();

		while (it.hasNext()) {
			User user = it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());

		}

	}

	private static void testGet() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		User user = (User) s.get(User.class, 6);

		System.out.println(user.getId());
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getDept_ID());

		s.clear();

		User user1 = (User) s.get(User.class, 6);

		System.out.println(user1.getId());
		System.out.println(user1.getFname());
		System.out.println(user1.getLname());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPassword());
		System.out.println(user1.getDept_ID());

		s.close();

	}

	private static void testadd() {
		User user = new User();
		user.setFname("mann");
		user.setLname("Panwar");
		user.setUsername("mann@gmail.com");
		user.setPassword("12345");
		user.setDept_ID(1);

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionfactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(user);

		tx.commit();
		s.close();
		System.out.println("saveds");

	}

	private static void testupdate() {
		User user = new User();
		user.setId(3);
		user.setFname("Shiv ");
		user.setLname("Singh");
		user.setUsername("shiv@gmail.com");
		user.setPassword("4444");

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionfactory.openSession();
		Transaction tx = s.beginTransaction();

		s.update(user);

		tx.commit();
		s.close();
		System.out.println("updated");

	}

	private static void testdelete() {

		User user = new User();
		user.setId(3);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.delete(user);

		tx.commit();
		s.close();

		System.out.println("Deleted");
	}
}
