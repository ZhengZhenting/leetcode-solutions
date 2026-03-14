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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode groupPrev = dummy;

        while(true){
			//检查后面是否还有 k 个节点
            ListNode kth = getKth(groupPrev,k);
            if(kth == null) break;

			// 记录这组结束后的下一个节点
            ListNode groupNext = kth.next;

			// 反转这k个节点
            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            while(cur != groupNext){
                ListNode nxt = cur.next;
                cur.next=prev;
                prev=cur;
                cur=nxt;
            }

            ListNode groupStart = groupPrev.next; //提前保存这组的头（反转后变尾），因为下一步会覆盖
            groupPrev.next=kth; //把上一组的尾接上这组反转后的新头
            groupPrev=groupStart; //移动到这组的尾，作为下一组的前驱
        }          

        return dummy.next;

    }

    private ListNode getKth(ListNode node, int k){
		// 从 node 往后走k步，返回第k个节点，不足则返回null
        while(node != null && k>0){
            node=node.next;
            k--;
        }
        return node;
    }
}
