package models.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNode {

  public static ListNode ofListCycle(List<Integer> ary, int startOfCyclePos) {
    ListNode beforeHead = new ListNode(-1);
    ListNode n = beforeHead;
    ListNode startOfCycle = null;
    int size = ary.size();
    for (int i = 0; i < size; i++) {
      n.next = new ListNode(ary.get(i));
      if (startOfCyclePos >= 0 && startOfCyclePos == i) {
        startOfCycle = n.next;
      }
      n = n.next;
    }
    if (startOfCycle != null) {
      n.next = startOfCycle;
    }
    return beforeHead.next;
  }

  public static ListNode ofList(List<Integer> ary) {
    return ofListCycle(ary, -1);
  }

  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  public ListNode(int x, ListNode next) {
    this.val = x;
    this.next = next;
  }

  public static List<Integer> toList(ListNode head) {
    Set<ListNode> visited = new HashSet<>();

    List<Integer> ll = new ArrayList<>();
    while (head != null) {
      if (visited.add(head)) {
        ll.add(head.val);
        head = head.next;
      } else {
        head = null;
      }
    }
    return ll;
  }

  public List<Integer> toList() {
    return toList(this);
  }

  @Override
  public String toString() {
    return String.valueOf(toList());
  }
}