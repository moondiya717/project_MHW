package day16;

import java.util.InputMismatchException;

public class TryTest6 {

	public static void main(String[] args) {
		int []arr = new int[5];
		
		//data2
		//arr=null;
		int res = setData2(arr, 0, 10);
		if(res == -1) {
			System.out.println("번지가 잘못");
		}else if(res == 0) {
			System.out.println("배열 생성 안됨");
		}else {
			System.out.println("데이터 저장 성공");
		}
		
		
		
		
		try {
			setData(arr,0,13);
			int num=getData(arr,-1);
			System.out.println(num);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
	/* 기능    : 정수형 배열 index번지에 있는 값을 (data로 설정)?하는 메소드
	 * 			정수형 배열, 번지, 데이터가 주어지면 배열의 번지에 데이터를 저장하는 메소드
	 * 			예) arr 0 1 -> arr라는 배열의 0번지에 1을 저장해라
	 * 매개변수 : 정수형배열, 번지, 데이터 => int arr[], int index, int data
	 * 리턴타입 : 없음
	 * 메소드명 : setData
	 * 
	 * 일반적으로 메소드에서는 예외를 직접처리 하지 않는다. */
	
	public static void setData(int arr[], int index, int data) throws RuntimeException{	//throws 생략가능, RuntimeException이나 아래 예외처리때 쓰는 2개가 같음
		if(arr==null) {
			throw new NullPointerException("배열이 생성되지 않았습니다.");
		}
		if(index <0 || index >=arr.length) {
			throw new ArrayIndexOutOfBoundsException(index + "번지는 "+ arr.length + "개짜리 배열에서 유효하지 않은 배열의 번지입니다.");
		}
		arr[index]=data;
	}
	
	/* 기능    : 정수형 배열에 index 번지에 있는 값을 가져오는 메소드
	 * 매개변수 : 배열, 번지 => int arr[], int index
	 * 리턴타입 : 배열에 있는 값 => 정수 => int
	 * 메소드명 : getData
	 * */
	public static int getData(int arr[], int index) throws NullPointerException, ArrayIndexOutOfBoundsException{
		if(arr==null) {
			throw new NullPointerException("배열이 생성되지 않았습니다.");
		}
		if(index <0 || index >=arr.length) {
			throw new ArrayIndexOutOfBoundsException(index + "번지는 "+ arr.length + "개짜리 배열에서 유효하지 않은 배열의 번지입니다.");
		}
		return arr[index];
	}
	
	
	
	
	
	public static int setData2(int arr[], int index, int data) throws RuntimeException{	
		if(arr==null) {
			return 0;
		}
		if(index <0 || index >=arr.length) {
			return -1;
		}
		arr[index]=data;
		return 1;
	}
	
}
