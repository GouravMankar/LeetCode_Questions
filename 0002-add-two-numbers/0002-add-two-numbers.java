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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remaining=0;
        ListNode result=new ListNode();
        ListNode dummy=result;
        while(l1!=null||l2!=null || remaining!=0){
            int val1=(l1!=null)?l1.val:0;
            int val2=(l2!=null)?l2.val:0;
            int sum=val1+val2+remaining;
            int digit=sum%10;
            remaining=sum/10;
            dummy.next=new ListNode(digit);
            dummy=dummy.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        return result.next;
    }
}