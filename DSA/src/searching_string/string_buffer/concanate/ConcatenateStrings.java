package searching_string.string_buffer.concanate;

public class ConcatenateStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"Hello", " ", "world", "!", " Have", " a", " nice", " day."};
        String result = concatenateUsingStringBuffer(input);
        System.out.println("Concatenated string: " + result);
	}

	private static String concatenateUsingStringBuffer(String[] input) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for(String s : input) {
			sb.append(s);
		}
		return sb.toString();
	}

}
