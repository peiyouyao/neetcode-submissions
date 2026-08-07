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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head=new ListNode(0, head);
        ListNode p=head, last=head.next;
        for(;n>0; n--){
            if(last==null)return head.next;
            last=last.next;
        }
        while(last!=null){
            last=last.next;
            p=p.next;
        }
        p.next=p.next.next;
        return head.next;
    }
}

/*
N=5
n=1

0 1 2 3 4

dummy -> 0 -> 1 -> 2 -> 3 -> 4
*/