/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int value) { this.value = value; }
 *     ListNode(int value, ListNode next) { this.value = value; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        
        ListNode f=l1;
        ListNode s=l2;
        
        ListNode result=new ListNode();
        ListNode temp=result;
        
        while(f!=null && s!=null){
            // if(f.val==s.val){
            //     temp.next=f;
            //     f=f.next;
            //     s=s.next;
            //     temp=temp.next;
            // }else 
            if(f.val>s.val){
                temp.next=s;
                s=s.next;
                temp=temp.next;
            }else{
                temp.next=f;
                f=f.next;
                temp=temp.next;
            }
        }
        
        while(f!=null){
            temp.next=f;
            f=f.next;
            temp=temp.next;
        }
        
        while(s!=null){
            temp.next=s;
            s=s.next;
            temp=temp.next;
        }
        return result.next;
    }
}