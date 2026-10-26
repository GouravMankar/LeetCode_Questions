
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] count = new int[26];

        // Count characters in s1
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        // Subtract characters in the first window of s2
        for (int i = 0; i < n; i++) {
            count[s2.charAt(i) - 'a']--;
        }

        if (isZero(count)) {
            return true;
        }

        // Slide the window across s2
        for (int right = n; right < m; right++) {
            char newChar = s2.charAt(right);
            char oldChar = s2.charAt(right - n);

            count[newChar - 'a']--;
            count[oldChar - 'a']++;

            if (isZero(count)) {
                return true;
            }
        }

        return false;
    }

    private boolean isZero(int[] count) {
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
