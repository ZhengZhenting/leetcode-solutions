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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	//初始化需要用构造函数 ListNode head = new ListNode(0)
	//而不是ListNode head = null!
	//因为构造函数包括了val=0,next=null(有指向下一个Node),但是null没有指向下一个Node
	
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                cur.next=list1;
                cur=list1;
                list1=list1.next;
            }else{
                cur.next=list2;
                cur=list2;
                list2=list2.next;
            }
        }

        if(list1!=null){
            cur.next=list1;
        }else{
            cur.next=list2;
        }

        return head.next;
    }
}