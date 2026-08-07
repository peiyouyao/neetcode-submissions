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
            ListNode next=head.next;
            head.next=rev;
            rev=head;
            head=next;
        }
        return rev;
    }

    public void reorderList(ListNode head) {
        // find the middle of the linked nodes
        ListNode s=head, f=head.next;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        ListNode m=s.next;
        s.next=null;
        m=reverse(m);

        while(m!=null){
            ListNode next=head.next;
            head.next=m;
            m=m.next;
            head.next.next=next;
            head=next;
        }
    }
}

/*
n=3

0 1 2

0 2 1

n=4

0 1 2 3

0 3 1 2

*/
