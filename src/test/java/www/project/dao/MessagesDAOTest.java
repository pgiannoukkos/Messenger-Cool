package www.project.dao;

import org.junit.jupiter.api.Test;
import www.project.bean.Messages;
import www.project.bean.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessagesDAOTest {

	@Test
	void getMessages() {
		MessagesDAO dao = new MessagesDAO();
		UserDAO userDAO = new UserDAO();
		List<Messages> list = dao.getAllMessages(1, 3);

		for (Messages message: list) {
			User sender = userDAO.getUser(message.getSender());
			User receiver = userDAO.getUser(message.getReceiver());
			System.out.println(sender.getFirstName() + " to " + receiver.getFirstName() + " : " + message.getMsg());
		}
	}

}