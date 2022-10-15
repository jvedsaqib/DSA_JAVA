package tree;

import java.util.Stack;

public class BST {
	
	private TreeNode root;
	
	class TreeNode{
		private int data;
		private TreeNode right;
		private TreeNode left;
		
		TreeNode(int data){
			this.data = data;
		}
	}
	
	public void create() {
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(3);
		
		root = n1;
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		
	}
	
	public void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void preOrderIT(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	
	
	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public void inOrderIT(TreeNode root) {
		
	}
	
	
	
	

	public static void main(String[] args) {
		
		BST obj = new BST();
		
		obj.create();
		obj.preOrder(obj.root);
		System.out.println();
		obj.preOrderIT(obj.root);
		System.out.println();
		obj.inOrder(obj.root);
		System.out.println();
		obj.inOrderIT(obj.root);

	}

}
