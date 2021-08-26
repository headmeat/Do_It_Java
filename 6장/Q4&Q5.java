package john.john;

import java.util.Arrays;

class BubbleSort {
	static int cnt = 0;
	static int swap_c = 0;
	
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	static void printArr(int[] arr, int idx, boolean action) {
		for(int i=0;i<arr.length;i++) {
			if(i == idx && action == true) {
				System.out.print(arr[i]+" + ");
			}else if(i == idx && action == false) {
				System.out.print(arr[i]+" - ");
			}else {
				System.out.print(arr[i]+"   ");
			}
		}
		System.out.println();
	}
	
	static int front2back(int[] arr, int last) {//last는 n부터
		int tmp = last;
		
		for(int i=1;i<last;i++) {
			cnt++;
			if(arr[i]<arr[i-1]) {
				swap_c++;
				swap(arr, i, i-1);
				last = i;
			}
		}
		
		if(tmp==last) return -1;
		
		return last;
	}
	
	static int back2front(int[] arr, int last) {//last는 0부터
		int n = arr.length;
		int tmp = last;
		
		for(int i=n-1;i>last;i--) {
			cnt++;
			if(arr[i]<arr[i-1]) {
				swap_c++;
				last = i;
				swap(arr, i-1, i);
			}
		}
		
		if(tmp==last) return -1;
		return last;
	}
	
	static void cockSort(int[] arr) {//칵테일 정렬
		int k = arr.length;
		boolean sw = false;
		int[] last = {0, k};
		System.out.println(Arrays.toString(last));
		while(true) {
			if(sw) {//앞에서부터
				last[1] = front2back(arr, last[1]);
				sw = false;
			}else {//뒤에서부터
				last[0] = back2front(arr, last[0]);
				sw = true;
			}
			
			if(last[1]==-1 || last[0]==-1) break;
		}
	}
	
	static void bookBubbleSort(int[] arr) {
		int k = 0;
		int n = arr.length;
		while(k < n-1) {
			int last = n-1;
			for(int j = n-1; j>k; j--) {
				cnt++;
				if(arr[j-1]>arr[j]) {
					swap_c++;
					swap(arr, j-1, j);
					last = j;
				}
			}
			k = last;
		}
	}
	
	static void bubbleSort(int[] arr) {
		int k = arr.length;
		boolean sw = true; int n = arr.length;
		
		while(k>1) { //k는 마지막 스왑이 발생한 idx: j+1
			int last = 1;
			
			for(int i=1;i<k;i++) {
				cnt++;
				if(arr[i]<arr[i-1]) {
					swap_c++;
					printArr(arr, i-1, true);
					swap(arr, i-1, i);
					last = i;
				}else {
					printArr(arr, i-1, false);
				}
			}
			
			k = last;
		}
		
		System.out.println("실행: "+cnt);
		System.out.println("실행: "+swap_c);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {9,1,3,4,6,7,8};
		
		System.out.println(Arrays.toString(arr)+"\n");
		System.out.println("버블 정렬을 수행합니다.\n");
		
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println("CNT:"+cnt);
		System.out.println("SWAP_C:"+swap_c);
	}
}
