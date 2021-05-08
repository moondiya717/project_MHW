package Practice;

public class test8_2 {

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
		 * 힌트:
		 * *
		 * **
		 * ***
		 * **** 예제의 혼합
		 * 별모양 삼각형에서 *이 아니라 알파벳나오는 예제*/

		
		for(char i='a'; i<='z'; i+=1) {	//26줄
			for(char k='a'; k<=i; k+=1) { //k<=1라고해야 순차적으로 끊김, k<='z' 하면 A-Z까지 쭉된 26줄나옴
				System.out.print(k);
			}System.out.println();
		}
		
		System.out.println();
		
		String str="";
		for(char i='a'; i<='z'; i+=1) {
			str=str+i;
			System.out.println(str);
		}
		
	}

}
