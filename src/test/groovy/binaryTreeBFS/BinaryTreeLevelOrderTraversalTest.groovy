package binaryTreeBFS

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeLevelOrderTraversalTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectAvgs) {
    given:
    def subject = new BinaryTreeLevelOrderTraversal();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def res = subject.levelOrder(root)

    then:
    res == expectAvgs

    where:
    treeDef                       | expectAvgs
    [3, 9, 20, null, null, 15, 7] | [[3], [9, 20], [15, 7]]
  }
}