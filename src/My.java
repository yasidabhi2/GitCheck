import java.util.ArrayList;
import java.util.List;

public class My {
	public static void main(String[] args) {
		String text = "#Java is #object oriented #language";
		List<String> hashTags;
		// List<String> words = Arrays.asList(text.split("\\s+"));
		String words[] = text.split("\\s+");
		List<String> wordWithHash = new ArrayList<String>();
		for (String word : words) {
			if (word.charAt(0) == '#') {
				wordWithHash.add(word);
			}
		}
		System.out.println(wordWithHash);
	}
}
