public class KthClosestPoint {
	public static Point solve(Point[] list, int k) throws Exception {
		if (list == null || list.length < k) {
			System.out.println("input error, need a list with size more than k");
			return null;	
		}
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (closerThan(p1, p2)) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		for (Point p : list) {
			if (queue.size() < k) {
				queue.add(p);
			}
			else {
				Point top = queue.peek();
				if (closerThan(p, top)) {
					queue.poll();
					queue.add(p);
				}
			}
		}
		return queue.poll();
	}
	public static boolean closerThan(Point p1, Point p2) {
		double distP1 = p1.x * p1.x + p1.y * p1.y;
		double distP2 = p2.x * p2.x + p2.y * p2.y;
		return distP1 < distP2;
	}
}