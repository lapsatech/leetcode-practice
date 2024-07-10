package divideConquerror

import models.binaryTree.TreeNode;
import spock.lang.Specification
import spock.lang.Unroll

class ConvertSortedArrayToBinarySearchTreeTest extends Specification {
  
  @Unroll
  def 'test'(def inputArray, def expectedAnyTreeDefs) {
    given:
    def subject = new ConvertSortedArrayToBinarySearchTree()

    when:
    def root = subject.sortedArrayToBST(inputArray as int[])
    def resultTreeDef = TreeNode.toList(root)

    then:
    expectedAnyTreeDefs.any { it == resultTreeDef }

    where:
    inputArray               | expectedAnyTreeDefs
    [-10, -3, 0, 5, 9]       | [[0, -3, 9, -10, null, 5], [0, -10, 5, null, -3, null, 9]]
    [1, 3]                   | [[1, null, 3], [3, 1]]
  }

}
