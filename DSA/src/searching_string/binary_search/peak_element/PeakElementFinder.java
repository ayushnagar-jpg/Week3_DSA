package searching_string.binary_search.peak_element;

public class PeakElementFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element is: " + arr[peakIndex] + " at index " + peakIndex);
	}

	private static int findPeakElement(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
        int left = 0;
        int right = n - 1;
        while(left < right) {
        	int mid = left +(right - left)/2;
        	boolean isLeftSmaller = (mid == 0) || (arr[mid]>arr[mid-1]);
        	boolean isRightSmaller = (mid == n - 1) || (arr[mid] >= arr[mid + 1]);
        	 if (isLeftSmaller && isRightSmaller) {
                 return mid; // Peak found
             }
        	 if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                 left = mid + 1;
             }
             // Else move left
             else {
                 right = mid - 1;
             }
        }
		return -1;
	}

}
