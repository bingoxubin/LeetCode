package com.epoint.bigdata;

import java.util.LinkedList;
import java.util.List;

public class ReverseList {
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.insertFirst(1);
		linkList.insertFirst(2);
		linkList.insertFirst(3);
		linkList.insertFirst(4);
		linkList.display();

		// linkList.deleteFirst();
		// linkList.display();

		// ListNode node = linkList.find(23);
		// node.display();

		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.forEach(i -> System.out.print(i + " "));
	}
}

// 链表中的节点
class Node {
	int val;
	Node nextNode;

	Node(int val) {
		this.val = val;
		this.nextNode = null;
	}

	public void display() {
		System.out.print(val + " ");
	}
}

// 链表
class LinkList {
	private Node first;

	public LinkList() {
		first = null;
	}

	public void insertFirst(int val) {
		Node node = new Node(val);
		node.nextNode = first;
		first = node;
	}

	public Node deleteFirst() {
		Node tmp = first;
		first = tmp.nextNode;
		return tmp;
	}

	public void display() {
		Node node = first;
		while (node != null) {
			node.display();
			node = node.nextNode;

		}
		System.out.println();
	}

	public Node find(int val) {
		Node node = first;
		while (node.val != val) {
			if (node.nextNode == null) {
				return null;
			}
		}
		return node;
	}

	public Node reverseList(Node head) {
		Node prev = null;
		Node node = null;
		Node current = head;
		while (current != null) {
			Node next = current.nextNode;
			if (next == null) {
				node = current;
			}
			current.nextNode = prev;
			prev = current;
			current = next;
		}
		return node;
	}

	public void reverseDisplay() {
	}
}
