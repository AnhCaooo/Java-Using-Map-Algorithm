package mapProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ObjectsLanguageTranslationMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		Map<Integer, wordPair> wordTrans = new HashMap<Integer, wordPair>();

		String englishWord;
		String finnishWord;
		String foundEnglishWord;
		int i = -1;

		System.out.println("=== Creating an English-Finnish dictionary (ok ends) ===");

		do {
			System.out.print("Enter an English word: ");
			englishWord = input.nextLine();

			if (englishWord.equals("ok")) {
				System.out.println();
				System.out.println("=== English-Finnish translation service (quit ends) ===");
			} else {
				i++;
				System.out.print("Enter a Finnish word: ");
				finnishWord = input.nextLine();

				wordTrans.put(i, new wordPair(englishWord, finnishWord));
				System.out.println();
			}
		} while (!englishWord.equals("ok"));

		do {
			System.out.print("Enter an English word: ");
			foundEnglishWord = input.nextLine();

			if (foundEnglishWord.equals("quit")) {
				System.out.println("Bye!");
			} else {

				boolean checkWord = false; 
				for (wordPair wordObj : wordTrans.values()) {

					if (wordObj.getEnglishWord().equals(foundEnglishWord)) {
						System.out.println(wordObj.getFinnishWord());
						checkWord = true; 
						System.out.println();

					}

				}
				if(checkWord == false) {
					System.out.println("Unknown word");
					System.out.println();
				}
					
				
			}

		} while (!foundEnglishWord.equals("quit"));

	}
}
