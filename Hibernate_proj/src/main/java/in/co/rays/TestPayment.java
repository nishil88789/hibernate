package in.co.rays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestPayment {

	public static void main(String[] args) {

		Cheque cheque = new Cheque();
		cheque.setId(1);
		cheque.setAmount(500);
		cheque.setCheqNo(23232);

		CreditCard card = new CreditCard();
		card.setId(2);
		card.setAmount(600);
		card.setCcType("Visa");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(cheque);
		session.save(card);

		tx.commit();

		session.close();

		System.out.println(" Inserted Done");

	}
}
