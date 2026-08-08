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
    ListNode reverse(ListNode head){
        ListNode rev=null;
        while(head!=null){
            ListNode nxt=head.next;
            head.next=rev;
            rev=head;
            head=nxt;
        }
        return rev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        head = new ListNode(0, head);
        ListNode p=head;
        while(p!=null){
            boolean end=false;
            ListNode q=p;
            for(int i=0;i<k;i++) {
                q=q.next;
                if(q==null){
                    end=true;
                    break;
                }
            }
            if(end)break;
            ListNode rest=q.next;
            q.next=null;
            ListNode nxt=p.next;
            p.next=reverse(p.next);
            nxt.next=rest;
            p=nxt;
        }
        return head.next;
    }
}
