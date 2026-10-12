class Solution {
    public int longestContinuousSubstring(String s) {
        if(s.length()==1)return 1;
        int count=1;
        int max=0;
        int ch=(int)s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(ch==(s.charAt(i)-1)){
                count++;
                ch=(int)s.charAt(i);
                System.out.println(ch);
            }else{
                ch=(int)s.charAt(i);
                max=Math.max(max,count);
                count=1;
            }
               max=Math.max(max,count);
        }
        return max;
    }
}