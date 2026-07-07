class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        StringBuilder sb=new StringBuilder("");
        Long sum=0l;
        Long rem=0l;
        while(n>0){
            rem=(long)n%10;
            n=n/10;
            if(rem!=0){
                sb.append(rem);
                sum+=rem;
            }
        }
        String val=sb.reverse().toString();
        Long value=Long.parseLong(val);
        return value*sum;
    }
}