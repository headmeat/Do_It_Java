package john.john;

public class BFMatch {
	static int plus = 0;
	/*전각 문자 출력용 (+에서 애먹는 중)
	static void printSpace(int n) {
		//짝수일 때
		if(n%2==0) for(int i=0;i<3*(n/2);i++) System.out.print(" ");
		//홀수일 때
		else for(int i=0;i<3*(n/2+1)-1;i++) System.out.print(" ");
	}*/
	
	//브루트-포스법으로 문자열을 검색하는 메서드
	static int bfMatch(String txt, String pat) {
		int pt = 0;//text idx
		int pp = 0;//pattern idx
		int n = txt.length(), p_len = pat.length();
		int start = -1;
		
		while(pt<n && pp<p_len) {
			//원본 문자열 출력 부분(if: 첫 비교인 경우, else: )
			if(pp == 0) {
				System.out.println(pt+" "+txt);
				start = pt;
			}
			else {
				System.out.print("  ");
				System.out.println(txt);
			}
			
			if(txt.charAt(pt)==pat.charAt(pp)) {
				System.out.print("  ");
				for(int i=0;i<pt;i++) System.out.print(" ");
				System.out.println("+");
					
				pt++;pp++;
				
			}else {
				System.out.print("  ");
				for(int i=0;i<pt;i++) System.out.print(" ");
				System.out.println("|");
				
				pt = pt - pp + 1;
				pp = 0;
			}
			
			System.out.print("  ");
			for(int i=0;i<start;i++) System.out.print(" ");
			for(int i=0;i<p_len;i++) System.out.print(pat.charAt(i));
			
			System.out.println();
		}
		//검색 성공
		if(pp==p_len) return pt - pp; //시작 인덱스를 돌려줌
		return -1;
	}
	
	public static void main(String[] args) {
		
		bfMatch("ABABCDEFGHA", "ABC");
		
		//0, 2, 3, 5, 6, 8, 9, 11

		/*
		String s1 = "AB주이지스DEF이지스12";
		String s2 = "이지스";
		
		int idx = s1.indexOf(s2);
		int idx2 = s1.lastIndexOf(s2);
		
		if(idx == -1) {
			System.out.println("텍스트 안에 패턴이 없습니다.");
		}else {
			int len1 = 0;
			
			for(int i=0;i<idx;i++) 
				len1 += s1.substring(i, i+1).getBytes().length;
			len1 += s2.length();
			
			int len2 = 0;
			
			for(int i=0;i<idx2;i++)
				len2 += s1.substring(i, i+1).getBytes().length;
			len2 += s2.length();
			ABCDE
			+++++
			|||||
			System.out.println("텍스트 :"+s1);
			System.out.printf(String.format("패턴: %%%ds\n", len1), s2);
			System.out.println("텍스트 : "+s1);
			System.out.printf(String.format("패턴: %%%ds\n", len2), s2);
		}
		*/
	}
}
