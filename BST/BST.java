package tree;


public class BST {
	static TreeNode root;
	
	private class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		
		public TreeNode(int data){
			this.data = data;
		}
	}
	
	public void insert(int value) {
		root = insertNode(root, value);
	}
	
	public TreeNode insertNode(TreeNode root, int value) {
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
	
	public void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	

	public static void main(String[] args) {
		BST obj = new BST();
		
		obj.insert(8);
		obj.insert(9);
		obj.insert(1);
		obj.insert(2);
		obj.insert(19);
		
		obj.inOrder(root);

	}

}
