package searching_string.string_builder.reverse;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "hello";
		String reversed = reversedUsingStringBuilder(input);
		System.out.println("Reversed string: " + reversed);
	}

	private static String reversedUsingStringBuilder(String input) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		sb.reverse();
		return sb.toString();
	}

}
