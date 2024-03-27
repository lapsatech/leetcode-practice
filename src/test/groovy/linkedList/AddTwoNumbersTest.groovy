package linkedList

import models.linkedlist.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class AddTwoNumbersTest extends Specification {

  @Unroll
  def 'test'(def list1, def list2, def expect) {
    given:
    def head1 = ListNode.ofList(list1)
    def head2 = ListNode.ofList(list2)
    def subject = new AddTwoNumbers();

    when:
    def resHead = subject.addTwoNumbers(head1, head2)
    def res = ListNode.toList(resHead)

    then:
    res == expect

    where:
    list1             | list2       | expect
    [2, 4, 3]         | [5, 6, 4]   | [7, 0, 8]
    [0]               | [0]         | [0]
    [9,9,9,9,9,9,9]   | [9,9,9,9]   | [8,9,9,9,0,0,0,1]
  }
}
