package john.john;

import java.util.Comparator;

public class LinkedList<E> {
	class Node<E> {
		private E data;
		private Node<E> next;
		//private Node next;
		
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> crnt;
	
	LinkedList() {
		head = crnt = null;
	}
	
	public void addFirst(E obj) {
		Node<E> node = new Node<E>(obj, head);
		head = crnt = node;
	}
	
	public void addLast(E obj) {
		Node<E> ptr = head;
		
		while(ptr.next!=null) {
			ptr = ptr.next;
		}
		
		ptr.next = crnt = new Node<E>(obj, null);
	}
	
	public void removeFirst() {
		if(head!=null) head = head.next;
	}
	
	public void removeLast() {
		if(head!=null) {
			if(head.next==null) removeFirst();
			else {
				Node<E> pre = head;
				Node<E> ptr = head;
				while(ptr.next!=null) {
					pre = ptr;
					ptr = ptr.next;
				}
				
				pre.next = null;
				crnt = pre;
			}
		}
	}
	//1. 앞쪽 노드를 찾음.
	//2. 앞쪽 노드를 뒤쪽뒤쪽 가리키게 만듬. 뒤쪽을 가리키는 건 없어짐.
	public void remove(Node<E> p) {
		if(head!=null) {
			if(p == head) removeFirst();
			else {
				Node<E> ptr = head;
				
				while(ptr.next!=p) {
					/*해당 else문에 처음 진입하고 여기까지 온 시점에서는 ptr.next는 이미 뭔가 있는 것
					 * 따라서 if문은 ptr = ptr.next 이후에 검사.
					 */
					ptr = ptr.next;
					if(ptr.next==null) return;
				}
				
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}
	
	public void purge(Comparator<? super E> c) {
		
	}
	
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	public void clear() {
		/*ver.01
		head = null;crnt = null;
		*//*
		*ver.02
		while(head!=null) head = head.next;
		*/
		
		while(head!=null) {
			removeFirst();
		}
		crnt = null;
	}
	
	public boolean next() {
		if(crnt!=null || crnt.next!=null) {
			crnt = crnt.next;
			return true;
		}
		return false;
	}
	
	public void printCurrentNode() {
		if(crnt == null) System.out.println("선택된 노드가 없습니다.");
		else System.out.println(crnt.data);
	}
	
	//모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		while(ptr!=null) {
			System.out.println(ptr.data+" ");
			ptr = ptr.next;
		}
	}
}
