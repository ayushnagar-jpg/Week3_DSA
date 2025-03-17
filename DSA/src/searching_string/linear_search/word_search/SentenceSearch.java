package searching_string.linear_search.word_search;

public class SentenceSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] sentences = {
		            "Java is a powerful language.",
		            "Python is great for data science.",
		            "C++ is used for system programming.",
		            "I love solving problems in Java."
		        };

		        String wordToFind = "Java";
		        String result = findSentenceWithWord(sentences, wordToFind);

		        System.out.println("Result: " + result);
	}

	private static String findSentenceWithWord(String[] sentences, String wordToFind) {
		// TODO Auto-generated method stub
		for(String word : sentences) {
			if(word.contains(wordToFind)) {
				return word;
			}
		}
		return "Not found";
	}

}
