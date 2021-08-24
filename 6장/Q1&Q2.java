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
		
		for(int i=0;i<len-1;i++) {
			for(int j=0;j<len-1;j++) {
				if(arr[j+1]<arr[j]) {
					printArr(arr, j, true);
					swap(arr, j+1, j);
				}else {
					printArr(arr, j, false);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,54,6,1,2,4512,55,6213};
		
		sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
