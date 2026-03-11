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
        Map<Node,Node> oldToNew = new HashMap<>();

//第一遍只保存节点和节点值
        Node cur = head;
        while(cur!=null){
            Node copy = new Node(cur.val);
            oldToNew.put(cur,copy);
            cur=cur.next;
        }

//第二遍把原本节点的关系映射到新的节点上
        cur = head;
        while(cur!=null){
            Node copy = oldToNew.get(cur);
            copy.next = oldToNew.get(cur.next);
            copy.random = oldToNew.get(cur.random);
            cur=cur.next;
        }

        return oldToNew.get(head);
    }
}
