package binaryTreeGeneral

import binaryTreeGeneral.BinarySearchTreeIterator.BSTIterator
import models.binaryTree.Node
import spock.lang.Specification
import spock.lang.Unroll

class PopulatingNextRightPointersInEachNodeIITest  extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectList) {
    given:
    def root = Node.ofList(treeDef)
    def subject = new PopulatingNextRightPointersInEachNodeII();

    when:
    def res = subject.connect(root)
    def result = Node.toNextList(res)
    

    then:
    result == expectList

    where:
    treeDef                       | expectList
    [1, 2, 3, 4, 5, null, 7]      | [1, null, 2, 3, null, 4, 5, 7, null]
    []                            | []
  }
}
