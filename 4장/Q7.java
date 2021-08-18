// 큐에 데이터를 인큐
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException(); // 큐가 가득 참
		
		switch(sw[0]) {
			case 0:
				if(front > 0) {
					que[--front] = x;
					sw[0] = 1;
					break;
				}
			case 1:
				if(rear < max) {
					que[rear++] = x;
					sw[1] = 0;
				}else {
					que[--front] = x;
					sw[0] = 1;
				}
		}
		
		num++;
		
		return x;
	}

	// 큐에서 데이터를 디큐
	public int deque() throws EmptyIntQueueException {
		int x = -1;
		
		if (num <= 0)
			throw new EmptyIntQueueException(); // 큐가 비어 있음
		
		switch(sw[1]) {
			case 0:
				if(front < max)
					x = que[front++];
				else
					front = 0;
				sw[1] = 1;
				break;
			case 1:
				if(rear > 0)
					x = que[--rear];
				else
					rear = 0;
				sw[1] = 0;
		}
		
		num--;
		return x;
	}
