package linkedList

import models.linkedlist.Node
import spock.lang.Specification
import spock.lang.Unroll

class CopyListWithRandomPointerTest extends Specification {

  @Unroll
  def 'test'(def list) {
    given:
    def head = Node.fromList(list)
    def subject = new CopyListWithRandomPointer();

    when:
    def resHead = subject.copyRandomList(head)
    def res = Node.toList(resHead)

    then:
    def h1 = head
    def r1 = resHead
    for (int i = 0 ; i < res.size(); i++) {
      assert !h1.is(r1)
      if (h1.random == null) {
        assert r1.random == null
      } else {
        assert r1.random != null
        assert !h1.random.is(r1)
      }
      r1 = r1.next
      h1 = h1.next
    }

    where:
    list                                           | _
    [[7, null], [13, 0], [11, 4], [10, 2], [1, 0]] | _
    [[1, 1], [2, 1]]                               | _
    [[3, null], [3, 0], [3, null]]                 | _
  }
}
