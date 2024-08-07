package models.binaryTree;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public abstract class Node<T extends Node<T>> {

  protected static <T extends Node<T>> T ofList(List<Integer> ary, IntFunction<T> ctor, IntFunction<T[]> aryctor) {
    if (ary == null || ary.size() == 0) {
      return null;
    }

    int lvl = 0;
    int shift = 1;

    T root = ctor.apply(ary.get(0));
    T[] prev = aryctor.apply(1);
    prev[0] = root;
    while (shift < ary.size()) {
      int countexpected = 2 << lvl;
      T[] current = aryctor.apply(countexpected);

      for (int i = 0; i < countexpected; i += 2) {
        if (shift + i < ary.size()) {

          Integer lv = ary.get(shift + i);
          if (lv != null) {
            current[i] = ctor.apply(lv.intValue());
            prev[i / 2].left = current[i];
          }

          if (shift + i + 1 < ary.size()) {

            Integer rv = ary.get(shift + i + 1);
            if (rv != null) {
              current[i + 1] = ctor.apply(rv.intValue());
              prev[i / 2].right = current[i + 1];
            }
          }
        }
      }
      prev = current;
      shift += countexpected;
      lvl++;
    }
    return root;
  }

  public static <T extends Node<T>> void preorder(Node<T> root, Consumer<? super Node<T>> visitor) {
    visitor.accept(root);
    if (root.left != null) {
      preorder(root.left, visitor);
    }
    if (root.right != null) {
      preorder(root.right, visitor);
    }
  }

  public static <Q, T extends Node<T>> void inorder(final T root, Consumer<T> visitor) {
    if (root.left != null) {
      inorder(root.left, visitor);
    }
    visitor.accept(root);
    if (root.right != null) {
      inorder(root.right, visitor);
    }
  }

  public static <T extends Node<T>> void postorder(final T root, Consumer<T> visitor) {
    if (root.left != null) {
      postorder(root.left, visitor);
    }
    if (root.right != null) {
      postorder(root.right, visitor);
    }
    visitor.accept(root);
  }

  public static <T extends Node<T>> void iterativePreorder(final T root, Consumer<T> visitor) {

    LinkedList<T> stack = new LinkedList<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      T node = stack.pop();
      visitor.accept(node);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
  }

  public static <T extends Node<T>> void iterativeInorder(final T root, Consumer<T> visitor) {
    LinkedList<T> stack = new LinkedList<>();
    T node = root;

    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        node = stack.pop();
        visitor.accept(node);
        node = node.right;
      }
    }
  }

  public static <T extends Node<T>> void iterativePostorder(final T root, Consumer<T> visitor) {

    LinkedList<T> stack = new LinkedList<>();
    T node = root;
    T lastNodeVisited = null;

    while (!stack.isEmpty() || node != null) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        T peekNode = stack.peek();
        if (peekNode.right != null && lastNodeVisited != peekNode.right) {
          node = peekNode.right;
        } else {
          lastNodeVisited = stack.pop();
          visitor.accept(lastNodeVisited);
        }
      }
    }
  }

  public static void linearPerfectTraverse(final Node<?> root, Consumer<Node<?>> visitor) {
    LinkedList<Node<?>> q = new LinkedList<>();

    Set<Node<?>> visited = new HashSet<>();

    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node<?> t = q.removeLast();
        if (t != null) {
          if (visited.add(t)) {
            visitor.accept(t);
            q.addFirst(t.left);
            q.addFirst(t.right);
          }
        } else {
          visitor.accept(null);
        }
      }
    }
  }

  public static List<Integer> toList(Node<?> root) {
    if (root == null) {
      return Collections.emptyList();
    }
    LinkedList<Integer> res = new LinkedList<>();
    linearPerfectTraverse(root, n -> res.addLast(n == null ? null : n.val));
    Integer last = null;
    while ((last = res.removeLast()) == null) {
    }
    res.addLast(last);
    return res;
  }

  public List<Integer> toList() {
    return toList(this);
  }

  public int val;
  public T left;
  public T right;

  public Node() {
  }

  public Node(int val) {
    this.val = val;
  }

  public Node(int val, T left, T right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return String.valueOf(toList());
  }
}
