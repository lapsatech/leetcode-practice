package linkedList

import models.linkedlist.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class LinkedListCycleTest extends Specification {

  @Unroll
  def 'test'(def list, def pos, def expect) {
    given:
    def head = ListNode.ofListCycle(list, pos)
    def subject = new LinkedListCycle();

    when:
    def res = subject.hasCycle(head)

    then:
    res == expect

    where:
    list          | pos | expect
    [3, 2, 0, -4] | 1   | true
    [1, 2]        | 0   | true
    [1]           | -1  | false
  }
}
