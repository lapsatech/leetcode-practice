package graphGeneral

import spock.lang.Specification
import spock.lang.Unroll

class NumberOfIslandsTest extends Specification {

  @Unroll
  def 'test'(def grid, def expectedNum) {
    given:
    def ng = new char[grid.size()][];
    def x = 0;
    grid.each { row ->
      def nr = new char[row.size()]
      ng[x++] = nr
      def y= 0
      row.each { nr[y++] = (it as char) }
    }
    
    def subject = new NumberOfIslands();

    when:
    def num1 = subject.numIslands(ng)

    then:
    num1 == expectedNum

    when:
    def num2 = subject.numIslandsRecursive(ng)

    then:
    num2 == expectedNum

    when:
    def num3 = subject.numIslandsIterative(ng)

    then:
    num3 == expectedNum

    when:
    def num4 = subject.numIslandsSimpleGraph(ng)

    then:
    num4 == expectedNum

    where:
    grid                       | expectedNum
    [
      ['1','1','1','1','0'],
      ['1','1','0','1','0'],
      ['1','1','0','0','0'],
      ['0','0','0','0','0']
    ]                          | 1
    [
      ['1','1','0','0','0'],
      ['1','1','0','0','0'],
      ['0','0','1','0','0'],
      ['0','0','0','1','1']
    ]                          | 3
    [['1']]                    | 1
    [['1'],['1']]              | 1
  }
}
