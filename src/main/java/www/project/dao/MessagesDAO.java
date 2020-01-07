package www.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import www.project.bean.Friendship;
import www.project.bean.Messages;

import java.sql.Timestamp;

public class MessagesDAO {

	public void createFriendship(int sender, int receiver, String msg) {

		try {
			// Configure Hibernate
			Configuration configuration = new Configuration().configure();

			// Create SessionFactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// Get Session object
			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			Messages messages = new Messages();
			messages.setReceiver(receiver);
			messages.setReceiver(sender);
			messages.setMsg(msg);
			messages.setTimestamp(new Timestamp(System.currentTimeMillis()));

			session.save(messages);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		}catch(HibernateException ex) {
			System.out.println(ex.getMessage());
			System.out.println("error");
		}
	}

}
