package livre.service;
import static org.junit.jupiter.api.Assertions.*;
import livre.model.User;
import livre.services.exceptions.ServiceException;
import livre.services.UserService;

import org.junit.jupiter.api.Test;

public class TestRegisterFeature {
	@Test
	public void testRegistrationSuccess() throws ServiceException {
		UserService userService = new UserService();
		User user = new User("hariharan@gmail.com", "@Hari123");
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
