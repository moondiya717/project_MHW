package day5;

public class Array4 {

	public static void main(String[] args) {
		/* 1~10 사이의 정수 3개를 랜덤으로 생성하여 배열에 저장한 후
		 * 생성된 값들이 중복되었는지 안되었는지 확인하는 코드를 작성하세요.
		 * 예시 :
		 * 
		 * 랜덤 :  3 8 2 => 중복되지 않음 (출력)
		 * 
		 * 랜덤 : 2 8 8 => 중복 (출력) 
		 * 
		 * */

		
		// min=1, max=10의 정수 3개 만들기 + 배열에 저장하기
		
		int min=1, max=10, r;
		int i, k;
		int []arr=new int[3];
		
		System.out.println("랜덤: ");
		for(i=0;i<3;i+=1) {
			arr[i]=(int)(Math.random()*(max-min+1)+min);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 중복 or 중복되지 않음 을 확인 후 글자 출력
		if(arr[0]==arr[1]||arr[0]==arr[2]||arr[1]==arr[2]) {
				System.out.println("랜덤 숫자가 중복됩니다.");
			}else {
				System.out.println("랜덤 숫자가 중복되지 않습니다.");
			}
		
System.out.println();	
		
		boolean isDuplicated = false;  //변수 선언만 한거임, 랜덤숫자중에서 겹치는게 있는지ture 없는지false 기록을 하려는 것
		for(i=0; i<arr.length-1; i+=1) { //arr.length-1 인이유가 숫자를 비교할 때, 5개의 숫자는 4줄로 대조함.
			for(k=i+1; k<arr.length; k+=1) {					//		01	02	03	04		=> 12345 비교할때 왼쪽과 같이 4줄이 되니까 -1이 된거임. (5-1)= length-1이용
				if(arr[i] ==arr[k]) { //랜덤값=arr[i]번쨰=[k]번째	//		12	13	14			=> 줄의 맨앞 숫자가 0123 으로 1씩 올라가는 규칙이 있음.
					isDuplicated = true;	//false써논걸 true덮어씀//		23	24				=> 줄마다 앞숫자는 같은데 뒷숫자가 바뀜(고정X),(규칙)뒷 숫자가 +1씩
				}		//같은키를 찾은 true						//		34
			}
		}
		if(isDuplicated) {
			System.out.println("중복");
		}else {
			System.out.println("중복 아님");
		}
		
		
		
	
	}

}
