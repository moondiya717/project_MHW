package day4;

public class For8 {

	public static void main(String[] args) {
		/* a부터 z까지 출력하는 코드를 작성하세요 
		 * 반복횟수 : i는 0부터 i는 26보다 작을때까지(25보다 작거나 같다)
		 * 			i는 1씩 증가
		 * 규칙성 : (char)('a'+i)를 출력
		 * 반복문 종료 후: 없음*/
		
	    /**	
		char ch = 'a';
		System.out.println(ch);
		ch = 'a'+1;
		System.out.println(ch);
		ch='a'+2;
		System.out.println(ch);
		**/
		
		//방법1
		char i;
		for(i=0; i<26; i+=1) {
			System.out.print((char)('a'+i));
		}
		
		System.out.println();    //출력값 나누려고 줄나눔 넣었음
		
		//방법2
		/* 반복횟수 : ch는 'a'부터 ch는 'z'까지 ch는 1씩 증가
		 * 규칙성 : ch를 출력
		 * 반복문 종료 후: 없음*/
		char ch;
		for(ch='a'; ch<='z'; ch+=1) {
			System.out.print(ch + " ");
		}
		
		System.out.println();
		//방법3  => 처음에 만들었던 코드인데, t가 쓸모없지 않나 생각했는데 알파벳나열하는 실행을 하는 횟수를 만들어서 abcde나열하게 해준거임.
		int t;
		char a='a';
		for(t=0;t<26;t+=1) {
		System.out.print(a++); //a++이 아니라 'a'+t했음 됐을거네 맨위 방법1이랑 거의 비슷해
		}
		
		

	
		
		
	}

}
