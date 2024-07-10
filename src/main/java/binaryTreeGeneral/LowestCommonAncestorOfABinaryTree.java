package binaryTreeGeneral;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import models.binaryTree.BinaryTreeNode;

public class LowestCommonAncestorOfABinaryTree {

  public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
    return iterativeLowestCommonAncestor(root, p, q);
  }

  private BinaryTreeNode iterativeLowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {

    Map<Integer, BinaryTreeNode> parents = new HashMap<>();

    LinkedList<BinaryTreeNode> stack = new LinkedList<>();
    stack.push(root);
    boolean pfound = false;
    boolean qfound = false;
    while (!stack.isEmpty()) {
      BinaryTreeNode node = stack.pop();

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
