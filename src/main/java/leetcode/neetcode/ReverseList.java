package leetcode.neetcode;

/**
 * @author tangqiuyue
 * @author 2022/8/18
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        static class Solution {
            public ListNode reverseList(ListNode head) {
                ListNode prev = null, curr = head;
                while (curr != null) {
                    ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }
                return prev;
            }

            /**
             * null-1-2-6-5-4
             *
             * @param head
             * @param val
             * @return
             */
            public ListNode removeRElements(ListNode head, int val) {
                ListNode dummy = new ListNode();
                dummy.next = head;
                ListNode curr = head, prev = dummy;
                while (curr != null) {
                    if (curr.val == val) {
                        prev.next = curr.next; //改变之前的next指针
                    } else {
                        prev = curr;
                    }
                    curr = curr.next;
                }
                return dummy.next;
            }
        }
    }

    public static void main(String[] args) {
        ReverseList.ListNode.Solution solution = new ReverseList.ListNode.Solution();
        ListNode listNode = new ListNode(7);
        addHead(listNode, 7);
        addHead(listNode, 7);
        addHead(listNode, 7);
        solution.removeRElements(listNode, 7);
    }

    private static ListNode addHead(ListNode listNode, int val) {
        ListNode curr = listNode;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
        return listNode.next;
    }

}
