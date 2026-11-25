class Solution {
    public String removeDuplicates(String s) {
        Stack<Character>result=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!result.empty()){
                if(result.peek()==ch){
                    result.pop();
                }else{
                    result.push(ch);
                }
            }else{
                result.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();

for (char ch : result) {
    sb.append(ch);
}
    return sb.toString();
    }
}