package john.john;
import java.util.Comparator;
// 해당 정답 메서드는 소스 코드의 맨 아래쪽에 있습니다.

public class LinkedList_09_01<E> {
	// 노드
	class Node<E> {
		private E data; // 데이터
		private Node<E> next; // 뒤쪽 포인터(다음 노드 참조）

		// 생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // 머리 노드
	private Node<E> crnt; // 선택 노드
	private Node<E> tail;

	// 생성자
	public LinkedList_09_01() {
		head = crnt = tail = null;
	}

	// 노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // 현재 scan중인 노드

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) { // 검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // 다음 노드를 선택
		}
		return null; // 검색 실패
	}

	// 머리에 노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head; // 삽입 전의 머리 노드
		
		head = crnt = new Node<E>(obj, ptr);
		if(tail == null) tail = head;
	}

	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		if (head == null) // 리스트가 비어 있으면
			addFirst(obj); // 머리에 삽입
		else {
			Node<E> ptr = tail.next = new Node<E>(obj, null);
			tail = crnt = ptr;
		}
	}

	// 머리 노드 삭제
	public void removeFirst() {
		if (head != null) // 리스트가 비어있지 않으면
			head = crnt = head.next;
			if (head==null) tail = null; //이 부분은 내가 놓치고 작성 못했던 부분.
	}

	// 꼬리 노드 삭제
	public void removeLast() {
		if (head != null) {
			if (head.next == null) // 노드가 하나만 있으면
				removeFirst(); // 머리 노드를 삭제
			else {
				Node<E> ptr = head; // 스캔 중인 노드
				Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				tail = pre.next = null; // pre는 삭제 후의 꼬리 노드
				crnt = pre;
			}
		}
	}

	// 노드 p를 삭제
	public void remove(Node<E> p) {
		if (head != null) {
			if (p == head) // p가 머리 노드면
				removeFirst(); // 머리 노드를 삭제
			else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null)
						return; // p가 리스트에 없습니다.
				}
				ptr.next = p.next;
				if(ptr.next == null) tail = ptr;
				crnt = ptr;
			}
		}
	}

	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}

	// 모든 노드를 삭제
	public void clear() {
		while (head != null) // 노드에 아무것도 없을 때까지
			removeFirst(); // 머리 노드를 삭제
		crnt = null;
	}

	// 선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false; // 이동할 수 없음
		crnt = crnt.next;
		return true;
	}

	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}

	// 모든 노드를 출력(return 값 int로 변경: 책과 다름)
	public void dump() {
		Node<E> ptr = head;
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	public int count() {
		Node<E> ptr = head;
		int cnt = 0;
		
		while(ptr!=null) {
			cnt += 1;
			ptr = ptr.next;
		}
		
		return cnt;
	}
	
	// ------------------------------ 연습9-1 ------------------------------//
	// comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	// 책에 나오는 코드
	public void purge(Comparator<? super E> c) {
		Node<E> ptr = head;

		while (ptr != null) {
			int count = 0;
			Node<E> ptr2 = ptr;
			Node<E> pre = ptr;

			while (pre.next != null) {
				ptr2 = pre.next;
				if (c.compare(ptr.data, ptr2.data) == 0) {
					/*아래 라인이 내 코드랑 다름.
					 * 본 while문에서 비교해나가면서 제거함.
					 * 함수의 마지막에서 ptr를 제거함.
					 * 난 remove를 호출하고 마찬가지로 마지막에서 ptr를 제거함.
					*/
					pre.next = ptr2.next;
					if(ptr2.next == null) tail = pre;
					count++;
				} else
					pre = ptr2;
			}
			if (count == 0)
				ptr = ptr.next;
			else {
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		}
		crnt = head;
	}
	
	//내가 짠 코드
	public void custom_purge(Comparator<? super E> c) {
		boolean sw = false;
		
		for(Node<E> ptr = head;ptr!=null;ptr = ptr.next) {
			E data = ptr.data;
			Node<E> tmp = ptr.next, pre = ptr;
			
			for(;tmp!=null;pre = tmp,tmp = tmp.next) {
				if(c.compare(data, tmp.data) == 0) {
					//remove(tmp);//여기서 remove를 호출하면 지금 보고 있는 tmp가 아니라 제일 앞의 ptr가 먼저 삭제됨. 문제가 될 수 있음.
					pre.next = tmp.next;
					if(pre.next==null) tail = pre;
					sw = true;
				}
			}
			
			if(sw) remove(ptr);
			sw = false;
		}
	}
	
	//my code
	public E custom_retrieve(int n) {
		if(n<0 || n>=count() || head == null) return null;

		Node<E> ptr = head;
		
		while(n-->0 && ptr!=null) ptr = ptr.next;
		
		return (crnt = ptr).data;
	}
	
	//book code
	public E retrieve(int n) {
		Node<E> ptr = head;

		while (n >= 0 && ptr != null) {
			if (n-- == 0) {
				crnt = ptr;
				return ptr.data; // 검색성공
			}
			ptr = ptr.next; // 뒤쪽노드에 주목
		}
		return (null);
	}
	
	// ------------------------------ 연습9-1 ------------------------------//
	public static void main(String[] args) {
		LinkedList_09_01<Integer> lst = new LinkedList_09_01<>();
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		
		lst.addFirst(0);
		for(int i=1;i<10;i++) {
			lst.addLast(i);
		}
		lst.addFirst(5);
		lst.addLast(5);
		lst.addLast(9);
		
		
		System.out.println("DUMP1: ");lst.dump();System.out.println();
		lst.custom_purge(c);
		System.out.println("DUMP2: ");lst.dump();
		
		//System.out.println(lst.custom_retrieve(5));
	}
}
