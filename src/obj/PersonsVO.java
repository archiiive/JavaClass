package obj;

import java.util.List;

public class PersonsVO {

	
	//VO클래스 or DTO클래스
	// VO클래스 (Value Object Class) - 객체에 값을 저장한 형태.
	//DB나 데이터 저징 용도 변수들의 모 역할
	//
	//DTO (data transfer object class) 데이터 전송처리를 위한 값을 저장하는 형태의 객체
	// 맴버변수 선언  -필드, 속성 데이터를 담아두는 용도
	// private
	private int id;
	private String firstname;
	private String lastname;
	private int age;
	private String city;
	
	public PersonsVO() {}

	//필드 생성자
	
	public PersonsVO(int id, String firstname, String lastname, int age, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString() {
		return "[id : "+id+", lastname : "+lastname +", firstname : "+ firstname + ""+", age : " + age + ", city : "+ city+"]";
	}

	
	
	
}
