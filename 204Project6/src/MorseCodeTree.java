/*
 * @Author-Steven Shiblie
 */

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	public MorseCodeTree() {
		root = new TreeNode<>("");
		buildTree();
	}
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				root.setLeftChild(new TreeNode<>(letter));
			}
			else {
				root.setRightChild(new TreeNode<>(letter));
			}
			return;
		}
		
		char direction = code.charAt(0);
		String remainder = code.substring(1);
		
		if(direction == '.') {
			if(root.getLeftChild() == null) {
				root.setLeftChild(new TreeNode<String>(""));
			}
			addNode(root.getLeftChild(), remainder, letter);
		}
		else {
			if(root.getRightChild() == null) {
				root.setRightChild(new TreeNode<String>(""));
			}
			addNode(root.getRightChild(), remainder, letter);
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				return root.getLeftChild().getData();
			}
			else {
				return root.getRightChild().getData();
			}
		}
		
		char direction = code.charAt(0);
		String remainder = code.substring(1);
		
		if(direction == '.') {
			return fetchNode(root.getLeftChild(), remainder);
		}
		else {
			return fetchNode(root.getRightChild(), remainder);
		}
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Deletion not supported");
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Deletion not supported");
	}

	@Override
	public void buildTree() {
		//Level 1
		insert(".", "e");
		insert("-", "t");
		//Level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		//Level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		//Level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null) {
			return;
		}
		
		LNRoutputTraversal(root.getLeftChild(), list);
		
		list.add(root.getData());
		
		LNRoutputTraversal(root.getRightChild(), list);
	}
}
