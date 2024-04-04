package arrayString;

public class JumpGameII {

  public int jump(int[] nums) {
    return jump2(nums);
  }

  // iterative version
  static int jump2(int[] nums) {
    if (nums.length == 0) {
      return -1;
    }
    int stepCount = 0;
    int rightPos = nums.length - 1;
    while (rightPos != 0) {
      int mostLeftPos = rightPos - 1;
      for (int pos = rightPos - 1; pos >= 0; pos--) {
        if (nums[pos] >= rightPos - pos) {
          mostLeftPos = pos;
        }
      }
      rightPos = mostLeftPos;
      stepCount++;
    }
    return stepCount;
  }

  // int array queue bfs version
  static int jump1(int[] nums) {

    if (nums.length == 1) {
      return 0;
    }

    boolean[] visited = new boolean[nums.length];
    IntArrayQueue q = new IntArrayQueue(nums.length);
    q.offer(0);
    visited[0] = true;

    int level = 0;
    while (!q.isEmpty()) {
      int s = q.size();
      for (int i = 0; i < s; i++) {
        int position = q.poll();
        if (position == nums.length - 1) {
          return level;
        }
        final int positionAfterMaxPossibleJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = positionAfterMaxPossibleJump; nextPosition > position; nextPosition--) {
          if (visited[nextPosition]) {
            continue;
          }
          q.offer(nextPosition);
          visited[nextPosition] = true;
        }
      }
      level++;
    }
    return level;
  }

  public static class IntArrayQueue {
    private final int[] queue;
    private int si = 0;
    private int len = 0;

    public IntArrayQueue(int size) {
      this.queue = new int[size];
    }

    public boolean isEmpty() {
      return len == 0;
    }

    public void offer(int v) {
      if (si + len == queue.length) {
        throw new IllegalStateException("Queue is full");
      }
      queue[si + len++] = v;
    }

    public int poll() {
      if (len == 0) {
        throw new IllegalStateException("Queue is empty");
      }
      int v = queue[si];
      si++;
      len--;
      return v;
    }

    public int size() {
      return len;
    }
  }

}
