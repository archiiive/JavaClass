package i;

import java.util.List;
import java.util.Scanner;

import obj.PersonsDAO;
import obj.PersonsVO;

public class I08_personsMain {

	//String sql1 = "insert into Persons (firstname, lastname, age, city)"
	//	+ "values('jdbcTest','testuser13',24,'Seoul')";
	public static void main(String[] args) {

		
		
		
		//DAO VO 테스트
		PersonsDAO dao = new PersonsDAO();
		
		PersonsVO vo = new PersonsVO();
		Scanner Scan = new Scanner(System.in);
		//데이터 추가
		System.out.println("persons에 데이터 추가");
		System.out.println("성(lastname)입력 : ");
		vo.setLastname(Scan.next());
		System.out.println("이름(firstname)입력 : ");
		vo.setFirstname(Scan.next());
		System.out.println("나이(age) 입력 : ");
		vo.setAge(Scan.nextInt());
		System.out.println("사는도시(city) 입력 : ");
		vo.setCity(Scan.next());
		
		int result = dao.insert(vo);
		if(result != 0) {
			System.out.println("레코드 추가 성공");
		}else {
			System.out.println("레코드 추가 실패");
		}
		
		//전체출력확인
		List<PersonsVO> list = dao.allPersons();
		for( PersonsVO pvo : list) {
			System.out.println(pvo);
		}
		
		System.out.println("특정 id를 가진 persons 출력");
		System.out.println("id를 입력해주세요");
		int ids = Scan.nextInt();
		PersonsVO svo = dao.selectOne(ids);
		System.out.println(svo);
		
		System.out.println("<<수정하기>>");
		System.out.println("특정 id 선택하세요 : ");	
		int id2 = Scan.nextInt();
		PersonsVO uVo = dao.selectOne(id2);
		System.out.println("수정할 성을 입력해주세요 : ("+uVo.getLastname()+") : ");
		String lastName = Scan.next();
		if(!lastName.equals("")) {
			uVo.setLastname(lastName);
		}
		System.out.println("수정할 이름을 입력하세요("+uVo.getFirstname()+") : ");
		String firstName = Scan.next();
		if(!firstName.equals("")) {
			uVo.setFirstname(firstName);
		}
		
		System.out.println("수정할 나이를 입력하세요("+uVo.getAge()+") : ");
		int age = Scan.nextInt();
		if(age !=0 && age >= 0) {
			uVo.setAge(age);
		}
		
		System.out.println("수정할 도시 입력하세요("+uVo.getCity()+") :");
		String city = Scan.next();
		if(!city.equals("")) {
			uVo.setCity(city);
		}
		
		int result1 = dao.updatePersons(uVo);
		if(result1 !=0) {
			System.out.println("수정 성공!!!");
		}else {
			System.out.println("수정 실패!!!");
		}
				
		
		
		
		
		
		
		
		
	
		
		
		
		
	Scan.close();
	}
}
