package john.john;

import java.util.Arrays;

class BubbleSort {
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
	
	static void sort(int[] arr) {
		int len = arr.length;
		int swap_cnt = 0,  cnt = 0;
		
		for(int i=0;i<len-1;i++) {
			int prev = swap_cnt;
			for(int j=i;j<len-1;j++) {
				cnt += 1;
				if(arr[j+1]<arr[j]) {
					swap_cnt += 1;
					printArr(arr, j, true);
					swap(arr, j+1, j);
				}else {
					printArr(arr, j, false);
				}
			}
			
			if(prev==swap_cnt) break;
		}
		
		System.out.println("\n총 "+cnt+"회 실행됐습니다.\nSwap은 총 "+swap_cnt+"회 실행됐습니다.\n");
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,54,6,1,2,55,56};
		
		System.out.println(Arrays.toString(arr));
		System.out.println("버블 정렬을 수행합니다.\n");
		
		sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
