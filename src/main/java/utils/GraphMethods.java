package utils;

import java.util.List;

public interface GraphMethods {

  <T> int leastSteps(SimpleGraph<T> graph, T startNode, T finishNode);

  <T> List<T> shortestPath(SimpleGraph<T> graph, T startNode, T finishNode);
}
