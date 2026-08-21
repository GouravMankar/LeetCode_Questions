class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        int idx=1;
        for(char ch:s.toCharArray()){
            int i=ch-'a';

            i=26-i;
            i=i*idx;

            sum=sum+i;
            idx++;

        }
        return sum;
    }
}