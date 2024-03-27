package linkedList

import models.linkedlist.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class MergedTwoSortedListsTest extends Specification {

  @Unroll
  def 'test'(def list1, def list2, def expectList) {
    given:
    def head1 = ListNode.ofList(list1)
    def head2 = ListNode.ofList(list2)
    def subject = new MergedTwoSortedLists();

    when:
    def head3 = subject.mergeTwoLists(head1, head2)
    def resultList = head3.toList()

    then:
    resultList == expectList

    where:
    list1      | list2     | expectList
    [1, 2, 4]  | [1, 3, 4] | [1, 1, 2, 3, 4, 4]
  }
}
