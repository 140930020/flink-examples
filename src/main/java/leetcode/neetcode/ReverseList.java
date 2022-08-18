package leetcode.neetcode;

/**
 * @author tangqiuyue
 * @author 2022/8/18
 */
public class ReverseList {
    class ListNode {
        int val;
        leetcode.neetcode.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, leetcode.neetcode.ListNode next) {
            this.val = val;
            this.next = next;
        }


        class Solution {
            public leetcode.neetcode.ListNode reverseList(leetcode.neetcode.ListNode head) {
                leetcode.neetcode.ListNode prev = null, curr = head;
                while (curr != null) {
                    leetcode.neetcode.ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }
                return prev;
            }
        }
    }


}
