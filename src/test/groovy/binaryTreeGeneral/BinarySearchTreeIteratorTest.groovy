package binaryTreeGeneral

import binaryTreeGeneral.BinarySearchTreeIterator.BSTIterator
import models.binaryTree.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchTreeIteratorTest  extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectIteratorList) {
    given:
    def root = TreeNode.ofList(treeDef)
    def subject = new BSTIterator(root);

    when:
    def iteratorList = []
    while (subject.hasNext()) {
      iteratorList << subject.next()
    }

    then:
    iteratorList == expectIteratorList

    where:
    treeDef                       | expectIteratorList
    [7, 3, 15, null, null, 9, 20] | [3, 7, 9, 15, 20]
  }
}
