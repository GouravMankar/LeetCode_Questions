class Solution {
    public boolean canAliceWin(int n) {
        boolean result=true;
        int remove=10;
       while(n>=remove){
            n=n-remove;
            remove--;
            result=!result;
       }
       return !result;
    }
}