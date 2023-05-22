package dal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import to.Hadees;
/**
 * 
 * @author Talha
 *
 */

public class DAO_Stub implements Idal {

	private Hashtable<Integer, Hadees> table;

	public DAO_Stub() {
		table = new Hashtable<Integer, Hadees>();

		Hadees hadith1 = new Hadees(
				
				"عن النبي صلى الله عليه وسلم ، قال",
				"صحيح مسلم",
				53,
				" الإيمان بضع وسبعون شعبة ",
				" والحيا شعبة من الإيمان",
				6,
				7);
		table.put(1, hadith1);

	}


	@Override
	public boolean insertHadith(Hadees obj_TO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHadith(Hadees obj_TO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHadith(Hadees obj_TO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> getHadiths() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hadees> getDataByBook(String book) {
		// TODO Auto-generated method stub
		return null;
	}

}