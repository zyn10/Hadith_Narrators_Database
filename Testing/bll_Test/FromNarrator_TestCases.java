package bll_Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bl.HadBO;
import dal.HadithDAO;
/**
 * 
 * @author zain
 *
 */
class FromNarrator_TestCases {
	static HadithDAO obj;
	static HadBO bo;

	@BeforeAll
	static void coldStart() {

		try {
			obj = new HadithDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bo = new HadBO(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("Narrator Found")
	void test1() {
		Assertions.assertEquals("[ 'إسماعيل']", bo.narrateHadithsFromGivenNarrator(" 'حميد'").toString());
	}
	@Test
	@DisplayName("Narrator Not found")
	void test2() {
		Assertions.assertEquals("[]", bo.narrateHadithsFromGivenNarrator(" 'زین احسن'").toString());
	}
	@Test
	@DisplayName("First Name")
	void test3() {
		Assertions.assertEquals("[]", bo.narrateHadithsFromGivenNarrator(" 'علي بن حجر'").toString());
	}
	@Test
	@DisplayName("Multiple Narrators found")
	void test4() {
		Assertions.assertEquals("[['قتيبة بن سعيد',  'سالم بن أبي الجعد',  'عبد الرحمن']", bo.narrateHadithsFromGivenNarrator(" 'سفيان'").toString());
	}
	
}
