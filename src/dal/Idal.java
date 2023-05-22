package dal;

import java.util.ArrayList;
import java.util.List;

import to.Hadees;

public interface Idal {


	public boolean insertHadith(Hadees obj_TO);
	public boolean updateHadith(Hadees obj_TO);
	public boolean deleteHadith(Hadees obj_TO);
	
	public ArrayList<String> getHadiths();
	public List<Hadees> getDataByBook(String book);
}