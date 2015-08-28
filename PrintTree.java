public class PrintTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(2);
		TreeNode rightLeft = new TreeNode(3);
		TreeNode rightRight = new TreeNode(2);
		TreeNode rightLeftLeft = new TreeNode(6);
		TreeNode rightLeftRight = new TreeNode(7);
		root.left = left;
		root.right =right;
		right.left = rightLeft;
		right.right = rightRight;
		rightLeft.left = rightLeftLeft;
		rightLeft.right = rightLeftRight;
		printTree(root);
	}
	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		int height = getHeight(root); // T : O(log(n))
		int branch = (int)Math.pow(2, height - 1) - 1;
		int width = (int)Math.pow(2, height) - 1;
		char[][] matrix = new char[height + branch][width]; // S: O(nlog(n))
		for (char[] m : matrix) { // T : O(nlog(n))
			Arrays.fill(m, ' ');
		}
		traverseTree(matrix, root, 0, 0, width - 1, height, 0);  
		printMatrix(matrix);
	}
	public static void traverseTree(char[][] matrix, TreeNode root, int idx, int start, int end, int height, int level) {
		int mid = start + (end - start) / 2;
		matrix[idx][mid] = (char)(root.val + '0');
		int offset = 1;
		int branch = (int)Math.pow(2, height - level - 2);
		for (int i = 0; i < branch; i++) {
			if (root.left != null) {
				matrix[idx + i + 1][mid - offset] = '/';
			}
			if (root.right != null) {
				matrix[idx + i + 1][mid + offset] = '\\';
			}
			offset++;
		}
		if (root.left != null) {
			traverseTree(matrix, root.left, idx + branch + 1, start, mid - 1, height, level + 1);
		}
		if (root.right != null) {
			traverseTree(matrix, root.right, idx + branch + 1, mid + 1, end, height, level + 1);
		}
	}
	private static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	private static void printMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}