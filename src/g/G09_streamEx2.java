package g;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class G09_streamEx2 {
	/*
	 * Strea은 basestream 인터페이스를 최상위로 stream
	 * intstream longstream doublestream 을 가지고 있다.
	 * 각 자료타입에 따라서 streamm을 구분하여 사용할 수 있음.
	 * 
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println("Arrays.stream() IntStrean 생성하기");
		IntStream intstream1 = Arrays.stream(arr);
		intstream1.forEach(s-> System.out.print(s+"\t"));
		System.out.println();
		
		System.out.println("IntStream.of()로 IntStream 만들"); //끝값 포함x
		IntStream intstream2 = IntStream.of(arr);
		intstream2.forEach(s -> System.out.print(s + "\t"));
		System.out.println();
		
		System.out.println("IntStream.range(1,6) IntStream 생성");
		IntStream intstream3 = IntStream.range(1, 6);
		intstream3.forEach(s -> System.out.print(s+"\t"));
		System.out.println();
		
		
		//stream 생성하기'i
		System.out.println("int형 난수 스트림");
		IntStream isr = new Random().ints(3);	//ints(3)은 3개의 정수 난수 ㅅㅇ성
		isr.forEach(s-> System.out.print(s+" "));
		System.out.println();
		
		isr = new Random().ints(10,0,3);
		isr.forEach(s -> System.out.print(s+" "));
		
		System.out.println("long type Stream");
		LongStream lsr = new Random().longs(3,0,10);
		lsr.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		System.out.println("Double type Stream");
		DoubleStream dsr = new Random().doubles(3);
		dsr.forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		//문자열을 Stream으로 처리...chars()메서드의 사용
		String str = "자바 세상을 만들자";
		//String 객체생성
		isr = str.chars();//why char은 정숙계산이 가능!!!!
		
		isr.forEach(s -> System.out.print((char)s));
		
		
		
		
		
		
		
		
		
	}

}
