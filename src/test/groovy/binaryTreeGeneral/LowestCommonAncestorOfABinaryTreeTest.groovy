package binaryTreeGeneral

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class LowestCommonAncestorOfABinaryTreeTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def p, def q, def expect) {
    given:
    def subject = new LowestCommonAncestorOfABinaryTree();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    def resultNode = subject.lowestCommonAncestor(root, new BinaryTreeNode(p), new BinaryTreeNode(q))
    def result = resultNode == null ? null : resultNode.val

    then:
    result == expect

    where:
    treeDef                       | p | q  | expect
    [3,5,1,6,2,0,8,null,null,7,4] | 5 | 1  | 3
    [3,5,1,6,2,0,8,null,null,7,4] | 5 | 4  | 5
    [1,2]                         | 1 | 2  | 1
    [3,5,1,6,2,0,8,null,null,7,4] | 5 | 10 | null
  }
}
