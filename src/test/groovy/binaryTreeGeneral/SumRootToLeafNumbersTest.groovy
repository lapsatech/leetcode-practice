package binaryTreeGeneral

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class SumRootToLeafNumbersTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectSum) {
    given:
    def subject = new SumRootToLeafNumbers();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def sum = subject.sumNumbers(root)

    then:
    sum == expectSum

    where:
    treeDef                  | expectSum
    [1, 2, 3]                | 25
    [4, 9, 0, 5, 1]          | 1026
    []                       | 0
    [1]                      | 1
    [1,5,1,null,null,null,6] | 131
  }
}
