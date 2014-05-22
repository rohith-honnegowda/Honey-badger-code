package com.Test.CareerCup;


class Node {
	int data;
	Node left;
	Node right;
	
	Node(){
		data = -9999;
		right = null;
		left = null;
	}
	
	Node(int data){
		this.data = data;
		right = null;
		left = null;
	}
}

public class Tree {

	Node head = new Node();
	
	void addNode(Node node){
		
		if(head == null){
			head = node;
			return;
		}
		
		Node tempHead = head;
		
		while(node != null){
			if(node.data < tempHead.data){
				if(tempHead.left == null){
					tempHead.left = node;
					return;
				}else{
					tempHead = tempHead.left;
				}
			}else if(node.data >= tempHead.data){
				if(tempHead.right == null){
					tempHead.right = node;
					return;
				}
				else{
					tempHead = tempHead.right;
				}
			}
		}

		
	}
	
	
	void inOrderTraversal(Node head){
		if(head == null){
			displayNode(head);
			return;
		}
		if(head.left != null){
			inOrderTraversal(head.left);
			
		}
		displayNode(head);
		if(head.right != null){
			inOrderTraversal(head.right);
			
		}
	}
	
	void displayNode(Node node){
		if(node == null){
			System.out.println("Node: null");
			return;
		}
		System.out.println("Node: "+node.data);
	}
	
	
	void createTree(){
		
		this.head.data = 99;
		
		this.addNode(new Node(89));
		this.addNode(new Node(79));
		this.addNode(new Node(69));
		this.addNode(new Node(88));
		this.addNode(new Node(98));
		this.addNode(new Node(109));
		this.addNode(new Node(108));
		this.addNode(new Node(111));
		this.addNode(new Node(110));
		this.addNode(new Node(115));
	}
	public static void main(String[] args) {
		System.out.println("****************Trees******************");
		Tree tree = new Tree();
		tree.createTree();
		tree.inOrderTraversal(tree.head);
	}

}
