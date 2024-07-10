package binaryTreeGeneral

import models.binaryTree.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class SymmetricTreeTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectedSymetric) {
    given:
    def subject = new SymmetricTree();
    def root = TreeNode.ofList(treeDef)

    when:
    def res = subject.isSymmetric(root)

    then:
    res == expectedSymetric

    where:
    treeDef                     | expectedSymetric
    [1, 2, 2, 3, 4, 4, 3]       | true
    [1, 2, 2, null, 3, null, 3] | false
  }

}
