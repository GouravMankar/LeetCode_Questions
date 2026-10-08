class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();

        if (strs.length == 0) {
            return "";
        }

        int i = 0;

        for (char ch : strs[0].toCharArray()) {

            for (int j = 1; j < strs.length; j++) {

                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }

            sb.append(ch);
            i++;
        }

        return sb.toString();
    }
}