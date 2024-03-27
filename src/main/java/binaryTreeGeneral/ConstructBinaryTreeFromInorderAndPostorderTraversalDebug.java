package binaryTreeGeneral;

import java.util.Collections;

import models.binaryTree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalDebug {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildSubtree(0, postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private String dump(int[] array, int start, int end) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < array.length; i++) {
      if (i == start) {
        sb.append(">");
      }
      sb.append(String.valueOf(array[i]));
      if (i == end) {
        sb.append("<");
      }
      if (i < array.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("] (");
    sb.append(start);
    sb.append(", ");
    sb.append(end);
    sb.append(")");
    return sb.toString();
  }

  private TreeNode buildSubtree(
      int lvl,
      int[] postorder,
      int p_start,
      int p_end,
      int[] inorder,
      int i_start,
      int i_end) {

    String prefix = String.join("", Collections.nCopies(lvl, "  "));

    System.out.println(
        prefix + "this"
            + " postorder = " + dump(postorder, p_start, p_end)
            + " inorder = " + dump(inorder, i_start, i_end));

    if (p_end < 0 || p_end >= postorder.length) {
      return null;
    }

    TreeNode n = new TreeNode(postorder[p_end]);
    if (p_start == p_end) {
      return n;
    }

    for (int i = i_start; i <= i_end; i++) {
      if (inorder[i] == n.val) {
        int in_shift = i - i_start;

        int p_left_start = p_start;
        int p_left_end = p_start + in_shift - 1;
        int i_left_start = i_start;
        int i_left_end = i_start + in_shift - 1;

        if (p_left_start != p_left_end) {
          System.out.println(
              prefix + "left"
                  + " postorder = " + dump(postorder, p_left_start, p_left_end)
                  + " inorder = " + dump(inorder, i_left_start, i_left_end));
        }
        n.left = buildSubtree(lvl + 1, postorder, p_left_start, p_left_end, inorder, i_left_start, i_left_end);

        int p_right_start = p_start + in_shift;
        int p_right_end = p_end - 1;
        int i_right_start = i_start + in_shift + 1;
        int i_right_end = i_end;

        if (p_right_start != p_right_end) {
          System.out.println(
              prefix + "rght"
                  + " postorder = " + dump(postorder, p_right_start, p_right_end)
                  + " inorder = " + dump(inorder, i_right_start, i_right_end));
        }
        n.right = buildSubtree(lvl + 1, postorder, p_right_start, p_right_end, inorder, i_right_start, i_right_end);
        return n;
      }
    }
    return null;
  }
}
