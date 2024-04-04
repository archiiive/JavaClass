package g;
import java.util.function.Predicate;

public class G06_predicateEx {
	/*
	 * predicate 함수적 인터페이스는 매개변수가 있고 , 반환값을 boolean으로 처리.
	 * 추상메드를 tset라는 이름으로가지고 있습니다.
	 * 
	 * 
	 * 인터페이스			추상 메서
	 * Predicate<T>		boolean test(T t)
	 * BiPredicate<T,U>	boolean test(T t , U t)
	 * xxxPredicate 	boolean test(xxx)
	 * 
	 * 
	 */
	static Student[]list= {
			new Student("hong",90,80,"컴"),
			new Student("이순신",95,70,"통"),
		new Student("d",12,34," ")
	};

	public static void main(String[] args) {
	
		double avg =avgEng(t -> t.getMajor().equals("컴공"));        
				System.out.print("컴공과 평균 영어 점수 : "+avg);
	}
	
	private static double avgEng(Predicate<Student> predicate) {
		int count = 0;
		int sum = 0;
		for (Student student :list) {
			//equal 비교
			if(predicate.test(student)) {
				count ++;
				sum += student.getEng();
			}
		}
		return(double)sum/count;
	}
	
	
}
