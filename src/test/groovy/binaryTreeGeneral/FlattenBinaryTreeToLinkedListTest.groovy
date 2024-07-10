package binaryTreeGeneral

import models.binaryTree.BinaryTreeNode
import spock.lang.Specification
import spock.lang.Unroll

class FlattenBinaryTreeToLinkedListTest extends Specification {

  @Unroll
  def 'test'(def treeDef, def expectTreeDef) {
    given:
    def subject = new FlattenBinaryTreeToLinkedList();
    def root = BinaryTreeNode.ofList(treeDef)

    when:
    subject.flatten(root)
    def resultTreeDef = BinaryTreeNode.toList(root)

    then:
    resultTreeDef == expectTreeDef

    where:
    treeDef                  | expectTreeDef
    [1, 2, 5, 3, 4, null, 6] | [1, null, 2, null, 3, null, 4, null, 5, null, 6]
    [1, 2, 3]                | [1, null, 2, null, 3]
    []                       | []
    [0]                      | [0]
  }
}
