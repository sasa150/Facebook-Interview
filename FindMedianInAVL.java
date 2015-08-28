public class FindMedianInAVL {
	public static double findMedian(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int treeSize = countSize(root);
		if (treeSize % 2 == 0) {
			return (findKth(root, (treeSize + 1) / 2) + findKth(root, (treeSize + 1) / 2 + 1)) / 2;
		}
		else {
			return findKth(root, (treeSize + 1) / 2);
		}
	}
	
	public static double findKth(TreeNode root, int k) {
		int leftSize = countSize(root.left);
		if (k <= leftSize) {
			return findKth(root.left, k);
		}
		if (k == leftSize + 1) {
			return (double)root.val;
		}
		return findKth(root.right, k - leftSize - 1);
		
	}
	
	public static int countSize(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSize = countSize(root.left);
		int rightSize = countSize(root.right);
		return leftSize + 1 + rightSize;
	}
}