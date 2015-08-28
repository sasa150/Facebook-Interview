public class TaskArrangementII {
	public static class Node {
		char letter;
		int num;
		public Node(char letter, int num) {
			this.letter = letter;
			this.num = num;
		}
		public static Comparator<Node> NodeComparator = new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return b.num - a.num;
			}
		};
	}
	public static int getShortestTime(String task, int k) {
		if (task == null || task.length() == 0) {
			return 0;
		}
		if (k == 0) {
			return task.length();
		}
		Map<Character, Node> count = new HashMap<Character, Node>();
		for (int i = 0; i < task.length(); i++) {
			if (count.containsKey(task.charAt(i))) {
				count.get(task.charAt(i)).num++;
			}
			else {
				count.put(task.charAt(i), new Node(task.charAt(i), 1));
			}
		}
		PriorityQueue<Node> queue = new PriorityQueue<Node>(count.size(), Node.NodeComparator);
		Map<Character, Integer> lastTime = new HashMap<Character, Integer>();
		for (char letter : count.keySet()) {
			queue.offer(count.get(letter));
			lastTime.put(count.get(letter).letter, -1);
		}
		int ret = 0;
		StringBuilder result = new StringBuilder();
		while (!queue.isEmpty()) { 
			List<Node> notValid = new ArrayList<Node>();
			Node cur;
			while (!queue.isEmpty() && !isValid(ret, lastTime.get(queue.peek().letter), k)) { // worstcase : nlog(n)
				Node tmp = queue.poll();
				notValid.add(tmp);
			}
			if (queue.isEmpty()) {
				result.append(" ");
				ret++;
			}
			else {
				cur = queue.poll();
				cur.num--;
				lastTime.put(cur.letter, ret);
				if (cur.num != 0) {
					queue.add(cur);
				}
				result.append(cur.letter);
				ret++;
			}
			for (Node node : notValid) { // worstCase: nlog(n)
				queue.add(node);
			}
		}
		System.out.println(result.toString());
		return ret;
	}
	
	private static boolean isValid(int curTime, int lastTime, int k) {
		if (lastTime == -1) {
			return true;
		}
		return curTime - lastTime > k;
	}
}