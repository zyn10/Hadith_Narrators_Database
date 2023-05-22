package dal_Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import dal.HadithDAO;
import to.Hadees;

public class Dal_Test_Cases {
	private Connection con;
	private HadithDAO dao;

	@Before
	public void setUp() throws Exception {
		String url = "jdbc:mysql://localhost:3306/dummyFour?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
		dao = new HadithDAO(con);
	}

	@After
	public void tearDown() throws Exception {
		con.close();
	}

	// =========================================================//
	// ====================Create Test Cases====================//
	// =========================================================//
	/**
	 * 
	 * @author zain
	 *
	 */
	@Test
	@DisplayName("Insertion Successfull")
	public void testInsertHadithSuccess() throws SQLException {

		Hadees hadith = new Hadees("Test Hadith", "Test Book", 1, "Test Matn", "Test Sanad", 10);
		HadithDAO hadithDAO = new HadithDAO();
		boolean result = hadithDAO.insertHadith(hadith);
		assertTrue(result);
	}

	@Test
	@DisplayName("Insertion Error")
	public void testInsertHadithNull() throws SQLException {

		HadithDAO hadithDAO = new HadithDAO();
		boolean result = hadithDAO.insertHadith(null);
		assertFalse(result);
	}

	// =========================================================//
	// ====================Read Test Case=======================//
	// =========================================================//
	/**
	 * 
	 * @author zain
	 *
	 */
	@Test
	@DisplayName("Hadiths Reading successfull")
	public void testGetHadiths() {
		ArrayList<String> hadiths = dao.getHadiths();
		assertNotNull(hadiths);
		assertTrue(hadiths.size() > 0);
	}

	// =========================================================//
	// ====================Update Test Cases====================//
	// =========================================================//
	/**
	 * 
	 * @author danish
	 *
	 */
	@Test
	@DisplayName("Updation Successfull")
	public void testUpdateHadithSuccess() throws SQLException {

		Hadees hadith = new Hadees("Test Hadith_3", "Test Book_3", 1, "Test Matn_3", "Test Sanad_3", 10, 12);
		HadithDAO hadithDAO = new HadithDAO();
		hadithDAO.insertHadith(hadith);
		hadith.setHadithDesc("Updated Test Hadith_3");
		hadith.setBook("Updated Book_3");
		boolean result = hadithDAO.updateHadith(hadith);
		assertTrue(result);
	}

	@Test
	@DisplayName("Updation Error")
	public void testUpdateHadithUnSuccessfull() throws SQLException {

		Hadees hadith = new Hadees(12000);
		HadithDAO hadithDAO = new HadithDAO();
		hadithDAO.insertHadith(hadith);
		hadith.setHadithDesc("Updated Test Hadith_3");
		hadith.setBook("Updated Book_3");
		boolean result = hadithDAO.updateHadith(hadith);
		assertFalse(result);
	}
	// =========================================================//
	// ====================Delete Test Cases=====================//
	// =========================================================//
	/**
	 * 
	 * @author danish
	 *
	 */
	@Test
	@DisplayName("Deletion Successfull")
	public void testDeleteHadithValid() throws SQLException {
		HadithDAO hadithDAO = new HadithDAO();
		Hadees obj_TO = new Hadees(11);
		boolean isDeleted = hadithDAO.deleteHadith(obj_TO);
		assertTrue(isDeleted);
	}

	@Test
	@DisplayName("Deletion Error")
	public void testDeleteHadithNull() throws SQLException {
		HadithDAO hadithDAO = new HadithDAO();
		boolean result = hadithDAO.deleteHadith(null);
		assertFalse(result);
	}

	// =========================================================//
	// ================Specific Book Test Cases=================//
	// =========================================================//
	/**
	 * 
	 * @author talha
	 *
	 */
	@DisplayName("hadiths from specific book")
	@Test
	public void testGetDataByBook() {
		String book = "سنن النسائى الصغرى";
		List<Hadees> dataList = dao.getDataByBook(book);
		assertNotNull(dataList);
		assertTrue(dataList.size() > 0);
		for (Hadees hadees : dataList) {
			assertEquals(hadees.getBook(), book);
		}
	}

	@DisplayName("Check Invalid Book Name")
	@Test
	public void testGetDataByBookInvalid() {
		String book = "غرى";
		List<Hadees> dataList = dao.getDataByBook(book);
		assertNotNull(dataList);
		assertTrue(dataList.isEmpty());
	}

}
