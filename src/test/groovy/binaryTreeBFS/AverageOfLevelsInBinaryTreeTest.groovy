package binaryTreeBFS

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class AverageOfLevelsInBinaryTreeTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectAvgs) {
    given:
    def subject = new AverageOfLevelsInBinaryTree();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def res = subject.averageOfLevels(root)

    then:
    res == expectAvgs

    where:
    treeDef                       | expectAvgs
    [3, 9, 20, null, null, 15, 7] | [3.0d, 14.5d, 11d]
  }
}