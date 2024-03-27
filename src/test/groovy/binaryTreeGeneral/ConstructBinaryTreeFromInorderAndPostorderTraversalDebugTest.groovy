package binaryTreeGeneral

import spock.lang.Specification
import spock.lang.Unroll

class ConstructBinaryTreeFromInorderAndPostorderTraversalDebugTest extends Specification {

  @Unroll
  def 'test'(def inorder, def postorder, def expectTreeDef) {
    given:
    def subject = new ConstructBinaryTreeFromInorderAndPostorderTraversalDebug();

    when:
    def treeDef = subject.buildTree(inorder as int[], postorder as int[]).toList()

    then:
    treeDef == expectTreeDef

    where:
    inorder                           | postorder                       | expectTreeDef
    [9, 3, 15, 20, 7]                 | [9, 15, 7, 20, 3]               | [3, 9, 20, null, null, 15, 7]
    [-1]                              | [-1]                            | [-1]
    [111, 11, 112, 1, 121, 12, 122]   | [111, 112, 11, 121, 122, 12, 1] | [1, 11, 12, 111, 112, 121, 122]
    [2, 1]                            | [2, 1]                          | [1, 2]
    [1, 2]                            | [2, 1]                          | [1, null, 2]
  }
}
