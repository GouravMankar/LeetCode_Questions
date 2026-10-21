
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Case 1: Already sorted
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // Case 2: Cannot sort an unsorted string of length 2
        if (n == 2) {
            return -1;
        }

        char minChar = 'z';
        char maxChar = 'a';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            minChar = (char) Math.min(minChar, c);
            maxChar = (char) Math.max(maxChar, c);
        }

        // Case 3: One operation is sufficient
        if (s.charAt(0) == minChar ||
            s.charAt(n - 1) == maxChar) {
            return 1;
        }

        // Case 4: Two operations are sufficient
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) {
                return 2;
            }
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) {
                return 2;
            }
        }

        // Case 5
        return 3;
    }
}
