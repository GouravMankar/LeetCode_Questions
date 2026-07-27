class Solution {
    public boolean isPalindrome(String s) {
StringBuilder filteredString = new StringBuilder();
 for (char c : s.toCharArray()) 
 { 
    if (Character.isLetterOrDigit(c)) 
    { filteredString.append(Character.toLowerCase(c));
    
     } 
} 
String filtered = filteredString.toString();
 int left = 0;
  int right = filtered.length() - 1;
   while (left < right) 
   { if (filtered.charAt(left) != filtered.charAt(right)) 
   {
     return false; 
     }
      left++;
       right--; 
       }
        return true;
    }
}