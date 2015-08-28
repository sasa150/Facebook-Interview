public class TaskArrangeMentI {
	public static int getTime(String task, int k) {
		if (task == null || task.length() == 0) {
			return 0;
		}
		if (k == 0) {
			return task.length();
		}
		Map<Character, Integer> lastTime = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < task.length(); i++) {
			count++;
			if (lastTime.containsKey(task.charAt(i))) {
				int last = lastTime.get(task.charAt(i));
				if (count - last < k) {
					count = last + k;
				}
				lastTime.put(task.charAt(i), count);
			}
			else {
				lastTime.put(task.charAt(i), count);
			}
		}
		return count;
	}
}