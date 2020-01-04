package www.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import www.project.bean.User;

import java.time.LocalDate;
import java.util.List;

public class UserDAO {

	public void createUser(String firstName, String lastName, String username, String email, String password,
						   LocalDate birthDate) {
		try {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setBirthDate(birthDate);
			session.save(user);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}

	public boolean userExists(String userName, String email) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		String hql = "SELECT username, email FROM user WHERE username=:username OR email=:email";
		NativeQuery query = session.createSQLQuery(hql);
		query.setParameter("username", userName);
		query.setParameter("email", email);

		List res = query.list();

		if (!res.isEmpty()) {
			System.out.println("\n\n User Exists \n");
			session.close();
			sessionFactory.close();
			return true;
		}

		session.close();
		sessionFactory.close();
		return false;
	}
}
