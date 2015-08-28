public class ConvertTreeToDoubleLinkedList {
	public TreeNode convertTreeToDoubleLinkedList(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode head = root;
		TreeNode tail = root;
		if (root.left != null) {
			TreeNode left = convertTreeToDoubleLinkedList(root.left);
			head = left;
			left.left.right = root;
			root.left = left.left;
		}
		if (root.right != null) {
			TreeNode right = convertTreeToDoubleLinkedList(root.right);
			tail = right.left;
			root.right = right;
			right.left = root;
		}
		head.left = tail;
		tail.right = head;
		return head;
	}
}