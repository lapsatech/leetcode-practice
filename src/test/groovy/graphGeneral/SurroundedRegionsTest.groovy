package graphGeneral

import spock.lang.Specification
import spock.lang.Unroll

class SurroundedRegionsTest extends Specification {

  @Unroll
  def 'test'(def grid, def expectedGrid) {
    given:
    def ng = new char[grid.size()][];
    def x = 0;
    grid.each { row ->
      def nr = new char[row.size()]
      ng[x++] = nr
      def y= 0
      row.each { nr[y++] = (it as char) }
    }
    
    def subject = new SurroundedRegions();

    when:
    subject.solve(ng)

    then:
    ng == expectedGrid

    where:
    grid                       | expectedGrid
    [
      ['X','X','X','X'],
      ['X','O','O','X'],
      ['X','X','O','X'],
      ['X','O','X','X']
    ]                          | [
                                    ['X','X','X','X'],
                                    ['X','X','X','X'],
                                    ['X','X','X','X'],
                                    ['X','O','X','X']
                                  ]

    [['X', 'O']]               | [['X','O']]
    [['X'], ['O']]             | [['X'], ['O']]
  }
}