public class FindAPlusBEqualsToCPlusD {
	public static int[] solve2(int[] nums) {
		if (nums == null || nums.length < 4) {
			return new int[]{-1, -1, -1, -1};
		}
		boolean[] used = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			used[i] = true;
			for (int j = i + 1; j < nums.length; j++) {
				used[j] = true;
				int[] sum = twoSum(nums, nums[i] + nums[j], used);
				if (sum[0] == -1) {
					used[j] = false;
					continue;
				}
				else {
					int[] ret = new int[]{i, j, sum[0], sum[1]};
					Arrays.sort(ret);
					return ret;
				}
			}
			used[i] = false;
		}
		return new int[]{-1, -1, -1, -1};
	}
}