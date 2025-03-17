package searching_string.string_builder.remove_duplicate;

import java.util.HashSet;

public class RemoveDuplicate {
	public static void main(String[]args) {
		String input = "programming";
        String noDuplicates = removeDuplicates(input);
        System.out.println("Without duplicates: " + noDuplicates);
	}

	private static String removeDuplicates(String input) {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		HashSet<Character>seen = new HashSet<>();
		for(char ch : input.toCharArray()) {
			if(!seen.contains(ch)) {
				seen.add(ch);
				result.append(ch);
			}
		}
		return result.toString();
	}
}
