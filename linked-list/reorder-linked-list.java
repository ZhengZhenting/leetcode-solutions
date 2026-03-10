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
    public void reorderList(ListNode head) {
	
		//find the middle of the list using fast-slow pointers
        ListNode s = head;
        ListNode f = head;

        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
		
		//cut the list from the middle into to parts and reverse the second part
        ListNode cur = s.next;
        s.next = null;
        ListNode pre = null;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre=cur;
            cur=nxt;
        }

		//combine the two lists
        ListNode first = head;
        ListNode second = pre;
        while(second!=null){
            ListNode t1=first.next;
            ListNode t2=second.next;

            first.next=second;
            second.next=t1;
            second=t2;
            first=t1;
        }
    }
}
