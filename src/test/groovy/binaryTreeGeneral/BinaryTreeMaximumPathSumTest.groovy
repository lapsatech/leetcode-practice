package binaryTreeGeneral

import models.binaryTree.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class BinaryTreeMaximumPathSumTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectSum) {
    given:
    def subject = new BinaryTreeMaximumPathSum();
    def root = TreeNode.ofList(treeDef)

    when:
    def sum = subject.maxPathSum(root)

    then:
    sum == expectSum

    where:
    treeDef                     | expectSum
    [1, 2, 3]                   | 6
    [-10,9,20,null,null,15,7]   | 42
    [0]   | 0
    [1]   | 1
    [2,-1] | 2
    [1, 2] | 3
    [0,1,1] | 2
  }
}
