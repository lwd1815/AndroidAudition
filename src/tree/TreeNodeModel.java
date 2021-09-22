package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TreeNodeModel {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[]{
                1, 3, 4, null, null, 8, null, null, 2, null, 6, null, 9}));
        TreeNode treeNode = creatBinaryTree(linkedList);
        pre(treeNode);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        mid(treeNode);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        next(treeNode);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Pre(treeNode);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Mid(treeNode);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Next(treeNode);
    }

    public static TreeNode creatBinaryTree(LinkedList<Integer> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        TreeNode node = null;

        Integer data = linkedList.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = creatBinaryTree(linkedList);
            node.rightChild = creatBinaryTree(linkedList);
        }
        return node;
    }

    //递归前序遍历
    public static void pre(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.println("data===" + treeNode.data);
        pre(treeNode.leftChild);
        pre(treeNode.rightChild);
    }

    //递归中序遍历
    public static void mid(TreeNode treeNode) {
        if (treeNode == null) return;
        mid(treeNode.leftChild);
        System.out.println("data===" + treeNode.data);
        mid(treeNode.rightChild);
    }

    //递归后序遍历
    public static void next(TreeNode treeNode) {
        if (treeNode == null) return;
        next(treeNode.leftChild);
        next(treeNode.rightChild);
        System.out.println("data===" + treeNode.data);
    }

    //利用栈做前序遍历

    public static void Pre(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = treeNode;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println("非递归==" + root.data);
                stack.push(root);
                root = root.leftChild;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.rightChild;
            }
        }
    }

    //非递归中序遍历

    public static void Mid(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = treeNode;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println("非递归==" + root.data);
                root = root.rightChild;
            }
        }
    }

    //非递归后序遍历

    public static void Next(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = treeNode;
        TreeNode pre = null;
        TreeNode top = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty()) {
                top = stack.peek();
                if (top.rightChild != null && top.rightChild != pre) {
                    root = top.rightChild;
                } else {
                    root=stack.pop();
                    pre = root;
                    System.out.println("非递归==" + pre.data);
                    root = null;
                }
            }
        }
    }
}
