package graphBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import utils.graph.ShortestPathLength;
import utils.graph.SimpleGraph;

public class WordLadder {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    SimpleGraph<String> graph = buildWordMutationIndexGraph(wordList, beginWord);
    ShortestPathLength util = new ShortestPathLength();
    return util.findLength(graph, beginWord, endWord) + 1;
  }

  private static SimpleGraph<String> buildWordMutationIndexGraph(List<String> wordList, String beginWord) {
    TreeMap<String, TreeSet<String>> index = new TreeMap<>();

    ArrayList<String> cpy = new ArrayList<>(wordList);
    cpy.add(beginWord);

    final HashMap<String, HashSet<String>> preBuilt = new HashMap<>();
    for (String s : cpy) {
      final char[] chars = s.toCharArray();
      final int len = s.length();
      for (int i = 0; i < len; i++) {
        char[] newChars = Arrays.copyOf(chars, len);
        newChars[i] = '*';
        String mask = new String(newChars).intern();
        HashSet<String> cc1 = preBuilt.computeIfAbsent(mask, c -> new HashSet<>());
        cc1.add(s);
      }
    }

    for (HashSet<String> vv : preBuilt.values()) {
      for (String v : vv) {
        TreeSet<String> childs = index.computeIfAbsent(v, x -> new TreeSet<>());
        childs.addAll(vv);
        childs.remove(v);
      }
    }

    return SimpleGraph.ofMap(index);
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
  }

}
