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
    public Node copyRandomList(Node head) {
        Map<Node, Node> copyMap=new HashMap<>();
        for(Node p=head; p!=null; p=p.next)copyMap.put(p, new Node(p.val));
        for(Node p=head; p!=null; p=p.next){
            Node next=p.next;
            Node random=p.random;
            Node copy=copyMap.get(p);
            Node copyNext=copyMap.get(p.next);
            Node copyRandom=copyMap.get(p.random);
            copy.next=copyNext;
            copy.random=copyRandom;
        }
        return copyMap.get(head);
    }
}
