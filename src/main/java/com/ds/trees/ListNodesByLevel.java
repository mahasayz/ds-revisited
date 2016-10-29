package com.ds.trees;

import com.ds.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Mahbub on 10/29/2016.
 */
public class ListNodesByLevel {

    public static void createListByLevel(TreeNode root, ArrayList<LinkedList<Integer>> lists, int level) {
        if (root == null) return;

        LinkedList<Integer> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else
            list = lists.get(level);

        list.add(root.data);
        createListByLevel(root.left, lists, level + 1);
        createListByLevel(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<Integer>> listNodesByLevel(TreeNode root) {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        createListByLevel(root, lists, 0);
        return lists;
    }

    public static void main(String[] args) {

        int[] array = {0,1,2,3,5,6,7,8,9,10};
        TreeNode root = TreeNode.createMinimalBST(array);

        root.print();

        int counter = 0;
        for (LinkedList<Integer> list : listNodesByLevel(root)) {
            System.out.println("Level " + counter);
            for (Integer val : list)
                System.out.printf("%d ", val);
            System.out.print("\n");
            counter++;
        }

    }
}
