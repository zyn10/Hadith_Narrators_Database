package DateBefore;

public class MyDate {
	int days;
	int months;
	int years;

	public MyDate() {
	}

	public MyDate(int dd, int mm, int yy) {
		days = dd;
		months = mm;
		years = yy;
	}

	public boolean isBefore(MyDate d) {
		if(this.years>d.years) {
			return true;
			
		}
		return false;
	}
}
