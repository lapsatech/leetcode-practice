package graphBFS;

import java.util.Collection;
import java.util.HashSet;

import utils.GraphMethods;
import utils.GraphMethodsImpl;
import utils.SimpleGraph;

public class MinimumGeneticMutation {

  public int minMutation(String startGene, String endGene, String[] bank) {
    SimpleGraph<String> graph = new GeneMutationGraph(bank);
    GraphMethods util = new GraphMethodsImpl();
    return util.leastSteps(graph, startGene, endGene);
  }

  private static class GeneMutationGraph implements SimpleGraph<String> {

    private String[] bank;

    private GeneMutationGraph(String[] bank) {
      this.bank = bank;
    }

    /**
     * Return true if two genes differs on just one letter
     */
    private boolean isMutationPossible(String gene1, String gene2) {
      boolean oneMistmatch = false;
      for (int i = 0; i < 8; i++) {
        if (gene1.charAt(i) != gene2.charAt(i)) {
          if (oneMistmatch) {
            // second mismatch means mutation isn't possible
            return false;
          } else {
            oneMistmatch = true;
          }
        }
      }
      return oneMistmatch;
    }

    @Override
    public Collection<String> childs(String gene) {
      HashSet<String> cc = new HashSet<>();
      for (int i = 0; i < bank.length; i++) {
        if (isMutationPossible(gene, bank[i])) {
          cc.add(bank[i]);
        }
      }
      return cc;
    }

    @Override
    public boolean isTheSame(String node1, String node2) {
      return node1.equals(node2);
    }

    @Override
    public int size() {
      return bank.length;
    }

  }

}
