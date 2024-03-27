package arrayString;

public class MergeSortedArray {
//  complexity O(m+n)
  public void merge(int[] mm, int m, int[] nn, int n) {
    if (mm.length != m + n || nn.length != n) {
      throw new IllegalArgumentException();
    }

    if (n == 0) {
      return;
    }

    int tail = m + n - 1;
    m--;
    n--;
    while (m >= 0 && n >= 0) {
      if (nn[n] >= mm[m]) {
        mm[tail] = nn[n];
        n--;
      } else {
        mm[tail] = mm[m];
        m--;
      }
      tail--;
    }
    while (n > 0) {
      mm[tail] = nn[n];
      n--;
      tail--;
    }
  }

  public static void main(String[] args) {
    MergeSortedArray s = new MergeSortedArray();
    int[] nums1 = { 0, 4, 100, 0, 0, 0 };
    int[] nums2 = { 3, 5, 6 };
    s.merge(nums1, 3, nums2, 3);
    for (int i = 0; i < nums1.length; i++) {
      System.out.println(i + ": " + nums1[i]);
    }
  }
}
