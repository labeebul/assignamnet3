package jevi;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import java.util.Stack;


public class BST extends Thread {
	protected BSTNode root = null;
	String fn ;
	protected BST bs=null;

    public BST()
    {
    	
    }

    
   
    
    public void insert(String data) 
    {
    	boolean g= false;
		BSTNode p = root, prev = null;
		    while (p != null) {
		        prev = p;
		        if (p.data.compareTo(data) < 0)
		            p = p.right;
		        else if(p.data==data) {
		        		g=true;
		        		break;
		        }
		        else 
		        	p = p.left;
		    }
		    if(g!=true)
		    {
		    	
		    if (root == null)
		        root = new BSTNode(data);
		    else if (prev.data.compareTo(data) < 0)
		        prev.right = new BSTNode(data);
		    else prev.left  = new BSTNode(data);
		    
		    }
    }   

   
    
    public void displayB() // display search tree
    {
        Stack<BSTNode> treeStack = new Stack<BSTNode>();
        treeStack.push(root);
        int numOfBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("\n");

        while (isRowEmpty == false) {
            Stack<BSTNode> localStack = new Stack<BSTNode>();
            isRowEmpty = true;

            for (int x = 0; x < numOfBlanks; x++)
                System.out.print(" ");

            while (treeStack.isEmpty() == false) {
                BSTNode temp = (BSTNode)treeStack.pop();
                if (temp != null)
                {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null || temp.right != null)
                        isRowEmpty = false;
                }
                    else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }

                    for (int y = 0; y < numOfBlanks*2-2; y++)
                        System.out.print(" ");
                }
            System.out.println();
            numOfBlanks /= 2;
            while (localStack.isEmpty() == false)
                treeStack.push(localStack.pop());

        }
        System.out.println();
    }

}
