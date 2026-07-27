class Solution {
    public int maxDistinct(String s) {
        Set<Character> string=new LinkedHashSet<>();
        for(char ch:s.toCharArray()){
            string.add(ch);
        }
        return string.size();



    }
}