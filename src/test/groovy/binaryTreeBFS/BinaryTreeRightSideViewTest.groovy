package binaryTreeBFS

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeRightSideViewTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectRightView) {
    given:
    def subject = new BinaryTreeRightSideView();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def res = subject.rightSideView(root)

    then:
    res as int[] == expectRightView as int[]

    where:
    treeDef                     | expectRightView
    [1, 2, 3, null, 5, null, 4] | [1, 3, 4]
  }
}