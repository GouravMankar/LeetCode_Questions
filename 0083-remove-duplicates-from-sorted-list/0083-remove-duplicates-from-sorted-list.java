/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result=head;

        while( result !=null && result.next!=null){
          if(result.next.val==result.val){
            result.next=result.next.next;
          }else{
            result=result.next;
            
          }
        }
        return head;
    }
}