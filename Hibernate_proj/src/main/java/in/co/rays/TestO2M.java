package in.co.rays;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestO2M {
	
	public static void main(String[] args) {
		
	

	AuctionItem item = new AuctionItem();
	item.setDescription("Iphone");

	
	Bid bid1 = new Bid();
	bid1.setAmount(500);
	
	Bid bid2 = new Bid();
	bid2.setAmount(600);
	
	Bid bid3 = new Bid();
	bid3.setAmount(700);
	
	Bid bid4 = new Bid();
	bid4.setAmount(8000);
	
	Set<Bid> set = new HashSet<Bid>();
	
	set.add(bid1);
	set.add(bid2);
	set.add(bid3);
	set.add(bid4);
	
	item.setBids(set);
	

	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

	Session s = sessionfactory.openSession();
	Transaction tx = s.beginTransaction();

	s.save(item);

	tx.commit();
	s.close();
	System.out.println("One to Many Done");

}
}