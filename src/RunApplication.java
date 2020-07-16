package techmojo.tweets.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunApplication {

	private static String filePath = "src\\resources\\tweets\\tweets.txt";

	private static int noOfTopHashTags = 10; // Change this to show no of top
												// tweets to be displayed

	public static void main(String args[]) {
		List<String> hashTags = null;
		String onlyHashTags = "";
		try {
			File tweetFile = new File(filePath);
			Scanner tweetReader = new Scanner(tweetFile);
			while (tweetReader.hasNextLine()) {

				String tweet = tweetReader.nextLine();
				hashTags = Utils.getHashTags(tweet);

				for (String hashTag : hashTags) {
					onlyHashTags = onlyHashTags + hashTag + " ";
				}
			}

			System.out.println(onlyHashTags);
			tweetReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File is not present at specified location please check location of file");
		}

		HashMap<String, Integer> countFrequencyHashTags = new HashMap<>();
		HashMap<String, Integer> sortByFrequencyHashTags = new HashMap<>();
		countFrequencyHashTags = Utils.countFrequencyHashTags(onlyHashTags);
		System.out.println(countFrequencyHashTags);
		sortByFrequencyHashTags = Utils.sortByFrequency(countFrequencyHashTags);
		System.out.println(sortByFrequencyHashTags);
		Utils.printTopHashTag(sortByFrequencyHashTags, noOfTopHashTags);
		System.out.println("\nWant to see all hash tags?");
		Scanner s = new Scanner(System.in);
		String option = s.nextLine();
		if (option != null && "yes".equals(option.toLowerCase()) || "y".equals(option.toLowerCase())) {
			Utils.printTopHashTag(sortByFrequencyHashTags, sortByFrequencyHashTags.size());
		}
	}
}
