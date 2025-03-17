package searching_string.linear_search.negative;

public class FirstNegativeSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] numbers = {5, 3, 8, -2, 6, -7};

	        int result = findFirstNegative(numbers);

	        if (result != -1) {
	            System.out.println("First negative number found at index: " + result);
	        } else {
	            System.out.println("No negative number found in the array.");
	        }
	}

	private static int findFirstNegative(int[] numbers) {
		// TODO Auto-generated method stub
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]<0) {
				return i;
			}
		}
		return -1;
	}

}
