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
public class Task2 {

    public static void main(String[] args) {

        TreeNode myTree = new TreeNode();

        TreeNode parent = myTree;

    

        printLevelOrder(myTree);
        
        heapify(myTree);

    }

    static void printLevelOrder(TreeNode root) {
        for (int i = 1; i <= 4; i++) {
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

   static void heapify(TreeNode myTree, int arrayLength, int rootElementIndex)
    {
        
        int leftIndex = 2*rootElementIndex + 1;  
        int rightIndex = 2*rootElementIndex + 2; 
        
        
        int largest = rootElementIndex;
        
        if (leftIndex < arrayLength && arr[leftIndex] > arr[largest])
            largest = leftIndex;
        
        if (rightIndex < arrayLength && arr[rightIndex] > arr[largest])
            largest = rightIndex;
        
        if (largest != rootElementIndex)
        {
            
            int swap = arr[rootElementIndex];
            arr[rootElementIndex] = arr[largest];
            arr[largest] = swap;
            
            heapify(arr, arrayLength, largest);
        }
    }
   static TreeNode generateTree(int arr[])
   {
        TreeNode myTree = new TreeNode();
        TreeNode parent = myTree;
        
        parent.data = arr[0];
        parent.left = new TreeNode(arr[1], parent);
        parent.right = new TreeNode(arr[2], parent);

        parent = myTree.left;

        parent.left = new TreeNode(arr[3], parent);
        parent.right = new TreeNode(arr[4], parent);

        parent = myTree.right;

        parent.left = new TreeNode(arr[5], parent);
        parent.right = new TreeNode(arr[6], parent);

        parent = myTree.left.left;

        parent.left = new TreeNode(arr[7], parent);
   }
}
