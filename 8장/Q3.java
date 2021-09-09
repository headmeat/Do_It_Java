package john.john;

import java.util.Arrays;

public class Kmp {
	static void printArr(int first_idx, int pt, String txt, String pat, boolean res) {
		//txt 출력
		System.out.print(pt+": ");
		for(int i=0;i<txt.length();i++) System.out.print(txt.charAt(i)+" ");
		System.out.println();
		
		//화살표 출력
		for(int i=0;i<pt*2+3;i++) System.out.print(" ");
		if(res) System.out.println("+");
		else System.out.println("|");
		
		//pat 출력
		for(int i=0;i<first_idx*2+3;i++) System.out.print(" ");
		for(int i=0;i<pat.length();i++) System.out.print(pat.charAt(i)+" ");
		System.out.println();
	}
	
	static int kmpMatch(String txt, String pat) {
		int pt = 1;//idx for txt
		int pp = 0;//idx for pat
		int[] skip = new int[pat.length()+1];//idx를 편하게 계산하기 위한 margin을 두기 위함.
		
		skip[pt] = 0;
		while(pt!=pat.length() && pp!=pat.length()) {
			if(pat.charAt(pt)==pat.charAt(pp)) skip[++pt] = ++pp;
			else if(pp == 0) skip[++pt] = pp;
			else pp = skip[pp];
		}
		
		int first_idx = pt = pp = 0;
		boolean sw = true;
		
		while(pt!=txt.length() && pp!=pat.length()) {
			if(sw == true) first_idx = pt;
			
			boolean res = txt.charAt(pt)==pat.charAt(pp);
			
			printArr(first_idx, pt, txt, pat, res);

			if(res) {
				sw = false;
				pt++;pp++;
			}else if(pp == 0) {
				sw = true;
				pt++;
			}else {
				sw = true;
				pp = skip[pp];
			}
		}
		
		if(pp == pat.length()) return pt - pp;
		return -1;
	}
	
	public static void main(String[] args) {
		String txt = "ABABCDEFGHA";
		String pat = "ABC";
		
		System.out.println("Pattern found at: "+kmpMatch(txt, pat));
	}
}
