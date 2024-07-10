package binaryTreeBFS

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeZigzagLevelOrderTraversalTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectZigzag) {
    given:
    def subject = new BinaryTreeZigzagLevelOrderTraversal();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def res = subject.zigzagLevelOrder(root)

    then:
    res == expectZigzag

    where:
    treeDef                       | expectZigzag
    [3, 9, 20, null, null, 15, 7] | [[3], [20, 9], [15, 7]]
    [1]                           | [[1]]
    []                            | []
  }
}