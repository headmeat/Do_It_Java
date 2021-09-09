package john.john;

import java.util.Arrays;

public class BoyerMoore {
	static void printArr(int pt, int first_idx, String txt, String pat, boolean facts) {
		System.out.print(first_idx+": ");
		for(int i=0;i<txt.length();i++) System.out.print(txt.charAt(i)+" ");
		System.out.println();
		for(int i=0;i<3+(pt)*2+((first_idx>=10)?1:0);i++) System.out.print(" ");
		if(facts) System.out.println("+"); else System.out.println("|");
		for(int i=0;i<3+(first_idx-pat.length()+1)*2+((first_idx>=10)?1:0);i++) System.out.print(" ");
		for(int i=0;i<pat.length();i++) System.out.print(pat.charAt(i)+" ");
		System.out.println();
	}
	
	static int bmMatch(String txt, String pat) {
		int pt;int pp;
		int txtLen = txt.length();
		int patLen = pat.length();
		int[] skip = new int[Character.MAX_VALUE+1];
		
		/*건너뛰기 표 만들기
		Character.MAX_VALUE는 65535(char:2바이트-->2^16-1)
		모든 문자에 대응하기 위해 해당 크기로 배열을 생성.
		그래서 skip[pat.charAt(pt)]가 가능*/
		
		//패턴에 문자가 없어서 현재 pt기준 이후로 patLen만큼, 즉 통째로 옮김.
		for(pt = 0;pt <= Character.MAX_VALUE;pt++) skip[pt] = patLen;
		//마지막에서 틀리면 어차피 3칸 옮겨야 되기 때문에 patLen-1까지만 skip을 변경 (n-k-1)
		for(pt = 0;pt < patLen - 1;pt++) skip[pat.charAt(pt)] = patLen - pt - 1;
		
		//이 시점에서 pt는 patLen - 1이다.
		while(pt<txtLen) {
			pp = patLen - 1;
			int first_idx = pt;
			
			while(txt.charAt(pt) == pat.charAt(pp)) {
				printArr(pt, first_idx, txt, pat, true);
				if(pp == 0) return pt;
				pp--;pt--;
			}
			
			printArr(pt, first_idx, txt, pat, false);
			pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(bmMatch("ZBDBCDEFGHABD", "HABD"));
	}
}
