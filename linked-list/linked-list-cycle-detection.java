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
    public boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

//保证"访问路径上不为null"，防止出现NPE
//fast.next       → 需要 fast != null
//fast.next.next  → 需要 fast.next != null
//最终结果可以是null，赋给fast没有任何问题
        while(f!=null && f.next!=null){
			
		 //速度差 = 2 - 1 = 1 步/轮
		 //距离每轮减少1,经过有限轮后距离必然 = 0,必然相遇
            s=s.next;
            f=f.next.next;
            if(s==f) return true;
        }

        return false;
    }
}
