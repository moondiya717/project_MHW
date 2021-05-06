package day8;

public class Test8_2 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 작성하세요.
		 * a
		 * ab
		 * abc
		 * abcd
		 * abcde
		 *  ...
		 * abcde...xyz
		 * 
		 * 
		 * *
		 * **
		 * ***
		 * **** 예제의 혼합
		 * 별모양 삼각형에서 *이 아니라 알파벳나오는 예제*/
		
		//방법1
		for(char i ='a'; i<='z' ; i+=1) {
			for(char k='a'; k<=i; k+=1) {
				System.out.print(k);
			}
			System.out.println();
		}
		//방법2
		String str= "";
		for(char i='a'; i<='z'; i+=1) {
			str+=i;
			System.out.println(str);
		}
	}

}
