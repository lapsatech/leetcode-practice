package binaryTreeGeneral

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class CountCompleteTreeNodesTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectCount) {
    given:
    def subject = new CountCompleteTreeNodes();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def res = subject.countNodes(root)

    then:
    res == expectCount

    where:
    treeDef               | expectCount
    [1, 2, 3, 4, 5, 6]    | 6
    []                    | 0
    [1]                   | 1
    null                  | 0
    [1, 2, 3, 4, 5, 6, 7] | 7
  }
}
