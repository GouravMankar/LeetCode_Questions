class Solution {
    public int minInsertions(String s) {
        int ans=0,need=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(need%2==1){
                    need--;
                    ans++;
                }
                need+=2;
            }else{
                need--;
                if(need==-1){
                    ans++;
                    need=1;
                }
            }
        }
        return ans+need;
    }
}