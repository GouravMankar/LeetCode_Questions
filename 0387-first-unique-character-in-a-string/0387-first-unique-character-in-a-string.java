class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> result=new HashMap<>();
        for(int i=0;i<s.length();i++){
            result.put(s.charAt(i),result.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(result.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}