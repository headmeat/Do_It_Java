public class IntQueue {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;
	
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {}
	}
	
	public boolean isEmpty() {
		if(front == rear) return true;
		else return false;
	}
	
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public void enque(int item) throws OverflowIntQueueException {
		if(rear==max) {
			throw new OverflowIntQueueException();
		}
		
		que[rear++] = item;
	}
	
	public int deque() throws EmptyIntQueueException {
		if(front==rear) {
			throw new EmptyIntQueueException();
		}
		
		int val = que[front];
		
		for(int i=front+1;i<rear;i++) {
			que[i-1] = que[i];
		}
		
		rear -= 1;
		
		return val;
	}
	
	public static void main(String[] args) {
		IntQueue que = new IntQueue(5);
		
		for(int i=0;i<que.max;i++) {
			System.out.println("Enque");
			que.enque(i);
		}
		
		for(int i=0;i<que.rear;i++) {
			System.out.println("Sweep thru");
			System.out.println(que.que[i]);
		}
		
		while(!que.isEmpty()) {
			System.out.println("Deque");
			System.out.println(que.deque());
		}
	}
}
