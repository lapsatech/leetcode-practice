package linkedList;

import models.linkedlist.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode head1, ListNode head2) {

    final ListNode output = new ListNode(-1);

    ListNode current = output;

    while (head1 != null || head2 != null) {

      if (current.next == null) {
        current.next = new ListNode(0);
      }

      current = current.next;

      if (head1 != null) {
        current.val += head1.val;
        head1 = head1.next;
      }

      if (head2 != null) {
        current.val += head2.val;
        head2 = head2.next;
      }

      if (current.val > 9) {
        current.val = current.val % 10;
        current.next = new ListNode(1);
      }
    }

    return output.next;
  }

}
