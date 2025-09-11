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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummyNode = new ListNode(0); 
        ListNode curr = dummyNode;
        int carry = 0;

        while (t1 != null || t2 != null) {
            int sum = carry;

            if (t1 != null) {
                sum += t1.val; 
                t1 = t1.next;
            }

            if (t2 != null) {
                sum += t2.val;  
                t2 = t2.next;
            }

            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyNode.next;  
    }
}
