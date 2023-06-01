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
    public ListNode sortList(ListNode head) {
        //Merge sort, find middle and merge linked list
        if(head==null || head.next ==null){
            return head;
        }
        
        ListNode mid=middle(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        
        return merge(left,right);
    }
    
    //for middle
    public ListNode middle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        
        if (prev != null) {
        prev.next = null;
    }
        return slow;
    }
    
    // Merge function
    public ListNode merge(ListNode h1,ListNode h2){
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        
        while(h1!=null && h2!=null){
            if(h1.val>h2.val){
                temp.next=h2;
                h2=h2.next;
                temp=temp.next;
            }else{
                temp.next=h1;
                h1=h1.next;
                temp=temp.next;
            }
        }
        
        while(h1!=null){
            temp.next=h1;
            h1=h1.next;
            temp=temp.next;
        }
        
        while(h2!=null){
            temp.next=h2;
            h2=h2.next;
            temp=temp.next;
        }
        
        return dummy.next;
        
    }
}