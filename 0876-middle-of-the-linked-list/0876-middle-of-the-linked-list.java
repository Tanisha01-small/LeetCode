/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */ // TC 0(n/2)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode tortoise=head;
        ListNode rabbit = head;
        
        while(rabbit!=null  && rabbit.next!=null){
            tortoise=tortoise.next;
            rabbit=rabbit.next.next;
           
        }
        
        return tortoise;
    }
}