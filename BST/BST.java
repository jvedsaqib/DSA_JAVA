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
				"(4) search a Node", "(5) isChild", "(6) Delete a Node", "(7) getSuccesor", "(8) searchNodeParent"
				, "(9) getPredecessor"};
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
	
	public static TreeNode searchNodeParent(TreeNode root, int key) {
		TreeNode temp = root;
		TreeNode parent = root;
		
		if(temp == null)
			return null;
		
		while(temp != null || temp.data != key) {
			if(temp.data > key) {
				System.out.println("TRAVERSING LEFT");
				parent = temp;
				temp = temp.left;
				System.out.println(parent.data+" <- PARENT - NODE -> "+temp.data);
			}
			else if(temp.data < key) {
				System.out.println("TRAVERSING RIGHT");
				parent = temp;
				temp = temp.right;
				System.out.println(parent.data+" <- PARENT - NODE -> "+temp.data);
			}
			
			if(temp.data == key)
				break;
		}
		
		
		return parent;
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
	
	public static void deleteNode(TreeNode root, int key) {
		
		if(root == null || root.data == key)
			return;
		
		TreeNode temp = root;
		TreeNode parent = null;
		
		// case - 1
		while(temp != null) {
			if(temp.data > key) {
				System.out.println("TRAVERSING LEFT :: "+temp.data+" -> "+temp.left.data);
				// traverse left
				parent = temp;
				temp = temp.left;
				if(temp.data == key && !isLeftChild(temp) && !isRightChild(temp)) {
					System.out.println(temp.data+" has no child");
					parent.left = null;
					System.out.println(temp.data+" DELETED");
					temp = null;
				}
				else if(temp.data == key) {
					if( !isLeftChild(temp) || !isRightChild(temp)) {
						System.out.println(temp.data+" has one child");
						if(isLeftChild(temp)) {
							System.out.println(temp.data+" has left child");
							parent.left = temp.left;
							System.out.println(parent.data+" <-> "+temp.left.data);
							System.out.println(temp.data+" DELETED");
							temp = null;
						}
						else if(isRightChild(temp)) {
							System.out.println(temp.data+" has right child");
							parent.right = temp.right;
							System.out.println(parent.data+" <-> "+temp.right.data);
							System.out.println(temp.data+" DELETED");
							temp = null;
						}
					}
					else if(temp.data == key && parent.left.data == key) {
						if( isLeftChild(temp) && isRightChild(temp)) {
							System.out.println(temp.data+" has two child");
							// get successor and replace it with the node that will be deleted
							System.out.println(temp.data+" DELETED");
							int node = getSuccesor(temp.right).data;
							System.out.println(parent.data+" <-> "+node);
							temp = searchNodeParent(root, getSuccesor(temp.right).data);
							parent.left.data = node;
							temp.left = null;
							break;
						}
					}
				}
			}
			else if(temp.data < key) {
				// traverse right
				System.out.println("TRAVERSING RIGHT :: "+temp.data+" -> "+temp.right.data);
				parent = temp;
				temp = temp.right;
				if(temp.data == key && !isLeftChild(temp) && !isRightChild(temp)) {
					System.out.println(temp.data+" has no child");
					parent.right = null;
					System.out.println(temp.data+" DELETED");
					temp = null;
				}
				else if(temp.data == key) {
					if(!isLeftChild(temp) || !isRightChild(temp)) {
						System.out.println(temp.data+" has one child");
						if(isLeftChild(temp)) {
							System.out.println(temp.data+" has left child");
							parent.right = temp.left;
							System.out.println(parent.data+" <-> "+temp.left.data);
							System.out.println(temp.data+" DELETED");
							temp = null;
						}
						else if(isRightChild(temp)) {
							System.out.println(temp.data+" has right child");
							parent.right = temp.right;
							System.out.println(parent.data+" <-> "+temp.right.data);
							System.out.println(temp.data+" DELETED");
							temp = null;
						}
					}
					else if(temp.data == key && parent.right.data == key) {
						if( isLeftChild(temp) && isRightChild(temp)) {
							System.out.println(temp.data+" has two child");
							// get successor and replace it with the node that will be deleted
							System.out.println(temp.data+" DELETED");
							int node = getSuccesor(temp.right).data;
							System.out.println(parent.data+" <-> "+node);
							temp = searchNodeParent(root, getSuccesor(temp.right).data);
							parent.right.data = node;
							temp.right = null;
							break;
						}
					}
				}
			}	
		}
	}
	
	
	public static TreeNode getSuccesor(TreeNode root) {
		if(root == null)
			return root;
		if(root.left == null)
			return root;
		return getSuccesor(root.left);
	}
	
	
	public static TreeNode getPredecessor(TreeNode root) {
		if(root == null)
			return root;
		if(root.right == null)
			return root;
		return getPredecessor(root.right);
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
				case 6:
					System.out.println("Enter the node to delete: ");
					key = sc.nextInt();
					deleteNode(root, key);
					break;
				case 7:
					System.out.println("Enter the node to search: ");
					key = sc.nextInt();
					System.out.println(getSuccesor(searchNode(root, key).right).data);
					break;
				case 8:
					System.out.println("Enter the node to search its parent: ");
					key = sc.nextInt();
					TreeNode parent = searchNodeParent(root, key);
					System.out.println("PARENT - "+ parent.data);
					break;
				case 9:
					System.out.println("Enter the node to search: ");
					key = sc.nextInt();
					System.out.println(getPredecessor(searchNode(root, key).left).data);
					break;
				
					
				default:
					System.out.println("INVALID");
			}
		}
		
		
	}

}
