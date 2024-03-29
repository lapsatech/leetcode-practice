package graphGeneral

import spock.lang.Specification
import spock.lang.Unroll

class EvaluateDivisionTest extends Specification {

  @Unroll
  def 'test #queries #expectations'(def equations, def values, def queries, def expectations) {
    given:
    def subject = new EvaluateDivision();
    def exp = expectations as double[]

    when:
    def result = subject.calcEquation(equations, values as double[], queries) as double[]
    if (result != null) {
      for (int i = 0; i < result.length;i++) {
        result[i] = Math.round(result[i] * 100_000d) / 100_000d
      }
    }

    then:
    result == exp

    where:
    equations                         | values        | queries                                             | expectations
    [["a","b"],["b","c"]]             | [2.0,3.0]     | [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] | [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//    [["a","b"],["b","c"]]             | [2.0,3.0]     | [["a","c"]]                                         | [6.00000]
//    [["a","b"],["b","c"]]             | [2.0,3.0]     | [["b","a"]]                                         | [0.50000]
//    [["a","b"],["b","c"]]             | [2.0,3.0]     | [["a","e"]]                                         | [-1.00000]
//    [["a","b"],["b","c"]]             | [2.0,3.0]     | [["a","a"]]                                         | [1.00000]
//    [["a","b"],["b","c"]]             | [2.0,3.0]     | [["x","x"]]                                         | [-1.00000]
    
    [["a","b"],["b","c"],["bc","cd"]] | [1.5,2.5,5.0] | [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]       | [3.75000,0.40000,5.00000,0.20000]
//    [["a","b"],["b","c"],["bc","cd"]] | [1.5,2.5,5.0] | [["a","c"]]                                         | [3.75000]
//    [["a","b"],["b","c"],["bc","cd"]] | [1.5,2.5,5.0] | [["c","b"]]                                         | [0.40000]
//    [["a","b"],["b","c"],["bc","cd"]] | [1.5,2.5,5.0] | [["bc","cd"]]                                       | [5.00000]
//    [["a","b"],["b","c"],["bc","cd"]] | [1.5,2.5,5.0] | [["cd","bc"]]                                       | [0.20000]

    [["a","b"]]                       | [0.5]         | [["a","b"],["b","a"],["a","c"],["x","y"]]           | [0.50000,2.00000,-1.00000,-1.00000]
//    [["a","b"]]                       | [0.5]         | [["a","b"]]                                         | [0.50000]
//    [["a","b"]]                       | [0.5]         | [["b","a"]]                                         | [2.00000]
//    [["a","b"]]                       | [0.5]         | [["a","c"]]                                         | [-1.00000]
//    [["a","b"]]                       | [0.5]         | [["x","y"]]                                         | [-1.00000]

    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]] | [3.0,4.0,5.0,6.0] | [["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]] | [360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000]
//    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]] | [3.0,4.0,5.0,6.0] | [["x1","x5"]]                   | [360.00000]
//    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]] | [3.0,4.0,5.0,6.0] | [["x5","x2"]]                   | [0.00833]
//    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]] | [3.0,4.0,5.0,6.0] | [["x2","x4"]]                   | [20.00000]
//    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]] | [3.0,4.0,5.0,6.0] | [["x2","x2"]]                   | [1.00000]
//    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]] | [3.0,4.0,5.0,6.0] | [["x2","x9"]]                   | [-1.00000]
//    [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]] | [3.0,4.0,5.0,6.0] | [["x9","x9"]]                   | [-1.00000]
  }
}