package john.john;

import java.util.Arrays;

public class SelectionSort {
	static void swap(int[] arr, int idx, int idx2) {
		if(idx!=idx2) {
			int tmp = arr[idx];
			arr[idx] = arr[idx2];
			arr[idx2] = tmp;
		}
	}
	
	static void printSel(int[] arr, int min, int ptr) {
		for(int i=0;i<arr.length;i++) {
			if(i==min) {
				System.out.printf("%-4s", "+");
			}else if(i==ptr) {
				System.out.printf("%-4s", "*");
			}
			else {
				System.out.print("    ");
			}
		}
		
		System.out.println();
		
		for(int num:arr) {
			System.out.printf("%-4d", num);
		}
		
		System.out.println();
	}
	
	//단순 선택 정렬
	//{9, 1, 3, 4, 6, 7, 8}
	static void selSort(int[] arr) {
		int n = arr.length;
		int min;
		
		for(int i=0;i<n-1;i++) {
			min = i;
			
			int j;
			
			for(j=i+1;j<n;j++) {
				if(arr[min]>arr[j]) {
					min = j;
				}
			}
			
			printSel(arr, min, i);
			
			swap(arr, i, min);
		}
	}
	
	//단순 삽입 정렬
	static void insSort(int[] arr) {
		int n = arr.length;
		
		for(int i=2;i<n;i++) {
			int j;
			int tmp = arr[0] = arr[i];
			
			for(j = i;arr[j-1]>tmp;j--) {
				arr[j] = arr[j-1];
			}
			
			arr[j] = tmp;
		}
	}
	
	//버블 정렬
	static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			for(int j=n-1;j>i;j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr, j, j-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {Integer.MAX_VALUE,9,5,3,4,65,6,7,1,31};
		insSort(arr);
		
		for(int i=1;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
