package graphGeneral

import models.graph.Node
import spock.lang.Specification
import spock.lang.Unroll

class CloneGraphTest extends Specification {

  @Unroll
  def 'test'(def nodeDef) {
    given:
    def node = Node.fromAdjacencyList(nodeDef);
    def subject = new CloneGraph();

    when:
    def clonedNode = subject.cloneGraph(node)
    def clonedNodeDef = Node.toAdjacencyList(clonedNode)

    then:
    nodeDef == clonedNodeDef

    where:
    nodeDef                           | _
    [[2, 4], [1, 3], [2, 4], [1, 3]]  | _
    [[]]                              | _
    []                                | _
  }
}