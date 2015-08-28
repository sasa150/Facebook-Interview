public class CombinationsFromDifferentString {
	private List<String> getPermutate(List<String> words, int depth) {
		List<String> result = new ArrayList<String>();
		if (depth == words.size() - 1) {
			for (int i = 0; i < words.get(depth).length(); i++) {
				result.add(String.valueOf(words.get(depth).charAt(i)));
			}
			return result;
		}
		List<String> next = getPermutate(words, depth + 1);
		for (int i = 0; i < words.get(depth).length(); i++) {
			String toBeAdd = String.valueOf(words.get(depth).charAt(i));
			for (String candidate : next) {
				result.add(toBeAdd + candidate);
			}
		}
		return result;
	}
}