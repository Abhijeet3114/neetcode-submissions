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
        /*
            you got 2 heads

            you need to create a new list/merge the list

            Corner cases:
                if list1 is empty then return list2
                if list2 is empty then return list1
                if both list are emplty then return null

            if(head1.val < head2.val){
                add head1 to result
                head1.next = mergeTwoLists(list1.next, list2)
            }
            else{
                add head2 to the result and process head2.next and list1
            }
        */

        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            ListNode head = list1;
            head.next = mergeTwoLists(list1.next, list2);
            return head;
        }
        else{
            ListNode head = list2;
            head.next = mergeTwoLists(list1, list2.next);
            return head;
        }

    }
}