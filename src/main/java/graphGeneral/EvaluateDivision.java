package graphGeneral;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

  private static class Equations {
    final HashMap<String, HashMap<String, Double>> index = new HashMap<>();

    private Equations(List<List<String>> equations, double[] values) {
      for (int i = 0; i < values.length; i++) {
        List<String> e = equations.get(i);
        String left = e.get(0);
        String right = e.get(1);
        double v = values[i];
        index.computeIfAbsent(left, c -> new HashMap<>()).put(right, v);
        index.computeIfAbsent(right, c -> new HashMap<>()).put(left, 1 / v);
      }
    }

    private class Calculation {
      private final HashSet<String> visited = new HashSet<>();

      private double calculate(String left, String right) {
        if (left.equals(right)) {
          return 1;
        }
        HashMap<String, Double> childs = index.get(left);
        for (Map.Entry<String, Double> newLeft : childs.entrySet()) {
          if (visited.add(newLeft.getKey())) {
            double n = calculate(newLeft.getKey(), right);
            if (n >= 0) {
              return n * newLeft.getValue().doubleValue();
            }
          }
        }
        return -1;
      }
    }

    public double calculate(String left, String right) {
      if (!index.containsKey(left) || !index.containsKey(right)) {
        return -1;
      }
      Calculation c = new Calculation();
      return c.calculate(left, right);
    }
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Equations s = new Equations(equations, values);
    double[] result = new double[queries.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = s.calculate(queries.get(i).get(0), queries.get(i).get(1));
    }
    return result;
  }
}
