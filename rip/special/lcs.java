package rip.special;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> pPath = nodeToRootPath(root, p);

        ArrayList<TreeNode> qPath = nodeToRootPath(root, q);

        for (TreeNode n : pPath) {
            System.out.print(n.val + " ");
        }

        System.out.println();

        for (TreeNode n : qPath) {
            System.out.print(n.val + " ");
        }


        return findLCA(pPath, qPath);

    }

    public ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode p) {

        if (root == null) {
            return new ArrayList<>();
        }

        if (root.val == p.val) {
            ArrayList<TreeNode> baseCase = new ArrayList<>();
            baseCase.add(p);
            return baseCase;
        }

        ArrayList<TreeNode> result = nodeToRootPath(root.left, p);

        if (!result.isEmpty()) {
            result.add(root);
        }

        result = nodeToRootPath(root.right, p);

        if (!result.isEmpty()) {
            result.add(root);
        }

        return result;

    }

    public TreeNode findLCA(ArrayList<TreeNode> pPath, ArrayList<TreeNode> qPath) {

        int i = 0;

        while (i < pPath.size() && i < qPath.size() && pPath.get(i).val != qPath.get(i).val) {
            i++;
        }

        return pPath.get(i - 1);

    }
}