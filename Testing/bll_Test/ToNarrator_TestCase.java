package bll_Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bl.HadBO;
import dal.HadithDAO;
/**
 * 
 * @author danish
 *
 */
class ToNarrator_TestCase {
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
		Assertions.assertEquals("[ 'ومنصور']", bo.narrateHadithsToGivenNarrator(" 'سليمان'").toString());
	}
	@Test
	@DisplayName("Narrator Not found")
	void test2() {
		Assertions.assertEquals("[]", bo.narrateHadithsToGivenNarrator(" 'زین احسن'").toString());
	}
	@Test
	@DisplayName("Last Name")
	void test3() {
		Assertions.assertEquals("[]", bo.narrateHadithsToGivenNarrator(" 'عائشة'").toString());
	}
	@Test
	@DisplayName("Mulitple Narrators")
	void test4() {
		Assertions.assertEquals("[ 'الزهري',  'لجابر',  'المقدام بن شريح']", bo.narrateHadithsToGivenNarrator(" 'سفيان'").toString());
	}

}
