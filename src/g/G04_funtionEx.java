package g;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

import obj.inheritance.goodcase.Student;

public class G04_funtionEx {
	/*
	 * 
	 * Funtion 인터페이스는 매개변수와 리턴값이 모두 있는 추상 메서드 apply를 가지고 있음.
	 * Function인터페이스는 주로 매개변수로 받은 값을 리턴값으로 매핑하여 사용.
	 * 
	 * 
	 * 인터페이스					메서드
	 * Function<T,R>			R apply(T t)
	 * BiFunction<T,U,R>		R apply(T t, U u)
	 * xxxFuntion<R>			R apply(xxx x)
	 * xxxToxxxFunction			yyy applyAs(yyy)(xxx x)		ex) double applyAsDouble(int x)
	 * ToxxxBiFunction			xxx applyAsxxx(T t, U u)
	 * ToxxxFunction			xxx applyAsxxx(T t )
	 * 
	 */

	static Student[] list = {
			new Student("hongkilldong", 20, "2403251", "ComGong"),
			new Student("lee", 28, "2403252",  "tongGye")
	};
	
	
	public static void main(String[] args) {
		
		System.out.print("학생명 : ");
		printString(t -> t.name);
	System.out.print("정공 : ");
	printString(t -> t.getMajor());
	System.out.print("나이");
	printInt(t->t.age);
	System.out.print("나이 합계 : ");
	printTot(t -> t.age);
	System.out.println("나이 평균 : ");
	printAvg(t -> t.age);
	
	
		
	}
	
	static void printAvg(ToDoubleFunction<Student> f) {
		double sum = 0;
		for (Student s:list) {
			sum += f.applyAsDouble(s);
		}
		System.out.println(sum /list.length);
	}
	
	static void printTot(ToIntFunction<Student> f) {
		int sum = 0;
		for(Student s: list) {
			sum +=f.applyAsInt(s);
		}
		System.out.print(sum);
	}
	
	
	static void printInt(Function<Student,Integer> f) {
		for(Student s: list) {
			System.out.print(f.apply(s)+" ");
		}
	}
	static void printString(Function<Student, String> f) {
		for(Student s : list) {
			System.out.print(f.apply(s)+" ");
			
		}
	}

}
