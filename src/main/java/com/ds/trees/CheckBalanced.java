package com.ds.trees;

import com.ds.utils.TreeNode;

/**
 * Created by Mahbub on 10/29/2016.
 */


public class CheckBalanced {

    public static int checkBalanced(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = checkBalanced(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = checkBalanced(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (checkBalanced(root) == -1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,5,6,7,8,9,10};

        TreeNode root = TreeNode.createMinimalBST(array);

        System.out.println("BALANCED : " + isBalanced(root));
        root.print();
        root.insertInOrder(4);
        System.out.println("BALANCED : " + isBalanced(root));
        root.print();
    }

}
