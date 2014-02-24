import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class WordDictionary {
	Set<String> dictionary = new HashSet<String>();
	
	public WordDictionary() {
		File folder = new File("./src/words");
		for (File file : folder.listFiles())
			loadDictionary(file);
	}
	
	private void loadDictionary(File file) {
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			String word;
			while (scanner.hasNext()) {
				word = scanner.next();
				dictionary.add(word.toLowerCase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean contains(String word) {
		return dictionary.contains(word);
	}
}
