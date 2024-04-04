package g;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

public class G05_operator {
/*
 * operator는function과 마찬가지로 매개변수와 리턴값 모두 존재.
 * function하우ㅣ 인터페이스로 보통 매개변수값을 연산하고 그 결과를리턴하는 경우 사용
 * 
 * 
 * 		인터페이스 			추상메서드
 * 		BinaryOperator<T>		T apply(T t1, T t2)
 * 		UnaryOperator<T>		T apply (T t)
 * 		xxxBinaryOperator		xxx applyAsxxx(xxx,xxx)
 * 		xxxUnaryOperator		xxx applyASxxx(xxx)
 * 
 * 
 * 
 * 
 */
	
	static Student[]list= {
			new Student("hong",90,80,"컴"),
			new Student("이순신",95,70,"통"),
		new Student("d",12,34," ")
	};
	public static void main(String[] args) {
		
		System.out.println("최대 수학점수 : ");
		int max = maxOrMinMath((a,b) ->{
			if(a>=b)return a;
			else return b;
		});
		System.out.print(max);
		
	System.out.print("최소 수학 점수  :");
	System.out.print(maxOrMinMath((a,b)->(a<=b?a:b)));
	
	System.out.print("최대 평균 점수");
	System.out.println(maxOrMinAvg((a,b)->(a>=b ? a :b)));
	
	System.out.print("최소 평균 점수");
	System.out.println(maxOrMinAvg((a,b)->(a<=b ? a :b)));
	}
	
	private static int maxOrMinMath(IntBinaryOperator op) {
		int result = list[0].getMath();
		for(Student s : list) {
			result = op.applyAsInt(result, s.getMath());
		};
		return result;
	}
	
	private static double maxOrMinAvg(DoubleBinaryOperator op) {
		double result = (list[0].getMath() + list[0].getEng()) /2.0;
		for(Student s :list) {
			result =op.applyAsDouble(result, (s.getMath()+s.getEng()/2.0));
		}
		return result;
	}
	
	
}
class Student{
	private String name;
	private int eng;
	private	int math;
	private String major;
	
	
	public Student(String name, int eng, int math, String major) {
		super();
		this.name = name;
		this.eng = eng;
		this.math = math;
		this.major = major;

		 
	
	}


	public String getName() {
		return name;
	}


	public int getEng() {
		return eng;
	}


	public int getMath() {
		return math;
	}


	public String getMajor() {
		return major;
	}
	
	
	
	   
}
