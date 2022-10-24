package trie;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	class TrieNode{
		private TrieNode children[];
		private boolean isWord;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
		}	
	}
	
	public void insert(String word) {
		if(word == null || word.isEmpty())
			throw new IllegalArgumentException("Try Again");
		
		word = word.toLowerCase();
		TrieNode curr = root;
		for(int i = 0; i < word.length(); i++) {
			char chr = word.charAt(i);
			int index = chr - 'a';
			
			if(curr.children[index] == null) {
				TrieNode node = new TrieNode();
				curr.children[index] = node;
				curr = node;
			} else {
				curr = curr.children[index];
			}
		}
		curr.isWord = true;
	}

	
	
	
	// --------------------------------------------------
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("hello");

	}

}
