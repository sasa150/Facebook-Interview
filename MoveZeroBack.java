public class MoveZeroBack {
	public static void moveZeroBack(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[end] == 0) {
				end--;
				continue;
			}
			if (nums[start] != 0) {
				start++;
				continue;
			}
			swap(nums, start, end);
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	private static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}