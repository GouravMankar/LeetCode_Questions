class Solution {
    public int[] minOperations(String boxes) {
       List<Integer> index=new ArrayList<>();
       int []result=new int[boxes.length()];
       for(int i=0;i<boxes.length();i++){
        if(boxes.charAt(i)=='1'){
            index.add(i);
        }
       } 
       for(int i=0;i<result.length;i++){
        int sum=0;
         for(Integer val:index){
             sum+=Math.abs(val-i);
         }
         result[i]=sum;
       }
       return result;
    }
}