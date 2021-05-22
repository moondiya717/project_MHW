package day18;

import java.util.ArrayList;

public class ListTest3 {	//오버라이딩못했엉!!! ㅠㅠ

	public static void main(String[] args) {
		/* 리스트에서 indexOf()와 contains 메소드를 잘 활용하려면 해당 클래스에서 equals를 오버라이딩해야한다.
 
		 *  */
		ArrayList<Student> list = new ArrayList<Student>();
		Student std1 = new Student(1,1,1,"홍길동");
		Student std2 = new Student(1,1,1,"홍길동");
		list.add(std1);
		//같은 값을 가지고있지만, equals를 오버라이딩 하지 않으면 다르다고 값을 출력함 => 오버라이딩하면 같다고 인식해줌(hashcode , equals)
		System.out.println("리스트에 학생 정보가 있습니까? " + list.indexOf(std2)); 	//값: -1
		System.out.println("리스트에 학생 정보가 있습니까? " + list.contains(std2)); 	//값: false
		//오버라이딩 후, 값이 같다고 바뀜
		
		
	}
}
class Student{
	int grade;	//접근제한자 생략할겡, 빨리수업해야대서
	int classNum;
	int num;
	String name;
	
	
	//생성자 만듬 using field
	public Student(int grade, int classNum, int num, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
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
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	
}