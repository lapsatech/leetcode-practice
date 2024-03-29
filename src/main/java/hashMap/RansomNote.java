package hashMap;

public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] index = new int[26];
    magazine.chars().forEach(i -> index[i - 'a']++);

    for (int i : ransomNote.toCharArray()) {
      if (index[i - 'a']-- == 0) {
        return false;
      }
    }
    return true;
  }
}
