package g;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class G02_consumerEx {

	//Consumer<T> - 추상 메서드 void accept(T t) 여기서 티는 매개변수를 의미함
	//BiConsumer<T,U> - 추상메서드 void accept(T t ,U u)
	//xxxConsumer - 각 데이터 타입 따른 Consumer(IntConsumer,LongConsumer,DoubleConsumer)
	//ObjxxxConsumer - 객체와 기본타입의 매개변수를 받는 Consumer...
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Consumer 인터페이스ㅁ
	Consumer<String> c1 = name -> System.out.println("제 이름은 "+name+"입니다.");
	c1.accept("홍킬동");
	
	BiConsumer <String, Integer > c2 = (name, age) -> {
		System.out.print("제이름은 "+name +"이고"+age+"입니다");
	};
	c2.accept("홍길동", 20);
	
	DoubleConsumer c3 = (score)-> System.out.println("제 점수는"+score+"점 입니다");
		c3.accept(98.6);
		
	ObjIntConsumer<String> c4 = (lecture, i)->{
		System.out.println("제"+lecture+"의점수"+i+"점입니Da");
	};
	c4.accept("javaPrograming", 90);
		
		
	}

}
