package binaryTreeGeneral;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import models.binaryTree.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return iterativeLowestCommonAncestor(root, p, q);
  }

  private TreeNode iterativeLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    Map<Integer, TreeNode> parents = new HashMap<>();

    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    boolean pfound = false;
    boolean qfound = false;
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();

      pfound |= node.val == p.val;
      qfound |= node.val == q.val;

      if (node.right != null) {
        stack.push(node.right);
        parents.put(node.right.val, node);
      }
      if (node.left != null) {
        stack.push(node.left);
        parents.put(node.left.val, node);
      }

      if (pfound && qfound) {
        break;
      }

    }
    if (!qfound || !pfound) {
      return null;
    }

    Set<Integer> ancestorsOfP = new HashSet<>();
    while (p != null) {
      ancestorsOfP.add(p.val);
      p = parents.get(p.val);
    }

    while (!ancestorsOfP.contains(q.val)) {
      q = parents.get(q.val);
    }
    return q;
  }

}
