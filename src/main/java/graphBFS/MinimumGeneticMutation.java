package graphBFS;

import java.util.Collection;
import java.util.HashSet;

import utils.graph.Graph;
import utils.graph.Graphs;

public class MinimumGeneticMutation {

  public int minMutation(String startGene, String endGene, String[] bank) {
    Graph<String> graph = new GeneMutationGraph(bank);
    return Graphs.shortestPathLength(graph, startGene, endGene);
  }

  private static class GeneMutationGraph implements Graph<String> {

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
  }

}
