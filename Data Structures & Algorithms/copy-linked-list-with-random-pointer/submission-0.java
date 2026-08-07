/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> copyMap=new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node copy=copyMap.get(head);
        if(copy==null){
            copy=new Node(head.val);
            copyMap.put(head, copy);
            copy.next=copyRandomList(head.next);
            copy.random=copyRandomList(head.random);
        }
        return copy;
    }
}
