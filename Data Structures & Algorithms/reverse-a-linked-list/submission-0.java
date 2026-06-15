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
    public ListNode reverseList(ListNode head) {

        /*
        input:
        1->2->3->null

        output:
        null<-1<-2<-3
        and return 3

        How?
            use 3 pointers
            one to point the curr
            one to point the next
            one to point prev

            while next is not null
                curr.next = prev
                prev = curr
                curr = next
                next = next.next
        */


        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode next = head.next;
        ListNode prev = null;

        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        return curr;

    }
}
