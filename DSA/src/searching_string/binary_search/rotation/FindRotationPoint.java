package searching_string.binary_search.rotation;

public class FindRotationPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] rotatedArray = {15, 18, 2, 3, 6, 12};

	        int index = findRotationIndex(rotatedArray);
	        System.out.println("Rotation point index: " + index);
	        System.out.println("Smallest element: " + rotatedArray[index]);
	}

	private static int findRotationIndex(int[]arr) {
		// TODO Auto-generated method stub
		int left =0;
		int right = arr.length-1;
		while(left<right) {
			int mid = left +(right-left)/2;
			if(arr[mid]>arr[right]) {
				left = mid+1;
			}
			else {
				right = mid;
			}
		}
		return left;
	}

}
