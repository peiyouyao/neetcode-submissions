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
    private ListNode mergeTwo(ListNode head1, ListNode head2){
        ListNode head=new ListNode();
        ListNode p=head;
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                ListNode nxt=head1.next;
                head1.next=null;
                p.next=head1;
                p=p.next;
                head1=nxt;
            }else{
                ListNode nxt=head2.next;
                head2.next=null;
                p.next=head2;
                p=p.next;
                head2=nxt;
            }
        }
        if(head1!=null)p.next=head1;
        else p.next=head2;
        return head.next;
    }

    private ListNode merge(ListNode[] lists, int l, int r){
        if(l==r)return null;
        if(l+1==r)return lists[l];
        int m=l+(r-l)/2;
        ListNode left=merge(lists, l, m), right=merge(lists, m, r);
        return mergeTwo(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length);
    }
}
