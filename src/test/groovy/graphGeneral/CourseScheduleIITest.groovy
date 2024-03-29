package graphGeneral

import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleIITest  extends Specification {

  @Unroll
  def 'test'(def numCourses, def prerequisites, def exp) {
    given:
    def subject = new CourseScheduleII() ;

    when:
    def result = subject.findOrder(numCourses, prerequisites as int[][]) as int[]

    then:
    result == exp as int[]

    where:
    numCourses | prerequisites                   | exp
    2          | [[1,0]]                         | [0,1]
    2          | [[0,1]]                         | [1,0]
    4          | [[1,0],[2,0],[3,1],[3,2]]       | [0,1,2,3]
    2          | [[1,0],[0,1]]                   | []
    3          | [[0,1],[0,2],[1,2]]             | [2,1,0]
  }
}