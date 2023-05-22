package bll_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bl.HadBO;
import dal.HadithDAO;
/**
 * 
 * @author talha
 *
 */
class GetUniqueNarratorsAtLevelN_TestCases {
	static HadithDAO dao;
	static HadBO bo;
	static final String BOOK = "سنن النسائى الصغرى";
	static final int LEVEL = 1;

	@BeforeAll
	static void coldStart() {
		try {
			dao = new HadithDAO();
			bo = new HadBO(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("Test with valid book and level")
	void test1() {
		List<String> uniqueNarrators = bo.getUniqueNarratorsAtLevelN(BOOK, LEVEL);
		assertNotNull(uniqueNarrators, "Result should not be null");
		assertEquals(66, uniqueNarrators.size(), "Result size should be 11");
	}

	@Test
	@DisplayName("Test with invalid book")
	void test2() {
		List<String> uniqueNarrators = bo.getUniqueNarratorsAtLevelN("Invalid Book", LEVEL);
		assertNotNull(uniqueNarrators, "Result should not be null");
		assertEquals(0, uniqueNarrators.size(), "Result size should be 0");
	}

	@Test
	@DisplayName("Test with invalid level")
	void test3() {
		List<String> uniqueNarrators = bo.getUniqueNarratorsAtLevelN(BOOK, 99);
		assertNotNull(uniqueNarrators, "Result should not be null");
		assertEquals(0, uniqueNarrators.size(), "Result size should be 0");
	}
}