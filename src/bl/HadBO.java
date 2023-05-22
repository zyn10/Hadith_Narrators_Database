package bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dal.Idal;
import to.Hadees;

/**
 * 
 * @author Talha
 *
 */

public class HadBO implements IBLL {
	private Idal dao;

	public HadBO(Idal dao) {
		this.dao = dao;
	}

	/**
	 * 
	 * @author zain
	 *
	 */

	public ArrayList<String> narrateHadithsToGivenNarrator(String inputName) {

		ArrayList<String> Row = new ArrayList<String>();
		ArrayList<String> narratorsList = new ArrayList<String>();

		Row = dao.getHadiths();// ----> get all rows here

		for (int i = 0; i < Row.size(); i++) {
			String[] NarratorsInOneRow = SplitNarrators(Row, i);
			for (int j = 0; j < NarratorsInOneRow.length - 1; j++) {
				String getOne = NarratorsInOneRow[j];
				if (getOne.equals(inputName) && !narratorsList.contains(NarratorsInOneRow[j + 1])) {
					narratorsList.add(NarratorsInOneRow[j + 1]);
				}
			}
		}
		return narratorsList;
	}

	/**
	 * 
	 * @author danish
	 *
	 */
	public ArrayList<String> narrateHadithsFromGivenNarrator(String inputName) {

		ArrayList<String> Row = new ArrayList<String>();
		ArrayList<String> narratorsList = new ArrayList<String>();
		Row = dao.getHadiths();// ----> get all rows here

		for (int i = 0; i < Row.size(); i++) {
			String[] NarratorsInOneRow = SplitNarrators(Row, i);
			for (int j = 0; j < NarratorsInOneRow.length - 1; j++) {
				String getOne = NarratorsInOneRow[j];
				if (getOne.equals(inputName) && !narratorsList.contains(NarratorsInOneRow[j + 1])) {
					narratorsList.add(NarratorsInOneRow[j - 1]);
				}
			}
		}
		return narratorsList;
	}

	/**
	 * 
	 * @author zain
	 *
	 */
	private String[] SplitNarrators(ArrayList<String> Row, int index) {
		String narrator_Row_with_Brackets = Row.get(index); // ---->getsingleRow
		String narrator_Row_without_Brackets = RemoveOuterBrackets(narrator_Row_with_Brackets).toString();
		String[] narratorsInOneRow = narrator_Row_without_Brackets.split(",");// ---->splitting by Commas
		return narratorsInOneRow;
	}
	/**
	 * 
	 * @author zain
	 *
	 */
	private String RemoveOuterBrackets(String narrator_Row) {
		StringBuilder NarratorsData = new StringBuilder(narrator_Row);
		NarratorsData.deleteCharAt(0);
		NarratorsData.deleteCharAt(NarratorsData.length() - 1);
		return narrator_Row;
	}

	/**
	 * 
	 * @author Talha
	 *
	 */

	@Override
	public List<String> getUniqueNarratorsAtLevelN(String book, int level) {
		List<Hadees> dataList = dao.getDataByBook(book);
		Map<String, Set<String>> narratorLevels = new HashMap<>();
		for (Hadees data : dataList) {
			String sanad = data.getSanad();
			String[] narrators = sanad.split(",");
			for (int i = 0; i < narrators.length; i++) {
				String narrator = narrators[i].trim();
				Set<String> levels = narratorLevels.get(narrator);
				if (levels == null) {
					levels = new LinkedHashSet<>();
					narratorLevels.put(narrator, levels);
				}
				levels.add(data.getBook() + "-" + data.gethadithNum() + "-" + (i + 1));
			}
		}
		List<String> uniqueNarrators = new ArrayList<>();
		for (Map.Entry<String, Set<String>> entry : narratorLevels.entrySet()) {
			String narrator = entry.getKey();
			Set<String> levels = entry.getValue();
			if (levels.size() == level) {
				uniqueNarrators.add(narrator);
			}
		}
		return uniqueNarrators;
	}
	

}