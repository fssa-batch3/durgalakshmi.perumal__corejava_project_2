package livre.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import livre.validation.UserValidator;

public class TestPassword {
	//valid password
		@Test
		public void testValidPassword() {

			assertTrue(UserValidator.validatePassword("Durga@123"));

		}
	//without SpecialCharacters
		@Test
		public void testInvalidPasswordWithoutSpecialCharacters() {
			assertFalse(UserValidator.validatePassword("Durga23"));

		}
	//Password  Without Numbers
		@Test
		public void testInvalidPasswordWithoutNumbers() {
			assertFalse(UserValidator.validatePassword("Durga@"));

		}
	//Password Without CapitalLetters
		@Test
		public void testInvalidPasswordWithoutCapitalLetters() {
			assertFalse(UserValidator.validatePassword("durga@123"));

		}
	//Password Without SmallLetters
		@Test
		public void testInvalidPasswordWithoutSmallLetters() {
			assertFalse(UserValidator.validatePassword("DURGA@123"));

		}
		//Password Shorter Length
		@Test
		public void testInvalidPasswordShorterLength() {
			assertFalse(UserValidator.validatePassword("du@123"));

		}
}
