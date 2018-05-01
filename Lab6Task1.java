/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author ktj2012
 */
public class Lab6Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {5, 2, 40, -1, 3, 0, 8};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        TreeNode myTree = new TreeNode();

        TreeNode parent = myTree;

        parent.data = arr[0];
        parent.left = new TreeNode(arr[1], parent);
        parent.right = new TreeNode(arr[2], parent);

        parent = parent.left;

        parent.left = new TreeNode(arr[3], parent);
        parent.right = new TreeNode(arr[4], parent);

        parent = parent.parent.right;

        parent.left = new TreeNode(arr[5], parent);
        parent.right = new TreeNode(arr[6], parent);

        printLevelOrder(myTree);
    }

    static void printLevelOrder(TreeNode root) {
        for (int i = 1; i <= 3; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    static void printGivenLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.data);
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

}
