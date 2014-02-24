	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordJumble {
	public static void main(String[] args) {
		WordGenerator generator = new WordGenerator(new WordDictionary());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.print("Please enter a string: ");
			try {
				String input = br.readLine();
				System.out.println(generator.getWords(input));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
