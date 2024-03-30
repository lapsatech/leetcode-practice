package graphBFS;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

import utils.GraphMethods;
import utils.GraphMethodsImpl;
import utils.SimpleGraph;

public class WordLadder {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    SimpleGraph<String> graph = new WordMutationPreindexedGraph(wordList);
    GraphMethods util = new GraphMethodsImpl();
    return util.leastSteps(graph, beginWord, endWord) + 1;
  }

  private static class WordMutationPreindexedGraph implements SimpleGraph<String> {

    private Map<String, Collection<String>> index = new TreeMap<>();
    private final int size;

    private WordMutationPreindexedGraph(List<String> wordList) {
      this.size = wordList.size();
      for (String s : wordList) {
        forEachMaskOf(s, mask -> {
          Collection<String> cc1 = index.computeIfAbsent(mask, c -> new HashSet<>());
          cc1.add(s);
        });
      }

    }

    private static void forEachMaskOf(String s, Consumer<String> back) {
      final char[] chars = s.toCharArray();
      final int len = s.length();
      for (int i = 0; i < len; i++) {
        char[] newChars = Arrays.copyOf(chars, len);
        newChars[i] = '*';
        String mask = new String(newChars).intern();
        back.accept(mask);
      }
    }

    @Override
    public Collection<String> childs(String s) {
      HashSet<String> childs = new HashSet<>();
      forEachMaskOf(s, mask -> {
        if (s.equals(mask)) {
          return;
        }
        Collection<String> candidates = index.get(mask);
        if (candidates != null) {
          childs.addAll(candidates);
        }
      });
      childs.remove(s);
      return childs;
    }

    @Override
    public boolean isTheSame(String word1, String word2) {
      return word1.equals(word2);
    }

    @Override
    public int size() {
      return size;
    }
  }

  @SuppressWarnings("unused")
  private static class WordMutationDynamicGraph implements SimpleGraph<String> {

    private List<String> wordList;

    private WordMutationDynamicGraph(List<String> wordList) {
      this.wordList = wordList;
    }

    /**
     * Return true if two genes differs on just one letter
     */
    private boolean isMutationPossible(String word1, String word2) {
      int len = word1.length();
      if (len != word2.length()) {
        return false;
      }
      boolean oneMistmatch = false;
      for (int i = 0; i < len; i++) {
        if (word1.charAt(i) != word2.charAt(i)) {
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
    public Collection<String> childs(String word) {
      HashSet<String> cc = new HashSet<>();
      Iterator<String> ss = wordList.iterator();
      while (ss.hasNext()) {
        String s = ss.next();
        if (isMutationPossible(word, s)) {
          cc.add(s);
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
      return wordList.size();
    }

  }

}
