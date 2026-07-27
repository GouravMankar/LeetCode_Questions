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
    public ListNode middleNode(ListNode head) {
        int count=0;
        if(head==null){
            return head;
        }
        ListNode temp=head;
        while(temp!=null){
          temp=temp.next;
          count++;
        }
        count=count/2+1;
        temp=head;
        while(count>1){
            temp=temp.next;
            count--;
        }
        return temp;
    }
}