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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode fast=head;
        int count=1;
        // length of LinkedList
        while(fast.next!=null){
            fast=fast.next;
            count++;
        }
        
        if(k>=count){
            k=k%count;
        }
        
        k=count-k;
        
       fast.next=head;
        
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        head=fast.next;
        fast.next=null;
        
        return head;
    }
}