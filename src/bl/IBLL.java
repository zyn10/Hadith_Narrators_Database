package bl;
import java.util.ArrayList;
import java.util.List;

public interface IBLL {
	public ArrayList<String> narrateHadithsToGivenNarrator(String inputName);
	public ArrayList<String> narrateHadithsFromGivenNarrator(String inputName);
	public List<String> getUniqueNarratorsAtLevelN(String book, int level);

}
