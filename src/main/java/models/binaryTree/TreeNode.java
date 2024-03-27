package models.binaryTree;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class TreeNode extends ATreeNode<TreeNode> {

  public static TreeNode ofList(List<Integer> asList) {
    return ATreeNode.ofList(asList, TreeNode::new, TreeNode[]::new);
  }

  public TreeNode() {
    super();
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    super(val, left, right);
  }

  public TreeNode(int val) {
    super(val);
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.ofList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

    System.out.println("original");
    System.out.println(root.toString());
    StringJoiner preorder = new StringJoiner(", ", "[", "]");
    preorder(root, i -> preorder.add(String.valueOf(i.val)));
    System.out.println("preorder");
    System.out.println(preorder.toString());

    StringJoiner iterativePreorder = new StringJoiner(", ", "[", "]");
    iterativePreorder(root, i -> iterativePreorder.add(String.valueOf(i.val)));
    System.out.println("iterativePreorder");
    System.out.println(iterativePreorder.toString());

    StringJoiner inorder = new StringJoiner(", ", "[", "]");
    inorder(root, i -> inorder.add(String.valueOf(i.val)));
    System.out.println("inorder");
    System.out.println(inorder.toString());

    StringJoiner inorderStack = new StringJoiner(", ", "[", "]");
    iterativeInorder(root, i -> inorderStack.add(String.valueOf(i.val)));
    System.out.println("inorder stack");
    System.out.println(inorderStack.toString());

    StringJoiner postorder = new StringJoiner(", ", "[", "]");
    postorder(root, i -> postorder.add(String.valueOf(i.val)));
    System.out.println("postorder");
    System.out.println(postorder.toString());

    StringJoiner iterativePostorder = new StringJoiner(", ", "[", "]");
    iterativePostorder(root, i -> iterativePostorder.add(String.valueOf(i.val)));
    System.out.println("iterativePostorder");
    System.out.println(iterativePostorder.toString());
  }

}
