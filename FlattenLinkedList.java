public class FlattenLinkedList {
	public Node solve(Node head) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		Node dummy = new Node(-1);
		dummy.next = head;
		Node pre = dummy;
		while (cur != null) {
			if (cur.opt != null) {
				Node opt = solve(cur.opt);
				Node tail = opt;
				while (tail.next != null) {
					tail = tail.next;
				}
				pre.next = opt;
				tail.next = cur;
				pre = cur;
				cur = cur.next;
			}
			else {
				pre = pre.next;
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}