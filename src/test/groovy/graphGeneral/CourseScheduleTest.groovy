package graphGeneral

import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleTest  extends Specification {

  @Unroll
  def 'test'(def numCourses, def prerequisites, def exp) {
    given:
    def subject = new CourseSchedule();

    when:
    def result = subject.canFinish(numCourses, prerequisites as int[][])

    then:
    result == exp

    where:
    numCourses | prerequisites       | exp
    2          | [[1,0]]             | true
    2          | [[1,0],[0,1]]       | false
  }
}