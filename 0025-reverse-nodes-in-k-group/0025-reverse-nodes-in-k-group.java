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
       ListNode dummy=new ListNode();
        dummy.next=head;
           
        ListNode curr=dummy;
        ListNode pres=dummy;
        ListNode nex=dummy;
        
        int count=0;
        
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
     
        
        // int group=count/k ;
        
        while(count>=k){
            curr=pres.next;
            nex=curr.next;
            for(int i=1;i<k;i++){
                curr.next=nex.next;
                nex.next=pres.next;
                pres.next=nex;
                nex=curr.next;
            }
            pres=curr;
            count-=k;
        }
        
        return dummy.next;
    }
    
}