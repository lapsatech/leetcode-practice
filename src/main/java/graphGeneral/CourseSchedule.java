package graphGeneral;

import java.util.Arrays;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Calculation c = new Calculation(numCourses, prerequisites);
    for (int course = 0; course < numCourses; course++) {
      boolean possible = c.tryLearn(course);
      if (!possible) {
        return false;
      }
    }
    return true;
  }

  private static class Calculation {

    final boolean[] learned;
    final private int[][] index;

    final int numCourses;

    private Calculation(int numCourses, int[][] prerequisites) {
      this.learned = new boolean[numCourses];
      this.numCourses = numCourses;
      index = new int[numCourses][];
      for (int i = 0; i < prerequisites.length; i++) {
        int course = prerequisites[i][0];
        int depend = prerequisites[i][1];

        int[] dependsOn = index[course];
        if (dependsOn == null) {
          dependsOn = new int[] { depend };
        } else {
          dependsOn = Arrays.copyOf(dependsOn, dependsOn.length + 1);
          dependsOn[dependsOn.length - 1] = depend;
        }
        index[course] = dependsOn;
      }
    }

    private boolean tryLearn(int course) {
      return new Check().tryLearn(course);
    }

    private class Check {

      final boolean[] isLearningNow = new boolean[numCourses];

      private boolean tryLearn(int course) {
        if (learned[course]) {
          return true;
        }
        if (isLearningNow[course]) {
          return false; // circular dependency
        }

        isLearningNow[course] = true;

        int[] coursesToLearn = index[course];
        if (coursesToLearn != null && coursesToLearn.length > 0) {
          for (int courseToLearn : coursesToLearn) {
            boolean possible = tryLearn(courseToLearn);
            if (!possible) {
              return false;
            }
          }
        }
        learned[course] = true;
        return true;
      }
    }
  }
}
