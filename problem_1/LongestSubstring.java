import java.util.HashMap;

class Solution {
/**
 * We are asked to return the longest substring without repeating characters
 * contained within String s.
 * There are two potential approached that come to mind:
 * Generating all substrings (takes a while)
 * Using a hashmap to create a sliding window. This works in linear time.
 *
 * We can slide a window over the string and add characters to seen when they
 * are seen. Once we hit a characer that is already in the map, we slide to
 * the next one.
 * We do this until the right edge of our window reaches the end of the string.
 */
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> seen = new HashMap<>();
		int maxLength = 0;
		int start = 0;

		for (int end = 0; end < s.length(); end++) {
			char current = s.charAt(end);
			if (seen.contains(current) && seen.get(current) < start) {
				start = seen.get(current) + 1;
			}
			seen.put(current, end);
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}

}
