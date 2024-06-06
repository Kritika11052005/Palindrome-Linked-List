public class LeetCode {
    
 // Definition for singly-linked list.
public class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverse(ListNode head) {//reversing second half of list
        ListNode PrevNode = null;
        ListNode CurrNode = head;
        while(CurrNode!= null) {
            ListNode NextNode = CurrNode.next;
            CurrNode.next = PrevNode;
            PrevNode = CurrNode;
            CurrNode = NextNode;
        }
        return PrevNode;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        while(pointer2 != null && pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        ListNode rev = reverse(pointer1.next); // reverse second half of linked- list
        pointer1.next = null;
        //comparison of each node with corresponding node in second-half
        while(rev != null) {
            if(head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
}
}
