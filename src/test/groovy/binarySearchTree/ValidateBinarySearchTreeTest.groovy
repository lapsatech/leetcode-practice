package binarySearchTree

import models.binaryTree.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class ValidateBinarySearchTreeTest extends Specification {

  @Unroll
  def 'test'(def rootDef, def expect) {
    given:
    def s = new ValidateBinarySearchTree();
    def root = TreeNode.ofList(rootDef)

    expect:
    s.isValidBST(root) == expect

    where:
    rootDef                      | expect
    [2, 1, 3]                    | true
    [5, 1, 4, null, null, 3, 6]  | false
  }
}
