/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        if(head==null || head.next==null){
            return null;
        }

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode start=head;
                while(start !=slow){
                    start=start.next;
                    slow=slow.next;
                }
                return start;
            }

        }
        return null;
    }
}