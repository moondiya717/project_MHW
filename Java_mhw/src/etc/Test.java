package etc;

public class Test {

	public static void main(String[] args) {
		Student st = new Student(1, 1, 1, "홍길동");
		st.studentInfo();

	}

}
class Student{
	private int grade;
	private int classNum;
	private int stNum;
	private String name;
	public int getGrade() {
		return grade;
	}
	
	public void studentInfo() {
		System.out.println("=====학생 정보=====");
		System.out.println("학년 :" + grade);
		System.out.println("반  :" + classNum);
		System.out.println("번호 :" + stNum);
		System.out.println("이름 :" + name);
		System.out.println("=================");

		
	}
	
	public Student(int grade, int classNum, int stNum, String name) {
		this.classNum = classNum;
		this.stNum = stNum;
		this.name = name;
		this.grade = grade;
	}
	
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int stNum) {
		this.stNum = stNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}