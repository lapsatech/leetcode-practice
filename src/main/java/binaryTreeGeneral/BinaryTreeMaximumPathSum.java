package binaryTreeGeneral;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import models.binaryTree.BinaryTreeNode;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(BinaryTreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    // post order traversal of subtree rooted at `root`
    private int gainFromSubtree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);

        // return the max sum for a path starting at the root of subtree
        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }

  private BinaryTreeNode closestCommonAncestor(Map<BinaryTreeNode, BinaryTreeNode> parentsIndex, final BinaryTreeNode pp, final BinaryTreeNode qq) {

    Set<BinaryTreeNode> ancestors = new HashSet<>();

    BinaryTreeNode q = qq;
    BinaryTreeNode p = pp;

    while (p != null) {
      ancestors.add(p);
      p = parentsIndex.get(p);
    }

    while (q != null && !ancestors.contains(q)) {
      q = parentsIndex.get(q);
    }

    return q;
  }

  public int maxPathSum2(BinaryTreeNode root) {
    Map<BinaryTreeNode, BinaryTreeNode> parentsIndex = new HashMap<>();
    LinkedList<BinaryTreeNode> nodesIndex = new LinkedList<>();

    LinkedList<BinaryTreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      BinaryTreeNode node = stack.pop();
      nodesIndex.add(node);
      if (node.right != null) {
        stack.push(node.right);
        parentsIndex.put(node.right, node);
      }
      if (node.left != null) {
        stack.push(node.left);
        parentsIndex.put(node.left, node);
      }
    }

    if (nodesIndex.size() == 1) {
      return nodesIndex.getFirst().val;
    }

    int maximum = Integer.MIN_VALUE;

    while (!nodesIndex.isEmpty()) {
      BinaryTreeNode q = nodesIndex.poll();

      for (BinaryTreeNode p : nodesIndex) {
        BinaryTreeNode middle = closestCommonAncestor(parentsIndex, p, q);
        int ps = sum(parentsIndex, p, middle);
        int qs = sum(parentsIndex, q, middle);
        int sum = ps + qs + middle.val;
        maximum = Math.max(maximum, Math.max(sum, Math.max(p.val, q.val)));
      }

    }

    return maximum;
  }

  private int sum(Map<BinaryTreeNode, BinaryTreeNode> parentsIndex, final BinaryTreeNode node, final BinaryTreeNode ancestor) {
    BinaryTreeNode n = node;
    int sum = 0;
    while (n != ancestor) {
      sum += n.val;
      n = parentsIndex.get(n);
    }
    return sum;
  }

}
