package linkedList;

import models.linkedlist.ListNode;

public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public ListNode startOfCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while (fast != slow) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }

  public ListNode tail(ListNode head) {
    ListNode fast = head, slow = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while (fast.next != slow.next) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }

}
