package binarySearchTree

import models.binaryTree.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class MinimumAbsoluteDifferenceInBSTTest extends Specification {

  @Unroll
  def 'test'(def rootDef, def expect) {
    given:
    def s = new MinimumAbsoluteDifferenceInBST();
    def root = TreeNode.ofList(rootDef)

    when:
    def res = s.getMinimumDifference(root) as int

    then:
    res == expect

    where:
    rootDef                               | expect
    [4, 2, 6, 1, 3]                       | 1
    [1, 0, 48, null, null, 12, 49]        | 1
    [236, 104, 701, null, 227, null, 911] | 9
  }
}
