import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                // Move the left pointer to the right of the previous occurrence
                left = charMap.get(currentChar) + 1;
            }

            charMap.put(currentChar, right);
            int currentWindowSize = right - left + 1;
            maxLength = Math.max(maxLength, currentWindowSize);
        }

        return maxLength;
    }
}
