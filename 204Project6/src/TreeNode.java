/*
 * @Author-Steven Shiblie
 */

public class TreeNode<T>{
	
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	public TreeNode(T dataNode) {
		data = dataNode;
		left = null;
		right = null;
	}
	
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		left = node.left;
		right = node.right;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public TreeNode<T> getLeftChild(){
		return left;
	}
	
	public void setLeftChild(TreeNode<T> left){
		this.left = left;
	}
	
	public TreeNode<T> getRightChild(){
		return right;
	}
	
	public void setRightChild(TreeNode<T> right){
		this.right = right;
	}

}
