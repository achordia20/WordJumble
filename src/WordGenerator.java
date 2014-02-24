import java.util.HashSet;
import java.util.Set;


public class WordGenerator {
	private WordDictionary dict = null;
	private Set<String> words = new HashSet<String>();
	
	public WordGenerator(WordDictionary dict) {
		this.dict = dict;
	}
	
	private void generateWords(StringBuffer pre, String rem) {
		if (rem.length() == 1) {
			String word = pre.toString() + rem;
			if (dict.contains(word))
				words.add(word);
			return;
		}
		
		char[] letters = rem.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			StringBuffer word = new StringBuffer(pre.toString());
			word.append(letters[i]);
			
			String potential = word.toString();
			if (dict.contains(potential))
				words.add(potential);
			
			String newRem = rem.substring(0, i) + rem.substring(i + 1);
			generateWords(word, newRem);
		}
	}
	
	public Set<String> getWords(String s) {
		words.clear();
		generateWords(new StringBuffer(), s.toLowerCase());
		return words;
	}
}
