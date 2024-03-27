package hashMap;

public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] letters = new int[26];

    int l = s.length();
    for (int i = 0; i < l; i++) {
      letters[s.charAt(i) - 'a']++;
    }
    l = t.length();
    for (int i = 0; i < l; i++) {
      int idx = t.charAt(i) - 'a';
      if (letters[idx] == 0) {
        return false;
      }
      letters[idx]--;
    }
    return true;
  }
}
