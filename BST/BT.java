package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BT {
	
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
		TreeNode n3 = new TreeNode(9);
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
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		while(temp != null || !stack.isEmpty()) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
	
	public void postOrder(TreeNode root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public void postOrderIT(TreeNode root) {
		if(root == null)
			return;
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		while(current != null || !stack.isEmpty()) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			} else {
				TreeNode temp = stack.peek().right;
				if(temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while(!stack.isEmpty() && temp == stack.peek().right) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				} else {
					current = temp;
				}
			}
			
		}
	}
	
	public void levelOrder(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null) {
				q.offer(temp.left);
				}
			if(temp.right != null) {
				q.offer(temp.right);
			}
		}
		
	}
	
	public int maxValue(TreeNode root) {
		if(root == null)
			return 0;
		int result = root.data;
		int left = maxValue(root.left);
		int right = maxValue(root.right);
		
		if(left > result)
			result = left;
		if(right > result)
			result = right;
		return result;
	}
	
	

	public static void main(String[] args) {
		
		BT obj = new BT();
		
		obj.create();
		System.out.println("preOrder Rec:");
		obj.preOrder(obj.root);
		System.out.println();
		System.out.println("preOrder It:");
		obj.preOrderIT(obj.root);
		System.out.println();
		System.out.println("inOrder It:");
		obj.inOrder(obj.root);
		System.out.println();
		System.out.println("inOrder Rec:");
		obj.inOrderIT(obj.root);
		System.out.println();
		System.out.println("postOrder Rec:");
		obj.postOrder(obj.root);
		System.out.println();
		System.out.println("postOrder It:");
		obj.postOrder(obj.root);
		System.out.println();
		System.out.println("levelOrder:");
		obj.levelOrder(obj.root);
		System.out.println();
		
		int max = obj.maxValue(obj.root);
		System.out.println("Max value - " + max);
	}

}
