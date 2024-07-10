package binaryTreeGeneral

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class MaximumDepthOfBinaryTreeTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectedMaxDepth) {
    given:
    def subject = new MaximumDepthOfBinaryTree();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def res = subject.maxDepth(root)

    then:
    res == expectedMaxDepth

    where:
    treeDef                       | expectedMaxDepth
    [3, 9, 20, null, null, 15, 7] | 3
    [1, null, 2]                  | 2
  }
}
