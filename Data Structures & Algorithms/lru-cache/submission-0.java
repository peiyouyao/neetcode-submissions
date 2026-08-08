class LRUCache {
    static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(){}
        public Node(int k, int v){key=k; val=v;}
    }

    private int cap;

    private Node head, tail;

    private Map<Integer, Node> key2node=new HashMap<>();

    private void addAtHead(Node node){
        Node rest=head.next;
        head.next=node; node.prev=head;
        rest.prev=node; node.next=rest;
    }

    private Node getNode(int key){
        Node node=key2node.get(key);
        if(node!=null){ // move to head
            Node prev=node.prev; node.prev=null;
            Node next=node.next; node.next=null;
            prev.next=next; next.prev=prev;
            addAtHead(node);
        }
        return node;
    }

    public LRUCache(int capacity) {
        cap=capacity;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        Node node=getNode(key);
        return node==null ? -1 : node.val;
    }
    
    public void put(int key, int value) {
        Node node=getNode(key);
        if(node==null){
            node = new Node(key, value);
            key2node.put(key, node);
            if(key2node.size()>cap){
                Node rm=tail.prev;
                Node rest=rm.prev;
                rest.next=tail; tail.prev=rest;
                key2node.remove(rm.key);
            }
            addAtHead(node);
        }
        node.val=value;
    }
}
