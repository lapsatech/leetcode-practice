package graphGeneral;

import java.util.Arrays;

public class CourseScheduleII {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[][] index = buildIndex(numCourses, prerequisites);
    PathBuilder c = new PathBuilder(index);
    return c.buildPath();
  }

  static int[][] buildIndex(int numNodes, int[][] prerequisites) {
    int[][] index = new int[numNodes][];
    for (int i = 0; i < prerequisites.length; i++) {
      int node = prerequisites[i][0];
      int child = prerequisites[i][1];

      int[] childs = index[node];
      if (childs == null) {
        childs = new int[] { child };
      } else {
        childs = Arrays.copyOf(childs, childs.length + 1);
        childs[childs.length - 1] = child;
      }
      index[node] = childs;
    }
    return index;
  }

  private static class PathBuilder {

    final private int[] traversePath;
    private int traverseIndex = 0;

    final private boolean[] visited;
    final private int[][] index;

    private PathBuilder(int[][] index) {
      this.index = index;
      this.traversePath = new int[index.length];
      this.visited = new boolean[index.length];
    }

    public int[] buildPath() {
      for (int node = 0; node < index.length; node++) {
        boolean possible = new DfsTraverse().helper(node);
        if (!possible) {
          return new int[0];
        }
      }
      return traversePath;
    }

    private class DfsTraverse {

      final boolean[] isVisitingNow = new boolean[index.length];

      private boolean helper(int node) {
        if (visited[node]) {
          return true;
        }
        if (isVisitingNow[node]) {
          return false;
        }
        isVisitingNow[node] = true;
        int[] childs = index[node];
        if (childs != null && childs.length > 0) {
          for (int child : childs) {
            boolean possible = helper(child);
            if (!possible) {
              return false;
            }
          }
        }
        visited[node] = true;
        traversePath[traverseIndex++] = node;
        return true;
      }
    }
  }
}
