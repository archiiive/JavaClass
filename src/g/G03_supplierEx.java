package g;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class G03_supplierEx {
	//Supplier 함수적 인터페이스 : 매개변수 x 반환값있음 ~ ㅋ.
	/*
	 * 	interface  추사메서드
	 * supplier   	T get()
	 * bollenasupplier 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Supplier<String> s1 = () -> {
			return "홍길동";
		};
		System.out.println(s1.get());
		s1 = ()->"이순";
		System.out.println(s1.get());
		
		IntSupplier s2 = ()-> {
			int num = (int)(Math.random()*6)+1;
			return num;
		};
		System.out.println("주사위값"+s2.getAsInt());
		
		DoubleSupplier s3 = () -> Math.PI;
		System.out.println("원주율 값 : "+s3.getAsDouble());

	}

}
