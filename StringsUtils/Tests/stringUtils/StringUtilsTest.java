package stringUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

	private static StringUtils utils;

	@BeforeAll
	static void coldStart() {
		utils = new StringUtils();
	}

	@Test
	@DisplayName("All uppercase letters")
	void testIsUpperCase() {
		Assertions.assertTrue(utils.isUpperCase("AAA"));
	}

	@Test
	@DisplayName("Some uppercase letters")
	void testIsUpperCase2() {
		Assertions.assertFalse(utils.isUpperCase("AbbC"));
	}

	@Test
	@DisplayName("All lowercase letters")
	void testIsUpperCase3() {
		Assertions.assertFalse(utils.isUpperCase("mmmmmmm"));
	}
	@Test
	@DisplayName("All lowercase letters")
	void testIsUpperCase4() {
		Assertions.assertFalse(utils.isUpperCase("zain.ahsan@nu.edu.pk"));
	}
	@Test
	@DisplayName("All Uppercase letters")
	void testIsUpperCase5() {
		Assertions.assertTrue(utils.isUpperCase("ZAIN.AHSAN@NU.EDU.PK"));
	}
	@Test
	@DisplayName("Check Emptiness")
	void testIsEmpty() {
		Assertions.assertFalse(utils.isEmpty("mmmmmmm"));
	}
	@Test
	@DisplayName("Check Emptiness 2")
	void testIsEmpty2() {
		Assertions.assertTrue(utils.isEmpty(""));
	}

}
