package MyDateTests;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import DateBefore.MyDate;

class DateTests {
	
	private static MyDate date;
	@BeforeAll
	static void coldStart() {
		date = new MyDate();
	}

	@Test
	@DisplayName("Is Before")
	void testIsBefore() {
		MyDate d1 = new MyDate(2012,10,1);
		MyDate d2 = new MyDate(2013,9,2);	
		Assertions.assertTrue(d1.isBefore(d2));
	}

}
