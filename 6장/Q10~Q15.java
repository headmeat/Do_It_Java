package john.john;

import java.util.Arrays;

class IntStack {
	int size;
	int ptr = -1;
	//int[] arr = new int[size];
	int[] arr;
	
	public IntStack(int size) {
		this.size = size;
		arr = new int[size];
	}
	
	public boolean isEmpty() {
		if(ptr==-1) return true;
		return false;
	}
	
	public int pop() {
		return arr[ptr--];
	}
	
	public void push(int item) { 
		arr[++ptr] = item;
	}
	
	public int peek() {
		return arr[ptr];
	}
}

public class Test {
	static void swap(int[] arr, int pl, int pr) {
		int tmp = arr[pl];arr[pl] = arr[pr];arr[pr] = tmp;
	}
	
	static void partition(int[] arr, int n) {
		int pl = 0;
		int pr = n-1;
		int pivot = arr[n/2];
		
		do {
			while(arr[pl]<=pivot) pl++;
			while(arr[pr]>=pivot) pr--;
			
			System.out.println("PL:"+pl);
			System.out.println("PR:"+pr);
			System.out.println();
			if(pl<=pr) swap(arr, pl++, pr--);
		}while(pl<=pr);
		
		System.out.println("Pivot is:"+(n/2));
		
		System.out.println("피벗 이하의 그룹");
		for(int i=0;i<=pl-1;i++) System.out.print(arr[i]+" ");
		System.out.println("\n");
		
		if(pl>pr+1) {
			System.out.println("피벗과 일치하는 그룹");
			for(int i=pr+1;i<=pl-1;i++) System.out.println(arr[i]+" \n");
		}
		
		System.out.println("피벗 이상의 그룹");
		for(int i=pr+1;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
	}
	
	static void insertionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=1;i<n;i++) {
			int tmp = arr[i];
			int j;
			
			for(j=i-1;j>=0&&arr[j]>tmp;j--) {
				arr[j+1] = arr[j];
			}
			
			arr[j+1] = tmp;
		}
	}
	
	static void sort(int[] arr, int a, int b) {
		if(arr[a]>arr[b]) {
			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
	}
	
	static void recurQuickSort(int[] arr, int left, int right) {
		IntStack lstack = new IntStack(right-left+1);
		IntStack rstack = new IntStack(right-left+1);
		
		lstack.push(left);
		rstack.push(right);
		
		while(!lstack.isEmpty()) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x;
			//int x = arr[(left+right)/2];
			
			/*
			if(pr-pl<8) {
				for(int i=pl+1;i<=pr;i++) {
					int tmp = arr[i];
					int j;
					
					for(j=i;j>pl&&arr[j-1]>tmp;j--) {
						arr[j] = arr[j-1];
					}
					
					arr[j] = tmp;
				}
				continue;
			}
			*/
			
			int mid = (pl+pr)/2;
			
			if(pr-pl>=3) {//나눌 요소가 3 이상이면(방법 1)
				sort(arr, pl, mid);
				sort(arr, mid, pr);
				sort(arr, pl, pr);
				
				System.out.println("ELEMENTS OVER 3");
				System.out.println(arr[pl]+" "+arr[mid]+" "+arr[pr]);
			}
			
			x = arr[mid];
			
			//pop
			System.out.println("팝: {"+pl+", "+pr+"}");
			
			do {
				while(arr[pl]<x) pl++;
				while(arr[pr]>x) pr--;
				
				if(pl<=pr) swap(arr, pl++, pr--);//이거 계속 놓침. ++, --
			}while(pl<=pr);
			
			if(pr - left<right - pl) {
				int tmp = pr;
				pr = right;
				right = tmp;
				
				tmp = left;
				left = pl;
				pl = tmp;
			}
			
			if(left<pr) {
				lstack.push(left);
				rstack.push(pr);
			}
			
			if(!lstack.isEmpty()) System.out.print("분할: {"+lstack.peek()+", "+rstack.peek()+"}");
			
			if(pl<right) {
				lstack.push(pl);
				rstack.push(right);
			}
			
			if(!lstack.isEmpty()) System.out.println(", {"+lstack.peek()+", "+rstack.peek()+"}\n");
		}
	}
	
	static void quickSortUtil(int[] arr, int left, int right) {//n은 요소의 개수: 이렇게 하려면 배열을 서브배열로 전달해줘야 할 듯
		int pl = left;
		int pr = right;
		int mid = (pl+pr)/2, pivot;
		
		if(pr-pl>=3) {
			sort(arr, pl, mid);
			sort(arr, mid, pr);
			sort(arr, pl, pr);
			
			int tmp = arr[mid];
			arr[mid] = arr[pr-1];
			arr[pr-1] = tmp;
			
			pl+=1;
			pr-=2;
			
			pivot = tmp;
		}else {
			pivot = arr[mid];
		}
		
		System.out.printf("a[%d]~a[%d] : {", left, right);
		
		for(int i=left;i<right;i++) System.out.printf("%d , ",arr[i]);
		System.out.printf("%d}\n", arr[right]);
		
		do {
			while(arr[pl]<pivot) pl++;
			while(arr[pr]>pivot) pr--;
			
			//swap할 때 다음 do..while 문에서 인덱스가 증가돼 있어야 함.
			//안 그러면 endless loop 되어버림.
			if(pl<=pr) swap(arr, pl++, pr--);
		}while(pl<=pr);
		
		if(left<pr) quickSortUtil(arr, left, pr);
		if(pl<right) quickSortUtil(arr, pl, right);
	}
	
	static void quickSort(int[] arr, int n) {
		quickSortUtil(arr, 0, n-1);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,4,15,5,23,214,3,4,16,};
		
		quickSort(arr, arr.length);
		
		System.out.println(Arrays.toString(arr));
	}
}
