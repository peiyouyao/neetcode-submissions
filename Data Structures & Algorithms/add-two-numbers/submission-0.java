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
        ListNode head=new ListNode();
        ListNode l=head;
        int c=0;
        while(l1!=null || l2!=null){
            int v1=l1==null ? 0 : l1.val;
            l1=l1==null ? null : l1.next;
            int v2=l2==null ? 0 : l2.val;
            l2=l2==null ? null : l2.next;
            int v=c+v1+v2;
            c=v/10;
            v%=10;
            l.next=new ListNode(v);
            l=l.next;
        }
        if(c!=0)l.next=new ListNode(c);
        return head.next;
    }
}
