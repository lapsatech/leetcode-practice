package graphBFS

import spock.lang.Specification
import spock.lang.Unroll

class SnakesAndLaddersTest extends Specification {

  @Unroll
  def 'test'(def board, def expectResult) {
    given:
    def subject = new SnakesAndLadders();

    when:
    def result = subject.snakesAndLadders(board as int[][])

    then:
    result == expectResult

    where:
    board                           | expectResult
    [
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
    ]                               | 24

    [
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1],
      [-1, 144, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
    ]                               | 1

    [
      [-1,-1,-1,-1,-1,-1],
      [-1,-1,-1,-1,-1,-1],
      [-1,-1,-1,-1,-1,-1],
      [-1,35,-1,-1,13,-1],
      [-1,-1,-1,-1,-1,-1],
      [-1,15,-1,-1,-1,-1]
    ]                                | 4

    [
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ]
    ]                                | 4

    [
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, 25, -1, -1, -1 ]
    ]                                | 1

    [
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, 25, -1 ],
      [ -1, -1, -1, -1, -1 ]
    ]                                | 1

    [
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, 25, -1, -1 ],
      [ -1, -1, -1, -1, -1 ]
    ]                                | 2

    [
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, 25, -1 ],
      [ -1, -1, -1, -1, -1 ],
      [ -1, -1, -1, -1, -1 ]
    ]                                | 3

    [
      [-1, -1, -1, -1, 48, 5, -1],
      [12, 29, 13, 9, -1, 2, 32],
      [-1, -1, 21, 7, -1, 12, 49],
      [42, 37, 21, 40, -1, 22, 12],
      [42, -1, 2, -1, -1, -1, 6],
      [39, -1, 35, -1, -1, 39,-1],
      [-1, 36, -1, -1, -1, -1, 5]
    ]                                | 3

    [[-1, -1], [-1, 3]]              | 1
  }
}