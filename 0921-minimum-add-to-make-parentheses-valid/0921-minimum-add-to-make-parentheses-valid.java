class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        int result=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }else if(ch==')'){
                if(!stack.empty() &&stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
        return stack.size();

        
    }
}