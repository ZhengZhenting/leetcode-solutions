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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = null;

        for(int i = 0; i<lists.length; i++){
            ListNode dummy = new ListNode(0);
            ListNode empty = dummy;

            while(lists[i]!=null && start!=null){
                if(lists[i].val<=start.val){
                    empty.next=lists[i];
                    lists[i]=lists[i].next;
                }else{
                    empty.next=start;
                    start=start.next;
                } 
                empty=empty.next;
            }

            if(lists[i]!=null){
                empty.next=lists[i];
            }else{
                empty.next=start;
            }

            start=dummy.next;
        }

        return start;
    }
}
