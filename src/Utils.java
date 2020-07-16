
/*
 * Author: Abhishek Gupta
 * Class name: Utils.java
 * Date: 15th July2020
 * Purpose: This class contain diffrent method used as helper method
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Utils {
	/*
	 * This methord will return list of hash tag in each line
	 */

	public static List<String> getHashTags(String text) {
		String words[] = text.split("\\s+");
		List<String> hashTags = new ArrayList<String>();
		for (String word : words) {
			if (word.charAt(0) == '#') {
				hashTags.add(word);
			}
		}
		return hashTags;
	}

	public static HashMap<String, Integer> countFrequencyHashTags(String hashTag) {
		HashMap<String, Integer> frequency = new HashMap<>();
		String hashTags[] = hashTag.split("#");
		for (String key : hashTags) {
			System.out.println(key);
			if (key.isEmpty()) {

			} else if (frequency.containsKey(key)) {
				frequency.put(key, frequency.get(key) + 1);
			} else {
				frequency.put(key, 1);
			}
		}
		System.out.println(frequency);
		return frequency;

	}

	public static HashMap<String, Integer> sortByFrequency(HashMap<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new SortByFrequency());

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		// System.out.println(temp);
		return temp;
	}

	public static void printTopHashTag(HashMap<String, Integer> hm, int noOfTopHashTags) {
		Iterator it = hm.entrySet().iterator();
		while (it.hasNext() && noOfTopHashTags > 0 ) {
			Map.Entry obj = (Entry) it.next();
			System.out.println("HashTags ----> " + obj.getKey() + " " + "Frequency ----> " + obj.getValue());
			noOfTopHashTags--;
		}
	}
}
