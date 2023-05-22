package to;

/**
 * 
 * @author Talha
 *
 */

public class Hadees {
	private int uid;
	private String hadithDesc;
	private String Book;
	private int hadithNum;
	private String Matn;
	private String Sanad;
	private int SanadLen;

	public Hadees( String Hadith, String Book, int hadithNum, String Matn, String Sanad, int SanadLen) {
		this.hadithDesc = Hadith;
		this.Book = Book;
		this.hadithNum = hadithNum;
		this.Matn = Matn;
		this.Sanad = Sanad;
		this.SanadLen = SanadLen;
	}
	public Hadees( String Hadith, String Book, int hadithNum, String Matn, String Sanad, int SanadLen,int uid) {
		this.uid = uid;
		this.hadithDesc = Hadith;
		this.Book = Book;
		this.hadithNum = hadithNum;
		this.Matn = Matn;
		this.Sanad = Sanad;
		this.SanadLen = SanadLen;
	}
	
	public Hadees(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int Id) {
		this.uid = Id;
	}

	public String getHadithDesc() {
		return hadithDesc;
	}

	public void setHadithDesc(String Hadith) {
		this.hadithDesc = Hadith;
	}

	public String getBook() {
		return Book;
	}

	public void setBook(String book) {
		this.Book = book;
	}

	public int gethadithNum() {
		return hadithNum;
	}

	public void sethadithNum(int hadith_Num) {
		this.hadithNum = hadith_Num;
	}

	public String getMatn() {
		return Matn;
	}

	public void setText(String mtn) {
		this.Matn = mtn;
	}

	public String getSanad() {
		return Sanad;
	}

	public void setSanad(String sand) {
		this.Sanad = sand;
	}

	public int getsanad_Length() {
		return SanadLen;
	}

	public void setsanad_Length(int sanad_Length) {
		this.SanadLen = sanad_Length;
	}

}