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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode leader = head;
        ListNode follower = dummy;

        // now move leader n nodes ahead
        for(int i = 0; i < n; i++){
            leader = leader.next;
        }

        while(leader != null){
            follower = follower.next;
            leader = leader.next;
        }

        follower.next = follower.next.next;    
        
        
        return dummy.next;
    }
}
