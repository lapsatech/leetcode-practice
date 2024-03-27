package linkedList;

import models.linkedlist.ListNode;

public class MergedTwoSortedLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = null, next = null;

    while (true) {
      if (list1 == null && list2 == null) {
        return head;
      }
      final int add;
      if (list1 == null && list2 != null) {
        add = list2.val;
        list2 = list2.next;
      } else if (list1 != null && list2 == null) {
        add = list1.val;
        list1 = list1.next;
      } else if (list1.val <= list2.val) {
        add = list1.val;
        list1 = list1.next;
      } else {
        add = list2.val;
        list2 = list2.next;
      }
      if (head == null) {
        head = new ListNode(add);
        next = head;
      } else {
        next.next = new ListNode(add);
        next = next.next;
      }
    }
  }
}
