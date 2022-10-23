package tree;
import java.util.*;

public class BST {
	static TreeNode root;
	
	private static class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		
		public TreeNode(int data){
			this.data = data;
		}
	}
	
	public static String[] qnArr() {
		String q_str[] = {"(0) Exit", "(1) insert a node", "(2) inOrder traversal" , "(3) preOrder traversal",
				"(4) search a Node", "(5) isChild"};
		return q_str;
	}
	
	public static void insert(int value) {
		root = insertNode(root, value);
	}
	
	public static TreeNode insertNode(TreeNode root, int value) {
		if(root == null) {
			TreeNode temp = new TreeNode(value);
			root = temp;
			return root;
		}
		
		if(value < root.data)
			root.left = insertNode(root.left, value);
		else
			root.right = insertNode(root.right, value);
		
		return root;
		
	}
	
	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static TreeNode searchNode(TreeNode root, int key) {
		if(root == null || root.data == key)
			return root;
		if(key < root.data)
			return searchNode(root.left, key);
		else
			return searchNode(root.right, key);
		
	}
	
	public static boolean isLeftChild(TreeNode root) {
		if(root.left != null)
			return true;
		else
			return false;
	}
	
	public static boolean isRightChild(TreeNode root) {
		if(root.right != null)
			return true;
		else
			return false;
	}
	
	
	

	public static void main(String[] args) {
		boolean response = true;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		String str[] = qnArr();
	
		while(response) {
			System.out.println();
			for(String i : str)
				System.out.print(i + "\n");
			System.out.println(":: Enter your choice ::");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					response = false;
					break;
					
				case 1:
					System.out.println("Enter value: ");
					int val = sc.nextInt();
					insert(val);
					break;
					
				case 2:
					inOrder(root);
					break;
					
				case 3:
					preOrder(root);
					break;
				case 4:
					System.out.println("Enter the node to search: ");
					int key = sc.nextInt();
					TreeNode node = searchNode(root, key);
					
					if(node != null) 
						System.out.println("Found");
					else
						System.out.println("Not Found");
					break;
				case 5:
					System.out.println("Enter the node to search for its child: ");
					key = sc.nextInt();
					System.out.println("Left Child : " + isLeftChild(searchNode(root, key)));
					System.out.println("Right Child : " + isRightChild(searchNode(root, key)));
					break;
				default:
					System.out.println("INVALID");
			}
		}
		
		
	}

}
