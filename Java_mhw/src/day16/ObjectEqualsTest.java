package day16;

public class ObjectEqualsTest {

	public static void main(String[] args) {
		String str1 = new String("abcd");
		String str2 = str1;
		System.out.println("두 문자열 주소 비교: " + (str1 == str2));
		
		System.out.println("str2 = new String(\"abcd\")");
		str2 = new String("abcd");
		System.out.println("두 문자열 주소 비교: " + (str1 == str2));
		System.out.println("두 문자열 비교: " + str1.equals(str2));	//객체.equals() 로 호출가능 how come?상속받았기때문
	
		Num n1 = new Num();	//기본생성자를 이용해서 만들더라도 
		Num n2 = new Num();	//new를 통해 만들어진 객체들은 모두 주소가 다 다르다. => n1, n2는 주소가 다름을 알 수 있음
		System.out.println("n1과 n2 주소 비교: " + (n1 == n2));
		
		System.out.println("n1과 n2가 같다: " + n1.equals(n2));
		n2.setNum(10);
		System.out.println("n1과 n2가 같다: " + n1.equals(n2));
		
		
		n1.equals(n2);
		n1.equals("abc");
		//매개변수의 다형성 => 여러클래스의 객체들이 매개변수로 다 올 수 있음. 종류가 다른데도 올 수 있음
	}

}

class Num{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	/*	//주소를 비교하려는게 아니라, 실제 값을 비교하려는 것이기때문에 밑에 이렇게 equals를 이용해서 실제 값 비교
	@Override							//매개변수 클래스가 Object로 조상이 왔음
	public boolean equals(Object obj) {	//매개변수로 Num클래스 뿐만아니라 다른 클래스의 객체도 올 수 있다. 예) n1.equals(n2);/n1.equals("abc");
		if(obj == null) {
			return false;
		}
		//매개변수 obj를 Num클래스의 객체로 타입변환이 가능하지 않다면 false를 리턴: 다른 클래스의 객체와 비교할 필요가 없어서
		if(!(obj instanceof Num)) {	//instanceof => 타입변환가능여부를 나타내는 코드
			return false;
		}
		//매개변수의 num와 내 num가 같은지를 비교
		Num tmp = (Num)obj;
		if(num==tmp.num) {
			return true;
		}
		return false;
	}
	*/

	@Override
	public int hashCode() {
		final int prime = 31;	//2n제곱과 가장 가까운 소수 중 적당한 수 하나가 31
		int result = 1;
		result = prime * result + num;	
		return result;
	
	/*
	 *  public int hashCode() {
		return num/10;				//10개씩 그룹화시킨다 => 이런식으로 hashCode로 분류를 해줄 수도 있음. 
	}								//상황에따라 코드를 hashCode를 만들어줄 수 있음
	*/
	}

	@Override
	public boolean equals(Object obj) {
		//주소가 같으면 같은 값을 공유하기 때문에 무조건 true
		if (this == obj)	//매개변수obj주소랑 내this 주소가 같음	//obj=>매개변수,참조변수
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Num other = (Num) obj;
		if (num != other.num)			//일반변수비교
			return false;
		return true;
	}
}
//일반변수(위) 와 참조변수(아래)를 비교하기위한 예시 
class Test{
	Name name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (name == null) {				//참조변수 비교(좀더복잡)
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))	//값이 아니라 주소를 비교중. why? Name클래스의 equals를 안만들었기때문=> Name클래스도 만들어야 돼
			return false;
		return true;
	}
}

class Name{
	String name;
}
